package com.demo.MaBanque.metier;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.MaBanque.dao.CompteRepository;
import com.demo.MaBanque.dao.OperationRepository;
import com.demo.MaBanque.entities.Compte;
import com.demo.MaBanque.entities.CompteCourant;
import com.demo.MaBanque.entities.Operation;
import com.demo.MaBanque.entities.Retrait;
import com.demo.MaBanque.entities.Versement;

@Service
@Transactional
public class BanqueMetierImpl implements IBanqueMetier {

	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	
	@Override
	public Compte consulterCompte(String codeCpte) {
		Compte cp = compteRepository.findById(codeCpte).orElse(null);
		if(cp == null) throw new RuntimeException("Compte introuvable");
		return cp;
	}

	@Override
	public void verser(String codeCpte, double montant) {
		Compte cp = consulterCompte(codeCpte);
		Versement v = new Versement(new Date(), montant, cp);
		operationRepository.save(v);
		cp.setSolde(cp.getSolde() + montant);
		compteRepository.save(cp);
	}

	@Override
	public void retirer(String codeCpte, double montant) {
		Compte cp = consulterCompte(codeCpte);
		double facilitesCaisse = 0;
		if(cp instanceof CompteCourant)
			facilitesCaisse = ((CompteCourant) cp).getDecouvert();
		if(cp.getSolde() + facilitesCaisse < montant)
			throw new RuntimeException("Solde insuffisant");
		Retrait r = new Retrait(new Date(), montant, cp);
		operationRepository.save(r);
		cp.setSolde(cp.getSolde() - montant);
		compteRepository.save(cp);		
	}

	@Override
	public void virement(String codeCpte1, String codeCpte2, double montant) {
		if(codeCpte1.equals(codeCpte2))
			throw new RuntimeException("Impossible le virement sur le même compte");
		retirer(codeCpte1, montant);
		verser(codeCpte2, montant);		
	}

	@Override
	public Page<Operation> listOperation(String codeCpte, int page, int size) {
		return operationRepository.listOperation(codeCpte, PageRequest.of(page, size));
	}

}

package com.demo.MaBanque.metier;

import org.springframework.data.domain.Page;

import com.demo.MaBanque.entities.Compte;
import com.demo.MaBanque.entities.Operation;

public interface IBanqueMetier {

	public Compte consulterCompte(String codeCpte);
	public void verser(String codeCpte, double montant);
	public void retirer(String codeCpte, double montant);
	public void virement(String codeCpte1, String codeCpte2, double montant);
	public Page<Operation> listOperation(String codeCpte, int page, int size);
}

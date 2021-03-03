package com.demo.MaBanque;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.demo.MaBanque.dao.ClientRepository;
import com.demo.MaBanque.dao.CompteRepository;
import com.demo.MaBanque.dao.OperationRepository;
import com.demo.MaBanque.entities.Client;
import com.demo.MaBanque.entities.Compte;
import com.demo.MaBanque.entities.CompteCourant;
import com.demo.MaBanque.entities.CompteEpargne;
import com.demo.MaBanque.entities.Retrait;
import com.demo.MaBanque.entities.Versement;
import com.demo.MaBanque.metier.IBanqueMetier;

@SpringBootApplication
public class MaBanqueApplication implements CommandLineRunner {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private IBanqueMetier banqueMetier;
	
	public static void main(String[] args) {
		SpringApplication.run(MaBanqueApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		Client c1 = clientRepository.save(new Client("Hassan", "hassan@gmail.com"));
		Client c2 = clientRepository.save(new Client("Rachid", "rachid@gmail.com"));
		
		Compte cp1 = compteRepository.save(new CompteCourant("c1", new Date(), 9000, c1, 6000));
		Compte cp2 = compteRepository.save(new CompteEpargne("c2", new Date(), 6000, c2, 5.5));
		
		operationRepository.save(new Versement(new Date(), 9000, cp1));
		operationRepository.save(new Versement(new Date(), 6000, cp1));
		operationRepository.save(new Versement(new Date(), 2300, cp1));
		operationRepository.save(new Retrait(new Date(), 9000, cp1));
		
		operationRepository.save(new Versement(new Date(), 2300, cp2));
		operationRepository.save(new Versement(new Date(), 400, cp2));
		operationRepository.save(new Versement(new Date(), 2300, cp2));
		operationRepository.save(new Retrait(new Date(), 3000, cp2));
		
		banqueMetier.verser("c1", 111111); */
	}

}

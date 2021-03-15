package com.demo.MaBanque.entities;

import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Groupe  {

	@Id
	@GeneratedValue
	private Long codeGroupe;
	private String nomGroupe;
	
	@ManyToMany(mappedBy = "groupes")
	private Collection<Employe> employes;
	
	
	public Groupe() {
		super();
	}


	public Groupe(Long codeGroupe, String nomGroupe) {
		super();
		this.nomGroupe = nomGroupe;
	}


	public Long getCodeGroupe() {
		return codeGroupe;
	}


	public void setCodeGroupe(Long codeGroupe) {
		this.codeGroupe = codeGroupe;
	}


	public String getNomGroupe() {
		return nomGroupe;
	}


	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}
	
	public Collection<Employe> getEmploye() {
		return employes;
	}
	
	public void setEmploye(Collection<Employe> employes) {
		this.employes = employes;
	}
	
}

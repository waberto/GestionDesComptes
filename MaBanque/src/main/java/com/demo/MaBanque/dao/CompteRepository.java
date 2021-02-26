package com.demo.MaBanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.MaBanque.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String>  {

}

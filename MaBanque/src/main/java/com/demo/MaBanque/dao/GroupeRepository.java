package com.demo.MaBanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.MaBanque.entities.Groupe;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {

}

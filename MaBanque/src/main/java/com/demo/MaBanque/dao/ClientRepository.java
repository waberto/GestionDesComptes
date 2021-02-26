package com.demo.MaBanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.MaBanque.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}

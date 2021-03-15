package com.demo.MaBanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.MaBanque.entities.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

}

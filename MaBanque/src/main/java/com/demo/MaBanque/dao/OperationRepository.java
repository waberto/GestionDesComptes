package com.demo.MaBanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.MaBanque.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {

}

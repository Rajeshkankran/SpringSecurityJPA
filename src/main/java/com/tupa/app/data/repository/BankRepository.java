package com.tupa.app.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.tupa.app.data.model.Bank;


public interface BankRepository extends CrudRepository<Bank, Long>{

}

package com.tupa.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tupa.app.data.Bank;

@Component
@Repository
public interface BankRepository extends CrudRepository<Bank, Long>{

}

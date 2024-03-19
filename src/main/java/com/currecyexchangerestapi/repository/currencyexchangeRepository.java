package com.currecyexchangerestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.currecyexchangerestapi.entity.currencyexchange;

@Repository
public interface currencyexchangeRepository extends JpaRepository<currencyexchange, Long>{
	
	currencyexchange findByCurrencyfromAndCurrencyto(String currencyFrom, String currencyTo);

}

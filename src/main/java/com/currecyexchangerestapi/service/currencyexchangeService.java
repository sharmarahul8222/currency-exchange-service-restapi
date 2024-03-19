package com.currecyexchangerestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.currecyexchangerestapi.entity.currencyexchange;
import com.currecyexchangerestapi.repository.currencyexchangeRepository;

@Service
public class currencyexchangeService {
	
	@Autowired
	private currencyexchangeRepository exchangerepo;
	
	//to check the health of the project
	public String health() {
		return "Project working fine...";
	}
	
	//to save the data 
	public currencyexchange postExchange(currencyexchange currency) {
		return exchangerepo.save(currency);
	}
	
	//to fetch the data
	public List<currencyexchange> getAllData() {
		return exchangerepo.findAll();
	}
	
	//to get from and to currency value
	public currencyexchange getCurrencyExchange(String fromCurrency, String toCurrency) {
		return exchangerepo.findByCurrencyfromAndCurrencyto(fromCurrency, toCurrency);
	}

}

package com.currecyexchangerestapi.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.currecyexchangerestapi.entity.currencyexchange;
import com.currecyexchangerestapi.service.currencyexchangeService;

@RestController
@RequestMapping("/currencyexchange")
public class currencyexchangeController {
	
	@Autowired
	private currencyexchangeService exchangeservice;
	
	@GetMapping("/health")
	public String healthCheck() {
		return exchangeservice.health();
	}
	
	@PostMapping
	public ResponseEntity<currencyexchange> postExchange(@RequestBody currencyexchange currency){
		try {
			exchangeservice.postExchange(currency);
			return new ResponseEntity<>(currency, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> getAllData(){
		List<currencyexchange> all = exchangeservice.getAllData();
		if(all!= null && !all.isEmpty()) {
			return new ResponseEntity<>(all, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}  
	
	@GetMapping("/fromcurrency/{fromCurrency}/tocurrency/{toCurrency}")
	public ResponseEntity<currencyexchange> getExchange(@PathVariable String fromCurrency,
														@PathVariable String toCurrency){
		
		currencyexchange exchangeCurrency= new currencyexchange();
		exchangeCurrency= exchangeservice.getCurrencyExchange(fromCurrency, toCurrency);
		
		if(exchangeCurrency == null) {
			throw new RuntimeException("Currency Not Found!! " + fromCurrency+ " to "+toCurrency);
		}
		return new ResponseEntity<>(exchangeCurrency, HttpStatus.OK);
	} 
	
	
	@GetMapping("/fromcurrency/{fromCurrency}/tocurrency/{toCurrency}/value/{value}")
	public ResponseEntity<currencyexchange> getValueExchange(@PathVariable String fromCurrency,
														@PathVariable String toCurrency,
														@PathVariable double value){
		
		currencyexchange exchangeValue= new currencyexchange();
		exchangeValue= exchangeservice.getCurrencyExchange(fromCurrency, toCurrency);
		
		BigDecimal conversionMultiple= exchangeValue.getConversionMultiple();
		
		BigDecimal totalAmt= new BigDecimal(value);
		
		totalAmt =totalAmt.multiply(conversionMultiple);
		exchangeValue.setTotalAmt(totalAmt);
		
		return new ResponseEntity<>(exchangeValue, HttpStatus.OK);
	} 
	

}

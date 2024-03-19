package com.currecyexchangerestapi.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class currencyexchange {
	
	@Id
	private Long id;
	
	@Column(name="currencyfrom")
	private String currencyfrom;
	
	@Column(name="currencyto")
	private String currencyto;
	
	@Column(name="conversionMultiple")
	private BigDecimal conversionMultiple;
	
	@Column(name="totalAmt")
	private BigDecimal totalAmt;
	
	
	
	public currencyexchange() {
		super();
		// TODO Auto-generated constructor stub
	}
	public currencyexchange(Long id, String currencyfrom, String currencyto, BigDecimal conversionMultiple,
			BigDecimal totalAmt) {
		super();
		this.id = id;
		this.currencyfrom = currencyfrom;
		this.currencyto = currencyto;
		this.conversionMultiple = conversionMultiple;
		this.totalAmt = totalAmt;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCurrencyfrom() {
		return currencyfrom;
	}
	public void setCurrencyfrom(String currencyfrom) {
		this.currencyfrom = currencyfrom;
	}
	public String getCurrencyto() {
		return currencyto;
	}
	public void setCurrencyto(String currencyto) {
		this.currencyto = currencyto;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public BigDecimal getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(BigDecimal totalAmt) {
		this.totalAmt = totalAmt;
	}
	
	

}

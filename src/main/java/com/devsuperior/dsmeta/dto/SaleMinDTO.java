package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;

public class SaleMinDTO  {
	
	private String sellerName;
	private Double amount;
	
	public SaleMinDTO(String name, Double amount) {
		this.sellerName = name;
		this.amount = amount;
	}
	
	
	public SaleMinDTO(Sale entity) {
		sellerName = entity.getSeller().getName();
		amount = entity.getAmount();
	}
	
	

	public String getsellerName() {
		return sellerName;
	}

	public Double getAmount() {
		return amount;
	}
}
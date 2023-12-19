package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;
import com.devsuperior.dsmeta.entities.Sale;

public class SaleWithSellerDTO {
	private Long id;
	private Double amount;
	private LocalDate date;
	private String sellerName;

	public SaleWithSellerDTO(Long id, Double amount, LocalDate date) {
		super();
		this.id = id;
		this.amount = amount;
		this.date = date;

	}

	public SaleWithSellerDTO(Sale entity) {
		this.id = entity.getId();
		this.date = entity.getDate();
		this.amount = entity.getAmount();
		this.sellerName = entity.getSeller().getName();
	}

	public Long getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}

	public Double getAmount() {
		return amount;
	}

	public String getName() {
		return sellerName;
	}

}

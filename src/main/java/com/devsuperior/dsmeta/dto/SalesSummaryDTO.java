package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;

public class SalesSummaryDTO {

    private String sellerName;
    private Double amount;

    public SalesSummaryDTO(Sale entity) {
        sellerName = entity.getSeller().getName();
        amount = entity.getAmount();
    }

    public SalesSummaryDTO(Object[] x) {
        sellerName = (String) x[0];
        amount = (Double) x[1];
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}

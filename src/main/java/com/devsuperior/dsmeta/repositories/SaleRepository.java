package com.devsuperior.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.projections.SummaryProjection;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	
	@Query("SELECT obj " +
            "FROM Sale obj " +
            "WHERE obj.date BETWEEN :minDate AND :maxDate " +
            "AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :sellerName, '%'))")
	Page<Sale> searchByName(LocalDate minDate, LocalDate maxDate, String sellerName, Pageable pageable);
	
	
	@Query(nativeQuery= true,value = "SELECT s.name AS sellerName, SUM(sale.amount) AS totalAmount "
			+ "FROM tb_sales sale "
			+ "JOIN tb_seller s ON sale.seller_id = s.id "
			+ "WHERE sale.date >=:minDate AND sale.date <=:maxDate "
			+ "GROUP BY s.name",
	countQuery ="SELECT s.name AS sellerName, SUM(sale.amount) AS totalAmount "
			+ "FROM tb_sales sale "
			+ "JOIN tb_seller s ON sale.seller_id = s.id "
			+ "WHERE sale.date >=: minDate AND sale.date <=: maxDate "
			+ "GROUP BY s.name")
		Page<SummaryProjection>summary(LocalDate minDate,
		       LocalDate maxDate, 
		       Pageable pageable);
	
}

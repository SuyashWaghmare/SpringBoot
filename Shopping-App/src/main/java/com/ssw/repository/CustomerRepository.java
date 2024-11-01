package com.ssw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssw.model.Customer;
import com.ssw.model.ProductOrder;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<ProductOrder> findByCmob(long cmob);

	

	



	

}

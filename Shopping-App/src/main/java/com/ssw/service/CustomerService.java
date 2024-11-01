package com.ssw.service;

import java.util.List;

import com.ssw.model.Customer;
import com.ssw.model.ProductOrder;

public interface CustomerService {

	String saveCustomer(Customer customer);

	Customer getCustomerById(long cmob);

	String deleteCustomerById(long cmob);

	void sendOrderConfirmationEmail(Customer existingCustomer);

	List<ProductOrder> findByCmob(long cmob);

	}

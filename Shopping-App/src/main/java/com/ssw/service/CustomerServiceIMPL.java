package com.ssw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ssw.model.Customer;
import com.ssw.model.ProductOrder;
import com.ssw.repository.CustomerRepository;

@Service
public class CustomerServiceIMPL implements CustomerService {

	@Autowired
	private CustomerRepository customerrepo;

	@Autowired
	private JavaMailSender sender;

	@Override
	public String saveCustomer(Customer customer) {

		Customer cu = customerrepo.save(customer);
		sendMail(cu);

		return "Mail Send";

	}

	private void sendMail(Customer customer) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(customer.getEmail());
		message.setSubject("Welcome to CJC Shopping Application");
		message.setText("Dear " + customer.getEmail() + ",\n\nThank you for registering on our platform !");
		sender.send(message);

	}

	@Override
	public Customer getCustomerById(long cmob) {

		if (customerrepo.existsById(cmob)) {

			return customerrepo.findById(cmob).get();

		}

		else
			return new Customer();

	}

	@Override
	public String deleteCustomerById(long cmob) {
		if (customerrepo.existsById(cmob)) {

			customerrepo.deleteById(cmob);

			return "User deleted " + cmob;

		} else
			return "User Not Found";

	}

	@Override
	public void sendOrderConfirmationEmail(Customer customer) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(customer.getEmail());
		message.setSubject("Order Confirmation");

		String text = "Dear " + customer.getCname()
				+ ", your order has been placed successfully!\n\nOrder Related Information:\n";

		List<ProductOrder> orderList = customer.getOrderlist();
		for (ProductOrder order : orderList) {
			text = text + "\n";
			text = text + "Order ID: " + order.getOid() + "\n";
			text = text + "Product ID: " + order.getProduct().getPid() + "\n";
			text = text + "Product Name: " + order.getProduct().getPname() + "\n";
			text = text + "Product Name: " + order.getProduct().getPbrand() + "\n";
			text = text + "Product Name: " + order.getProduct().getPrice() + "\n";
			text = text + "Product Category: " + order.getProduct().getPcategory() + "\n";
			text = text + "\n";
		}

		message.setText(text);
		sender.send(message);

	}

	@Override
	public List<ProductOrder> findByCmob(long cmob) {

		return customerrepo.findByCmob(cmob);
	}

}
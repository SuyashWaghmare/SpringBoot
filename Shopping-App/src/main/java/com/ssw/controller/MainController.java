package com.ssw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssw.model.Customer;
import com.ssw.model.Product;
import com.ssw.model.ProductOrder;
import com.ssw.service.CustomerService;
import com.ssw.service.ProductService;

@RestController

public class MainController {

	@Autowired
	private CustomerService customerservice;

	@Autowired
	private ProductService productservice;
	
	

	@PostMapping
	@RequestMapping("/saveCustomer")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer customer) {
		if (customer.getCmob() == 0 || customer.getCname().trim().isEmpty() || customer.getCaddress().trim().isEmpty()
				|| customer.getEmail().trim().isEmpty())

		{
			return new ResponseEntity<String>("Not Acceptable", HttpStatus.NOT_ACCEPTABLE);
		}

		customerservice.saveCustomer(customer);

		return new ResponseEntity<String>("Record Created", HttpStatus.OK);

	}

	@RequestMapping(value = "/getCustomerById/{cmob}", method = RequestMethod.GET)
	public Customer getCustomerById(@PathVariable long cmob) {

		return customerservice.getCustomerById(cmob);

	}

	@RequestMapping(value = "/deleteCustomerById/{cmob}", method = RequestMethod.DELETE)
	public String deleteCustomerById(@PathVariable long cmob) {

		return customerservice.deleteCustomerById(cmob);

	}

	@GetMapping("/getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts() {

		return new ResponseEntity<List<Product>>(productservice.getAllProducts(), HttpStatus.OK);

	}

	@GetMapping
	@RequestMapping("/getProductByCategeory/{pcategory}")
	public ResponseEntity<List<Product>> getProductByCategeory(@PathVariable String pcategory) {
		List<Product> productList = productservice.getProductByCategeory(pcategory);
		if (productList != null && !productList.isEmpty()) {
			return new ResponseEntity<List<Product>>(productList, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<List<Product>>(HttpStatus.BAD_REQUEST);
		}
	}
 
	@GetMapping
	@RequestMapping("/getProductByPid/{pid}")
	public ResponseEntity<Product> getProductByPid(@PathVariable int pid) {
		Product product = productservice.getProductByPid(pid);
		if (product != null) {
			return new ResponseEntity<Product>(product, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/makeOrder/{pid}")
	public ResponseEntity<String> makeOrder(@PathVariable long pid, @RequestBody Customer customer) {

		Customer existingCustomer = customerservice.getCustomerById(customer.getCmob());
		if (existingCustomer == null) {
			return new ResponseEntity<String>("Customer not found.", HttpStatus.NOT_FOUND);
		}

		Product product = productservice.getProductByPid(pid);
		if (product == null) {
			return new ResponseEntity<String>("Product not found.", HttpStatus.NOT_FOUND);
		}

		ProductOrder order = new ProductOrder();
		order.setProduct(product);

		existingCustomer.getOrderlist().add(order);

		customerservice.saveCustomer(existingCustomer);

		customerservice.sendOrderConfirmationEmail(existingCustomer);

		return new ResponseEntity<String>("Order placed successfully.", HttpStatus.OK);
	}

	@GetMapping("/getOrderByCustomer/{cmob}")
	public List<ProductOrder> getOrderByCustomer(@PathVariable long cmob) {
		Customer customer = customerservice.getCustomerById(cmob);
		if (customer == null) {
			System.out.println("Customer not found");
		}
		return customer.getOrderlist();
	}

}

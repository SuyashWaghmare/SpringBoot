package com.ssw.service;

import java.util.List;

import com.ssw.model.Product;

public interface ProductService {

	List<Product> getAllProducts();

	List<Product> getProductByCategeory(String pcategory);

	Product getProductByPid(long pid);

	

}

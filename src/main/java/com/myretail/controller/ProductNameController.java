package com.myretail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.model.ProductName;
import com.myretail.service.ProductService;

@RestController
public class ProductNameController {
	@Autowired
	ProductService productService;

	@ResponseStatus()
	@RequestMapping("/allProducts")
	public List<ProductName> productList() {
		return productService.getProductName();
	}

	@RequestMapping("/product/{id}")
	public ProductName productName(@PathVariable("id") int id) {
		return productService.getProductparticular(id);
	}

}

package com.myretail.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.myretail.model.ProductName;

@Service
public class ProductService {

	List<ProductName> products = Arrays.asList(new ProductName(13860428, "the Big Lebowski (Blu-ray) (Widescreen)"),
			new ProductName(54456119, "the Big Lebowski (yellow-ray) (Widescreen)"),
			new ProductName(13264003, "the Big Lebowski (green-ray) (Widescreen)"),
			new ProductName(12954218, "the Big Lebowski (red-ray) (Widescreen)"));

	public List<ProductName> getProductName() {

		return products;
	}

	public ProductName getProductparticular(int id) {

		List<ProductName> finalProducts = products.stream().filter(e -> e.getId() == id).collect(Collectors.toList());
		return finalProducts.get(0);
	}

}

package com.rohim.springboot2.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rohim.springboot2.models.Product;
import com.rohim.springboot2.models.User;

@Service
public class ProductService {
	
	private static List<Product> products;
	
	public static List<Product> getProducts() {
		if (products == null) {
			List<Product> prods = new ArrayList<Product>();
			prods.add(new Product(1, "iphone", new BigDecimal(1000)));
			prods.add(new Product(2, "iwatch", new BigDecimal(300)));
			prods.add(new Product(3, "airpods", new BigDecimal(500)));
			products = prods;
		}
		
		return products;
	}

	public List<Product> findAll() {
		return getProducts();
	}

	public Product findById(int idFromClient) {
		Product product = products.stream()
				.filter(x -> x.getId() == idFromClient).findFirst().orElse(null);
		return product;
	}

	public void insert(Product product) {
		int maxid = products.stream().map(x -> x.getId()).max(Integer::compare).get();
		product.setId(maxid+1);
		products.add(product);		
	}

	public void update(Product product) {
		Product existingProduct = products.stream()
				.filter(x -> x.getId() == product.getId()).findFirst().get();
		
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
	}
}

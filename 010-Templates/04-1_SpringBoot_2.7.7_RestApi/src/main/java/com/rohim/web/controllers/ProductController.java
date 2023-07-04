package com.rohim.web.controllers;

import com.rohim.web.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

	public static List<Product> products = new ArrayList<Product>();

	static {
		Product product1 = new Product(1, "bike");
		Product product2 = new Product(2, "helmet");
		Product product3 = new Product(3, "seat");
		products.add(product1);
		products.add(product2);
		products.add(product3);
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getAll() {
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getById(@PathVariable String id) {
		Product product = products.stream()
				.filter(stu -> stu.getId() == Integer.parseInt(id)).findFirst().get();
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addNew(@RequestBody Product newProduct) {
		products.add(newProduct);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteById(@PathVariable String id) {
		Product product = products.stream()
				.filter(prd -> prd.getId() == Integer.parseInt(id)).findFirst().get();
		products.remove(product);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}

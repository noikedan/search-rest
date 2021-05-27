package com.example.searchrest.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.searchrest.domains.Product;

@RestController
@RequestMapping("api/product")
public class ProductController {
	private Map<String, Product> products = new HashMap<String, Product>() {
		private static final long serialVersionUID = 1L;
		{
			put("1", new Product("1", "商品A", 2000));
			put("2", new Product("2", "商品B", 3000));
			put("3", new Product("3", "商品C", 4000));
		}
	};

	@GetMapping
	public List<Product> getAll() {
		return new ArrayList<>(products.values());
	}

	@GetMapping("{id}")
	public Product getById(@PathVariable("id") String id) {
		return products.get(id);
	}

	@PostMapping
	public void create(@RequestBody Product product) {
		products.put(product.getId(), product);
	}
}
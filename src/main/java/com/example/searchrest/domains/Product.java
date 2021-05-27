package com.example.searchrest.domains;

import java.util.Date;

import lombok.Data;

@Data
public class Product {
	private String id;
	private String name;
	private int price;

	public Product() {
	}

	public Product(String id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	// Setter・Getterは省略
}
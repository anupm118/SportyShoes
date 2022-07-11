package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAO {

	@Autowired
	ProductRepository repo;
	public Product insertProduct(Product p) {
		return repo.save(p);
	}
		Product updateProduct(Product p) {
		System.out.println("getting id");
		Product product=repo.findById(p.getSNo()).orElse(null);
		System.out.println("setting id");
		product.setProductId(p.getProductId());
		System.out.println("setting name");
		product.setProductName(p.getProductName());
		return repo.save(p);
	}
	public String deleteProduct(int sNo) {
		repo.deleteById(sNo);
		return "deleted" +sNo;
	}
	public List<Product> getAll() {
		return repo.findAll();
	}
	}


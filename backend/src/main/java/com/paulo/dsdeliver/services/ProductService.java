package com.paulo.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paulo.dsdeliver.dto.ProductDTO;
import com.paulo.dsdeliver.entities.Product;
import com.paulo.dsdeliver.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll(){
		List<Product> products = repository.findAllByOrderByNameAsc();
		
		return products.stream().map(p -> new ProductDTO(p)).collect(Collectors.toList());
	}
}

package com.paulo.dsdeliver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulo.dsdeliver.dto.OrderDTO;
import com.paulo.dsdeliver.dto.ProductDTO;
import com.paulo.dsdeliver.services.OrderService;
import com.paulo.dsdeliver.services.ProductService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<OrderDTO>> findAll() {
		List<OrderDTO> orders = service.findAll();
		
		return ResponseEntity.ok().body(orders);
	}
}

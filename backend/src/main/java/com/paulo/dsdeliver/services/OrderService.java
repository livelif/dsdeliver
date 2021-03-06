package com.paulo.dsdeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paulo.dsdeliver.dto.OrderDTO;
import com.paulo.dsdeliver.dto.ProductDTO;
import com.paulo.dsdeliver.entities.Order;
import com.paulo.dsdeliver.entities.OrderStatus;
import com.paulo.dsdeliver.entities.Product;
import com.paulo.dsdeliver.repositories.OrderRepository;
import com.paulo.dsdeliver.repositories.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order> orders = repository.findOrdersWithProducts();
		
		return orders.stream().map(p -> new OrderDTO(p)).collect(Collectors.toList());
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), Instant.now(), 
				OrderStatus.PENDING);
		
		for(ProductDTO p : dto.getProducts()) {
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}
		
		order = repository.save(order);
		
		return new OrderDTO(order);
	}
	
	@Transactional
	public OrderDTO setDelivered(Long id) {
		Order order = repository.getOne(id);
		order.setOrderStatus(OrderStatus.DELIVERED); 
		order = repository.save(order);
		
		return new OrderDTO(order);
	}
}

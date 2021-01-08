package com.paulo.dsdeliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulo.dsdeliver.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

package com.assesment.questionpro.groceryApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assesment.questionpro.groceryApi.Entity.GroceryOrder;

public interface OrderRepository extends JpaRepository<GroceryOrder, Long> {

}

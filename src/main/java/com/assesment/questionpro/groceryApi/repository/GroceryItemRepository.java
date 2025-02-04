package com.assesment.questionpro.groceryApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assesment.questionpro.groceryApi.Entity.GroceryItem;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {

}

package com.assesment.questionpro.groceryApi.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.questionpro.groceryApi.Entity.GroceryItem;
import com.assesment.questionpro.groceryApi.Entity.GroceryOrder;
import com.assesment.questionpro.groceryApi.repository.GroceryItemRepository;
import com.assesment.questionpro.groceryApi.repository.OrderRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	 @Autowired
	    private GroceryItemRepository groceryItemRepository;

	    @Autowired
	    private OrderRepository orderRepository;

	    @GetMapping("/groceries")
	    public List<GroceryItem> getAllGroceryItems() {
	        return groceryItemRepository.findAll();
	    }

	    @PostMapping("/order")
	    public GroceryOrder createOrder(@RequestBody List<Long> itemIds) {
	        List<GroceryItem> items = groceryItemRepository.findAllById(itemIds);
	        GroceryOrder order = new GroceryOrder();
	        order.setItems(items);
	        order.setOrderDate(LocalDateTime.now());
	        return orderRepository.save(order);
	    }

}

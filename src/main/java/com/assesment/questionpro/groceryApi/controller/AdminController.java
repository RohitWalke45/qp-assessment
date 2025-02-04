package com.assesment.questionpro.groceryApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.questionpro.groceryApi.Entity.GroceryItem;
import com.assesment.questionpro.groceryApi.repository.GroceryItemRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {

	    @Autowired
	    private GroceryItemRepository groceryItemRepository;

	    @PostMapping("/grocery")
	    public GroceryItem addGroceryItem(@RequestBody
	    		GroceryItem item) {
	        return groceryItemRepository.save(item);
	    }

	    @GetMapping("/groceries")
	    public List<GroceryItem> getAllGroceryItems() {
	        return groceryItemRepository.findAll();
	    }

	    @DeleteMapping("/grocery/{id}")
	    public void deleteGroceryItem(@PathVariable Long id) {
	        groceryItemRepository.deleteById(id);
	    }

	    @PutMapping("/grocery")
	    public GroceryItem updateGroceryItem(@RequestBody GroceryItem item) {
	        return groceryItemRepository.save(item);
	    }

	    @PutMapping("/grocery/{id}/inventory")
	    public GroceryItem updateInventory(@PathVariable Long id, @RequestParam int inventory) {
	        GroceryItem item = groceryItemRepository.findById(id).orElseThrow();
	        item.setInventory(inventory);
	        return groceryItemRepository.save(item);
	    }

}

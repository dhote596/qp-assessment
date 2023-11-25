package com.qpassessment.demo.controller;

import com.qpassessment.demo.dto.GroceryItemDto;
import com.qpassessment.demo.service.GroceryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grocery-items")
public class GroceryItemController {
    @Autowired
    private GroceryItemService groceryItemService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public List<GroceryItemDto> getAllItems() {
        return groceryItemService.getAllItems();
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public GroceryItemDto addItem(@RequestBody GroceryItemDto groceryItemDto) {
        return groceryItemService.addItem(groceryItemDto);
    }

    @DeleteMapping("/{itemId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void removeItem(@PathVariable Long itemId) {
        groceryItemService.removeItem(itemId);
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public GroceryItemDto updateItem(@RequestBody GroceryItemDto groceryItemDto) {
        return groceryItemService.updateItem(groceryItemDto);
    }

}

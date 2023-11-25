package com.qpassessment.demo.controller;

import com.qpassessment.demo.dto.GroceryItemDto;
import com.qpassessment.demo.dto.OrderDto;
import com.qpassessment.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public OrderDto createOrder(@RequestBody List<GroceryItemDto> groceryItemDtoList) {
        return orderService.createOrder(groceryItemDtoList);
    }

}

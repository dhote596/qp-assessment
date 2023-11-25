package com.qpassessment.demo.service;

import com.qpassessment.demo.Exception.ItemNotInStockException;
import com.qpassessment.demo.dto.GroceryItemDto;
import com.qpassessment.demo.dto.OrderDto;
import com.qpassessment.demo.entity.GroceryItem;
import com.qpassessment.demo.entity.Order;
import com.qpassessment.demo.repository.GroceryItemRepository;
import com.qpassessment.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    public OrderDto createOrder(List<GroceryItemDto> groceryItemDtoList) {
        Order order = new Order();
        checkItemsInInventory(groceryItemDtoList);
        List<GroceryItem> groceryItemList = dtoListToEntityList(groceryItemDtoList);

        order.setItems(groceryItemList);
        Order order1 = orderRepository.saveAndFlush(order);
        return dtoToEntity(order1);
    }

    private OrderDto dtoToEntity(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setItems(order.getItems());
        return orderDto;
    }

    private List<GroceryItem> dtoListToEntityList(List<GroceryItemDto> groceryItemDtoList) {
        List<GroceryItem> groceryItemList = new ArrayList<>();
        for (GroceryItemDto groceryItemDto : groceryItemDtoList) {
            GroceryItem groceryItem = new GroceryItem();
            groceryItem.setName(groceryItemDto.getName());
            groceryItem.setPrice(groceryItemDto.getPrice());
            groceryItem.setQuantity(groceryItemDto.getQuantity());
            groceryItemList.add(groceryItem);
        }
        return groceryItemList;
    }

    private void checkItemsInInventory(List<GroceryItemDto> groceryItemDtoList) {

        for(GroceryItemDto groceryItem : groceryItemDtoList) {
            Optional<GroceryItem> groceryItem1 = groceryItemRepository.findById(groceryItem.getId());
            if (!groceryItem1.isPresent()) {
                throw new ItemNotInStockException("Item Not in Stock");
            }
        }
    }
}

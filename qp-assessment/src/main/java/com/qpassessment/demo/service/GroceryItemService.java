package com.qpassessment.demo.service;

import com.qpassessment.demo.Exception.ItemNotFoundException;
import com.qpassessment.demo.dto.GroceryItemDto;
import com.qpassessment.demo.entity.GroceryItem;
import com.qpassessment.demo.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroceryItemService {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    public List<GroceryItemDto> getAllItems() {

        List<GroceryItem> groceryItemList = groceryItemRepository.findAll();
        return entityListToDtoList(groceryItemList);

    }

    public GroceryItemDto addItem(GroceryItemDto groceryItemDto) {
        GroceryItem groceryItem = groceryItemRepository.save(dtoToEntity(groceryItemDto));
        return entityToDto(groceryItem);
    }

    public void removeItem(Long itemId) {
        Optional<GroceryItem> groceryItem = groceryItemRepository.findById(itemId);
        if (groceryItem.isPresent()) {
            groceryItemRepository.deleteById(itemId);
        }
        throw new ItemNotFoundException("Item not found");

    }

    public GroceryItemDto updateItem(GroceryItemDto groceryItemDto) {
        Optional<GroceryItem> groceryItem = groceryItemRepository.findById(groceryItemDto.getId());
        if(groceryItem.isPresent()) {

            groceryItem.get().setName(groceryItemDto.getName());
            groceryItem.get().setPrice(groceryItemDto.getPrice());
            groceryItem.get().setQuantity(groceryItemDto.getQuantity());
            GroceryItem groceryItem1 = groceryItemRepository.save(groceryItem.get());
            return entityToDto(groceryItem1);
        } else {
            throw new ItemNotFoundException("Item not found");
        }

    }

    private GroceryItem dtoToEntity(GroceryItemDto groceryItemDto) {
        GroceryItem groceryItem = new GroceryItem();
        groceryItem.setName(groceryItemDto.getName());
        groceryItem.setPrice(groceryItemDto.getPrice());
        groceryItem.setQuantity(groceryItemDto.getQuantity());
        return groceryItem;
    }

    private GroceryItemDto entityToDto(GroceryItem groceryItem) {
        GroceryItemDto groceryItemDto = new GroceryItemDto();
        groceryItemDto.setId(groceryItem.getId());
        groceryItemDto.setName(groceryItem.getName());
        groceryItemDto.setPrice(groceryItem.getPrice());
        groceryItemDto.setQuantity(groceryItem.getQuantity());
        return groceryItemDto;
    }

    private List<GroceryItemDto> entityListToDtoList(List<GroceryItem> groceryItemList) {
        List<GroceryItemDto> groceryItemDtoList = new ArrayList<>();
        for (GroceryItem groceryItem : groceryItemList) {
            GroceryItemDto groceryItemDto = new GroceryItemDto();
            groceryItemDto.setId(groceryItem.getId());
            groceryItemDto.setName(groceryItem.getName());
            groceryItemDto.setPrice(groceryItem.getPrice());
            groceryItemDto.setQuantity(groceryItem.getQuantity());
            groceryItemDtoList.add(groceryItemDto);
        }
        return groceryItemDtoList;
    }
}

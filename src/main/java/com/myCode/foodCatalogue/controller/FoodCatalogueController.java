package com.myCode.foodCatalogue.controller;

import com.myCode.foodCatalogue.dto.FoodCataloguePage;
import com.myCode.foodCatalogue.dto.FoodItemDTO;
import com.myCode.foodCatalogue.entity.FoodItem;
import com.myCode.foodCatalogue.service.FoodCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodCatalogue")
@CrossOrigin
public class FoodCatalogueController{
    @Autowired
    FoodCatalogueService foodCatalogueService;

//    @PostMapping("/addFoodItem")
//    public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO){
//        FoodItemDTO foodItemSaved = foodCatalogueService.addFoodItem(foodItemDTO);
//        return new ResponseEntity<>(foodItemSaved, HttpStatus.CREATED);
//    }

    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItem> addFoodItem(@RequestBody FoodItem foodItem){
        FoodItem foodItemSaved = foodCatalogueService.addFoodItem(foodItem);
        return new ResponseEntity<>(foodItemSaved, HttpStatus.CREATED);
    }

    @GetMapping("/fetchRestaurantAndFoodItemsById/{restaurantId}")
    public ResponseEntity<FoodCataloguePage> fetchRestauDetailsWithFoodMenu(@PathVariable Integer restaurantId){
        FoodCataloguePage foodCataloguePage = foodCatalogueService.fetchFoodCataloguePageDetails(restaurantId);
        return new ResponseEntity<>(foodCataloguePage, HttpStatus.OK);

    }
}

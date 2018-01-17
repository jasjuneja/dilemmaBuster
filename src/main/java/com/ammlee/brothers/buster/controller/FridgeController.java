package com.ammlee.brothers.buster.controller;

import com.ammlee.brothers.buster.model.Category;
import com.ammlee.brothers.buster.model.Fridge;
import com.ammlee.brothers.buster.model.Item;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FridgeController {

    @RequestMapping("/getFridge")
    public Fridge getFridge(@RequestParam(value = "id",defaultValue="hello") String id){

        List<Item> test= new ArrayList<>();
        test.add(new Item("Tomatoes",Category.VEGETABLE,"0.5kg"));

        return new Fridge("gagan_123","yo",test);
    }
}

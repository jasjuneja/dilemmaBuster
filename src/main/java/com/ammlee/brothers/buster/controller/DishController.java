package com.ammlee.brothers.buster.controller;

import com.ammlee.brothers.buster.DishRepo;
import com.ammlee.brothers.buster.UserDishHistoryRepo;
import com.ammlee.brothers.buster.UserSpecificationRepo;
import com.ammlee.brothers.buster.model.Dish;
import com.ammlee.brothers.buster.model.UserDishHistory;
import com.ammlee.brothers.buster.model.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping(value = "/dish/")
public class DishController {

    @Autowired
    UserSpecificationRepo userSpecificationRepo;

    @Autowired
    DishRepo dishRepo;

    @Autowired
    UserDishHistoryRepo dishHistoryRepo;

    @RequestMapping(value = "/getDishes/{userId}", method = RequestMethod.GET)
    public Collection<Dish> getDishes(@PathVariable("userId") long userId) {
        UserSpecification userSpecification = userSpecificationRepo.findByUser(userId);

        Dish.DishCategory dishCategory;

        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay < 12) {
            dishCategory = Dish.DishCategory.BREAKFAST;
        } else if (timeOfDay >= 12 && timeOfDay < 16) {
            dishCategory = Dish.DishCategory.LUNCH;
        } else if (timeOfDay >= 16 && timeOfDay < 21) {
            dishCategory = Dish.DishCategory.EVE_SNACK;
        } else {
            dishCategory = Dish.DishCategory.DINNER;
        }

        Collection<UserDishHistory> userDishHistory = dishHistoryRepo.fingByUser(userSpecification.getUserId());
        return dishRepo.getAllDishes(userSpecification, dishCategory, userDishHistory);
    }

    @RequestMapping(value = "/read/{userId}/{dishId}", method = RequestMethod.PUT)
    public void readDish(@PathVariable("userId") long userId, @PathVariable("dishId") String dishId){
        UserDishHistory userDishHistory = new UserDishHistory();
        userDishHistory.setId(userId + dishId);
        userDishHistory.setUserId(userId);
        userDishHistory.setDishId(dishId);
        userDishHistory.setCheckedOn(new Date());
        dishHistoryRepo.insert(userDishHistory);
    }
}

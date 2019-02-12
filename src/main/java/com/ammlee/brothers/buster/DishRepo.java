package com.ammlee.brothers.buster;

import com.ammlee.brothers.buster.model.Dish;
import com.ammlee.brothers.buster.model.UserDishHistory;
import com.ammlee.brothers.buster.model.UserSpecification;

import java.util.Collection;

/**
 * @author thanos on 09/02/19
 */
public interface DishRepo {

    Collection<Dish> getAllDishes(UserSpecification userSpecification, Dish.DishTime dishTime,
                                  Collection<UserDishHistory> userDishHistory);

}

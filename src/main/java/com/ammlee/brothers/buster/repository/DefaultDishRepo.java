package com.ammlee.brothers.buster.repository;

import com.ammlee.brothers.buster.DishRepo;
import com.ammlee.brothers.buster.model.Dish;
import com.ammlee.brothers.buster.model.UserDishHistory;
import com.ammlee.brothers.buster.model.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author thanos on 10/02/19
 */
@Repository
public class DefaultDishRepo implements DishRepo {

    @Autowired
    MongoTemplate mongoTemplate;


    @Override
    public Collection<Dish> getAllDishes(UserSpecification userSpecification, Dish.DishCategory dishCategory, Collection<UserDishHistory> userDishHistory) {
        Query query = new Query();
        Criteria criteria = interPretCriteria(userSpecification, dishCategory, userDishHistory);
        query.addCriteria(criteria);
        return mongoTemplate.find(query, Dish.class);
    }

    private Criteria interPretCriteria(UserSpecification userSpecification, Dish.DishCategory dishCategory,
                                       Collection<UserDishHistory> userDishHistories) {


        Criteria criteria = Criteria.where("dishCategory").is(dishCategory.name())
                .and("id").ne(userDishHistories.stream().map(UserDishHistory::getDishId).collect(Collectors.toList()));

        if(userSpecification != null){
            criteria.and("category").is(userSpecification.getCategory().name());
        }

        return criteria;
    }
}

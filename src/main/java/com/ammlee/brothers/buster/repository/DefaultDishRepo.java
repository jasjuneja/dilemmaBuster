package com.ammlee.brothers.buster.repository;

import com.ammlee.brothers.buster.DishRepo;
import com.ammlee.brothers.buster.model.Dish;
import com.ammlee.brothers.buster.model.UserDishHistory;
import com.ammlee.brothers.buster.model.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.SampleOperation;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
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
    public Collection<Dish> getAllDishes(UserSpecification userSpecification, Dish.DishTime dishTime, Collection<UserDishHistory> userDishHistory) {
        SampleOperation sample = Aggregation.sample(5);
        Criteria criteria = interPretCriteria(userSpecification, dishTime, userDishHistory);

        TypedAggregation<Dish> dishTypedAggregation = Aggregation.newAggregation(Dish.class, Arrays.asList(sample, Aggregation.match(criteria)));

        return mongoTemplate.aggregate(dishTypedAggregation, Dish.class).getMappedResults();
    }

    private Criteria interPretCriteria(UserSpecification userSpecification, Dish.DishTime dishTime,
                                       Collection<UserDishHistory> userDishHistories) {
        Criteria criteria = Criteria.where("dishTime").is(dishTime.name());

        if(userDishHistories != null && userDishHistories.isEmpty()){
            criteria.and("_id").ne(userDishHistories.stream().map(UserDishHistory::getDishId).collect(Collectors.toList()));
        }
        if(userSpecification != null){
            criteria.and("category").is(userSpecification.getCategory().name());
        }

        return criteria;
    }
}

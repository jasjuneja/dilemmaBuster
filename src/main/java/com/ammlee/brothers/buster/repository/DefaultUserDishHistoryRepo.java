package com.ammlee.brothers.buster.repository;

import com.ammlee.brothers.buster.UserDishHistoryRepo;
import com.ammlee.brothers.buster.model.UserDishHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author thanos on 10/02/19
 */
@Repository
public class DefaultUserDishHistoryRepo implements UserDishHistoryRepo {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Collection<UserDishHistory> fingByUser(long userId) {

        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        return mongoTemplate.find(query, UserDishHistory.class);

    }

    @Override
    public void insert(UserDishHistory userDishHistory) {
        mongoTemplate.save(userDishHistory);
    }
}

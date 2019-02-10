package com.ammlee.brothers.buster.repository;

import com.ammlee.brothers.buster.UserRepo;
import com.ammlee.brothers.buster.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


/**
 * @author thanos on 10/02/19
 */
@Repository
public class DefaultUserRepo implements UserRepo {

    @Autowired
    MongoTemplate  mongoTemplate;

    @Override
    public User findById(long userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        return mongoTemplate.findOne(query, User.class);
    }

    @Override
    public void insert(User user) {
        User existingUser = mongoTemplate.findOne(new Query(Criteria.where("userName").is(user.getUserName())), User.class);

        if(existingUser != null){
           new Exception("User Already exists with username:" + user.getUserName());
        }
        mongoTemplate.save(user);
    }
}

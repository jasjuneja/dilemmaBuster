package com.ammlee.brothers.buster.repository;

import com.ammlee.brothers.buster.UserSpecificationRepo;
import com.ammlee.brothers.buster.model.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @author thanos on 09/02/19
 */
@Repository
public class DefaultUserSpecificationRepo implements UserSpecificationRepo {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public UserSpecification findByUser(long userId) {
        Query query = new Query();

        query.addCriteria(Criteria.where("userId").is(userId));

        return mongoTemplate.findOne(query, UserSpecification.class);
    }
}

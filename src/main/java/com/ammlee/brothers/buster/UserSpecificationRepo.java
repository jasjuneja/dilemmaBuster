package com.ammlee.brothers.buster;

import com.ammlee.brothers.buster.model.UserSpecification;

/**
 * @author thanos on 09/02/19
 */
public interface UserSpecificationRepo {

    UserSpecification findByUser(long userId);

    void insert(UserSpecification userSpecification);
}

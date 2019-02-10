package com.ammlee.brothers.buster;

import com.ammlee.brothers.buster.model.User;

/**
 * @author thanos on 09/02/19
 */
public interface UserRepo {
    User findById(long userId);
}

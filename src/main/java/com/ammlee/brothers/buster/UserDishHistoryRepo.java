package com.ammlee.brothers.buster;

import com.ammlee.brothers.buster.model.UserDishHistory;

import java.util.Collection;

/**
 * @author thanos on 09/02/19
 */
public interface UserDishHistoryRepo {
    Collection<UserDishHistory> fingByUser(long userId);
}

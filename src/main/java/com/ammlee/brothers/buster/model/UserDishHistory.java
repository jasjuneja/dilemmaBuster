package com.ammlee.brothers.buster.model;

/**
 * @author thanos on 09/02/19
 */
public class UserDishHistory {
    private long userId;
    private String dishId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }
}

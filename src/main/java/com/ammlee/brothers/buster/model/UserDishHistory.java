package com.ammlee.brothers.buster.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author thanos on 09/02/19
 */
@Document()
public class UserDishHistory {
    @Id
    private String id;

    private long userId;

    private String dishId;

    private Date checkedOn;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Date getCheckedOn() {
        return checkedOn;
    }

    public void setCheckedOn(Date checkedOn) {
        this.checkedOn = checkedOn;
    }
}

package com.ammlee.brothers.buster.model;

import java.util.List;

/**
 * @author jaspreet on 27/01/19
 */
public class UserSpecification {

    private long userId;
    private List<String> allergies;
    private Category category;
    private Location location;
    private List<String> likes;
    private List<String> disLikes;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

    public List<String> getDisLikes() {
        return disLikes;
    }

    public void setDisLikes(List<String> disLikes) {
        this.disLikes = disLikes;
    }
}

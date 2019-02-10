package com.ammlee.brothers.buster.model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Dish {

    @Id
    private String id;
    private String name;
    private String description;
    private String ingredients;
    private String season;
    private String time;
    private String ethicinity;
    private String timeToPlate;
    private String cookingTime;
    private String prepTime;
    private String dishType;
    private String weather;
    private String complementsWith;
    private String tasteType;
    private String category;
    private List<DishCategory> categories;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEthicinity() {
        return ethicinity;
    }

    public void setEthicinity(String ethicinity) {
        this.ethicinity = ethicinity;
    }

    public String getTimeToPlate() {
        return timeToPlate;
    }

    public void setTimeToPlate(String timeToPlate) {
        this.timeToPlate = timeToPlate;
    }

    public String getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(String cookingTime) {
        this.cookingTime = cookingTime;
    }

    public String getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    public String getDishType() {
        return dishType;
    }

    public void setDishType(String dishType) {
        this.dishType = dishType;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getComplementsWith() {
        return complementsWith;
    }

    public void setComplementsWith(String complementsWith) {
        this.complementsWith = complementsWith;
    }

    public String getTasteType() {
        return tasteType;
    }

    public void setTasteType(String tasteType) {
        this.tasteType = tasteType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<DishCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<DishCategory> categories) {
        this.categories = categories;
    }

    public enum DishCategory{
        BREAKFAST,LUNCH, EVE_SNACK,DINNER
    }
}

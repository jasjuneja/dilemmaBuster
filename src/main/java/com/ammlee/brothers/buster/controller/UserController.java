package com.ammlee.brothers.buster.controller;

import com.ammlee.brothers.buster.UserRepo;
import com.ammlee.brothers.buster.UserSpecificationRepo;
import com.ammlee.brothers.buster.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author thanos on 10/02/19
 */
@RestController
@RequestMapping(value = "/user/")
public class UserController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserSpecificationRepo userSpecificationRepo;


    @RequestMapping(value = "/create/", method = RequestMethod.POST)
    public void createUser(@RequestBody UserModel userRequest) {

        User user = new User();
        user.setAddress(userRequest.getAddress());
        user.setId(userRequest.getUserName().hashCode() + userRequest.getEmail().hashCode());
        user.setEmail(userRequest.getEmail());
        user.setUserName(userRequest.getUserName());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setLocation(userRequest.getLocation());

        userRepo.insert(user);

    }

    @RequestMapping(value = "/userSpec/{userId}", method = RequestMethod.POST)
    public void createUserSpec(@PathVariable("userId") long userId, @RequestBody UserSpecificationModel userSpecificationModel) {

        UserSpecification userSpecification = new UserSpecification();
        userSpecification.setUserId(userId);
        userSpecification.setCategory(Category.valueOf(userSpecificationModel.getCategory()));
        userSpecification.setAllergies(userSpecificationModel.getAllergies());
        userSpecification.setLikes(userSpecificationModel.getLikes());
        userSpecification.setDisLikes(userSpecificationModel.getDisLikes());
        userSpecificationRepo.insert(userSpecification);
    }
}

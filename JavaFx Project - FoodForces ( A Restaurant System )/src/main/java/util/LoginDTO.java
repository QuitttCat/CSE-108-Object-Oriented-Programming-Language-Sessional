package util;


import DelivarySystem.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class LoginDTO implements Serializable {

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private String userName;
    private String password;
    private boolean status;
    private boolean isCustomer;
    private boolean isManager;

    public boolean isCustomer() {
        return isCustomer;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setCustomer(boolean customer) {
        isCustomer = customer;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }
    private List<Restaurant> restaurantList=new ArrayList<>();
    private List<Food> foodList=new ArrayList<>();

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public void setRestaurantList(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public List<Restaurant> getRestaurantList() {
        return restaurantList;
    }
    private Restaurant restaurant=new Restaurant();

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

}


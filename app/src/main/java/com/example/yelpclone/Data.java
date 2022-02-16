package com.example.yelpclone;

import java.util.ArrayList;

public class Data {
    private static ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();

    public static void addRestaurant(Restaurant r) {
        restaurants.add(r);
    }

    public static ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }
}

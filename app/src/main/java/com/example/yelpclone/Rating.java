package com.example.yelpclone;

import java.io.Serializable;

public class Rating implements Serializable {
    private String name;
    private double rating;

    public Rating(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }
}

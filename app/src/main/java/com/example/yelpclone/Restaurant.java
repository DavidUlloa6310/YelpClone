package com.example.yelpclone;

import java.io.Serializable;
import java.util.ArrayList;

public class Restaurant implements Serializable {
    private int mImageResource;
    private String name;
    private ArrayList<Rating> ratings;

    public Restaurant(int mImageResource, String name) {
        this.mImageResource = mImageResource;
        this.name = name;
        this.ratings = new ArrayList<>();
    }

    public void changeName(String text) {
        this.name = text;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public String getName() {
        return name;
    }

    public void addRating(Rating rating) {
        ratings.add(rating);
    }

    public double getRating() {

        double ratingNum = 0;

        for (Rating rating : ratings) {
            if (rating == null) continue;
            ratingNum += rating.getRating();
        }

        if (ratings.size() != 0) {
            return ratingNum / ratings.size();
        }

        return ratingNum;
    }

    public String getRatingString() {
        return "Rating : " + getRating();
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }
}

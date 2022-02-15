package com.example.yelpclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class RatingsActivity extends AppCompatActivity {

    private TextView restaurantTextView;
    private TextView ratingsTextView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);

        restaurantTextView = findViewById(R.id.restaurantTextView);
        ratingsTextView = findViewById(R.id.ratingsTextView);
        listView = findViewById(R.id.listView);

        Intent intent = getIntent();
        Restaurant restaurant = (Restaurant) getIntent().getSerializableExtra("restaurant");

        restaurantTextView.setText(restaurant.getName());
        String ratingText = "Ratings (" + restaurant.getRating() + "/10)";
        ratingsTextView.setText(ratingText);

        ArrayAdapter<Rating> adapter = new ArrayAdapter<Rating>(RatingsActivity.this, android.R.layout.simple_list_item_1, restaurant.getRatings());

        listView.setAdapter(adapter);
    }
}
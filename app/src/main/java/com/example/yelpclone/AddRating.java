package com.example.yelpclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddRating extends AppCompatActivity {

    private Restaurant restaurant;
    private int position;

    private String ratingName;
    private int rating;

    private TextView restaurantNameTextView;

    private TextView nameTextView;
    private TextView ratingTextView;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_rating);

        restaurant = (Restaurant) getIntent().getSerializableExtra("Restaurant");
        position = getIntent().getIntExtra("position", 0);

        restaurantNameTextView = findViewById(R.id.restrauntNameTextView);
        restaurantNameTextView.setText(restaurant.getName());

        nameTextView = findViewById(R.id.nameTextView);
        ratingTextView = findViewById(R.id.ratingTextView);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                restaurant.addRating(new Rating(nameTextView.getText().toString(), Double.parseDouble(ratingTextView.getText().toString())));

                startActivity(intent);
            }
        });
    }
}
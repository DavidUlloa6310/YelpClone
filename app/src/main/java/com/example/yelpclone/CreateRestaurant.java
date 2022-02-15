package com.example.yelpclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class CreateRestaurant extends AppCompatActivity {

    private TextView restrauntName;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_restaurant);
        restrauntName = findViewById(R.id.restrauntNameTextView);
        button = findViewById(R.id.createRestrauntButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("restaurantName", restrauntName.getText().toString());
                intent.putExtra("addRating", false);
                startActivity(intent);
            }
        });
    }
}
package com.example.yelpclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button newRestaurantButton;

    private TextView infoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Yelp!");

        newRestaurantButton = findViewById(R.id.newRestaurantButton);

        buildRecyclerView();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Intent intent = getIntent();
        String action = getIntent().getAction();

        System.out.println(action);

        if (action.equals("Add Rating")) {
            int position = getIntent().getIntExtra("position", 0);
            Restaurant restaurant = (Restaurant) getIntent().getSerializableExtra("restaurant");

            if (restaurant != null) {
                Data.getRestaurants().set(position, restaurant);
                mAdapter.notifyItemChanged(position);
            }
        } else if (action.equals("Add Restaurant")) {
            Restaurant restaurant = new Restaurant(R.drawable.ic_food, intent.getStringExtra("restaurantName"));
            addRestaurant(restaurant);
        }

        intent.setAction("");
    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(Data.getRestaurants());

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Restaurant restaurant = Data.getRestaurants().get(position);
                Intent intent = new Intent(getApplicationContext(), RatingsActivity.class);
                intent.putExtra("restaurant", restaurant);
                startActivity(intent);
            }

            @Override
            public void onCommentClick(int position) {
                Intent intent = new Intent(getApplicationContext(), AddRating.class);
                intent.putExtra("restaurant", mAdapter.getRestaurantList().get(position));
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }

    public void goToRestaurantActivity(View view) {
        Intent intent = new Intent(this, CreateRestaurant.class);
        startActivity(intent);
    }

    public void addRestaurant(Restaurant restaurant) {
        Data.getRestaurants().add(restaurant);
        mAdapter.notifyItemInserted(Data.getRestaurants().size() - 1);
    }
}
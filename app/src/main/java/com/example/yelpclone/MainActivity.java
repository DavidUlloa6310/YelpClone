package com.example.yelpclone;

import androidx.appcompat.app.AppCompatActivity;
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
    private ArrayList<Restaurant> restaurantArrayList;

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private TextView infoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Yelp!");

        buildRecyclerView();

        restaurantArrayList = mAdapter.getRestaurantList();

        createExampleList();
    }

    @Override
    protected void onResume(){
        super.onResume();
        int position = getIntent().getIntExtra("position", 0);
        Restaurant restaurant = (Restaurant) getIntent().getSerializableExtra("restaurant");

        if (restaurant != null) {
            restaurantArrayList.set(position, restaurant);
            mAdapter.notifyItemChanged(position);
        }
    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(new ArrayList<Restaurant>());

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

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

    public void createExampleList() {
        restaurantArrayList.add(new Restaurant(R.drawable.ic_food, "Test"));
    }
}
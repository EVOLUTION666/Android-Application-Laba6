package com.example.laba6.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.laba6.DBHelper;
import com.example.laba6.Model;
import com.example.laba6.R;
import com.example.laba6.adapters.MainAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnCart;
    private Button btnAdmin;
    private Button addToCart;
    private RecyclerView recyclerView;
    DBHelper dbHelper = new DBHelper(this);
    List<Model>listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


////        db.addProduct(new Model("Orange", "Ginger orange", 5, 20));
////        db.addProduct(new Model("Potato","Red Potato", 15,25));
//        dbHelper.addProduct(new Model("Cucumber", "Green cucumber", 1, 3));
//        dbHelper.addProduct(new Model("Tomato","Red tomato", 30,25));

        listView = dbHelper.getAllProducts();

        recyclerView = (RecyclerView) findViewById(R.id.MainAdapter);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        MainAdapter mainAdapter = new MainAdapter(MainActivity.this, listView);
        recyclerView.setAdapter(mainAdapter);

        addListenerOnButton();
    }

    public void addListenerOnButton() {

        btnCart = (Button) findViewById(R.id.goToCart);
        btnAdmin = (Button) findViewById(R.id.goToAdminPanel);
        addToCart = (Button) findViewById(R.id.addToCart);

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdminActivity.class);
                startActivity(intent);
            }
        });


    }


}

package com.example.laba6.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.laba6.DBHelper;
import com.example.laba6.Model;
import com.example.laba6.R;
import com.example.laba6.adapters.MainAdapter;

import java.util.List;

public class CartActivity extends AppCompatActivity {

    private List<Model> mCartList;
    private MainAdapter mainAdapter;

    private DBHelper dbHelper = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);



    }


}

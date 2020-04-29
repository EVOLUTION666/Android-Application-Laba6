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
import com.example.laba6.adapters.SecondAdapter;

import java.util.List;

public class AdminActivity extends AppCompatActivity {
    List<Model> listView;
    private RecyclerView recyclerView2;
    DBHelper db = new DBHelper(this);
    Button addProdButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        listView = db.getAllProducts();

        recyclerView2 = (RecyclerView)findViewById(R.id.SecondAdapter);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        SecondAdapter secondAdapter = new SecondAdapter(AdminActivity.this, listView);
        recyclerView2.setAdapter(secondAdapter);

        addListenerOnButton();



    }

    public void addListenerOnButton() {

        addProdButton = (Button) findViewById(R.id.addProdBtn);

        addProdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, AddProductActivity.class);
                startActivity(intent);
            }
        });

    }


}

package com.example.laba6.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.laba6.DBHelper;
import com.example.laba6.Model;
import com.example.laba6.R;

public class AddProductActivity extends AppCompatActivity {
    private Button addNewProduct;
    private EditText name, price, description, count;
    private DBHelper db = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_product);
        addNewProduct = (Button) findViewById(R.id.addNewProduct);
        count = (EditText) findViewById(R.id.productCount);
        description = (EditText) findViewById(R.id.productDescription);
        price = (EditText) findViewById(R.id.productPrice);
        name = (EditText) findViewById(R.id.productName);
        addNewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameofProduct = name.getText().toString();
                String discofProduct = description.getText().toString();
                int countofProduct = Integer.parseInt(count.getText().toString());
                int priceofProduct = Integer.parseInt(price.getText().toString());
                db.addProduct(new Model(nameofProduct, discofProduct, countofProduct, priceofProduct));
                Intent intent = new Intent(AddProductActivity.this, AdminActivity.class);
                startActivity(intent);
            }
        });

    }
}
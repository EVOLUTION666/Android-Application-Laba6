package com.example.laba6.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.laba6.DBHelper;
import com.example.laba6.Model;
import com.example.laba6.R;

public class DeleteAdminActivity extends AppCompatActivity {
    private DBHelper db = new DBHelper(this);
    private EditText name, description, count, price;
    private Model toDelete;
    private Model toUpdate;
    private Button deleteBtn, updateBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_admin);
        name = (EditText) findViewById(R.id.deleteName);
        description = (EditText) findViewById(R.id.deleteDescription);
        count = (EditText) findViewById(R.id.deleteCount);
        price = (EditText) findViewById(R.id.deletePrice);
        Intent intent = getIntent();
        final int id = intent.getIntExtra("id", 0);
        toDelete = db.getProduct(id);
        name.setText(toDelete.getName());
        description.setText(toDelete.getDescription());
        count.setText(String.valueOf(toDelete.getCount()));
        price.setText(String.valueOf(toDelete.getPrice()));

        updateBtn = (Button) findViewById(R.id.updateAdmin);

        toUpdate = db.getProduct(id);
        name.setText(toUpdate.getName());
        description.setText(toUpdate.getDescription());
        count.setText(String.valueOf(toUpdate.getCount()));
        price.setText(String.valueOf(toUpdate.getPrice()));
        deleteBtn = (Button) findViewById(R.id.deleteAdmin);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeleteAdminActivity.this, AdminActivity.class);
                db.deleteProduct(toDelete);
                startActivity(intent);
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DeleteAdminActivity.this, AdminActivity.class);
                db.updateProduct(new Model(id,
                        name.getText().toString(),
                        description.getText().toString(),
                        Integer.parseInt(count.getText().toString()),
                        Integer.parseInt(price.getText().toString())));
                startActivity(intent1);
            }
        });

    }
}
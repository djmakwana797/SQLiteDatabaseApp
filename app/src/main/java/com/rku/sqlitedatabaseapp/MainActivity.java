package com.rku.sqlitedatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText edtEnrollno,edtFirstName,edtLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DatabaseHelper(this);
        edtEnrollno = findViewById(R.id.edtEnrollNo);
        edtFirstName = findViewById(R.id.edtFirstName);
        edtLastName = findViewById(R.id.edtLastName);
    }

    public void addData(View view) {
        boolean isInserted = myDB.insertData(edtEnrollno.getText().toString(),edtFirstName.getText().toString(),edtLastName.getText().toString());
        if(isInserted == true)
            Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Data not Inserted", Toast.LENGTH_SHORT).show();
    }
}
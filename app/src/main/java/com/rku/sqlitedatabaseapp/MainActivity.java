package com.rku.sqlitedatabaseapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
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

    public void viewAll(View view) {
        Cursor res = myDB.getAllData();
        if(res.getCount() == 0){
            //show message
            showMessage("Error","Nothing found");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            buffer.append("Enrollment no. : "+res.getString(1)+"\n");
            buffer.append("Name : "+res.getString(2)+" "+res.getString(3)+"\n");
            buffer.append("Email : "+res.getString(4)+"\n\n");
        }
        //show all data
        showMessage("Data",buffer.toString());
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
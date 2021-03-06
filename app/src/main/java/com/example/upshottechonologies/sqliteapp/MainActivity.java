package com.example.upshottechonologies.sqliteapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mName, mPhone, mId;
    private Button mInsertBtn, fetch, update, delete;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(this);
        mName = findViewById(R.id.etName);
        mPhone = findViewById(R.id.etPhone);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        mId = findViewById(R.id.etId);


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.update(mName.getText().toString(), mPhone.getText().toString(), Integer.parseInt(mId.getText().toString()));
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.delete(Integer.parseInt(mId.getText().toString()));
            }
        });

        mInsertBtn = findViewById(R.id.submit);
        fetch = findViewById(R.id.fetch);
        mInsertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //System.out.println("Name:"+mName.getText().toString()+"\n Phone:"+mPhone.getText().toString());
               Long ret =  dbHelper.insert(mName.getText().toString(), mPhone.getText().toString() );
                //System.out.println("Inserted Value:"+ret);
            }
        });

        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetch.setText(dbHelper.fetch());
            }
        });
    }
}

package com.example.upshottechonologies.sqliteapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedprefActivity extends AppCompatActivity {

    EditText etName, etPhone;
    Button insert, fetch;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final SharedPreferences sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);

        setContentView(R.layout.activity_sharedpref);
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        insert = findViewById(R.id.insert);
        fetch = findViewById(R.id.fetch);
        textView = findViewById(R.id.text);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Name", etName.getText().toString());
                editor.putString("Phone", etPhone.getText().toString());
                editor.apply();
            }
        });
        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = sharedPreferences.getString("Name", null);
                String phone = sharedPreferences.getString("Phone", null);
                if(name!=null && phone!=null)
                textView.setText(name+"\n"+phone);

            }
        });
    }
}

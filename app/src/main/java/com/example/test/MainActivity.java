package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.text.*;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void buttonClicked(View view){
        TextView label= findViewById(R.id.textViewId);
        label.setText("Good Morning");
    }

}
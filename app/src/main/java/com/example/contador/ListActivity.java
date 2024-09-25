package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);


        Button button3 = findViewById(R.id.Button3);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);

        button3.setOnClickListener(
                p -> {
                    Intent intent = new Intent(getApplicationContext(), ListActivity3.class);

                    startActivity(intent);
                }
        );

        button8.setOnClickListener(
                p -> {
                    Intent intent = new Intent(getApplicationContext(), ListActivity8.class);

                    startActivity(intent);
                }
        );

        button9.setOnClickListener(
                p -> {
                    Intent intent = new Intent(getApplicationContext(), ListActivity9.class);

                    startActivity(intent);
                }
        );

    }
}
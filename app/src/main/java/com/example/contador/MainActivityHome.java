package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivityHome extends AppCompatActivity {
    Button buttonList;
    Button buttonHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        buttonList = findViewById(R.id.ListButton);
        buttonHome = findViewById(R.id.ClassButton);

        buttonList.setOnClickListener(
                v -> {
                    Intent intent = new Intent(getApplicationContext(), ListActivity.class);

                    startActivity(intent);
                });

        buttonHome.setOnClickListener(
                v -> {
                    Log.d("HomeButton", "Botão Home pressionado");
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    Log.d("HomeButton", "Iniciando MainActivity");
                });
    }
}
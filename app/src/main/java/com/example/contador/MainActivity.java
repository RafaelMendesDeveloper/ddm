package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView myText = findViewById(R.id.textView);
        Button myButton = findViewById(R.id.button);

        myText.setText("0");
        myButton.setText("RANDOMIZAR");
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                myText.setText(Integer.toString(random.nextInt(100)));
            }
        });
    }
}
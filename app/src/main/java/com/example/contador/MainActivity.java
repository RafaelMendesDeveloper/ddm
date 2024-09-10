package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView myText = findViewById(R.id.textView);
        Button myButton = findViewById(R.id.button);

        EditText inicio = findViewById(R.id.editText1);
        EditText fim = findViewById(R.id.editText2);

        myText.setText("DIGITE UM VALOR");
        myButton.setText("RANDOMIZAR");

        if(inicio.getText() != null && fim.getText() != null){
            myButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Random random = new Random();

                    int inicioNum = Integer.parseInt(inicio.getText().toString());
                    int fimNum = Integer.parseInt(fim.getText().toString());

                    if(inicioNum<fimNum){
                        myText.setText(Integer.toString(random.nextInt(fimNum - inicioNum) + inicioNum));
                    } else {
                        myText.setText("VALOR INVÁLIDO");
                    }
                }
            });
        }
    }
}
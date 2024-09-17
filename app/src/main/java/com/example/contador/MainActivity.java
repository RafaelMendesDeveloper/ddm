package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.wtf("CICLO DE VIDA", "passou pelo OnCreate");

        Button buttonSave = findViewById(R.id.buttonSave);
        Button buttonPage2 = findViewById(R.id.buttonPage2);
        Button buttonPage3 = findViewById(R.id.buttonPage3);

        EditText notas = findViewById(R.id.editText1);

        if(notas.getText() != null){
            buttonSave.setOnClickListener(v -> {

                String noteText = notas.getText().toString();

                String mensagem = noteText;
                notas.setText("");
            });
        }

        buttonPage2.setOnClickListener( v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity2.class);

            String mensagem = notas.getText().toString();

            intent.putExtra("msg", mensagem);
            startActivity(intent);
        });

        buttonPage3.setOnClickListener( v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Ciclo de vida", "passou pelo onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Ciclo de vida", "passou pelo onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Ciclo de vida", "passou pelo onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Ciclo de vida", "passou pelo onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Ciclo de vida", "passou pelo onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Ciclo de vida", "passou pelo onDestroy");
    }
}
package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.contador.database.DataBaseActivity;
import com.example.contador.launcher.LauncherMainActivity;
import com.example.contador.paint.Paint;
import com.example.contador.planetas.MainListagem;
import com.example.contador.taco.TacoActivity;
//import com.example.contador.taco.TacoActivity;

public class MainActivity extends AppCompatActivity{
    private String note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.wtf("CICLO DE VIDA", "passou pelo OnCreate");

        Button buttonSave = findViewById(R.id.buttonSave);
        Button buttonPage2 = findViewById(R.id.buttonPage2);
        Button buttonPage3 = findViewById(R.id.buttonPage3);
        Button buttonPage4 = findViewById(R.id.buttonPage);
        Button buttonPaint = findViewById(R.id.buttonPaint);
        Button buttonPlanet = findViewById(R.id.buttonPlanets);
        Button launcher = findViewById(R.id.buttonForLaunch);
        Button dataBaseButton = findViewById(R.id.databaseButton);
        Button tacoButton = findViewById(R.id.tacoButton);

        EditText notas = findViewById(R.id.editText1);

        if(notas.getText() != null){
            buttonSave.setOnClickListener(v -> {

                note = notas.getText().toString();
                notas.setText("");
            });
        }

        buttonPage2.setOnClickListener( v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity2.class);

            intent.putExtra("msg", note);
            startActivity(intent);
        });

        buttonPage3.setOnClickListener( v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity3.class);

            startActivity(intent);
        });

        buttonPage4.setOnClickListener( v -> {
            Intent intent = new Intent(getApplicationContext(), SensorActivity.class);

            startActivity(intent);
        });

        buttonPaint.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Paint.class);

            startActivity(intent);
        });

        buttonPlanet.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainListagem.class);

            startActivity(intent);
        });

        launcher.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), LauncherMainActivity.class);

            startActivity(intent);
        });

        dataBaseButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), DataBaseActivity.class);

            startActivity(intent);
        });

        tacoButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), TacoActivity.class);

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
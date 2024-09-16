package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSave = findViewById(R.id.buttonSave);
        EditText notas = findViewById(R.id.editText1);
        TextView notaVisualizada = findViewById(R.id.textViewNote);

        if(notas.getText() != null){
            buttonSave.setOnClickListener(v -> {
                String noteText = notas.getText().toString();

                notaVisualizada.setText(noteText);

                notas.setText("");
            });
        }
    }
}
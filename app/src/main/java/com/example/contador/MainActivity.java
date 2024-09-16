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

        Button buttonSave = findViewById(R.id.buttonSave);
        EditText notas = findViewById(R.id.editText1);
        TextView notaVisualizada = findViewById(R.id.textViewNote);

        buttonSave.setText("SALVAR");

        if(notas.getText() != null){
            buttonSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Obtém o texto do EditText
                    String noteText = notas.getText().toString();

                    // Exibe o texto no TextView
                    notaVisualizada.setText(noteText);

                    // Limpa o EditText
                    notas.setText("");
                }
            });
        }
    }
}
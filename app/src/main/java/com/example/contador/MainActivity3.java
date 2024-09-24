package com.example.contador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    SeekBar seekBar;
    ProgressBar progressBar;
    EditText editText;
    TextView textView;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        seekBar = findViewById(R.id.seekBar);
        progressBar = findViewById(R.id.progressBar2);
        editText = findViewById(R.id.editTextTextPersonName);
        textView = findViewById(R.id.textView);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                progressBar.setProgress(progress);
                textView.setText("Progress: " + Integer.toString(progress) + "/100");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text", editText.getText().toString());
        outState.putInt("progress", 69);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState!=null){
         textView2 = findViewById(R.id.textView2);
         textView2.setText(savedInstanceState.getString("text"));
         seekBar.setProgress(savedInstanceState.getInt("progress"));
        }
    }
}
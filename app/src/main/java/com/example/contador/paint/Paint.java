package com.example.contador.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;

import com.example.contador.R;
import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

public class Paint extends AppCompatActivity {
    Button colorButton;
    SimplePaint simplePaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);

        colorButton = findViewById(R.id.paintButton);
        simplePaint = findViewById(R.id.simplePaint);

        colorButton.setOnClickListener(view -> {
            openColorPicker();
        });
    }

    public void openColorPicker(){
        new ColorPickerDialog.Builder(Paint.this)
                .setTitle("ColorPicker Dialog")
                .setPreferenceName("MyColorPickerDialog")
                .setPositiveButton("CONFIRM",
                        new ColorEnvelopeListener() {
                            @Override
                            public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                                setColor(envelope);
                            }
                        })
                .setNegativeButton("CANCEL",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                .attachAlphaSlideBar(true) // the default value is true.
                .attachBrightnessSlideBar(true)  // the default value is true.
                .setBottomSpace(12) // set a bottom space between the last slidebar and buttons.
                .show();
    }

    public void setColor(ColorEnvelope envelope){
        simplePaint.myPaint.setColor(envelope.getColor());
        colorButton.setBackgroundColor(envelope.getColor());
    }
}
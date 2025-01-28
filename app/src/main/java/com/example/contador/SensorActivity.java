package com.example.contador;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SensorActivity extends AppCompatActivity implements SensorEventListener{
    SensorManager mySensorManager;
    Sensor mySensorLight;
    TextView myTvLight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sensor2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        myTvLight = findViewById(R.id.myTvLight);

        mySensorManager = (SensorManager) getSystemService(getApplicationContext().SENSOR_SERVICE);
        mySensorLight = mySensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mySensorManager.registerListener((SensorEventListener) this, mySensorLight, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSensorChanged(SensorEvent event){
        float currentValue = event.values[0];
        myTvLight.setText(Float.toString(currentValue));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
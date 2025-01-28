//package com.example.contador.taco;
//
//import android.os.Bundle;
//import android.database.sqlite.SQLiteDatabase;
//import android.util.Log;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import com.example.contador.R;
//
//public class TacoDataBaseActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_taco_data_base);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//
//        SQLiteDatabase banco = openOrCreateDatabase(getAssets().toString(), getBaseContext().MODE_PRIVATE,null);
//        Log.wtf("OOOOOOOOOI", getAssets().toString());
//    }
//}
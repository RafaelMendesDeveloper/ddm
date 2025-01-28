//package com.example.contador.taco;
//
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.os.Bundle;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.contador.R;
//
//public class TacoActivity extends AppCompatActivity {
//    private RecyclerView recyclerView;
//    private DataBaseHelper dbHelper;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_taco);
//
//        recyclerView = findViewById(R.id.recycler_view);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        dbHelper = new DataBaseHelper(this);
//        dbHelper.copyDatabase();
//
//        SQLiteDatabase database = dbHelper.openDatabase();
//        Cursor cursor = new FoodDAO(database).getAllFoods();
//        FoodAdapter adapter = new FoodAdapter(cursor);
//        recyclerView.setAdapter(adapter);
//    }
//}
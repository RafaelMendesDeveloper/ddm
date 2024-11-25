package com.example.contador.planetas;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contador.R;

public class MainListagem extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_listagem);
        recyclerView = findViewById(R.id.recyclerViewList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PlanetaDao planetaDao = new PlanetaDao();
        PlanetaAdapterRecyclerView padapterRV = new PlanetaAdapterRecyclerView(
                this,
                R.layout.activity_planeta_adapter_recycler_view,
                planetaDao.getAllPlanetas()
        );

        recyclerView.setAdapter(padapterRV);
    }
}

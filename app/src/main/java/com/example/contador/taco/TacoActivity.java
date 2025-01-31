package com.example.contador.taco;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contador.R;

import java.util.ArrayList;
import java.util.List;

public class TacoActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Alimento> listaAlimentos = new ArrayList<>();
    private DataBaseHelper dataBaseHelper;
    private AlimentoAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taco);

        recyclerView = findViewById(R.id.recyclerViewTaco);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dataBaseHelper = new DataBaseHelper(this);

        mostrarDados();

        adapter = new AlimentoAdapter(listaAlimentos);
        recyclerView.setAdapter(adapter);

        EditText editTextFiltro = findViewById(R.id.editTextFiltro);

        editTextFiltro.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filtrarLista(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void filtrarLista(String texto){
        List<Alimento> listaFiltrada = new ArrayList<>();
        for (Alimento alimento : listaAlimentos) {
            if (alimento.getNome().toLowerCase().contains(texto.toLowerCase())) {
                listaFiltrada.add(alimento);
            }
        }
        adapter.filtrarLista(listaFiltrada);
    }

    private void mostrarDados(){
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM alimentos_macros_100g", null);

        if(cursor.moveToFirst()){
            do {
                String nome = cursor.getString(cursor.getColumnIndexOrThrow("nome_alimento"));
                float energia = cursor.getFloat(cursor.getColumnIndexOrThrow("enegiakcal"));

                listaAlimentos.add(new Alimento(nome, energia));
            } while (cursor.moveToNext());
        }
        cursor.close();
    }

}
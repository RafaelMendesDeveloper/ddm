package com.example.contador.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.util.Log;
import android.widget.ListView;

import com.example.contador.R;

import java.util.ArrayList;

public class DataBaseActivity extends AppCompatActivity {
    SQLiteDatabase bd;
    ListView nomeListView;
    ArrayAdapter<String> adapter;
    ArrayList<String> nomesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);

        bd = openOrCreateDatabase("notinhas", MODE_PRIVATE, null);
        bd.execSQL("CREATE TABLE IF NOT EXISTS notas ( id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR)");


        EditText nomes = findViewById(R.id.editTextText);
        Button saveButton = findViewById(R.id.button2);
        nomeListView = findViewById(R.id.nomeListView);

        nomesList = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nomesList);
        nomeListView.setAdapter(adapter);

        carregarNomesDoBanco();

        saveButton.setOnClickListener(v -> {
            String nome = nomes.getText().toString();

            if(!nome.isEmpty()) {
                ContentValues cv = new ContentValues();
                cv.put("nome", nome);

                long id = bd.insert("notas", null, cv);

                Log.d("DataBaseActivity", "Nome inserido: " + nome);
                Log.d("DataBaseActivity", "ID do nome inserido: " + id);

                nomes.setText("");

                carregarNomesDoBanco();
            }
            else{
                Log.d("DataBaseActivity", "Nenhum nome inserido");
            }
        });


    }
    private void carregarNomesDoBanco() {
        nomesList.clear();

        Cursor cursor = bd.rawQuery("SELECT nome FROM notas", null);

        if (cursor != null && cursor.moveToFirst()) {
            int nomeColumnIndex = cursor.getColumnIndex("nome");

            if (nomeColumnIndex != -1) {
                do {
                    String nome = cursor.getString(nomeColumnIndex);

                    nomesList.add(nome);
                } while (cursor.moveToNext());
            } else {
                Log.e("DataBaseActivity", "Coluna 'nome' não encontrada no banco de dados.");
            }
            cursor.close();
        }

        adapter.notifyDataSetChanged();
    }
}

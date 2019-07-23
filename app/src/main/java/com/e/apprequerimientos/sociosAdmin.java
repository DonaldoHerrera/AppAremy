package com.e.apprequerimientos;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class sociosAdmin extends AppCompatActivity {
    private Cursor fila;
    ArrayAdapter<String> arrayAdapter;
    Button btnEliminar;
    ListView simpleList;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socios_admin);

        simpleList = findViewById(R.id.simpleList);
        btnEliminar = findViewById(R.id.btnDelete);

        Intent i = getIntent();
        Bundle bundle = getIntent().getExtras();
        id = i.getIntExtra("id",id);


        DBHelper admin=new DBHelper(this,"instituto",null,1);

        ArrayList<String> lista = new ArrayList<>();

        lista = admin.getReportesSocios();
        arrayAdapter = new ArrayAdapter<String>(sociosAdmin.this,R.layout.listsocios, R.id.report,lista);
        simpleList.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();




    }
}

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
    ArrayList <String> lista, listaname;
    Button btnEliminar;
    ListView simpleList;
    int id;
    int posEli;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socios_admin);

        simpleList = findViewById(R.id.simpleList);
        btnEliminar = findViewById(R.id.btnDelete);



        final DBHelper admin=new DBHelper(this,"instituto",null,1);

        lista = new ArrayList<>();
        listaname = new ArrayList<>();
        lista = admin.getReportesSocios(0);
        for (String i:lista) {
            System.out.println(i);
        }


        arrayAdapter = new ArrayAdapter<String>(sociosAdmin.this,R.layout.listsocios, R.id.report,lista);
        simpleList.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();





    }

    public void eliminar(View view) {
        View item = (View) view.getParent();
        int pos = simpleList.getPositionForView(item);
        String [] datos = lista.get(pos).toString().split(" ");
        posEli = Integer.parseInt(datos[1]);
        lista.remove(pos);
        System.out.println("pos: "+pos);
        dbHelper.delete(posEli);
        arrayAdapter.notifyDataSetChanged();
    }


}

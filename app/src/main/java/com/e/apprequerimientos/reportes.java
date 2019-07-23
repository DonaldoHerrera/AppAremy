package com.e.apprequerimientos;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class reportes extends AppCompatActivity {

    private Cursor fila;
    ArrayAdapter<String> arrayAdapter;
    ListView simpleList;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes);

        simpleList = findViewById(R.id.simpleList);
        Button btn = findViewById(R.id.reportar);

        Intent i = getIntent();
        Bundle bundle = getIntent().getExtras();
        id = i.getIntExtra("id",id);


        DBHelper admin=new DBHelper(this,"instituto",null,1);

        ArrayList<String> lista = new ArrayList<>();

        lista = admin.getReportesByid(id);
        arrayAdapter = new ArrayAdapter<String>(reportes.this,R.layout.listreporte, R.id.report,lista);
        simpleList.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ven=new Intent(reportes.this,Menu.class);
                ven.putExtra("id",id);
                startActivity(ven);
            }
        });




    }
}
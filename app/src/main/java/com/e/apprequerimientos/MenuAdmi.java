package com.e.apprequerimientos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuAdmi extends AppCompatActivity {
    Button btnContacto, btnGastos, btnReporte, btnSocios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admi);

        btnContacto = findViewById(R.id.btnContacto);
        btnGastos = findViewById(R.id.btnGastos);
        btnReporte = findViewById(R.id.btnReporte);
        btnSocios = findViewById(R.id.btnSocios);

        btnReporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ven = new Intent(MenuAdmi.this,reportesAdmin.class);
                startActivity(ven);
            }
        });

        btnGastos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ven = new Intent(MenuAdmi.this,gastosAdmin.class);
                startActivity(ven);
            }
        });

        btnContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ven = new Intent(MenuAdmi.this,contactoAdmin.class);
                startActivity(ven);
            }
        });

        btnSocios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ven = new Intent(MenuAdmi.this,sociosAdmin.class);
                startActivity(ven);
            }
        });

    }
}

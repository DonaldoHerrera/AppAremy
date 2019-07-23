package com.e.apprequerimientos;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Menu extends AppCompatActivity {
    EditText et1, et2;
    Button btn1;
    String reporte, fondos;

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        et1= findViewById(R.id.editText2);
        et2 = findViewById(R.id.editText);
        btn1 = findViewById(R.id.button6);
        Intent i = getIntent();
        Bundle bundle = getIntent().getExtras();
        id = i.getIntExtra("id",id);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper admin = new DBHelper(Menu.this,"instituto",null,1);
                String usuario = et1.getText().toString();
                String fondos = et2.getText().toString();
                System.out.println("fondos: ---"+fondos);
                System.out.println("reportesssss: --"+ usuario);
                admin.insertReportId(usuario,fondos,id);
                Intent ven=new Intent(Menu.this,reportes.class);
                startActivity(ven);
            }
        });

    }
}

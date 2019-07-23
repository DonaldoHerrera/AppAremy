package com.e.apprequerimientos;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    private Cursor fila;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et1= (EditText) findViewById(R.id.etusuario);
        //btn1 = findViewById(R.id.button2);
        et2= (EditText) findViewById(R.id.etcontrasena);

        /*
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ven = new Intent(MainActivity.this,Registro.class);
                startActivity(ven);
            }
        });
        */
    }

    public void ingresar(View v){

        DBHelper admin=new DBHelper(this,"instituto",null,1);
        //admin.updateVersion();
        SQLiteDatabase db=admin.getWritableDatabase();
        String usuario=et1.getText().toString();
        String contrasena=et2.getText().toString();
        fila=db.rawQuery("select usuario,contrasena,codigo from reportesS where usuario='"+usuario+"' and contrasena='"+contrasena+"'",null);

        if (fila.moveToFirst()){
            String usua=fila.getString(0);
            String pass=fila.getString(1);
            int id = fila.getInt(2);
            System.out.println("id: "+id);
            if (usuario.equals(usua)&&contrasena.equals(pass)){
                if(id<201){
                    //admin
                    Intent ven=new Intent(this,MenuAdmi.class);
                    ven.putExtra("id",id);
                    startActivity(ven);
                }else{
                    //user
                    Intent ven=new Intent(this,reportes.class);
                    ven.putExtra("id",id);
                    startActivity(ven);
                }

                et1.setText("");
                et2.setText("");
            }

        }



    }
    public void registro(View v){

    }

    public void salir(View v){
        finish();
        //System.exit(0);
    }
}
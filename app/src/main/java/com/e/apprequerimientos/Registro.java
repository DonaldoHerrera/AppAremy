package com.e.apprequerimientos;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity{

    EditText et1,et2,et3,et4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        et1 = (EditText) findViewById(R.id.etcod);
        et2 = (EditText) findViewById(R.id.etuser);
        et3 = (EditText) findViewById(R.id.etcontra);
        et4 = (EditText) findViewById(R.id.ettel);
    }

    public void registrar(View view){

        DBHelper admin=new DBHelper(this,"instituto",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        String codigo=et1.getText().toString();
        String usuario=et2.getText().toString();
        String contraseña=et3.getText().toString();
        String tel = et4.getText().toString();

        ContentValues values=new ContentValues();
        values.put("codigo",codigo);
        values.put("usuario",usuario);
        values.put("contrasena",contraseña);
        values.put("tel",tel);

        db.insert("reportesS",null,values);
        db.close();
        System.out.println("tel--"+tel);

        Intent ven=new Intent(this,MainActivity.class);
        startActivity(ven);

    }

    public void cancelar(View view){
        finish();

    }
}

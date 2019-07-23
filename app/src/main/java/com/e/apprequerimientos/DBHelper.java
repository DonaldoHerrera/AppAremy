package com.e.apprequerimientos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "reportes";
    private static final String TABLE = "reportesS";
    private static final String TABLE2 = "reportes";
    private static final String KEY_ID = "codigo";
    private static final String KEY_NAME = "usuario";
    private static final String KEY_PASS = "contrasena";
    private static final String KEY_REPORTES = "reportes";
    private static final String KEY_FONDOS = "fondos";
    private static final String KEY_TELEPHONE = "tel";


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table reportesS(codigo integer primary key,usuario text,contrasena text, reportes text, fondos float, tel text)");
        //db.execSQL("insert into reportess values(01,'admin','admin')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("create table reportesS(codigo integer primary key,usuario text,contrasena text, reportes text, fondos float, tel text)");
        db.execSQL("insert into reportesS values(01,'admin','admin')");
    }

    public ArrayList getReportesByid(int indice){
        ArrayList<String> lista = new ArrayList<>();
        String QUERY = "SELECT * FROM "+ TABLE +" where codigo='"+indice+"'";
        String totalData = "";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(QUERY,null);

        if (cursor.moveToFirst()){
            do{
                //String data1 = cursor.getString(cursor.getColumnIndex(KEY_NAME));
                //String data2 = cursor.getString(cursor.getColumnIndex(KEY_PASS));
                //tring data3 = cursor.getString(cursor.getColumnIndex(KEY_ID));
                String data4 = cursor.getString(cursor.getColumnIndex(KEY_REPORTES));
                String data5 = cursor.getString(cursor.getColumnIndex(KEY_FONDOS));
                String data6 = cursor.getString(cursor.getColumnIndex(KEY_TELEPHONE));
                totalData = "Reporte: "+data4+"\n"+"Gasto: "+data5+"\n"+"Telefono: "+data6;
                System.out.println("data: "+data4);
                lista.add(totalData);
                // do what ever you want here
            }while(cursor.moveToNext());
        }

        return lista;
    }
    public ArrayList getReportes(){
        ArrayList<String> lista = new ArrayList<>();
        String QUERY = "SELECT * FROM "+ TABLE;
        String totalData = "";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(QUERY,null);
        int no = 0;
        if (cursor.moveToFirst()){
            do{
                if(no == 0){
                    no++;
                }else{
                    String data1 = cursor.getString(cursor.getColumnIndex(KEY_NAME));
                    //String data2 = cursor.getString(cursor.getColumnIndex(KEY_PASS));
                    //tring data3 = cursor.getString(cursor.getColumnIndex(KEY_ID));
                    String data4 = cursor.getString(cursor.getColumnIndex(KEY_REPORTES));
                    String data5 = cursor.getString(cursor.getColumnIndex(KEY_FONDOS));
                    String data6 = cursor.getString(cursor.getColumnIndex(KEY_TELEPHONE));
                    totalData =
                            "Usuario: "+data1+"\n"+"Reporte: "+data4;
                    System.out.println("data: "+data4);
                    System.out.println("data: "+data5);
                    System.out.println("date: "+data6);
                    lista.add(totalData);
                }

                // do what ever you want here
            }while(cursor.moveToNext());
        }

        return lista;
    }
    public ArrayList getReportesGastos(){
        ArrayList<String> lista = new ArrayList<>();
        String QUERY = "SELECT * FROM "+ TABLE;
        String totalData = "";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(QUERY,null);
        int no = 0;
        if (cursor.moveToFirst()){
            do{
                if(no == 0){
                    no++;
                }else{
                    String data1 = cursor.getString(cursor.getColumnIndex(KEY_NAME));
                    //String data2 = cursor.getString(cursor.getColumnIndex(KEY_PASS));
                    //tring data3 = cursor.getString(cursor.getColumnIndex(KEY_ID));
                    String data4 = cursor.getString(cursor.getColumnIndex(KEY_REPORTES));
                    String data5 = cursor.getString(cursor.getColumnIndex(KEY_FONDOS));
                    String data6 = cursor.getString(cursor.getColumnIndex(KEY_TELEPHONE));
                    totalData =
                            "Usuario: "+data1+"\n"+
                            "Gasto: "+data5;
                    System.out.println("data: "+data4);
                    System.out.println("data: "+data5);
                    System.out.println("date: "+data6);
                    lista.add(totalData);
                }

                // do what ever you want here
            }while(cursor.moveToNext());
        }

        return lista;
    }

    public ArrayList getReportesContacto(){
        ArrayList<String> lista = new ArrayList<>();
        String QUERY = "SELECT * FROM "+ TABLE;
        String totalData = "";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(QUERY,null);
        int no = 0;
        if (cursor.moveToFirst()){
            do{
                if(no == 0){
                    no++;
                }else{
                    String data1 = cursor.getString(cursor.getColumnIndex(KEY_NAME));
                    //String data2 = cursor.getString(cursor.getColumnIndex(KEY_PASS));
                    //tring data3 = cursor.getString(cursor.getColumnIndex(KEY_ID));
                    String data4 = cursor.getString(cursor.getColumnIndex(KEY_REPORTES));
                    String data5 = cursor.getString(cursor.getColumnIndex(KEY_FONDOS));
                    String data6 = cursor.getString(cursor.getColumnIndex(KEY_TELEPHONE));
                    totalData =
                            "Usuario: "+data1+"\n"+
                            "Telefono: "+data6;
                    System.out.println("data: "+data4);
                    System.out.println("data: "+data5);
                    System.out.println("date: "+data6);
                    lista.add(totalData);
                }

                // do what ever you want here
            }while(cursor.moveToNext());
        }

        return lista;
    }
    public ArrayList getReportesSocios(){
        ArrayList<String> lista = new ArrayList<>();
        String QUERY = "SELECT * FROM "+ TABLE;
        String totalData = "";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(QUERY,null);
        int no = 0;
        if (cursor.moveToFirst()){
            do{
                if(no == 0){
                    no++;
                }else{
                    String data1 = cursor.getString(cursor.getColumnIndex(KEY_NAME));
                    //String data2 = cursor.getString(cursor.getColumnIndex(KEY_PASS));
                    //tring data3 = cursor.getString(cursor.getColumnIndex(KEY_ID));
                    String data4 = cursor.getString(cursor.getColumnIndex(KEY_REPORTES));
                    String data5 = cursor.getString(cursor.getColumnIndex(KEY_FONDOS));
                    String data6 = cursor.getString(cursor.getColumnIndex(KEY_TELEPHONE));
                    totalData =
                            "Usuario: "+data1;
                    System.out.println("data: "+data4);
                    System.out.println("data: "+data5);
                    System.out.println("date: "+data6);
                    lista.add(totalData);
                }

                // do what ever you want here
            }while(cursor.moveToNext());
        }

        return lista;
    }

    public void updateVersion() {

        String QUERY = "PRAGMA user_version = 2 ";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(QUERY,null);

    }

    public void insertReportId (String report, String fondos, int id){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cValues = new ContentValues();
        System.out.println("report:  -------------------------------------------"+report);
        System.out.println("fondos: --------------------------------------------"+fondos);
        cValues.put(KEY_REPORTES, report);
        cValues.put(KEY_FONDOS,fondos);

        db.update(TABLE,cValues,KEY_ID+" = "+id,null);
        db.close();
    }

}
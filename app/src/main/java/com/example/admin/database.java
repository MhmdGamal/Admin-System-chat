package com.example.admin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database extends SQLiteOpenHelper {

    public static String dbname="pi";
    public static String tablename="pi_nsb";
    public static String col0="Id";
    public static String col1="UserName";
    public static String col2="Password";
    public static String col3="Project_Name";
    public static String col4="Project_Specialization";
    public static String col5="Project_Budget";

    public database(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+tablename+" ( "+col0+" INTEGER PRIMARY KEY AUTOINCREMENT , "+col1+" TEXT , "+col2+
                " TEXT  ,"+col3+" TEXT ,"+col4+" TEXT ,"+col5+" TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+tablename);
        onCreate(db);
    }

    public String insert(String un,String pas,String projn,String projs,String projb){

        try {

            ContentValues con=new ContentValues();
            con.put(col1,un);
            con.put(col2,pas);
            con.put(col3,projn);
            con.put(col4,projs);
            con.put(col5,projb);
            SQLiteDatabase db=this.getWritableDatabase();
            db.insert(tablename,null,con);
            return "Success";

        }catch (Exception e){
            return "Error";
        }
    }

    public Cursor get_alldata(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM "+tablename,null);
        return c;
    }

    public Cursor get_onedata(String un){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM "+tablename+" WHERE "+col1+" = "+un ,null);
        return c;
    }

    public String delete_all(){
        try {
            SQLiteDatabase db=this.getWritableDatabase();
            db.delete(tablename,null,null);
            return "Success";
        }catch (Exception e){
            return "Error";
        }
    }

    public String delete_one(String  un){
        try {
            SQLiteDatabase db=this.getWritableDatabase();
            db.execSQL("DELETE FROM "+tablename+" WHERE "+col1+" = "+un);
            return "Success";
        }catch (Exception e){
            return "Error";
        }
    }

    public String update(String xun,String un,String pas,String projn,String projs,String projb){
        try {

            SQLiteDatabase db=this.getWritableDatabase();
            db.execSQL("UPDATE "+tablename+" SET "+ col1+" = "+un+", "+col2+" = "+pas+", "+
                    col3+" = "+projn+" , "+col4+" = "+projs+", "+col5+" = "+projb);
            return "Success";
        }catch (Exception e){
            return "Error";
        }
    }


}

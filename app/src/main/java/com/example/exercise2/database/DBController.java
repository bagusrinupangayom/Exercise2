package com.example.exercise2.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DBController extends SQLiteOpenHelper {
    public DBController(Context c){
        super(c,"ProdiTI",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table teman (id integer primary key, nama text, telp text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists teman");
        onCreate(db);
    }

    public void insertData(HashMap<String,String> queryVal){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put("nama",queryVal.get("nama"));
        val.put("telp",queryVal.get("telp"));
        db.insert("teman",null,val);
        db.close();
    }

    public void updateData(HashMap<String,String> queryVal){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put("nama",queryVal.get("nama"));
        val.put("telp",queryVal.get("telp"));
        db.update("teman",val,"id=?",new String[]{queryVal.get("id")});
        db.close();
    }

    public void deleteData(HashMap<String,String> queryVal){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("teman","id=?",new String[]{queryVal.get("id")});
        db.close();
    }

    public ArrayList<HashMap<String,String>> getAllTeman(){
        ArrayList<HashMap<String,String>> listTeman;
        listTeman = new ArrayList<HashMap<String, String>>();
        String selQuery = "select * from teman";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(selQuery,null);

        if(cursor.moveToFirst()){
            do{
                HashMap<String,String> map = new HashMap<>();
                map.put("id",cursor.getString(0));
                map.put("nama", cursor.getString(1));
                map.put("telp", cursor.getString(2));
                listTeman.add(map);
            } while (cursor.moveToNext());
        }
        db.close();
        return listTeman;
    }
}

package com.example.dbdemo.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.dbdemo.model.contact;
import com.example.dbdemo.params.Params;

import java.util.ArrayList;
import java.util.List;

public class MyDbHandler extends SQLiteOpenHelper {
    public MyDbHandler(Context context) {
        super(context, Params.DB_NAME, null, Params.DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE "+Params.TABLE_NAME+"("+Params.KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ Params.KEY_NAME+ " TEXT, " + Params.KEY_PHONE+" TEXT )" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void addcontact(contact contact){
        SQLiteDatabase db= getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Params.KEY_NAME, contact.getName());
        values.put(Params.KEY_PHONE,contact.getPhonenumber());
        db.insert(Params.TABLE_NAME,null,values);
        Log.d("dbharry", "INSERTED");
        db.close();
    }
    public List<contact> getallcontact(){
        List<contact>contactlist= new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();

        Cursor cursor=db.rawQuery("SELECT * FROM "+ Params.TABLE_NAME,null);
        if(cursor.moveToFirst()){
            do{
                contact contact=new contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhonenumber(cursor.getString(2));
                contactlist.add(contact);
            }while (cursor.moveToNext());

        }
        return contactlist;
    }
    public int updatecontact(contact contact){
        SQLiteDatabase db= getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(Params.KEY_NAME,contact.getName());
        values.put(Params.KEY_PHONE,contact.getPhonenumber());
        return db.update(Params.TABLE_NAME,values,Params.KEY_ID + "=?",
                new String[]{String.valueOf(contact.getId())});
    }
    public void deletecontact(contact contact)
    {
        SQLiteDatabase db= getWritableDatabase();
        db.delete(Params.TABLE_NAME, Params.KEY_NAME + "+? ", new String[]{String.valueOf(contact.getId())});
    db.close();
    }
    public int count(){
        String querry= "SELECT * FROM " + Params.TABLE_NAME;
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor= db.rawQuery(querry,null);
        return cursor.getCount();
    }
}

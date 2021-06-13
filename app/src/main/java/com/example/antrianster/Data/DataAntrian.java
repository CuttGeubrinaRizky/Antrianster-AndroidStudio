package com.example.antrianster.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DataAntrian {
    private SQLiteDatabase database;
    private DatabaseHelper dbhelper;

    public DataAntrian(Context context){
        dbhelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        database = dbhelper.getWritableDatabase();
    }

    public void close(){
        dbhelper.close();
    }

    public void addAntrian(Antrian antrian, int idpasien){
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.KEY_ANTRIAN, antrian.getAntrian());
        values.put(DatabaseHelper.KEY_ID_PASIEN, idpasien);

        //inserting row
        database.insert(DatabaseHelper.TABLE_ANTRIAN, null, values);
    }
}

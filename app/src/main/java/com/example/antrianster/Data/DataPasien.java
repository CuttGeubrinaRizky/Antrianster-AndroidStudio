package com.example.antrianster.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DataPasien{
    private SQLiteDatabase database;
    private DatabaseHelper dbhelper;

    public DataPasien(Context context){
        dbhelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        database = dbhelper.getWritableDatabase();
    }

    public void close(){
        dbhelper.close();
    }

    public void addPasien(Pasien pasien){
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.KEY_NAMA, pasien.getNama());
        values.put(DatabaseHelper.KEY_JK, pasien.getJk());
        values.put(DatabaseHelper.KEY_TANGGAL, pasien.get_tgl());
        values.put(DatabaseHelper.KEY_ALAMAT, pasien.getAlamat());
        values.put(DatabaseHelper.KEY_HP, pasien.getNohp());
        values.put(DatabaseHelper.KEY_AGAMA, pasien.getAgama());
        values.put(DatabaseHelper.KEY_NIK, pasien.getNik());

        //inserting row
        database.insert(DatabaseHelper.TABLE_PASIEN, null, values);
    }



/*    public void updateMahasiswa(String nim, String nama, String jurusan, byte[] image) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.KEY_NAMA, nama);
        values.put(DatabaseHelper.KEY_JK, jk);
        values.put(DatabaseHelper.KEY_ALAMAT, alamat);
        values.put(DatabaseHelper.KEY_HP, nohp);
        values.put(DatabaseHelper.KEY_AGAMA, agama);
        values.put(DatabaseHelper.KEY_NIK, nik);

        database.update(DatabaseHelper.TABLE_PASIEN, values, "nim=?", new String[]{nim});
    }

    public void deteleMahasiswa(String nim) {
        database.delete(DatabaseHelper.TABLE_MAHASISWA, "nim=?", new String[]{nim});
    }*/

    public ArrayList<String> getAllNIK() {
        ArrayList<String> listNIK = new ArrayList<String>();

        String allNIK = "SELECT nik FROM " + DatabaseHelper.TABLE_PASIEN;
        Cursor cursor = database.rawQuery(allNIK, null);

        if (cursor.moveToFirst()) {
            do {
                listNIK.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return listNIK;
    }

    public ArrayList<String> getAllNama() {
        ArrayList<String> listNama = new ArrayList<String>();

        String allNama = "SELECT nama FROM " + DatabaseHelper.TABLE_PASIEN;
        Cursor cursor = database.rawQuery(allNama, null);

        if (cursor.moveToFirst()) {
            do {
                listNama.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return listNama;
    }

    public ArrayList<String> getAllJk() {
        ArrayList<String> listJk = new ArrayList<String>();

        String allJk = "SELECT jk FROM " + DatabaseHelper.TABLE_PASIEN;
        Cursor cursor = database.rawQuery(allJk, null);

        if (cursor.moveToFirst()) {
            do {
                listJk.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return listJk;
    }

    public ArrayList<String> getAllAlamat() {
        ArrayList<String> listAlamat = new ArrayList<String>();

        String allAlamat = "SELECT alamat FROM " + DatabaseHelper.TABLE_PASIEN;
        Cursor cursor = database.rawQuery(allAlamat, null);

        if (cursor.moveToFirst()) {
            do {
                listAlamat.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return listAlamat;
    }

    public ArrayList<String> getAllNohp() {
        ArrayList<String> listNohp = new ArrayList<String>();

        String allNohp = "SELECT nohp FROM " + DatabaseHelper.TABLE_PASIEN;
        Cursor cursor = database.rawQuery(allNohp, null);

        if (cursor.moveToFirst()) {
            do {
                listNohp.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return listNohp;
    }

    public ArrayList<String> getAllAgama() {
        ArrayList<String> listAgama = new ArrayList<String>();

        String allAgama = "SELECT agama FROM " + DatabaseHelper.TABLE_PASIEN;
        Cursor cursor = database.rawQuery(allAgama, null);

        if (cursor.moveToFirst()) {
            do {
                listAgama.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return listAgama;
    }

    public List<Pasien> getAllPasien(){
        List<Pasien> listPasien = new ArrayList<Pasien>();

        //select all data mahasiswa
        String allPasien = "SELECT * FROM " + DatabaseHelper.TABLE_PASIEN;
        Cursor cursor = database.rawQuery(allPasien, null);

        //looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Pasien pasien = new Pasien();
                pasien.setId(Integer.parseInt(cursor.getString(0)));
                pasien.setNik(cursor.getString(1));
                pasien.setNama(cursor.getString(2));
                pasien.setJk(cursor.getString(3));
                pasien.setAlamat(cursor.getString(4));
                pasien.setNohp(cursor.getString(5));
                pasien.setAgama(cursor.getString(6));

                //adding mahasiswa to the list
                listPasien.add(pasien);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return listPasien;
    }

}


package com.example.antrianster.Data;

public class Antrian {
    int _id;
    int _antrian;
    int _idpasien;


    //Empty constructor
    //Default constructor
    public Antrian(){

    }

    //Constructor
    public Antrian(int antrian){
        this._antrian = antrian;
    }


    public int getId() {
        return this._id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public int getAntrian(){
        return this._antrian;
    }

    public void setAntrian(int antrian){
        this._antrian = antrian;
    }

    public int getIdpasien() {
        return this._idpasien;
    }

    public void setIdpasien(int idpasien) {
        this._id = idpasien;
    }
}

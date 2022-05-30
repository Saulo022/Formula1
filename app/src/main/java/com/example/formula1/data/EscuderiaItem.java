package com.example.formula1.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "escuderias")
public class EscuderiaItem {

    @PrimaryKey
    public int pk_idEscuderia;

    public String nombre;

    @Override
    public String toString(){return nombre;}
}

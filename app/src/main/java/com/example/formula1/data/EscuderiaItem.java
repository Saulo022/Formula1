package com.example.formula1.data;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "escuderias")
public class EscuderiaItem {

    @PrimaryKey
    public int pk_idEscuderia;

    public String nombre;

    @Ignore
    @SerializedName("pilotos")
    public List<PilotoItem> pilotosItems;

    @Override
    public String toString(){return nombre;}
}

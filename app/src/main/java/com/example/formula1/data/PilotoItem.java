package com.example.formula1.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(
        tableName = "pilotos",
        foreignKeys = @ForeignKey(
        entity = EscuderiaItem.class,
        parentColumns = "pk_idEscuderia",
        childColumns = "fk_idEscuderia",
        onDelete = CASCADE
        )
)

public class PilotoItem {

    @PrimaryKey
    public int pk_idPiloto;

    public String nombre;
    public int edad;
    public int posicion;



    @ColumnInfo(name = "fk_idEscuderia")
    public int fk_idEscuderia;

    @Override
    public String toString(){
        return nombre;
    }
}

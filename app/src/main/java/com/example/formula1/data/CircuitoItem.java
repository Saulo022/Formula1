package com.example.formula1.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(
        tableName = "circuitos",
        foreignKeys = @ForeignKey(
                entity = PilotoItem.class,
                parentColumns = "pk_idPiloto",
                childColumns = "fk_idPiloto",
                onDelete = CASCADE
        )
)
public class CircuitoItem {
    @PrimaryKey
    public int pk_idCircuito;

    public String nombre;
    public int longitud;
    public int curvas;

    @ColumnInfo(name = "fk_idPiloto")
    public int fk_idPiloto;

    @Override
    public String toString(){return nombre;}
}

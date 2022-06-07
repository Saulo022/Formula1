package com.example.formula1.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.formula1.data.CircuitoItem;
import com.example.formula1.data.EscuderiaItem;
import com.example.formula1.data.PilotoItem;

@Database(entities = {PilotoItem.class, EscuderiaItem.class, CircuitoItem.class}, version = 1)
public abstract class Formula1Database extends RoomDatabase {

    public abstract PilotoDao pilotoDao();
    public abstract EscuderiaDao escuderiaDao();
    public abstract CircuitoDao circuitoDao();
}

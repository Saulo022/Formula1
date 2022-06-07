package com.example.formula1.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.formula1.data.EscuderiaItem;

import java.util.List;

@Dao
public interface EscuderiaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertEscuderia(EscuderiaItem escuderia);

    @Update
    void updateEscuderia(EscuderiaItem escuderia);

    @Delete
    void deleteEscuderia(EscuderiaItem escuderia);

    @Query("SELECT * FROM escuderias")
    List<EscuderiaItem> loadEscuderias();

    @Query("SELECT * FROM escuderias WHERE pk_idEscuderia = :id LIMIT 1")
    EscuderiaItem loadEscuderia(int id);
}

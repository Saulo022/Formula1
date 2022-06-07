package com.example.formula1.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.formula1.data.PilotoItem;

import java.util.List;

@Dao
public interface PilotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPiloto(PilotoItem piloto);

    @Update
    void updatePiloto(PilotoItem piloto);

    @Delete
    void deletePiloto(PilotoItem piloto);

    @Query("SELECT * FROM pilotos")
    List<PilotoItem> loadPilotos();

    @Query("SELECT * FROM pilotos WHERE pk_idPiloto = :id LIMIT 1")
    PilotoItem loadPiloto(int id);

    @Query("SELECT * FROM pilotos WHERE fk_idEscuderia=:fk_idPiloto")
    List<PilotoItem> loadPilotos(final int fk_idPiloto);
}

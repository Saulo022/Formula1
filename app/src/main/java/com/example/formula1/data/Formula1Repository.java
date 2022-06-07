package com.example.formula1.data;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.room.Room;

import com.example.formula1.database.EscuderiaDao;
import com.example.formula1.database.Formula1Database;

import com.example.formula1.database.PilotoDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class Formula1Repository implements RepositoryContract{

    public static String TAG = Formula1Repository.class.getSimpleName();

    public static final String DB_FILE = "formula1.db";
    public static final String JSON_FILE = "formula1.json";
    public static final String JSON_ROOT = "escuderias";

    private static Formula1Repository INSTANCE;

    private Formula1Database database;
    private Context context;


    public static RepositoryContract getInstance(Context context) {
        if(INSTANCE == null){
            INSTANCE = new Formula1Repository(context);
        }

        return INSTANCE;
    }

    private Formula1Repository(Context context) {
        this.context = context;

        database = Room.databaseBuilder(
                context, Formula1Database.class, DB_FILE
        ).build();

    }

    @Override
    public void loadFormula1(final boolean clearFirst, final FetchFormula1DataCallback callback){

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if(clearFirst){
                    database.clearAllTables();
                }

                boolean error = false;
                if(getEscuderiaDao().loadEscuderias().size() == 0){

                }
                if (callback != null) callback.onEscuderiaDataFetched(error);
            }
        });
    }



    @Override
    public void getEscuderiaList(final GetEscuderiaListCallback callback) {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    callback.setEscuderiaList(getEscuderiaDao().loadEscuderias());
                }
            }
        });

    }

    private EscuderiaDao getEscuderiaDao(){
        return database.escuderiaDao();
    }

    private PilotoDao getPilotoDao() {return database.pilotoDao();}

    private boolean loadEscuderiaFromJSON(String json) {
        Log.e(TAG, "loadEscuderiaFromJSON()");

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT);

            if (jsonArray.length() > 0) {

                final List<EscuderiaItem> escuderias = Arrays.asList(
                        gson.fromJson(jsonArray.toString(), EscuderiaItem[].class)
                );

                for (EscuderiaItem escuderia: escuderias) {
                    getEscuderiaDao().insertEscuderia(escuderia);
                }

                for (EscuderiaItem escuderia: escuderias) {
                    for (PilotoItem piloto: escuderia.pilotosItems) {
                        piloto.fk_idEscuderia = escuderia.pk_idEscuderia;
                        getPilotoDao().insertPiloto(piloto);
                    }
                }

                return true;
            }

        } catch (JSONException error) {
            Log.e(TAG, "error: " + error);
        }

        return false;
    }

    private String loadJSONFromAsset() {
        //Log.e(TAG, "loadJSONFromAsset()");

        String json = null;

        try {

            InputStream is = context.getAssets().open(JSON_FILE);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException error) {
            Log.e(TAG, "error: " + error);
        }

        return json;
    }
}

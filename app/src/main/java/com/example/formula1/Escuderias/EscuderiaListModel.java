package com.example.formula1.Escuderias;

import android.util.Log;

import com.example.formula1.data.RepositoryContract;

public class EscuderiaListModel implements EscuderiaListContract.Model {

    public static String TAG = EscuderiaListModel.class.getSimpleName();

    private String data;
    private RepositoryContract repository;

    public EscuderiaListModel(RepositoryContract repository) {
        this.repository = repository;
    }


    @Override
    public void fetchEscuderiaListData(final RepositoryContract.GetEscuderiaListCallback callback){

        Log.e(TAG, "fetchEscuderiaListData()");

        repository.loadFormula1(
                    true, new RepositoryContract.FetchFormula1DataCallback(){

        @Override
        public void onEscuderiaDataFetched(boolean error){
            if (!error){
                repository.getEscuderiaList(callback);
                }
            }
        });
    }

    @Override
    public String getStoredData() {
        // Log.e(TAG, "getStoredData()");
        return data;
    }

    @Override
    public void onRestartScreen(String data) {
        // Log.e(TAG, "onRestartScreen()");
    }

    @Override
    public void onDataFromNextScreen(String data) {
        // Log.e(TAG, "onDataFromNextScreen()");
    }

    @Override
    public void onDataFromPreviousScreen(String data) {
        // Log.e(TAG, "onDataFromPreviousScreen()");
    }
}
package com.example.formula1.data;

import java.util.List;

public interface RepositoryContract {

    interface FetchFormula1DataCallback{
        void onEscuderiaDataFetched(boolean error);
    }

    interface GetEscuderiaListCallback {
        void setEscuderiaList(List<EscuderiaItem> escuderias);
    }

    void loadFormula1(boolean clearFirst, FetchFormula1DataCallback callback);

    void getEscuderiaList(Formula1Repository.GetEscuderiaListCallback callback);
}

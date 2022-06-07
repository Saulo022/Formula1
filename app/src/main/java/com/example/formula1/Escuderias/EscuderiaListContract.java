package com.example.formula1.Escuderias;

import com.example.formula1.data.RepositoryContract;

import java.lang.ref.WeakReference;

public interface EscuderiaListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayEscuderiaListData(EscuderiaListViewModel viewModel);

        void navigateToNextScreen();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);
        void injectModel(Model model);

        void fetchEscuderiaListData();
    }

    interface Model {
        String getStoredData();

        void onDataFromNextScreen(String data);

        void onRestartScreen(String data);

        void onDataFromPreviousScreen(String data);

        void fetchEscuderiaListData(final RepositoryContract.GetEscuderiaListCallback callback);
    }

}
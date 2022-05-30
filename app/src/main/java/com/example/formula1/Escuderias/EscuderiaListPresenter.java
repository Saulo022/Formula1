package com.example.formula1.Escuderias;

import com.example.formula1.app.AppMediator;

import java.lang.ref.WeakReference;
import java.util.List;

public class EscuderiaListPresenter implements EscuderiaListContract.Presenter {

    public static String TAG = EscuderiaListPresenter.class.getSimpleName();

    private WeakReference<EscuderiaListContract.View> view;
    private EscuderiaListState state;
    private EscuderiaListContract.Model model;
    private AppMediator mediator;

    public EscuderiaListPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getEscuderiaListState();
    }

    /*
    @Override
    //Obtener datos de la lista de categorías
    public void fetchCategoryListData() {
        // Log.e(TAG, "fetchCategoryListData()");

        // call the model
        model.fetchCategoryListData(new RepositoryContract.GetCategoryListCallback() {

            @Override
            public void setCategoryList(List<CategoryItem> categories) {
                state.categories = categories;

                view.get().displayCategoryListData(state);
            }
        });

    }*/

    @Override
    public void injectView(WeakReference<EscuderiaListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(EscuderiaListContract.Model model) {
        this.model = model;
    }

    /*@Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state
        state = new EscuderiaListState();

        // call the model and update the state
        state.data = model.getStoredData();

        // use passed state if is necessary
        PreviousToEscuderiaListState savedState = getStateFromPreviousScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromPreviousScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }
    }

    @Override
    public void onRestart() {
        // Log.e(TAG, "onRestart()");

        // update the model if is necessary
        model.onRestartScreen(state.data);
    }

    @Override
    public void onResume() {
        // Log.e(TAG, "onResume()");

        // use passed state if is necessary
        NextToEscuderiaListState savedState = getStateFromNextScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromNextScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }

        // call the model and update the state
        //state.data = model.getStoredData();

        // update the view
        view.get().onDataUpdated(state);

    }

    @Override
    public void onBackPressed() {
        // Log.e(TAG, "onBackPressed()");
    }

    @Override
    public void onPause() {
        // Log.e(TAG, "onPause()");
    }

    @Override
    public void onDestroy() {
        // Log.e(TAG, "onDestroy()");
    }

    private NextToEscuderiaListState getStateFromNextScreen() {
        return mediator.getNextEscuderiaListScreenState();
    }

    private void passStateToNextScreen(EscuderiaListToNextState state) {
        mediator.setNextEscuderiaListScreenState(state);
    }

    private void passStateToPreviousScreen(EscuderiaListToPreviousState state) {
        mediator.setPreviousEscuderiaListScreenState(state);
    }

    private PreviousToEscuderiaListState getStateFromPreviousScreen() {
        return mediator.getPreviousEscuderiaListScreenState();
    }*/

}
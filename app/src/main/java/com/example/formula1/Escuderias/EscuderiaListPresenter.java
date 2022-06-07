package com.example.formula1.Escuderias;

import com.example.formula1.app.AppMediator;
import com.example.formula1.data.EscuderiaItem;
import com.example.formula1.data.RepositoryContract;

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


    @Override
    //Obtener datos de la lista de categorías
    public void fetchEscuderiaListData() {
        // Log.e(TAG, "fetchCategoryListData()");

        // call the model
        model.fetchEscuderiaListData(new RepositoryContract.GetEscuderiaListCallback() {

            @Override
            public void setEscuderiaList(List<EscuderiaItem> escuderias) {
                state.escuderias = escuderias;

                view.get().displayEscuderiaListData(state);
            }
        });

    }

    @Override
    public void injectView(WeakReference<EscuderiaListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(EscuderiaListContract.Model model) {
        this.model = model;
    }


}
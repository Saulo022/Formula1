package com.example.formula1.Escuderias;

import androidx.fragment.app.FragmentActivity;

import com.example.formula1.R;
import com.example.formula1.app.AppMediator;

import java.lang.ref.WeakReference;

public class EscuderiaListScreen {

    public static void configure(EscuderiaListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        //String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();



        EscuderiaListContract.Presenter presenter = new EscuderiaListPresenter(mediator);

        //EscuderiaListContract.Model model = new EscuderiaListModel(data);

        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);
        view.injectPresenter(presenter);

    }
}

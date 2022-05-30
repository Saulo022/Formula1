package com.example.formula1.menuF1;

import androidx.fragment.app.FragmentActivity;

import com.example.formula1.R;
import com.example.formula1.app.AppMediator;

import java.lang.ref.WeakReference;

public class MenuScreen {

    public static void configure(MenuContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        //String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();

        MenuContract.Presenter presenter = new MenuPresenter(mediator);
        String data = "0";
        MenuContract.Model model = new MenuModel(data);

        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);
        view.injectPresenter(presenter);

    }
}

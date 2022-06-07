package com.example.formula1.Escuderias;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.formula1.R;

public class EscuderiaListActivity
        extends AppCompatActivity implements EscuderiaListContract.View {

    public static String TAG = EscuderiaListActivity.class.getSimpleName();

    private EscuderiaListContract.Presenter presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escuderia_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.title_escuderia_screen);
        }



        // do the setup
        EscuderiaListScreen.configure(this);

        presenter.fetchEscuderiaListData();
    }




    @Override
    public void displayEscuderiaListData(EscuderiaListViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");


    }


    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, EscuderiaListActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(EscuderiaListContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
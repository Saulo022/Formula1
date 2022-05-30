package com.example.formula1.Escuderias;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

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
        getSupportActionBar().setTitle(R.string.title_escuderia_screen);


        // do the setup
        EscuderiaListScreen.configure(this);

        if (savedInstanceState == null) {
            presenter.onStart();

        } else {
            presenter.onRestart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.onResume();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        presenter.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();

        presenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.onDestroy();
    }

    @Override
    public void onDataUpdated(EscuderiaListViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
        //((TextView) findViewById(R.id.data)).setText(viewModel.data);
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
package com.example.formula1.app;

import com.example.formula1.Escuderias.EscuderiaListState;
import com.example.formula1.menuF1.MenuState;

@SuppressWarnings("unused")
public class AppMediator {

    private MenuState menuState = new MenuState();
    private EscuderiaListState escuderiaListState = new EscuderiaListState();


    private static AppMediator INSTANCE;

    //private AppState mAppState;


    private AppMediator() {

    }


    public static AppMediator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AppMediator();
        }

        return INSTANCE;
    }

    // to reset the state when testing
    public static void resetInstance() {
        INSTANCE = null;
    }

    public MenuState getMenuState() {
        return menuState;
    }

    public EscuderiaListState getEscuderiaListState() {
        return escuderiaListState;
    }
/*
    public AppState getAppState() {
        return mAppState;
    }


    public NextToAppState getNextAppScreenState() {
        return null;
    }

    public void setNextAppScreenState(AppToNextState state) {

    }

    public void setPreviousAppScreenState(AppToPreviousState state) {

    }

    public PreviousToAppState getPreviousAppScreenState() {
        return null;
    }*/
}
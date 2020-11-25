package com.example.myapplication;

import android.app.Application;

public class Museum extends Application {
    private int selectedMuseum = 0;

    public int getSelectedMuseum() {
        return selectedMuseum;
    }

    public void setSelectedMuseum(int selectedMuseum) {
        this.selectedMuseum = selectedMuseum;
    }
}

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launch2ndActivity(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void metAction(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        ((Museum) this.getApplication()).setSelectedMuseum(0);
        startActivity(intent);
    }

    public void momaAction(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        ((Museum) this.getApplication()).setSelectedMuseum(1);
        startActivity(intent);
    }

    public void americanAction(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        ((Museum) this.getApplication()).setSelectedMuseum(2);
        startActivity(intent);
    }

    public void guggenheimAction(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        ((Museum) this.getApplication()).setSelectedMuseum(3);
        startActivity(intent);
    }
}
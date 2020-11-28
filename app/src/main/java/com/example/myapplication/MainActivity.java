package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

// This Class takes care of the first activity, or the first screen user will see
// Displays 4 museums
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

    // launching 2nd activity for Metropolitan Museum
    public void metAction(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        ((Museum) this.getApplication()).setSelectedMuseum(0);
        startActivity(intent);
    }

    // launching 2nd activity for MOMA
    public void momaAction(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        ((Museum) this.getApplication()).setSelectedMuseum(1);
        startActivity(intent);
    }

    // launching 2nd activity for American Museum of Natural History
    public void americanAction(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        ((Museum) this.getApplication()).setSelectedMuseum(2);
        startActivity(intent);
    }

    // launching 2nd activity for Guggenheim
    public void guggenheimAction(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        ((Museum) this.getApplication()).setSelectedMuseum(3);
        startActivity(intent);
    }
}
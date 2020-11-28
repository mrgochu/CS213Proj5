package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;

// This class takes care of the 2nd Activities, where the ticket calculator and respective images and museum names are displayed.
public class MainActivity2 extends AppCompatActivity {
    final int[][] PRICE = { {25, 17, 12}, {25, 18, 14}, {23, 18, 18},{23, 18, 18} };
    final double NY_TAX = 8.875;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        // Toast implementation
        Context context = getApplicationContext();
        CharSequence text = "Maximum of 5 tickets for each!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        // Setting image type for respective museums
        ImageView imageView = findViewById(R.id.museumPic);
        int selectedMuseum = ((Museum) this.getApplication()).getSelectedMuseum();
        setUpSpinners();

        switch(selectedMuseum){
            case 0:{
                setForMetropolitan();
                break;
            }
            case 1:{
                setForModern();
                break;
            }
            case 2:{
                setForHistory();
                break;
            }
            case 3:{
                setForGug();
                break;
            }
        }
    }

    // Implementation for Metropolitan Museum
    public void setForMetropolitan(){
        TextView museumName = findViewById(R.id.museumName);
        ImageView img = findViewById(R.id.museumPic);
        Spinner sp = findViewById(R.id.spinner);
        museumName.setText(getString(R.string.metMuseum));
        img.setImageResource(R.drawable.met);
        setTicketPrice(PRICE[0][0],PRICE[0][1],PRICE[0][2]);
    }

    // Implementation for Museum of Modern Art
    public void setForModern(){
        TextView museumName = findViewById(R.id.museumName);
        ImageView img = findViewById(R.id.museumPic);
        Spinner sp = findViewById(R.id.spinner);
        museumName.setText(getString(R.string.momaMuseum));
        img.setImageResource(R.drawable.moma);
        setTicketPrice(PRICE[1][0],PRICE[1][1],PRICE[1][2]);
    }

    // Implementation for American Museum of Natural History
    public void setForHistory(){
        TextView museumName = findViewById(R.id.museumName);
        ImageView img = findViewById(R.id.museumPic);
        Spinner sp = findViewById(R.id.spinner);
        museumName.setText(getString(R.string.americanMuseum));
        img.setImageResource(R.drawable.naturalhistorymuseum);
        setTicketPrice(PRICE[2][0],PRICE[2][1],PRICE[2][2]);
    }

    // Implementation for Guggenheim
    public void setForGug(){
        TextView museumName = findViewById(R.id.museumName);
        ImageView img = findViewById(R.id.museumPic);
        Spinner sp = findViewById(R.id.spinner);
        museumName.setText(getString(R.string.guggenheimMuseum));
        img.setImageResource(R.drawable.guggenheim);
        setTicketPrice(PRICE[3][0],PRICE[3][1],PRICE[3][2]);
    }

    // Method for setting Ticket Prices
    public void setTicketPrice(int adult, int senior, int student){
        TextView adultPrice = findViewById(R.id.adultPrice);
        TextView seniorPrice = findViewById(R.id.seniorPrice);
        TextView studentPrice = findViewById(R.id.studentPrice);

        adultPrice.setText(getString(R.string.adultPrice, adult));
        seniorPrice.setText(getString(R.string.seniorPrice, senior));
        studentPrice.setText(getString(R.string.studentPrice, student));
    }

    // Spinners set so MAX is 5 tickets for each age group
    public void setUpSpinners(){
        Spinner sp = findViewById(R.id.spinner);
        Spinner sp2 = findViewById(R.id.spinner2);
        Spinner sp3 = findViewById(R.id.spinner3);
        ArrayList<String> tickets = new ArrayList<>();
        tickets.add(0+"");
        tickets.add(1+"");
        tickets.add(2+"");
        tickets.add(3+"");
        tickets.add(4+"");
        tickets.add(5+"");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, tickets);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp.setAdapter(arrayAdapter);
        sp2.setAdapter(arrayAdapter);
        sp3.setAdapter(arrayAdapter);
        AdapterView.OnItemSelectedListener oc = new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                EditText rawPrice = findViewById(R.id.rawTicketPrice);

                EditText salesTax = findViewById(R.id.salesTax);

                EditText totalPrice = findViewById(R.id.totalPrice);

                Spinner sp = findViewById(R.id.spinner);
                Spinner sp2 = findViewById(R.id.spinner2);
                Spinner sp3 = findViewById(R.id.spinner3);

                sp.getSelectedItem();
                int adultCount = Integer.parseInt(sp.getSelectedItem()+"");
                int seniorCount = Integer.parseInt(sp2.getSelectedItem()+"");
                int studentCount = Integer.parseInt(sp3.getSelectedItem()+"");
                int selectedMuseum = ((Museum) getApplication()).getSelectedMuseum();
                int ticketPrice = PRICE[selectedMuseum][0] * adultCount +
                        PRICE[selectedMuseum][1] * seniorCount +
                        PRICE[selectedMuseum][2] * studentCount;

                rawPrice.setText(getString(R.string.ticket_price, ticketPrice));
                salesTax.setText(getString(R.string.sales_tax, String.format(Locale.US, "%.2f",ticketPrice * NY_TAX / 100)));
                totalPrice.setText(getString(R.string.ticket_total,  String.format(Locale.US, "%.2f",ticketPrice * (NY_TAX / 100 + 1))));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        sp.setOnItemSelectedListener(oc);
        sp2.setOnItemSelectedListener(oc);
        sp3.setOnItemSelectedListener(oc);
    }

    // Implementation of directing to website from image selected
    public void goWebsite(View view) {
        int selectedMuseum = ((Museum) this.getApplication()).getSelectedMuseum();
        switch(selectedMuseum){
            case 0: {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.metmuseum.org/")));
                break;
            }

            case 1: {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.moma.org/")));
                break;
            }

            case 2: {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amnh.org/")));
                break;
            }

            case 3: {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.guggenheim.org/")));
                break;
            }
        }

    }
}
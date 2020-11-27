package com.example.myapplication;

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


public class MainActivity2 extends AppCompatActivity {
    final int[][] PRICE = { {25, 17, 12}, {25, 18, 14}, {23, 18, 18},{23, 18, 18} };
    final double NY_TAX = 8.875;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageView imageView = (ImageView) findViewById(R.id.museumPic);
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

    public void setForMetropolitan(){
        TextView museumName = (TextView) findViewById(R.id.museumName);
        ImageView img = (ImageView) findViewById(R.id.museumPic);
        Spinner sp = (Spinner) findViewById(R.id.spinner);
        museumName.setText("The Metropolitan Museum of Art");
        img.setImageResource(R.drawable.met);
        setTicketPrice(PRICE[0][0],PRICE[0][1],PRICE[0][2]);
    }

    public void setForModern(){
        TextView museumName = (TextView) findViewById(R.id.museumName);
        ImageView img = (ImageView) findViewById(R.id.museumPic);
        Spinner sp = (Spinner) findViewById(R.id.spinner);
        museumName.setText("The Museum of Modern Art");
        img.setImageResource(R.drawable.moma);
        setTicketPrice(PRICE[1][0],PRICE[1][1],PRICE[1][2]);
    }

    public void setForHistory(){
        TextView museumName = (TextView) findViewById(R.id.museumName);
        ImageView img = (ImageView) findViewById(R.id.museumPic);
        Spinner sp = (Spinner) findViewById(R.id.spinner);
        museumName.setText("American Museum of Natural History");
        img.setImageResource(R.drawable.naturalhistorymuseum);
        setTicketPrice(PRICE[2][0],PRICE[2][1],PRICE[2][2]);
    }

    public void setForGug(){
        TextView museumName = (TextView) findViewById(R.id.museumName);
        ImageView img = (ImageView) findViewById(R.id.museumPic);
        Spinner sp = (Spinner) findViewById(R.id.spinner);
        museumName.setText("Solomon R. Guggenheim Museum");
        img.setImageResource(R.drawable.guggenheim);
        setTicketPrice(PRICE[3][0],PRICE[3][1],PRICE[3][2]);
    }

    public void setTicketPrice(int adult, int senior, int student){
        TextView adultPrice = (TextView) findViewById(R.id.adultPrice);
        TextView seniorPrice = (TextView) findViewById(R.id.seniorPrice);
        TextView studentPrice = (TextView) findViewById(R.id.studentPrice);

        adultPrice.setText("$ "+ adult);
        seniorPrice.setText("$ "+ senior);
        studentPrice.setText("$ "+ student);
    }

    public void setUpSpinners(){
        Spinner sp = (Spinner) findViewById(R.id.spinner);
        Spinner sp2 = (Spinner) findViewById(R.id.spinner2);
        Spinner sp3 = (Spinner) findViewById(R.id.spinner3);
        ArrayList<String> tickets = new ArrayList<>();
        tickets.add(0+"");
        tickets.add(1+"");
        tickets.add(2+"");
        tickets.add(3+"");
        tickets.add(4+"");
        tickets.add(5+"");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, tickets);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp.setAdapter(arrayAdapter);
        sp2.setAdapter(arrayAdapter);
        sp3.setAdapter(arrayAdapter);
        AdapterView.OnItemSelectedListener oc = new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                EditText rawPrice = (EditText) findViewById(R.id.rawTicketPrice);

                EditText salesTax = (EditText) findViewById(R.id.salesTax);

                EditText totalPrice = (EditText) findViewById(R.id.totalPrice);

                Spinner sp = (Spinner) findViewById(R.id.spinner);
                Spinner sp2 = (Spinner) findViewById(R.id.spinner2);
                Spinner sp3 = (Spinner) findViewById(R.id.spinner3);
                Toast toast = Toast.makeText(getApplicationContext(), "Reason can not be blank", Toast.LENGTH_LONG);
                toast.setMargin(50, 100);
                toast.show();
                sp.getSelectedItem();
                int adultCount = Integer.parseInt(sp.getSelectedItem()+"");
                int seniorCount = Integer.parseInt(sp2.getSelectedItem()+"");
                int studentCount = Integer.parseInt(sp3.getSelectedItem()+"");
                int selectedMuseum = ((Museum) getApplication()).getSelectedMuseum();
                int ticketPrice = PRICE[selectedMuseum][0] * adultCount +
                        PRICE[selectedMuseum][1] * seniorCount +
                        PRICE[selectedMuseum][2] * studentCount;

                rawPrice.setText("ticket price : " + ticketPrice);
                salesTax.setText("sales tax : " + String.format("%.2f",ticketPrice * NY_TAX / 100));
                totalPrice.setText("ticket total : " + String.format("%.2f",ticketPrice * (NY_TAX / 100 + 1)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        sp.setOnItemSelectedListener(oc);
        sp2.setOnItemSelectedListener(oc);
        sp3.setOnItemSelectedListener(oc);
    }

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
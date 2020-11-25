package com.example.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity2 extends AppCompatActivity {
    final int[][] PRICE = { {25, 17, 12}, {25, 18, 14}, {23, 18, 18},{23, 18, 18} };
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
        tickets.add(6+"");
        tickets.add(7+"");
        tickets.add(8+"");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, tickets);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp.setAdapter(arrayAdapter);
        sp2.setAdapter(arrayAdapter);
        sp3.setAdapter(arrayAdapter);
    }

}
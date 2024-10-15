package com.example.convertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Spinner s1,s2;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.editTextTextPersonName);
        s1=findViewById(R.id.spinner3);
        s2=findViewById(R.id.spinner);
        b=findViewById(R.id.button);

        String[] from = {"PAK"};
        ArrayAdapter ad = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        s1.setAdapter(ad);
        String[] to = {"UAE", "RIYAL", "USD"};
        ArrayAdapter ad1 = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,to);
        s2.setAdapter(ad1);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double total;
                double amount = Double.parseDouble(et.getText().toString());
                if (s1.getSelectedItem().toString()=="PAK" && s2.getSelectedItem().toString()=="USD"){
                    total = amount*290.0;
                    Toast.makeText(MainActivity.this, "Amount in USD is"+total, Toast.LENGTH_SHORT).show();
                } else if (s1.getSelectedItem().toString() == "PAK" && s2.getSelectedItem().toString() == "RIYAL") {
                    total=amount*77.16;
                    Toast.makeText(MainActivity.this, "Amount in RIYAL is"+total, Toast.LENGTH_SHORT).show();
                } else if (s1.getSelectedItem().toString() == "PAK" && s2.getSelectedItem().toString() == "UAE") {
                    total=amount*78.78;
                    Toast.makeText(MainActivity.this, "Amount in UAE is "+ total, Toast.LENGTH_SHORT).show();
                }
            }
        });
        }
}
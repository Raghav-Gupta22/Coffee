package com.example.coffee;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class summaryactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summaryactivity);



        Bundle extras= getIntent().getExtras();
        String str=extras.getString("data");
        TextView textView8=findViewById(R.id.textView8);
        textView8.setText("Name: "+ str);
        String ncoffee=extras.getString("data2");
        TextView textView4=findViewById(R.id.textView4);
        textView4.setText("Number of coffees: "+ ncoffee);
        int n=Integer.parseInt(ncoffee);
        int cost=n*20;
        TextView textView10=findViewById(R.id.textView10);
        textView10.setText(String.valueOf("Total amount: "+ cost+" "+"Bucks"));
    }
}
package com.example.coffee;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button inc, dec, order,menucard;
    TextView nn;
    EditText name;
    CheckBox c;
    String sugar;
    Spinner spinner;
    String[] arr = {"Yes", "No", "Maybe", "Very Well"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nn = (TextView) findViewById(R.id.textView9);
        inc = (Button) findViewById(R.id.button2);
        dec = (Button) findViewById(R.id.button);
        order = (Button) findViewById(R.id.button3);
        name=(EditText)findViewById(R.id.editTextTextPersonName2);
        menucard=(Button)findViewById(R.id.button4);


        inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(nn.getText().toString());
                num = num + 1;
                nn.setText(String.valueOf(num));
            }
        });

        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(nn.getText().toString());
                if(num>=2) {
                    num = num - 1;
                    nn.setText(String.valueOf(num));
                }
                else
                    Toast.makeText(MainActivity.this, "YOU HAVE TO ORDER MINIMUM 1 COFFEE", Toast.LENGTH_LONG).show();
            }
        });


        c = (CheckBox) findViewById(R.id.checkBox);
        c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (c.isChecked()) {
                    Toast.makeText(MainActivity.this, "SUGAR ADDED", Toast.LENGTH_SHORT).show();
                    sugar = "yes";
                } else {
                    sugar = "no";
                }
            }
        });

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arr);
        spinner.setAdapter(adapter);


            order.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String pname=name.getText().toString();
                    if(pname.equals(""))                                                             //also write if(TextUtils.isEmpty(pname));
                    {
                        name.setError("Please Enter Name");                                          //setError work on object not on string.
                    }
                    else {
                    Intent intent = new Intent(MainActivity.this, summaryactivity.class);
                    String ncoffee = nn.getText().toString();
                    intent.putExtra("data", pname);
                    intent.putExtra("data2", ncoffee);
                    startActivity(intent);
                }}
            });

            menucard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1=new Intent(MainActivity.this,MenuCardActivity.class);
                    startActivity(intent1);
                }
            });

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.rate:
                {
                Intent intent2=new Intent(MainActivity.this,RateActivity.class);
                startActivity(intent2);
                break;
            }
            case R.id.gallery:
            {
                Intent intent3=new Intent(MainActivity.this,GalleryActivity.class);
                startActivity(intent3);
                break;
            }
            case R.id.web:
            {
                Intent intent4=new Intent(MainActivity.this,WebActivity.class);
                startActivity(intent4);
                break;
            }
        }
        return true;
    }
}
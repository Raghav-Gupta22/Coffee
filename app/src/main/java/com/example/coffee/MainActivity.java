package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    Button dec, menucard;
    EditText name;
    String sugar;
    Spinner spinner;
    String[] arr = {"Yes", "No", "Maybe", "Very Well"};
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // inflating our xml layout in our activity main binding
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        // getting our root layout in our view.
        View view = activityMainBinding.getRoot();

        // below line is to set
        // Content view for our layout.
        setContentView(view);

        name = (EditText) findViewById(R.id.editTextTextPersonName2);
        menucard = (Button) findViewById(R.id.button4);


        activityMainBinding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(activityMainBinding.textView9.getText().toString());
                num = num + 1;
                activityMainBinding.textView9.setText(String.valueOf(num));
            }
        });

        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(activityMainBinding.textView9.getText().toString());
                if(num>=2) {
                    num = num - 1;
                    activityMainBinding.textView9.setText(String.valueOf(num));
                }
                else
                    Toast.makeText(MainActivity.this, "YOU HAVE TO ORDER MINIMUM 1 COFFEE", Toast.LENGTH_LONG).show();
            }
        });


        activityMainBinding.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (activityMainBinding.checkBox.isChecked()) {
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


        activityMainBinding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pname = name.getText().toString();
                if (pname.equals(""))                                                             //also write if(TextUtils.isEmpty(pname));
                {
                    name.setError("Please Enter Name");                                          //setError work on object not on string.
                } else {
                    Intent intent = new Intent(MainActivity.this, summaryactivity.class);
                    String ncoffee = activityMainBinding.textView9.getText().toString();
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
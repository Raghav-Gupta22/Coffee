package com.example.coffee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class RateActivity extends AppCompatActivity {

    RatingBar bar;
    TextView textView,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        bar=(RatingBar)findViewById(R.id.rating);
        textView=(TextView)findViewById((R.id.text1));
        t2=(TextView)findViewById((R.id.text));
        t3=(TextView)findViewById((R.id.text2));

        bar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(rating==1||rating==0.5)
                {
                t2.setText("THANK YOU FOR YOUR VALUABLE FEEDBACK.");
                t3.setText("YOU RATED APP POOR, Next time i will work harder.");
            }
                else if(rating==2||rating==1.5)
                {
                    t2.setText("THANK YOU FOR YOUR VALUABLE FEEDBACK.");
                    t3.setText("You rated app BAD, Next time i will put more effort.");
                }
                else if(rating==3||rating==2.5)
                {
                    t2.setText("THANK YOU FOR YOUR VALUABLE FEEDBACK.");
                    t3.setText("You rated app AVERAGE, sorry that it didn't met upto your expectations.");
                }
                else if(rating==4||rating==3.5)
                {
                    t2.setText("THANK YOU FOR YOUR VALUABLE FEEDBACK.");
                    t3.setText("You rated app GOOD, I am happy to know you liked my app.");
                }
                else if(rating==5||rating==4.5)
                {
                    t2.setText("THANK YOU FOR YOUR VALUABLE FEEDBACK.");
                    t3.setText("You rated app EXCELLENT, I am gratefully delighted.");
                }
            }
        });
    }
}
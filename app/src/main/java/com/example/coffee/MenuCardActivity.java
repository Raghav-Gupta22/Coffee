package com.example.coffee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MenuCardActivity extends AppCompatActivity {

    ListView listView;
    Integer[] allimages ={R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,};
    String[] alltitle ={"one","two","three","four","five","six","seven","eight","nine"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_card);


        listView=(ListView)findViewById(R.id.list);
        MyListAdapter adapter1=new MyListAdapter(MenuCardActivity.this,allimages,alltitle);
        listView.setAdapter(adapter1);
    }
}
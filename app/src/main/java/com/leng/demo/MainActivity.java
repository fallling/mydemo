package com.leng.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView(){
        ListView listView = findViewById(R.id.list_item);

        List<Message> messages = new ArrayList<>();
        messages.add(new Message("hello piter", 1));
        messages.add(new Message("hello", 0));
        messages.add(new Message("how are you today", 1));
        messages.add(new Message("im fine thank you", 0));

        MyListViewAdapter adapter = new MyListViewAdapter(this,messages);

        listView.setAdapter(adapter);
    }
}
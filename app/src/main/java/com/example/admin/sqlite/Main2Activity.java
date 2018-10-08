package com.example.admin.sqlite;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1=(TextView)findViewById(R.id.txt1);
        //String sname=getIntent().getStringExtra("NAME");
        //String email=getIntent().getStringExtra("EMAIL");
        //String srnum=getIntent().getStringExtra("RNUMBER");
        //String snum=getIntent().getStringExtra("NUMBER");
        SharedPreferences sharedPreferences=getSharedPreferences("studentdata", Context.MODE_PRIVATE);
        String sname=sharedPreferences.getString("NAME","'");
        String srnum=sharedPreferences.getString("SRNUM","'");
        String snum=sharedPreferences.getString("SNUM","'");
        t1.setText(sname+"\n"+srnum+"\n"+snum);
    }
}

package com.example.admin.sqlite;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText e1,e3,e4;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.e1);
        e3=(EditText)findViewById(R.id.e3);
        e4=(EditText)findViewById(R.id.e4);
        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String sname=e1.getText().toString();
                String srnum=e3.getText().toString();
                String snum=e4.getText().toString();
                if(sname.length()==0) {
                    e1.setError("inavalid name");
                }
                else if(srnum.length() == 0) {
                    e3.setError("invalid registration number");
                }
                else if(snum.length() == 0) {
                    e4.setError("Invalid number");
                }



                else {
                    Intent i = new Intent(MainActivity.this, Main2Activity.class);
                    SharedPreferences sharedPreferences=getSharedPreferences("studentdata", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("NAME",sname);
                    editor.putString("SRNUM",srnum);
                    editor.putString("SNUM",snum);
                    editor.apply();

                    //i.putExtra("NAME", sname);
                    //i.putExtra("RNUMBER", srnum);
                    //i.putExtra("NUMBER", snum);
                    startActivity(i);
                    Database db=new Database(MainActivity.this);
                    db.insert(sname,srnum,snum);
                }

            }
        });
    }
    }


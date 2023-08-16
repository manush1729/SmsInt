package com.example.smsint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class date extends AppCompatActivity {
    String name,age;
    DatePicker date;
    Button next,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        Bundle b=getIntent().getExtras();
        name=b.getString("name");
        age=b.getString("age");
        date=findViewById(R.id.date);
        next=findViewById(R.id.next);
        back=findViewById(R.id.back);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b=new Bundle();
                b.putString("name",name);
                b.putString("age",age);
                String dat=Integer.toString(date.getDayOfMonth())+"/";
                dat+=Integer.toString(date.getMonth()+1)+"/";
                dat+=Integer.toString(date.getYear());
                b.putString("date",dat);
                Intent i=new Intent(date.this,last.class);
                i.putExtras(b);
                startActivity(i);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(date.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
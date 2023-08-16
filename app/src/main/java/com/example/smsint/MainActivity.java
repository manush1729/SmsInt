package com.example.smsint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button next;
    EditText name,age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next=findViewById(R.id.next);
        name=findViewById(R.id.name);
        age=findViewById(R.id.age);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n,a;
                n=name.getText().toString();
                a=age.getText().toString();
                Bundle b=new Bundle();
                b.putString("name",n);
                b.putString("age",a);
                Intent i=new Intent(MainActivity.this,date.class);
                i.putExtras(b);
                startActivity(i);
            }
        });
    }
}
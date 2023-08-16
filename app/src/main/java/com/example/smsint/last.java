package com.example.smsint;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class last extends AppCompatActivity {
    Button time,submit;
    TextView viewtime;
    String name,age,date,tim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        Bundle b=getIntent().getExtras();
        name=b.getString("name");
        age=b.getString("age");
        date=b.getString("date");
        time=findViewById(R.id.time);
        submit=findViewById(R.id.submit);
        viewtime=findViewById(R.id.viewtime);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c=Calendar.getInstance();
                int hour=c.get(Calendar.HOUR_OF_DAY);
                int minute=c.get(Calendar.MINUTE);
                TimePickerDialog tpd=new TimePickerDialog(last.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        viewtime.setText("The selected time is "+hourOfDay+":"+minute);
                        tim=hourOfDay+":"+minute;
                    }
                },hour,minute,false);
                tpd.show();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sm="Name: "+name+"\nAge: "+age+"\nDate: "+date+"\nTime: "+tim;
                Uri u=Uri.parse("smsto:6381177120");
                Intent i=new Intent(Intent.ACTION_SENDTO,u);
                i.putExtra("sms_body",sm);
                startActivity(i);
            }
        });
    }
}
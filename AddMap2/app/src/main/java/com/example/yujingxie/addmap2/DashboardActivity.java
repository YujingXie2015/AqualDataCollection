package com.example.yujingxie.addmap2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    TextView Name;
    TextView Location;
    TextView Time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Name = (TextView)findViewById(R.id.name);
        Location = (TextView)findViewById(R.id.location);
        Time = (TextView)findViewById(R.id.timeText);

        Name.setText("Leakage outside DBH");
        Location.setText("Front Door");
        Time.setText("23:13PM");


    }
}

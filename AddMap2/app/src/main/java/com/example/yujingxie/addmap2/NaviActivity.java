package com.example.yujingxie.addmap2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NaviActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navi);

        Button mbtn=(Button)findViewById(R.id.mapBtn);
        mbtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent myIntent = new Intent(NaviActivity.this, MapsActivity.class);
                startActivity(myIntent);
            }
        });

        Button rbtn=(Button)findViewById(R.id.reportBtn);
        rbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(NaviActivity.this,ReportWaterActivity.class);
                startActivity(myIntent);
            }
        });


        Button dbtn=(Button)findViewById(R.id.dashBtn);
        dbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(NaviActivity.this,RecyclerViewActivity.class);
                startActivity(myIntent);
            }
        });
    }

}

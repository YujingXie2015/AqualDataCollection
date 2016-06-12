package com.example.yujingxie.addmap2;

import com.parse.ParseUser;

import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
public class Welcome extends AppCompatActivity {

    // Declare Variable
    Button logout;
    Button continuebtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);

        // Retrieve current user from Parse.com
        ParseUser currentUser = ParseUser.getCurrentUser();

        // Convert currentUser into String
        String struser = currentUser.getUsername().toString();


        TextView txtuser = (TextView) findViewById(R.id.txtuser);

        // Set the currentUser String into TextView
        txtuser.setText("You are logged in as " + struser);


        logout = (Button) findViewById(R.id.logout);

        // Logout Button Click Listener
        logout.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                // Logout current user
                ParseUser.logOut();
                finish();
            }
        });

        continuebtn = (Button) findViewById(R.id.continuebtn);

        // Logout Button Click Listener
        continuebtn.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                // Logout current user
                Intent intentNavi = new Intent(Welcome.this ,
                        NaviActivity.class);
                Welcome.this.startActivity(intentNavi);
                finish();
            }
        });



    }
}
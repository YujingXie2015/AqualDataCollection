package com.example.yujingxie.addmap2;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;
import android.app.Application;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseInstallation;
import com.parse.PushService;
import com.parse.SaveCallback;
//import com.parse;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        ParseObject.registerSubclass(Report.class);
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("aquascale")
                .server("https://aquascale.herokuapp.com/parse/")   // '/' important after 'parse'
                .build());
        ParseInstallation.getCurrentInstallation().saveInBackground();
        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        // If you would like all objects to be private by default, remove this
        // line.
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);
    }

//    @Override
//    protected void attachBaseContext(Context context) {
//        super.attachBaseContext(context);
//        MultiDex.install(this);
//    }
}
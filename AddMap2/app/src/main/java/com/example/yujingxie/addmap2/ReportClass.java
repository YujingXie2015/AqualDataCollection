package com.example.yujingxie.addmap2;

/**
 * Created by XueYang on 6/9/16.
 */
public class ReportClass {
    String location;
    String time;
    String type;
    public ReportClass(String location, String time, String type){
        this.location = location;
        this.time = time;
        this.type = type;


    }

    public String getTime(){
        return this.time;
    }

    public String getLocation(){
        return this.location;
    }

    public String getType(){
        return this.type;
    }
}

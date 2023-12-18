package com.example.sa_medicationrecorder_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Dates {
    private String day;
    private String dayNum;
    private String time;
    private String month;


    public Dates(String day, String dayNum, String month, String time) {
        this.day = day;
        this.dayNum = dayNum;
        this.month = month;
        this.time = time;
    }


    public Dates(){
        day = "";
        dayNum = "";
        month = "";
        time = "";

    }

    @Override
    public String toString(){
        return String.valueOf(day) + "," + String.valueOf(dayNum)+ "," + String.valueOf(month) + "," + String.valueOf(time) ;
    }

    public String getDay() {
        return day;
    }

    public String getDayNum() {
        return dayNum;
    }

    public String getMonth() {
        return month;
    }

    public String getTime() { return time; }
}



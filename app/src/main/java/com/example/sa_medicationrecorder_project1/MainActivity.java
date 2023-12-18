package com.example.sa_medicationrecorder_project1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button button2;
    private Button button3;

    private EditText editTextDay;
    private EditText editTextTime;
    private EditText editTextMonth;

    private String sharedPrefs = "sharedPref";
    static public ArrayList<Dates> recordedInfo = new ArrayList<Dates>();
    List<String> spinnerArray =  new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.recyclerViewButton);
        button2 = findViewById(R.id.buttonSetRecord);
        button3 = findViewById(R.id.buttonDetails);

        editTextDay = findViewById(R.id.editTextDayNum);
        editTextTime = findViewById(R.id.editTextMonth);
        editTextMonth = findViewById(R.id.editTextTime);

        spinnerArray.add("Monday");
        spinnerArray.add("Tuesday");
        spinnerArray.add("Wednesday");
        spinnerArray.add("Thursday");
        spinnerArray.add("Friday");
        spinnerArray.add("Saturday");
        spinnerArray.add("Sunday");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.spinner);
        sItems.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecyclerViewer.class);

                intent.putExtra("dayNum", String.valueOf(editTextDay));

                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Dates dates;


                try{
                    String day = sItems.getSelectedItem().toString();
                    String dayNum = editTextDay.getText().toString();
                    String month = editTextMonth.getText().toString();
                    String time = editTextTime.getText().toString();


                    dates = new Dates(day, dayNum,  month, time);
                    recordedInfo.add(dates);

                }
                catch (Exception e){
                }

                Toast.makeText(getApplicationContext(),"Record Added", Toast.LENGTH_SHORT).show();
                editTextDay.setText("");
                editTextMonth.setText("");
                editTextTime.setText("");
                saveData();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

    }


    public ArrayList<Dates> retrieveData(){
        SharedPreferences sharedPref = getSharedPreferences(sharedPrefs, MODE_PRIVATE);
        String data = sharedPref.getString("list", "[]");
        recordedInfo.clear();
        if (data.length() == 2) return null;

        data = data.substring(1, data.length() - 1);
        String[] dateList = data.split(",");
        for (String date : dateList) {
            // recordedInfo.add(date.trim());
        }


        return recordedInfo;
    }

    public void saveData(){
        SharedPreferences sharedPref = getSharedPreferences(sharedPrefs, MODE_PRIVATE);
        SharedPreferences.Editor editor =  sharedPref.edit();

        editor.putString("list", recordedInfo.toString());
        editor.apply();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

        editTextDay.setText(editTextDay.getText().toString());
        editTextMonth.setText(editTextMonth.getText().toString());
        editTextTime.setText(editTextTime.getText().toString());

    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();

        editTextDay.getText().toString();
        editTextMonth.getText().toString();
        editTextTime.getText().toString();

    }


}



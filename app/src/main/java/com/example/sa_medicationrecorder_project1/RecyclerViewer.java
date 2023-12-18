package com.example.sa_medicationrecorder_project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class RecyclerViewer extends AppCompatActivity {



    RecyclerView recycler;
    private DateAdapter adapter;
    private ArrayList<Dates> datesArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recycler = findViewById(R.id.recyclerView);

        recycler.setLayoutManager(new LinearLayoutManager(this));
        datesArrayList = MainActivity.recordedInfo;

        adapter = new DateAdapter(this, datesArrayList);
        recycler.setAdapter(adapter);
        recycler.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

       //  createListData();

        Button buttonRemoveLast = findViewById(R.id.lastRemover);
        buttonRemoveLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (datesArrayList.size() == 0)
                    return;

                datesArrayList.remove(datesArrayList.size() - 1);

                adapter.setList(datesArrayList);
                Toast.makeText(getApplicationContext(),"Last Record Removed", Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();

            }
        });

        Button buttonClear = findViewById(R.id.removeAll);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (datesArrayList.size() == 0)
                    return;

                datesArrayList.clear();

                adapter.setList(datesArrayList);
                Toast.makeText(getApplicationContext(),"All Records Removed", Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();

            }
        });

        Button buttonMain = findViewById(R.id.returnMain);
        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecyclerViewer.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void createListData(){

        Dates dates = new Dates();
        for(int i = 0; i < datesArrayList.size(); i++) {
            datesArrayList.add(dates);
        }
    }
}



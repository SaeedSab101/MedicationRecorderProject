package com.example.sa_medicationrecorder_project1;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.DateHolder> {

    private Context context;
    private ArrayList<Dates> dates;

    public DateAdapter(Context context, ArrayList<Dates> dates){
        this.context = context;
        this.dates = dates;
    }

    public void setList(ArrayList<Dates> dates) {
        this.dates = dates;
    }

    @NonNull
    @Override
    public DateHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.date_layout,
                parent, false);
        return new DateHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DateAdapter.DateHolder holder, int position) {
        Dates date = dates.get(position);
        holder.SetDetails(date);
    }

    @Override
    public int getItemCount() {
        return dates.size();
    }

    class DateHolder extends RecyclerView.ViewHolder{
        private TextView textWeekDay, textDay, textTime, textMonth;

        public DateHolder(@NonNull View itemView){
            super(itemView);

            textWeekDay = itemView.findViewById(R.id.textWeekDay);
            textDay = itemView.findViewById(R.id.textDay);
            textMonth = itemView.findViewById(R.id.textMonth);
            textTime = itemView.findViewById(R.id.textTime);
        }

        void SetDetails(Dates dates){

            textWeekDay.setText("Day in week: " + dates.getDayNum());
            textDay.setText("Day: " + dates.getDay());
            textMonth.setText("Month: " + dates.getTime());
            textTime.setText("At: " + dates.getMonth());
        }
    }
}


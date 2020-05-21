package com.example.calendarex;

import androidx.annotation.Nullable;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Calendar;

public class CustomList<i> extends ArrayAdapter<String>  {
    MainActivity context;

    static ArrayList<String> arrDay = new ArrayList<>();
    static ArrayList<String> arrSchedule = new ArrayList<>();

    Calendar calendar = Calendar.getInstance();
    int startDayOfWeek;
    int lastDay;


    public CustomList(Context context, int year, int month) {
        super(context, R.layout.day, arrDay);
        this.context = (MainActivity)context;

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, 1);
        startDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        lastDay = calendar.getActualMaximum(Calendar.DATE);

        arrDay.clear();
        arrSchedule.clear();
        Log.d("pioella", startDayOfWeek + ", " + lastDay);
        int j = 0;
        for (int i=0 ; i < startDayOfWeek+lastDay-1 ; i++) {
            if (i < startDayOfWeek-1) {
                arrDay.add("");
                arrSchedule.add("");
            } else {
                arrDay.add(++j + "");
                arrSchedule.add("기념일");
            }
        }
        if (arrDay.size()%7 != 0) {
            for (int i = arrDay.size() % 7; i < 7; i++) {
                arrDay.add("");
                arrSchedule.add("");
            }
        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View rowView = layoutInflater.inflate(R.layout.day, null, true);
        TextView textViewDay = rowView.findViewById(R.id.textViewDay);
        TextView textViewSchedule = rowView.findViewById(R.id.textViewSchedule);
        textViewDay.setText(arrDay.get(position));
        switch (position % 7) {
            case 0:
                textViewDay.setTextColor(Color.RED);
                break;
            case 1: case 2: case 3: case 4: case 5:
                textViewDay.setTextColor(Color.BLACK);
                break;
            case 6:
                textViewDay.setTextColor(Color.BLUE);
                break;
        }

        textViewSchedule.setText(arrSchedule.get(position));
        return rowView;
    }
}

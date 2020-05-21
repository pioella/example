package com.example.calendarex;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    TextView textViewYearMonth;
    Button buttonPreviousMonth, buttonNextMonth;
    int year, month;
    CustomList adapter;
    LinearLayout layoutGrid;
    DatePicker datePicker;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewYearMonth = findViewById(R.id.textViewYearMonth);
        buttonPreviousMonth = findViewById(R.id.buttonPreviousMonth);
        buttonNextMonth = findViewById(R.id.buttonNextMonth);
        layoutGrid = findViewById(R.id.layoutGrid);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
    }

    @Override
    protected void onResume() {
        super.onResume();
        textViewYearMonth.setText(year + "년 " + month + "월");
        adapter = new CustomList(this, year, month);
        gridView = findViewById(R.id.gridView);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    public void onClickYearMonth(View view) {
        View dialogView = View.inflate(this, R.layout.dialog_year_month, null);
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        datePicker = dialogView.findViewById(R.id.datePicker);
        dlg.setTitle("년, 월을 선택하세요");
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setView(dialogView);
        dlg.setCancelable(false);  // 화면 밖 터치시 종료되지 않게 하기
        dlg.setNeutralButton("이번달", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH) + 1;
                onResume();
            }
        });
        dlg.setNegativeButton("입력", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                year = datePicker.getYear();
                month = datePicker.getMonth() + 1;
                onResume();
            }
        });
        dlg.setPositiveButton("취소", null);
        // NeutralButton 왼쪽, NegativeButton 오른쪽, PositiveButton 제일 오른쪽
        dlg.show();
    }

    public void onButtonPreviousMonth(View view) {
        month -= 1;
        if (month == 0) {
            year -= 1;
            month = 12;
        }
        onResume();
    }

    public void onButtonNextMonth(View view) {
        month += 1;
        if (month == 13) {
            year += 1;
            month = 1;
        }
        onResume();
    }
}

package com.example.dialogex;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String msg;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
    }

    public void onClickButton(View view) {
        View dialogView = View.inflate(this, R.layout.dialog, null);
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        editText = dialogView.findViewById(R.id.editText);
        dlg.setTitle("이름 입력");
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setView(dialogView);
        dlg.setCancelable(false);  // 화면 밖 터치시 종료되지 않게 하기
        dlg.setNeutralButton("Pioella", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textView.setText("Pioella");
            }
        });
        dlg.setNegativeButton("입력", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                msg = editText.getText().toString();

                textView.setText(msg);
            }
        });
        dlg.setPositiveButton("취소", null);
        // NeutralButton 왼쪽, NegativeButton 오른쪽, PositiveButton 제일 오른쪽
        dlg.show();
    }
}

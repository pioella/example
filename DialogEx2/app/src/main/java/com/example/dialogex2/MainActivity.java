package com.example.dialogex2;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String msg;
    TextView textView;
    Dialog dlg;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
    }

    public void onClickButton(View view) {
        dlg = new Dialog(this);
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dlg.setContentView(R.layout.custom_dialog);
        editText = dlg.findViewById(R.id.editText);
        dlg.show();
    }

    public void onClickBtnOK(View view) {
        msg = editText.getText().toString();
        Log.d("Pioella", "msg = " + msg);
        textView.setText(msg);
        dlg.dismiss();
    }

    public void onClickBtnCancel(View view) {
        textView.setText("");
        dlg.dismiss();
    }
}

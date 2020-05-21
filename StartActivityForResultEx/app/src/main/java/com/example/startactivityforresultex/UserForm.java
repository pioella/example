package com.example.startactivityforresultex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UserForm extends AppCompatActivity {
    EditText editID, editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_form);
    }

    public void onClickBtnInput(View view) {
        editID = findViewById(R.id.editID);
        editPassword = findViewById(R.id.editPassword);

        Intent intent = new Intent();
        intent.putExtra("id", editID.getText().toString());
        intent.putExtra("password", editPassword.getText().toString());

        setResult(RESULT_OK, intent);
        finish();
    }

    public void onClickBtnCancel(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
}

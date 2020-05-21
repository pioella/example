package com.example.startactivityex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), ResultActivity.class);
                in.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
//                Intent.FLAG_ACTIVITY_SINGLE_TOP
//                  : activity가 생성될 때 연속적으로 같은 activity가 쌓일경우 재사용, 재사용 Activity는 onPause(), onNewIntent(), onResume() 순으로 동작
//                Intent.FLAG_ACTIVITY_CLEAR_TOP
//                  : 기존의 activity가 있는 경우 기존의 activity를 호출하면서 그위의 activity를 모두 제거 onCreate()로 시작
//                Intent.FLAG_ACTIVITY_NEW_TASK
//                  : 새롭운 tast를 생성하여 그 안에 activity를 추가, FLAG_ACTIVITY_MULTIPLE_TASK 와 같이 사용하여야 적용된다.
//                Intent.FLAG_ACTIVITY_NO_HISTORY
//                  : intro 같은 다시 호출할 필요가 없는 activity의 경우 task에 남기지 않고 호출
//                Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
//                  : 호출하는 activity와 같은 activity가 있는 경우 제일 위로 올려서 onResume() 로 시작
                in.putExtra("text", editText.getText().toString());
                startActivity(in);
            }
        });
    }
}

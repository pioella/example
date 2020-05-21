package com.example.menuex;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menuLoad:
                Log.d("Pioella", "불러오기 메뉴 선택");
                loadFile();
                break;
            case R.id.menuSave:
                Log.d("Pioella", "저장하기 메뉴 선택");
                saveFile();
                break;
            case R.id.meneExit:
                Log.d("Pioella", "나가기 메뉴 선택");
                finish();
                break;
        }
        return true;
    }

    public void loadFile() {
        Toast.makeText(getApplicationContext(), "불러오기 메뉴 클릭", Toast.LENGTH_SHORT).show();
    }

    public void saveFile() {
        Toast.makeText(getApplicationContext(), "저장하기 메뉴 클릭", Toast.LENGTH_SHORT).show();
    }
}

package com.example.menuex2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
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
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "위성 지도");
        menu.add(0, 2, 0, "일반 지도");
        SubMenu subMenu = menu.addSubMenu("유명장소 가기>>");
        subMenu.addSubMenu(0,3,0,"정동진");
        subMenu.addSubMenu(0,4,0,"해운대");
        subMenu.addSubMenu(0,5,0,"땅끝마을");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Toast.makeText(getApplicationContext(), "위성사진", Toast.LENGTH_SHORT).show();
                return true;
            case 2:
                Toast.makeText(getApplicationContext(), "일반사진", Toast.LENGTH_SHORT).show();
                return true;
            case 3:
                Toast.makeText(getApplicationContext(), "정동진", Toast.LENGTH_SHORT).show();
                return true;
            case 4:
                Toast.makeText(getApplicationContext(), "해운대", Toast.LENGTH_SHORT).show();
                return true;
            case 5:
                Toast.makeText(getApplicationContext(), "땅끝마을", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }
}

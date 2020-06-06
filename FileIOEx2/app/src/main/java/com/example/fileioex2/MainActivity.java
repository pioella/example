package com.example.fileioex2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    static final String CAPTURE_PATH = "/myfolder";
    static final String FILENAME = "text.txt";
    EditText editText;
    TextView fileView;
    int permissionCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 앱 설치시 외부저장소(공용영역) 쓰기를 위해서는 권한을 허용받아야 한다.
        // 권한을 허용하면 외부 폴더에 저장내고 권한을 허용하지 않으면 앱내의 외부저장소에 저장하는 앱을 만들어 보자.
        // AndroidManifest.xml 에 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/> 문구 추가
        // API 29(안드로이드 10)버전부터는 AndroidManifest.xml application 영역에 android:requestLegacyExternalStorage="true" 문구추가 필요(정책변경으로 인한 한시적 유예)
        // 위 문구를 넣지 않으면 폴더가 생성이 되지 않음. 이미 존재하는 폴더를 지정하면 저장됨
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        // 1번 방법
        permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        editText = findViewById(R.id.editText);
        fileView = findViewById(R.id.fileView);
    }

    // 2번 방법
    private boolean checkPermission() {
        int permissionState = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return permissionState == PackageManager.PERMISSION_GRANTED;
    }

    // 2가지 방법 중 하나를 선택해서 하자.

    public void writeFile(View view) {
        // 1번 방법
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            extStorageWrite(view);
            Toast.makeText(getApplicationContext(), "파일이 myFolder 폴더 안에 저장되었습니다.", Toast.LENGTH_SHORT).show();
        } else {
            extFileWrite(view);
            Toast.makeText(getApplicationContext(), "권한이 허용되지 않아 앱 고유영역에 저장되었습니다.", Toast.LENGTH_SHORT).show();
        }
    }

    public void readFile(View view) {
//        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
        // 2번 방법
        if(checkPermission()) {
            extStorageRead(view);
            Toast.makeText(getApplicationContext(), "myFolder 폴더 안에 파일을 불러왔습니다.", Toast.LENGTH_SHORT).show();
        } else {
            extFileRead(view);
            Toast.makeText(getApplicationContext(), "권한이 허용되지 않아 앱 고유영역에서 불러왔습니다.", Toast.LENGTH_SHORT).show();
        }
    }

    //외부 저장소(앱 고유 영역)에 쓰기. /sdcard/Android/data/[패키지명]/files/ 에 저장
    public void extFileWrite(View v) {
        File file = new File(getExternalFilesDir(null),FILENAME);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(editText.getText().toString().getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void extFileRead(View v) {
        File file = new File(getExternalFilesDir(null), FILENAME);
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] buf = new byte[fis.available()];
            fis.read(buf);
            fileView.setText(new String(buf));
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 외부 저장소(공용 영역)에 쓰기. /sdcard/myfolder
    public void extStorageWrite(View v) {
        String strFolderPath = Environment.getExternalStorageDirectory().getAbsolutePath() + CAPTURE_PATH;  // API 29 에는 지원을 하지 않음
        File folder = new File(strFolderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String strFIlePath = strFolderPath + "/" + FILENAME;
        File file = new File(strFIlePath);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(editText.getText().toString().getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void extStorageRead(View v) {
        String strFolderPath = Environment.getExternalStorageDirectory().getAbsolutePath() + CAPTURE_PATH;
        String strFIlePath = strFolderPath + "/" + FILENAME;
        File file = new File(strFIlePath);
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] buf = new byte[fis.available()];
            fis.read(buf);
            fileView.setText(new String(buf));
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.example.fileioex;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    static final String CAPTURE_PATH = "/myfolder";
    static final String FILENAME = "text.txt";
    EditText editText;
    TextView fileView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        fileView = findViewById(R.id.fileView);

        // 앱 설치시 외부저장소(공용영역) 쓰기를 위해서는 권한을 허용받아야 한다.
        // AndroidManifest.xml 에 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/> 문구 추가
        // API 29(안드로이드 10)버전부터는 AndroidManifest.xml application 영역에 android:requestLegacyExternalStorage="true" 문구추가 필요(정책변경으로 인한 한시적 유예)
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
    }

    // 내부 저장소에 쓰기. FileOutputStream 객체를 반환하는 openFileOutput 메소드를 사용한다. /data/data/[패키지명]/files/에 저장
    public void intFileWrite(View v) {
        File file = new File(getFilesDir(), FILENAME);
        try {
//            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);  //MODE_PRIVATE 덮어쓰기, MODE_APPEND 이어쓰기
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(editText.getText().toString().getBytes());  //getText() 메소드는 CharSequence, Spannable 인터페이스를 구현하는 Editable 객체를 반환한다. 텍스트 뿐만 아니라 이미지 링크 등도 값으로 가질 수 있다.
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 내장메모리에 읽기. FileInputStream 객체를 반환하는 openFileInput 메소드를 사용한다.
    public void intFileRead(View v) {
        File file = new File(getFilesDir(), FILENAME);
        try {
//            FileInputStream fis = openFileInput(FILENAME);  // 1번.
            FileInputStream fis = new FileInputStream(file);      // 2번. 2가지 형태 다 가능
            byte[] buf = new byte[fis.available()];
            fis.read(buf);
            fileView.setText(new String(buf));
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
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

    // raw 폴더는 프로젝트에 포함된 폴더이기 때문에 읽기만 가능하고 쓰기는 불가능. FileInputStream 대신에 InputStream 클래스를 사용한다.
    public void rawFileRead(View v) {
        InputStream is = getResources().openRawResource(R.raw.data);
        try {
            byte[] buf = new byte[is.available()];
            is.read(buf);
            fileView.setText(new String(buf));
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

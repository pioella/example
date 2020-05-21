package com.example.sqliteex;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabase;
    MyDBHelper myDBHelper;
    EditText editID, editPassword;
    TextView textID, textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDBHelper = new MyDBHelper(this);

        editID = findViewById(R.id.editID);
        editPassword = findViewById(R.id.editPassword);
        textID = findViewById(R.id.textID);
        textPassword = findViewById(R.id.textPassword);

    }

    public class MyDBHelper extends SQLiteOpenHelper {

        public MyDBHelper(Context context) {
            super(context, "memberDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table memberTBL (ID char(20) primary key, password char(20))");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists memberTBL");
            onCreate(db);
        }
    }

    public void onClickBtnInit(View view) {
        sqLiteDatabase = myDBHelper.getWritableDatabase();
        myDBHelper.onUpgrade(sqLiteDatabase, 1, 2);
    }

    public void onClickBtnInsert(View view) {
        sqLiteDatabase = myDBHelper.getWritableDatabase();
        String sql = String.format("insert into memberTBL values ('%s', '%s')",
                editID.getText().toString().trim(), editPassword.getText().toString().trim());
        try {
            sqLiteDatabase.execSQL(sql);
            sqLiteDatabase.close();
            onClickBtnSelect(view);
            Toast.makeText(getApplicationContext(), "데이터 입력됨!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "데이터 입력 오류!", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickBtnUpdate(View view) {
        sqLiteDatabase = myDBHelper.getWritableDatabase();
        if (editID.getText().toString() != "") {
            String sql = String.format("update memberTBL set password = '%s' where ID='%s'",
                    editPassword.getText().toString().trim(), editID.getText().toString().trim());
            sqLiteDatabase.execSQL(sql);
        }
        sqLiteDatabase.close();
        onClickBtnSelect(view);
        Toast.makeText(getApplicationContext(), "데이터가 수정됨!", Toast.LENGTH_SHORT).show();
    }

    public void onClickBtnDelete(View view) {
        sqLiteDatabase = myDBHelper.getWritableDatabase();
        if (editID.getText().toString() != "") {
            String sql = String.format("delete from memberTBL where ID='%s'",
                    editID.getText().toString());
            sqLiteDatabase.execSQL(sql);
        }
        sqLiteDatabase.close();
        onClickBtnSelect(view);
        Toast.makeText(getApplicationContext(), "데이터가 삭제됨!", Toast.LENGTH_SHORT).show();
    }

    public void onClickBtnSelect(View view) {
        sqLiteDatabase = myDBHelper.getWritableDatabase();
        String strID = "ID\r\n" + "--------------\r\n";
        String strPassword = "Password\r\n" + "--------------\r\n";

        Cursor cursor = sqLiteDatabase.rawQuery("select * from memberTBL", null);
        // void execSQL(String sql) - DB 내용을 바꿈. / Cursor rawQuery(String sql) DB 내용은 바꾸지 않고 정보만 가져옴.

        while (cursor.moveToNext()) {
            strID += cursor.getString(0) + "\r\n";
            strPassword += cursor.getString(1) + "\r\n";
        }
        textID.setText(strID);
        textPassword.setText(strPassword);
        cursor.close();
        sqLiteDatabase.close();
    }
}

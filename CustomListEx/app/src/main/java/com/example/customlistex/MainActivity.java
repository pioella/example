package com.example.customlistex;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    static String[] arrTitle = {
            "써니 (2011년)",
            "완득이 (2011년)",
            "괴물 (2006년)",
            "라디오스타 (2006년)",
            "비열한 거리 (2006년)",
            "왕의 남자 (2005년)",
            "아일랜드 (2005년)",
            "웰컴 투 동막골 (2005년)",
            "헬보이 (2004년)",
            "백 투 더 퓨쳐 (1985년)",
    };

    static Integer[] image = {
            R.drawable.mov01,
            R.drawable.mov02,
            R.drawable.mov03,
            R.drawable.mov04,
            R.drawable.mov05,
            R.drawable.mov06,
            R.drawable.mov07,
            R.drawable.mov08,
            R.drawable.mov09,
            R.drawable.mov10,
    };

    static String[] rating = {"9.11", "8.78", "8.62", "9.20", "8.79", "9.03", "8.81", "8.90", "7.05", "9.39"};
    static String[] genre = {"드라마", "드라마", "스릴러", "드라마", "느와르", "드라마", "SF", "드라마", "SF", "SF"};
    static int[] year = {2011, 2011, 2006, 2006, 2006, 2005, 2005, 2005, 2004, 1985};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomList adapter = new CustomList(this);
        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), arrTitle[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}

// 수업 때는 CustomList 클래스를 메인엑티비티 안에 집어 넣어서 static 이나 MainActivity. 등을 쓰지 않음.
// 나중에 다시 각각의 클래스를 쪼개서 코딩해보자.
class CustomList extends ArrayAdapter<String> {
    MainActivity context;

    public CustomList(Context context) {
        super(context, R.layout.list_item, MainActivity.arrTitle);
        this.context = (MainActivity)context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View rowView = layoutInflater.inflate(R.layout.list_item, null, true);
        ImageView imageView = rowView.findViewById(R.id.imageView);
        TextView title = rowView.findViewById(R.id.title);
        TextView rating = rowView.findViewById(R.id.rating);
        TextView genre = rowView.findViewById(R.id.genre);
        TextView year = rowView.findViewById(R.id.year);
        title.setText(MainActivity.arrTitle[position]);
        imageView.setImageResource(MainActivity.image[position]);
        rating.setText("평점 : " + MainActivity.rating[position]);
        genre.setText("장르 : " + MainActivity.genre[position]);
        year.setText(MainActivity.year[position] + "년도 작품");

        return rowView;
    }
}



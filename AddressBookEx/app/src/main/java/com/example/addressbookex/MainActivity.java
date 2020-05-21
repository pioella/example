package com.example.addressbookex;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView textViewHomePage;
    ListView listViewAddressBook;
    MemberList memberList = new MemberList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewHomePage = findViewById(R.id.textViewHomePage);
        listViewAddressBook = findViewById(R.id.listViewAddressBook);

        CustomList adapter = new CustomList(this);
        listViewAddressBook.setAdapter(adapter);
        listViewAddressBook.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentTel = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:" + memberList.getMembers()[position][1]));
                startActivity(intentTel);
            }
        });

    }

    public void onClickHomePage(View view) {
        Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("http://naver.com"));
        startActivity(intentWeb);
    }

    class CustomList extends ArrayAdapter<String> {
        MainActivity context;

        public CustomList(Context context) {
            super(context, R.layout.list_item, memberList.getCountNumber());
            this.context = (MainActivity)context;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            View rowView = layoutInflater.inflate(R.layout.list_item, null, true);
            TextView textViewName = rowView.findViewById(R.id.textViewName);
            TextView textViewPhone = rowView.findViewById(R.id.textViewPhone);
            TextView textVIewAddress = rowView.findViewById(R.id.textViewAdress);
            textViewName.setText(memberList.getMembers()[position][0]);
            textViewPhone.setText(memberList.getMembers()[position][1]);
            textVIewAddress.setText(memberList.getMembers()[position][2]);

            return rowView;
        }
    }

}


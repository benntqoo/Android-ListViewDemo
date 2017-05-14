package com.demo.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListAdapterListView extends AppCompatActivity {
    String[] languageList = {"Android", "Java", "Swift", "C", "C++", "C#", "Python", "Delphi", "go", "JavaScript", "R",
            "PHP", "Ruby", "Matlab", "perl"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_adapter_list_view);
        ListView listView = (ListView) findViewById(R.id.listAdapterListView);

//        String[] list =getResources().getStringArray(R.array.list); //取得String.xml 中的 array


        ListAdapter listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                languageList);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String language;
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                language =textView.getText().toString();
                Toast.makeText(ListAdapterListView.this, "position=" + position + " Language:" + language, Toast
                        .LENGTH_SHORT)
                        .show();
            }
        });
    }
}

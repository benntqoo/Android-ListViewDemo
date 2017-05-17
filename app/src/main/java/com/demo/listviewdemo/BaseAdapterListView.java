package com.demo.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.demo.listviewdemo.Adapter.MyBaseAdapter;

public class BaseAdapterListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter_list_view);
        setTitle("BaseAdapterListView");

        String[] strs = getResources().getStringArray(R.array.list);
        ListView listView = (ListView) findViewById(R.id.lv_BaseAdapterListView);
        MyBaseAdapter adapter = new MyBaseAdapter(this,strs);
        listView.setAdapter(adapter);
        adapter.getItem(0);

    }
}

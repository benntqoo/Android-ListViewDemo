package com.demo.listviewdemo;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HeaderFooterListView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header_footer_list_view);
        setTitle("ListView Header Footer");

        ListView listView = (ListView) findViewById(R.id.lv_HeaderFooterListView);

        final String[] listItem = getResources().getStringArray(R.array.list);
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, listItem);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemStr = "";
                if (position != 0 && position <= listItem.length) {
                    itemStr = listItem[position-1];
                }
                Toast.makeText(HeaderFooterListView.this, "position=" + position + " item=" + itemStr, Toast
                        .LENGTH_SHORT)
                        .show();
            }
        });


        View header = LayoutInflater.from(this).inflate(R.layout.list_view_header, null);
        listView.addHeaderView(header);

        View footer = LayoutInflater.from(this).inflate(R.layout.list_view_header, null);
        TextView textView = (TextView) footer.findViewById(R.id.tv_Title);
        textView.setText("Footer");
        RelativeLayout relativeLayout = (RelativeLayout) footer.findViewById(R.id.rl_HeaderFooter);
        relativeLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        listView.addFooterView(footer);
        Toast.makeText(HeaderFooterListView.this, "list length=" + listItem.length, Toast.LENGTH_SHORT).show();

        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }
}

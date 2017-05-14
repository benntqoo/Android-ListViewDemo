package com.demo.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ExpendListView extends AppCompatActivity {
    private List<Map<String, String>> groupList;
    private List<List<Map<String, String>>> childList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expend_list_view);

        groupList = new ArrayList<>();
        childList = new ArrayList<>();
        initData("動物", new String[]{"狗", "貓", "豬", "鳥"});
        initData("植物", new String[]{"玫瑰", "向日葵", "含羞草", "喇叭花"});
        initData("魚類", new String[]{"虱目魚", "大肚魚", "孔雀魚", "吳郭魚"});

        SimpleExpandableListAdapter simpleExpandableListAdapter = new SimpleExpandableListAdapter(this,
                groupList,
                android.R.layout.simple_expandable_list_item_1,
                new String[]{"groupName"},
                new int[]{android.R.id.text1},
                childList,
                android.R.layout.simple_expandable_list_item_2,
                new String[]{"childName"},
                new int[]{android.R.id.text2});

        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListView.setAdapter(simpleExpandableListAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long
                    id) {
                TextView childItem = (TextView) v.findViewById(android.R.id.text2);
                String childStr =childItem.getText().toString();
                Toast.makeText(ExpendListView.this,"child position="+childPosition+" child="+childStr , Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }

    private void initData(String title, String[] child) {
        Map<String, String> GroupItem = new HashMap<String, String>();
        GroupItem.put("groupName", title);
        groupList.add(GroupItem);

        List<Map<String, String> > childItem = new ArrayList<>();

        for (int index = 0; index < child.length; index++) {
            Map<String,String> childMapItem = new HashMap<String,String>();
            childMapItem.put("childName",child[index]);
            childItem.add(childMapItem);
        }

        childList.add(childItem);
    }
}

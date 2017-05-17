package com.demo.listviewdemo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.listviewdemo.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Jrtou on 2017/5/17.
 */

public class MyBaseAdapter extends BaseAdapter {
    private List<String> mList;
    private LayoutInflater mLayoutInflater;

    public MyBaseAdapter(Context context, String[] list) {
        this.mLayoutInflater = LayoutInflater.from(context);
        mList = Arrays.asList(list);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (null == convertView) {
            convertView = mLayoutInflater.inflate(R.layout.base_adapter_item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.ivItem = (ImageView) convertView.findViewById(R.id.iv_BaseItem);
            viewHolder.tvItem = (TextView) convertView.findViewById(R.id.tv_BaseItem);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvItem.setText(mList.get(position));
        if (position % 2 == 0) {
            viewHolder.ivItem.setImageResource(R.mipmap.ic_car);
        } else {
            viewHolder.ivItem.setImageResource(R.mipmap.ic_launcher);
        }
        return convertView;
    }

    class ViewHolder {
        TextView tvItem;
        ImageView ivItem;
    }
}

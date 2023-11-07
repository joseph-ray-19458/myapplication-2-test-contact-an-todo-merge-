package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CustomStringAdapter extends ArrayAdapter {

//    private static final TAG ="Coustom String Adaptr";
    private Context context;
    private int resource;
    private ArrayList<String> list;

    public CustomStringAdapter(Context context,int resource, ArrayList<String> list) {
        super(context,resource,list);
        this.context = context;
        this.resource = resource;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

//    @SuppressLint("ViewHolder")
    @NotNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            convertView = LayoutInflater.from(context).inflate(R.layout.todos_layout, parent, false);
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(resource,parent,false);
            ((TextView)convertView.findViewById(R.id.todoTextView)).setText(list.get(position) );

            ((ImageButton)convertView.findViewById(R.id.taskDeleteBtn)).setId(position);
            ((ImageButton)convertView.findViewById(R.id.taskUpdateBtn)).setId(position);

        }catch (Exception e){
            e.printStackTrace();
        }
//
        return convertView;
    }
    public void createNew(String item) {
        list.add(item);
        notifyDataSetChanged();
    }

    public void remove(int position) {
        list.remove(position);
        notifyDataSetChanged();
    }

    public void update(int position, String item) {
        list.set(position, item);
        notifyDataSetChanged();
    }

    private class ViewHolder {
        TextView textView;
    }
}

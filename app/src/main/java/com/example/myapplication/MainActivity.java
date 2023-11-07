package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ComponentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    private ArrayList<String> tasks = new ArrayList<String>();
    ListView tl ;
//    ArrayAdapter<String> arrayAdapterTaskList;
    CustomStringAdapter customStringAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasks.add("first Todo") ;
        tasks.add("Second Todo") ;
        tasks.add("Third Todo") ;

        customStringAdapter = new CustomStringAdapter(MainActivity.this,R.layout.todos_layout,tasks);
//        arrayAdapterTaskList = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,tasks);
        tl = findViewById(R.id.taskList);

        tl.setAdapter(customStringAdapter);

//        tl.setOnItemClickListener(this);
    }
    public  void  deleteTodo(View V){
        String val ;
        val = Integer.toString(((ImageButton)V).getId());
        Toast.makeText(this,val,Toast.LENGTH_SHORT).show();
        customStringAdapter.remove(((ImageButton)V).getId());
    }
    public  void  createTodo(View V){

        Toast.makeText(this,"created",Toast.LENGTH_SHORT).show();
        customStringAdapter.createNew(((TextView)findViewById(R.id.taskInput)).getText().toString());
        ((TextView)findViewById(R.id.taskInput)).setText("");

    }
    public void updateTodo(View V){
//        Log.d("testing","Calling"+i+"  "+arrayAdapterTaskList.getItem(i).toString());
        int reqCode = 10;
        Intent intent = new Intent(this,taskFullPageViewActivity.class);
        intent.putExtra("SelectedTask",((ImageButton)V).getId());
        startActivity(intent);
    }

//    public  void createNew(View V){
//        String value = ((TextView)findViewById(R.id.taskInput)).getText().toString();
////        tasks.add(value);
////        customStringAdapter.add(value);
////        ArrayAdapter<ArrayList> arrayAdapterTaskList =
////                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,(ArrayList) tasks);
////        tl.setAdapter(arrayAdapterTaskList);
//    }
//
//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////        Log.d("testing","Calling"+i+"  "+arrayAdapterTaskList.getItem(i).toString());
////        Intent intent = new Intent(this,taskFullPageViewActivity.class);
////        intent.putExtra("SelectedTask",arrayAdapterTaskList.getItem(i));
////        startActivity(intent);
//
//    }
}
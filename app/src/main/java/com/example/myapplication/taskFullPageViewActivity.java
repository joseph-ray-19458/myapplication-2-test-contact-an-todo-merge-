package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class taskFullPageViewActivity extends AppCompatActivity {
    EditText ed;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_full_page_view);

        Intent intent = getIntent();
        int selectedTask = Integer.parseInt(intent.getStringExtra("SelectedTask"));
        Log.d("testing","Calling task Activity"+"  "+selectedTask);
//        ((TextView) findViewById(R.id.taskViewTittle)).setText(selectedTask);
        ed =findViewById(R.id.updatedText);
//        ed.setText();

    }
}
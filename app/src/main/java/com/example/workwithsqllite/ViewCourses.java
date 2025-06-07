package com.example.workwithsqllite;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewCourses extends AppCompatActivity {

    //khai bao bien tong
    ArrayList<CourseModal> courseModalArrayList;
    DBHandler handler;
    CourseRVAdapter courseRVAdapter;
    RecyclerView courseRV;
    Button buttontrove;
    @Override
    protected  void onCreate(Bundle saveIdStanceState){
        super.onCreate(saveIdStanceState);
        setContentView(R.layout.activity_view_courses);

        //anh xa
        courseModalArrayList = new ArrayList<>();
        handler = new DBHandler(ViewCourses.this);
        courseModalArrayList = handler.doccourse();
        courseRVAdapter = new CourseRVAdapter(courseModalArrayList, ViewCourses.this);
        courseRV = findViewById(R.id.RVC);
        buttontrove =findViewById(R.id.buttontrove);

        //setting
        LinearLayoutManager linnear = new LinearLayoutManager(ViewCourses.this, RecyclerView.VERTICAL, false);
        courseRV.setLayoutManager(linnear);
        courseRV.setAdapter(courseRVAdapter);
        buttontrove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

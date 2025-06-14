package com.example.workwithsqllite;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateCourseActivity extends AppCompatActivity {
    //khai bao
    EditText etten, etlink;
    Button btntupdate, btdelete;
    DBHandler db;
    String cten, clink;
    int cid;
    @Override
    protected void onCreate(Bundle saveIdStanceState){
        super.onCreate(saveIdStanceState);
        setContentView(R.layout.activity_update_course);

        //anh xa
        etten = findViewById(R.id.etten);
        etlink = findViewById(R.id.etlink);
        btntupdate = findViewById(R.id.btntupdate);
        btdelete = findViewById(R.id.btdelete);
        //tao bang
        db = new DBHandler(UpdateCourseActivity.this);

        //lay intent

        cten = getIntent().getStringExtra("ten");
        clink =getIntent().getStringExtra("link");

        //lay data
        etten.setText(cten);
        etlink.setText(clink);
        //su kien click chinh sua
        btntupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //thay data trong bang
                db.updateCourse(cten,etten.getText().toString(),etlink.getText().toString());
                //thong bao
                Toast.makeText(UpdateCourseActivity.this, "Update thanh cong", Toast.LENGTH_SHORT).show();
                //tro ve trang xem hinh
                Intent i = new Intent(UpdateCourseActivity.this, ViewCourses.class);
                startActivity(i);
                //finish();
            }
        });
        //su kien click xoa anh
        btdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteCourse(cten);
                Toast.makeText(UpdateCourseActivity.this, "Xoa thanh cong", Toast.LENGTH_SHORT).show();
                //tro ve trang xem hinh
                Intent i = new Intent(UpdateCourseActivity.this, ViewCourses.class);
                startActivity(i);
            }
        });
    }
}

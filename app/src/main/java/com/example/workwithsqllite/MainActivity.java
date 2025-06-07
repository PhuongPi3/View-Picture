package com.example.workwithsqllite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //khai bao bien tong
    EditText etten, etlink;
    Button Btnthemanh, btntxemanh;
    DBHandler Handler;

    //ham chinh
    @Override
    protected  void onCreate (Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        //anh xa
        etten = findViewById(R.id.etten);
        etlink = findViewById(R.id.etlink);
        Btnthemanh = findViewById(R.id.Btnthemanh);
        btntxemanh = findViewById(R.id.btntxemanh);
        //tao lop dbhander moi, de luu du lieu
        Handler = new DBHandler(MainActivity.this);

        //su kien click
        Btnthemanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //truyen du lieu
                String coursten = etten.getText().toString();
                String courelink = etlink.getText().toString();

                //kiemtra
                if(coursten.isEmpty() && courelink.isEmpty()){
                    Toast.makeText(MainActivity.this, "Hay nhap data", Toast.LENGTH_SHORT).show();
                    return;
                }
                //luu du lieu
                Handler.addNewCourse(coursten, courelink);

                //thong bao luu thanh cong
                Toast.makeText(MainActivity.this, "Luu du lieu thanh cong", Toast.LENGTH_SHORT).show();
                etten.setText("");
                etlink.setText("");
            }
        });

        //doc data
        btntxemanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tao intent (them trang moi)
                Intent i = new Intent(MainActivity.this, ViewCourses.class);
                //khoi tao acti moi
                startActivity(i);
            }
        });
        }
    }




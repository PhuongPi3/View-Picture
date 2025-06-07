package com.example.workwithsqllite;
//thu vien

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    //khai bao bang
    //ten file
    static final String DB_ten = "db";
    //phien ban
    static final int DB_phienban =1;
    //ten bang
    static final  String ten_table = "courses";
    //id cot
    static final String id_cot = "id";
    //ten cot
    static final  String ten_cot = "ten";
    //link
    static final  String link = "link";

    public DBHandler(Context con){
        super(con, DB_ten, null, DB_phienban);
    }

    //tao bang o sqlite
    @Override
    public  void  onCreate(SQLiteDatabase db){
        String query = "CREATE TABLE " + ten_table + " (" +
                id_cot + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ten_cot + " TEXT, " +
                link + " TEXT)";

        db.execSQL(query);
    }

    //ham con them thong tin
    public  void  addNewCourse (String coursten, String courelink){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        //them thong tin
        values.put(ten_cot, coursten);
        values.put(link, courelink);

        db.insert(ten_table, null, values);
        db.close();
    }
    @Override
    public  void onUpgrade(SQLiteDatabase db, int oldVerson, int newVersion){
        //kiem tra neu bang da ton tai hay chua
        db.execSQL("DROP TABLE If EXISTS " +ten_table);
        onCreate(db);
    }

    //tao arraylist
    ArrayList<CourseModal> doccourse(){
        //doc database
        SQLiteDatabase db = this.getReadableDatabase();

        //tao cursor, bang du lieu
        Cursor cursorCourse = db.rawQuery("Select * from " + ten_table, null);
        //tao array list moi
        ArrayList<CourseModal> courseModalArrayList = new ArrayList<>();

        //di chuyen toi diem dau
        if (cursorCourse.moveToFirst()){
            do {
                //them data
                courseModalArrayList.add(new CourseModal(
                        cursorCourse.getString(1),
                        cursorCourse.getString(2)));
            }while (cursorCourse.moveToNext());
        }
        cursorCourse.close();
        return courseModalArrayList;
    }
}

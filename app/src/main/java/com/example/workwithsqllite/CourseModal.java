package com.example.workwithsqllite;

public class CourseModal {
    //khai bao bien tong
    String courseten, courselink;
    int id;

    //dong goi code
    String getCourseten(){return courseten;}
    void setCourseten(String courseten){this.courseten = courseten;}
    String getCourselink(){return courselink;}
    void  setCourselink(String courselink){this.courselink =courselink; }
    int getId (){return  id;}
    void setId(int id){this.id = id;}

    public CourseModal(String courseten, String courselink){
        this.courseten =courseten;
        this.courselink = courselink;
    }

}

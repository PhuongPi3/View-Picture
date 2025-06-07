package com.example.workwithsqllite;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class CourseRVAdapter extends RecyclerView.Adapter<CourseRVAdapter.ViewHolder> {

    //khai bao bien
    ArrayList<CourseModal> courseModalArrayList;
    Context con;

    //phuong thuc
    CourseRVAdapter(ArrayList<CourseModal> courseModalArrayList, Context con){
        this.courseModalArrayList = courseModalArrayList;
        this.con = con;
    }
    //ham con
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //lay khung
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_rv_item, parent, false);
        return new ViewHolder(v);
    }
    //ham con
    @Override
    public void onBindViewHolder(@NonNull CourseRVAdapter.ViewHolder holder, int position) {
        //nhap data
        CourseModal mo = courseModalArrayList.get(position);
        holder.coursetentv.setText(mo.getCourseten());
        Glide.with(con)
                        .load(mo.getCourselink())
                        .into(holder.courselinktv);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tao intent
                Intent i = new Intent(con, UpdateCourseActivity.class);

                //day thong tin len
                i.putExtra("ten", mo.getCourseten() );
                i.putExtra("link",mo.getCourselink());
                con.startActivity(i);
            }
        });
    }
    //ham con
    @Override
    public int getItemCount() {
        return courseModalArrayList.size();
    }
    //ham con
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView coursetentv;
        ImageView courselinktv;
        ViewHolder(@NonNull View itemView){
            super(itemView);
            //anh xa
            coursetentv = itemView.findViewById(R.id.etten);
            courselinktv = itemView.findViewById(R.id.etlink);
        }
    }

}

package com.example.deepa.optionmenu.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.deepa.optionmenu.R;
import com.example.deepa.optionmenu.model.Student;
import com.example.deepa.optionmenu.MainActivity;

import java.util.ArrayList;



public class StudentAdapter extends BaseAdapter {

    ArrayList<Student> mArrayList;
    LayoutInflater mLayoutInflater;

    public StudentAdapter(Context context, ArrayList<Student> mArrayList) {
        this.mArrayList=mArrayList;
        this.mLayoutInflater=LayoutInflater.from(context);
    }



    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView=mLayoutInflater.inflate(R.layout.customlistview,parent,false);

        Student student= (Student)getItem(position);

        TextView name=(TextView)convertView.findViewById(R.id.name);
        TextView phone1=(TextView)convertView.findViewById(R.id.phone);

        name.setText(student.getName());

        phone1.setText(String.valueOf(student.getPhone()));

        return convertView;
    }
}

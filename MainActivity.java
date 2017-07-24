package com.example.deepa.optionmenu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.TextView;

import com.example.deepa.optionmenu.adapters.StudentAdapter;
import com.example.deepa.optionmenu.model.Student;

import java.util.ArrayList;

import static com.example.deepa.optionmenu.R.id.phone;

public class MainActivity extends AppCompatActivity {
    String Phone;
    ListView lv;
    String name1, name2, name3, name4, name5, name6, name7,
            phone1, phone2, phone3, phone4, phone5, phone6, phone7;

    ArrayList<Student> mArrayList;
    StudentAdapter mStudentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listview);  //lv.setOnItemClickListener(this);

        //lv.setOnClickListener(this);

        mArrayList = new ArrayList<>();

        mArrayList.add(new Student("Anu", "9876543211"));
        mArrayList.add(new Student("Banu", "9812345678"));
        mArrayList.add(new Student("Cisha", "9778987987"));
        mArrayList.add(new Student("Esha", "9167876434"));
        mArrayList.add(new Student("Ben", "9765432145"));
        mArrayList.add(new Student("Pooja", "9765432134"));
        mArrayList.add(new Student("Gita", "9876543212"));

        mStudentAdapter = new StudentAdapter(this, mArrayList);
        lv.setAdapter(mStudentAdapter);


        registerForContextMenu(lv);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String name = ((TextView) view.findViewById(R.id.name)).getText().toString();
                Toast.makeText(getApplicationContext(), "name: " + name, Toast.LENGTH_SHORT).show();


                Phone = ((TextView) view.findViewById(phone)).getText().toString();
                Toast.makeText(getApplicationContext(), "Phone: " + Phone, Toast.LENGTH_SHORT).show();


            }
        });


    }

    //lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.call:
                Phone = ((TextView) findViewById(phone)).getText().toString();
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "CALL ", Toast.LENGTH_SHORT).show();

                return true;
            case R.id.sms:

                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.putExtra("sms_body", "default content");
                sendIntent.setType("vnd.android-dir/mms-sms");
                startActivity(sendIntent);
                Toast.makeText(getApplicationContext(), "SMS ", Toast.LENGTH_SHORT).show();

                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


   // @Override
    //public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


package com.example.admin;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class showone_ extends AppCompatActivity {

    ListView lv;
    database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showone_);
        db=new database(this);
        lv=findViewById(R.id.liviid);
        ArrayList<String> arrl=new ArrayList<>();
        ArrayAdapter<String> arrad;
        Cursor c=db.get_onedata(getIntent().getStringExtra("usn"));
        arrl.add("ID: "+c.getString(0)+"\nUserName: "+c.getString(1)+"\nPassword: "+
                c.getString(2)+"\nProject Name: "+c.getString(3)+"\nProject Specialization: "+
                c.getString(4)+"\nProject Budget: "+c.getString(5));
        arrad =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,arrl);
        lv.setAdapter(arrad);

    }
}

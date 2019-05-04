package com.example.admin;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class update_s extends AppCompatActivity {

    EditText un;
    database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_s);
        db=new database(this);
        un=findViewById(R.id.usnid);
    }

    public void select(View v){
        if (un.getText().toString().equals("")){
            Toast.makeText(this,"Empty Username",Toast.LENGTH_LONG).show();
        }else {
            Cursor c=db.get_alldata();
            while (c.moveToNext()){
                if (un.getText().toString().equals(c.getString(1))){
                    Intent intent=new Intent(this,update_.class);
                    intent.putExtra("un",un.getText().toString());
                    startActivity(intent);
                }
            }
            Toast.makeText(this,"Not Found",Toast.LENGTH_LONG).show();
        }
    }
}

package com.example.admin;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usn,pas;
    database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usn=findViewById(R.id.usernameid);
        pas=findViewById(R.id.passwordid);
        db=new database(this);
    }

    public void login(View v){

        if(usn.getText().toString().equals("") || pas.getText().toString().equals("")){
            Toast.makeText(this,"UserName or Password Is Empty ",Toast.LENGTH_LONG).show();
        }else if (usn.getText().toString().equals("Mohamed G") && pas.getText().toString().equals("12370@")){
            Intent intent=new Intent(this,admin.class);
            startActivity(intent);
        }else {
            Cursor c=db.get_alldata();
            while (c.moveToNext()){
                if (usn.getText().toString().equals(c.getString(1)) ){
                    if ( pas.getText().toString().equals(c.getString(2))){
                        Toast.makeText(MainActivity.this,"Welcome"+usn.getText().toString(),Toast.LENGTH_LONG).show();

                        //Intent to go to main user activity
                        Toast.makeText(MainActivity.this,"Ok",Toast.LENGTH_LONG).show();

                    }else {
                        Toast.makeText(MainActivity.this,"Incorrect Password",Toast.LENGTH_LONG).show();
                    }
                }
            }
            Toast.makeText(MainActivity.this,"Incorrect UserName",Toast.LENGTH_LONG).show();
        }
    }

    public void signup(View v){
        //Intent to sign up activity
        Toast.makeText(this,"Under Construction",Toast.LENGTH_LONG).show();
    }
}

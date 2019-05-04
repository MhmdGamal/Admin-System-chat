package com.example.admin;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class insert extends AppCompatActivity {

    EditText un,pas,pn,ps,pb;
    database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        un=findViewById(R.id.unid);
        pas=findViewById(R.id.pasid);
        pn=findViewById(R.id.projnid);
        ps=findViewById(R.id.projsid);
        pb=findViewById(R.id.projbid);
        db=new database(this);


    }

    public void ins(View v){
        if (un.getText().toString().equals("")||pas.getText().toString().equals("")){
            Toast.makeText(this,"Username or Password is Empty",Toast.LENGTH_LONG).show();
        }
        else {
            Cursor c=db.get_alldata();
            while (c.moveToNext()){
                if (un.getText().toString().equals(c.getString(1))){
                    Toast.makeText(this,"Username Existed",Toast.LENGTH_LONG).show();
                    return;
                }
            }
            db.insert(un.getText().toString(),pas.getText().toString(),pn.getText().toString(),ps.getText().toString(),
                    pb.getText().toString());
        }
    }
}

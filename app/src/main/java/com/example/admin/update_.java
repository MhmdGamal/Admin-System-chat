package com.example.admin;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class update_ extends AppCompatActivity {

    EditText un,pas,pn,ps,pb;
    database db;
    String xun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_);

        un=findViewById(R.id.unid);
        pas=findViewById(R.id.pasid);
        pn=findViewById(R.id.projnid);
        ps=findViewById(R.id.projsid);
        pb=findViewById(R.id.projbid);
        db=new database(this);

        un.setText(getIntent().getStringExtra("un"));
        Cursor c=db.get_onedata(un.getText().toString());
        pas.setText(c.getString(2));
        pn.setText(c.getString(3));
        ps.setText(c.getString(4));
        pb.setText(c.getString(5));
        xun=un.getText().toString();

    }

    public void upd(View v){
        if (un.getText().toString().equals("")||pas.getText().toString().equals("")){
            Toast.makeText(this,"Username or Password is Empty",Toast.LENGTH_LONG).show();
        }else if (un.getText().toString().equals(xun)){
            db.update(xun,xun,pas.getText().toString(),pn.getText().toString(),ps.getText().toString(),
                    pb.getText().toString());
        }
        else {
            Cursor c=db.get_alldata();
            while (c.moveToNext()){
                if (un.getText().toString().equals(c.getString(1))){
                    Toast.makeText(this,"Username Existed",Toast.LENGTH_LONG).show();
                    return;
                }
            }
            db.update(xun,un.getText().toString(),pas.getText().toString(),pn.getText().toString(),ps.getText().toString(),
                    pb.getText().toString());
        }
    }
}

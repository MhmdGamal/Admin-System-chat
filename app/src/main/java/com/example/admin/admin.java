package com.example.admin;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class admin extends AppCompatActivity {

    database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        db=new database(this);

        Toast.makeText(this,"Welcome Man ^^ ",Toast.LENGTH_LONG).show();
    }

    public void show(View v){
        AlertDialog.Builder alrt=new AlertDialog.Builder(this);
        alrt.setTitle("Show")
                .setMessage("Show One or All? ")
                .setPositiveButton("Show All", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent=new Intent(admin.this,showall.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Show One", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(admin.this,showone_s.class);
                        startActivity(intent);

                    }
                });
        alrt.create().show();
    }

    public void insert(View v){
        Intent intent=new Intent(this,insert.class);
        startActivity(intent);
    }
    public void update(View v){
        Intent intent=new Intent(this,update_s.class);
        startActivity(intent);
    }

    public void dele(View v){
        AlertDialog.Builder alrt=new AlertDialog.Builder(this);

        alrt.setTitle("Delete")
                .setMessage("Delete One or All ?")
                .setPositiveButton("Delete All", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String p= db.delete_all();
                        if (p.equals("Error")){
                            Toast.makeText(admin.this,"Error",Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(admin.this,"Deleted",Toast.LENGTH_LONG).show();
                        }
                    }
                })
                .setNegativeButton("Delete One", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(admin.this,delete.class);
                        startActivity(intent);
                    }
                });
    }
}

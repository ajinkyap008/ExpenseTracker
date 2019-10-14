package com.example.expensetracker;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.net.nsd.NsdManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Currency;


public class MainActivity extends AppCompatActivity {
    EditText username_text,password_text ;
    Button button_login ;
    String password_edit,username_edit ;
    TextView textView;
    SQLiteDatabase db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.new_user);
        username_text = findViewById(R.id.login_name) ;
        password_text = findViewById(R.id.login_password) ;
        button_login = findViewById(R.id.login_button) ;
        username_text.setText("");
        password_text.setText("");
        db=openOrCreateDatabase("Users", Context.MODE_PRIVATE,null);
//        db.execSQL("drop table Users;");
        insert_login_info(db);      //checks if table exists or not and thus creates is table does not exist.


//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(MainActivity.this, Registration.class);
//                startActivity(intent);
//            }
//        });
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password_edit = password_text.getText().toString().trim();
                username_edit = username_text.getText().toString().trim();
                Cursor cursor=db.rawQuery("Select password,isadmin from Users where username = '"+username_edit+"'",null);
                if (cursor.moveToFirst())
                {
                    if (password_edit.equals(cursor.getString(0))) {
                        if (cursor.getInt(1)==0) {
                            Intent intent = new Intent(MainActivity.this, IntroActivity.class);
                            startActivity(intent);
                        }
//                        else if(cursor.getString(1).equals('1')){
//                            Intent intent = new Intent(MainActivity.this, AdminActivity.class);
//                            startActivity(intent);
//                        }
                    }
                }
                else
                {
                    username_text.setText("");
                    password_text.setText("");
                    Toast.makeText(MainActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    void insert_login_info(SQLiteDatabase database){
        String tn="Users";
        Cursor cursor=db.rawQuery("Select DISTINCT tbl_name from sqlite_master where tbl_name= '"+ tn + "'",null);
        if (cursor.getCount()==0)
        {
            database.execSQL("Create TABLE IF NOT EXISTS Users(username varchar,password varchar,isadmin integer);");
            database.execSQL("Insert into Users values('pccoe','pccoe',0)");
            database.execSQL("Insert into Users values('admin','admin',1)");
        }
    }
}

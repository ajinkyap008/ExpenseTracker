package com.example.expensetracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.util.Log;

import java.util.List;

public class AcceptedActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    String username;


    DatabaseHelper databaseHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accepted);

        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            username = null;
        } else {
            username = extras.getString("username");
        }
        Log.d("onapproved1111", "on_approved_click: ");

        databaseHelper = new DatabaseHelper(this);

        Log.d("onapproved1", "on_approved_click: ");
        Cursor c1 = databaseHelper.gethead(username);
        Log.d("onapproved11", "on_approved_click: ");
        Cursor c2 = databaseHelper.getcategory(username);
        Log.d("onapproved2", "on_approved_click: ");
        Cursor c3 = databaseHelper.getinfo(username);
        Log.d("onapproved3", "on_approved_click: ");
        Cursor c4 = databaseHelper.getdetails(username);
        Log.d("onapproved4", "on_approved_click: ");


        recyclerView = findViewById(R.id.rcv_view);

        Log.d("onapproved31", "on_approved_click: ");

        recyclerAdapter = new RecyclerAdapter(this , c1 , c2 , c3 , c4);

        Log.d("onapproved32", "on_approved_click: ");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Log.d("onapproved33", "on_approved_click: ");

        recyclerView.setAdapter(recyclerAdapter);

        Log.d("onapproved34", "on_approved_click: ");

        /*StringBuffer stringBuffer = new StringBuffer();

        while(c1.moveToNext() && c2.moveToNext() && c3.moveToNext() && c4.moveToNext()){
            stringBuffer.append("id : " + c1.getString(0) + "\n");
            stringBuffer.append(("head_name : " + c1.getString(1) + "\n"));
            stringBuffer.append("category_name : " + c2.getString(3) + "\n");
            stringBuffer.append("bill no : " + c3.getString(3) + "\n");
            stringBuffer.append("biller name : " + c3.getString(4) + "\n");
            stringBuffer.append("date : " + c4.getString(2) + "\n");
            stringBuffer.append("time : " + c4.getString(3) + "\n\n");


        }
        showmessage("Data",stringBuffer.toString());
    }

    public void showmessage(String title , String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }*/


    }
}


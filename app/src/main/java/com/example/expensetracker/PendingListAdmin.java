package com.example.expensetracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class PendingListAdmin extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    String username;
    DatabaseHelper databaseHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_list_admin);

        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            username = null;
        } else {
            username = extras.getString("username");
        }

        Log.d("onapproved1111", "on_pending_click: ");

        databaseHelper = new DatabaseHelper(this);


        ArrayList<Cursor> arrayList= databaseHelper.getPending_List_Admin();


        ArrayList<String> list = new ArrayList<String>();

//        int j=0;
//        while(c1.moveToNext()){
//            //System.out.println("Data : "+c1.getString(0)+ " " + c1.getString(1)+ " ... ");
//            Log.d("x"+j,c1.getString(5));
//            j++;
//        }

//        c1.moveToFirst();
        int x=0;
        Cursor c1;
        while(x<arrayList.size()){
            c1 = arrayList.get(x);
            //list.add(c1.getString(0));//id
            list.add((c1.getString(0)));//head
            list.add(c1.getString(1));//category
//            list.add(c1.getString(2));//description
//            list.add(c1.getString(3));//username
//            list.add(c1.getString(4) );//emp_id
            list.add((c1.getString(5)));//billno
            list.add((c1.getString(6)));//billername
            list.add((c1.getString(7)));//address
            list.add(c1.getString(8) );//city
            list.add(c1.getString(9) );//amount
            list.add((c1.getString(10)));//date
            list.add((c1.getString(11)));//time
            list.add(c1.getString(12));//particulars
            list.add(c1.getString(13));//remarks
            x++;
        }

        for(int i=0;i<list.size();i++){
            Log.d("Accepted", "onCreate: " + list.get(i) + "\n");
        }


        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerAdapter = new RecyclerAdapter(this , list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);
    }
}

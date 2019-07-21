package com.example.expensetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Spinner spinner1,s;
    final ArrayList<String> ExpenseHead=new ArrayList<String>();
    final ArrayList<String> ExpenseType=new ArrayList<String>();
    TextView textViewDate,textViewTime ;
    Calendar calendar ;
    SimpleDateFormat simpleDateFormatDate,simpleDateFormatTime  ;
    String timestamp_date,timestamp_time ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         s=(Spinner)findViewById(R.id.spinner_type) ;
         textViewDate = findViewById(R.id.dateText) ;
        textViewTime = findViewById(R.id.timeText) ;
        calendar = Calendar.getInstance() ;
        simpleDateFormatDate = new SimpleDateFormat("dd-MM-yyyy") ;
        timestamp_date = simpleDateFormatDate.format(calendar.getTime()) ;
        textViewDate.setText(timestamp_date);

        simpleDateFormatTime = new SimpleDateFormat("HH:mm:ss") ;
        timestamp_time = simpleDateFormatTime.format(calendar.getTime()) ;
        textViewTime.setText(timestamp_time);

        ExpenseHead.add("Select Expense Head");
        ExpenseHead.add("Travel");
        ExpenseHead.add("Food");
        ExpenseHead.add("Medical");
        ExpenseHead.add("Others");


        spinner1=(Spinner)findViewById(R.id.spinner_head);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,ExpenseHead);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);

        ExpenseType.add("Select Expense Type");

        Log.d("here", "onCreate: ");


    spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            Log.d("here", "onItemSelected: above ");
            String state = ExpenseHead.get(i).toString();

            Log.d("here", "onItemSelected:  ");

            if(!TextUtils.isEmpty(state))
            func_ExpenseType(state);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    });

    }

    private void func_ExpenseType(String state) {

        Log.d("here", "func_ExpenseType: ");

        if(state.equals("Select Expense Head")){
            ExpenseType.clear();
            ExpenseType.add("Select Expense Type");
        }

        else if(state.equals("Travel")){
            Log.d("here", "func_ExpenseType: Travel");

            ExpenseType.clear();

            ExpenseType.add("Bus");
            ExpenseType.add("Train");
            ExpenseType.add("Aerial");
            ExpenseType.add("Others");

        }


        else if(state.equals("Food")){
            Log.d("here", "func_ExpenseType: Food");

            ExpenseType.clear();

            ExpenseType.add("Dinner");
            ExpenseType.add("Lunch");
            ExpenseType.add("BreakFast");
            ExpenseType.add("Others");

        }

        else if(state.equals("Medical")){
            Log.d("here", "func_ExpenseType: Medical");

            ExpenseType.clear();

            ExpenseType.add("Hospital");
            ExpenseType.add("Prescription");
            ExpenseType.add("Others");
        }

        else if(state.equals("Others")) {
            Log.d("here", "func_ExpenseType: Others");

            ExpenseType.clear();
            ExpenseType.add("Others");
        }


        ArrayAdapter<String> ar=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,ExpenseType);
        ar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(ar);

        //ExpenseType.clear();

    }


}

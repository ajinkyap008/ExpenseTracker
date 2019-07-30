package com.example.expensetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class ExpenseTrack extends AppCompatActivity {

    Spinner spinner1,s;
    final ArrayList<String> ExpenseHead=new ArrayList<String>();
    final ArrayList<String> ExpenseType=new ArrayList<String>();
    TextView textViewDate,textViewTime ;
    Calendar calendar ;
    SimpleDateFormat simpleDateFormatDate,simpleDateFormatTime  ;
    String timestamp_date,timestamp_time ;
    TextView txt_date,txt_time;
    ImageView img_date,img_time;

    final Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_track);

        txt_date = findViewById(R.id.txt_date);
        img_date = findViewById(R.id.img_date);
        img_time = findViewById(R.id.img_time);
        txt_time = findViewById(R.id.txt_time);
        calendar = Calendar.getInstance() ;

        //To set Current Date
        simpleDateFormatDate = new SimpleDateFormat("dd-MM-yyyy") ;
        timestamp_date = simpleDateFormatDate.format(calendar.getTime()) ;
        txt_date.setText(timestamp_date);


        //To set Current time
        simpleDateFormatTime = new SimpleDateFormat("HH:mm") ;
        timestamp_time = simpleDateFormatTime.format(calendar.getTime()) ;
        txt_time.setText(timestamp_time);

        //Select time on clicking time button
        img_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(ExpenseTrack.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        txt_time.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });



        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                myCalendar.set(Calendar.YEAR, i);
                myCalendar.set(Calendar.MONTH, i1);
                myCalendar.set(Calendar.DAY_OF_MONTH, i2);
                updateLabel();
            }


        };


        //Select date on clicking date button
        img_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(ExpenseTrack.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        s=(Spinner)findViewById(R.id.spinner_type) ;






        ExpenseHead.add("Select Expense Head");
        ExpenseHead.add("Travel");
        ExpenseHead.add("Food");
        ExpenseHead.add("Medical");
        ExpenseHead.add("Others");


        spinner1=(Spinner)findViewById(R.id.spinner_head);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(ExpenseTrack.this,android.R.layout.simple_spinner_item,ExpenseHead);
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

    private void updateLabel() {
        String myFormat = "dd-MM-yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        txt_date.setText(sdf.format(myCalendar.getTime()));
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


        ArrayAdapter<String> ar=new ArrayAdapter<String>(ExpenseTrack.this,android.R.layout.simple_spinner_item,ExpenseType);
        ar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(ar);

        //ExpenseType.clear();

    }
}

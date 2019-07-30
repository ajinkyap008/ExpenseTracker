package com.example.expensetracker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText username_text,password_text ;
    Button button_login ;
    String password_edit,username_edit ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username_text = findViewById(R.id.login_name) ;
        password_text = findViewById(R.id.login_password) ;
        button_login = findViewById(R.id.login_button) ;


        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password_edit = password_text.getText().toString().trim() ;
                username_edit = username_text.getText().toString().trim() ;
                if(password_edit.equals("pccoe") && username_edit.equals("pccoe")) {
                    Intent intent = new Intent(MainActivity.this, ExpenseTrack.class);
                    Toast.makeText(MainActivity.this, "Expense Billing Form", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

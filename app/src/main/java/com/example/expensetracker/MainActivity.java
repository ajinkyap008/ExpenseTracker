package com.example.expensetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner1,s;
    final ArrayList<String> states=new ArrayList<String>();
    final ArrayList<String> city=new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         s=(Spinner)findViewById(R.id.spinner_city);

        states.add("Select State");
        states.add("AndraPradesh");
        states.add("Karnataka");
        states.add("Kerela");
        states.add("Maharashtra");


        spinner1=(Spinner)findViewById(R.id.spinner_state);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,states);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);

        city.add("Select City");

        Log.d("here", "onCreate: ");



      //  String selected_state = spinner1.getSelectedItem().toString().trim();


   /*    spinner1.setOnItemClickListener(new AdapterView.OnItemClickListener() {



           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               String state = states.get(i).toString().trim();

               func_city(state);
           }


           @Override
           public void onNothingSelected(AdapterView<?> parent) {
           }


        });

*/


    spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {



        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            Log.d("here", "onItemSelected: above ");
            String state = states.get(i).toString();



            Log.d("here", "onItemSelected:  ");

            if(!TextUtils.isEmpty(state))
            func_city(state);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    });




    }

    private void func_city(String state) {

        Log.d("here", "func_city: ");

        if(state.equals("Select State")){

            city.clear();
            city.add("Select City");
        }

        if(state.equals("AndraPradesh")){

            Log.d("here", "func_city: Andrapradesh");

            city.clear();

            city.add("Vishakapatnam");
            city.add("Tirupati");
            city.add("Vijaywada");
            city.add("Guntur");

        }


       else if(state.equals("Karnataka")){

            Log.d("here", "func_city: Karnataka");

            city.clear();

            city.add("Banglore");
            city.add("Manglore");
            city.add("Hubli");
            city.add("Belgaum");

        }



        else if(state.equals("Kerela")){
            Log.d("here", "func_city: Kerela");

            city.clear();

            city.add("Thiruvanantapuram");
            city.add("Kochi");
            city.add("Kollam");
            city.add("Kozhikode");

        }

        else if(state.equals("Maharashtra")){
            Log.d("here", "func_city: Maharashtra");

            city.clear();

            city.add("Pune");
            city.add("Mumbai");
            city.add("Nagpur");
            city.add("Nashik");

        }



        ArrayAdapter<String> ar=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,city);
        ar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(ar);

        //city.clear();




    }





}

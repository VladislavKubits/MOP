package com.example.user.mop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class MOP_Activity_Timetable extends AppCompatActivity {

    String[] menu = {"Отправить новость в соцсети", "Новости", "Расписание", "О кафедре", "Авторизация", "Абитуриент"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mop_activity_timetable);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, menu);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        spinner.setAdapter(adapter);

        spinner.setPrompt("Главное меню");

        spinner.setSelection(2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                              @Override
                                              public void onItemSelected(AdapterView<?> parent,
                                                                         View view, int position, long id) {
                                                  if (id == 0) {
                                                      Intent i = new Intent(MOP_Activity_Timetable.this,
                                                              MOP_Activity_Publication.class);
                                                      startActivity(i);
                                                  }

                                                  if (id == 1) {
                                                      Intent i = new Intent(MOP_Activity_Timetable.this,
                                                              MOP_Activity_MOP_NEWS.class);
                                                      startActivity(i);
                                                  }

                                                  if (id == 3) {
                                                      Intent i = new Intent(MOP_Activity_Timetable.this,
                                                              MOP_Activity_History_of_MOP_AVM.class);
                                                      startActivity(i);
                                                  }

                                                  if (id == 4) {
                                                      Intent i = new Intent(MOP_Activity_Timetable.this,
                                                              MOP_Activity_Autoresation.class);
                                                      startActivity(i);
                                                  }

                                                  if (id == 5) {
                                                      Intent i = new Intent(MOP_Activity_Timetable.this,
                                                              MOP_Activity_Abiturient.class);
                                                      startActivity(i);
                                                  }
                                              }

                                              @Override
                                              public void onNothingSelected(AdapterView<?> parent) {
                                              }
                                          }
        );
    }
}

package com.example.user.mop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MOP_Activity_Autoresation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mop__activity__autoresation);
    }
    public void goToActivity_Password(View view){
        Intent intent = new Intent(this, MOP_Activity_GoogleSfedu.class);
        startActivity(intent);
    }
    public void goToActivity_History(View view){
        Intent intent = new Intent(this, MOP_Activity_History_of_MOP_AVM.class);
        startActivity(intent);
    }
    public void goToActivity_NEWS(View view){
        Intent intent = new Intent(this, MOP_Activity_MOP_NEWS.class);
        startActivity(intent);
    }
    public void goToActivity_Timetable(View view){
        Intent intent = new Intent(this, MOP_Activity_Timetable.class);
        startActivity(intent);
    }
    public void goToActivity_Publication(View view){
        Intent intent = new Intent(this, MOP_Activity_Publication.class);
        startActivity(intent);
    }
    public void goToActivity_Abiturient(View view){
        Intent intent = new Intent(this, MOP_Activity_Abiturient.class);
        startActivity(intent);
    }
}


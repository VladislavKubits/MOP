package com.example.user.mop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MOP_Activity_Sfedupassword extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mop_activity_sfedupassword);
    }
    public void goToActivity_Menu(View view){
        Intent intent = new Intent(this, MOP_Activity_Autoresation.class);
        startActivity(intent);
    }
    }

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
        Intent intent = new Intent(this, MOP_Activity_Password.class);
        startActivity(intent);
    }
}

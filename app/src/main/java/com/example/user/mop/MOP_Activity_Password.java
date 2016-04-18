package com.example.user.mop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

public class MOP_Activity_Password extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mop_activity_password);
    }
    public void goToActivity_Menu(View view){
        Intent intent = new Intent(this, MOP_Activity_Menu.class);
         startActivity(intent);
    }
}

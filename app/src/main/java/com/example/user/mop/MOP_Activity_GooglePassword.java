package com.example.user.mop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MOP_Activity_GooglePassword extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mop_activity_googlepassword);
    }
    public void goToActivity_Menu(View view){
        Intent intent = new Intent(this, MOP_Activity_Autoresation.class);
        intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP | intent.FLAG_ACTIVITY_SINGLE_TOP);
         startActivity(intent);
    }
}

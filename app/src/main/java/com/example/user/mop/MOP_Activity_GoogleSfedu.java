package com.example.user.mop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MOP_Activity_GoogleSfedu extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mop_activity_googlesfedu);
    }
    public void goToActivity_GooglePassword(View view){
        Intent intent = new Intent(this, MOP_Activity_GooglePassword.class);
        startActivity(intent);
    }
    public void goToActivity_SfeduPassword(View view){
        Intent intent = new Intent(this, );
        startActivity(intent);
    }
}

package com.example.user.mop;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MOP_Activity_GoogleSfedu extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mop_activity_googlesfedu);
    }

    public void goToActivity_GooglePassword(View view) {
        Intent intent = new Intent(this, MOP_Activity_GooglePassword.class);
        startActivity(intent);
    }

    public void goToActivity_SfeduPassword(View view) {
        Intent intent = new Intent(this, MOP_Activity_Sfedupassword.class);
        startActivity(intent);
    }
}

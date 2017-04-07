package com.example.user.mop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.vk.sdk.util.VKUtil;

import java.util.Arrays;
import java.util.jar.Manifest;

public class MOP_Activity_Autoresation extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mop__activity__autoresation);
        String[] fingerprints = VKUtil.getCertificateFingerprint(this, this.getPackageName());
        System.out.println(Arrays.asList(fingerprints));
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
    public void goToActivity_Abiturient(View view){
        Intent intent = new Intent(this, MOP_Activity_Abiturient.class);
        startActivity(intent);
    }

}


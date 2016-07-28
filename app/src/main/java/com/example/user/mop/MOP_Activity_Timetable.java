package com.example.user.mop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



public class MOP_Activity_Timetable extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mop_activity_timetable);

        toolbar=(Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();

        if (id==R.id.news){
            Intent intent = new Intent(this, MOP_Activity_MOP_NEWS.class);
            startActivity(intent);
            return true;
        }
        if (id==R.id.schedule){
            Intent intent = new Intent(this, MOP_Activity_Timetable.class);
            startActivity(intent);
            return true;
        }
        if (id==R.id.About_the_department){
            Intent intent = new Intent(this, MOP_Activity_History_of_MOP_AVM.class);
            startActivity(intent);
            return true;
        }
        if (id==R.id.Send_news_to_social_networks){
            Intent intent = new Intent(this, MOP_Activity_Publication.class);
            startActivity(intent);
            return true;
        }
        if (id==R.id.authorization){
            Intent intent = new Intent(this, MOP_Activity_Autoresation.class);
            startActivity(intent);
            return true;
        }
        if (id==R.id.Enrollee){
            Intent intent = new Intent(this, MOP_Activity_Abiturient.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);

    }
}

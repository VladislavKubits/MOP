package com.example.user.mop;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MOP_Activity_Abiturient extends AppCompatActivity {

    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mop_activity_abiturient);

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
            return true;
        }
        if (id==R.id.schedule){
            return true;
        }
        if (id==R.id.About_the_department){
            return true;
        }
        if (id==R.id.Send_news_to_social_networks){
            return true;
        }
        if (id==R.id.authorization){
            return true;
        }
        if (id==R.id.Enrollee){
            return true;
        }

        return super.onOptionsItemSelected(item);

    }
}

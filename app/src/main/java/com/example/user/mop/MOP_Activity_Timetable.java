package com.example.user.mop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.text.format.DateFormat;
import android.support.design.widget.Snackbar;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class MOP_Activity_Timetable extends AppCompatActivity {

    private static int SIGN_IN_REQUEST_CODE = 1;
    private FirebaseListAdapter<MOP_Message> adapter;
    RelativeLayout activity_mop_activity_timetable;
    FloatingActionButton button;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mop_activity_timetable);
        activity_mop_activity_timetable = (RelativeLayout) findViewById(R.id.activity_chat);
        button = (FloatingActionButton) findViewById(R.id.sendButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText input = (EditText) findViewById(R.id.messageEditText);
                FirebaseDatabase.getInstance().getReference().push()
                        .setValue(new MOP_Message(input.getText().toString(),
                                FirebaseAuth.getInstance().getCurrentUser().getEmail()));
                input.setText("");
            }
        });

        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            startActivityForResult(AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .build(), SIGN_IN_REQUEST_CODE);
        } else {
            displayChat();
        }

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
    }


    private void displayChat() {

        ListView listMessages = (ListView)findViewById(R.id.messageListView);
        adapter = new FirebaseListAdapter<MOP_Message>(this, MOP_Message.class, R.layout.mop_chat_item, FirebaseDatabase.getInstance().getReference()) {
            @Override
            protected void populateView(View v, MOP_Message model, int position) {

                TextView textMessage, autor, timeMessage;
                textMessage = (TextView)v.findViewById(R.id.tvMessage);
                autor = (TextView)v.findViewById(R.id.tvUser);
                timeMessage = (TextView)v.findViewById(R.id.tvTime);

                textMessage.setText(model.getTextMessage());
                autor.setText(model.getAutor());
                timeMessage.setText(DateFormat.format("dd-MM-yy \n HH:mm", model.getTimeMessage()));
            }
        };
        listMessages.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SIGN_IN_REQUEST_CODE)
        {
            if (resultCode == RESULT_OK)
            {
                Snackbar.make(activity_mop_activity_timetable, "Вход выполнен", Snackbar.LENGTH_SHORT).show();
                displayChat();
            } else {
                Snackbar.make(activity_mop_activity_timetable, "Вход не выполнен", Snackbar.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    /*@Override
    public boolean onCreateOptionsMenu2(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_chat, menu);
        return true;
    }*/



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.news) {
            Intent intent = new Intent(this, MOP_Activity_MOP_NEWS.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.chat) {
            Intent intent = new Intent(this, MOP_Activity_Timetable.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.About_the_department) {
            Intent intent = new Intent(this, MOP_Activity_History_of_MOP_AVM.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.authorization) {
            Intent intent = new Intent(this, MOP_Activity_Autoresation.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.Enrollee) {
            Intent intent = new Intent(this, MOP_Activity_Abiturient.class);
            startActivity(intent);
            return true;
        }
        if (id==R.id.chat_logout){
            AuthUI.getInstance().signOut(this)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            Snackbar.make(activity_mop_activity_timetable, "Выход выполнен", Snackbar.LENGTH_SHORT).show();
                            finish();

                        }
                    });
        }

        return super.onOptionsItemSelected(item);

    }
}

package com.example.user.mop;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.entity.Example;
import com.example.entity.Item;
import com.google.gson.Gson;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.methods.VKApiUsers;
import com.vk.sdk.api.methods.VKApiWall;
import com.vk.sdk.api.model.VKList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.R.layout.simple_list_item_1;


public class MOP_Activity_MOP_NEWS extends AppCompatActivity {
    private Toolbar toolbar;

    RecyclerView recyclerView;
    ArrayList<String> arrayList = new ArrayList<>();
    //ArrayAdapter<String> arrayAdapter;
    NEWS_Adapter news_adapter;

    private String[] scope = new String[]{VKScope.WALL};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mop_activity_mop_news);
        VKSdk.login(this, scope);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        news_adapter = new NEWS_Adapter();
        recyclerView.setAdapter(news_adapter);
        setSupportActionBar(toolbar);

    }

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
        if (id == R.id.schedule) {
            Intent intent = new Intent(this, MOP_Activity_Timetable.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.About_the_department) {
            Intent intent = new Intent(this, MOP_Activity_History_of_MOP_AVM.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.Send_news_to_social_networks) {
            Intent intent = new Intent(this, MOP_Activity_Publication.class);
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

        return super.onOptionsItemSelected(item);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                // Пользователь успешно авторизовался
                final VKRequest VKRequest = new VKApiUsers().get(VKParameters.from("user_ids", "software.engineering"));
                VKRequest.executeWithListener(new VKRequest.VKRequestListener() {
                    @Override
                    public void onComplete(VKResponse response) {
                        super.onComplete(response);
                        VKList vkList = (VKList) response.parsedModel;
                        try {
                            VKRequest VKRequest1 = new VKApiWall().get(VKParameters.from(VKApiConst.OWNER_ID, vkList.get(0).fields.getInt("id"), VKApiConst.COUNT, 100));
                            VKRequest1.executeWithListener(new VKRequest.VKRequestListener() {
                                @Override
                                public void onComplete(VKResponse response) {
                                    super.onComplete(response);
                                    Example example = new Gson().fromJson(response.responseString, com.example.entity.Example.class);
                                    news_adapter.setItems(example.getResponse().getItems());
                                    news_adapter.notifyDataSetChanged();

                                }
                            });

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
            }

            @Override
            public void onError(VKError error) {
                // Произошла ошибка авторизации (например, пользователь запретил авторизацию)
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}

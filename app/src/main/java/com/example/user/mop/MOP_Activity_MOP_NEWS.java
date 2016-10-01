package com.example.user.mop;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.entity.Example;
import com.example.entity.Item;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
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
import com.vk.sdk.api.model.VKApiGetMessagesResponse;
import com.vk.sdk.api.model.VKApiPhoto;
import com.vk.sdk.api.model.VKApiPost;
import com.vk.sdk.api.model.VKAttachments;
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
    NewsAdapter newsAdapter;

    /**
     * Посты со страницы
     */
    VKList<VKApiPost> posts = new VKList<>();

    private String[] scope = new String[]{VKScope.WALL};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mop_activity_mop_news);
      //  VKSdk.login(this, scope);
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        news_adapter = new NEWS_Adapter(posts);
        newsAdapter = new NewsAdapter();
        recyclerView.setAdapter(newsAdapter);
        setSupportActionBar(toolbar);
        loadPosts();

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

    private class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.PostsHolder> {
        public class PostsHolder extends RecyclerView.ViewHolder {
            public TextView text;
            public LinearLayout attachments;
            public PostsHolder(View itemView) {
                super(itemView);
                text = (TextView) itemView.findViewById(R.id.post_textView);
                attachments = (LinearLayout) itemView.findViewById(R.id.attachments);
            }
        }

        @Override
        public int getItemCount() {
            return posts.size();
        }

        @Override
        public PostsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(getApplicationContext())
                    .inflate(R.layout.post_layout, parent, false);
            return new PostsHolder(v);
        }

        @Override
        public void onBindViewHolder(PostsHolder holder, int position) {
            VKApiPost post = posts.get(position);
            holder.text.setText(post.text);
            if (!post.copy_history.isEmpty()) {
                holder.text.setText(post.copy_history.get(0).text);
            }
            if (!post.attachments.isEmpty()) {
                Log.d("Have attachpost", "Есть прикрепления");
                VKAttachments.VKApiAttachment attachment;

                for (int i=0; i<post.attachments.size(); i++) {
                    attachment = post.attachments.get(i);
                    if (attachment.getType().equals(VKAttachments.TYPE_PHOTO)) {
                        ImageView photo = new ImageView(getBaseContext());
                        Picasso.with(getApplicationContext()).load(((VKApiPhoto) attachment).photo_604).into(photo);
                        holder.attachments.addView(photo);
                        Log.d("Have attachpost", "Есть фото");
                    }
                    holder.attachments.setVisibility(View.VISIBLE);
                }
            }

        }
    }

    private void loadPosts() {
        VKRequest request = new VKRequest("wall.get", VKParameters
                .from("domain", "software.engineering", VKApiConst.COUNT, 100));
        request.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                super.onComplete(response);
                JSONObject object = response.json.optJSONObject("response");
                VKList<VKApiPost> newPosts = new VKList<>(object
                        .optJSONArray("items"), VKApiPost.class);
                posts.addAll(newPosts);
                newsAdapter.notifyDataSetChanged();
            }
        });
    }

}

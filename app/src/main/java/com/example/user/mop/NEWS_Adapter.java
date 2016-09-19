package com.example.user.mop;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.entity.Item;
import com.example.entity.Link;
import com.squareup.picasso.Picasso;
import com.vk.sdk.api.model.VKApiPost;
import com.vk.sdk.api.model.VKList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 22.08.2016.
 */
public class NEWS_Adapter extends RecyclerView.Adapter<NEWS_Adapter.ViewHolder> {

    private List<Item> items;
    VKList<VKApiPost> posts;

    public NEWS_Adapter(VKList<VKApiPost> posts) {
        this.items = new ArrayList<>();
        this.posts = posts;
    }

    public void setItems(List<Item> items) {
        this.items.addAll(items);
    }

    /**
     * Создание новых View и ViewHolder элемента списка, которые впоследствии могут переиспользоваться.
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.post_layout, viewGroup, false);
        return new ViewHolder(v);
    }

    /**
     * Заполнение виджетов View данными из элемента списка с номером i
     */
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.name.setText(posts.get(i).text);
//        Item item = items.get(i);
//        viewHolder.name.setText(item.getText());
//
//        if (item.getAttachments().size() > 0) {
//            Link link = item.getAttachments().get(0).getLink();
//            if (link != null) {
//                Picasso.with(viewHolder.itemView.getContext())
//                        .load(link.getUrl())
//                        .into(viewHolder.icon);
//            }
//
//
//        }


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    /**
     * Реализация класса ViewHolder, хранящего ссылки на виджеты.
     */
    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private ImageView icon;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.post_textView);
            icon = (ImageView) itemView.findViewById(R.id.post_imageView);
        }
    }

}

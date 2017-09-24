package com.study.teamspkt.worldnews.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.study.teamspkt.worldnews.Models.Post_Model;
import com.study.teamspkt.worldnews.R;

import java.util.ArrayList;

/**
 * Created by Pon Long Bong on 9/20/2017.
 */

public class HotNews_Adapter extends RecyclerView.Adapter<HotNews_Adapter.Viewholder> {
    Context context;
    ArrayList<Post_Model> post_models = new ArrayList<>();

    public HotNews_Adapter(Context context, ArrayList<Post_Model> post_models) {
        this.context = context;
        this.post_models = post_models;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Viewholder(LayoutInflater.from(context).inflate(R.layout.item_hotnews,parent,false));
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        /*holder.textViewTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return post_models.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    static class Viewholder extends RecyclerView.ViewHolder{
        View v;
        TextView textViewTitle;

        public Viewholder(View itemView) {
            super(itemView);
            this.v = itemView;
            //textViewTitle = (TextView) v.findViewById(R.id.textViewTitle);
        }
    }
}

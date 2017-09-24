package com.study.teamspkt.worldnews.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.study.teamspkt.worldnews.Models.Post_Model;
import com.study.teamspkt.worldnews.R;

import java.util.ArrayList;

/**
 * Created by Pon Long Bong on 9/19/2017.
 */

public class Summary_Category_Adapter extends RecyclerView.Adapter<Summary_Category_Adapter.ViewHolder> {

    Context context;
    ArrayList<Post_Model> post_models = new ArrayList<>();

    public Summary_Category_Adapter(Context context, ArrayList<Post_Model> post_models) {
        this.context = context;
        this.post_models = post_models;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_summary_category,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return post_models.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}

package com.study.teamspkt.worldnews.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.study.teamspkt.worldnews.Models.Post_Model;
import com.study.teamspkt.worldnews.R;

import java.util.ArrayList;

/**
 * Created by Pon Long Bong on 9/17/2017.
 */

public class Summary_BaseAdapter extends BaseAdapter {

    Context context;
    ArrayList<Post_Model> post_models;

    public Summary_BaseAdapter(Context context, ArrayList<Post_Model> post_models) {
        this.context = context;
        this.post_models = post_models;
    }

    @Override
    public int getCount() {
        return post_models == null?0 : post_models.size();
    }

    @Override
    public Object getItem(int position) {
        return post_models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {

        return getCount();
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.context).inflate(R.layout.item_summary, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.renderData1(convertView);
        return convertView;
    }


    static class ViewHolder {
        View v;
        ExpandableRelativeLayout expandablerelativeLayoutPostView;
        ExpandableRelativeLayout expandablerelativeLayoutSummary;
        RelativeLayout relativeLayoutBottom;

        ImageView imageViewExpandView;

        TextView textViewTitile;

        boolean isexpand=false;

        Animation animation0to180,animation180to0;
        public ViewHolder( View v) {
            this.v = v;
            /*this.expandablerelativeLayoutPostView = (ExpandableRelativeLayout) v.findViewById(R.id.expandablerelativeLayoutPostView);
            this.expandablerelativeLayoutSummary = (ExpandableRelativeLayout) v.findViewById(R.id.expandablerelativeLayoutSummary);
            this.imageViewExpandView = (ImageView) v.findViewById(R.id.imageViewExpandView);
            this.relativeLayoutBottom = (RelativeLayout) v.findViewById(R.id.relativeLayoutBottom);*/
            this.textViewTitile = (TextView) v.findViewById(R.id.textViewTitile);


        }
        public void renderData1( View view) {
            /*if(!isexpand) {
                this.expandablerelativeLayoutSummary.expand();

                this.expandablerelativeLayoutPostView.collapse();
                isexpand = true;
            }
            else
            {
                this.expandablerelativeLayoutSummary.collapse();

                this.expandablerelativeLayoutPostView.expand();
                isexpand = false;
            }*/
        }
    }
}

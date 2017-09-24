package com.study.teamspkt.worldnews.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.study.teamspkt.worldnews.Models.Post_Model;
import com.study.teamspkt.worldnews.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Pon Long Bong on 9/16/2017.
 */

public class Summary_Adapter extends RecyclerView.Adapter<Summary_Adapter.ViewHolder> {
    Context context;
    Animation animation0to180,animation180to0;
    ArrayList<Post_Model> post_models = new ArrayList<>();
    public static int VIEW_TYPE_HEADER=0;
    public static int VIEW_TYPE_SUMMARY=1;
    public static int VIEW_TYPE_SUMMARY_CATEGORY=2;

    public Summary_Adapter(Context context, ArrayList<Post_Model> post_models) {
        this.context = context;
        this.post_models = post_models;
        animation0to180 = AnimationUtils.loadAnimation(context, R.anim.rotate_iconexpand_0to180);
        animation180to0 = AnimationUtils.loadAnimation(context, R.anim.rotate_iconexpand_180to0);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_summary,parent,false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position){
        final Post_Model post_model = post_models.get(position);

        if(!holder.isExpand) {
            holder.expandablerelativeLayoutSummary.setExpanded(true);
            holder.expandablerelativeLayoutPostView.collapse();
            holder.imageViewExpandView.setRotation(0);
        }
        else
        {
            holder.expandablerelativeLayoutPostView.setExpanded(true);
            holder.imageViewExpandView.setRotation(180);
        }

        holder.linearLayoutExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!holder.isExpand){

                    holder.expandablerelativeLayoutSummary.collapse();
                    holder.expandablerelativeLayoutPostView.expand();
                    holder.imageViewExpandView.startAnimation(animation0to180);
                    holder.isExpand=true;
                }
                else
                {
                    holder.expandablerelativeLayoutSummary.setExpanded(true);
                    holder.expandablerelativeLayoutSummary.expand();
                    holder.expandablerelativeLayoutPostView.collapse();
                    holder.imageViewExpandView.startAnimation(animation180to0);
                    holder.isExpand=false;
                }
            }
        });

        holder.textViewSummaryTitile.setText(post_model.getTitile());
        //image summary cover
        holder.textViewSummaryDescription.setText(post_model.getDescription());
        //category get list name
        holder.textViewSummaryCategory.setText(post_model.getCategory_id());
        //imageCover
        holder.textViewTitile.setText(post_model.getTitile());
        holder.textViewCategory.setText(post_model.getCategory_id());
        holder.textViewDescription.setText(post_model.getDescription());
        holder.textViewAuthor.setText(post_model.getAuthor());
        holder.textViewContent.setText(post_model.getContent());
        //canculate like
        //canculate comment
        //canculate ic_share
        //calculate time ago
        Toast.makeText(context, calculateTimeAgo("11-8-2017 21:30:00"), Toast.LENGTH_SHORT).show();
        holder.expandablerelativeLayoutSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.expandablerelativeLayoutPostView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.linearLayoutLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.imageViewLike.setImageResource(R.drawable.ic_liked);
                Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(context, R.anim.animlike);
                holder.imageViewLike.startAnimation(hyperspaceJumpAnimation);
            }
        });
        holder.linearLayoutComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.linearLayoutShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private String calculateTimeAgo(String date)
    {
        Date today=new Date(System.currentTimeMillis());
        DateFormat timeFormat= SimpleDateFormat.getDateTimeInstance();
        Date datepost=new Date();
        try {
            datepost = timeFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long distance = (today.getTime()-datepost.getTime());
        long minute = TimeUnit.MINUTES.convert(distance, TimeUnit.MILLISECONDS);

        if(minute>=60)
        {
            long hour = TimeUnit.HOURS.convert(distance, TimeUnit.MILLISECONDS);
            if(hour>=24)
            {
                long day = TimeUnit.DAYS.convert(distance, TimeUnit.MILLISECONDS);
                if(day>=7)
                {
                    if(day>=30)
                    {
                        return String.valueOf(day / 30) + " tháng trước";
                    }
                    return String.valueOf(day / 7) + " tuần " + String.valueOf(day % 7) + " ngày trước";
                }
                return String.valueOf(day) +" ngày trước";
            }
            return String.valueOf(hour) +" giờ trước";

        }
        return  String.valueOf(minute) +" phút trước";
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(post_models.get(position).getPost_id());
    }


    @Override
    public int getItemCount() {
        return post_models ==null ? 0: post_models.size();
    }



    static class ViewHolder extends RecyclerView.ViewHolder{
        View v;
        ExpandableRelativeLayout expandablerelativeLayoutSummary;
        TextView textViewSummaryTitile;
        ImageView imageViewSummaryCover;
        TextView textViewSummaryDescription;
        TextView textViewSummaryCategory;
        ExpandableRelativeLayout expandablerelativeLayoutPostView;
        ImageView imageViewCover;
        TextView textViewTitile,textViewCategory,textViewDescription,textViewAuthor,textViewContent;
        LinearLayout linearLayoutLike;
        ImageView imageViewLike;
        TextView textViewLike;
        LinearLayout linearLayoutComment;
        TextView textViewComment;
        LinearLayout linearLayoutShare;
        LinearLayout linearLayoutExpand;
        ImageView imageViewExpandView;
        TextView textViewTimeAgo;

        boolean isExpand=false;

        public ViewHolder( View v) {
            super(v);
            this.v = v;
            this.expandablerelativeLayoutSummary = (ExpandableRelativeLayout) v.findViewById(R.id.expandablerelativeLayoutSummary);
            this.expandablerelativeLayoutPostView = (ExpandableRelativeLayout) v.findViewById(R.id.expandablerelativeLayoutPostView);
            this.expandablerelativeLayoutSummary = (ExpandableRelativeLayout) v.findViewById(R.id.expandablerelativeLayoutSummary);
            this.imageViewExpandView = (ImageView) v.findViewById(R.id.imageViewExpandView);
            this.linearLayoutExpand = (LinearLayout) v.findViewById(R.id.linearLayoutExpand);
            this.textViewSummaryTitile = (TextView) v.findViewById(R.id.textViewSummaryTitile);
            imageViewSummaryCover = (ImageView) v.findViewById(R.id.imageViewSummaryCover);
            textViewSummaryDescription = (TextView) v.findViewById(R.id.textViewSummaryDescription);
            textViewSummaryCategory = (TextView) v.findViewById(R.id.textViewSummaryCategory);
            imageViewCover = (ImageView) v.findViewById(R.id.imageViewCover);
            textViewTitile = (TextView) v.findViewById(R.id.textViewTitile);
            textViewCategory = (TextView) v.findViewById(R.id.textViewCategory);
            textViewDescription = (TextView) v.findViewById(R.id.textViewDescription);
            textViewAuthor= (TextView) v.findViewById(R.id.textViewAuthor);
            textViewContent = (TextView) v.findViewById(R.id.textViewContent);
            linearLayoutLike = (LinearLayout) v.findViewById(R.id.linearLayoutLike);
            imageViewLike = (ImageView) v.findViewById(R.id.imageViewLike);
            textViewLike = (TextView) v.findViewById(R.id.textViewLike);
            linearLayoutComment = (LinearLayout) v.findViewById(R.id.linearLayoutComment);
            textViewComment = (TextView) v.findViewById(R.id.textViewComment);
            linearLayoutShare = (LinearLayout) v.findViewById(R.id.linearLayoutShare);
            textViewTimeAgo = (TextView) v.findViewById(R.id.textViewTimeAgo);
        }
    }
}
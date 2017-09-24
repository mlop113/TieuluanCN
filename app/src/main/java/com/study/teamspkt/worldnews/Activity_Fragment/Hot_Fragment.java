package com.study.teamspkt.worldnews.Activity_Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.study.teamspkt.worldnews.Adapters.HotNews_Adapter;
import com.study.teamspkt.worldnews.Adapters.Summary_Adapter;
import com.study.teamspkt.worldnews.Adapters.Summary_Category_Adapter;
import com.study.teamspkt.worldnews.Models.Post_Model;
import com.study.teamspkt.worldnews.R;

import java.util.ArrayList;

import me.mvdw.recyclerviewmergeadapter.adapter.RecyclerViewMergeAdapter;

/**
 * Created by Pon Long Bong on 9/14/2017.
 */

public class Hot_Fragment extends Fragment implements View.OnClickListener{
    Animation animation0to180,animation180to0;
    //RecyclerView summary
    RecyclerView recyclerViewSummary;
    Summary_Adapter summary_adapter;
    ArrayList<Post_Model> post_models = new ArrayList<>();
    LayoutInflater inflater;
    View v;
    //hotnews
    LinearLayout linearLayoutHotNews;
    RecyclerView recyclerViewHotNews;
    HotNews_Adapter hotNews_adapter;
    LinearLayoutManager linearLayoutManager;

    //RecyclerView category summary
    Summary_Category_Adapter summary_category_adapter;

    //header
    View viewHeader;
    ExpandableRelativeLayout expandablerelativeLayoutPostView;
    LinearLayout linearLayoutLike;
    ImageView imageViewLike;
    LinearLayout linearLayoutExpand;
    ImageView imageViewExpandView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_hot,container,false);
        this.inflater = inflater;

        animation0to180 = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_iconexpand_0to180);
        animation180to0 = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_iconexpand_180to0);

        mappings();
        initView();
        event();

        return v;
    }

    private void mappings() {
        //Hotnews
        recyclerViewHotNews = (RecyclerView) v.findViewById(R.id.recyclerViewHotNews);

        //RecyclerView summary
        recyclerViewSummary = (RecyclerView) v.findViewById(R.id.recyclerViewSummary);



        //header
        viewHeader = LayoutInflater.from(getContext()).inflate(R.layout.item_summary_header,null,false);
        expandablerelativeLayoutPostView = (ExpandableRelativeLayout) viewHeader.findViewById(R.id.expandablerelativeLayoutPostView);
        linearLayoutExpand = (LinearLayout) viewHeader.findViewById(R.id.linearLayoutExpand);
        linearLayoutLike = (LinearLayout) viewHeader.findViewById(R.id.linearLayoutLike);
        imageViewLike = (ImageView) viewHeader.findViewById(R.id.imageViewLike);
        imageViewExpandView = (ImageView) viewHeader.findViewById(R.id.imageViewExpandView);

    }

    private void initView() {
        //set linearLayout Hotnews automatic scroll
        //StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL);
        linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,true);
        hotNews_adapter = new HotNews_Adapter(getContext(),getPosts());
        recyclerViewHotNews.setLayoutManager(linearLayoutManager);
        recyclerViewHotNews.setAdapter(hotNews_adapter);

        //RecyclerView summary
        recyclerViewSummary.setLayoutManager(new LinearLayoutManager(getContext()));
        summary_adapter = new Summary_Adapter(getContext(),getPosts());

        //RecyclerView suummary category
        summary_category_adapter = new Summary_Category_Adapter(getContext(),getPosts());

        // Create a new merge adapter.
        RecyclerViewMergeAdapter mergeAdapter = new RecyclerViewMergeAdapter();
        // Add any number of subadapters to the merge adapter.
        mergeAdapter.addView(viewHeader);
        mergeAdapter.addAdapter(summary_adapter);
        mergeAdapter.addAdapter(summary_category_adapter);
        // Set the merge adapter on the RecyclerView.
        recyclerViewSummary.setAdapter(mergeAdapter);

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void autoScrollrecyclerView(final RecyclerView recyclerView, final LinearLayoutManager linearLayoutManager,
                                        final HotNews_Adapter hotNews_adapter) {
        final int duration = 10;
        final int pixelsToMove = 30;
        final Handler mHandler = new Handler(Looper.getMainLooper());
        final Runnable SCROLLING_RUNNABLE = new Runnable() {
            @Override
            public void run() {
                recyclerView.smoothScrollBy(pixelsToMove, 0);
                mHandler.postDelayed(this, duration);
            }
        };
        mHandler.postDelayed(SCROLLING_RUNNABLE, 2000);
    }


    private void event() {
        linearLayoutExpand.setOnClickListener(this);
        linearLayoutLike.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.linearLayoutExpand:
                if(!expandablerelativeLayoutPostView.isExpanded()) {
                    expandablerelativeLayoutPostView.expand();
                    imageViewExpandView.startAnimation(animation0to180);
                }
                else
                {
                    expandablerelativeLayoutPostView.collapse();
                    imageViewExpandView.startAnimation(animation180to0);
                }
                break;
            case R.id.linearLayoutLike:
                imageViewLike.setImageResource(R.drawable.ic_liked);
                Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.animlike);
                imageViewLike.startAnimation(hyperspaceJumpAnimation);
                break;
        }
    }

    public ArrayList<Post_Model> getPosts() {
        ArrayList<Post_Model> post_models = new ArrayList<>();
        post_models.add(new Post_Model("1","1111111111111111","afdfdsfdsf","fdfdsfsdf","fashion","12/9/2017","","sadsad"));
        post_models.add(new Post_Model("2","22222222222222","afdfdsfdsf","fdfdsfsdf","fashion","12/9/2017","","ádasd"));
        post_models.add(new Post_Model("3","333333333333333","afdfdsfdsf","fdfdsfsdf","fashion","12/9/2017","","ádasd"));
        post_models.add(new Post_Model("4","4444444444444444","afdfdsfdsf","fdfdsfsdf","fashion","12/9/2017","","ádasd"));
        post_models.add(new Post_Model("5","555555555555","afdfdsfdsf","fdfdsfsdf","fashion","12/9/2017","","ádasd"));
        post_models.add(new Post_Model("6","6666666666666666","afdfdsfdsf","fdfdsfsdf","fashion","12/9/2017","","ádasd"));
        post_models.add(new Post_Model("7","777777777777","afdfdsfdsf","fdfdsfsdf","fashion","12/9/2017","","ádasd"));
        post_models.add(new Post_Model("8","888888888888","afdfdsfdsf","fdfdsfsdf","fashion","12/9/2017","","ádasd"));
        post_models.add(new Post_Model("9","999999999999","afdfdsfdsf","fdfdsfsdf","fashion","12/9/2017","","ádasd"));
        post_models.add(new Post_Model("10","10","afdfdsfdsf","fdfdsfsdf","fashion","12/9/2017","","ádasd"));
        post_models.add(new Post_Model("11","11","afdfdsfdsf","fdfdsfsdf","fashion","12/9/2017","","ádasd"));
        post_models.add(new Post_Model("12","12","afdfdsfdsf","fdfdsfsdf","fashion","12/9/2017","","ádasd"));
        post_models.add(new Post_Model("13","13","afdfdsfdsf","fdfdsfsdf","fashion","12/9/2017","","ádasd"));
        return post_models;
    }
}

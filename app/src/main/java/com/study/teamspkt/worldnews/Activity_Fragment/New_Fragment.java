package com.study.teamspkt.worldnews.Activity_Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.study.teamspkt.worldnews.Adapters.Summary_Adapter;
import com.study.teamspkt.worldnews.Models.Post_Model;
import com.study.teamspkt.worldnews.R;

import java.util.ArrayList;

/**
 * Created by Pon Long Bong on 9/14/2017.
 */

public class New_Fragment extends Fragment {
    Animation animation0to180,animation180to0;
    //RecyclerView summary
    RecyclerView recyclerViewSummary;
    Summary_Adapter summary_adapter;
    ArrayList<Post_Model> post_models = new ArrayList<>();
    LayoutInflater inflater;
    View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_new,container,false);
        this.inflater = inflater;

        animation0to180 = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_iconexpand_0to180);
        animation180to0 = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_iconexpand_180to0);

        mappings();
        initView();
        event();
        return v;
    }

    private void mappings() {
        //RecyclerView summary
        recyclerViewSummary = (RecyclerView) v.findViewById(R.id.recyclerViewSummary);

    }

    private void initView() {
        //RecyclerView summary
        recyclerViewSummary.setLayoutManager(new LinearLayoutManager(getContext()));
        summary_adapter = new Summary_Adapter(getContext(),getPosts());
        recyclerViewSummary.setAdapter(summary_adapter);
    }

    private void event() {
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

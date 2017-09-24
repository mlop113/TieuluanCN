package com.study.teamspkt.worldnews.Activity_Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.study.teamspkt.worldnews.R;

/**
 * Created by Pon Long Bong on 9/14/2017.
 */

public class BottomSheetDialogFragment extends android.support.design.widget.BottomSheetDialogFragment {
    View v;
    LinearLayout linearLayout_FilterbyDate;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v =  inflater.inflate(R.layout.plus_menu, container, false);
        //linearLayout_FilterbyDate = (LinearLayout)v.findViewById(R.id.linearLayout_FilterbyDate);
        //linearLayout_FilterbyDate.setOnClickListener(this);
        return v;
    }




}

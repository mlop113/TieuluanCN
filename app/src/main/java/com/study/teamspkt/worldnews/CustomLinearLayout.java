package com.study.teamspkt.worldnews;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by Pon Long Bong on 9/21/2017.
 */
@CoordinatorLayout.DefaultBehavior(MoveUpwardBehavior.class)
public class CustomLinearLayout extends LinearLayout {
    public CustomLinearLayout(Context context) {
        super(context);
    }

    public CustomLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}

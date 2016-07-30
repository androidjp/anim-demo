package com.androidjp.anim_demo.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.LinearLayout;

import com.androidjp.anim_demo.R;

/**
 * Created by androidjp on 16-7-29.
 */
public abstract class BaseActivity extends FragmentActivity{

    private LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_common_scroll);
        container = (LinearLayout) findViewById(R.id.container_list);
        addViews();
    }


    protected LinearLayout getContainer(){
        return this.container;
    }

    protected abstract void addViews();

}

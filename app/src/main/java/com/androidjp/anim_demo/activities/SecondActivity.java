package com.androidjp.anim_demo.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.androidjp.anim_demo.R;
import com.androidjp.anim_demo.fragment.TestFragment;

/**
 * Created by androidjp on 16-7-29.
 */
public class SecondActivity extends AppCompatActivity{

    private FrameLayout frameRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_frame);
        frameRoot = (FrameLayout) findViewById(R.id.frame_root);

        addFragment();
    }

    /***
     * 使用动画效果加载Fragment（注意，这种方式对于DialogFragment是无效的，因为DialogFragment没有对应的父容器，本身就是固定的）
     */
    private void addFragment() {
        Fragment fragment = new TestFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
//        transaction.setCustomAnimations(R.anim.fragment_enter_anim,R.anim.fragment_exit_anim);
        transaction.add(R.id.frame_root,fragment);
//        transaction.addToBackStack("frag");
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter_anim,R.anim.exit_anim);
    }
}

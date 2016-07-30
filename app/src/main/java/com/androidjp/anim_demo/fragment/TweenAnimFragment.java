package com.androidjp.anim_demo.fragment;

import android.graphics.drawable.AnimationDrawable;

import com.androidjp.anim_demo.R;

/**
 * Created by androidjp on 16-7-29.
 */
public class TweenAnimFragment extends BaseDialogFragment{

    @Override
    public void onResume() {
        super.onResume();
        getImageView().setBackgroundResource(R.drawable.frame_anim);
        AnimationDrawable ad = (AnimationDrawable) getImageView().getBackground();
        ad.start();
    }

}

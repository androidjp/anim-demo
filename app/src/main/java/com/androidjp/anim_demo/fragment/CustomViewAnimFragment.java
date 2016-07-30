package com.androidjp.anim_demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import com.androidjp.anim_demo.R;
import com.androidjp.anim_demo.animation.CustomViewAnim;

/**
 * Created by androidjp on 16-7-29.
 */
public class CustomViewAnimFragment extends BaseDialogFragment implements Animation.AnimationListener {
    Animation animation;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getImageView().setImageResource(R.drawable.img2);
    }

    @Override
    public void onResume() {
        super.onResume();
//        animation = AnimationUtils.loadAnimation(getActivity(),R.anim.view_anim);


        animation = new CustomViewAnim(0,360,50,50,100,true);

        animation.setDuration(2000);
        animation.setFillAfter(true);
        animation.setInterpolator(getActivity(),android.R.anim.anticipate_interpolator);
        animation.setAnimationListener(this);
        getImageView().startAnimation(animation);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getImageView().clearAnimation();
    }


    @Override
    public void onAnimationStart(Animation animation) {
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        this.dismiss();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}

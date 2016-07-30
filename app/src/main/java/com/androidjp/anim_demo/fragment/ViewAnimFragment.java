package com.androidjp.anim_demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;

import com.androidjp.anim_demo.R;

/**
 * Created by androidjp on 16-7-29.
 */
public class ViewAnimFragment extends BaseDialogFragment implements Animation.AnimationListener{
    Animation animation;

    int i = 4;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getImageView().setImageResource(R.drawable.img1);
    }

    @Override
    public void onResume() {
        super.onResume();
//        animation = AnimationUtils.loadAnimation(getActivity(),R.anim.view_anim);

        getImageView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"你点击了我",Toast.LENGTH_SHORT).show();
            }
        });

        animation = new RotateAnimation(0, +720, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(3000);
        animation.setInterpolator(getActivity(),android.R.anim.accelerate_decelerate_interpolator);
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

        i-=1;
        switch (i){
            case 3:
                animation = new TranslateAnimation(0,0,0,-160);
                animation.setDuration(2000);
                animation.setInterpolator(getActivity(),android.R.anim.accelerate_decelerate_interpolator);
                /**
                 * 这里，注意点：
                 * 1.setFillAfter 表示的是：是否让画面停留在最后一刻的状态
                 */
                animation.setFillAfter(true);
                animation.setAnimationListener(this);
                getImageView().startAnimation(animation);
                break;

            case 2:
                //要自己实际移动View的坐标位置
                getImageView().offsetTopAndBottom(-160);

//                animation.cancel();
                getImageView().clearAnimation();
                getImageView().invalidate();
                animation = new ScaleAnimation(1f,1.5f,1f,1.5f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                animation.setDuration(2000);
                animation.setInterpolator(getActivity(),android.R.anim.accelerate_decelerate_interpolator);
                animation.setFillAfter(true);
                animation.setAnimationListener(this);
                getImageView().startAnimation(animation);
                break;

            case 1:
//                animation.cancel();
                getImageView().clearAnimation();
                getImageView().invalidate();
                animation = new AlphaAnimation(1.0f,0.0f);
                animation.setDuration(1000);
                animation.setInterpolator(getActivity(),android.R.anim.accelerate_decelerate_interpolator);
                animation.setFillAfter(true);
                animation.setAnimationListener(this);
                getImageView().startAnimation(animation);
                break;
            default:
                getImageView().clearAnimation();
                this.dismiss();
                break;

        }


    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}

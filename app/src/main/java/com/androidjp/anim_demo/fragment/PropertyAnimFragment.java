package com.androidjp.anim_demo.fragment;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.widget.Toast;

import com.androidjp.anim_demo.R;

/**
 * Created by androidjp on 16-7-29.
 */
public class PropertyAnimFragment extends BaseDialogFragment{

    @Override
    public void onResume() {
        super.onResume();

        Toast.makeText(getActivity(),"xml方式失效，尝试用java代码方式动态设置属性动画",Toast.LENGTH_SHORT).show();
//        getImageView().setImageResource(R.drawable.img1);
//        AnimatorSet set  = (AnimatorSet) AnimatorInflater.loadAnimator(getActivity(), R.animator.property_anim);
//        set.setTarget(getImageView());
//        set.start();

        getImageView().setImageResource(R.drawable.img1);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofFloat(getImageView(),"rotationX",0,360),
                ObjectAnimator.ofFloat(getImageView(),"rotationY",0,180),
                ObjectAnimator.ofFloat(getImageView(),"rotation",0,-90),
                ObjectAnimator.ofFloat(getImageView(),"translationX",0,90),
                ObjectAnimator.ofFloat(getImageView(),"translationY",0,90),
                ObjectAnimator.ofFloat(getImageView(),"scaleX",1,1.5f),
                ObjectAnimator.ofFloat(getImageView(),"scaleY",1,0.5f),
                ObjectAnimator.ofFloat(getImageView(),"alpha",1,0.25f,1)
        );

        set.setDuration(5*1000).start();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getImageView().clearAnimation();
    }
}

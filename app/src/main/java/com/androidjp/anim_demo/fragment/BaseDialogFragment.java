package com.androidjp.anim_demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.androidjp.anim_demo.R;

/**
 * Created by androidjp on 16-7-29.
 */
public class BaseDialogFragment extends DialogFragment {
    View view;
    ImageView iv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_dfragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iv = (ImageView) view.findViewById(R.id.iv_test);
    }

    public ImageView getImageView(){
        return this.iv;
    }

    public View getRootView(){
        return this.view;
    }
}

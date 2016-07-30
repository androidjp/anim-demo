package com.androidjp.anim_demo.activities;

import android.app.Activity;

import com.androidjp.anim_demo.R;

/**
 * Created by androidjp on 16-7-29.
 */
public class SecondActivity extends Activity{


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter_anim,R.anim.exit_anim);
    }
}

package com.androidjp.anim_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.LinearLayout;

import com.androidjp.anim_demo.activities.SecondActivity;
import com.androidjp.anim_demo.fragment.CustomViewAnimFragment;
import com.androidjp.anim_demo.fragment.FrameAnimFragment;
import com.androidjp.anim_demo.fragment.PropertyAnimFragment;
import com.androidjp.anim_demo.fragment.ViewAnimFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "你点击了", 1000)
                        .setAction("点我", null).show();
            }
        });


        container = (LinearLayout) findViewById(R.id.list_container);

        /**
         * 设置LayoutAnimation
         */
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.view_anim);
        LayoutAnimationController controller = new LayoutAnimationController(animation);
        controller.setDelay(0.6f);
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
        container.setLayoutAnimation(controller);

        /**
         * 添加菜单按钮
         */
        addCardViews();

    }

    private void addCardViews() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(8,8,8,8);
        Button btn1 = (Button) getLayoutInflater().inflate(R.layout.btn_new,null,false);
        btn1.setLayoutParams(params);
        btn1.setText("View动画");
        btn1.setTag(1);
        btn1.setOnClickListener(this);

        Button btn2 = (Button) getLayoutInflater().inflate(R.layout.btn_new,null,false);
        btn2.setLayoutParams(params);
        btn2.setText("自定义View动画");
        btn2.setTag(2);
        btn2.setOnClickListener(this);

        Button btn3 = (Button) getLayoutInflater().inflate(R.layout.btn_new,null,false);
        btn3.setLayoutParams(params);
        btn3.setText("属性动画");
        btn3.setTag(3);
        btn3.setOnClickListener(this);


        Button btn4 = (Button) getLayoutInflater().inflate(R.layout.btn_new,null,false);
        btn4.setLayoutParams(params);
        btn4.setText("帧动画");
        btn4.setTag(4);
        btn4.setOnClickListener(this);

        Button btn5 = (Button) getLayoutInflater().inflate(R.layout.btn_new,null,false);
        btn5.setLayoutParams(params);
        btn5.setText("ViewGroup动画：LayoutAnimation");
        btn5.setTag(5);
        btn5.setOnClickListener(this);
        btn5.setEnabled(false);

        Button btn6 = (Button) getLayoutInflater().inflate(R.layout.btn_new,null,false);
        btn6.setLayoutParams(params);
        btn6.setText("Activity跳转动画");
        btn6.setTag(6);
        btn6.setOnClickListener(this);

        container.addView(btn1);
        container.addView(btn2);
        container.addView(btn3);
        container.addView(btn4);
        container.addView(btn5);
        container.addView(btn6);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch ((Integer)(view.getTag())){
            case 1:
                new ViewAnimFragment().show(getSupportFragmentManager(),"ViewAnimFragment");
                break;
            case 2:
                new CustomViewAnimFragment().show(getSupportFragmentManager(),"CustomViewAnimFragment");
                break;
            case 3:
                new PropertyAnimFragment().show(getSupportFragmentManager(),"PropertyAnimFragment");
                break;
            case 4:
                new FrameAnimFragment().show(getSupportFragmentManager(),"FrameAnimFragment");
                break;
            case 6:
                startActivity(new Intent(this, SecondActivity.class));
                overridePendingTransition(R.anim.enter_anim,R.anim.exit_anim);
                break;
        }
    }
}

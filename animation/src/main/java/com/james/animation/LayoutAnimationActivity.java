package com.james.animation;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridLayout;

import com.james.animation.R;

public class LayoutAnimationActivity extends ActionBarActivity implements CompoundButton.OnCheckedChangeListener {

    private ViewGroup mViewGroup;
    private GridLayout mGridLayout;
    private int mVal;
    private LayoutTransition mLayoutTransition;

    private CheckBox mAppear, mChangeAppear, mDisAppear, mChangeDisAppear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_animation);
        mViewGroup = (ViewGroup) findViewById(R.id.id_container);

        mAppear = (CheckBox) findViewById(R.id.chkAppear);
        mChangeAppear = (CheckBox) findViewById(R.id.chkChange_appear);
        mDisAppear = (CheckBox) findViewById(R.id.chkDisappear);
        mChangeDisAppear = (CheckBox) findViewById(R.id.chkChange_disappear);

        mAppear.setOnCheckedChangeListener(this);
        mChangeAppear.setOnCheckedChangeListener(this);
        mDisAppear.setOnCheckedChangeListener(this);
        mChangeDisAppear.setOnCheckedChangeListener(this);

        // 创建一个GridLayout
        mGridLayout = new GridLayout(this);
        // 设置每列5个按钮
        mGridLayout.setColumnCount(5);
        // 添加到布局中
        mViewGroup.addView(mGridLayout);
        // 默认动画全部开启
        mLayoutTransition = new LayoutTransition();
        mLayoutTransition.setAnimator(LayoutTransition.APPEARING, (mAppear
                .isChecked() ? ObjectAnimator.ofFloat(this, "scaleX", 0, 1)
                : null));
        mGridLayout.setLayoutTransition(mLayoutTransition);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_layout_animation, menu);
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

    public void addBtn(View view) {
        final Button button = new Button(this);
        button.setText((++mVal) + "");
        mGridLayout.addView(button, Math.min(1, mGridLayout.getChildCount()));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGridLayout.removeView(button);
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        mLayoutTransition = new LayoutTransition();
        mLayoutTransition.setAnimator(
                LayoutTransition.APPEARING,
                (mAppear.isChecked() ? mLayoutTransition
                        .getAnimator(LayoutTransition.APPEARING) : null));
        mLayoutTransition.setAnimator(
                LayoutTransition.CHANGE_APPEARING,
                (mChangeAppear.isChecked() ? mLayoutTransition
                        .getAnimator(LayoutTransition.CHANGE_APPEARING)
                        : null));
        mLayoutTransition.setAnimator(
                LayoutTransition.DISAPPEARING,
                (mDisAppear.isChecked() ? mLayoutTransition
                        .getAnimator(LayoutTransition.DISAPPEARING) : null));
        mLayoutTransition.setAnimator(
                LayoutTransition.CHANGE_DISAPPEARING,
                (mChangeDisAppear.isChecked() ? mLayoutTransition
                        .getAnimator(LayoutTransition.CHANGE_DISAPPEARING)
                        : null));
        mGridLayout.setLayoutTransition(mLayoutTransition);
    }
}

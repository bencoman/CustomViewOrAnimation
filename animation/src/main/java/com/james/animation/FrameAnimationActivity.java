package com.james.animation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import com.james.animation.R;

public class FrameAnimationActivity extends ActionBarActivity implements View.OnClickListener {
    AnimationDrawable frameAnimation;
    /*
     * 声明AnimationDrawable 可绘制动画 对象frameAnimation
     */
    ImageView myImage;
    Button start, stop;
    CheckBox Cycle;
    boolean isChecked_cycle = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);

        start = (Button) findViewById(R.id.btnStart);
        stop = (Button) findViewById(R.id.btnStop);
        Cycle = (CheckBox) findViewById(R.id.CheckBox_ifCycle_orNot);

        myImage = (ImageView) findViewById(R.id.rocket_image);
        myImage.setBackgroundResource(R.anim.frameanimation);
        /*
         * ImageView.setBackgroundResource()设置 图片View的背景图片
         * 这里是把帧动画 myframeanimation加到 图片View的背景中
         */
        frameAnimation = (AnimationDrawable) myImage.getBackground();
        /*
         * myImage.getBackground()获得背景的Drawable的对象，转换成AnimationDrawable
         */

        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        frameAnimation.setOneShot(isChecked_cycle);

        //添加触摸事件处理方法
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            /*
             * MotionEvent.getAction()获取事件动作
             * MotionEvent.ACTION_DOWN 向下的手势动作
             */
        /*event.getAction() 返回正被执行的动作种类：
         * 是     ACTION_DOWN, ACTION_MOVE, ACTION_UP, 或 ACTION_CANCEL中的一个.
         */
            //AnimationDrawable.isRunning()，判断帧动画是否在运行，true---运行中 如果动画正在运行，可以停止
            if (frameAnimation.isRunning()) {
                frameAnimation.stop();//停止帧动画效果
            } else {
                frameAnimation.start();//启动帧动画效果
            }
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View button) {
        switch (button.getId()) {
            case R.id.btnStart: {
                if (Cycle.isChecked()) {
                    Toast.makeText(this, "动画重复", Toast.LENGTH_LONG).show();
                    isChecked_cycle = false;
                } else {
                    Toast.makeText(this, "不重复", Toast.LENGTH_LONG).show();
                    isChecked_cycle = true;
                }
                frameAnimation.setOneShot(isChecked_cycle);//设置重复与否
                frameAnimation.start();//启动帧动画效果
            }
            break;
            case R.id.btnStop: {
                //AnimationDrawable.isRunning()，判断帧动画是否在运行，true---运行中 如果动画正在运行，可以停止
                if (frameAnimation.isRunning()) {
                    frameAnimation.stop();//停止帧动画效果
                }
            }
            break;
        }
    }
}


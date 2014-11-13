package com.james.animation;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private Button btnFrame;
    private Button btnTween;
    private Button btnBouncingBalls;
    private Button btnObjectAnimator;
    private Button btnValueAnimator;
    private Button btnAnimatorSet;
    private Button btnXml4Animator;
    private Button btnLayoutAnimation;
    private Button btnViewAnimate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFrame = (Button) findViewById(R.id.btnFrame);
        btnFrame.setOnClickListener(this);

        btnTween = (Button) findViewById(R.id.btnTween);
        btnTween.setOnClickListener(this);

        btnBouncingBalls = (Button) findViewById(R.id.btnBouncingBalls);
        btnBouncingBalls.setOnClickListener(this);

        btnObjectAnimator = (Button) findViewById(R.id.btnObjectAnimator);
        btnObjectAnimator.setOnClickListener(this);

        btnValueAnimator = (Button) findViewById(R.id.btnValueAnimator);
        btnValueAnimator.setOnClickListener(this);

        btnAnimatorSet = (Button) findViewById(R.id.btnAnimatorSet);
        btnAnimatorSet.setOnClickListener(this);

        btnXml4Animator = (Button) findViewById(R.id.btnXml4Animator);
        btnXml4Animator.setOnClickListener(this);

        btnLayoutAnimation = (Button) findViewById(R.id.btnLayoutAnimation);
        btnLayoutAnimation.setOnClickListener(this);

        btnViewAnimate = (Button) findViewById(R.id.btnViewAnimate);
        btnViewAnimate.setOnClickListener(this);
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
    public void onClick(View v) {

        Intent intent;
        switch (v.getId()) {
            case R.id.btnFrame: {
                intent = new Intent(this, FrameAnimationActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.btnTween: {
                intent = new Intent(this, TweenAnimationActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.btnBouncingBalls: {
                intent = new Intent(this, BouncingBallsActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.btnObjectAnimator: {
                intent = new Intent(this, ObjectAnimatorActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.btnValueAnimator: {
                intent = new Intent(this, ValueAnimatorActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.btnAnimatorSet: {
                intent = new Intent(this, AnimatorSetActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.btnXml4Animator: {
                intent = new Intent(this, Xml4AnimatorActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.btnLayoutAnimation: {
                intent = new Intent(this, LayoutAnimationActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.btnViewAnimate: {
                intent = new Intent(this, ViewAnimateActivity.class);
                startActivity(intent);
            }
            break;
        }
    }
}

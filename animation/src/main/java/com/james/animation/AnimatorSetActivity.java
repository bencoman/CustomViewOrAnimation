package com.james.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.james.animation.R;

public class AnimatorSetActivity extends ActionBarActivity {

    private ImageView ivBall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_set);

        ivBall = (ImageView) findViewById(R.id.ivBall);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_animator_set, menu);
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

    public void togetherRun(View view) {
        ObjectAnimator objectAnimator = new ObjectAnimator().ofFloat(ivBall, "ScaleX", 1.0F, 5.0F);
        ObjectAnimator objectAnimator2 = new ObjectAnimator().ofFloat(ivBall, "ScaleY", 1.0F, 5.0F);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(2000);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.playTogether(objectAnimator, objectAnimator2);
        animatorSet.start();
    }

    public void playWithAfter(View view) {
        ObjectAnimator objectAnimator = new ObjectAnimator().ofFloat(ivBall, "ScaleX", 1.0F, 3.0F);
        ObjectAnimator objectAnimator2 = new ObjectAnimator().ofFloat(ivBall, "ScaleY", 1.0F, 3.0F);
        float cx = ivBall.getX();
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(ivBall, "x", cx, 0f);
        ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(ivBall, "x", cx);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(2000);
//        animatorSet.play(objectAnimator).with(objectAnimator2);
        animatorSet.playTogether(objectAnimator, objectAnimator2, objectAnimator3);
        animatorSet.play(objectAnimator).before(objectAnimator4);
        animatorSet.start();
    }
}

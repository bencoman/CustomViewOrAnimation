package com.james.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.james.animation.R;

public class Xml4AnimatorActivity extends ActionBarActivity {

    private ImageView ivBall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml4_animator);

        ivBall = (ImageView) findViewById(R.id.ivBall);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_xml4_animator, menu);
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

    public void scaleX(View view) {
        Animator animator= AnimatorInflater.loadAnimator(this,R.animator.scalex);
        animator.setTarget(ivBall);
        animator.start();
    }

    public void scaleXY(View view) {
        Animator animator=AnimatorInflater.loadAnimator(this,R.animator.scale);
        ivBall.setPivotX(0);
        ivBall.setPivotX(0);
        animator.setTarget(ivBall);
        animator.start();
    }
}

package com.james.animation;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.james.animation.R;

public class ViewAnimateActivity extends Activity {

    private ImageView ivBall;
    private float mScreenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animate);

        DisplayMetrics outMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        mScreenHeight = outMetrics.heightPixels;
        ivBall = (ImageView) findViewById(R.id.ivBall);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_animate, menu);
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

    public void viewAnim(View view) {
        final String TAG = "ViewAnimateActivity";
        // need API12
        ivBall.animate()//
                .alpha(0)//
                .y(mScreenHeight / 2).setDuration(1000)
                // need API 12
                .withStartAction(new Runnable() {
                    @Override
                    public void run() {
                        Log.e(TAG, "START");
                    }
                    // need API 16
                }).withEndAction(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG, "END");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ivBall.setY(0);
                        ivBall.setAlpha(1.0f);
                    }
                });
            }
        }).start();
    }

    public void propertyValuesHolder(View view) {
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 1f,
                0f, 1f);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("y", 0,
                mScreenHeight / 2, 0);
        ObjectAnimator.ofPropertyValuesHolder(ivBall, pvhX, pvhY).setDuration(1000).start();
    }
}

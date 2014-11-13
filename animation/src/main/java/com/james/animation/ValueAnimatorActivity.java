package com.james.animation;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.james.animation.R;

public class ValueAnimatorActivity extends ActionBarActivity {

    private ImageView ivBall;
    private int mScreenHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator);
        ivBall=(ImageView)findViewById(R.id.ivBall);

        DisplayMetrics outMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        mScreenHeight = outMetrics.heightPixels;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_value_animator, menu);
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

    public void verticalRun(View view) {

        ValueAnimator valueAnimator=new ValueAnimator().ofFloat(0.0f,mScreenHeight-ivBall.getHeight());
        valueAnimator.setTarget(ivBall);
        valueAnimator.setDuration(1000).start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                ivBall.setTranslationY((Float)animation.getAnimatedValue());
            }
        });
    }

    /**
     * 抛物线
     * @param view
     */
    public void throwLine(View view) {
        ValueAnimator valueAnimator=new ValueAnimator();
        valueAnimator.setDuration(1000);
        valueAnimator.setObjectValues(new PointF(0,0));
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setEvaluator(new TypeEvaluator<PointF>() {

            @Override
            public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
                PointF point=new PointF();
                point.x=200*fraction*3;
                point.y=0.5f*200*fraction*3*fraction*3;
                return point;
            }
        });

        valueAnimator.start();
        valueAnimator.addListener(new Animator.AnimatorListener() {
            String log="AnimatorListener";
            @Override
            public void onAnimationStart(Animator animation) {
                Log.i(log,"onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.i(log,"onAnimationEnd");
//                ViewGroup parent = (ViewGroup) ivBall.getParent();
//                if (parent != null)
//                    parent.removeView(ivBall);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.i(log,"onAnimationCancel");

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.i(log,"onAnimationRepeat");

            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF point = (PointF) animation.getAnimatedValue();
                ivBall.setX(point.x);
                ivBall.setY(point.y);
            }
        });
    }
}

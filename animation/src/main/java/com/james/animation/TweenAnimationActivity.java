package com.james.animation;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.james.animation.R;

public class TweenAnimationActivity extends ActionBarActivity implements View.OnClickListener{

    private Button btnAlpha;
    private Button btnScale;
    private Button btnTranslate;
    private Button btnRotate;
    private Animation myAnimation_Alpha;
    private Animation myAnimation_Scale;
    private Animation myAnimation_Translate;
    private Animation myAnimation_Rotate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlpha = (Button) findViewById(R.id.btnAlpha);
        btnAlpha.setOnClickListener(this);

        btnScale = (Button) findViewById(R.id.btnScale);
        btnScale.setOnClickListener(this);

        btnTranslate = (Button) findViewById(R.id.btnTranslate);
        btnTranslate.setOnClickListener(this);

        btnRotate = (Button) findViewById(R.id.btnRotate);
        btnRotate.setOnClickListener(this);

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
        switch (v.getId()) {
            case R.id.btnAlpha: {
                myAnimation_Alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
                btnAlpha.startAnimation(myAnimation_Alpha);
            }
            break;
            case R.id.btnScale: {
                myAnimation_Scale= AnimationUtils.loadAnimation(this,R.anim.scale);
                btnScale.startAnimation(myAnimation_Scale);
            }
            break;
            case R.id.btnTranslate: {
                myAnimation_Translate= AnimationUtils.loadAnimation(this,R.anim.translate);
                btnTranslate.startAnimation(myAnimation_Translate);
            }
            break;
            case R.id.btnRotate: {
                myAnimation_Rotate= AnimationUtils.loadAnimation(this,R.anim.rotate);
                btnRotate.startAnimation(myAnimation_Rotate);
            }
            break;

            default:
                break;
        }
    }
}

package com.james.customview.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.james.customview.R;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    Button textTileBtn, imgViewBtn, progressBarBtn,volumControlBarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textTileBtn = (Button) findViewById(R.id.textTileBtn);
        imgViewBtn = (Button) findViewById(R.id.imgViewBtn);
        progressBarBtn = (Button) findViewById(R.id.progressBarBtn);
        volumControlBarBtn = (Button) findViewById(R.id.volumControlBarBtn);

        textTileBtn.setOnClickListener(this);
        imgViewBtn.setOnClickListener(this);
        progressBarBtn.setOnClickListener(this);
        volumControlBarBtn.setOnClickListener(this);
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
            case R.id.textTileBtn:
                intent = new Intent(this, CustomTextTileActivity.class);
                startActivity(intent);
                break;
            case R.id.imgViewBtn:
                intent = new Intent(this, CustomImageViewActivity.class);
                startActivity(intent);
                break;
            case R.id.progressBarBtn:
                intent = new Intent(this, CustomProgressBarActivity.class);
                startActivity(intent);
                break;
            case R.id.volumControlBarBtn:
                intent = new Intent(this, CustomVolumControlBarActivity.class);
                startActivity(intent);
                break;
        }
    }
}

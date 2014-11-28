package com.james.customview.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import com.james.customview.R;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    Button textTileBtn, imgViewBtn, progressBarBtn, volumeControlBarBen,horizontalScrollViewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textTileBtn = (Button) findViewById(R.id.textTileBtn);
        imgViewBtn = (Button) findViewById(R.id.imgViewBtn);
        progressBarBtn = (Button) findViewById(R.id.progressBarBtn);
        volumeControlBarBen = (Button) findViewById(R.id.volumControlBarBtn);
        horizontalScrollViewBtn = (Button) findViewById(R.id.horizontalScrollViewBtn);

        textTileBtn.setOnClickListener(this);
        imgViewBtn.setOnClickListener(this);
        progressBarBtn.setOnClickListener(this);
        volumeControlBarBen.setOnClickListener(this);
        horizontalScrollViewBtn.setOnClickListener(this);
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
            case R.id.horizontalScrollViewBtn:
                intent = new Intent(this, CustomHorizontalScrollViewActivity.class);
                startActivity(intent);
                break;
        }
    }
}

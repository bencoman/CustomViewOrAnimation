package com.james.customview.activities;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.james.customview.R;
import com.james.customview.customview.CustomHorizontalScrollView;
import com.james.customview.customview.CustomHorizontalScrollViewAdapter;
import com.james.customview.customview.PicInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomHorizontalScrollViewActivity extends ActionBarActivity {

    private CustomHorizontalScrollViewAdapter mAdapter;
    private ImageView ivScrollView;
    private List<PicInfo> mPicInfos;
    private CustomHorizontalScrollView mHorizontalScrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_horizontal_scroll_view);
        mHorizontalScrollView = (CustomHorizontalScrollView) findViewById(R.id.id_horizontalScrollView);
        ivScrollView = (ImageView) findViewById(R.id.ivScrollView);

        mPicInfos = new ArrayList<PicInfo>(
                Arrays.asList(new PicInfo(0, R.drawable.a, "pic 0"),
                        new PicInfo(1, R.drawable.b, "pic 1"),
                        new PicInfo(2, R.drawable.c, "pic 2"),
                        new PicInfo(3, R.drawable.d, "pic 3"),
                        new PicInfo(4, R.drawable.e, "pic 4"),
                        new PicInfo(5, R.drawable.f, "pic 5"),
                        new PicInfo(6, R.drawable.g, "pic 6"),
                        new PicInfo(7, R.drawable.h, "pic 7"),
                        new PicInfo(8, R.drawable.i, "pic 8")
                ));
        mAdapter=new CustomHorizontalScrollViewAdapter(this,mPicInfos);
        //添加点击回调
        mHorizontalScrollView.setOnItemClickListener(new CustomHorizontalScrollView.OnItemClickListener() {
            @Override
            public void onClick(View view, int pos) {
                ivScrollView.setImageResource(mPicInfos.get(pos).getmImageId());
                view.setBackgroundColor(Color.parseColor("#AA024DA4"));
            }
        });
        //设置适配器
        mHorizontalScrollView.initDatas(mAdapter);
    }
//    private void initPicInfo() {
//
//        mPicInfos.add(new PicInfo(0, R.drawable.a, "pic 0"));
//        mPicInfos.add(new PicInfo(1, R.drawable.b, "pic 1"));
//        mPicInfos.add(new PicInfo(2, R.drawable.c, "pic 2"));
//        mPicInfos.add(new PicInfo(3, R.drawable.d, "pic 3"));
//        mPicInfos.add(new PicInfo(4, R.drawable.e, "pic 4"));
//        mPicInfos.add(new PicInfo(5, R.drawable.f, "pic 5"));
//        mPicInfos.add(new PicInfo(6, R.drawable.g, "pic 6"));
//        mPicInfos.add(new PicInfo(7, R.drawable.h, "pic 7"));
//        mPicInfos.add(new PicInfo(8, R.drawable.i, "pic 8"));
//    }


}

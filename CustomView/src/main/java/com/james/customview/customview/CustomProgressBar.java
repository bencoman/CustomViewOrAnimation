package com.james.customview.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ProgressBar;

import com.james.customview.R;

/**
 * <p>CustomProgressBar [V1.0.0]</p>
 * <p>classes : com.james.myapplication.customview.CustomProgressBar</p>
 * <p>谭建建 Create at 2014/11/5 0005 16:40</p>
 */
public class CustomProgressBar extends ProgressBar{
    /**
     * 第一圈的颜色
     */
    private int mFirstColor;
    /**
     * 第二圈的颜色
     */
    private int mSecondColor;
    /**
     * 圈的宽度
     */
    private int mCircleWidth;
    /**
     * 画笔
     */
    private Paint mPaint;
    /**
     * 当前进度
     */
    private int mProgress;

    /**
     * 速度
     */
    private int mSpeed;

    /**
     * 是否应该开始下一个
     */
    private boolean isNext = false;

    public CustomProgressBar(Context context) {
        this(context, null);
    }

    public CustomProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray=context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomProgressBar,defStyleAttr,0);
        for (int i=0;i<typedArray.length();i++){
            int attr=typedArray.getIndex(i);
            switch (attr){
                case R.styleable.CustomProgressBar_circleWidth:
                    mCircleWidth=typedArray.getDimensionPixelSize(attr,(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,20, getResources().getDisplayMetrics()));
                    break;
                case R.styleable.CustomProgressBar_firstColor:
                    mFirstColor=typedArray.getColor(attr, Color.GRAY);
                    break;
                case R.styleable.CustomProgressBar_secondColor:
                    mSecondColor=typedArray.getColor(attr,Color.WHITE);
                    break;
                case R.styleable.CustomProgressBar_speed:
                    mSpeed=typedArray.getInt(attr,20);
            }
        }
        typedArray.recycle();
        mPaint=new Paint();
        //thread of draw painting
        // 绘图线程
        new Thread()
        {
            public void run()
            {
                while (true)
                {
                    mProgress++;
                    if (mProgress == 360)
                    {
                        mProgress = 0;
                        if (!isNext)
                            isNext = true;
                        else
                            isNext = false;
                    }
                    postInvalidate();
                    try
                    {
                        Thread.sleep(mSpeed);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            };
        }.start();
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        int centre=getWidth()/2;
        int radius=centre-mCircleWidth/2;
        mPaint.setStrokeWidth(mCircleWidth);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        RectF oval=new RectF(centre-radius,centre-radius,centre+radius,centre+radius);
        if(!isNext){
            mPaint.setColor(mFirstColor);
            canvas.drawCircle(centre,centre,radius,mPaint);
            mPaint.setColor(mSecondColor);
            canvas.drawArc(oval,-180,mProgress,false,mPaint);
        }else{
            mPaint.setColor(mSecondColor); // 设置圆环的颜色
            canvas.drawCircle(centre, centre, radius, mPaint); // 画出圆环
            mPaint.setColor(mFirstColor); // 设置圆环的颜色
            canvas.drawArc(oval, -180, mProgress, false, mPaint); // 根据进度画圆弧
        }
    }
}

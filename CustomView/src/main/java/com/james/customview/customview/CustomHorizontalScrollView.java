package com.james.customview.customview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>CustomHorizontalScrollView [V1.0.0]</p>
 * <p>classes : com.james.customview.customview.CustomHorizontalScrollView</p>
 * <p>谭建建 Create at 2014/11/21 0021 13:22</p>
 */
public class CustomHorizontalScrollView extends HorizontalScrollView implements View.OnClickListener {
    /**
     * 当前最后一张图片的index
     */
    private int mEndIndex;
    /**
     * 当前第一张图片的下标
     */
    private int mFristIndex;
    /**
     * 保存View与位置的键值对
     */
    private Map<View, Integer> mViewPosMap = new HashMap<View, Integer>();
    /**
     * 子元素的宽度，高度,屏幕最多显示的个数
     */
    private int mChildWidth,mChildHeight,mCountOneScreen;

    private int mScreenWitdh;
    private CustomHorizontalScrollViewAdapter mAdapter;

    private LinearLayout mContainer;


    public CustomHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 获得屏幕宽度
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        mScreenWitdh = displayMetrics.widthPixels;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mContainer = (LinearLayout) getChildAt(0);
    }

    @Override
    public void onClick(View v) {
        if (onItemClickListener != null) {
            for (int i = 0; i < mContainer.getChildCount(); i++) {
                mContainer.getChildAt(i).setBackgroundColor(Color.WHITE);
            }
            onItemClickListener.onClick(v, mViewPosMap.get(v));
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_MOVE:
                int scrollX = getScrollX();
                // 如果当前scrollX为view的宽度，加载下一张，移除第一张
                if (scrollX >= mChildWidth) {
                    loadNextImg();
                }
                // 如果当前scrollX = 0， 往前设置一张，移除最后一张
                if (scrollX == 0) {
                    loadPreImg();
                }
                break;
        }
        return super.onTouchEvent(ev);
    }
    /**
     * 初始化数据，设置数据适配器
     *
     * @param mAdapter
     */
    public void initDatas(CustomHorizontalScrollViewAdapter mAdapter) {
        this.mAdapter = mAdapter;
        mContainer = (LinearLayout) getChildAt(0);
        // 获得适配器中第一个View
        View view = mAdapter.getView(0, null, mContainer);
        mContainer.addView(view);
        // 强制计算当前View的宽和高
        if (mChildHeight == 0 && mChildWidth == 0) {
            int w = View.MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
            int h = View.MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
            view.measure(w, h);
            mChildHeight = view.getMeasuredHeight();
            mChildWidth = view.getMeasuredWidth();

            // 计算每次加载多少个View
            mCountOneScreen = (mScreenWitdh / mChildWidth == 0) ?
                    mScreenWitdh / mChildWidth + 1 : mScreenWitdh / mChildWidth + 2;
        }
        //初始化第一屏幕的元素
        initFirstScreenChildren(mCountOneScreen);
    }

    /**
     * 加载第一屏的View
     *
     * @param mCountOneScreen
     */
    private void initFirstScreenChildren(int mCountOneScreen) {
        mContainer.removeAllViews();
        mViewPosMap.clear();

        for (int i = 0; i < mCountOneScreen; i++) {
            View view = mAdapter.getView(i, null, mContainer);
            view.setOnClickListener(this);
            mContainer.addView(view);
            mViewPosMap.put(view, i);
            mEndIndex = i;
        }

//        if (mListener != null) {
//            notifyCurrentImgChanged();
//        }
    }

    /**
     * 加载下一张图片
     */
    protected void loadNextImg() {
        // 数组边界值计算
        if (mEndIndex == mAdapter.getCount()) {
            return;
        }
        //移除第一张图片，且将水平滚动位置置0
        mContainer.removeViewAt(0);
        mViewPosMap.remove(mContainer.getChildAt(0));
        scrollTo(0,0);

    }
    /**
     * 加载上一张图片
     */
    protected void loadPreImg() {
        // 如果当前已经是第一张，则返回
        if (mFristIndex == 0) {
            return;
        }
        //获得当前应该显示为第一张图片的下标
        int index = mEndIndex - mCountOneScreen;
        if (index >= 0) {
            //移除最后一张
            int oldViewPos = mContainer.getChildCount() - 1;
            mViewPosMap.remove(mContainer.getChildAt(oldViewPos));
            mContainer.removeViewAt(oldViewPos);

            //将此View放入第一个位置，并且设置onclick事件，且加入容器中
            View view = mAdapter.getView(index, null, mContainer);
            view.setOnClickListener(this);
            mViewPosMap.put(view, index);
            mContainer.addView(view, 0);

            //水平滚动位置向左移动view的宽度个像素
            scrollTo(mChildWidth, 0);

            //当前位置--，当前第一个显示的下标--
            mEndIndex--;
            mFristIndex--;

            //如果设置了滚动监听则触发
//            if (mListener != null) {
//                notifyCurrentImgChanged();
//            }
        }

        //当前第一张图片小标
        mFristIndex++;
        //如果设置了滚动监听则触发
//        if (mListener != null) {
//            notifyCurrentImgChanged();
//        }
    }
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onClick(View view, int pos);
    }
    public void setOnItemClickListener(OnItemClickListener mOnClickListener) {
        this.onItemClickListener = mOnClickListener;
    }
}

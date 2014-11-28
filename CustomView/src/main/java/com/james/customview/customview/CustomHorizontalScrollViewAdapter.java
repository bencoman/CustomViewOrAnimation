package com.james.customview.customview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.james.customview.R;

import java.util.List;

/**
 * <p>CustomHorizontalViewAdapter [V1.0.0]</p>
 * <p>classes : com.james.customview.customview.CustomHorizontalViewAdapter</p>
 * <p>谭建建 Create at 2014/11/21 0021 10:18</p>
 */
public class CustomHorizontalScrollViewAdapter extends BaseAdapter{
    private Context mContext;
    private List<PicInfo> mPicInfos;
    private LayoutInflater mLayoutInflater;
    public CustomHorizontalScrollViewAdapter(Context mContext,List<PicInfo> picInfos){
        this.mContext=mContext;
        mLayoutInflater=LayoutInflater.from(mContext);
        this.mPicInfos=picInfos;
    }
    @Override
    public int getCount() {
        return mPicInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return mPicInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView=mLayoutInflater.inflate(R.layout.activity_index_gallery_item,parent,false);
            viewHolder.imageView=(ImageView)convertView.findViewById(R.id.id_index_gallery_item_image);
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder)convertView.getTag();
        }
        viewHolder.imageView.setImageResource(mPicInfos.get(position).getmImageId());
        return convertView;
    }

    private class ViewHolder{
        ImageView imageView;
    }

}

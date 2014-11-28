package com.james.customview.customview;

/**
 * <p>PicInfo [V1.0.0]</p>
 * <p>classes : com.james.customview.customview.PicInfo</p>
 * <p>谭建建 Create at 2014/11/21 0021 15:38</p>
 */
public class PicInfo {
    private int id;
    private Integer mImageId;
    private String name;

    public PicInfo(int id, Integer mImageId, String name) {
        this.id = id;
        this.mImageId = mImageId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getmImageId() {
        return mImageId;
    }

    public void setmImageId(Integer mImageId) {
        this.mImageId = mImageId;
    }
}

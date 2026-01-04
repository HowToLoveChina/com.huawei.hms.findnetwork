package com.huawei.hms.findnetwork.comm.request.bean;

/* loaded from: classes8.dex */
public class NavigationInfo {
    private String mExtendData;
    private int mFlag;
    private String mSn;
    private float[] mValue;

    public String getExtendData() {
        return this.mExtendData;
    }

    public int getFlag() {
        return this.mFlag;
    }

    public String getSn() {
        return this.mSn;
    }

    public float[] getValues() {
        float[] fArr = this.mValue;
        return fArr == null ? new float[0] : (float[]) fArr.clone();
    }

    public void setExtendData(String str) {
        this.mExtendData = str;
    }

    public void setFlag(int i10) {
        this.mFlag = i10;
    }

    public void setSn(String str) {
        this.mSn = str;
    }

    public void setValues(float[] fArr) {
        this.mValue = fArr == null ? new float[0] : (float[]) fArr.clone();
    }
}

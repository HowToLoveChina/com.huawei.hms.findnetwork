package com.huawei.hms.findnetwork.ultrasound.entity;

import java.util.Arrays;

/* loaded from: classes8.dex */
public class MeasureResult {
    private int mFlag;
    private float[] mValue;

    public MeasureResult(int i10, float[] fArr) {
        this.mFlag = i10;
        if (fArr != null) {
            this.mValue = (float[]) fArr.clone();
        }
    }

    public int getFlag() {
        return this.mFlag;
    }

    public float[] getValue() {
        float[] fArr = this.mValue;
        return fArr == null ? new float[0] : (float[]) fArr.clone();
    }

    public void setFlag(int i10) {
        this.mFlag = i10;
    }

    public void setValue(float[] fArr) {
        if (fArr != null) {
            this.mValue = (float[]) fArr.clone();
        }
    }

    public String toString() {
        return "MeasureResult{mFlag=" + this.mFlag + ", mValue=" + Arrays.toString(this.mValue) + '}';
    }
}

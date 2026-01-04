package com.huawei.hms.findnetwork.comm.request.bean;

/* loaded from: classes8.dex */
public class UltrasoundSettings {
    private int mTagStatus = 0;
    private long mUltrasoundTxTime = -1;
    private float mTemperature = -100.0f;
    private float mTimeBias = 0.0f;
    private long mStartUltrasoundMeasuringTime = -1;
    private int mAlpha = 2;

    public int getAlpha() {
        return this.mAlpha;
    }

    public long getStartUltrasoundMeasuringTime() {
        return this.mStartUltrasoundMeasuringTime;
    }

    public int getTagStatus() {
        return this.mTagStatus;
    }

    public float getTemperature() {
        return this.mTemperature;
    }

    public float getTimeBias() {
        return this.mTimeBias;
    }

    public long getUltrasoundTxTime() {
        return this.mUltrasoundTxTime;
    }

    public void setAlpha(int i10) {
        this.mAlpha = i10;
    }

    public void setStartUltrasoundMeasuringTime(long j10) {
        this.mStartUltrasoundMeasuringTime = j10;
    }

    public void setTagStatus(int i10) {
        this.mTagStatus = i10;
    }

    public void setTemperature(float f10) {
        this.mTemperature = f10;
    }

    public void setTimeBias(float f10) {
        this.mTimeBias = f10;
    }

    public void setUltrasoundTxTime(long j10) {
        this.mUltrasoundTxTime = j10;
    }

    public String toString() {
        return "UltrasoundSettings{mTagStatus=" + this.mTagStatus + ", mUltrasoundTxTime=" + this.mUltrasoundTxTime + ", mTemperature=" + this.mTemperature + ", mTimeBias=" + this.mTimeBias + ", mStartUltrasoundMeasuringTime=" + this.mStartUltrasoundMeasuringTime + ", mAlpha=" + this.mAlpha + '}';
    }
}

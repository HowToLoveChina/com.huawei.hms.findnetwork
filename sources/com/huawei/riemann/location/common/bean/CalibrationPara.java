package com.huawei.riemann.location.common.bean;

/* loaded from: classes5.dex */
public class CalibrationPara {
    private double wssScaleFactor = 1.0d;
    private double rollBias = 0.0d;
    private double pitchBias = 0.0d;
    private double yawBias = 0.0d;
    private double cn0MeanTh = 30.0d;
    private int interpBufferSize = 8;
    private int syncBufferSize = 15;
    private double reservedPara1 = 0.0d;
    private double reservedPara2 = 0.0d;

    public double getCn0MeanTh() {
        return this.cn0MeanTh;
    }

    public int getInterpBufferSize() {
        return this.interpBufferSize;
    }

    public double getPitchBias() {
        return this.pitchBias;
    }

    public double getReservedPara1() {
        return this.reservedPara1;
    }

    public double getReservedPara2() {
        return this.reservedPara2;
    }

    public double getRollBias() {
        return this.rollBias;
    }

    public int getSyncBufferSize() {
        return this.syncBufferSize;
    }

    public double getWssScaleFactor() {
        return this.wssScaleFactor;
    }

    public double getYawBias() {
        return this.yawBias;
    }

    public void setCn0MeanTh(double d10) {
        this.cn0MeanTh = d10;
    }

    public void setInterpBufferSize(int i10) {
        this.interpBufferSize = i10;
    }

    public void setPitchBias(double d10) {
        this.pitchBias = d10;
    }

    public void setReservedPara1(double d10) {
        this.reservedPara1 = d10;
    }

    public void setReservedPara2(double d10) {
        this.reservedPara2 = d10;
    }

    public void setRollBias(double d10) {
        this.rollBias = d10;
    }

    public void setSyncBufferSize(int i10) {
        this.syncBufferSize = i10;
    }

    public void setWssScaleFactor(double d10) {
        this.wssScaleFactor = d10;
    }

    public void setYawBias(double d10) {
        this.yawBias = d10;
    }

    public String toString() {
        return "CalibrationPara{wssScaleFactor=" + this.wssScaleFactor + ", rollBias=" + this.rollBias + ", pitchBias=" + this.pitchBias + ", yawBias=" + this.yawBias + ", cn0MeanTh=" + this.cn0MeanTh + ", interpBufferSize=" + this.interpBufferSize + ", syncBufferSize=" + this.syncBufferSize + ", reservedPara1=" + this.reservedPara1 + ", reservedPara2=" + this.reservedPara2 + '}';
    }
}

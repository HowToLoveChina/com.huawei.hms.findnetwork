package com.huawei.hms.findnetwork.comm.request.bean;

/* loaded from: classes8.dex */
public class FreqParam {
    public static final int ACTION_ACK = 2;
    public static final int ACTION_SYNC = 1;
    public static final int ACTION_UNCHANGED = 0;
    private int actionFlag = 0;
    private int circles;
    private int initFreq;
    private int interval;
    private int stepHeight;
    private int stepNums;
    private int stepWidth;

    public FreqParam(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.initFreq = i10;
        this.stepHeight = i11;
        this.stepWidth = i12;
        this.stepNums = i13;
        this.interval = i14;
        this.circles = i15;
    }

    public int getActionFlag() {
        return this.actionFlag;
    }

    public int getCircles() {
        return this.circles;
    }

    public int getInitFreq() {
        return this.initFreq;
    }

    public int getInterval() {
        return this.interval;
    }

    public int getStepHeight() {
        return this.stepHeight;
    }

    public int getStepNums() {
        return this.stepNums;
    }

    public int getStepWidth() {
        return this.stepWidth;
    }

    public void setActionFlag(int i10) {
        this.actionFlag = i10;
    }

    public void setCircles(int i10) {
        this.circles = i10;
    }

    public void setInitFreq(int i10) {
        this.initFreq = i10;
    }

    public void setInterval(int i10) {
        this.interval = i10;
    }

    public void setStepHeight(int i10) {
        this.stepHeight = i10;
    }

    public void setStepNums(int i10) {
        this.stepNums = i10;
    }

    public void setStepWidth(int i10) {
        this.stepWidth = i10;
    }
}

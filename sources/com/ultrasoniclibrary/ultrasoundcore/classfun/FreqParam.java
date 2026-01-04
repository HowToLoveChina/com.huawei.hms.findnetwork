package com.ultrasoniclibrary.ultrasoundcore.classfun;

/* loaded from: classes9.dex */
public class FreqParam {
    private int actionFlag;
    private int circles;
    private int initFreq;
    private int interval;
    private int stepHeight;
    private int stepNums;
    private int stepWidth;

    public FreqParam() {
        this.initFreq = 14000;
        this.stepHeight = 4;
        this.stepWidth = 50;
        this.stepNums = 1000;
        this.interval = 550;
        this.circles = 30;
        this.actionFlag = 0;
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

    public String toString() {
        return "initFreq: " + this.initFreq + "actionFlag: " + this.actionFlag;
    }

    public FreqParam(FreqParam freqParam) {
        this(freqParam.getInitFreq(), freqParam.getStepHeight(), freqParam.getStepWidth(), freqParam.getStepNums(), freqParam.getInterval(), freqParam.getCircles(), freqParam.getActionFlag());
    }

    public FreqParam(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        this.initFreq = i10;
        this.stepHeight = i11;
        this.stepWidth = i12;
        this.stepNums = i13;
        this.interval = i14;
        this.circles = i15;
        this.actionFlag = i16;
    }
}

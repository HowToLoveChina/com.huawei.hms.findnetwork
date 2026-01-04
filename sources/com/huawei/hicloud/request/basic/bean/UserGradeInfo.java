package com.huawei.hicloud.request.basic.bean;

/* loaded from: classes6.dex */
public class UserGradeInfo {
    private String gradeCode;
    private int gradeState = -1;
    private int dataPeriod = -1;
    private int remainRegretDays = -1;
    private int remainDwnldDays = -1;
    private int dwnldPeriodDays = -1;
    private int dwnldPeriod1Days = -1;
    private int dwnldPeriod2Days = -1;

    public int getDataPeriod() {
        return this.dataPeriod;
    }

    public int getDwnldPeriod1Days() {
        return this.dwnldPeriod1Days;
    }

    public int getDwnldPeriod2Days() {
        return this.dwnldPeriod2Days;
    }

    public int getDwnldPeriodDays() {
        return this.dwnldPeriodDays;
    }

    public String getGradeCode() {
        return this.gradeCode;
    }

    public int getGradeState() {
        return this.gradeState;
    }

    public int getRemainDwnldDays() {
        return this.remainDwnldDays;
    }

    public int getRemainRegretDays() {
        return this.remainRegretDays;
    }

    public void setDataPeriod(int i10) {
        this.dataPeriod = i10;
    }

    public void setDwnldPeriod1Days(int i10) {
        this.dwnldPeriod1Days = i10;
    }

    public void setDwnldPeriod2Days(int i10) {
        this.dwnldPeriod2Days = i10;
    }

    public void setDwnldPeriodDays(int i10) {
        this.dwnldPeriodDays = i10;
    }

    public void setGradeCode(String str) {
        this.gradeCode = str;
    }

    public void setGradeState(int i10) {
        this.gradeState = i10;
    }

    public void setRemainDwnldDays(int i10) {
        this.remainDwnldDays = i10;
    }

    public void setRemainRegretDays(int i10) {
        this.remainRegretDays = i10;
    }
}

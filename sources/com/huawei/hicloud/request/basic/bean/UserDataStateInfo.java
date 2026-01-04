package com.huawei.hicloud.request.basic.bean;

import java.io.Serializable;

/* loaded from: classes6.dex */
public class UserDataStateInfo implements Serializable {
    private static final long serialVersionUID = -5658302864772095924L;
    private String bsGrade;
    private long userdataExpiredTime;
    private int bmType = -1;
    private int dataRetentionDays = -1;
    private int bmGradeState = -1;
    private int dataPeriod = -1;
    private int remainRegretDays = -1;
    private int remainDwnldDays = -1;
    private int dwnldPeriodDays = -1;
    private int dwnldPeriod1Days = -1;
    private int dwnldPeriod2Days = -1;
    private int userdataRemainDays = -1;
    private long bsDsuCloudUsage = -1;

    public int getBmGradeState() {
        return this.bmGradeState;
    }

    public int getBmType() {
        return this.bmType;
    }

    public long getBsDsuCloudUsage() {
        return this.bsDsuCloudUsage;
    }

    public String getBsGrade() {
        return this.bsGrade;
    }

    public int getDataPeriod() {
        return this.dataPeriod;
    }

    public int getDataRetentionDays() {
        return this.dataRetentionDays;
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

    public int getRemainDwnldDays() {
        return this.remainDwnldDays;
    }

    public int getRemainRegretDays() {
        return this.remainRegretDays;
    }

    public long getUserdataExpiredTime() {
        return this.userdataExpiredTime;
    }

    public int getUserdataRemainDays() {
        return this.userdataRemainDays;
    }

    public void setBmGradeState(int i10) {
        this.bmGradeState = i10;
    }

    public void setBmType(int i10) {
        this.bmType = i10;
    }

    public void setBsDsuCloudUsage(long j10) {
        this.bsDsuCloudUsage = j10;
    }

    public void setBsGrade(String str) {
        this.bsGrade = str;
    }

    public void setDataPeriod(int i10) {
        this.dataPeriod = i10;
    }

    public void setDataRetentionDays(int i10) {
        this.dataRetentionDays = i10;
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

    public void setRemainDwnldDays(int i10) {
        this.remainDwnldDays = i10;
    }

    public void setRemainRegretDays(int i10) {
        this.remainRegretDays = i10;
    }

    public void setUserdataExpiredTime(long j10) {
        this.userdataExpiredTime = j10;
    }

    public void setUserdataRemainDays(int i10) {
        this.userdataRemainDays = i10;
    }

    public String toString() {
        return "UserDataStateInfo{bsGrade='" + this.bsGrade + "', bmType=" + this.bmType + ", dataRetentionDays=" + this.dataRetentionDays + ", bmGradeState=" + this.bmGradeState + ", userdataExpiredTime=" + this.userdataExpiredTime + ", dataPeriod=" + this.dataPeriod + ", remainRegretDays=" + this.remainRegretDays + ", remainDwnldDays=" + this.remainDwnldDays + ", dwnldPeriodDays=" + this.dwnldPeriodDays + ", dwnldPeriod1Days=" + this.dwnldPeriod1Days + ", dwnldPeriod2Days=" + this.dwnldPeriod2Days + ", userdataRemainDays=" + this.userdataRemainDays + '}';
    }
}

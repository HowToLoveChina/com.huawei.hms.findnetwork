package com.huawei.hicloud.notification.p106db.bean;

/* loaded from: classes6.dex */
public class SNTimes {
    private int day;
    private int month;
    private long time;
    private int week;
    private int year;

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public long getTime() {
        return this.time;
    }

    public int getWeek() {
        return this.week;
    }

    public int getYear() {
        return this.year;
    }

    public void setDay(int i10) {
        this.day = i10;
    }

    public void setMonth(int i10) {
        this.month = i10;
    }

    public void setTime(long j10) {
        this.time = j10;
    }

    public void setWeek(int i10) {
        this.week = i10;
    }

    public void setYear(int i10) {
        this.year = i10;
    }

    public String toString() {
        return "time=" + this.time + " week=" + this.week + " day=" + this.day + " month=" + this.month + " year=" + this.year;
    }
}

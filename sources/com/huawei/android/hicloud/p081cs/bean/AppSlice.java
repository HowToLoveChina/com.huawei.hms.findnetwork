package com.huawei.android.hicloud.p081cs.bean;

/* loaded from: classes3.dex */
public class AppSlice {
    private long end;
    private String rangePath;
    private String rangemd5;
    private String rangesha256;
    private long start;

    public AppSlice(String str, long j10, long j11, String str2, String str3) {
        this.rangePath = str;
        this.start = j10;
        this.end = j11;
        this.rangemd5 = str2;
        this.rangesha256 = str3;
    }

    public long getEnd() {
        return this.end;
    }

    public String getRangePath() {
        return this.rangePath;
    }

    public String getRangemd5() {
        return this.rangemd5;
    }

    public String getRangesha256() {
        return this.rangesha256;
    }

    public long getStart() {
        return this.start;
    }

    public void setEnd(long j10) {
        this.end = j10;
    }

    public void setRangePath(String str) {
        this.rangePath = str;
    }

    public void setRangemd5(String str) {
        this.rangemd5 = str;
    }

    public void setRangesha256(String str) {
        this.rangesha256 = str;
    }

    public void setStart(long j10) {
        this.start = j10;
    }
}

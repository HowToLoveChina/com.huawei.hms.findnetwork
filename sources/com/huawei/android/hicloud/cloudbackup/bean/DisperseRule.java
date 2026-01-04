package com.huawei.android.hicloud.cloudbackup.bean;

/* loaded from: classes2.dex */
public class DisperseRule {
    int delaySegment;
    String left;
    String right;

    public int getDelaySegment() {
        return this.delaySegment;
    }

    public String getLeft() {
        return this.left;
    }

    public String getRight() {
        return this.right;
    }

    public void setDelaySegment(int i10) {
        this.delaySegment = i10;
    }

    public void setLeft(String str) {
        this.left = str;
    }

    public void setRight(String str) {
        this.right = str;
    }

    public String toString() {
        return "DisperseRule{delaySegment=" + this.delaySegment + ", left='" + this.left + "', right='" + this.right + "'}";
    }
}

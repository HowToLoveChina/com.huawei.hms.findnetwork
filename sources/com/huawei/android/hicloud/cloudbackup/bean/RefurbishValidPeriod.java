package com.huawei.android.hicloud.cloudbackup.bean;

/* loaded from: classes2.dex */
public class RefurbishValidPeriod {
    private int refurbishFirstRemainingPeriod;
    private int refurbishSecondRemainingPeriod;

    public boolean checkValidityConfiguration(int i10) {
        int i11;
        int i12 = this.refurbishFirstRemainingPeriod;
        return i12 > 0 && (i11 = this.refurbishSecondRemainingPeriod) > 0 && i10 > i12 && i10 > i11 && i12 > i11;
    }

    public int getRefurbishFirstRemainingPeriod() {
        return this.refurbishFirstRemainingPeriod;
    }

    public int getRefurbishSecondRemainingPeriod() {
        return this.refurbishSecondRemainingPeriod;
    }

    public void setRefurbishFirstRemainingPeriod(int i10) {
        this.refurbishFirstRemainingPeriod = i10;
    }

    public void setRefurbishSecondRemainingPeriod(int i10) {
        this.refurbishSecondRemainingPeriod = i10;
    }

    public String toString() {
        return "RefurbishValidPeriod{refurbishFirstRemainingPeriod=" + this.refurbishFirstRemainingPeriod + ", refurbishSecondRemainingPeriod=" + this.refurbishSecondRemainingPeriod + '}';
    }
}

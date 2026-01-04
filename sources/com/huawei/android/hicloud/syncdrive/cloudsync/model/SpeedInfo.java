package com.huawei.android.hicloud.syncdrive.cloudsync.model;

import ni.C11707b;

/* loaded from: classes3.dex */
public class SpeedInfo extends C11707b {
    private double timeAppConnect;
    private double timeConnect;
    private double timeNameLookup;
    private double timePreTransfer;
    private double timeRedirect;
    private double timeStartTransfer;
    private double timeTotal;

    public double getTimeAppConnect() {
        return this.timeAppConnect;
    }

    public double getTimeConnect() {
        return this.timeConnect;
    }

    public double getTimeNameLookup() {
        return this.timeNameLookup;
    }

    public double getTimePreTransfer() {
        return this.timePreTransfer;
    }

    public double getTimeRedirect() {
        return this.timeRedirect;
    }

    public double getTimeStartTransfer() {
        return this.timeStartTransfer;
    }

    public double getTimeTotal() {
        return this.timeTotal;
    }

    public void setTimeAppConnect(double d10) {
        this.timeAppConnect = d10;
    }

    public void setTimeConnect(double d10) {
        this.timeConnect = d10;
    }

    public void setTimeNameLookup(double d10) {
        this.timeNameLookup = d10;
    }

    public void setTimePreTransfer(double d10) {
        this.timePreTransfer = d10;
    }

    public void setTimeRedirect(double d10) {
        this.timeRedirect = d10;
    }

    public void setTimeStartTransfer(double d10) {
        this.timeStartTransfer = d10;
    }

    public void setTimeTotal(double d10) {
        this.timeTotal = d10;
    }
}

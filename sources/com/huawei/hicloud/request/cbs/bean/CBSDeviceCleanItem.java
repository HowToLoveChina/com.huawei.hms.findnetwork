package com.huawei.hicloud.request.cbs.bean;

/* loaded from: classes6.dex */
public class CBSDeviceCleanItem {
    private CBSDevice cbsDevice;
    private boolean isChecked;
    private boolean isCurrent;
    private boolean sendPush;

    public CBSDeviceCleanItem(boolean z10, CBSDevice cBSDevice) {
        this.isChecked = z10;
        this.cbsDevice = cBSDevice;
    }

    public CBSDevice getCbsDevice() {
        return this.cbsDevice;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public boolean isCurrent() {
        return this.isCurrent;
    }

    public boolean isSendPush() {
        return this.sendPush;
    }

    public void setCbsDevice(CBSDevice cBSDevice) {
        this.cbsDevice = cBSDevice;
    }

    public void setChecked(boolean z10) {
        this.isChecked = z10;
    }

    public void setCurrent(boolean z10) {
        this.isCurrent = z10;
    }

    public void setSendPush(boolean z10) {
        this.sendPush = z10;
    }
}

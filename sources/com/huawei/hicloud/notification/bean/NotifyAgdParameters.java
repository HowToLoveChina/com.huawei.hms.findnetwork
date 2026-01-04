package com.huawei.hicloud.notification.bean;

/* loaded from: classes6.dex */
public class NotifyAgdParameters {
    private int enabled;
    private String slotId;
    private int threshold;

    public NotifyAgdParameters(int i10, String str, int i11) {
        this.enabled = i10;
        this.slotId = str;
        this.threshold = i11;
    }

    public int getEnabled() {
        return this.enabled;
    }

    public String getSlotId() {
        return this.slotId;
    }

    public int getThreshold() {
        return this.threshold;
    }

    public void setEnabled(int i10) {
        this.enabled = i10;
    }

    public void setSlotId(String str) {
        this.slotId = str;
    }

    public void setThreshold(int i10) {
        this.threshold = i10;
    }
}

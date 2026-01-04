package com.huawei.hicloud.request.notify.bean;

/* loaded from: classes6.dex */
public class NotifyResult {
    private String name;
    private boolean needNotify;

    public String getName() {
        return this.name;
    }

    public boolean isNeedNotify() {
        return this.needNotify;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNeedNotify(boolean z10) {
        this.needNotify = z10;
    }

    public String toString() {
        return "NotifyResult{name='" + this.name + "', needNotify=" + this.needNotify + '}';
    }
}

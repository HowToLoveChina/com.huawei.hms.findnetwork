package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes3.dex */
public class Quota extends C11707b {

    @InterfaceC4648p
    private String usedSpace;

    @InterfaceC4648p
    private String userCapacity;

    public String getUsedSpace() {
        return this.usedSpace;
    }

    public String getUserCapacity() {
        return this.userCapacity;
    }

    public void setUsedSpace(String str) {
        this.usedSpace = str;
    }

    public void setUserCapacity(String str) {
        this.userCapacity = str;
    }
}

package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes3.dex */
public class Attachment extends C11707b {

    @InterfaceC4648p
    private Asset asset;

    @InterfaceC4648p
    private String usage;

    public Asset getAsset() {
        return this.asset;
    }

    public String getUsage() {
        return this.usage;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public void setUsage(String str) {
        this.usage = str;
    }
}

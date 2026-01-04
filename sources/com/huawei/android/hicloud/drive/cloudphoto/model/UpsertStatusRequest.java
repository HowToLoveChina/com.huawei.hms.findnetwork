package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes3.dex */
public class UpsertStatusRequest extends C11707b {

    @InterfaceC4648p
    private String key;

    @InterfaceC4648p
    private String status;

    public String getKey() {
        return this.key;
    }

    public String getStatus() {
        return this.status;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}

package com.huawei.hicloud.base.drive.user.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes6.dex */
public class PublicKey extends C11707b {

    @InterfaceC4648p
    private String publicKey;

    @InterfaceC4648p
    private String version;

    public String getPublicKey() {
        return this.publicKey;
    }

    public String getVersion() {
        return this.version;
    }

    public void setPublicKey(String str) {
        this.publicKey = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}

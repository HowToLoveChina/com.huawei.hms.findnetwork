package com.huawei.android.hicloud.syncdrive.cloudsync.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes3.dex */
public class ResourceCreateReq extends C11707b {

    @InterfaceC4648p
    private String hash;

    @InterfaceC4648p
    private Long length;

    @InterfaceC4648p
    private String sha256;

    public String getHash() {
        return this.hash;
    }

    public Long getLength() {
        return this.length;
    }

    public String getSha256() {
        return this.sha256;
    }

    public ResourceCreateReq setHash(String str) {
        this.hash = str;
        return this;
    }

    public ResourceCreateReq setLength(Long l10) {
        this.length = l10;
        return this;
    }

    public ResourceCreateReq setSha256(String str) {
        this.sha256 = str;
        return this;
    }
}

package com.huawei.android.hicloud.drive.clouddisk.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes3.dex */
public class Attachment extends C11707b {

    @InterfaceC4648p
    private Asset asset;

    @InterfaceC4648p
    private String assetId;

    @InterfaceC4648p
    private String usage;

    @InterfaceC4648p
    private String versionId;

    public Asset getAsset() {
        return this.asset;
    }

    public String getAssetId() {
        return this.assetId;
    }

    public String getUsage() {
        return this.usage;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public void setAssetId(String str) {
        this.assetId = str;
    }

    public void setUsage(String str) {
        this.usage = str;
    }

    public void setVersionId(String str) {
        this.versionId = str;
    }
}

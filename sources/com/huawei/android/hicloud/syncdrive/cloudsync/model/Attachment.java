package com.huawei.android.hicloud.syncdrive.cloudsync.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.Objects;
import ni.C11707b;

/* loaded from: classes3.dex */
public class Attachment extends C11707b {

    @InterfaceC4648p
    private Asset asset;

    @InterfaceC4648p
    private String assetId;

    @InterfaceC4648p
    private String hash;

    @InterfaceC4648p
    private long length;

    @InterfaceC4648p
    private String sha256;

    @InterfaceC4648p
    private Integer status;

    @InterfaceC4648p
    private String usage;

    @InterfaceC4648p
    private String versionId;

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Attachment) || !super.equals(obj)) {
            return false;
        }
        Attachment attachment = (Attachment) obj;
        return Objects.equals(getAsset(), attachment.getAsset()) && Objects.equals(getUsage(), attachment.getUsage()) && Objects.equals(getHash(), attachment.getHash()) && Objects.equals(getAssetId(), attachment.getAssetId()) && Objects.equals(getVersionId(), attachment.getVersionId());
    }

    public Asset getAsset() {
        return this.asset;
    }

    public String getAssetId() {
        return this.assetId;
    }

    public String getHash() {
        return this.hash;
    }

    public long getLength() {
        return this.length;
    }

    public String getSha256() {
        return this.sha256;
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getUsage() {
        return this.usage;
    }

    public String getVersionId() {
        return this.versionId;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), getAsset(), getUsage(), getHash(), getAssetId(), getVersionId());
    }

    public Attachment setAsset(Asset asset) {
        this.asset = asset;
        return this;
    }

    public Attachment setAssetId(String str) {
        this.assetId = str;
        return this;
    }

    public Attachment setHash(String str) {
        this.hash = str;
        return this;
    }

    public Attachment setLength(long j10) {
        this.length = j10;
        return this;
    }

    public Attachment setSha256(String str) {
        this.sha256 = str;
        return this;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public Attachment setUsage(String str) {
        this.usage = str;
        return this;
    }

    public Attachment setVersionId(String str) {
        this.versionId = str;
        return this;
    }

    @Override // ni.C11707b, java.util.AbstractMap
    public String toString() {
        return "Attachment{usage='" + this.usage + "', hash='" + this.hash + "', hash='" + this.hash + "', assetId='" + this.assetId + '}';
    }
}

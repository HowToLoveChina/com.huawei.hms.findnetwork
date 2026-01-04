package com.huawei.android.hicloud.syncdrive.cloudsync.model;

import ni.C11707b;

/* loaded from: classes3.dex */
public class AssetInfo extends C11707b {
    private Asset asset;
    private String database;
    private String hash;
    private String kind;
    private String recordId;
    private String usage;

    public Asset getAsset() {
        return this.asset;
    }

    public String getDatabase() {
        return this.database;
    }

    public String getHash() {
        return this.hash;
    }

    public String getKind() {
        return this.kind;
    }

    public String getRecordId() {
        return this.recordId;
    }

    public String getUsage() {
        return this.usage;
    }

    public AssetInfo setAsset(Asset asset) {
        this.asset = asset;
        return this;
    }

    public AssetInfo setDatabase(String str) {
        this.database = str;
        return this;
    }

    public AssetInfo setHash(String str) {
        this.hash = str;
        return this;
    }

    public AssetInfo setKind(String str) {
        this.kind = str;
        return this;
    }

    public AssetInfo setRecordId(String str) {
        this.recordId = str;
        return this;
    }

    public AssetInfo setUsage(String str) {
        this.usage = str;
        return this;
    }
}

package com.huawei.android.remotecontrol.trustchange;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
public class SelectInfo {

    @SerializedName("AssetHandle")
    private String assetHandle = "";

    @SerializedName("AssetType")
    private String assetType = "";

    @SerializedName("DataCreator")
    private String dataCreator = "";

    @SerializedName("DataOwner")
    private String dataOwner = "";

    @SerializedName("IsDelete")
    private String isDelete = "";

    @SerializedName("IsDirty")
    private String isDirty = "";

    @SerializedName("KeyAlg")
    private String keyAlg = "";

    @SerializedName("KeyAlias")
    private String keyAlias = "";

    @SerializedName("KeyOutGoingType")
    private String keyOutGoingType = "";

    @SerializedName("KeyPurpose")
    private String keyPurpose = "";

    @SerializedName("SyncAccountUid")
    private String syncAccountUid = "";

    @SerializedName("TeeStorage")
    private String teeStorage = "";

    public String getAssetHandle() {
        return this.assetHandle;
    }

    public String getAssetType() {
        return this.assetType;
    }

    public String getDataCreator() {
        return this.dataCreator;
    }

    public String getDataOwner() {
        return this.dataOwner;
    }

    public String getIsDelete() {
        return this.isDelete;
    }

    public String getIsDirty() {
        return this.isDirty;
    }

    public String getKeyAlg() {
        return this.keyAlg;
    }

    public String getKeyAlias() {
        return this.keyAlias;
    }

    public String getKeyOutGoingType() {
        return this.keyOutGoingType;
    }

    public String getKeyPurpose() {
        return this.keyPurpose;
    }

    public String getSyncAccountUid() {
        return this.syncAccountUid;
    }

    public String getTeeStorage() {
        return this.teeStorage;
    }

    public void setAssetHandle(String str) {
        this.assetHandle = str;
    }

    public void setAssetType(String str) {
        this.assetType = str;
    }

    public void setDataCreator(String str) {
        this.dataCreator = str;
    }

    public void setDataOwner(String str) {
        this.dataOwner = str;
    }

    public void setIsDelete(String str) {
        this.isDelete = str;
    }

    public void setIsDirty(String str) {
        this.isDirty = str;
    }

    public void setKeyAlg(String str) {
        this.keyAlg = str;
    }

    public void setKeyAlias(String str) {
        this.keyAlias = str;
    }

    public void setKeyOutGoingType(String str) {
        this.keyOutGoingType = str;
    }

    public void setKeyPurpose(String str) {
        this.keyPurpose = str;
    }

    public void setSyncAccountUid(String str) {
        this.syncAccountUid = str;
    }

    public void setTeeStorage(String str) {
        this.teeStorage = str;
    }
}

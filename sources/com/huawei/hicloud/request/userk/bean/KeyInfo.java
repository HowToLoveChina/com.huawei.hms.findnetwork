package com.huawei.hicloud.request.userk.bean;

/* loaded from: classes6.dex */
public class KeyInfo {
    private int dataType;
    private String key;
    private String keySHA256;
    private int keyType;
    private String keyUuid;

    public int getDataType() {
        return this.dataType;
    }

    public String getKey() {
        return this.key;
    }

    public String getKeySHA256() {
        return this.keySHA256;
    }

    public int getKeyType() {
        return this.keyType;
    }

    public String getKeyUuid() {
        return this.keyUuid;
    }

    public void setDataType(int i10) {
        this.dataType = i10;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setKeySHA256(String str) {
        this.keySHA256 = str;
    }

    public void setKeyType(int i10) {
        this.keyType = i10;
    }

    public void setKeyUuid(String str) {
        this.keyUuid = str;
    }
}

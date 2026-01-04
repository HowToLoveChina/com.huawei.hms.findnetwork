package com.huawei.android.hicloud.security.bean;

/* loaded from: classes3.dex */
public class EncryptedData {
    private String data;
    private String edek;
    private String extensionData;
    private String keyGuid;

    public String getData() {
        return this.data;
    }

    public String getEdek() {
        return this.edek;
    }

    public String getExtensionData() {
        return this.extensionData;
    }

    public String getKeyGuid() {
        return this.keyGuid;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setEdek(String str) {
        this.edek = str;
    }

    public void setExtensionData(String str) {
        this.extensionData = str;
    }

    public void setKeyGuid(String str) {
        this.keyGuid = str;
    }
}

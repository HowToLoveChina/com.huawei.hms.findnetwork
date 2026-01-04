package com.huawei.android.hicloud.sync.bean;

import com.huawei.android.hicloud.sync.service.aidl.UnstructData;

/* loaded from: classes3.dex */
public class Usage {
    private String recordId;
    private UnstructData unstructData;
    private String usage;

    public Usage(String str, String str2) {
        this.recordId = str;
        this.usage = str2;
    }

    public String getRecordId() {
        return this.recordId;
    }

    public UnstructData getUnstructData() {
        return this.unstructData;
    }

    public String getUsage() {
        return this.usage;
    }

    public void setRecordId(String str) {
        this.recordId = str;
    }

    public void setUnstructData(UnstructData unstructData) {
        this.unstructData = unstructData;
    }

    public void setUsage(String str) {
        this.usage = str;
    }

    public String toString() {
        return "Usage{recordId='" + this.recordId + "', usage='" + this.usage + "', unstructData=" + this.unstructData + '}';
    }

    public Usage(String str, String str2, UnstructData unstructData) {
        this.recordId = str;
        this.usage = str2;
        this.unstructData = unstructData;
    }
}

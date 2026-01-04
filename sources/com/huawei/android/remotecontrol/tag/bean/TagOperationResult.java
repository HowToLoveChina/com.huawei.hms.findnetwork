package com.huawei.android.remotecontrol.tag.bean;

/* loaded from: classes4.dex */
public class TagOperationResult<T> extends TagLocalFindResult {
    private T mData;

    public TagOperationResult(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
    }

    public T getData() {
        return this.mData;
    }

    public void setData(T t10) {
        this.mData = t10;
    }
}

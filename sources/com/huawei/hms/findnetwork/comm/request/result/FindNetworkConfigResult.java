package com.huawei.hms.findnetwork.comm.request.result;

/* loaded from: classes8.dex */
public class FindNetworkConfigResult<T> {
    private T mData;
    private String mDescription;
    private int mRespCode;

    public FindNetworkConfigResult() {
    }

    public FindNetworkConfigResult(int i10, String str, T t10) {
        this.mRespCode = i10;
        this.mDescription = str;
        this.mData = t10;
    }

    public T getData() {
        return this.mData;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public int getRespCode() {
        return this.mRespCode;
    }

    public void setData(T t10) {
        this.mData = t10;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public void setRespCode(int i10) {
        this.mRespCode = i10;
    }
}

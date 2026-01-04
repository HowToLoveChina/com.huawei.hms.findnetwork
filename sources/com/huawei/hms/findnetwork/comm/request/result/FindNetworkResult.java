package com.huawei.hms.findnetwork.comm.request.result;

/* loaded from: classes8.dex */
public class FindNetworkResult<T> {
    private T mData;
    private String mDescription;
    private int mRespCode;
    private String mSrcTransId;

    public FindNetworkResult() {
    }

    public FindNetworkResult(int i10, String str, T t10) {
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

    public String getSrcTransId() {
        return this.mSrcTransId;
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

    public void setSrcTransId(String str) {
        this.mSrcTransId = str;
    }
}

package com.huawei.hms.findnetwork.comm.request.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes8.dex */
public class FindNetworkRequestBean<T> extends BaseRequestBean {

    @SerializedName("data")
    private T data;

    public FindNetworkRequestBean(T t10) {
        this.data = t10;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T t10) {
        this.data = t10;
    }
}

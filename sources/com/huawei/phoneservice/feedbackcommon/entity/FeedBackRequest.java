package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class FeedBackRequest {

    @SerializedName("accessToken")
    private String accessToken;

    @SerializedName("orderType")
    private int orderType;

    @SerializedName("pageSize")
    private int pageSize;

    @SerializedName("problemId")
    private String problemId;

    @SerializedName("problemSourceCode")
    private String problemSourceCode;

    @SerializedName("startWith")
    private String startWith;

    public String getAccessToken() {
        return this.accessToken;
    }

    public int getOrderType() {
        return this.orderType;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public String getProblemId() {
        return this.problemId;
    }

    public String getProblemSourceCode() {
        return this.problemSourceCode;
    }

    public String getStartWith() {
        return this.startWith;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setOrderType(int i10) {
        this.orderType = i10;
    }

    public void setPageSize(int i10) {
        this.pageSize = i10;
    }

    public void setProblemId(String str) {
        this.problemId = str;
    }

    public void setProblemSourceCode(String str) {
        this.problemSourceCode = str;
    }

    public void setStartWith(String str) {
        this.startWith = str;
    }
}

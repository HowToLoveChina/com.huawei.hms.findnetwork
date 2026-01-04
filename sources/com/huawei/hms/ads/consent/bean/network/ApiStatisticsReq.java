package com.huawei.hms.ads.consent.bean.network;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@DataKeep
/* loaded from: classes8.dex */
public class ApiStatisticsReq {
    private String apiName;
    private long callTime = System.currentTimeMillis();
    private long costTime;
    private String params;
    private int result;
    private int resultCode;
    private String service;

    @OuterVisible
    public com.huawei.openalliance.p169ad.beans.inner.ApiStatisticsReq convert() {
        com.huawei.openalliance.p169ad.beans.inner.ApiStatisticsReq apiStatisticsReq = new com.huawei.openalliance.p169ad.beans.inner.ApiStatisticsReq();
        apiStatisticsReq.m39361a(getService());
        apiStatisticsReq.m39365b(getApiName());
        apiStatisticsReq.m39358a(getResult());
        apiStatisticsReq.m39363b(getResultCode());
        apiStatisticsReq.m39359a(getCallTime());
        apiStatisticsReq.m39364b(getCostTime());
        apiStatisticsReq.m39368c(getParams());
        return apiStatisticsReq;
    }

    @OuterVisible
    public String getApiName() {
        return this.apiName;
    }

    @OuterVisible
    public long getCallTime() {
        return this.callTime;
    }

    @OuterVisible
    public long getCostTime() {
        return this.costTime;
    }

    @OuterVisible
    public String getParams() {
        return this.params;
    }

    @OuterVisible
    public int getResult() {
        return this.result;
    }

    @OuterVisible
    public int getResultCode() {
        return this.resultCode;
    }

    @OuterVisible
    public String getService() {
        return this.service;
    }

    @OuterVisible
    public void setApiName(String str) {
        this.apiName = str;
    }

    @OuterVisible
    public void setCallTime(long j10) {
        this.callTime = j10;
    }

    @OuterVisible
    public void setCostTime(long j10) {
        this.costTime = j10;
    }

    @OuterVisible
    public void setParams(String str) {
        this.params = str;
    }

    @OuterVisible
    public void setResult(int i10) {
        this.result = i10;
    }

    @OuterVisible
    public void setResultCode(int i10) {
        this.resultCode = i10;
    }

    @OuterVisible
    public void setService(String str) {
        this.service = str;
    }
}

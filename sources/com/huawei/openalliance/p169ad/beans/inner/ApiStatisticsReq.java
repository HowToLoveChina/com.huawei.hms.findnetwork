package com.huawei.openalliance.p169ad.beans.inner;

import com.huawei.openalliance.p169ad.beans.metadata.DelayInfo;

/* loaded from: classes8.dex */
public class ApiStatisticsReq {
    private int adType;
    private String additionId;
    private String apiName;
    private long callTime;
    private String contentId;
    private long costTime;
    private DelayInfo delayInfo;
    private String isLimitTracking;
    private String oaid;
    private String params;
    private String requestId;
    private int requestType;
    private int result;
    private int resultCode;
    private String service;

    public ApiStatisticsReq() {
        this.callTime = System.currentTimeMillis();
        this.adType = -1;
        this.requestType = 0;
    }

    /* renamed from: a */
    public String m39357a() {
        return this.service;
    }

    /* renamed from: b */
    public String m39362b() {
        return this.apiName;
    }

    /* renamed from: c */
    public int m39366c() {
        return this.result;
    }

    /* renamed from: d */
    public int m39369d() {
        return this.resultCode;
    }

    /* renamed from: e */
    public long m39372e() {
        return this.callTime;
    }

    /* renamed from: f */
    public long m39373f() {
        return this.costTime;
    }

    /* renamed from: g */
    public String m39374g() {
        return this.params;
    }

    /* renamed from: h */
    public String m39375h() {
        return this.additionId;
    }

    /* renamed from: i */
    public String m39376i() {
        return this.isLimitTracking;
    }

    /* renamed from: j */
    public String m39377j() {
        return this.requestId;
    }

    /* renamed from: k */
    public int m39378k() {
        return this.adType;
    }

    /* renamed from: l */
    public int m39379l() {
        return this.requestType;
    }

    /* renamed from: m */
    public String m39380m() {
        return this.contentId;
    }

    /* renamed from: n */
    public DelayInfo m39381n() {
        return this.delayInfo;
    }

    public ApiStatisticsReq(com.huawei.hms.ads.consent.bean.network.ApiStatisticsReq apiStatisticsReq) {
        this.callTime = System.currentTimeMillis();
        this.adType = -1;
        this.requestType = 0;
        if (apiStatisticsReq != null) {
            this.service = apiStatisticsReq.getService();
            this.apiName = apiStatisticsReq.getApiName();
            this.result = apiStatisticsReq.getResult();
            this.resultCode = apiStatisticsReq.getResultCode();
            this.callTime = apiStatisticsReq.getCallTime();
            this.costTime = apiStatisticsReq.getCostTime();
            this.params = apiStatisticsReq.getParams();
        }
    }

    /* renamed from: a */
    public void m39358a(int i10) {
        this.result = i10;
    }

    /* renamed from: b */
    public void m39363b(int i10) {
        this.resultCode = i10;
    }

    /* renamed from: c */
    public void m39367c(int i10) {
        this.adType = i10;
    }

    /* renamed from: d */
    public void m39370d(int i10) {
        this.requestType = i10;
    }

    /* renamed from: a */
    public void m39359a(long j10) {
        this.callTime = j10;
    }

    /* renamed from: b */
    public void m39364b(long j10) {
        this.costTime = j10;
    }

    /* renamed from: c */
    public void m39368c(String str) {
        this.params = str;
    }

    /* renamed from: d */
    public void m39371d(String str) {
        this.requestId = str;
    }

    /* renamed from: a */
    public void m39360a(DelayInfo delayInfo) {
        this.delayInfo = delayInfo;
    }

    /* renamed from: b */
    public void m39365b(String str) {
        this.apiName = str;
    }

    /* renamed from: a */
    public void m39361a(String str) {
        this.service = str;
    }
}

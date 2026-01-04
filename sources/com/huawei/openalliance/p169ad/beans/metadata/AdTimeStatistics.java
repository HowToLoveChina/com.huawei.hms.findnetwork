package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes8.dex */
public class AdTimeStatistics {
    long adInfoPrepEndTS;
    long adLoadEndTS;
    long adLoadStartTS;
    long adNetReqEndTS;
    long adNetReqStartTS;
    long adPhyReqEndTS;
    long adPhyReqStartTS;
    long adRspParseEndTS;
    long adRspParseStartTS;
    long splashAdDownloadTS;
    long splashAdMaterialLoadedTS;

    /* renamed from: a */
    public long m39557a() {
        return this.adLoadStartTS;
    }

    /* renamed from: b */
    public long m39559b() {
        return this.adLoadEndTS;
    }

    /* renamed from: c */
    public long m39561c() {
        return this.adInfoPrepEndTS;
    }

    /* renamed from: d */
    public long m39563d() {
        return this.adPhyReqStartTS;
    }

    /* renamed from: e */
    public long m39565e() {
        return this.adPhyReqEndTS;
    }

    /* renamed from: f */
    public long m39567f() {
        return this.adRspParseStartTS;
    }

    /* renamed from: g */
    public long m39569g() {
        return this.adRspParseEndTS;
    }

    /* renamed from: h */
    public long m39571h() {
        return this.splashAdDownloadTS;
    }

    /* renamed from: i */
    public long m39573i() {
        return this.splashAdMaterialLoadedTS;
    }

    /* renamed from: j */
    public void m39575j(long j10) {
        this.splashAdDownloadTS = j10;
    }

    /* renamed from: k */
    public void m39576k(long j10) {
        this.splashAdMaterialLoadedTS = j10;
    }

    /* renamed from: a */
    public void m39558a(long j10) {
        this.adLoadStartTS = j10;
    }

    /* renamed from: b */
    public void m39560b(long j10) {
        this.adLoadEndTS = j10;
    }

    /* renamed from: c */
    public void m39562c(long j10) {
        this.adInfoPrepEndTS = j10;
    }

    /* renamed from: d */
    public void m39564d(long j10) {
        this.adPhyReqStartTS = j10;
    }

    /* renamed from: e */
    public void m39566e(long j10) {
        this.adPhyReqEndTS = j10;
    }

    /* renamed from: f */
    public void m39568f(long j10) {
        this.adNetReqStartTS = j10;
    }

    /* renamed from: g */
    public void m39570g(long j10) {
        this.adNetReqEndTS = j10;
    }

    /* renamed from: h */
    public void m39572h(long j10) {
        this.adRspParseStartTS = j10;
    }

    /* renamed from: i */
    public void m39574i(long j10) {
        this.adRspParseEndTS = j10;
    }
}

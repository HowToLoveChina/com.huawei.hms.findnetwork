package com.huawei.openalliance.p169ad.inter.data;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@DataKeep
/* loaded from: classes2.dex */
public class AdEventRecord {

    /* renamed from: ad */
    private IAd f33545ad;
    private long endTime;
    private Long eventTime;
    private String eventType;
    private Boolean impWithClick = null;
    private long startTime;

    @OuterVisible
    public AdEventRecord() {
    }

    /* renamed from: a */
    public IAd m44245a() {
        return this.f33545ad;
    }

    /* renamed from: b */
    public long m44246b() {
        return this.startTime;
    }

    /* renamed from: c */
    public long m44247c() {
        return this.endTime;
    }

    /* renamed from: d */
    public String m44248d() {
        return this.eventType;
    }

    /* renamed from: e */
    public Boolean m44249e() {
        return this.impWithClick;
    }

    @OuterVisible
    public void setAd(IAd iAd) {
        this.f33545ad = iAd;
    }

    @OuterVisible
    public void setEndTime(long j10) {
        this.endTime = j10;
    }

    @OuterVisible
    public void setEventTime(Long l10) {
        this.eventTime = l10;
    }

    @OuterVisible
    public void setEventType(String str) {
        this.eventType = str;
    }

    @OuterVisible
    public void setImpWithClick(Boolean bool) {
        this.impWithClick = bool;
    }

    @OuterVisible
    public void setStartTime(long j10) {
        this.startTime = j10;
    }

    @OuterVisible
    public AdEventRecord(AbstractC7298a abstractC7298a, long j10, long j11, String str, Long l10) {
        this.f33545ad = abstractC7298a;
        this.startTime = j10;
        this.endTime = j11;
        this.eventType = str;
        this.eventTime = l10;
    }
}

package com.huawei.openalliance.p169ad.beans.inner;

import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import java.util.List;

/* loaded from: classes8.dex */
public class AdEventReport {
    private String activityName;
    private int adType;
    private String appPkgName;
    private String appSdkVersion;
    private String contentId;
    private String customData;
    private Float density;
    private String destination;
    private Integer endProgress;
    private Long endTime;
    private String eventType;
    private Integer intentDest;
    private Integer intentFailReason;
    private String isAdContainerSizeMatched;
    private List<String> keyWords;
    private boolean mute;
    private int opTimes;
    private boolean phyShow;
    private String requestId;
    private Long showDuration;
    private String showId = String.valueOf(AbstractC7741ao.m47566c());
    private Integer showRatio;
    private Integer sld;
    private Integer source;
    private Integer startProgress;
    private Long startTime;
    private Integer upX;
    private Integer upY;
    private String userId;
    private Long videoTime;

    /* renamed from: x */
    private int f32004x;

    /* renamed from: y */
    private int f32005y;

    /* renamed from: a */
    public void m39301a(int i10) {
        this.adType = i10;
    }

    /* renamed from: b */
    public Long m39305b() {
        return this.showDuration;
    }

    /* renamed from: c */
    public Integer m39308c() {
        return this.showRatio;
    }

    /* renamed from: d */
    public Integer m39311d() {
        return this.source;
    }

    /* renamed from: e */
    public Long m39313e() {
        return this.startTime;
    }

    /* renamed from: f */
    public Long m39314f() {
        return this.endTime;
    }

    /* renamed from: g */
    public Integer m39315g() {
        return this.startProgress;
    }

    /* renamed from: h */
    public Integer m39316h() {
        return this.endProgress;
    }

    /* renamed from: i */
    public int m39317i() {
        return this.f32004x;
    }

    /* renamed from: j */
    public int m39318j() {
        return this.f32005y;
    }

    /* renamed from: k */
    public String m39319k() {
        return this.destination;
    }

    /* renamed from: l */
    public List<String> m39320l() {
        return this.keyWords;
    }

    /* renamed from: m */
    public String m39321m() {
        return this.customData;
    }

    /* renamed from: n */
    public String m39322n() {
        return this.activityName;
    }

    /* renamed from: o */
    public Long m39323o() {
        return this.videoTime;
    }

    /* renamed from: a */
    public void m39302a(String str) {
        this.contentId = str;
    }

    /* renamed from: b */
    public void m39306b(int i10) {
        this.f32004x = i10;
    }

    /* renamed from: c */
    public void m39309c(int i10) {
        this.f32005y = i10;
    }

    /* renamed from: d */
    public void m39312d(String str) {
        this.isAdContainerSizeMatched = str;
    }

    /* renamed from: a */
    public void m39303a(List<String> list) {
        this.keyWords = list;
    }

    /* renamed from: b */
    public void m39307b(String str) {
        this.showId = str;
    }

    /* renamed from: c */
    public void m39310c(String str) {
        this.requestId = str;
    }

    /* renamed from: a */
    public boolean m39304a() {
        return this.phyShow;
    }
}

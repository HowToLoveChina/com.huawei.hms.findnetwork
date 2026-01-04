package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes8.dex */
public class PostBackEvent {
    private int adType;
    private String contentId;
    private String eventType;
    private int maxShowRatio;
    private String packageName;
    private String requestId;
    private String showId;
    private long showTimeDuration;
    private String slotId;
    private long time;

    /* renamed from: a */
    public String m40388a() {
        return this.packageName;
    }

    /* renamed from: b */
    public String m40392b() {
        return this.slotId;
    }

    /* renamed from: c */
    public String m40396c() {
        return this.contentId;
    }

    /* renamed from: d */
    public String m40398d() {
        return this.showId;
    }

    /* renamed from: e */
    public long m40400e() {
        return this.showTimeDuration;
    }

    /* renamed from: f */
    public int m40402f() {
        return this.maxShowRatio;
    }

    /* renamed from: g */
    public String m40404g() {
        return this.eventType;
    }

    /* renamed from: h */
    public long m40405h() {
        return this.time;
    }

    /* renamed from: i */
    public String m40406i() {
        return this.requestId;
    }

    /* renamed from: a */
    public void m40389a(int i10) {
        this.maxShowRatio = i10;
    }

    /* renamed from: b */
    public void m40393b(int i10) {
        this.adType = i10;
    }

    /* renamed from: c */
    public void m40397c(String str) {
        this.contentId = str;
    }

    /* renamed from: d */
    public void m40399d(String str) {
        this.showId = str;
    }

    /* renamed from: e */
    public void m40401e(String str) {
        this.eventType = str;
    }

    /* renamed from: f */
    public void m40403f(String str) {
        this.requestId = str;
    }

    /* renamed from: a */
    public void m40390a(long j10) {
        this.showTimeDuration = j10;
    }

    /* renamed from: b */
    public void m40394b(long j10) {
        this.time = j10;
    }

    /* renamed from: a */
    public void m40391a(String str) {
        this.packageName = str;
    }

    /* renamed from: b */
    public void m40395b(String str) {
        this.slotId = str;
    }
}

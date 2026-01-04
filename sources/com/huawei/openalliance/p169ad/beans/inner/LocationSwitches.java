package com.huawei.openalliance.p169ad.beans.inner;

/* loaded from: classes8.dex */
public class LocationSwitches {
    public static final int SWITCH_OFF = 0;
    public static final int SWITCH_ON = 1;
    private int adsLoc;
    private int gpsOn;
    private boolean locationAccess;
    private boolean locationAvailable;
    private int mediaGpsOn;

    /* renamed from: a */
    public int m39407a() {
        return this.adsLoc;
    }

    /* renamed from: b */
    public int m39410b() {
        return this.gpsOn;
    }

    /* renamed from: c */
    public int m39413c() {
        return this.mediaGpsOn;
    }

    /* renamed from: d */
    public boolean m39415d() {
        return this.locationAvailable;
    }

    /* renamed from: e */
    public boolean m39416e() {
        return this.locationAccess;
    }

    /* renamed from: a */
    public void m39408a(int i10) {
        this.adsLoc = i10;
    }

    /* renamed from: b */
    public void m39411b(int i10) {
        this.gpsOn = i10;
    }

    /* renamed from: c */
    public void m39414c(int i10) {
        this.mediaGpsOn = i10;
    }

    /* renamed from: a */
    public void m39409a(boolean z10) {
        this.locationAvailable = z10;
    }

    /* renamed from: b */
    public void m39412b(boolean z10) {
        this.locationAccess = z10;
    }
}

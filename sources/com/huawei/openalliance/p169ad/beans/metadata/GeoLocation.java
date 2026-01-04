package com.huawei.openalliance.p169ad.beans.metadata;

/* loaded from: classes8.dex */
public class GeoLocation {
    private Address address;
    private int clctSource;
    private Long clctTime;
    private Integer lastfix;
    private Double lat;
    private Double lon;

    /* renamed from: a */
    public void m40169a(int i10) {
        this.clctSource = i10;
    }

    /* renamed from: b */
    public void m40173b(Double d10) {
        this.lat = d10;
    }

    /* renamed from: a */
    public void m40170a(Address address) {
        this.address = address;
    }

    /* renamed from: a */
    public void m40171a(Double d10) {
        this.lon = d10;
    }

    /* renamed from: a */
    public void m40172a(Long l10) {
        this.clctTime = l10;
    }
}

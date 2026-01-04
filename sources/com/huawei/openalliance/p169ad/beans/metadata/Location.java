package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6932d;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6934f;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.inner.LocationSwitches;
import com.huawei.openalliance.p169ad.utils.C7766bm;

@DataKeep
/* loaded from: classes8.dex */
public class Location {
    private int clctSource;
    private Long clctTime;
    private Integer lastfix;

    @InterfaceC6932d(m39225a = "lat")
    @InterfaceC6929a
    private Double latitude;

    @InterfaceC6934f
    private LocationSwitches locationSwitches;

    @InterfaceC6932d(m39225a = "lon")
    @InterfaceC6929a
    private Double longitude;

    public Location() {
    }

    @OuterVisible
    public Location(Double d10, Double d11) {
        this.longitude = C7766bm.m47803a(d10, 4, 4);
        this.latitude = C7766bm.m47803a(d11, 4, 4);
    }

    /* renamed from: a */
    public Location m40229a() {
        Location location = new Location();
        location.longitude = this.longitude;
        location.latitude = this.latitude;
        location.lastfix = this.lastfix;
        location.clctTime = this.clctTime;
        location.clctSource = this.clctSource;
        return location;
    }

    /* renamed from: b */
    public Double m40235b() {
        return this.longitude;
    }

    /* renamed from: c */
    public Double m40237c() {
        return this.latitude;
    }

    /* renamed from: d */
    public Long m40238d() {
        return this.clctTime;
    }

    /* renamed from: e */
    public Integer m40239e() {
        return this.lastfix;
    }

    /* renamed from: f */
    public LocationSwitches m40240f() {
        return this.locationSwitches;
    }

    /* renamed from: g */
    public int m40241g() {
        return this.clctSource;
    }

    /* renamed from: h */
    public boolean m40242h() {
        return (this.longitude == null || this.latitude == null) ? false : true;
    }

    /* renamed from: a */
    public void m40230a(int i10) {
        this.clctSource = i10;
    }

    /* renamed from: b */
    public void m40236b(Double d10) {
        this.latitude = C7766bm.m47803a(d10, 4, 4);
    }

    /* renamed from: a */
    public void m40231a(long j10) {
        Long l10 = this.clctTime;
        if (l10 == null || l10.longValue() >= j10) {
            return;
        }
        this.lastfix = Integer.valueOf(Math.round((j10 - this.clctTime.longValue()) / 1000.0f));
    }

    /* renamed from: a */
    public void m40232a(LocationSwitches locationSwitches) {
        this.locationSwitches = locationSwitches;
    }

    /* renamed from: a */
    public void m40233a(Double d10) {
        this.longitude = C7766bm.m47803a(d10, 4, 4);
    }

    /* renamed from: a */
    public void m40234a(Long l10) {
        this.clctTime = l10;
    }
}

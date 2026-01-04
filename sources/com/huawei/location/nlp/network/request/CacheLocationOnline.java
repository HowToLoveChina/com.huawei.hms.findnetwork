package com.huawei.location.nlp.network.request;

import com.huawei.location.C6769i;
import com.huawei.location.nlp.network.response.Location;

/* loaded from: classes8.dex */
public class CacheLocationOnline extends Location {
    private float accFilter;
    private short flagsFilter;
    private double latFilter;
    private double lonFilter;

    public float getAccFilter() {
        return this.accFilter;
    }

    public short getFlagsFilter() {
        return this.flagsFilter;
    }

    public double getLatFilter() {
        return this.latFilter;
    }

    public double getLonFilter() {
        return this.lonFilter;
    }

    public void setAccFilter(float f10) {
        this.accFilter = f10;
    }

    public void setFlagsFilter(short s10) {
        this.flagsFilter = s10;
    }

    public void setLatFilter(double d10) {
        this.latFilter = d10;
    }

    public void setLonFilter(double d10) {
        this.lonFilter = d10;
    }

    @Override // com.huawei.location.nlp.network.response.Location
    public String toString() {
        StringBuilder sb2 = new StringBuilder("CacheLocationOnline{");
        sb2.append(super.toString());
        sb2.append("latFilter=");
        sb2.append(this.latFilter);
        sb2.append(", lonFilter=");
        sb2.append(this.lonFilter);
        sb2.append(", accFilter=");
        sb2.append(this.accFilter);
        sb2.append(", flagsFilter=");
        return C6769i.m38373a(sb2, this.flagsFilter, '}');
    }
}

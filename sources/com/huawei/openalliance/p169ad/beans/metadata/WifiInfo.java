package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import java.util.Objects;

@DataKeep
/* loaded from: classes8.dex */
public class WifiInfo implements Comparable<WifiInfo> {
    private String bssid;
    private Integer encrypted;
    private Integer frequency;
    private Integer level;
    private String ssid;
    private Long time;
    private int type;
    private int wifiState;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(WifiInfo wifiInfo) {
        if (wifiInfo == null) {
            return -1;
        }
        int i10 = wifiInfo.wifiState - this.wifiState;
        if (i10 != 0) {
            return i10;
        }
        return (wifiInfo.m40504a() != null ? wifiInfo.m40504a().intValue() : Integer.MIN_VALUE) - (m40504a() == null ? Integer.MIN_VALUE : m40504a().intValue());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WifiInfo wifiInfo = (WifiInfo) obj;
        return Objects.equals(this.bssid, wifiInfo.bssid) && Objects.equals(this.ssid, wifiInfo.ssid) && Objects.equals(this.time, wifiInfo.time);
    }

    public int hashCode() {
        return Objects.hash(this.bssid, this.ssid, this.time);
    }

    /* renamed from: a */
    public Integer m40504a() {
        return this.level;
    }
}

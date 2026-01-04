package com.huawei.hms.network.embedded;

/* renamed from: com.huawei.hms.network.embedded.k1 */
/* loaded from: classes8.dex */
public class C5978k1 {

    /* renamed from: a */
    public long f27231a;

    /* renamed from: b */
    public String f27232b;

    /* renamed from: c */
    public long f27233c;

    public C5978k1() {
        this.f27231a = 0L;
        this.f27232b = "unknown";
        this.f27233c = 0L;
    }

    public String getCurrentHost() {
        return this.f27232b;
    }

    public long getEstimatedBandwidthBps() {
        return this.f27233c;
    }

    public long getReceivedTime() {
        return this.f27231a;
    }

    public void setCurrentHost(String str) {
        this.f27232b = str;
    }

    public void setEstimatedBandwidthBps(long j10) {
        this.f27233c = j10;
    }

    public void setTime(long j10) {
        this.f27231a = j10;
    }

    public String toString() {
        return "BandwidthInfo{receivedTime=" + this.f27231a + ", currentHost='" + this.f27232b + "', estimatedBandwidthBps=" + this.f27233c + '}';
    }

    public C5978k1(long j10, String str, long j11) {
        this.f27231a = j10;
        this.f27232b = str;
        this.f27233c = j11;
    }
}

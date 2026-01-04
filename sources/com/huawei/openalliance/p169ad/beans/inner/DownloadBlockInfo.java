package com.huawei.openalliance.p169ad.beans.inner;

/* loaded from: classes8.dex */
public class DownloadBlockInfo {
    private volatile long endTime;
    private volatile boolean fullFile;
    private volatile long size;
    private long startTime;

    /* renamed from: a */
    public long m39393a() {
        return this.size;
    }

    /* renamed from: b */
    public long m39396b() {
        return this.endTime - this.startTime;
    }

    /* renamed from: c */
    public void m39398c(long j10) {
        this.size = j10;
    }

    public String toString() {
        return "DownloadBlockInfo{size=" + this.size + ", fullFile=" + this.fullFile + ", duration=" + (this.endTime - this.startTime) + '}';
    }

    /* renamed from: a */
    public void m39394a(long j10) {
        this.startTime = j10;
    }

    /* renamed from: b */
    public void m39397b(long j10) {
        this.endTime = j10;
    }

    /* renamed from: c */
    public boolean m39399c() {
        return this.fullFile;
    }

    /* renamed from: a */
    public void m39395a(boolean z10) {
        this.fullFile = z10;
    }
}

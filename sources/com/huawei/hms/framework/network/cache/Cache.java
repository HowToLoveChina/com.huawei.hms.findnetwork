package com.huawei.hms.framework.network.cache;

/* loaded from: classes8.dex */
public final class Cache {
    private final String directory;
    private final long maxSize;

    public Cache(String str, long j10) {
        this.directory = str;
        this.maxSize = j10;
    }

    public String getDirectory() {
        return this.directory;
    }

    public long getMaxSize() {
        return this.maxSize;
    }
}

package com.huawei.hms.network.file.api;

/* loaded from: classes8.dex */
public class Progress {
    long finishedSize;
    int progress;
    Request request;
    long speed;
    long totalSize;
    String url;

    public Progress(Request request, String str, int i10, long j10, long j11, long j12) {
        this.request = request;
        this.url = str;
        this.progress = i10;
        this.totalSize = j10;
        this.finishedSize = j11;
        this.speed = j12;
    }

    public long getFinishedSize() {
        return this.finishedSize;
    }

    public int getProgress() {
        return this.progress;
    }

    public Request getRequest() {
        return this.request;
    }

    public long getSpeed() {
        return this.speed;
    }

    public long getTotalSize() {
        return this.totalSize;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "Progress{progress=" + this.progress + ", totalSize=" + this.totalSize + ", finishedSize=" + this.finishedSize + ", speed=" + this.speed + "(byte/s)}";
    }
}

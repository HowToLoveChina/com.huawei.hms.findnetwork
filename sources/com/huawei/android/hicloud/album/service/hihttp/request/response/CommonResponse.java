package com.huawei.android.hicloud.album.service.hihttp.request.response;

/* loaded from: classes2.dex */
public class CommonResponse extends BaseResponse {
    private int expire = 0;
    private int interval = -1;
    private long serverTime = 0;
    private int status = -1;

    public int getExpire() {
        return this.expire;
    }

    public int getInterval() {
        return this.interval;
    }

    public long getServerTime() {
        return this.serverTime;
    }

    public int getStatus() {
        return this.status;
    }

    public void setExpire(int i10) {
        this.expire = i10;
    }

    public void setInterval(int i10) {
        this.interval = i10;
    }

    public void setServerTime(long j10) {
        this.serverTime = j10;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }
}

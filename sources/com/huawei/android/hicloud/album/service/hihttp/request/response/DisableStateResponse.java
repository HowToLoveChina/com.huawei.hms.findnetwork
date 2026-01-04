package com.huawei.android.hicloud.album.service.hihttp.request.response;

/* loaded from: classes2.dex */
public class DisableStateResponse extends BaseResponse {
    private long deleteTime;
    private long disableTime;
    private int remain;
    private int status;

    public long getDeleteTime() {
        return this.deleteTime;
    }

    public long getDisableTime() {
        return this.disableTime;
    }

    public int getRemain() {
        return this.remain;
    }

    public int getStatus() {
        return this.status;
    }

    public void setDeleteTime(long j10) {
        this.deleteTime = j10;
    }

    public void setDisableTime(long j10) {
        this.disableTime = j10;
    }

    public void setRemain(int i10) {
        this.remain = i10;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }

    public String toString() {
        return "DisableStateResponse{status=" + this.status + ", deleteTime='" + this.deleteTime + "', disableTime='" + this.disableTime + "'}";
    }
}

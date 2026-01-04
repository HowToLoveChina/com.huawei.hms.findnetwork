package com.huawei.hms.findnetwork.comm.request.result;

import com.huawei.hms.findnetwork.comm.util.MaskUtil;

/* loaded from: classes8.dex */
public class StandbyDeviceResult {
    private String fid;
    private Integer sequence;
    private Integer status;

    public StandbyDeviceResult(Integer num, String str) {
        this.sequence = num;
        this.fid = str;
    }

    public String getFid() {
        return this.fid;
    }

    public Integer getSequence() {
        return this.sequence;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setFid(String str) {
        this.fid = str;
    }

    public void setSequence(Integer num) {
        this.sequence = num;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public String toString() {
        return "{fid=" + MaskUtil.maskSn(this.fid) + ", sequence=" + this.sequence + ", status=" + this.status + "}";
    }

    public StandbyDeviceResult(Integer num, String str, Integer num2) {
        this.sequence = num;
        this.fid = str;
        this.status = num2;
    }
}

package com.huawei.hms.findnetwork.comm.request.bean;

import com.huawei.hms.findnetwork.comm.util.MaskUtil;

/* loaded from: classes8.dex */
public class TagStatus {
    private int exceptionStatus;

    /* renamed from: sn */
    private String f24745sn;
    private String standbyStatus;
    private int status;

    public TagStatus(String str, int i10, int i11, String str2) {
        this.f24745sn = str;
        this.status = i10;
        this.exceptionStatus = i11;
        this.standbyStatus = str2;
    }

    public int getExceptionStatus() {
        return this.exceptionStatus;
    }

    public String getSn() {
        return this.f24745sn;
    }

    public String getStandbyStatus() {
        return this.standbyStatus;
    }

    public int getStatus() {
        return this.status;
    }

    public void setExceptionStatus(int i10) {
        this.exceptionStatus = i10;
    }

    public void setSn(String str) {
        this.f24745sn = str;
    }

    public void setStandbyStatus(String str) {
        this.standbyStatus = str;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }

    public String toString() {
        return "DeviceStatus{fid='" + MaskUtil.maskSn(this.f24745sn) + "', status=" + this.status + ", exceptionStatus=" + this.exceptionStatus + ", standbyStatus='" + MaskUtil.maskCommon(this.standbyStatus) + "'}";
    }
}

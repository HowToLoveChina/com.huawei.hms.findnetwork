package com.huawei.hms.findnetwork.comm.request.bean;

/* loaded from: classes8.dex */
public class StartOtaRequestBean extends BaseRequestBean {
    private int code;
    private String message;
    private int progress;

    /* renamed from: sn */
    private String f24742sn;

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public int getProgress() {
        return this.progress;
    }

    public String getSn() {
        return this.f24742sn;
    }

    public void setCode(int i10) {
        this.code = i10;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setProgress(int i10) {
        this.progress = i10;
    }

    public void setSn(String str) {
        this.f24742sn = str;
    }
}

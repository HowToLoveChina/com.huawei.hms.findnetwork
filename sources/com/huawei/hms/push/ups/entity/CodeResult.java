package com.huawei.hms.push.ups.entity;

/* loaded from: classes8.dex */
public class CodeResult {

    /* renamed from: a */
    private int f29730a;

    /* renamed from: b */
    private String f29731b;

    public CodeResult() {
    }

    public String getReason() {
        return this.f29731b;
    }

    public int getReturnCode() {
        return this.f29730a;
    }

    public void setReason(String str) {
        this.f29731b = str;
    }

    public void setReturnCode(int i10) {
        this.f29730a = i10;
    }

    public CodeResult(int i10) {
        this.f29730a = i10;
    }

    public CodeResult(int i10, String str) {
        this.f29730a = i10;
        this.f29731b = str;
    }
}

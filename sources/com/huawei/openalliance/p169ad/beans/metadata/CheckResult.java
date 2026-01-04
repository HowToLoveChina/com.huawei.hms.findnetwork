package com.huawei.openalliance.p169ad.beans.metadata;

/* loaded from: classes8.dex */
public class CheckResult {
    private String contentDownMethod;
    private String filePath;
    private String realPath;
    private boolean valid;

    public CheckResult() {
    }

    public CheckResult(boolean z10, String str, String str2) {
        this.valid = z10;
        this.filePath = str;
        this.realPath = str2;
    }

    /* renamed from: a */
    public boolean m39880a() {
        return this.valid;
    }

    /* renamed from: b */
    public String m39881b() {
        return this.filePath;
    }

    /* renamed from: c */
    public String m39882c() {
        return this.realPath;
    }

    /* renamed from: d */
    public String m39883d() {
        return this.contentDownMethod;
    }

    public CheckResult(boolean z10, String str, String str2, String str3) {
        this.valid = z10;
        this.filePath = str;
        this.realPath = str2;
        this.contentDownMethod = str3;
    }
}

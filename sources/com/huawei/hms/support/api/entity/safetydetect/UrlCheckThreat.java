package com.huawei.hms.support.api.entity.safetydetect;

/* loaded from: classes8.dex */
public class UrlCheckThreat {
    public static final int MALWARE = 1;
    public static final int PHISHING = 3;
    private int urlCheckResult;

    public UrlCheckThreat(int i10) {
        this.urlCheckResult = i10;
    }

    public int getUrlCheckResult() {
        return this.urlCheckResult;
    }
}

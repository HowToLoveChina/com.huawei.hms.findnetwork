package com.huawei.hms.framework.network.restclient.dnkeeper;

import android.text.TextUtils;

/* loaded from: classes8.dex */
public final class RequestHost {

    /* renamed from: a */
    private String f25050a;

    /* renamed from: b */
    private String f25051b;

    /* renamed from: c */
    private String f25052c = "Unknown Reason";

    /* renamed from: d */
    private String f25053d = "UNKNOWN";

    /* renamed from: e */
    private int f25054e = 0;

    /* renamed from: f */
    private String f25055f = "ALL";

    /* renamed from: g */
    private long f25056g;

    public RequestHost(String str) {
        setDomainName(str);
    }

    public void enableAccelerate(boolean z10) {
        this.f25054e = z10 ? 1 : 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RequestHost) {
            return this.f25050a.equals(((RequestHost) obj).f25050a);
        }
        return false;
    }

    public int getAccelerate() {
        return this.f25054e;
    }

    public String getApkName() {
        return this.f25051b;
    }

    public String getDnsFailType() {
        return this.f25052c;
    }

    public String getDomainName() {
        return this.f25050a;
    }

    public String getFailIP() {
        return this.f25053d;
    }

    public long getTime() {
        return this.f25056g;
    }

    public String getType() {
        return this.f25055f;
    }

    public int hashCode() {
        String str = this.f25050a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public void setApkName(String str) {
        this.f25051b = str;
    }

    public void setDnsFailType(String str) {
        this.f25052c = str;
    }

    public void setDomainName(String str) {
        this.f25050a = str;
    }

    public void setFailIP(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f25053d = str;
    }

    public void setTime(long j10) {
        this.f25056g = j10;
    }

    public void setType(String str) {
        this.f25055f = str;
    }

    public String toString() {
        return this.f25050a + "";
    }
}

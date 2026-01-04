package com.huawei.hms.network.embedded;

/* renamed from: com.huawei.hms.network.embedded.m2 */
/* loaded from: classes8.dex */
public class C6005m2 {

    /* renamed from: a */
    public String f27472a;

    /* renamed from: b */
    public int f27473b = C5927g2.f26808n;

    /* renamed from: c */
    public int f27474c = C5927g2.f26808n;

    /* renamed from: d */
    public boolean f27475d;

    public int getAlternatePort() {
        return this.f27474c;
    }

    public boolean getEnableQuic() {
        return this.f27475d;
    }

    public String getHost() {
        return this.f27472a;
    }

    public int getPort() {
        return this.f27473b;
    }

    public void setAlternatePort(int i10) {
        this.f27474c = i10;
    }

    public void setEnableQuic(boolean z10) {
        this.f27475d = z10;
    }

    public void setHost(String str) {
        this.f27472a = str;
    }

    public void setPort(int i10) {
        this.f27473b = i10;
    }

    public String toString() {
        return "Host:" + this.f27472a + ", Port:" + this.f27473b + ", AlternatePort:" + this.f27474c + ", Enable:" + this.f27475d;
    }
}

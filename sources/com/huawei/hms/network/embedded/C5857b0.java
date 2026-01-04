package com.huawei.hms.network.embedded;

import java.util.Date;

/* renamed from: com.huawei.hms.network.embedded.b0 */
/* loaded from: classes8.dex */
public class C5857b0 {

    /* renamed from: a */
    public String f26392a;

    /* renamed from: b */
    public String f26393b;

    /* renamed from: c */
    public long f26394c;

    /* renamed from: d */
    public long f26395d;

    /* renamed from: e */
    public int f26396e;

    public C5857b0() {
        this.f26394c = C6132w.m35707a();
    }

    /* renamed from: b */
    private long m33852b() {
        return new Date().getTime();
    }

    /* renamed from: a */
    public boolean m33853a() {
        long jM33852b = m33852b() - this.f26395d;
        return jM33852b > 86400000 || jM33852b < -86400000;
    }

    public String toString() {
        return "Address{domain='" + this.f26392a + "', ip=" + this.f26393b + ", ttl=" + this.f26394c + ", createTime=" + this.f26395d + ", source=" + C6093t.m35329m().m35333a(this.f26396e) + '}';
    }

    public C5857b0(String str, String str2) {
        this.f26394c = C6132w.m35707a();
        this.f26392a = str;
        this.f26393b = str2;
    }

    public C5857b0(String str, String str2, long j10) {
        C6132w.m35707a();
        this.f26392a = str;
        this.f26393b = str2;
        this.f26394c = j10;
    }
}

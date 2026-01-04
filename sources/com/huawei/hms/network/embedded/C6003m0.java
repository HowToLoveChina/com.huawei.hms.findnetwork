package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.hms.network.embedded.m0 */
/* loaded from: classes8.dex */
public class C6003m0 {

    /* renamed from: h */
    public static final String f27455h = "DomainResult";

    /* renamed from: i */
    public static final String f27456i = "A";

    /* renamed from: j */
    public static final String f27457j = "AAAA";

    /* renamed from: k */
    public static final String f27458k = "ALL";

    /* renamed from: l */
    public static final long f27459l = 86400000;

    /* renamed from: m */
    public static final int f27460m = 0;

    /* renamed from: n */
    public static final int f27461n = 1;

    /* renamed from: o */
    public static final int f27462o = 2;

    /* renamed from: p */
    public static final String f27463p = "CNAME";

    /* renamed from: f */
    public int f27469f;

    /* renamed from: a */
    public String f27464a = "";

    /* renamed from: b */
    public String f27465b = "A";

    /* renamed from: c */
    public List<String> f27466c = new ArrayList();

    /* renamed from: d */
    public long f27467d = System.currentTimeMillis();

    /* renamed from: e */
    public long f27468e = C6132w.m35707a();

    /* renamed from: g */
    public int f27470g = -1;

    /* renamed from: a */
    public int m34736a() {
        return this.f27470g;
    }

    /* renamed from: b */
    public long m34742b() {
        return this.f27467d;
    }

    /* renamed from: c */
    public String m34747c() {
        return this.f27464a;
    }

    /* renamed from: d */
    public List<String> m34749d() {
        return new ArrayList(this.f27466c);
    }

    /* renamed from: e */
    public int m34750e() {
        long jAbs = Math.abs(System.currentTimeMillis() - this.f27467d);
        Logger.m32144v(f27455h, "getReportStatus:time is %d,ttl is %d", Long.valueOf(jAbs), Long.valueOf(this.f27468e));
        long j10 = this.f27468e;
        if (j10 <= 0) {
            return -1;
        }
        return (int) (jAbs / j10);
    }

    /* renamed from: f */
    public int m34751f() {
        return this.f27469f;
    }

    /* renamed from: g */
    public int m34752g() {
        long jAbs = Math.abs(System.currentTimeMillis() - this.f27467d);
        Logger.m32144v(f27455h, "getStatus:time is %d,ttl is %d", Long.valueOf(jAbs), Long.valueOf(this.f27468e));
        if (jAbs < this.f27468e) {
            return 0;
        }
        return jAbs < 86400000 ? 1 : 2;
    }

    /* renamed from: h */
    public long m34753h() {
        return this.f27468e;
    }

    /* renamed from: i */
    public String m34754i() {
        return this.f27465b;
    }

    /* renamed from: j */
    public boolean m34755j() {
        return this.f27466c.isEmpty();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{'");
        sb2.append(this.f27465b);
        sb2.append('\'');
        sb2.append(m34755j() ? ", not exist" : ", exist");
        sb2.append(", createTime=");
        sb2.append(this.f27467d);
        sb2.append(", ");
        sb2.append(C6093t.m35329m().m35333a(this.f27469f));
        sb2.append(", ");
        sb2.append(this.f27470g);
        sb2.append('}');
        return sb2.toString();
    }

    /* renamed from: a */
    public void m34737a(int i10) {
        this.f27470g = i10;
    }

    /* renamed from: b */
    public void m34743b(int i10) {
        this.f27469f = i10;
    }

    /* renamed from: c */
    public void m34748c(String str) {
        this.f27465b = str;
    }

    /* renamed from: a */
    public void m34738a(long j10) {
        this.f27467d = j10;
    }

    /* renamed from: b */
    public void m34744b(long j10) {
        this.f27468e = j10;
    }

    /* renamed from: a */
    public void m34739a(String str) {
        this.f27466c.add(str);
    }

    /* renamed from: b */
    public void m34745b(String str) {
        this.f27464a = str;
    }

    /* renamed from: a */
    public void m34740a(List<String> list) {
        this.f27466c.addAll(list);
    }

    /* renamed from: b */
    public void m34746b(List<String> list) {
        if (list == null) {
            this.f27466c = new ArrayList();
        } else {
            this.f27466c = list;
        }
    }

    /* renamed from: a */
    public boolean m34741a(C6003m0 c6003m0) {
        return c6003m0 == null || c6003m0.m34755j() || this.f27469f >= c6003m0.m34751f();
    }
}

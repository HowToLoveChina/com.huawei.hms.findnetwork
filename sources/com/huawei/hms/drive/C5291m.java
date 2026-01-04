package com.huawei.hms.drive;

/* renamed from: com.huawei.hms.drive.m */
/* loaded from: classes8.dex */
public final class C5291m {

    /* renamed from: a */
    private String f24533a;

    /* renamed from: b */
    private String f24534b;

    /* renamed from: c */
    private String f24535c = "Unknown Reason";

    /* renamed from: d */
    private String f24536d = "UNKNOWN";

    /* renamed from: e */
    private int f24537e = 0;

    /* renamed from: f */
    private String f24538f = "ALL";

    /* renamed from: g */
    private long f24539g;

    public C5291m(String str) {
        m31756a(str);
    }

    /* renamed from: a */
    public String m31754a() {
        return this.f24533a;
    }

    /* renamed from: b */
    public String m31758b() {
        return this.f24534b;
    }

    /* renamed from: c */
    public String m31760c() {
        return this.f24535c;
    }

    /* renamed from: d */
    public String m31761d() {
        return this.f24536d;
    }

    /* renamed from: e */
    public String m31762e() {
        return this.f24538f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C5291m) {
            return this.f24533a.equals(((C5291m) obj).f24533a);
        }
        return false;
    }

    /* renamed from: f */
    public int m31763f() {
        return this.f24537e;
    }

    public int hashCode() {
        String str = this.f24533a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return this.f24533a + "";
    }

    /* renamed from: a */
    public void m31755a(long j10) {
        this.f24539g = j10;
    }

    /* renamed from: b */
    public void m31759b(String str) {
        this.f24535c = str;
    }

    /* renamed from: a */
    public void m31756a(String str) {
        this.f24533a = str;
    }

    /* renamed from: a */
    public void m31757a(boolean z10) {
        this.f24537e = z10 ? 1 : 0;
    }
}

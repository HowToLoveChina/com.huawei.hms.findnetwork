package com.google.crypto.tink.shaded.protobuf;

/* renamed from: com.google.crypto.tink.shaded.protobuf.f0 */
/* loaded from: classes.dex */
public class C1912f0 {

    /* renamed from: e */
    public static final C1944q f9132e = C1944q.m12103b();

    /* renamed from: a */
    public AbstractC1920i f9133a;

    /* renamed from: b */
    public C1944q f9134b;

    /* renamed from: c */
    public volatile InterfaceC1951s0 f9135c;

    /* renamed from: d */
    public volatile AbstractC1920i f9136d;

    /* renamed from: a */
    public void m11634a(InterfaceC1951s0 interfaceC1951s0) {
        if (this.f9135c != null) {
            return;
        }
        synchronized (this) {
            if (this.f9135c != null) {
                return;
            }
            try {
                if (this.f9133a != null) {
                    this.f9135c = interfaceC1951s0.mo12142l().mo11480a(this.f9133a, this.f9134b);
                    this.f9136d = this.f9133a;
                } else {
                    this.f9135c = interfaceC1951s0;
                    this.f9136d = AbstractC1920i.f9147b;
                }
            } catch (C1903c0 unused) {
                this.f9135c = interfaceC1951s0;
                this.f9136d = AbstractC1920i.f9147b;
            }
        }
    }

    /* renamed from: b */
    public int m11635b() {
        if (this.f9136d != null) {
            return this.f9136d.size();
        }
        AbstractC1920i abstractC1920i = this.f9133a;
        if (abstractC1920i != null) {
            return abstractC1920i.size();
        }
        if (this.f9135c != null) {
            return this.f9135c.mo12140i();
        }
        return 0;
    }

    /* renamed from: c */
    public InterfaceC1951s0 m11636c(InterfaceC1951s0 interfaceC1951s0) {
        m11634a(interfaceC1951s0);
        return this.f9135c;
    }

    /* renamed from: d */
    public InterfaceC1951s0 m11637d(InterfaceC1951s0 interfaceC1951s0) {
        InterfaceC1951s0 interfaceC1951s02 = this.f9135c;
        this.f9133a = null;
        this.f9136d = null;
        this.f9135c = interfaceC1951s0;
        return interfaceC1951s02;
    }

    /* renamed from: e */
    public AbstractC1920i m11638e() {
        if (this.f9136d != null) {
            return this.f9136d;
        }
        AbstractC1920i abstractC1920i = this.f9133a;
        if (abstractC1920i != null) {
            return abstractC1920i;
        }
        synchronized (this) {
            try {
                if (this.f9136d != null) {
                    return this.f9136d;
                }
                if (this.f9135c == null) {
                    this.f9136d = AbstractC1920i.f9147b;
                } else {
                    this.f9136d = this.f9135c.mo11459g();
                }
                return this.f9136d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1912f0)) {
            return false;
        }
        C1912f0 c1912f0 = (C1912f0) obj;
        InterfaceC1951s0 interfaceC1951s0 = this.f9135c;
        InterfaceC1951s0 interfaceC1951s02 = c1912f0.f9135c;
        return (interfaceC1951s0 == null && interfaceC1951s02 == null) ? m11638e().equals(c1912f0.m11638e()) : (interfaceC1951s0 == null || interfaceC1951s02 == null) ? interfaceC1951s0 != null ? interfaceC1951s0.equals(c1912f0.m11636c(interfaceC1951s0.mo12208c())) : m11636c(interfaceC1951s02.mo12208c()).equals(interfaceC1951s02) : interfaceC1951s0.equals(interfaceC1951s02);
    }

    public int hashCode() {
        return 1;
    }
}

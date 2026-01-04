package com.huawei.cloud.base.http;

import com.huawei.cloud.base.http.C4612o;
import com.huawei.cloud.base.util.InterfaceC4631c0;
import java.io.IOException;

/* renamed from: com.huawei.cloud.base.http.y */
/* loaded from: classes.dex */
public abstract class AbstractC4622y {

    /* renamed from: a */
    public long f21241a = -1;

    /* renamed from: b */
    public String f21242b;

    /* renamed from: c */
    public String f21243c;

    /* renamed from: d */
    public InterfaceC4631c0 f21244d;

    /* renamed from: e */
    public InterfaceC4614q f21245e;

    /* renamed from: f */
    public C4612o.a f21246f;

    /* renamed from: a */
    public abstract void mo28242a(String str, String str2) throws IOException;

    /* renamed from: b */
    public void mo28339b() {
    }

    /* renamed from: c */
    public abstract AbstractC4623z mo28243c() throws IOException;

    /* renamed from: d */
    public final long m28340d() {
        return this.f21241a;
    }

    /* renamed from: e */
    public final String m28341e() {
        return this.f21243c;
    }

    /* renamed from: f */
    public InterfaceC4614q m28342f() {
        return this.f21245e;
    }

    /* renamed from: g */
    public C4612o.a m28343g() {
        return this.f21246f;
    }

    /* renamed from: h */
    public final InterfaceC4631c0 m28344h() {
        return this.f21244d;
    }

    /* renamed from: i */
    public final void m28345i(String str) throws IOException {
        this.f21242b = str;
    }

    /* renamed from: j */
    public final void m28346j(long j10) throws IOException {
        this.f21241a = j10;
    }

    /* renamed from: k */
    public final void m28347k(String str) throws IOException {
        this.f21243c = str;
    }

    /* renamed from: l */
    public void m28348l(InterfaceC4614q interfaceC4614q) {
        this.f21245e = interfaceC4614q;
    }

    /* renamed from: m */
    public void m28349m(C4612o.a aVar) {
        this.f21246f = aVar;
    }

    /* renamed from: n */
    public final void m28350n(InterfaceC4631c0 interfaceC4631c0) throws IOException {
        this.f21244d = interfaceC4631c0;
    }

    /* renamed from: o */
    public void mo28351o(int i10, int i11) throws IOException {
    }
}

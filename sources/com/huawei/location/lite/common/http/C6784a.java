package com.huawei.location.lite.common.http;

import android.annotation.SuppressLint;
import android.content.Context;
import as.C1016d;
import java.net.Proxy;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.C11912b0;
import okhttp3.C11945l;
import okhttp3.EnumC11914c0;
import p688ur.C13244d;
import p716vr.C13480a;
import p716vr.C13484e;
import p716vr.C13485f;
import tr.AbstractC13057a;
import tr.C13058b;
import tr.InterfaceC13060d;
import tr.InterfaceC13062f;

@SuppressLint({"CheckResult"})
/* renamed from: com.huawei.location.lite.common.http.a */
/* loaded from: classes8.dex */
public class C6784a extends AbstractC13057a {

    /* renamed from: s */
    public static final C11945l f31373s = new C11945l(AbstractC13057a.f59399q, 30000, TimeUnit.MILLISECONDS);

    /* renamed from: r */
    public C11912b0 f31374r;

    public C6784a(C13058b c13058b, Context context) {
        super(c13058b, context);
    }

    @Override // tr.InterfaceC13059c
    /* renamed from: a */
    public InterfaceC13060d mo38443a() throws C13244d {
        return new C6787d(this.f31374r);
    }

    @Override // tr.InterfaceC13059c
    /* renamed from: b */
    public List<InterfaceC13062f> mo38444b() {
        return this.f59400a;
    }

    @Override // tr.AbstractC13057a
    /* renamed from: c */
    public void mo38445c() {
        this.f59400a.add(new C13484e());
        if (this.f59412m) {
            this.f59400a.add(new C13485f());
        }
        if (this.f59411l) {
            this.f59400a.add(new C13480a());
        }
    }

    @Override // tr.AbstractC13057a
    /* renamed from: e */
    public void mo38446e() {
        X509TrustManager x509TrustManager;
        C1016d.m6181a("HttpClientReal", "OkHttpClient init...");
        C11912b0.c cVarM71517n = new C11912b0.c().m71508e(f31373s).m71520q(false).m71517n(Collections.unmodifiableList(Arrays.asList(EnumC11914c0.HTTP_2, EnumC11914c0.HTTP_1_1)));
        int i10 = this.f59404e;
        if (i10 > 0) {
            cVarM71517n.m71516m(i10, TimeUnit.MILLISECONDS);
        }
        int i11 = this.f59403d;
        if (i11 > 0) {
            cVarM71517n.m71519p(i11, TimeUnit.MILLISECONDS);
        }
        int i12 = this.f59405f;
        if (i12 > 0) {
            cVarM71517n.m71522s(i12, TimeUnit.MILLISECONDS);
        }
        int i13 = this.f59402c;
        if (i13 > 0) {
            cVarM71517n.m71507d(i13, TimeUnit.MILLISECONDS);
        }
        Proxy proxy = this.f59409j;
        if (proxy != null) {
            cVarM71517n.m71518o(proxy);
        }
        HostnameVerifier hostnameVerifier = this.f59408i;
        if (hostnameVerifier != null) {
            cVarM71517n.m71515l(hostnameVerifier);
        }
        SSLSocketFactory sSLSocketFactory = this.f59406g;
        if (sSLSocketFactory != null && (x509TrustManager = this.f59407h) != null) {
            cVarM71517n.m71521r(sSLSocketFactory, x509TrustManager);
        }
        this.f31374r = cVarM71517n.m71505b();
    }
}

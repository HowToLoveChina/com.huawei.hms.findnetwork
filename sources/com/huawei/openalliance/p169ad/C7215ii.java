package com.huawei.openalliance.p169ad;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.ii */
/* loaded from: classes8.dex */
public class C7215ii extends ProxySelector {

    /* renamed from: a */
    private static final List<Proxy> f33200a = Collections.singletonList(Proxy.NO_PROXY);

    /* renamed from: b */
    private final ProxySelector f33201b;

    /* renamed from: c */
    private final String f33202c;

    /* renamed from: d */
    private final int f33203d;

    private C7215ii(ProxySelector proxySelector, String str, int i10) {
        if (proxySelector == null || str == null) {
            throw null;
        }
        this.f33201b = proxySelector;
        this.f33202c = str;
        this.f33203d = i10;
    }

    /* renamed from: a */
    public static void m43938a(String str, int i10) {
        ProxySelector.setDefault(new C7215ii(ProxySelector.getDefault(), str, i10));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f33201b.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return (this.f33202c.equals(uri.getHost()) && this.f33203d == uri.getPort()) ? f33200a : this.f33201b.select(uri);
    }
}

package com.huawei.cloud.base.http;

import java.io.IOException;

/* renamed from: com.huawei.cloud.base.http.p */
/* loaded from: classes.dex */
public final class C4613p {

    /* renamed from: a */
    public final AbstractC4619v f21215a;

    /* renamed from: b */
    public final InterfaceC4614q f21216b;

    public C4613p(AbstractC4619v abstractC4619v, InterfaceC4614q interfaceC4614q) {
        this.f21215a = abstractC4619v;
        this.f21216b = interfaceC4614q;
    }

    /* renamed from: a */
    public C4612o m28297a(C4604g c4604g) throws IOException {
        return m28300d("GET", c4604g, null);
    }

    /* renamed from: b */
    public C4612o m28298b(C4604g c4604g, InterfaceC4605h interfaceC4605h) throws IOException {
        return m28300d("POST", c4604g, interfaceC4605h);
    }

    /* renamed from: c */
    public C4612o m28299c(C4604g c4604g, InterfaceC4605h interfaceC4605h) throws IOException {
        return m28300d("PUT", c4604g, interfaceC4605h);
    }

    /* renamed from: d */
    public C4612o m28300d(String str, C4604g c4604g, InterfaceC4605h interfaceC4605h) throws IOException {
        C4612o c4612oBuildRequest = this.f21215a.buildRequest();
        InterfaceC4614q interfaceC4614q = this.f21216b;
        if (interfaceC4614q != null) {
            interfaceC4614q.mo28303a(c4612oBuildRequest);
        }
        c4612oBuildRequest.m28264E(str);
        if (c4604g != null) {
            c4612oBuildRequest.m28268I(c4604g);
        }
        if (interfaceC4605h != null) {
            c4612oBuildRequest.m28292x(interfaceC4605h);
        }
        return c4612oBuildRequest;
    }

    /* renamed from: e */
    public InterfaceC4614q m28301e() {
        return this.f21216b;
    }

    /* renamed from: f */
    public AbstractC4619v m28302f() {
        return this.f21215a;
    }
}

package com.huawei.openalliance.p169ad;

import android.content.Context;

/* renamed from: com.huawei.openalliance.ad.sq */
/* loaded from: classes8.dex */
public class C7668sq extends AbstractC7659sh {

    /* renamed from: b */
    private InterfaceC7670ss f35680b;

    /* renamed from: c */
    private int f35681c;

    public C7668sq(Context context, int i10) {
        super(context);
        this.f35680b = new C7656se(context);
        this.f35681c = i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7671st
    /* renamed from: a */
    public int mo47212a() {
        return this.f35681c;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7671st
    /* renamed from: b */
    public void mo47213b() {
        super.m47222a(C7124fh.m43316b(this.f35674a).mo43355aV());
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7659sh, com.huawei.openalliance.p169ad.InterfaceC7671st
    /* renamed from: c */
    public void mo47223c() {
        this.f35680b.mo47220b();
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7659sh, com.huawei.openalliance.p169ad.InterfaceC7671st
    /* renamed from: d */
    public void mo47224d() {
        this.f35680b.mo47219a();
    }
}

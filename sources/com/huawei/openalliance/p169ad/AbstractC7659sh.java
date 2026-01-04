package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;

/* renamed from: com.huawei.openalliance.ad.sh */
/* loaded from: classes8.dex */
public abstract class AbstractC7659sh implements InterfaceC7671st {

    /* renamed from: a */
    protected Context f35674a;

    /* renamed from: b */
    private InterfaceC7138fv f35675b;

    public AbstractC7659sh(Context context) {
        this.f35674a = context.getApplicationContext();
        this.f35675b = C7108ex.m43156a(context);
    }

    /* renamed from: a */
    public void m47222a(long j10) {
        this.f35675b.mo43163a(AbstractC7741ao.m47566c() - j10, mo47212a());
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7671st
    /* renamed from: c */
    public void mo47223c() {
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7671st
    /* renamed from: d */
    public void mo47224d() {
    }
}

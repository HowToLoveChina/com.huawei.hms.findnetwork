package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8126s;

/* renamed from: com.huawei.openalliance.ad.nr */
/* loaded from: classes8.dex */
public class C7523nr extends C7336jj<InterfaceC8126s> implements InterfaceC7539og<InterfaceC8126s> {

    /* renamed from: d */
    private InterfaceC7146gc f34947d;

    /* renamed from: e */
    private Context f34948e;

    /* renamed from: f */
    private AbstractC7524ns f34949f;

    /* renamed from: g */
    private InterfaceC7182hl f34950g;

    /* renamed from: h */
    private boolean f34951h = false;

    public C7523nr(Context context, InterfaceC8126s interfaceC8126s, int i10) {
        mo45316a((C7523nr) interfaceC8126s);
        this.f34948e = context.getApplicationContext();
        this.f34947d = C7124fh.m43316b(context);
    }

    /* renamed from: b */
    private void m46200b(int i10, boolean z10) {
        AbstractC7185ho.m43820b("SloganPresenter", "show default slogan");
        if (z10) {
            C7494nb c7494nb = new C7494nb(this.f34947d, this.f34950g);
            this.f34949f = c7494nb;
            c7494nb.mo45920a();
        }
        mo45320d().mo49992a(i10);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7539og
    /* renamed from: a */
    public void mo46201a(InterfaceC7182hl interfaceC7182hl) {
        this.f34950g = interfaceC7182hl;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7539og
    /* renamed from: a */
    public boolean mo46202a(int i10, boolean z10) {
        AbstractC7185ho.m43820b("SloganPresenter", "loadSloganRecord " + i10);
        m46200b(i10, z10);
        return this.f34951h;
    }
}

package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.constant.AdLoadMode;
import com.huawei.openalliance.p169ad.inter.listeners.AdListener;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7810dc;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l;
import java.util.concurrent.Callable;

/* renamed from: com.huawei.openalliance.ad.nu */
/* loaded from: classes8.dex */
public class C7526nu extends C7336jj<InterfaceC8119l> implements InterfaceC7540oh<InterfaceC8119l> {

    /* renamed from: d */
    private InterfaceC7146gc f34964d;

    /* renamed from: e */
    private AdListener f34965e;

    /* renamed from: f */
    private Context f34966f;

    /* renamed from: g */
    private C6922c f34967g;

    public C7526nu(Context context, InterfaceC8119l interfaceC8119l) {
        mo45316a((C7526nu) interfaceC8119l);
        this.f34964d = C7124fh.m43316b(context);
        Context applicationContext = context.getApplicationContext();
        this.f34966f = applicationContext;
        this.f34967g = new C6922c(applicationContext);
    }

    /* renamed from: i */
    private void m46214i() {
        AbstractC7185ho.m43823c("SplashPresenter", "notifyNotSupport");
        AdListener adListener = this.f34965e;
        if (adListener != null) {
            adListener.onAdFailedToLoad(1001);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7540oh
    /* renamed from: b */
    public boolean mo46218b() {
        if (AbstractC7741ao.m47562b(this.f34966f)) {
            return true;
        }
        m46214i();
        mo46220h();
        return false;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7540oh
    /* renamed from: c */
    public boolean mo46219c() {
        return AbstractC7807d.m48257t(this.f34966f);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7540oh
    /* renamed from: h */
    public void mo46220h() {
        AbstractC7185ho.m43817a("SplashPresenter", "notifyAdDismissed");
        AdListener adListener = this.f34965e;
        if (adListener != null) {
            adListener.onAdDismissed();
        }
        AbstractC7741ao.m47585i(this.f34966f);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7540oh
    /* renamed from: a */
    public void mo46215a() {
        mo45320d().mo49710a((AdLoadMode) AbstractC7810dc.m48269a(new Callable<AdLoadMode>() { // from class: com.huawei.openalliance.ad.nu.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public AdLoadMode call() {
                return C7526nu.this.f34964d.mo43367ay();
            }
        }, AdLoadMode.CACHE));
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7540oh
    /* renamed from: a */
    public void mo46216a(AdListener adListener) {
        this.f34965e = adListener;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7540oh
    /* renamed from: a */
    public void mo46217a(String str, int i10) {
        this.f34967g.m39087a(str, i10);
    }
}

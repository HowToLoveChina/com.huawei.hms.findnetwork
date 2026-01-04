package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8120m;

/* renamed from: com.huawei.openalliance.ad.nk */
/* loaded from: classes8.dex */
public class C7516nk extends AbstractC7513nh<InterfaceC8120m> implements InterfaceC7533oa {

    /* renamed from: e */
    private InterfaceC7002cs f34912e;

    public C7516nk(Context context, InterfaceC8120m interfaceC8120m, int i10) {
        super(context, interfaceC8120m, i10);
        this.f34912e = new C6922c(context);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7533oa
    /* renamed from: i */
    public void mo46149i() {
        this.f34190b.mo46616c();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7533oa
    /* renamed from: a */
    public void mo46146a(final long j10, final long j11, final long j12) {
        if (this.f34912e == null || j10 == 0 || j10 >= j12) {
            return;
        }
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.nk.1
            @Override // java.lang.Runnable
            public void run() {
                long j13 = j12;
                long j14 = j13 - j10;
                long j15 = j11;
                C7516nk.this.f34912e.mo39074a(C7516nk.this.f34189a, j14, (j15 == 0 || j15 >= j13) ? 0L : j13 - j15);
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7513nh
    /* renamed from: b */
    public void mo46119b(String str) {
        ((InterfaceC8120m) mo45320d()).mo50316d();
        AbstractC7185ho.m43820b("PPSVideoViewPresenter", "onMaterialLoaded - begin to load video");
        ((InterfaceC8120m) mo45320d()).mo50308a(str);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7533oa
    /* renamed from: a */
    public void mo46147a(long j10, long j11, long j12, long j13) {
        this.f34190b.mo46617c(j10, j11, (int) j12, (int) j13);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7533oa
    /* renamed from: a */
    public void mo46148a(boolean z10) {
        this.f34190b.mo46615b(z10);
    }
}

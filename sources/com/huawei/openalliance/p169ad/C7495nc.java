package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.view.View;
import com.huawei.hms.ads.uiengine.common.IInterstitialView;
import com.huawei.openalliance.p169ad.inter.data.C7301d;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7586a;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7587b;

/* renamed from: com.huawei.openalliance.ad.nc */
/* loaded from: classes8.dex */
public class C7495nc extends C7336jj<IInterstitialView> {

    /* renamed from: d */
    private IInterstitialView f34768d;

    /* renamed from: e */
    private Context f34769e;

    /* renamed from: f */
    private C7301d f34770f;

    public C7495nc(Context context, IInterstitialView iInterstitialView) {
        mo45316a(iInterstitialView);
        this.f34769e = context;
        this.f34190b = new C7560ou(context, new C7663sl(context));
    }

    @Override // com.huawei.openalliance.p169ad.C7336jj
    /* renamed from: a */
    public IInterstitialView mo45320d() {
        return this.f34768d;
    }

    /* renamed from: b */
    public void m45930b() {
    }

    /* renamed from: c */
    public void m45931c() {
        this.f34190b.mo46606b();
    }

    /* renamed from: a */
    public void m45924a(long j10, int i10) {
        this.f34190b.mo46581a(j10, i10);
    }

    /* renamed from: a */
    public void m45925a(long j10, int i10, Integer num) {
        String strM45322f = m45322f();
        C7301d c7301d = this.f34770f;
        if (c7301d != null) {
            AbstractC7185ho.m43818a("InterstitialAdPresenter", "slotId: %s, contentId: %s, slot pos: %s", c7301d.m44710Q(), this.f34770f.getContentId(), strM45322f);
        }
        C7586a.a aVar = new C7586a.a();
        aVar.m46874a(Long.valueOf(j10)).m46873a(Integer.valueOf(i10)).m46884d(strM45322f).m46885e(C8190vl.m50727b((View) this.f34768d)).m46878b(num);
        this.f34190b.mo46593a(aVar.m46877a());
    }

    @Override // com.huawei.openalliance.p169ad.C7336jj
    /* renamed from: a */
    public final void mo45316a(IInterstitialView iInterstitialView) {
        this.f34768d = iInterstitialView;
    }

    /* renamed from: a */
    public void m45927a(C7301d c7301d) {
        this.f34770f = c7301d;
        ContentRecord contentRecordM46653a = C7563ox.m46653a(c7301d);
        this.f34189a = contentRecordM46653a;
        this.f34190b.mo46590a(contentRecordM46653a);
    }

    /* renamed from: a */
    public void m45928a(AbstractC7687ti abstractC7687ti, Integer num, MaterialClickInfo materialClickInfo) {
        C7587b.a aVar = new C7587b.a();
        if (num == null) {
            num = 7;
        }
        aVar.m46920b(abstractC7687ti.m47250c()).m46915a(num).m46914a(materialClickInfo);
        this.f34190b.mo46594a(aVar.m46918a());
    }

    /* renamed from: a */
    public void m45929a(boolean z10) {
        this.f34190b.mo46615b(z10);
    }
}

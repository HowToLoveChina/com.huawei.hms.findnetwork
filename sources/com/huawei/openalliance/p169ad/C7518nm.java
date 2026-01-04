package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.inter.data.C7304g;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7586a;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7587b;
import com.huawei.openalliance.p169ad.utils.C7753b;
import com.huawei.openalliance.p169ad.views.interfaces.IPPSPlacementView;
import java.util.HashMap;

/* renamed from: com.huawei.openalliance.ad.nm */
/* loaded from: classes8.dex */
public class C7518nm extends C7336jj<IPPSPlacementView> {

    /* renamed from: d */
    private Context f34919d;

    /* renamed from: e */
    private C7304g f34920e;

    public C7518nm(Context context, IPPSPlacementView iPPSPlacementView) {
        this.f34919d = context;
        mo45316a((C7518nm) iPPSPlacementView);
        this.f34190b = new C7560ou(context, new C7666so(context));
    }

    /* renamed from: a */
    public void m46155a() {
        this.f34190b.mo46607b(0, 0);
    }

    /* renamed from: b */
    public void m46160b() {
        this.f34190b.mo46606b();
    }

    /* renamed from: a */
    public void m46156a(long j10, int i10, Integer num) {
        String strM45322f = m45322f();
        C7304g c7304g = this.f34920e;
        if (c7304g != null) {
            AbstractC7185ho.m43818a("PlacementAdPresenter", "slotId: %s, contentId: %s, slot pos: %s", c7304g.m44879H(), this.f34920e.getContentId(), strM45322f);
        }
        C7586a.a aVar = new C7586a.a();
        aVar.m46874a(Long.valueOf(j10)).m46873a(Integer.valueOf(i10)).m46878b(num).m46884d(strM45322f).m46885e(m45323g()).m46875a(C7753b.m47700a(mo45320d()));
        this.f34190b.mo46593a(aVar.m46877a());
    }

    /* renamed from: a */
    public void m46157a(MaterialClickInfo materialClickInfo) {
        C7304g c7304g = this.f34920e;
        if (c7304g == null) {
            return;
        }
        c7304g.m44890e(true);
        AbstractC7185ho.m43817a("PlacementAdPresenter", "begin to deal click");
        HashMap map = new HashMap();
        map.put("appId", this.f34920e.getAppMarketAppId());
        map.put("thirdId", this.f34920e.getPromotionChannel());
        AbstractC7687ti abstractC7687tiM47245a = C7686th.m47245a(this.f34919d, this.f34189a, map);
        if (abstractC7687tiM47245a.mo47233a()) {
            m46154a(abstractC7687tiM47245a, materialClickInfo);
        }
    }

    /* renamed from: a */
    public void m46158a(C7304g c7304g) {
        this.f34920e = c7304g;
        this.f34189a = C7575pi.m46766a(c7304g);
        Context context = this.f34919d;
        this.f34190b = new C7560ou(context, new C7666so(context), this.f34189a);
    }

    /* renamed from: a */
    private void m46154a(AbstractC7687ti abstractC7687ti, MaterialClickInfo materialClickInfo) {
        C7587b.a aVar = new C7587b.a();
        aVar.m46920b(abstractC7687ti.m47250c()).m46915a((Integer) 7).m46914a(materialClickInfo).m46923d(C7753b.m47700a(mo45320d()));
        this.f34190b.mo46594a(aVar.m46918a());
        InterfaceC7615qq interfaceC7615qq = this.f34191c;
        if (interfaceC7615qq != null) {
            interfaceC7615qq.mo46594a(aVar.m46918a());
        }
    }

    /* renamed from: a */
    public void m46159a(boolean z10) {
        InterfaceC7615qq interfaceC7615qq = this.f34190b;
        if (interfaceC7615qq == null) {
            return;
        }
        interfaceC7615qq.mo46615b(z10);
    }
}

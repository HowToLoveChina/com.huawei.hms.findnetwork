package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.constant.AdShowExtras;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.inter.C7288c;
import com.huawei.openalliance.p169ad.inter.data.IAd;
import com.huawei.openalliance.p169ad.inter.data.LinkedSplashAd;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.inter.listeners.AdActionListener;
import com.huawei.openalliance.p169ad.inter.listeners.AdShowListener;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7586a;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7587b;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.C7753b;
import com.huawei.openalliance.p169ad.utils.C7780c;
import com.huawei.openalliance.p169ad.views.interfaces.IPPSLinkedView;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.nj */
/* loaded from: classes8.dex */
public class C7515nj extends C7336jj<IPPSLinkedView> implements InterfaceC7531nz {

    /* renamed from: d */
    private Context f34905d;

    /* renamed from: e */
    private LinkedSplashAd f34906e;

    /* renamed from: f */
    private AdActionListener f34907f;

    /* renamed from: g */
    private AdShowListener f34908g;

    /* renamed from: h */
    private boolean f34909h = false;

    /* renamed from: i */
    private boolean f34910i = false;

    /* renamed from: j */
    private boolean f34911j = false;

    public C7515nj(Context context, IPPSLinkedView iPPSLinkedView) {
        this.f34905d = context.getApplicationContext();
        mo45316a((C7515nj) iPPSLinkedView);
        Context context2 = this.f34905d;
        this.f34190b = new C7560ou(context2, new C7668sq(context2, 1));
    }

    /* renamed from: l */
    private boolean m46126l() {
        return this.f34909h;
    }

    @Override // com.huawei.openalliance.p169ad.C7336jj
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public IPPSLinkedView mo45320d() {
        return (IPPSLinkedView) super.mo45320d();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7531nz
    /* renamed from: b */
    public void mo46136b() {
        this.f34190b.mo46606b();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7531nz
    /* renamed from: c */
    public void mo46139c() {
        this.f34190b.mo46607b(0, 0);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7531nz
    /* renamed from: h */
    public void mo46140h() {
        this.f34190b.mo46633p();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7531nz
    /* renamed from: i */
    public void mo46141i() {
        this.f34190b.mo46616c();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7531nz
    /* renamed from: j */
    public void mo46142j() {
        this.f34190b.mo46623f();
    }

    /* renamed from: k */
    public boolean m46143k() {
        return this.f34910i;
    }

    /* renamed from: c */
    private void m46125c(boolean z10) {
        this.f34909h = z10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7531nz
    /* renamed from: a */
    public void mo46128a(long j10, int i10) {
        this.f34190b.mo46581a(j10, i10);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7531nz
    /* renamed from: b */
    public void mo46137b(long j10, long j11, long j12, long j13) {
        this.f34190b.mo46608b(j10, j11, (int) j12, (int) j13);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7531nz
    /* renamed from: a */
    public void mo46129a(long j10, long j11, long j12, long j13) {
        this.f34190b.mo46617c(j10, j11, (int) j12, (int) j13);
    }

    /* renamed from: b */
    public void m46138b(boolean z10) {
        this.f34910i = z10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7531nz
    /* renamed from: a */
    public void mo46130a(LinkedSplashAd linkedSplashAd) {
        this.f34906e = linkedSplashAd;
        if (linkedSplashAd != null) {
            this.f34189a = linkedSplashAd.m44490K();
        }
        Context context = this.f34905d;
        this.f34190b = new C7560ou(context, new C7668sq(context, 1), this.f34189a);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7531nz
    /* renamed from: a */
    public void mo46131a(AdActionListener adActionListener) {
        this.f34907f = adActionListener;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7531nz
    /* renamed from: a */
    public void mo46132a(AdShowListener adShowListener) {
        this.f34908g = adShowListener;
    }

    /* renamed from: a */
    private void m46123a(AbstractC7687ti abstractC7687ti, int i10, MaterialClickInfo materialClickInfo) {
        C7587b.a aVar = new C7587b.a();
        aVar.m46920b(abstractC7687ti.m47250c()).m46915a(Integer.valueOf(i10)).m46914a(materialClickInfo).m46923d(C7753b.m47700a(mo45320d()));
        this.f34190b.mo46594a(aVar.m46918a());
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7531nz
    /* renamed from: a */
    public void mo46133a(Long l10, Integer num, Integer num2) {
        String splashViewSlotPosition;
        LinkedSplashAd linkedSplashAd = this.f34906e;
        boolean zM47867a = C7780c.m47867a(linkedSplashAd != null ? linkedSplashAd.m44627d() : null, num2);
        if (m46126l() && (!zM47867a || m46143k())) {
            AbstractC7185ho.m43823c("PPSLinkedVideoViewPresenter", "show event already reported before, ignore this");
            return;
        }
        IPPSLinkedView iPPSLinkedViewMo45320d = mo45320d();
        if (iPPSLinkedViewMo45320d != null) {
            splashViewSlotPosition = iPPSLinkedViewMo45320d.getSplashViewSlotPosition();
            LinkedSplashAd linkedSplashAd2 = this.f34906e;
            if (linkedSplashAd2 != null) {
                AbstractC7185ho.m43818a("PPSLinkedVideoViewPresenter", "slotId: %s, contentId: %s, slot pos: %s", linkedSplashAd2.getSlotId(), this.f34906e.getContentId(), splashViewSlotPosition);
            }
        } else {
            splashViewSlotPosition = "";
        }
        C7586a.a aVar = new C7586a.a();
        aVar.m46874a(l10).m46873a(num).m46878b(num2).m46885e(m45323g()).m46875a(C7753b.m47700a(mo45320d()));
        if (!AbstractC7806cz.m48165b(splashViewSlotPosition)) {
            aVar.m46884d(splashViewSlotPosition);
        }
        this.f34190b.mo46593a(aVar.m46877a());
        if (zM47867a) {
            m46138b(true);
        }
        if (m46126l()) {
            return;
        }
        m46125c(true);
        if (this.f34908g != null && this.f34189a != null) {
            HashMap map = new HashMap();
            map.put(AdShowExtras.PRELOAD_MODE, String.valueOf(C7120fd.m43288a(this.f34905d).mo43290a(this.f34189a.m41585m())));
            map.put(AdShowExtras.DOWNLOAD_SOURCE, AbstractC7807d.m48210a(this.f34189a.m41423U()));
            this.f34908g.onAdShowed(map);
        }
        AdActionListener adActionListener = this.f34907f;
        if (adActionListener != null) {
            adActionListener.onAdShowed();
        }
    }

    @Override // com.huawei.openalliance.p169ad.C7336jj, com.huawei.openalliance.p169ad.InterfaceC7531nz
    /* renamed from: a */
    public void mo45318a(String str) {
        super.mo45318a(str);
        m46125c(false);
        m46138b(false);
    }

    /* renamed from: a */
    private void m46124a(Map<String, String> map) {
        LinkedSplashAd linkedSplashAd;
        if (map == null || map.isEmpty() || (linkedSplashAd = this.f34906e) == null || linkedSplashAd.getVideoInfo() == null) {
            return;
        }
        int iM44566b = this.f34906e.getVideoInfo().m44566b();
        if (Math.abs(this.f34906e.getVideoInfo().getVideoDuration() - iM44566b) < 1000) {
            iM44566b = 0;
        }
        AbstractC7185ho.m43821b("PPSLinkedVideoViewPresenter", "buildLinkedAdConfig, duration: %s, set progress from LinkedSplash view:%s ", Integer.valueOf(this.f34906e.getVideoInfo().getVideoDuration()), Integer.valueOf(iM44566b));
        map.put(MapKeyNames.LINKED_CUSTOM_RETURN_VIDEO_DIRECT, this.f34906e.getVideoInfo().m44585f() ? FaqConstants.DISABLE_HA_REPORT : "false");
        map.put(MapKeyNames.LINKED_CUSTOM_VIDEO_SOUND_SWITCH, this.f34906e.getVideoInfo().getSoundSwitch());
        map.put(MapKeyNames.LINKED_CUSTOM_VIDEO_PROGRESS, String.valueOf(iM44566b));
        map.put(MapKeyNames.LINKED_SPLASH_MEDIA_PATH, this.f34906e.mo44485F());
        map.put(MapKeyNames.LINKED_CUSTOM_SHOW_ID, this.f34906e.getShowId());
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7531nz
    /* renamed from: a */
    public void mo46134a(boolean z10) {
        this.f34190b.mo46615b(z10);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7531nz
    /* renamed from: a */
    public boolean mo46135a(int i10, MaterialClickInfo materialClickInfo) {
        LinkedSplashAd linkedSplashAd = this.f34906e;
        if (linkedSplashAd == null) {
            return false;
        }
        linkedSplashAd.m44838f(true);
        AbstractC7014dc.m41869a((IAd) this.f34906e);
        AbstractC7185ho.m43820b("PPSLinkedVideoViewPresenter", "begin to deal click");
        HashMap map = new HashMap();
        map.put("appId", this.f34906e.m44769O());
        map.put("thirdId", this.f34906e.m44767N());
        m46124a(map);
        AdActionListener adActionListener = this.f34907f;
        if (adActionListener != null) {
            adActionListener.onAdClick();
        }
        AbstractC7687ti abstractC7687tiM47245a = C7686th.m47245a(this.f34905d, this.f34189a, map);
        boolean zMo47233a = abstractC7687tiM47245a.mo47233a();
        if (zMo47233a) {
            m46123a(abstractC7687tiM47245a, i10, materialClickInfo);
        }
        C7288c.m44224a(this.f34905d).m44229a(false);
        return zMo47233a;
    }
}

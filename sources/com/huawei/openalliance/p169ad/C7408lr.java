package com.huawei.openalliance.p169ad;

import com.iab.omid.library.huawei.adsession.AdEvents;
import com.iab.omid.library.huawei.adsession.AdSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.lr */
/* loaded from: classes8.dex */
public class C7408lr extends AbstractC7409ls implements InterfaceC7413lw {

    /* renamed from: a */
    private static boolean f34437a = C7418ma.m45655a("com.iab.omid.library.huawei.adsession.AdEvents");

    /* renamed from: b */
    private final List<AdEvents> f34438b = new ArrayList();

    @Override // com.huawei.openalliance.p169ad.InterfaceC7413lw
    /* renamed from: a */
    public void mo45636a(InterfaceC7474mi interfaceC7474mi) {
        if (interfaceC7474mi instanceof C7406lp) {
            List<AdSession> listM45632b = ((C7406lp) interfaceC7474mi).m45632b();
            if (listM45632b.isEmpty()) {
                return;
            }
            for (AdSession adSession : listM45632b) {
                if (adSession != null) {
                    this.f34438b.add(AdEvents.createAdEvents(adSession));
                }
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7413lw
    /* renamed from: b */
    public void mo45637b() {
        this.f34438b.clear();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7478mm
    /* renamed from: e */
    public void mo45618e() {
        AbstractC7185ho.m43820b("DisplayEventAgent", "impressionOccurred");
        if (this.f34438b.isEmpty()) {
            AbstractC7185ho.m43823c("DisplayEventAgent", "impressionOccurred, mAdEventList isEmpty");
            return;
        }
        try {
            Iterator<AdEvents> it = this.f34438b.iterator();
            while (it.hasNext()) {
                it.next().impressionOccurred();
            }
        } catch (IllegalStateException unused) {
            AbstractC7185ho.m43820b("DisplayEventAgent", "impressionOccurred, fail");
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7478mm
    /* renamed from: f */
    public void mo45619f() {
        AbstractC7185ho.m43820b("DisplayEventAgent", "load");
        if (this.f34438b.isEmpty()) {
            AbstractC7185ho.m43820b("DisplayEventAgent", "load, AdEventList isEmpty");
            return;
        }
        try {
            Iterator<AdEvents> it = this.f34438b.iterator();
            while (it.hasNext()) {
                it.next().loaded();
            }
        } catch (IllegalStateException unused) {
            AbstractC7185ho.m43820b("DisplayEventAgent", "loaded, fail");
        }
    }

    /* renamed from: a */
    public static boolean m45635a() {
        return f34437a;
    }
}

package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.openalliance.p169ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.openalliance.p169ad.inter.data.LinkedSplashAd;
import com.huawei.openalliance.p169ad.inter.listeners.LinkedAdListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7810dc;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* renamed from: com.huawei.openalliance.ad.iz */
/* loaded from: classes8.dex */
public class C7325iz extends AbstractC7323ix {

    /* renamed from: p */
    private final int f34107p;

    public C7325iz(InterfaceC8119l interfaceC8119l) {
        super(interfaceC8119l);
        this.f34107p = hashCode();
    }

    /* renamed from: C */
    private void m45203C() {
        AbstractC7817dj.m48364a(new Runnable() { // from class: com.huawei.openalliance.ad.iz.3
            @Override // java.lang.Runnable
            public void run() {
                C7325iz.this.m45186m();
            }
        }, RippleView.SINGLE_RIPPLE_TIME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public ContentRecord m45204D() {
        AdSlotParam adSlotParamM45184k = m45184k();
        if (adSlotParamM45184k == null) {
            return null;
        }
        String str = adSlotParamM45184k.m40627a().get(0);
        int iM40639b = adSlotParamM45184k.m40639b();
        long jMo43340aG = this.f34048c.mo43340aG();
        ContentRecord contentRecordM45207a = m45207a(str, iM40639b, jMo43340aG, adSlotParamM45184k.m40623G());
        return contentRecordM45207a == null ? m45206a(str, iM40639b, jMo43340aG) : contentRecordM45207a;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: A */
    public void mo45208A() {
        AbstractC7185ho.m43820b("CacheAdMediator", "start");
        InterfaceC8119l interfaceC8119lM45189p = m45189p();
        if (interfaceC8119lM45189p == null) {
            mo45168c(-4);
            mo45183j();
            return;
        }
        Context context = interfaceC8119lM45189p.getContext();
        C7008cy c7008cy = new C7008cy(context);
        c7008cy.m41238a(new C7011da(context));
        boolean z10 = AbstractC7807d.m48256s(context) == 1;
        AbstractC7185ho.m43821b("CacheAdMediator", "readScreenOn: %s", Boolean.valueOf(z10));
        ContentRecord contentRecord = (c7008cy.mo41237a() || z10) ? null : (ContentRecord) AbstractC7810dc.m48272b(new Callable<ContentRecord>() { // from class: com.huawei.openalliance.ad.iz.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ContentRecord call() {
                C7325iz.this.m45181h();
                return C7325iz.this.m45204D();
            }
        });
        this.f34052g = true;
        if (contentRecord != null) {
            m45175e(contentRecord);
            if (contentRecord.m41392E() == 12) {
                if (mo45170d() != 1 || !(m45167c() instanceof LinkedAdListener)) {
                    mo45168c(1200);
                    mo45209B();
                    m45203C();
                    return;
                }
                LinkedAdListener linkedAdListener = (LinkedAdListener) m45167c();
                LinkedSplashAd linkedSplashAdM46668a = C7565oz.m46668a(context, contentRecord);
                AbstractC7185ho.m43820b("CacheAdMediator", "on content find, linkedAd loaded. ");
                this.f34057l.m40035b(System.currentTimeMillis());
                linkedAdListener.onLinkedAdLoaded(linkedSplashAdM46668a);
                this.f34056k = contentRecord;
                m45203C();
                m45180g(200);
                return;
            }
            this.f34050e.mo46590a(contentRecord);
            if (!mo45169c(contentRecord)) {
                mo45168c(ErrorCode.ERROR_CODE_NULL_AD_VIEW);
                mo45209B();
            }
        } else {
            AbstractC7185ho.m43820b("CacheAdMediator", "show sloganView");
            interfaceC8119lM45189p.mo49713a(new InterfaceC7182hl() { // from class: com.huawei.openalliance.ad.iz.2
                @Override // com.huawei.openalliance.p169ad.InterfaceC7182hl
                /* renamed from: a */
                public void mo43801a() {
                    AbstractC7185ho.m43820b("CacheAdMediator", "on Slogan Reach Min Show Time");
                }

                @Override // com.huawei.openalliance.p169ad.InterfaceC7182hl
                /* renamed from: b */
                public void mo43802b() {
                    AbstractC7185ho.m43820b("CacheAdMediator", "on Slogan Show End");
                    AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.iz.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            C7325iz.this.mo45168c(ErrorCode.ERROR_CODE_NO_CACHE_AD);
                            C7325iz.this.mo45183j();
                        }
                    });
                }
            });
        }
        m45203C();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: B */
    public void mo45209B() {
        AbstractC7185ho.m43820b("CacheAdMediator", "onAdFailToDisplay");
        mo45183j();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7621qw
    /* renamed from: b */
    public List<ContentRecord> mo44095b(AdContentRsp adContentRsp) {
        List<ContentRecord> listM46757a = AbstractC7573pg.m46757a(adContentRsp, this.f34059n);
        if (m45184k() != null) {
            m45159a(listM46757a, m45184k().m40639b(), 1);
        }
        return listM46757a;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7323ix
    /* renamed from: d */
    public void mo45171d(ContentRecord contentRecord) {
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7323ix
    /* renamed from: r */
    public String mo45191r() {
        return String.valueOf(1);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7323ix
    /* renamed from: z */
    public String mo45199z() {
        return "CacheAdMediator" + this.f34107p;
    }

    /* renamed from: a */
    private ContentRecord m45206a(String str, int i10, long j10) {
        boolean z10 = false;
        ContentRecord contentRecord = null;
        ContentRecord contentRecord2 = null;
        boolean z11 = false;
        for (ContentRecord contentRecord3 : this.f34049d.mo43114b(str, i10, j10, this.f34059n)) {
            if (contentRecord3 != null) {
                if (z10 && z11) {
                    break;
                }
                if (!z10 && contentRecord3.m41392E() == 12) {
                    contentRecord = contentRecord3;
                    z10 = true;
                } else if (!z11 && contentRecord3.m41392E() != 12) {
                    contentRecord2 = contentRecord3;
                    z11 = true;
                }
            }
        }
        AbstractC7185ho.m43821b("CacheAdMediator", "linkedSupportMode:%s, firstNormal: %s, firstLink:%s", Integer.valueOf(mo45170d()), contentRecord2, contentRecord);
        if (mo45170d() != 1) {
            AbstractC7014dc.m41868a((ContentRecord) null);
            return contentRecord2;
        }
        if (contentRecord == null) {
            AbstractC7014dc.m41868a((ContentRecord) null);
            return contentRecord2;
        }
        if (contentRecord2 != null) {
            AbstractC7014dc.m41868a(contentRecord2);
        } else {
            AbstractC7014dc.m41868a((ContentRecord) null);
        }
        return contentRecord;
    }

    /* renamed from: a */
    private ContentRecord m45207a(String str, int i10, long j10, Map<String, Integer> map) {
        AbstractC7185ho.m43820b("CacheAdMediator", "query CachedContentV3");
        List<ContentRecord> listMo43114b = C7104et.m43127b(this.f34060o).mo43114b(str, i10, j10, this.f34059n);
        if (AbstractC7760bg.m47767a(listMo43114b)) {
            return null;
        }
        for (ContentRecord contentRecord : listMo43114b) {
            if (contentRecord != null && !C7128fl.m43510a(this.f34060o).mo43527a(str, contentRecord.m41463aO(), map)) {
                AbstractC7185ho.m43820b("CacheAdMediator", "v3 content got");
                return contentRecord;
            }
        }
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7621qw
    /* renamed from: a */
    public List<ContentRecord> mo44094a(AdContentRsp adContentRsp) {
        return AbstractC7573pg.m46759b(adContentRsp, this.f34059n);
    }
}

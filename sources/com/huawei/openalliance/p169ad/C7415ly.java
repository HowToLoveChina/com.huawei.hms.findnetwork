package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.C7421mc;
import com.huawei.openalliance.p169ad.utils.AbstractC7768bo;
import com.iab.omid.library.huawei.adsession.AdEvents;
import com.iab.omid.library.huawei.adsession.AdSession;
import com.iab.omid.library.huawei.adsession.media.InteractionType;
import com.iab.omid.library.huawei.adsession.media.MediaEvents;
import com.iab.omid.library.huawei.adsession.media.VastProperties;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.ly */
/* loaded from: classes8.dex */
public class C7415ly extends AbstractC7414lx implements InterfaceC7413lw {

    /* renamed from: a */
    private static boolean f34439a = false;

    /* renamed from: d */
    private C7421mc f34442d;

    /* renamed from: b */
    private final List<MediaEvents> f34440b = new ArrayList();

    /* renamed from: c */
    private final List<AdEvents> f34441c = new ArrayList();

    /* renamed from: e */
    private boolean f34443e = false;

    /* renamed from: f */
    private int f34444f = 0;

    /* renamed from: g */
    private float f34445g = 0.0f;

    /* renamed from: h */
    private boolean f34446h = false;

    static {
        f34439a = C7418ma.m45655a("com.iab.omid.library.huawei.adsession.media.MediaEvents") && C7418ma.m45655a("com.iab.omid.library.huawei.adsession.AdEvents");
    }

    /* renamed from: e */
    public static boolean m45648e() {
        return f34439a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m45649m() {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a(m45650n(), "volumeChangeInner %s", Boolean.valueOf(this.f34443e));
        }
        mo45614b(this.f34443e ? 0.0f : 1.0f);
    }

    /* renamed from: n */
    private String m45650n() {
        return "VideoEventAgent" + hashCode();
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7414lx
    /* renamed from: a */
    public void mo45639a() {
        if (this.f34440b.isEmpty()) {
            AbstractC7185ho.m43823c(m45650n(), "firstQuartile, mVideoEventsList isEmpty");
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.f34440b) {
                if (mediaEvents != null) {
                    AbstractC7185ho.m43820b(m45650n(), "firstQuartile");
                    mediaEvents.firstQuartile();
                }
            }
        } catch (IllegalStateException unused) {
            AbstractC7185ho.m43820b(m45650n(), "firstQuartile, fail");
        }
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7414lx
    /* renamed from: d */
    public void mo45644d() {
        if (this.f34440b.isEmpty()) {
            AbstractC7185ho.m43823c(m45650n(), "thirdQuartile, mVideoEventsList isEmpty");
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.f34440b) {
                if (mediaEvents != null) {
                    AbstractC7185ho.m43820b(m45650n(), "thirdQuartile ");
                    mediaEvents.thirdQuartile();
                }
            }
        } catch (IllegalStateException unused) {
            AbstractC7185ho.m43820b(m45650n(), "thirdQuartile, fail");
        }
    }

    /* renamed from: f */
    public void m45651f() {
        if (this.f34441c.isEmpty()) {
            AbstractC7185ho.m43823c(m45650n(), "impressionOccurred, mAdEventList isEmpty");
            return;
        }
        try {
            Iterator<AdEvents> it = this.f34441c.iterator();
            while (it.hasNext()) {
                it.next().impressionOccurred();
            }
        } catch (IllegalStateException unused) {
            AbstractC7185ho.m43820b(m45650n(), "impressionOccurred, fail");
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7479mn
    /* renamed from: g */
    public void mo45620g() {
        this.f34445g = 0.0f;
        this.f34444f = 0;
        if (this.f34440b.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.f34440b) {
                if (mediaEvents != null) {
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43817a(m45650n(), "complete ");
                    }
                    mediaEvents.complete();
                }
            }
        } catch (IllegalStateException unused) {
            AbstractC7185ho.m43820b(m45650n(), "complete, fail");
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7479mn
    /* renamed from: h */
    public void mo45621h() {
        if (this.f34440b.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.f34440b) {
                if (mediaEvents != null) {
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43817a(m45650n(), "bufferStart ");
                    }
                    mediaEvents.bufferStart();
                }
            }
        } catch (IllegalStateException unused) {
            AbstractC7185ho.m43820b(m45650n(), "bufferStart, fail");
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7479mn
    /* renamed from: i */
    public void mo45622i() {
        if (this.f34440b.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.f34440b) {
                if (mediaEvents != null) {
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43817a(m45650n(), "bufferFinish ");
                    }
                    mediaEvents.bufferFinish();
                }
            }
        } catch (IllegalStateException unused) {
            AbstractC7185ho.m43820b(m45650n(), "bufferFinish, fail");
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7479mn
    /* renamed from: j */
    public void mo45623j() {
        if (!this.f34446h) {
            this.f34444f = 0;
        }
        if (this.f34440b.isEmpty()) {
            AbstractC7185ho.m43823c(m45650n(), "skipped, mVideoEventsList isEmpty");
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.f34440b) {
                if (mediaEvents != null) {
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43817a(m45650n(), "skipped ");
                    }
                    mediaEvents.skipped();
                }
            }
        } catch (IllegalStateException unused) {
            AbstractC7185ho.m43820b(m45650n(), "skipped, fail");
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7479mn
    /* renamed from: k */
    public void mo45624k() {
        if (this.f34440b.isEmpty() || 1 != this.f34444f) {
            return;
        }
        try {
            this.f34444f = 2;
            for (MediaEvents mediaEvents : this.f34440b) {
                if (mediaEvents != null) {
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43817a(m45650n(), "pause ");
                    }
                    mediaEvents.pause();
                }
            }
        } catch (IllegalStateException unused) {
            AbstractC7185ho.m43820b(m45650n(), "pause, fail");
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7479mn
    /* renamed from: l */
    public void mo45625l() {
        this.f34444f = 1;
        if (this.f34440b.isEmpty()) {
            AbstractC7185ho.m43823c(m45650n(), "resume, mVideoEventsList isEmpty");
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.f34440b) {
                if (mediaEvents != null) {
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43817a(m45650n(), "resume ");
                    }
                    mediaEvents.resume();
                }
            }
        } catch (IllegalStateException unused) {
            AbstractC7185ho.m43820b(m45650n(), "resume, fail");
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7479mn
    /* renamed from: a */
    public void mo45605a(float f10) {
        int iM45672a = C7420mb.m45672a(this.f34445g, f10);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a(m45650n(), "onProgress %s", Integer.valueOf(iM45672a));
        }
        if (iM45672a == 25) {
            this.f34445g = iM45672a;
            mo45639a();
        } else if (iM45672a == 50) {
            this.f34445g = iM45672a;
            mo45643c();
        } else {
            if (iM45672a != 75) {
                return;
            }
            this.f34445g = iM45672a;
            mo45644d();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7413lw
    /* renamed from: b */
    public void mo45637b() {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a(m45650n(), "release ");
        }
        this.f34444f = 0;
        C7421mc c7421mc = this.f34442d;
        if (c7421mc != null) {
            c7421mc.m45676a();
        }
        AbstractC7768bo.m47808a(new Runnable() { // from class: com.huawei.openalliance.ad.ly.2
            @Override // java.lang.Runnable
            public void run() {
                C7415ly.this.f34440b.clear();
                C7415ly.this.f34441c.clear();
            }
        }, 200L);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7414lx
    /* renamed from: c */
    public void mo45643c() {
        if (this.f34440b.isEmpty()) {
            AbstractC7185ho.m43823c(m45650n(), "midpoint, mVideoEventsList isEmpty");
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.f34440b) {
                if (mediaEvents != null) {
                    AbstractC7185ho.m43820b(m45650n(), "midpoint ");
                    mediaEvents.midpoint();
                }
            }
        } catch (IllegalStateException unused) {
            AbstractC7185ho.m43820b(m45650n(), "midpoint, fail");
        }
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7414lx
    /* renamed from: a */
    public void mo45640a(float f10, float f11) {
        if (this.f34440b.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.f34440b) {
                if (mediaEvents != null) {
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43818a(m45650n(), "start，duration: %s ", Float.valueOf(f10));
                    }
                    mediaEvents.start(f10, f11);
                }
            }
        } catch (IllegalStateException unused) {
            AbstractC7185ho.m43820b(m45650n(), "start, fail");
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7479mn
    /* renamed from: b */
    public void mo45614b(float f10) {
        C7421mc c7421mc;
        AbstractC7185ho.m43821b(m45650n(), "volumeChange %s", Float.valueOf(f10));
        this.f34443e = Math.abs(f10 - 0.0f) < 1.0E-8f;
        if (this.f34440b.isEmpty() || this.f34444f != 1) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.f34440b) {
                if (mediaEvents != null && (c7421mc = this.f34442d) != null) {
                    if (f10 == -1.0f) {
                        mediaEvents.volumeChange(c7421mc.m45675a(this.f34443e));
                    } else {
                        mediaEvents.volumeChange(f10);
                    }
                }
            }
        } catch (IllegalStateException unused) {
            AbstractC7185ho.m43820b(m45650n(), "volumeChange, fail");
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7479mn
    /* renamed from: a */
    public void mo45606a(float f10, boolean z10) {
        this.f34444f = 1;
        this.f34443e = z10;
        mo45640a(f10, z10 ? 0.0f : 1.0f);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7479mn
    /* renamed from: b */
    public void mo45615b(boolean z10) {
        this.f34446h = z10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7413lw
    /* renamed from: a */
    public void mo45636a(InterfaceC7474mi interfaceC7474mi) {
        String strM45650n;
        String str;
        if (f34439a) {
            if ((interfaceC7474mi instanceof C7406lp) && m45648e()) {
                C7406lp c7406lp = (C7406lp) interfaceC7474mi;
                Context contextM45633e = c7406lp.m45633e();
                if (contextM45633e != null) {
                    AbstractC7185ho.m43820b(m45650n(), "Set VolumeChange observer");
                    C7421mc c7421mc = new C7421mc(contextM45633e);
                    this.f34442d = c7421mc;
                    c7421mc.m45677a(new C7421mc.b() { // from class: com.huawei.openalliance.ad.ly.1
                        @Override // com.huawei.openalliance.p169ad.C7421mc.b
                        /* renamed from: a */
                        public void mo45652a() {
                            C7415ly.this.m45649m();
                        }
                    });
                }
                List<AdSession> listM45632b = c7406lp.m45632b();
                if (!listM45632b.isEmpty()) {
                    for (AdSession adSession : listM45632b) {
                        if (adSession != null) {
                            if (AbstractC7185ho.m43819a()) {
                                AbstractC7185ho.m43817a(m45650n(), "setAdSessionAgent, add mVideoEventsList");
                            }
                            this.f34440b.add(MediaEvents.createMediaEvents(adSession));
                            this.f34441c.add(AdEvents.createAdEvents(adSession));
                        }
                    }
                    return;
                }
                strM45650n = m45650n();
                str = "adSessionList is empty";
            } else {
                strM45650n = m45650n();
                str = "adsessionAgent is null";
            }
            AbstractC7185ho.m43820b(strM45650n, str);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7479mn
    /* renamed from: a */
    public void mo45610a(EnumC7480mo enumC7480mo) {
        InteractionType interactionTypeM45846a;
        if (!EnumC7480mo.m45847a() || (interactionTypeM45846a = EnumC7480mo.m45846a(enumC7480mo)) == null) {
            return;
        }
        mo45641a(interactionTypeM45846a);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7479mn
    /* renamed from: a */
    public void mo45611a(C7482mq c7482mq) {
        VastProperties vastPropertiesM45851b;
        if (c7482mq == null || !C7482mq.m45850a() || (vastPropertiesM45851b = c7482mq.m45851b()) == null) {
            return;
        }
        mo45642a(vastPropertiesM45851b);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7414lx
    /* renamed from: a */
    public void mo45641a(InteractionType interactionType) {
        if (this.f34440b.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.f34440b) {
                if (mediaEvents != null) {
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43817a(m45650n(), "adUserInteraction ");
                    }
                    mediaEvents.adUserInteraction(interactionType);
                }
            }
        } catch (IllegalStateException unused) {
            AbstractC7185ho.m43820b(m45650n(), "adUserInteraction, fail");
        }
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7414lx
    /* renamed from: a */
    public void mo45642a(VastProperties vastProperties) {
        if (this.f34441c.isEmpty()) {
            return;
        }
        try {
            for (AdEvents adEvents : this.f34441c) {
                if (adEvents != null) {
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43817a(m45650n(), "loaded ");
                    }
                    adEvents.loaded(vastProperties);
                }
            }
        } catch (IllegalStateException unused) {
            AbstractC7185ho.m43820b(m45650n(), "loaded, fail");
        }
    }
}

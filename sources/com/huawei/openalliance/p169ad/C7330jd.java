package com.huawei.openalliance.p169ad;

import android.view.View;
import com.huawei.openalliance.p169ad.inter.data.LinkedSplashAd;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;

/* renamed from: com.huawei.openalliance.ad.jd */
/* loaded from: classes8.dex */
public class C7330jd extends AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh {

    /* renamed from: a */
    boolean f34143a;

    /* renamed from: b */
    boolean f34144b;

    /* renamed from: c */
    protected LinkedSplashAd f34145c;

    /* renamed from: e */
    private a f34146e;

    /* renamed from: f */
    private long f34147f;

    /* renamed from: g */
    private int f34148g;

    /* renamed from: h */
    private boolean f34149h;

    /* renamed from: i */
    private long f34150i;

    /* renamed from: j */
    private int f34151j;

    /* renamed from: k */
    private int f34152k;

    /* renamed from: l */
    private int f34153l;

    /* renamed from: com.huawei.openalliance.ad.jd$a */
    public interface a {
        /* renamed from: a */
        void mo45265a();

        /* renamed from: a */
        void mo45266a(long j10, int i10);

        /* renamed from: b */
        void mo45267b();

        /* renamed from: b */
        void mo45268b(long j10, int i10);

        /* renamed from: c */
        void mo45269c();

        /* renamed from: d */
        void mo45270d();

        /* renamed from: e */
        void mo45271e();
    }

    public C7330jd(View view, a aVar) {
        super(view);
        this.f34147f = 500L;
        this.f34148g = 50;
        this.f34149h = false;
        this.f34152k = 100;
        this.f34153l = 10;
        this.f34143a = false;
        this.f34144b = false;
        this.f34146e = aVar;
        this.f34150i = AbstractC7741ao.m47566c();
    }

    /* renamed from: o */
    private void m45250o() {
        if (this.f34149h) {
            return;
        }
        AbstractC7185ho.m43820b("PPSLinkedViewMonitor", "viewShowStartRecord");
        this.f34149h = true;
        this.f34150i = System.currentTimeMillis();
        a aVar = this.f34146e;
        if (aVar != null) {
            aVar.mo45265a();
        }
    }

    /* renamed from: p */
    private void m45251p() {
        if (this.f34149h) {
            AbstractC7185ho.m43820b("PPSLinkedViewMonitor", "viewShowEndRecord");
            this.f34149h = false;
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f34150i;
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("PPSLinkedViewMonitor", "max visible area percentage: %d duration: %d", Integer.valueOf(this.f34151j), Long.valueOf(jCurrentTimeMillis));
            }
            a aVar = this.f34146e;
            if (aVar != null) {
                aVar.mo45266a(jCurrentTimeMillis, this.f34151j);
            }
            this.f34151j = 0;
        }
    }

    @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
    /* renamed from: a */
    public void mo45252a() {
        a aVar = this.f34146e;
        if (aVar != null) {
            aVar.mo45267b();
        }
    }

    /* renamed from: b */
    public int m45257b() {
        return this.f34152k;
    }

    /* renamed from: c */
    public int m45260c() {
        return this.f34153l;
    }

    /* renamed from: d */
    public int m45261d() {
        return this.f34151j;
    }

    /* renamed from: e */
    public long m45262e() {
        return this.f34150i;
    }

    /* renamed from: f */
    public void m45263f() {
        a aVar;
        int iM45304k = m45304k();
        AbstractC7185ho.m43821b("PPSLinkedViewMonitor", "checkAutoPlay, visibleArea: %s", Integer.valueOf(iM45304k));
        if (iM45304k < m45257b() || (aVar = this.f34146e) == null) {
            return;
        }
        aVar.mo45269c();
    }

    /* renamed from: g */
    public boolean m45264g() {
        return m45304k() >= m45257b();
    }

    @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
    /* renamed from: a */
    public void mo45253a(int i10) {
        AbstractC7185ho.m43821b("PPSLinkedViewMonitor", "onUpdateViewShowArea, percentage: %s", Integer.valueOf(i10));
        if (i10 > this.f34151j) {
            this.f34151j = i10;
        }
        if (i10 >= this.f34148g) {
            m45250o();
        } else {
            m45251p();
        }
        m45258b(i10);
    }

    /* renamed from: b */
    public void m45258b(int i10) {
        a aVar;
        if (i10 >= m45257b()) {
            this.f34144b = false;
            if (this.f34143a) {
                return;
            }
            this.f34143a = true;
            a aVar2 = this.f34146e;
            if (aVar2 != null) {
                aVar2.mo45269c();
                return;
            }
            return;
        }
        this.f34143a = false;
        if (i10 > 100 - m45260c()) {
            if (this.f34144b && (aVar = this.f34146e) != null) {
                aVar.mo45271e();
            }
            this.f34144b = false;
            return;
        }
        if (this.f34144b) {
            return;
        }
        this.f34144b = true;
        a aVar3 = this.f34146e;
        if (aVar3 != null) {
            aVar3.mo45270d();
        }
    }

    @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
    /* renamed from: a */
    public void mo45254a(long j10, int i10) {
        m45251p();
        a aVar = this.f34146e;
        if (aVar != null) {
            aVar.mo45268b(j10, i10);
        }
        m45258b(0);
    }

    /* renamed from: b */
    public void m45259b(long j10, int i10) {
        this.f34148g = i10;
        this.f34147f = j10;
    }

    /* renamed from: a */
    public void m45255a(LinkedSplashAd linkedSplashAd) {
        this.f34145c = linkedSplashAd;
        if (linkedSplashAd == null || linkedSplashAd.getVideoInfo() == null) {
            return;
        }
        VideoInfo videoInfo = linkedSplashAd.getVideoInfo();
        this.f34152k = videoInfo.getAutoPlayAreaRatio();
        this.f34153l = Math.max(100 - videoInfo.getAutoStopPlayAreaRatio(), 0);
    }

    /* renamed from: a */
    public boolean m45256a(long j10) {
        return j10 >= this.f34147f && this.f34151j >= this.f34148g;
    }
}

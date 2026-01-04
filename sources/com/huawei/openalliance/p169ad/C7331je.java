package com.huawei.openalliance.p169ad;

import android.view.View;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;

/* renamed from: com.huawei.openalliance.ad.je */
/* loaded from: classes8.dex */
public class C7331je extends AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh {

    /* renamed from: a */
    private a f34154a;

    /* renamed from: b */
    private long f34155b;

    /* renamed from: c */
    private int f34156c;

    /* renamed from: e */
    private boolean f34157e;

    /* renamed from: f */
    private long f34158f;

    /* renamed from: g */
    private int f34159g;

    /* renamed from: com.huawei.openalliance.ad.je$a */
    public interface a {
        /* renamed from: a */
        void mo45279a();

        /* renamed from: a */
        void mo45280a(long j10, int i10);

        /* renamed from: b */
        void mo45281b();

        /* renamed from: b */
        void mo45282b(long j10, int i10);
    }

    public C7331je(View view, a aVar) {
        super(view);
        this.f34155b = 500L;
        this.f34156c = 50;
        this.f34157e = false;
        this.f34154a = aVar;
        this.f34158f = AbstractC7741ao.m47566c();
    }

    /* renamed from: e */
    private void m45272e() {
        if (this.f34157e) {
            return;
        }
        AbstractC7185ho.m43820b("PPSNativeViewMonitor", "viewShowStartRecord");
        this.f34157e = true;
        this.f34158f = System.currentTimeMillis();
        a aVar = this.f34154a;
        if (aVar != null) {
            aVar.mo45279a();
        }
    }

    /* renamed from: f */
    private void m45273f() {
        if (this.f34157e) {
            AbstractC7185ho.m43820b("PPSNativeViewMonitor", "viewShowEndRecord");
            this.f34157e = false;
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f34158f;
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("PPSNativeViewMonitor", "max visible area percentage: %d duration: %d", Integer.valueOf(this.f34159g), Long.valueOf(jCurrentTimeMillis));
            }
            a aVar = this.f34154a;
            if (aVar != null) {
                aVar.mo45280a(jCurrentTimeMillis, this.f34159g);
            }
            this.f34159g = 0;
        }
    }

    @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
    /* renamed from: a */
    public void mo45252a() {
        a aVar = this.f34154a;
        if (aVar != null) {
            aVar.mo45281b();
        }
    }

    /* renamed from: b */
    public void m45275b() {
        this.f34156c = 50;
        this.f34155b = 500L;
    }

    /* renamed from: c */
    public int m45277c() {
        return this.f34159g;
    }

    /* renamed from: d */
    public long m45278d() {
        return this.f34158f;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
    /* renamed from: a */
    public void mo45253a(int i10) {
        if (i10 > this.f34159g) {
            this.f34159g = i10;
        }
        if (i10 >= this.f34156c) {
            m45272e();
        } else {
            m45273f();
        }
    }

    /* renamed from: b */
    public void m45276b(long j10, int i10) {
        this.f34156c = i10;
        this.f34155b = j10;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
    /* renamed from: a */
    public void mo45254a(long j10, int i10) {
        m45273f();
        a aVar = this.f34154a;
        if (aVar != null) {
            aVar.mo45282b(j10, i10);
        }
    }

    /* renamed from: a */
    public boolean m45274a(long j10) {
        return j10 >= this.f34155b && this.f34159g >= this.f34156c;
    }
}

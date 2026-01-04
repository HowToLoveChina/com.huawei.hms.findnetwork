package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.views.PPSInterstitialVideoView;

/* renamed from: com.huawei.openalliance.ad.nd */
/* loaded from: classes8.dex */
public class C7496nd extends C7336jj<PPSInterstitialVideoView> {

    /* renamed from: d */
    private PPSInterstitialVideoView f34771d;

    /* renamed from: e */
    private Context f34772e;

    /* renamed from: f */
    private InterfaceC7002cs f34773f;

    /* renamed from: com.huawei.openalliance.ad.nd$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ long f34774a;

        /* renamed from: b */
        final /* synthetic */ long f34775b;

        /* renamed from: c */
        final /* synthetic */ long f34776c;

        public AnonymousClass1(long j10, long j11, long j12) {
            j = j10;
            j = j11;
            j = j12;
        }

        @Override // java.lang.Runnable
        public void run() {
            long j10 = j;
            long j11 = j10 - j;
            long j12 = j;
            C7496nd.this.f34773f.mo39074a(C7496nd.this.f34189a, j11, (j12 == 0 || j12 >= j10) ? 0L : j10 - j12);
        }
    }

    public C7496nd(Context context, PPSInterstitialVideoView pPSInterstitialVideoView) {
        mo45316a(pPSInterstitialVideoView);
        this.f34772e = context;
        this.f34190b = new C7560ou(context, new C7663sl(context));
        this.f34773f = new C6922c(this.f34772e);
    }

    /* renamed from: c */
    public void m45941c() {
        this.f34190b.mo46623f();
    }

    @Override // com.huawei.openalliance.p169ad.C7336jj
    /* renamed from: a */
    public PPSInterstitialVideoView mo45320d() {
        return this.f34771d;
    }

    /* renamed from: b */
    public void m45939b() {
        this.f34190b.mo46616c();
    }

    /* renamed from: a */
    public void m45935a(long j10, long j11, long j12) {
        if (j10 == 0 || j10 >= j12 || this.f34773f == null) {
            return;
        }
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.nd.1

            /* renamed from: a */
            final /* synthetic */ long f34774a;

            /* renamed from: b */
            final /* synthetic */ long f34775b;

            /* renamed from: c */
            final /* synthetic */ long f34776c;

            public AnonymousClass1(long j122, long j102, long j112) {
                j = j122;
                j = j102;
                j = j112;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j102 = j;
                long j112 = j102 - j;
                long j122 = j;
                C7496nd.this.f34773f.mo39074a(C7496nd.this.f34189a, j112, (j122 == 0 || j122 >= j102) ? 0L : j102 - j122);
            }
        });
    }

    /* renamed from: b */
    public void m45940b(long j10, long j11, long j12, long j13) {
        this.f34190b.mo46608b(j10, j11, (int) j12, (int) j13);
    }

    /* renamed from: a */
    public void m45936a(long j10, long j11, long j12, long j13) {
        this.f34190b.mo46617c(j10, j11, (int) j12, (int) j13);
    }

    /* renamed from: a */
    public void m45937a(ContentRecord contentRecord) {
        this.f34189a = contentRecord;
        Context context = this.f34772e;
        this.f34190b = new C7560ou(context, new C7663sl(context), this.f34189a);
    }

    @Override // com.huawei.openalliance.p169ad.C7336jj
    /* renamed from: a */
    public final void mo45316a(PPSInterstitialVideoView pPSInterstitialVideoView) {
        this.f34771d = pPSInterstitialVideoView;
    }
}

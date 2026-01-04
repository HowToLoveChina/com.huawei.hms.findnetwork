package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.InterfaceC7337jk;
import com.huawei.openalliance.p169ad.analysis.C6920a;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;

/* renamed from: com.huawei.openalliance.ad.na */
/* loaded from: classes8.dex */
public abstract class AbstractC7493na<V extends InterfaceC7337jk> extends C7336jj<V> implements InterfaceC7541oi<V> {

    /* renamed from: d */
    protected Context f34758d;

    /* renamed from: e */
    protected InterfaceC7002cs f34759e;

    /* renamed from: f */
    protected Integer f34760f;

    /* renamed from: g */
    protected String f34761g;

    public AbstractC7493na(Context context) {
        this.f34758d = context;
        this.f34759e = new C6922c(context);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7541oi
    /* renamed from: b */
    public void mo45916b(long j10, long j11, long j12, long j13) {
        this.f34190b.mo46617c(j10, j11, (int) j12, (int) j13);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7541oi
    /* renamed from: c */
    public void mo45917c(long j10, long j11, long j12, long j13) {
        this.f34190b.mo46608b(j10, j11, (int) j12, (int) j13);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7541oi
    /* renamed from: h */
    public void mo45918h() {
        this.f34190b.mo46616c();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7541oi
    /* renamed from: i */
    public void mo45919i() {
        this.f34190b.mo46623f();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7541oi
    /* renamed from: a */
    public void mo45915a(final long j10, final long j11, final long j12) {
        if (j10 == 0 || j10 >= j12 || this.f34759e == null) {
            return;
        }
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.na.1
            @Override // java.lang.Runnable
            public void run() {
                long j13 = j12;
                long j14 = j13 - j10;
                long j15 = j11;
                long j16 = (j15 == 0 || j15 >= j13) ? 0L : j13 - j15;
                C6920a c6920a = new C6920a();
                c6920a.m38867a(AbstractC7493na.this.f34760f);
                c6920a.m38874d(AbstractC7493na.this.f34761g);
                AbstractC7493na abstractC7493na = AbstractC7493na.this;
                abstractC7493na.f34759e.mo39076a(abstractC7493na.f34189a, j14, j16, c6920a);
            }
        });
    }
}

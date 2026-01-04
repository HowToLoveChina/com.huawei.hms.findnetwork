package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.linked.view.C7397b;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.openalliance.ad.ij */
/* loaded from: classes8.dex */
public class C7216ij implements InterfaceC7316iq {

    /* renamed from: a */
    WeakReference<C7397b> f33204a;

    /* renamed from: com.huawei.openalliance.ad.ij$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C7397b f33205a;

        /* renamed from: b */
        final /* synthetic */ int f33206b;

        public AnonymousClass1(C7397b c7397b, int i10) {
            c7397b = c7397b;
            i = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c7397b.m45559a(i);
            c7397b.mo43796g();
        }
    }

    public C7216ij(C7397b c7397b) {
        this.f33204a = new WeakReference<>(c7397b);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7316iq
    /* renamed from: a */
    public void mo30558a(int i10) {
        AbstractC7185ho.m43821b("LinkedVideoStreamListener", "stream error, code: %s", Integer.valueOf(i10));
        C7397b c7397b = this.f33204a.get();
        if (c7397b != null) {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.ij.1

                /* renamed from: a */
                final /* synthetic */ C7397b f33205a;

                /* renamed from: b */
                final /* synthetic */ int f33206b;

                public AnonymousClass1(C7397b c7397b2, int i102) {
                    c7397b = c7397b2;
                    i = i102;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c7397b.m45559a(i);
                    c7397b.mo43796g();
                }
            });
        }
    }
}

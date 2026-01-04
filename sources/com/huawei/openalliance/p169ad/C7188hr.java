package com.huawei.openalliance.p169ad;

import android.util.Log;
import com.huawei.openalliance.p169ad.utils.ThreadFactoryC7835n;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.openalliance.ad.hr */
/* loaded from: classes8.dex */
public class C7188hr extends AbstractC7183hm {

    /* renamed from: b */
    private final InterfaceC7199ht f33094b;

    /* renamed from: c */
    private final Executor f33095c = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC7835n("PPS-FileLog"));

    public C7188hr(InterfaceC7199ht interfaceC7199ht) {
        this.f33094b = interfaceC7199ht;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7199ht
    /* renamed from: a */
    public InterfaceC7199ht mo43809a(final String str, final String str2) {
        this.f33095c.execute(new Runnable() { // from class: com.huawei.openalliance.ad.hr.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C7188hr.this.f33094b.mo43809a(str, str2);
                } catch (Throwable th2) {
                    Log.w("HiAdLog", "init err: " + th2.getClass().getSimpleName());
                }
            }
        });
        InterfaceC7199ht interfaceC7199ht = this.f33086a;
        if (interfaceC7199ht != null) {
            interfaceC7199ht.mo43809a(str, str2);
        }
        return this;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7199ht
    /* renamed from: a */
    public void mo43810a(final C7201hv c7201hv, final int i10, final String str) {
        this.f33095c.execute(new Runnable() { // from class: com.huawei.openalliance.ad.hr.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C7188hr.this.f33094b.mo43810a(c7201hv, i10, str);
                } catch (Throwable th2) {
                    Log.w("HiAdLog", "log err: " + th2.getClass().getSimpleName());
                }
            }
        });
        InterfaceC7199ht interfaceC7199ht = this.f33086a;
        if (interfaceC7199ht != null) {
            interfaceC7199ht.mo43810a(c7201hv, i10, str);
        }
    }
}

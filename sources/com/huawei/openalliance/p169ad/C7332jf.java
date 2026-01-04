package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;

/* renamed from: com.huawei.openalliance.ad.jf */
/* loaded from: classes8.dex */
public class C7332jf {

    /* renamed from: a */
    private final String f34160a = "PRELOAD_" + hashCode();

    /* renamed from: b */
    private int f34161b = 0;

    /* renamed from: c */
    private a f34162c;

    /* renamed from: com.huawei.openalliance.ad.jf$a */
    public interface a {
        /* renamed from: a */
        void mo45287a();
    }

    public C7332jf(a aVar) {
        this.f34162c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m45284c() {
        AbstractC7185ho.m43817a("PreloadWebViewMonitor", "unbindService");
        this.f34162c.mo45287a();
    }

    /* renamed from: a */
    public synchronized void m45285a() {
        this.f34161b++;
        AbstractC7817dj.m48366a(this.f34160a);
        AbstractC7185ho.m43817a("PreloadWebViewMonitor", "inc count: " + this.f34161b);
    }

    /* renamed from: b */
    public synchronized void m45286b() {
        try {
            int i10 = this.f34161b - 1;
            this.f34161b = i10;
            if (i10 < 0) {
                this.f34161b = 0;
            }
            AbstractC7185ho.m43817a("PreloadWebViewMonitor", "dec count: " + this.f34161b);
            if (this.f34161b <= 0) {
                AbstractC7817dj.m48365a(new Runnable() { // from class: com.huawei.openalliance.ad.jf.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C7332jf.this.m45284c();
                    }
                }, this.f34160a, 60000L);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}

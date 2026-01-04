package p731w7;

import com.huawei.android.hicloud.album.service.hihttp.rest.OnResponseListener;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import p031b7.C1120a;

/* renamed from: w7.i */
/* loaded from: classes2.dex */
public class C13542i {

    /* renamed from: a */
    public final BlockingQueue<AbstractC13540g<?>> f60927a = new LinkedBlockingDeque();

    /* renamed from: b */
    public final BlockingQueue<AbstractC13540g<?>> f60928b = new PriorityBlockingQueue();

    /* renamed from: c */
    public AtomicInteger f60929c = new AtomicInteger();

    /* renamed from: d */
    public C13541h[] f60930d;

    public C13542i(int i10) {
        this.f60930d = new C13541h[i10];
    }

    /* renamed from: a */
    public <T> void m81466a(int i10, AbstractC13540g<T> abstractC13540g, OnResponseListener<T> onResponseListener) {
        if (abstractC13540g.mo15141a()) {
            return;
        }
        abstractC13540g.mo81462E(i10, onResponseListener);
        abstractC13540g.mo15142b(this.f60927a);
        abstractC13540g.m81434q(this.f60929c.incrementAndGet());
        this.f60927a.add(abstractC13540g);
        this.f60928b.add(abstractC13540g);
    }

    /* renamed from: b */
    public void m81467b() {
        try {
            Iterator<AbstractC13540g<?>> it = this.f60927a.iterator();
            while (it.hasNext()) {
                it.next().mo81428e();
            }
        } catch (Exception e10) {
            C1120a.m6676e("RequestQueue", "cancelAll error: " + e10.toString());
        }
    }

    /* renamed from: c */
    public void m81468c() {
        m81469d();
        for (int i10 = 0; i10 < this.f60930d.length; i10++) {
            C13541h c13541h = new C13541h(this.f60927a, this.f60928b);
            this.f60930d[i10] = c13541h;
            c13541h.start();
        }
    }

    /* renamed from: d */
    public void m81469d() {
        for (C13541h c13541h : this.f60930d) {
            if (c13541h != null) {
                c13541h.m81465a();
            }
        }
    }
}

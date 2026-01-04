package pm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import p616rk.AbstractRunnableC12516b;

/* renamed from: pm.d */
/* loaded from: classes6.dex */
public class C12177d {

    /* renamed from: d */
    public static C12177d f56507d = new C12177d();

    /* renamed from: e */
    public static final Object f56508e = new Object();

    /* renamed from: f */
    public static final Object f56509f = new Object();

    /* renamed from: a */
    public ExecutorService f56510a = null;

    /* renamed from: b */
    public ConcurrentHashMap<String, List<AbstractRunnableC12516b>> f56511b = new ConcurrentHashMap<>();

    /* renamed from: c */
    public int f56512c = 2;

    /* renamed from: b */
    public static C12177d m73274b() {
        return f56507d;
    }

    /* renamed from: a */
    public void m73275a(String str, AbstractRunnableC12516b abstractRunnableC12516b) {
        m73276c();
        synchronized (f56509f) {
            try {
                abstractRunnableC12516b.setFuture(this.f56510a.submit(abstractRunnableC12516b));
                List<AbstractRunnableC12516b> arrayList = this.f56511b.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(abstractRunnableC12516b);
                this.f56511b.put(str, arrayList);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: c */
    public final void m73276c() {
        synchronized (f56508e) {
            try {
                ExecutorService executorService = this.f56510a;
                if (executorService == null || executorService.isShutdown()) {
                    this.f56510a = Executors.newFixedThreadPool(this.f56512c);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: d */
    public void m73277d() {
        ArrayList arrayList = new ArrayList();
        synchronized (f56509f) {
            try {
                Iterator<Map.Entry<String, List<AbstractRunnableC12516b>>> it = this.f56511b.entrySet().iterator();
                while (it.hasNext()) {
                    arrayList.addAll(it.next().getValue());
                }
                this.f56511b.clear();
            } finally {
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Future<?> future = ((AbstractRunnableC12516b) it2.next()).getFuture();
            if (future != null) {
                future.cancel(true);
            }
        }
        synchronized (f56508e) {
            try {
                ExecutorService executorService = this.f56510a;
                if (executorService != null && !executorService.isShutdown()) {
                    this.f56510a.shutdownNow();
                }
            } finally {
            }
        }
    }
}

package p767x9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import p652t9.EnumC12999a;

/* renamed from: x9.b */
/* loaded from: classes3.dex */
public class C13733b {

    /* renamed from: a */
    public static C13733b f61729a = new C13733b();

    /* renamed from: b */
    public static final Object f61730b = new Object();

    /* renamed from: c */
    public static final Object f61731c = new Object();

    /* renamed from: d */
    public static final Object f61732d = new Object();

    /* renamed from: e */
    public static final Map<EnumC12999a, ExecutorService> f61733e = new HashMap();

    /* renamed from: f */
    public static final Map<EnumC12999a, Semaphore> f61734f = new HashMap();

    /* renamed from: g */
    public static List<AbstractRunnableC13732a> f61735g = new ArrayList();

    /* renamed from: a */
    public static C13733b m82520a() {
        return f61729a;
    }

    /* renamed from: b */
    public void m82521b(AbstractRunnableC13732a abstractRunnableC13732a) {
        synchronized (f61731c) {
            f61735g.remove(abstractRunnableC13732a);
        }
    }

    /* renamed from: c */
    public void m82522c(EnumC12999a enumC12999a, AbstractRunnableC13732a abstractRunnableC13732a) {
        ExecutorService executorServiceNewFixedThreadPool;
        synchronized (f61730b) {
            try {
                Map<EnumC12999a, ExecutorService> map = f61733e;
                if (map.containsKey(enumC12999a)) {
                    executorServiceNewFixedThreadPool = map.get(enumC12999a);
                    if (executorServiceNewFixedThreadPool.isShutdown()) {
                        executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(enumC12999a.m78145f());
                        map.put(enumC12999a, executorServiceNewFixedThreadPool);
                    }
                } else {
                    executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(enumC12999a.m78145f());
                    map.put(enumC12999a, executorServiceNewFixedThreadPool);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        synchronized (f61731c) {
            f61735g.add(abstractRunnableC13732a);
            abstractRunnableC13732a.m82519e(executorServiceNewFixedThreadPool.submit(abstractRunnableC13732a));
        }
    }

    /* renamed from: d */
    public void m82523d(EnumC12999a enumC12999a, AbstractC13734c abstractC13734c) throws InterruptedException {
        Semaphore semaphore;
        synchronized (f61732d) {
            try {
                Map<EnumC12999a, Semaphore> map = f61734f;
                if (map.containsKey(enumC12999a)) {
                    semaphore = map.get(enumC12999a);
                } else {
                    Semaphore semaphore2 = new Semaphore(enumC12999a.m78145f() + 1, true);
                    map.put(enumC12999a, semaphore2);
                    semaphore = semaphore2;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (semaphore != null) {
            semaphore.acquire();
        }
        abstractC13734c.m82524g(semaphore);
        m82522c(enumC12999a, abstractC13734c);
    }
}

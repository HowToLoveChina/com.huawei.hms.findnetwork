package p026b2;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import p630s2.C12676k;

/* renamed from: b2.a */
/* loaded from: classes.dex */
public final class C1099a {

    /* renamed from: a */
    public final Map<String, a> f5224a = new HashMap();

    /* renamed from: b */
    public final b f5225b = new b();

    /* renamed from: b2.a$a */
    public static class a {

        /* renamed from: a */
        public final Lock f5226a = new ReentrantLock();

        /* renamed from: b */
        public int f5227b;
    }

    /* renamed from: b2.a$b */
    public static class b {

        /* renamed from: a */
        public final Queue<a> f5228a = new ArrayDeque();

        /* renamed from: a */
        public a m6538a() {
            a aVarPoll;
            synchronized (this.f5228a) {
                aVarPoll = this.f5228a.poll();
            }
            return aVarPoll == null ? new a() : aVarPoll;
        }

        /* renamed from: b */
        public void m6539b(a aVar) {
            synchronized (this.f5228a) {
                try {
                    if (this.f5228a.size() < 10) {
                        this.f5228a.offer(aVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* renamed from: a */
    public void m6536a(String str) {
        a aVarM6538a;
        synchronized (this) {
            try {
                aVarM6538a = this.f5224a.get(str);
                if (aVarM6538a == null) {
                    aVarM6538a = this.f5225b.m6538a();
                    this.f5224a.put(str, aVarM6538a);
                }
                aVarM6538a.f5227b++;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        aVarM6538a.f5226a.lock();
    }

    /* renamed from: b */
    public void m6537b(String str) {
        a aVar;
        synchronized (this) {
            try {
                aVar = (a) C12676k.m76276d(this.f5224a.get(str));
                int i10 = aVar.f5227b;
                if (i10 < 1) {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f5227b);
                }
                int i11 = i10 - 1;
                aVar.f5227b = i11;
                if (i11 == 0) {
                    a aVarRemove = this.f5224a.remove(str);
                    if (!aVarRemove.equals(aVar)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + aVarRemove + ", safeKey: " + str);
                    }
                    this.f5225b.m6539b(aVarRemove);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        aVar.f5226a.unlock();
    }
}

package p572qb;

import java.util.ArrayList;
import java.util.Iterator;
import p514o9.C11839m;

/* renamed from: qb.v */
/* loaded from: classes3.dex */
public class C12330v {

    /* renamed from: a */
    public final Object f57081a = new Object();

    /* renamed from: b */
    public ArrayList<a> f57082b = new ArrayList<>();

    /* renamed from: qb.v$a */
    public static class a {

        /* renamed from: a */
        public String f57083a;

        /* renamed from: b */
        public boolean f57084b = false;

        /* renamed from: c */
        public boolean f57085c = false;

        public a(String str) {
            this.f57083a = str;
        }

        /* renamed from: a */
        public String m74151a() {
            return this.f57083a;
        }

        /* renamed from: b */
        public boolean m74152b() {
            return this.f57084b;
        }

        /* renamed from: c */
        public boolean m74153c() {
            return this.f57085c;
        }

        /* renamed from: d */
        public void m74154d(boolean z10) {
            this.f57084b = z10;
        }

        /* renamed from: e */
        public void m74155e(boolean z10) {
            this.f57085c = z10;
        }
    }

    /* renamed from: a */
    public void m74145a(a aVar) {
        synchronized (this.f57081a) {
            this.f57082b.add(aVar);
        }
    }

    /* renamed from: b */
    public boolean m74146b() {
        synchronized (this.f57081a) {
            try {
                Iterator<a> it = this.f57082b.iterator();
                while (it.hasNext()) {
                    if (!it.next().m74152b()) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: c */
    public void m74147c() {
        synchronized (this.f57081a) {
            try {
                Iterator<a> it = this.f57082b.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    next.m74154d(false);
                    next.m74155e(false);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: d */
    public final a m74148d(String str) {
        Iterator<a> it = this.f57082b.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.m74151a().equals(str)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: e */
    public boolean m74149e() {
        synchronized (this.f57081a) {
            try {
                Iterator<a> it = this.f57082b.iterator();
                while (it.hasNext()) {
                    if (!it.next().m74153c()) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: f */
    public void m74150f(String str, boolean z10) {
        synchronized (this.f57081a) {
            try {
                a aVarM74148d = m74148d(str);
                if (aVarM74148d == null) {
                    C11839m.m70687e("MultiTaskChecker", "updateFinishedItem item null");
                } else {
                    aVarM74148d.m74154d(true);
                    aVarM74148d.m74155e(z10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}

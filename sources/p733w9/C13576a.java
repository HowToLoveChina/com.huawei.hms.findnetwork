package p733w9;

import java.util.ArrayList;
import java.util.List;
import p514o9.C11839m;

/* renamed from: w9.a */
/* loaded from: classes3.dex */
public final class C13576a {

    /* renamed from: a */
    public static C13576a f61073a = new C13576a();

    /* renamed from: b */
    public static final List<String> f61074b = new ArrayList();

    /* renamed from: c */
    public static final List<String> f61075c = new ArrayList();

    /* renamed from: a */
    public static C13576a m81565a() {
        return f61073a;
    }

    /* renamed from: b */
    public boolean m81566b(String str) {
        List<String> list = f61074b;
        synchronized (list) {
            try {
                if (list.contains(str)) {
                    return false;
                }
                list.add(str);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: c */
    public void m81567c(String str) {
        while (true) {
            List<String> list = f61075c;
            synchronized (list) {
                if (!list.contains(str)) {
                    list.add(str);
                    return;
                }
                try {
                    list.wait(400L);
                } catch (InterruptedException e10) {
                    C11839m.m70689w("Lock", "lockCheck err: " + e10.toString());
                }
            }
        }
    }

    /* renamed from: d */
    public void m81568d(String str) {
        List<String> list = f61074b;
        synchronized (list) {
            list.remove(str);
            list.notifyAll();
        }
    }

    /* renamed from: e */
    public void m81569e(String str) {
        List<String> list = f61075c;
        synchronized (list) {
            list.remove(str);
            list.notifyAll();
        }
    }

    /* renamed from: f */
    public void m81570f(String str) {
        while (true) {
            List<String> list = f61074b;
            synchronized (list) {
                if (!list.contains(str)) {
                    return;
                }
                try {
                    list.wait(400L);
                } catch (InterruptedException e10) {
                    C11839m.m70686d("Lock", "lock interrupted " + e10);
                }
            }
        }
    }
}

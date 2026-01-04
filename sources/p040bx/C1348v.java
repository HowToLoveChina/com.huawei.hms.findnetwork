package p040bx;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import mw.InterfaceC11539f;
import p408jw.C10936b;
import p408jw.C10945k;
import p408jw.C10946l;
import p408jw.C10951q;
import zw.C14397f;
import zw.C14399h;

/* renamed from: bx.v */
/* loaded from: classes9.dex */
public final class C1348v {

    /* renamed from: a */
    public static final List<InterfaceC1346u> f5848a = C14399h.m85628e(C14397f.m85624a(ServiceLoader.load(InterfaceC1346u.class, InterfaceC1346u.class.getClassLoader()).iterator()));

    /* renamed from: a */
    public static final void m7840a(InterfaceC11539f interfaceC11539f, Throwable th2) {
        Iterator<InterfaceC1346u> it = f5848a.iterator();
        while (it.hasNext()) {
            try {
                it.next().handleException(interfaceC11539f, th2);
            } catch (Throwable th3) {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, C1350w.m7842b(th2, th3));
            }
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        try {
            C10945k.a aVar = C10945k.f51855a;
            C10936b.m66063a(th2, new C1300c0(interfaceC11539f));
            C10945k.m66070b(C10951q.f51861a);
        } catch (Throwable th4) {
            C10945k.a aVar2 = C10945k.f51855a;
            C10945k.m66070b(C10946l.m66073a(th4));
        }
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th2);
    }
}

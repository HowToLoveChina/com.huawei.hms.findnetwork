package im;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: im.f */
/* loaded from: classes6.dex */
public final /* synthetic */ class C10556f {
    /* renamed from: a */
    public static /* synthetic */ boolean m64761a(AtomicReference atomicReference, Object obj, Object obj2) {
        while (!atomicReference.compareAndSet(obj, obj2)) {
            if (atomicReference.get() != obj) {
                return false;
            }
        }
        return true;
    }
}

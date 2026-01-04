package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* renamed from: kotlinx.coroutines.scheduling.n */
/* loaded from: classes9.dex */
public final /* synthetic */ class C11123n {
    /* renamed from: a */
    public static /* synthetic */ boolean m66881a(AtomicReferenceArray atomicReferenceArray, int i10, Object obj, Object obj2) {
        while (!atomicReferenceArray.compareAndSet(i10, obj, obj2)) {
            if (atomicReferenceArray.get(i10) != obj) {
                return false;
            }
        }
        return true;
    }
}

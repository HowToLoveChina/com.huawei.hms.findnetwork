package p618rm;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

/* renamed from: rm.x */
/* loaded from: classes6.dex */
public class C12604x {

    /* renamed from: a */
    public static final ConcurrentHashMap<String, Long> f58004a = new ConcurrentHashMap<>();

    /* renamed from: b */
    public static void m76063b(String str, final long j10) {
        f58004a.compute(str, new BiFunction() { // from class: rm.w
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return C12604x.m76066e(j10, (String) obj, (Long) obj2);
            }
        });
    }

    /* renamed from: c */
    public static void m76064c() {
        f58004a.clear();
    }

    /* renamed from: d */
    public static long m76065d(String str) {
        Long orDefault = f58004a.getOrDefault(str, 0L);
        if (orDefault != null) {
            return orDefault.longValue();
        }
        return 0L;
    }

    /* renamed from: e */
    public static /* synthetic */ Long m76066e(long j10, String str, Long l10) {
        return Long.valueOf((l10 != null ? l10.longValue() : 0L) + j10);
    }
}

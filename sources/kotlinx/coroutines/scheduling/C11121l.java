package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.C11105v;
import kotlinx.coroutines.internal.C11107x;
import p790xw.C13885n;

/* renamed from: kotlinx.coroutines.scheduling.l */
/* loaded from: classes9.dex */
public final class C11121l {

    /* renamed from: a */
    public static final long f52382a = C11107x.m66816e("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);

    /* renamed from: b */
    public static final int f52383b = C11107x.m66815d("kotlinx.coroutines.scheduler.core.pool.size", C13885n.m83236a(C11105v.m66803a(), 2), 1, 0, 8, null);

    /* renamed from: c */
    public static final int f52384c = C11107x.m66815d("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);

    /* renamed from: d */
    public static final long f52385d = TimeUnit.SECONDS.toNanos(C11107x.m66816e("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, null));

    /* renamed from: e */
    public static AbstractC11116g f52386e = C11114e.f52372a;

    /* renamed from: f */
    public static final InterfaceC11118i f52387f = new C11119j(0);

    /* renamed from: g */
    public static final InterfaceC11118i f52388g = new C11119j(1);
}

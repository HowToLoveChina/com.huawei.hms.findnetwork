package p630s2;

import android.annotation.TargetApi;
import android.os.SystemClock;

/* renamed from: s2.g */
/* loaded from: classes.dex */
public final class C12672g {

    /* renamed from: a */
    public static final double f58177a = 1.0d / Math.pow(10.0d, 6.0d);

    /* renamed from: a */
    public static double m76262a(long j10) {
        return (m76263b() - j10) * f58177a;
    }

    @TargetApi(17)
    /* renamed from: b */
    public static long m76263b() {
        return SystemClock.elapsedRealtimeNanos();
    }
}

package p815ym;

import android.os.Handler;
import android.os.Looper;

/* renamed from: ym.b */
/* loaded from: classes6.dex */
public abstract class AbstractC14027b {

    /* renamed from: a */
    public static final Object f62794a = new Object();

    /* renamed from: b */
    public static volatile Handler f62795b;

    /* renamed from: a */
    public static Handler m84162a() {
        Handler handler;
        if (f62795b != null) {
            return f62795b;
        }
        synchronized (f62794a) {
            try {
                if (f62795b == null) {
                    f62795b = new Handler(Looper.getMainLooper());
                }
                handler = f62795b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return handler;
    }

    /* renamed from: b */
    public static void m84163b(Runnable runnable) {
        m84162a().post(runnable);
    }
}

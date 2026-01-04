package lu;

import android.os.Handler;
import android.os.Looper;

/* renamed from: lu.h */
/* loaded from: classes5.dex */
public class C11349h {

    /* renamed from: a */
    public static Handler f53060a = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    public static void m68160a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        f53060a.post(runnable);
    }
}

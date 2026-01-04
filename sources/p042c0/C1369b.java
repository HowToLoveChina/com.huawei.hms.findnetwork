package p042c0;

import android.os.Handler;
import android.os.Looper;

/* renamed from: c0.b */
/* loaded from: classes.dex */
public class C1369b {
    /* renamed from: a */
    public static Handler m7869a() {
        return Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler();
    }
}

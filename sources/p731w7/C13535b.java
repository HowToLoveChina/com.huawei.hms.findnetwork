package p731w7;

import android.os.Handler;
import android.os.Looper;

/* renamed from: w7.b */
/* loaded from: classes2.dex */
public final class C13535b {

    /* renamed from: a */
    public Handler f60906a;

    /* renamed from: w7.b$b */
    public static class b {

        /* renamed from: a */
        public static C13535b f60907a = new C13535b(new Handler(Looper.getMainLooper()));
    }

    /* renamed from: a */
    public static C13535b m81436a() {
        return b.f60907a;
    }

    /* renamed from: b */
    public boolean m81437b(Runnable runnable) {
        return this.f60906a.post(runnable);
    }

    /* renamed from: c */
    public boolean m81438c(Runnable runnable, long j10) {
        return this.f60906a.postDelayed(runnable, j10);
    }

    public C13535b(Handler handler) {
        this.f60906a = handler;
    }
}

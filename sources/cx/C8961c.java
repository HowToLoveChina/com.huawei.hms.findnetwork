package cx;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.lang.reflect.InvocationTargetException;
import p408jw.C10945k;
import p408jw.C10946l;

/* renamed from: cx.c */
/* loaded from: classes9.dex */
public final class C8961c {

    /* renamed from: a */
    public static final AbstractC8960b f45467a;
    private static volatile Choreographer choreographer;

    static {
        Object objM66070b;
        try {
            C10945k.a aVar = C10945k.f51855a;
            objM66070b = C10945k.m66070b(new C8959a(m56714a(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th2) {
            C10945k.a aVar2 = C10945k.f51855a;
            objM66070b = C10945k.m66070b(C10946l.m66073a(th2));
        }
        f45467a = (AbstractC8960b) (C10945k.m66072d(objM66070b) ? null : objM66070b);
    }

    /* renamed from: a */
    public static final Handler m56714a(Looper looper, boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!z10) {
            return new Handler(looper);
        }
        Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        if (objInvoke != null) {
            return (Handler) objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
    }
}

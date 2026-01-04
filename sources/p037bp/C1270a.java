package p037bp;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* renamed from: bp.a */
/* loaded from: classes.dex */
public class C1270a {

    /* renamed from: a */
    public Map<Class, Object> f5704a;

    /* renamed from: bp.a$b */
    public static class b {

        /* renamed from: a */
        public static C1270a f5705a = new C1270a();
    }

    /* renamed from: b */
    public static C1270a m7534b() {
        return b.f5705a;
    }

    /* renamed from: a */
    public synchronized <T> T m7535a(Class<T> cls) {
        return (T) this.f5704a.get(cls);
    }

    /* renamed from: c */
    public synchronized <T> void m7536c(Class<T> cls, T t10) {
        try {
            this.f5704a.put(cls, t10);
        } catch (Exception e10) {
            Log.w("CoreRouter", "core router exception: " + e10.toString());
        }
    }

    public C1270a() {
        this.f5704a = new HashMap();
    }
}

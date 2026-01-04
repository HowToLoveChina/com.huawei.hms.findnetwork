package p292fn;

import cn.C1461a;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: fn.d */
/* loaded from: classes6.dex */
public class C9731d {

    /* renamed from: a */
    public static final ConcurrentHashMap<String, Object> f47970a = new ConcurrentHashMap<>();

    /* renamed from: b */
    public static final C9731d f47971b = new C9731d();

    /* renamed from: d */
    public static C9731d m60699d() {
        return f47971b;
    }

    /* renamed from: f */
    public static /* synthetic */ Object m60700f(String str) throws Exception {
        return Boolean.valueOf(C9733f.m60705z().m60720O(str));
    }

    /* renamed from: b */
    public void m60701b() {
        f47970a.clear();
    }

    /* renamed from: c */
    public Object m60702c(String str, Callable<Object> callable, Object obj) throws Exception {
        ConcurrentHashMap<String, Object> concurrentHashMap = f47970a;
        Object obj2 = concurrentHashMap.get(str);
        if (obj2 != null) {
            return obj2;
        }
        try {
            Object objCall = callable.call();
            if (objCall != null) {
                concurrentHashMap.put(str, objCall);
                C1461a.m8357d("ConfigCacheContainer", "getConfig callable value =" + objCall);
                return objCall;
            }
        } catch (Exception e10) {
            C1461a.m8358e("ConfigCacheContainer", "getConfig error:" + e10.getMessage());
        }
        C1461a.m8357d("ConfigCacheContainer", "getConfig defaultValue =" + obj);
        return obj;
    }

    /* renamed from: e */
    public boolean m60703e(final String str) {
        Boolean bool = (Boolean) m60699d().m60702c(str, new Callable() { // from class: fn.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return C9731d.m60700f(str);
            }
        }, null);
        return bool != null && bool.booleanValue();
    }
}

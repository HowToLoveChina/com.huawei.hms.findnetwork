package com.huawei.openalliance.p169ad;

import android.content.Context;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.ks */
/* loaded from: classes8.dex */
public interface InterfaceC7372ks<P> {

    /* renamed from: com.huawei.openalliance.ad.ks$a */
    public static class a {

        /* renamed from: a */
        private static final Map<Type, InterfaceC7372ks> f34293a = new HashMap();

        /* renamed from: b */
        private static C7373kt f34294b;

        /* renamed from: c */
        private static C7370kq f34295c;

        /* renamed from: d */
        private static C7371kr f34296d;

        /* renamed from: a */
        public static InterfaceC7372ks m45457a(Context context, Class cls) {
            m45458a(context);
            InterfaceC7372ks interfaceC7372ks = f34293a.get(cls);
            return interfaceC7372ks == null ? f34296d : interfaceC7372ks;
        }

        /* renamed from: a */
        private static synchronized void m45458a(Context context) {
            try {
                if (f34294b == null) {
                    C7373kt c7373kt = new C7373kt(context);
                    f34294b = c7373kt;
                    f34293a.put(String.class, c7373kt);
                }
                if (f34295c == null) {
                    C7370kq c7370kq = new C7370kq(context);
                    f34295c = c7370kq;
                    Map<Type, InterfaceC7372ks> map = f34293a;
                    map.put(Integer.TYPE, c7370kq);
                    map.put(Integer.class, f34295c);
                    map.put(Float.TYPE, f34295c);
                    map.put(Float.class, f34295c);
                    map.put(Long.TYPE, f34295c);
                    map.put(Long.class, f34295c);
                    map.put(Double.TYPE, f34295c);
                    map.put(Double.class, f34295c);
                    map.put(Short.TYPE, f34295c);
                    map.put(Short.class, f34295c);
                    map.put(Byte.TYPE, f34295c);
                    map.put(Byte.class, f34295c);
                    map.put(Character.TYPE, f34295c);
                    map.put(Character.class, f34295c);
                    map.put(Boolean.TYPE, f34295c);
                    map.put(Boolean.class, f34295c);
                }
                if (f34296d == null) {
                    f34296d = new C7371kr(context);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    String mo45456a();

    /* renamed from: a */
    String mo45455a(P p10, InterfaceC7368ko interfaceC7368ko);
}

package com.huawei.openalliance.p169ad;

import java.io.InputStream;

/* renamed from: com.huawei.openalliance.ad.lb */
/* loaded from: classes8.dex */
public interface InterfaceC7382lb<R> {

    /* renamed from: com.huawei.openalliance.ad.lb$a */
    public static class a {

        /* renamed from: a */
        private static final C7383lc f34299a = new C7383lc();

        /* renamed from: a */
        public static <RD> InterfaceC7382lb<RD> m45466a(Class<RD> cls) {
            if (cls == Integer.TYPE || cls == Integer.class) {
                return new C7378ky();
            }
            if (cls == Float.TYPE || cls == Float.class) {
                return new C7376kw();
            }
            if (cls == Double.TYPE || cls == Double.class) {
                return new C7375kv();
            }
            if (cls == Long.TYPE || cls == Long.class) {
                return new C7381la();
            }
            if (cls == String.class) {
                return f34299a;
            }
            if (!cls.isPrimitive()) {
                return new C7379kz(cls);
            }
            throw new IllegalArgumentException("Response type: " + cls + " not supported!");
        }
    }

    /* renamed from: a */
    long mo45459a();

    /* renamed from: a */
    R mo45460a(int i10, InputStream inputStream, long j10, InterfaceC7368ko interfaceC7368ko);
}

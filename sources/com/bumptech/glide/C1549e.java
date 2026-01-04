package com.bumptech.glide;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bumptech.glide.e */
/* loaded from: classes.dex */
public class C1549e {

    /* renamed from: a */
    public final Map<Class<?>, Object> f6864a;

    /* renamed from: com.bumptech.glide.e$a */
    public static final class a {

        /* renamed from: a */
        public final Map<Class<?>, Object> f6865a = new HashMap();

        /* renamed from: b */
        public C1549e m8930b() {
            return new C1549e(this);
        }
    }

    public C1549e(a aVar) {
        this.f6864a = Collections.unmodifiableMap(new HashMap(aVar.f6865a));
    }

    /* renamed from: a */
    public boolean m8928a(Class<Object> cls) {
        return this.f6864a.containsKey(cls);
    }
}

package com.huawei.cloud.base.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: com.huawei.cloud.base.util.b */
/* loaded from: classes.dex */
public final class C4628b {

    /* renamed from: a */
    public final Map<String, a> f21259a = C4626a.m28373d();

    /* renamed from: b */
    public final Map<Field, a> f21260b = C4626a.m28373d();

    /* renamed from: c */
    public final Object f21261c;

    /* renamed from: com.huawei.cloud.base.util.b$a */
    public static class a {

        /* renamed from: a */
        public final Class<?> f21262a;

        /* renamed from: b */
        public final ArrayList<Object> f21263b = new ArrayList<>();

        public a(Class<?> cls) {
            this.f21262a = cls;
        }

        /* renamed from: a */
        public void m28399a(Class<?> cls, Object obj) {
            C4627a0.m28388a(cls == this.f21262a);
            this.f21263b.add(obj);
        }

        /* renamed from: b */
        public Object m28400b() {
            return C4637f0.m28426o(this.f21263b, this.f21262a);
        }
    }

    public C4628b(Object obj) {
        this.f21261c = obj;
    }

    /* renamed from: a */
    public void m28397a(Field field, Class<?> cls, Object obj) {
        a aVar = this.f21260b.get(field);
        if (aVar == null) {
            aVar = new a(cls);
            this.f21260b.put(field, aVar);
        }
        aVar.m28399a(cls, obj);
    }

    /* renamed from: b */
    public void m28398b() {
        for (Map.Entry<String, a> entry : this.f21259a.entrySet()) {
            ((Map) this.f21261c).put(entry.getKey(), entry.getValue().m28400b());
        }
        for (Map.Entry<Field, a> entry2 : this.f21260b.entrySet()) {
            C4645m.m28463l(entry2.getKey(), this.f21261c, entry2.getValue().m28400b());
        }
    }
}

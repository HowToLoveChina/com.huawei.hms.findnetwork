package com.huawei.cloud.base.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;
import java.util.WeakHashMap;

/* renamed from: com.huawei.cloud.base.util.g */
/* loaded from: classes.dex */
public final class C4638g {

    /* renamed from: e */
    public static final Map<Class<?>, C4638g> f21278e = new WeakHashMap();

    /* renamed from: f */
    public static final Map<Class<?>, C4638g> f21279f = new WeakHashMap();

    /* renamed from: a */
    public final List<String> f21280a;

    /* renamed from: b */
    public final Class<?> f21281b;

    /* renamed from: c */
    public final boolean f21282c;

    /* renamed from: d */
    public final IdentityHashMap<String, C4645m> f21283d = new IdentityHashMap<>();

    /* renamed from: com.huawei.cloud.base.util.g$a */
    public class a implements Comparator<String> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            if (C4658z.m28496a(str, str2)) {
                return 0;
            }
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            return str.compareTo(str2);
        }
    }

    public C4638g(Class<?> cls, boolean z10) {
        this.f21281b = cls;
        this.f21282c = z10;
        C4627a0.m28389b((z10 && cls.isEnum()) ? false : true, "cannot ignore case on an enum: " + cls);
        TreeSet treeSet = new TreeSet(new a());
        for (Field field : cls.getDeclaredFields()) {
            C4645m c4645mM28462k = C4645m.m28462k(field);
            if (c4645mM28462k != null) {
                String strM28467e = c4645mM28462k.m28467e();
                strM28467e = z10 ? strM28467e.toLowerCase(Locale.US).intern() : strM28467e;
                C4645m c4645m = this.f21283d.get(strM28467e);
                boolean z11 = c4645m == null;
                Object[] objArr = new Object[4];
                objArr[0] = z10 ? "case-insensitive " : "";
                objArr[1] = strM28467e;
                objArr[2] = field;
                objArr[3] = c4645m == null ? null : c4645m.m28465b();
                C4627a0.m28390c(z11, "two fields have the same %sname <%s>: %s and %s", objArr);
                this.f21283d.put(strM28467e, c4645mM28462k);
                treeSet.add(strM28467e);
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            C4638g c4638gM28428g = m28428g(superclass, z10);
            treeSet.addAll(c4638gM28428g.f21280a);
            for (Map.Entry<String, C4645m> entry : c4638gM28428g.f21283d.entrySet()) {
                String key = entry.getKey();
                if (!this.f21283d.containsKey(key)) {
                    this.f21283d.put(key, entry.getValue());
                }
            }
        }
        this.f21280a = treeSet.isEmpty() ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(treeSet));
    }

    /* renamed from: f */
    public static C4638g m28427f(Class<?> cls) {
        return m28428g(cls, false);
    }

    /* renamed from: g */
    public static C4638g m28428g(Class<?> cls, boolean z10) {
        C4638g c4638g;
        if (cls == null) {
            return null;
        }
        Map<Class<?>, C4638g> map = z10 ? f21279f : f21278e;
        synchronized (map) {
            try {
                c4638g = map.get(cls);
                if (c4638g == null) {
                    c4638g = new C4638g(cls, z10);
                    map.put(cls, c4638g);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c4638g;
    }

    /* renamed from: a */
    public Field m28429a(String str) {
        C4645m c4645mM28430b = m28430b(str);
        if (c4645mM28430b == null) {
            return null;
        }
        return c4645mM28430b.m28465b();
    }

    /* renamed from: b */
    public C4645m m28430b(String str) {
        if (str != null) {
            if (this.f21282c) {
                str = str.toLowerCase(Locale.US);
            }
            str = str.intern();
        }
        return this.f21283d.get(str);
    }

    /* renamed from: c */
    public Collection<C4645m> m28431c() {
        return Collections.unmodifiableCollection(this.f21283d.values());
    }

    /* renamed from: d */
    public final boolean m28432d() {
        return this.f21282c;
    }

    /* renamed from: e */
    public boolean m28433e() {
        return this.f21281b.isEnum();
    }
}

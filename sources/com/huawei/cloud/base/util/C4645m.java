package com.huawei.cloud.base.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.WeakHashMap;
import ki.C11055a;

/* renamed from: com.huawei.cloud.base.util.m */
/* loaded from: classes.dex */
public class C4645m {

    /* renamed from: d */
    public static final Map<Field, C4645m> f21320d = new WeakHashMap();

    /* renamed from: a */
    public final boolean f21321a;

    /* renamed from: b */
    public final Field f21322b;

    /* renamed from: c */
    public final String f21323c;

    public C4645m(Field field, String str) {
        this.f21322b = field;
        this.f21323c = str == null ? null : str.intern();
        this.f21321a = C4642j.m28442e(m28468f());
    }

    /* renamed from: c */
    public static Object m28460c(Field field, Object obj) {
        try {
            return field.get(obj);
        } catch (IllegalAccessException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    /* renamed from: j */
    public static C4645m m28461j(Enum<?> r32) {
        try {
            C4645m c4645mM28462k = m28462k(r32.getClass().getField(r32.name()));
            C4627a0.m28390c(c4645mM28462k != null, "enum constant missing @Value or @NullValue annotation: %s", r32);
            return c4645mM28462k;
        } catch (NoSuchFieldException e10) {
            throw new C11055a(e10);
        }
    }

    /* renamed from: k */
    public static C4645m m28462k(Field field) {
        String strValue = null;
        if (field == null) {
            return null;
        }
        Map<Field, C4645m> map = f21320d;
        synchronized (map) {
            try {
                C4645m c4645m = map.get(field);
                boolean zIsEnumConstant = field.isEnumConstant();
                if (c4645m == null && (zIsEnumConstant || !Modifier.isStatic(field.getModifiers()))) {
                    if (zIsEnumConstant) {
                        InterfaceC4639g0 interfaceC4639g0 = (InterfaceC4639g0) field.getAnnotation(InterfaceC4639g0.class);
                        if (interfaceC4639g0 != null) {
                            strValue = interfaceC4639g0.value();
                        } else if (((InterfaceC4656x) field.getAnnotation(InterfaceC4656x.class)) == null) {
                            return null;
                        }
                    } else {
                        InterfaceC4648p interfaceC4648p = (InterfaceC4648p) field.getAnnotation(InterfaceC4648p.class);
                        if (interfaceC4648p == null) {
                            return null;
                        }
                        strValue = interfaceC4648p.value();
                        field.setAccessible(true);
                    }
                    if ("##default".equals(strValue)) {
                        strValue = field.getName();
                    }
                    c4645m = new C4645m(field, strValue);
                    map.put(field, c4645m);
                }
                return c4645m;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: l */
    public static void m28463l(Field field, Object obj, Object obj2) throws IllegalAccessException, IllegalArgumentException {
        if (!Modifier.isFinal(field.getModifiers())) {
            try {
                field.set(obj, obj2);
                return;
            } catch (IllegalAccessException e10) {
                throw new IllegalArgumentException(e10);
            } catch (SecurityException e11) {
                throw new IllegalArgumentException(e11);
            }
        }
        Object objM28460c = m28460c(field, obj);
        if (obj2 == null) {
            if (objM28460c == null) {
                return;
            }
        } else if (obj2.equals(objM28460c)) {
            return;
        }
        throw new IllegalArgumentException("expected final value <" + objM28460c + "> but was <" + obj2 + "> on " + field.getName() + " field in " + obj.getClass().getName());
    }

    /* renamed from: a */
    public <T extends Enum<T>> T m28464a() {
        return (T) Enum.valueOf(this.f21322b.getDeclaringClass(), this.f21322b.getName());
    }

    /* renamed from: b */
    public Field m28465b() {
        return this.f21322b;
    }

    /* renamed from: d */
    public Type m28466d() {
        return this.f21322b.getGenericType();
    }

    /* renamed from: e */
    public String m28467e() {
        return this.f21323c;
    }

    /* renamed from: f */
    public Class<?> m28468f() {
        return this.f21322b.getType();
    }

    /* renamed from: g */
    public Object m28469g(Object obj) {
        return m28460c(this.f21322b, obj);
    }

    /* renamed from: h */
    public boolean m28470h() {
        return Modifier.isFinal(this.f21322b.getModifiers());
    }

    /* renamed from: i */
    public boolean m28471i() {
        return this.f21321a;
    }

    /* renamed from: m */
    public void m28472m(Object obj, Object obj2) {
        m28463l(this.f21322b, obj, obj2);
    }
}

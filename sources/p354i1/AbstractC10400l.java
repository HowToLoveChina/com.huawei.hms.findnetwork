package p354i1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p244e1.C9380d;
import p323h1.C10077a;
import p481n1.C11592d;

/* renamed from: i1.l */
/* loaded from: classes.dex */
public abstract class AbstractC10400l {

    /* renamed from: a */
    public final C11592d f50198a;

    /* renamed from: b */
    public final Class<?> f50199b;

    public AbstractC10400l(Class<?> cls, C11592d c11592d) {
        this.f50199b = cls;
        this.f50198a = c11592d;
    }

    /* renamed from: a */
    public static boolean m63906a(Field field, Method method, Object obj, Object obj2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (m63907e(field, obj, obj2)) {
            return true;
        }
        try {
            obj.getClass().getDeclaredMethod("set" + method.getName().substring(3), method.getReturnType()).invoke(obj, obj2);
            return true;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    /* renamed from: e */
    public static boolean m63907e(Field field, Object obj, Object obj2) throws IllegalAccessException, IllegalArgumentException {
        if (field == null || Modifier.isFinal(field.getModifiers())) {
            return false;
        }
        field.set(obj, obj2);
        return true;
    }

    /* renamed from: b */
    public int mo63896b() {
        return 0;
    }

    /* renamed from: c */
    public Class<?> m63908c() {
        return this.f50199b;
    }

    /* renamed from: d */
    public abstract void mo63897d(C10077a c10077a, Object obj, Type type, Map<String, Object> map);

    /* renamed from: f */
    public void m63909f(Object obj, int i10) {
        mo63911h(obj, Integer.valueOf(i10));
    }

    /* renamed from: g */
    public void m63910g(Object obj, long j10) {
        mo63911h(obj, Long.valueOf(j10));
    }

    /* renamed from: h */
    public void mo63911h(Object obj, Object obj2) {
        C11592d c11592d;
        Method method;
        String str;
        if (obj2 == null && this.f50198a.f53772e.isPrimitive()) {
            return;
        }
        C11592d c11592d2 = this.f50198a;
        if (c11592d2.f53772e == String.class && (str = c11592d2.f53787t) != null && str.equals("trim")) {
            obj2 = ((String) obj2).trim();
        }
        try {
            c11592d = this.f50198a;
            method = c11592d.f53769b;
        } catch (Exception e10) {
            throw new C9380d("set property error, " + this.f50199b.getName() + "#" + this.f50198a.f53768a, e10);
        }
        if (method == null) {
            Field field = c11592d.f53770c;
            if (!c11592d.f53775h) {
                if (field != null) {
                    field.set(obj, obj2);
                    return;
                }
                return;
            }
            Class<?> cls = c11592d.f53772e;
            if (cls == AtomicInteger.class) {
                AtomicInteger atomicInteger = (AtomicInteger) field.get(obj);
                if (atomicInteger != null) {
                    atomicInteger.set(((AtomicInteger) obj2).get());
                    return;
                }
                return;
            }
            if (cls == AtomicLong.class) {
                AtomicLong atomicLong = (AtomicLong) field.get(obj);
                if (atomicLong != null) {
                    atomicLong.set(((AtomicLong) obj2).get());
                    return;
                }
                return;
            }
            if (cls == AtomicBoolean.class) {
                AtomicBoolean atomicBoolean = (AtomicBoolean) field.get(obj);
                if (atomicBoolean != null) {
                    atomicBoolean.set(((AtomicBoolean) obj2).get());
                    return;
                }
                return;
            }
            if (Map.class.isAssignableFrom(cls)) {
                Map map = (Map) field.get(obj);
                if (map != null && map != Collections.emptyMap() && !map.getClass().getName().startsWith("java.util.Collections$Unmodifiable")) {
                    map.putAll((Map) obj2);
                    return;
                }
                return;
            }
            Collection collection = (Collection) field.get(obj);
            if (collection != null && obj2 != null && collection != Collections.emptySet() && collection != Collections.emptyList() && !collection.getClass().getName().startsWith("java.util.Collections$Unmodifiable")) {
                collection.clear();
                collection.addAll((Collection) obj2);
                return;
            }
            return;
        }
        if (!c11592d.f53775h) {
            method.invoke(obj, obj2);
            return;
        }
        Class<?> cls2 = c11592d.f53772e;
        if (cls2 == AtomicInteger.class) {
            AtomicInteger atomicInteger2 = (AtomicInteger) method.invoke(obj, new Object[0]);
            if (atomicInteger2 != null) {
                atomicInteger2.set(((AtomicInteger) obj2).get());
                return;
            } else {
                m63906a(this.f50198a.f53770c, method, obj, obj2);
                return;
            }
        }
        if (cls2 == AtomicLong.class) {
            AtomicLong atomicLong2 = (AtomicLong) method.invoke(obj, new Object[0]);
            if (atomicLong2 != null) {
                atomicLong2.set(((AtomicLong) obj2).get());
                return;
            } else {
                m63906a(this.f50198a.f53770c, method, obj, obj2);
                return;
            }
        }
        if (cls2 == AtomicBoolean.class) {
            AtomicBoolean atomicBoolean2 = (AtomicBoolean) method.invoke(obj, new Object[0]);
            if (atomicBoolean2 != null) {
                atomicBoolean2.set(((AtomicBoolean) obj2).get());
                return;
            } else {
                m63906a(this.f50198a.f53770c, method, obj, obj2);
                return;
            }
        }
        if (Map.class.isAssignableFrom(method.getReturnType())) {
            try {
                Map map2 = (Map) method.invoke(obj, new Object[0]);
                if (map2 == null) {
                    if (obj2 != null) {
                        m63906a(this.f50198a.f53770c, method, obj, obj2);
                        return;
                    }
                    return;
                } else {
                    if (map2 == Collections.emptyMap()) {
                        return;
                    }
                    if (map2.isEmpty() && ((Map) obj2).isEmpty()) {
                        return;
                    }
                    String name = map2.getClass().getName();
                    if (!name.equals("java.util.ImmutableCollections$Map1") && !name.equals("java.util.ImmutableCollections$MapN") && !name.startsWith("java.util.Collections$Unmodifiable")) {
                        if (map2.getClass().getName().equals("kw.x")) {
                            m63906a(this.f50198a.f53770c, method, obj, obj2);
                            return;
                        } else {
                            map2.putAll((Map) obj2);
                            return;
                        }
                    }
                    return;
                }
            } catch (InvocationTargetException unused) {
                m63906a(this.f50198a.f53770c, method, obj, obj2);
                return;
            }
        }
        try {
            Collection collection2 = (Collection) method.invoke(obj, new Object[0]);
            if (collection2 == null || obj2 == null) {
                if (collection2 != null || obj2 == null) {
                    return;
                }
                m63906a(this.f50198a.f53770c, method, obj, obj2);
                return;
            }
            String name2 = collection2.getClass().getName();
            if (collection2 != Collections.emptySet() && collection2 != Collections.emptyList() && name2 != "java.util.ImmutableCollections$ListN" && name2 != "java.util.ImmutableCollections$List12" && !name2.startsWith("java.util.Collections$Unmodifiable")) {
                if (!collection2.isEmpty()) {
                    collection2.clear();
                } else if (((Collection) obj2).isEmpty()) {
                    return;
                }
                if (!name2.equals("kw.w") && !name2.equals("kw.y")) {
                    collection2.addAll((Collection) obj2);
                    return;
                }
                m63906a(this.f50198a.f53770c, method, obj, obj2);
                return;
            }
            return;
        } catch (InvocationTargetException unused2) {
            m63906a(this.f50198a.f53770c, method, obj, obj2);
            return;
        }
        throw new C9380d("set property error, " + this.f50199b.getName() + "#" + this.f50198a.f53768a, e10);
    }

    /* renamed from: i */
    public void m63912i(Object obj, String str) {
        mo63911h(obj, str);
    }

    /* renamed from: j */
    public void m63913j(Object obj, boolean z10) {
        mo63911h(obj, Boolean.valueOf(z10));
    }
}

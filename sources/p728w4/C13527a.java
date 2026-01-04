package p728w4;

import com.huawei.android.backup.filelogic.utils.C2111d;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* renamed from: w4.a */
/* loaded from: classes.dex */
public class C13527a {

    /* renamed from: c */
    public static final Map<Class<?>, Class<?>> f60890c;

    /* renamed from: a */
    public final Class<?> f60891a;

    /* renamed from: b */
    public final Object f60892b;

    /* renamed from: w4.a$a */
    public static class a {
    }

    static {
        HashMap map = new HashMap(8);
        f60890c = map;
        map.put(Integer.class, Integer.TYPE);
        map.put(Byte.class, Byte.TYPE);
        map.put(Character.class, Character.TYPE);
        map.put(Short.class, Short.TYPE);
        map.put(Long.class, Long.TYPE);
        map.put(Float.class, Float.TYPE);
        map.put(Double.class, Double.TYPE);
        map.put(Boolean.class, Boolean.TYPE);
    }

    public C13527a(Class<?> cls) {
        this(cls, cls);
    }

    /* renamed from: a */
    public static <T extends AccessibleObject> T m81401a(T t10) throws SecurityException {
        if (t10 == null) {
            return null;
        }
        if (t10 instanceof Member) {
            Member member = (Member) t10;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return t10;
            }
        }
        if (!t10.isAccessible()) {
            t10.setAccessible(true);
        }
        return t10;
    }

    /* renamed from: f */
    public static Class<?> m81402f(String str) throws C13530d {
        try {
            return Class.forName(str);
        } catch (Exception unused) {
            throw new C13530d("cannot find class:" + str);
        }
    }

    /* renamed from: i */
    public static C13527a m81403i(Class<?> cls) {
        return new C13527a(cls);
    }

    /* renamed from: j */
    public static C13527a m81404j(Class<?> cls, Object obj) {
        return new C13527a(cls, obj);
    }

    /* renamed from: k */
    public static C13527a m81405k(Object obj) {
        return obj == null ? new C13527a(Object.class) : new C13527a(obj.getClass(), obj);
    }

    /* renamed from: l */
    public static C13527a m81406l(String str) throws C13530d {
        return m81403i(m81402f(str));
    }

    /* renamed from: m */
    public static C13527a m81407m(Method method, Object obj, Object... objArr) throws IllegalAccessException, C13530d, IllegalArgumentException, InvocationTargetException {
        try {
            m81401a(method);
            if (method.getReturnType() != Void.TYPE) {
                return m81405k(method.invoke(obj, objArr));
            }
            method.invoke(obj, objArr);
            return m81405k(obj);
        } catch (IllegalAccessException unused) {
            throw new C13530d("reflect failed when invoking reflectMethod:" + method.getName());
        } catch (IllegalArgumentException unused2) {
            throw new C13530d("reflect failed when invoking reflectMethod:" + method.getName());
        } catch (InvocationTargetException unused3) {
            throw new C13530d("reflect failed when invoking reflectMethod:" + method.getName());
        } catch (Exception unused4) {
            throw new C13530d("reflect failed when invoking reflectMethod:Exception");
        }
    }

    /* renamed from: n */
    public static Class<?>[] m81408n(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i10 = 0; i10 < objArr.length; i10++) {
            Object obj = objArr[i10];
            if (obj == null) {
                clsArr[i10] = a.class;
            } else {
                clsArr[i10] = obj.getClass();
            }
        }
        return clsArr;
    }

    /* renamed from: b */
    public C13527a m81409b(String str, Object... objArr) throws C13530d {
        try {
            return m81407m(m81411d(str, m81408n(objArr)), this.f60892b, objArr);
        } catch (NoSuchMethodException unused) {
            throw new C13530d("Reflect error");
        }
    }

    /* renamed from: c */
    public C13527a m81410c(String str, Object... objArr) throws C13530d {
        try {
            return m81407m(m81411d(str, m81415o(objArr)), this.f60892b, objArr);
        } catch (NoSuchMethodException unused) {
            throw new C13530d("Reflect error");
        }
    }

    /* renamed from: d */
    public final Method m81411d(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> superclass = this.f60891a;
        try {
            return superclass.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    return superclass.getDeclaredMethod(str, clsArr);
                } catch (NoSuchMethodException unused2) {
                    C2111d.m12648d("InnerReflect", "err cannot find method: " + str);
                    superclass = superclass.getSuperclass();
                    if (superclass == null) {
                        throw new NoSuchMethodException();
                    }
                }
            } while (superclass == null);
            throw new NoSuchMethodException();
        }
    }

    /* renamed from: e */
    public C13527a m81412e(String str) throws C13530d {
        try {
            Field fieldM81414h = m81414h(str);
            return m81404j(fieldM81414h.getType(), fieldM81414h.get(this.f60892b));
        } catch (IllegalAccessException unused) {
            throw new C13530d("reflect failed when getting field:" + str);
        } catch (IllegalArgumentException unused2) {
            throw new IllegalArgumentException("reflect failed when getting field:" + str);
        } catch (Exception unused3) {
            throw new C13530d("reflect failed when getting field:Exception");
        }
    }

    /* renamed from: g */
    public <T> T m81413g() {
        return (T) this.f60892b;
    }

    /* renamed from: h */
    public final Field m81414h(String str) throws C13530d {
        Class<?> superclass = this.f60891a;
        try {
            return (Field) m81401a(superclass.getField(str));
        } catch (NoSuchFieldException unused) {
            do {
                try {
                    return (Field) m81401a(superclass.getDeclaredField(str));
                } catch (NoSuchFieldException unused2) {
                    C2111d.m12648d("InnerReflect", "err reflect failed when getting field:" + str);
                    superclass = superclass.getSuperclass();
                    if (superclass == null) {
                        throw new C13530d("reflect failed when getting field:" + str);
                    }
                }
            } while (superclass == null);
            throw new C13530d("reflect failed when getting field:" + str);
        }
    }

    /* renamed from: o */
    public final Class<?>[] m81415o(Object[] objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i10 = 0; i10 < objArr.length; i10++) {
            Object obj = objArr[i10];
            if (obj == null) {
                clsArr[i10] = a.class;
            } else {
                Map<Class<?>, Class<?>> map = f60890c;
                if (map.containsKey(obj.getClass())) {
                    clsArr[i10] = map.get(obj.getClass());
                } else {
                    clsArr[i10] = obj.getClass();
                }
            }
        }
        return clsArr;
    }

    public C13527a(Class<?> cls, Object obj) {
        this.f60891a = cls;
        this.f60892b = obj;
    }
}

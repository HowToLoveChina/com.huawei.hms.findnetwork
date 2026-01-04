package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.lifecycle.o */
/* loaded from: classes.dex */
public class C0799o {

    /* renamed from: a */
    public static Map<Class<?>, Integer> f4185a = new HashMap();

    /* renamed from: b */
    public static Map<Class<?>, List<Constructor<? extends InterfaceC0787f>>> f4186b = new HashMap();

    /* renamed from: a */
    public static InterfaceC0787f m4971a(Constructor<? extends InterfaceC0787f> constructor, Object obj) {
        try {
            return constructor.newInstance(obj);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException(e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException(e12);
        }
    }

    /* renamed from: b */
    public static Constructor<? extends InterfaceC0787f> m4972b(Class<?> cls) throws NoSuchMethodException, SecurityException {
        try {
            Package r02 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r02 != null ? r02.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String strM4973c = m4973c(canonicalName);
            if (!name.isEmpty()) {
                strM4973c = name + "." + strM4973c;
            }
            Constructor declaredConstructor = Class.forName(strM4973c).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e10) {
            throw new RuntimeException(e10);
        }
    }

    /* renamed from: c */
    public static String m4973c(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }

    /* renamed from: d */
    public static int m4974d(Class<?> cls) throws NoSuchMethodException, SecurityException {
        Integer num = f4185a.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int iM4977g = m4977g(cls);
        f4185a.put(cls, Integer.valueOf(iM4977g));
        return iM4977g;
    }

    /* renamed from: e */
    public static boolean m4975e(Class<?> cls) {
        return cls != null && InterfaceC0795k.class.isAssignableFrom(cls);
    }

    /* renamed from: f */
    public static InterfaceC0794j m4976f(Object obj) {
        boolean z10 = obj instanceof InterfaceC0794j;
        boolean z11 = obj instanceof InterfaceC0785e;
        if (z10 && z11) {
            return new FullLifecycleObserverAdapter((InterfaceC0785e) obj, (InterfaceC0794j) obj);
        }
        if (z11) {
            return new FullLifecycleObserverAdapter((InterfaceC0785e) obj, null);
        }
        if (z10) {
            return (InterfaceC0794j) obj;
        }
        Class<?> cls = obj.getClass();
        if (m4974d(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List<Constructor<? extends InterfaceC0787f>> list = f4186b.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(m4971a(list.get(0), obj));
        }
        InterfaceC0787f[] interfaceC0787fArr = new InterfaceC0787f[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            interfaceC0787fArr[i10] = m4971a(list.get(i10), obj);
        }
        return new CompositeGeneratedAdaptersObserver(interfaceC0787fArr);
    }

    /* renamed from: g */
    public static int m4977g(Class<?> cls) throws NoSuchMethodException, SecurityException {
        ArrayList arrayList;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends InterfaceC0787f> constructorM4972b = m4972b(cls);
        if (constructorM4972b != null) {
            f4186b.put(cls, Collections.singletonList(constructorM4972b));
            return 2;
        }
        if (C0779b.f4140c.m4918d(cls)) {
            return 1;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (!m4975e(superclass)) {
            arrayList = null;
        } else {
            if (m4974d(superclass) == 1) {
                return 1;
            }
            arrayList = new ArrayList(f4186b.get(superclass));
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (m4975e(cls2)) {
                if (m4974d(cls2) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.addAll(f4186b.get(cls2));
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f4186b.put(cls, arrayList);
        return 2;
    }
}

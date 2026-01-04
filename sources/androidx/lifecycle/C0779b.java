package androidx.lifecycle;

import androidx.lifecycle.AbstractC0791h;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
/* renamed from: androidx.lifecycle.b */
/* loaded from: classes.dex */
public final class C0779b {

    /* renamed from: c */
    public static C0779b f4140c = new C0779b();

    /* renamed from: a */
    public final Map<Class<?>, a> f4141a = new HashMap();

    /* renamed from: b */
    public final Map<Class<?>, Boolean> f4142b = new HashMap();

    @Deprecated
    /* renamed from: androidx.lifecycle.b$a */
    public static class a {

        /* renamed from: a */
        public final Map<AbstractC0791h.b, List<b>> f4143a = new HashMap();

        /* renamed from: b */
        public final Map<b, AbstractC0791h.b> f4144b;

        public a(Map<b, AbstractC0791h.b> map) {
            this.f4144b = map;
            for (Map.Entry<b, AbstractC0791h.b> entry : map.entrySet()) {
                AbstractC0791h.b value = entry.getValue();
                List<b> arrayList = this.f4143a.get(value);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.f4143a.put(value, arrayList);
                }
                arrayList.add(entry.getKey());
            }
        }

        /* renamed from: b */
        public static void m4920b(List<b> list, InterfaceC0796l interfaceC0796l, AbstractC0791h.b bVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).m4922a(interfaceC0796l, bVar, obj);
                }
            }
        }

        /* renamed from: a */
        public void m4921a(InterfaceC0796l interfaceC0796l, AbstractC0791h.b bVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            m4920b(this.f4143a.get(bVar), interfaceC0796l, bVar, obj);
            m4920b(this.f4143a.get(AbstractC0791h.b.ON_ANY), interfaceC0796l, bVar, obj);
        }
    }

    @Deprecated
    /* renamed from: androidx.lifecycle.b$b */
    public static final class b {

        /* renamed from: a */
        public final int f4145a;

        /* renamed from: b */
        public final Method f4146b;

        public b(int i10, Method method) throws SecurityException {
            this.f4145a = i10;
            this.f4146b = method;
            method.setAccessible(true);
        }

        /* renamed from: a */
        public void m4922a(InterfaceC0796l interfaceC0796l, AbstractC0791h.b bVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                int i10 = this.f4145a;
                if (i10 == 0) {
                    this.f4146b.invoke(obj, new Object[0]);
                } else if (i10 == 1) {
                    this.f4146b.invoke(obj, interfaceC0796l);
                } else {
                    if (i10 != 2) {
                        return;
                    }
                    this.f4146b.invoke(obj, interfaceC0796l, bVar);
                }
            } catch (IllegalAccessException e10) {
                throw new RuntimeException(e10);
            } catch (InvocationTargetException e11) {
                throw new RuntimeException("Failed to call observer method", e11.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f4145a == bVar.f4145a && this.f4146b.getName().equals(bVar.f4146b.getName());
        }

        public int hashCode() {
            return (this.f4145a * 31) + this.f4146b.getName().hashCode();
        }
    }

    /* renamed from: a */
    public final a m4915a(Class<?> cls, Method[] methodArr) {
        int i10;
        a aVarM4917c;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (aVarM4917c = m4917c(superclass)) != null) {
            map.putAll(aVarM4917c.f4144b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, AbstractC0791h.b> entry : m4917c(cls2).f4144b.entrySet()) {
                m4919e(map, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = m4916b(cls);
        }
        boolean z10 = false;
        for (Method method : methodArr) {
            InterfaceC0803s interfaceC0803s = (InterfaceC0803s) method.getAnnotation(InterfaceC0803s.class);
            if (interfaceC0803s != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i10 = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(InterfaceC0796l.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i10 = 1;
                }
                AbstractC0791h.b bVarValue = interfaceC0803s.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(AbstractC0791h.b.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (bVarValue != AbstractC0791h.b.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i10 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                m4919e(map, new b(i10, method), bVarValue, cls);
                z10 = true;
            }
        }
        a aVar = new a(map);
        this.f4141a.put(cls, aVar);
        this.f4142b.put(cls, Boolean.valueOf(z10));
        return aVar;
    }

    /* renamed from: b */
    public final Method[] m4916b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e10) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e10);
        }
    }

    /* renamed from: c */
    public a m4917c(Class<?> cls) {
        a aVar = this.f4141a.get(cls);
        return aVar != null ? aVar : m4915a(cls, null);
    }

    /* renamed from: d */
    public boolean m4918d(Class<?> cls) {
        Boolean bool = this.f4142b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] methodArrM4916b = m4916b(cls);
        for (Method method : methodArrM4916b) {
            if (((InterfaceC0803s) method.getAnnotation(InterfaceC0803s.class)) != null) {
                m4915a(cls, methodArrM4916b);
                return true;
            }
        }
        this.f4142b.put(cls, Boolean.FALSE);
        return false;
    }

    /* renamed from: e */
    public final void m4919e(Map<b, AbstractC0791h.b> map, b bVar, AbstractC0791h.b bVar2, Class<?> cls) {
        AbstractC0791h.b bVar3 = map.get(bVar);
        if (bVar3 == null || bVar2 == bVar3) {
            if (bVar3 == null) {
                map.put(bVar, bVar2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + bVar.f4146b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + bVar3 + ", new value " + bVar2);
    }
}

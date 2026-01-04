package com.huawei.cloud.base.util;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* renamed from: com.huawei.cloud.base.util.f0 */
/* loaded from: classes.dex */
public class C4637f0 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.huawei.cloud.base.util.f0$a */
    public class a<T> implements Iterable<T> {

        /* renamed from: a */
        public final /* synthetic */ Object f21274a;

        /* renamed from: com.huawei.cloud.base.util.f0$a$a, reason: collision with other inner class name */
        public class C14429a implements Iterator<T> {

            /* renamed from: a */
            public final int f21275a;

            /* renamed from: b */
            public int f21276b = 0;

            public C14429a() {
                this.f21275a = Array.getLength(a.this.f21274a);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f21276b < this.f21275a;
            }

            @Override // java.util.Iterator
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Object obj = a.this.f21274a;
                int i10 = this.f21276b;
                this.f21276b = i10 + 1;
                return (T) Array.get(obj, i10);
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        public a(Object obj) {
            this.f21274a = obj;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return new C14429a();
        }
    }

    /* renamed from: a */
    public static Type m28412a(Type type, Class<?> cls, int i10) {
        Type typeM28425n;
        ParameterizedType parameterizedTypeM28419h = m28419h(type, cls);
        if (parameterizedTypeM28419h == null) {
            return null;
        }
        Type type2 = parameterizedTypeM28419h.getActualTypeArguments()[i10];
        return (!(type2 instanceof TypeVariable) || (typeM28425n = m28425n(Arrays.asList(type), (TypeVariable) type2)) == null) ? type2 : typeM28425n;
    }

    /* renamed from: b */
    public static Type m28413b(Type type) {
        return type instanceof GenericArrayType ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
    }

    /* renamed from: c */
    public static Type m28414c(WildcardType wildcardType) {
        Type[] lowerBounds = wildcardType.getLowerBounds();
        return lowerBounds.length != 0 ? lowerBounds[0] : wildcardType.getUpperBounds()[0];
    }

    /* renamed from: d */
    public static Type m28415d(Type type) {
        return m28412a(type, Iterable.class, 0);
    }

    /* renamed from: e */
    public static Type m28416e(Type type) {
        return m28412a(type, Map.class, 1);
    }

    /* renamed from: f */
    public static Class<?> m28417f(List<Type> list, Type type) {
        if (type instanceof TypeVariable) {
            type = m28425n(list, (TypeVariable) type);
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(m28417f(list, m28413b(type)), 0).getClass();
        }
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return m28418g((ParameterizedType) type);
        }
        C4627a0.m28390c(type == null, "wildcard type is not supported: %s", type);
        return Object.class;
    }

    /* renamed from: g */
    public static Class<?> m28418g(ParameterizedType parameterizedType) {
        return (Class) parameterizedType.getRawType();
    }

    /* renamed from: h */
    public static ParameterizedType m28419h(Type type, Class<?> cls) {
        Class<?> cls2;
        if (!(type instanceof Class) && !(type instanceof ParameterizedType)) {
            return null;
        }
        while (type != null && type != Object.class) {
            if (type instanceof Class) {
                cls2 = (Class) type;
            } else {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Class<?> clsM28418g = m28418g(parameterizedType);
                if (clsM28418g == cls) {
                    return parameterizedType;
                }
                if (cls.isInterface()) {
                    for (Type type2 : clsM28418g.getGenericInterfaces()) {
                        if (cls.isAssignableFrom(type2 instanceof Class ? (Class) type2 : m28418g((ParameterizedType) type2))) {
                            type = type2;
                            break;
                        }
                    }
                }
                cls2 = clsM28418g;
            }
            type = cls2.getGenericSuperclass();
        }
        return null;
    }

    /* renamed from: i */
    public static IllegalArgumentException m28420i(Exception exc, Class<?> cls) throws NoSuchMethodException, SecurityException {
        StringBuilder sb2 = new StringBuilder("unable to create new instance of class ");
        sb2.append(cls.getName());
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        if (cls.isArray()) {
            arrayList.add("because it is an array");
        } else if (cls.isPrimitive()) {
            arrayList.add("because it is primitive");
        } else if (cls == Void.class) {
            arrayList.add("because it is void");
        } else {
            if (Modifier.isInterface(cls.getModifiers())) {
                arrayList.add("because it is an interface");
            } else if (Modifier.isAbstract(cls.getModifiers())) {
                arrayList.add("because it is abstract");
            }
            if (cls.getEnclosingClass() != null && !Modifier.isStatic(cls.getModifiers())) {
                arrayList.add("because it is not static");
            }
            if (Modifier.isPublic(cls.getModifiers())) {
                try {
                    cls.getConstructor(new Class[0]);
                } catch (NoSuchMethodException unused) {
                    arrayList.add("because it has no accessible default constructor");
                }
            } else {
                arrayList.add("possibly because it is not public");
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z10) {
                sb2.append(" and");
            } else {
                z10 = true;
            }
            sb2.append(" ");
            sb2.append(str);
        }
        return new IllegalArgumentException(sb2.toString(), exc);
    }

    /* renamed from: j */
    public static boolean m28421j(Type type) {
        return (type instanceof GenericArrayType) || ((type instanceof Class) && ((Class) type).isArray());
    }

    /* renamed from: k */
    public static boolean m28422k(Class<?> cls, Class<?> cls2) {
        return cls.isAssignableFrom(cls2) || cls2.isAssignableFrom(cls);
    }

    /* renamed from: l */
    public static <T> Iterable<T> m28423l(Object obj) {
        if (obj instanceof Iterable) {
            return (Iterable) obj;
        }
        Class<?> cls = obj.getClass();
        C4627a0.m28390c(cls.isArray(), "not an array or Iterable: %s", cls);
        return !cls.getComponentType().isPrimitive() ? Arrays.asList((Object[]) obj) : new a(obj);
    }

    /* renamed from: m */
    public static <T> T m28424m(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e10) {
            throw m28420i(e10, cls);
        } catch (InstantiationException e11) {
            throw m28420i(e11, cls);
        }
    }

    /* renamed from: n */
    public static Type m28425n(List<Type> list, TypeVariable<?> typeVariable) {
        Type typeM28425n;
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            Class cls = (Class) genericDeclaration;
            int size = list.size();
            ParameterizedType parameterizedTypeM28419h = null;
            while (parameterizedTypeM28419h == null) {
                size--;
                if (size < 0) {
                    break;
                }
                parameterizedTypeM28419h = m28419h(list.get(size), cls);
            }
            if (parameterizedTypeM28419h != null) {
                TypeVariable<?>[] typeParameters = genericDeclaration.getTypeParameters();
                int i10 = 0;
                while (i10 < typeParameters.length && !typeParameters[i10].equals(typeVariable)) {
                    i10++;
                }
                Type type = parameterizedTypeM28419h.getActualTypeArguments()[i10];
                return (!(type instanceof TypeVariable) || (typeM28425n = m28425n(list, (TypeVariable) type)) == null) ? type : typeM28425n;
            }
        }
        return null;
    }

    /* renamed from: o */
    public static Object m28426o(Collection<?> collection, Class<?> cls) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        if (!cls.isPrimitive()) {
            return collection.toArray((Object[]) Array.newInstance(cls, collection.size()));
        }
        Object objNewInstance = Array.newInstance(cls, collection.size());
        Iterator<?> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            Array.set(objNewInstance, i10, it.next());
            i10++;
        }
        return objNewInstance;
    }
}

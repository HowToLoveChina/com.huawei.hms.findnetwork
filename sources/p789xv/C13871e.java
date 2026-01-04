package p789xv;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p559pv.InterfaceC12231a;

/* renamed from: xv.e */
/* loaded from: classes9.dex */
public class C13871e<A extends Annotation> implements InterfaceC13870d<A> {

    /* renamed from: a */
    public final Map<Type, Class<? extends InterfaceC12231a<A, ?>>> f62150a = new ConcurrentHashMap();

    /* renamed from: b */
    public final Map<Type, Class<? extends InterfaceC12231a<A, ?>>> f62151b = new ConcurrentHashMap();

    /* renamed from: c */
    public final Map<Class<?>, Class<?>> f62152c = new a();

    /* renamed from: d */
    public final Map<Class<?>, Class<?>> f62153d = new b();

    /* renamed from: xv.e$a */
    public class a extends ConcurrentHashMap<Class<?>, Class<?>> {
        public a() {
            put(Byte.TYPE, Byte.class);
            put(Short.TYPE, Short.class);
            put(Integer.TYPE, Integer.class);
            put(Long.TYPE, Long.class);
            put(Float.TYPE, Float.class);
            put(Double.TYPE, Double.class);
            put(Character.TYPE, Character.class);
            put(Boolean.TYPE, Boolean.class);
        }
    }

    /* renamed from: xv.e$b */
    public class b extends ConcurrentHashMap<Class<?>, Class<?>> {
        public b() {
            put(Byte.TYPE, byte[].class);
            put(Short.TYPE, short[].class);
            put(Integer.TYPE, int[].class);
            put(Long.TYPE, long[].class);
            put(Float.TYPE, float[].class);
            put(Double.TYPE, double[].class);
            put(Character.TYPE, char[].class);
            put(Boolean.TYPE, boolean[].class);
        }
    }

    @SafeVarargs
    public C13871e(Class<? extends InterfaceC12231a<A, ?>>... clsArr) {
        for (Class<? extends InterfaceC12231a<A, ?>> cls : clsArr) {
            m83210e(cls);
        }
    }

    @Override // p789xv.InterfaceC13870d
    /* renamed from: a */
    public Class<? extends InterfaceC12231a<A, ?>> mo83206a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        Class<?> clsM83209d = m83209d(cls);
        if (this.f62150a.containsKey(Object.class)) {
            return this.f62150a.get(Object.class);
        }
        if (this.f62150a.containsKey(clsM83209d)) {
            return this.f62150a.get(clsM83209d);
        }
        Class<? extends InterfaceC12231a<A, ?>> clsM83208c = clsM83209d.isArray() ? m83208c(this.f62151b, clsM83209d.getComponentType()) : m83208c(this.f62150a, clsM83209d);
        if (clsM83208c != null) {
            this.f62150a.put(clsM83209d, clsM83208c);
        }
        return clsM83208c;
    }

    /* renamed from: b */
    public final Class<? extends InterfaceC12231a<A, ?>> m83207b(Map<Type, Class<? extends InterfaceC12231a<A, ?>>> map, Class<?> cls) {
        if (map.containsKey(cls)) {
            return map.get(cls);
        }
        Class<? extends InterfaceC12231a<A, ?>> clsM83208c = m83208c(map, cls.getGenericSuperclass());
        if (clsM83208c != null) {
            return clsM83208c;
        }
        for (Type type : cls.getGenericInterfaces()) {
            Class<? extends InterfaceC12231a<A, ?>> clsM83208c2 = m83208c(map, type);
            if (clsM83208c2 != null) {
                return clsM83208c2;
            }
        }
        return null;
    }

    /* renamed from: c */
    public final Class<? extends InterfaceC12231a<A, ?>> m83208c(Map<Type, Class<? extends InterfaceC12231a<A, ?>>> map, Type type) {
        Class<? extends InterfaceC12231a<A, ?>> clsM83207b;
        if (type == null) {
            return null;
        }
        if ((type instanceof Class) && (clsM83207b = m83207b(map, (Class) type)) != null) {
            return clsM83207b;
        }
        if (!(type instanceof ParameterizedType)) {
            return null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getRawType() instanceof Class) {
            return m83207b(map, (Class) parameterizedType.getRawType());
        }
        return null;
    }

    /* renamed from: d */
    public final Class<?> m83209d(Class<?> cls) {
        return this.f62152c.containsKey(cls) ? this.f62152c.get(cls) : cls;
    }

    /* renamed from: e */
    public final void m83210e(Class<? extends InterfaceC12231a<A, ?>> cls) {
        Type typeM83205a = C13869c.m83205a(cls);
        if (typeM83205a instanceof Class) {
            Class cls2 = (Class) typeM83205a;
            if (cls2.isArray()) {
                this.f62151b.put(cls2.getComponentType(), cls);
            }
            this.f62150a.put(typeM83205a, cls);
            return;
        }
        if (typeM83205a instanceof GenericArrayType) {
            Class cls3 = (Class) ((GenericArrayType) typeM83205a).getGenericComponentType();
            if (this.f62153d.containsKey(cls3)) {
                this.f62150a.put(this.f62153d.get(cls3), cls);
            }
        }
    }
}

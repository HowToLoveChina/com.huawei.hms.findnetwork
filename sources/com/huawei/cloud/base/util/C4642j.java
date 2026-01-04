package com.huawei.cloud.base.util;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/* renamed from: com.huawei.cloud.base.util.j */
/* loaded from: classes.dex */
public class C4642j {

    /* renamed from: a */
    public static final Boolean f21289a;

    /* renamed from: b */
    public static final String f21290b;

    /* renamed from: c */
    public static final Character f21291c;

    /* renamed from: d */
    public static final Byte f21292d;

    /* renamed from: e */
    public static final Short f21293e;

    /* renamed from: f */
    public static final Integer f21294f;

    /* renamed from: g */
    public static final Float f21295g;

    /* renamed from: h */
    public static final Long f21296h;

    /* renamed from: i */
    public static final Double f21297i;

    /* renamed from: j */
    public static final BigInteger f21298j;

    /* renamed from: k */
    public static final BigDecimal f21299k;

    /* renamed from: l */
    public static final C4644l f21300l;

    /* renamed from: m */
    public static final ConcurrentHashMap<Class<?>, Object> f21301m;

    static {
        Boolean bool = new Boolean(true);
        f21289a = bool;
        String str = new String();
        f21290b = str;
        Character ch2 = new Character((char) 0);
        f21291c = ch2;
        Byte b10 = new Byte((byte) 0);
        f21292d = b10;
        Short sh2 = new Short((short) 0);
        f21293e = sh2;
        Integer num = new Integer(0);
        f21294f = num;
        Float f10 = new Float(0.0f);
        f21295g = f10;
        Long l10 = new Long(0L);
        f21296h = l10;
        Double d10 = new Double(0.0d);
        f21297i = d10;
        BigInteger bigInteger = new BigInteger("0");
        f21298j = bigInteger;
        BigDecimal bigDecimal = new BigDecimal("0");
        f21299k = bigDecimal;
        C4644l c4644l = new C4644l(0L);
        f21300l = c4644l;
        ConcurrentHashMap<Class<?>, Object> concurrentHashMap = new ConcurrentHashMap<>();
        f21301m = concurrentHashMap;
        concurrentHashMap.put(Boolean.class, bool);
        concurrentHashMap.put(String.class, str);
        concurrentHashMap.put(Character.class, ch2);
        concurrentHashMap.put(Byte.class, b10);
        concurrentHashMap.put(Short.class, sh2);
        concurrentHashMap.put(Integer.class, num);
        concurrentHashMap.put(Float.class, f10);
        concurrentHashMap.put(Long.class, l10);
        concurrentHashMap.put(Double.class, d10);
        concurrentHashMap.put(BigInteger.class, bigInteger);
        concurrentHashMap.put(BigDecimal.class, bigDecimal);
        concurrentHashMap.put(C4644l.class, c4644l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static <T> T m28438a(T t10) {
        T t11;
        if (t10 == 0 || m28442e(t10.getClass())) {
            return t10;
        }
        if (t10 instanceof C4646n) {
            return (T) ((C4646n) t10).clone();
        }
        Class<?> cls = t10.getClass();
        if (cls.isArray()) {
            t11 = (T) Array.newInstance(cls.getComponentType(), Array.getLength(t10));
        } else if (t10 instanceof C4626a) {
            t11 = (T) ((C4626a) t10).clone();
        } else {
            if ("java.util.Arrays$ArrayList".equals(cls.getName())) {
                Object[] array = ((List) t10).toArray();
                m28439b(array, array);
                return (T) Arrays.asList(array);
            }
            t11 = (T) C4637f0.m28424m(cls);
        }
        m28439b(t10, t11);
        return t11;
    }

    /* renamed from: b */
    public static void m28439b(Object obj, Object obj2) {
        Class<?> cls = obj.getClass();
        int i10 = 0;
        C4627a0.m28388a(cls == obj2.getClass());
        if (cls.isArray()) {
            C4627a0.m28388a(Array.getLength(obj) == Array.getLength(obj2));
            Iterator it = C4637f0.m28423l(obj).iterator();
            while (it.hasNext()) {
                Array.set(obj2, i10, m28438a(it.next()));
                i10++;
            }
            return;
        }
        if (!Collection.class.isAssignableFrom(cls)) {
            m28440c(obj, cls, obj2);
            return;
        }
        Collection collection = (Collection) obj;
        if (ArrayList.class.isAssignableFrom(cls)) {
            ((ArrayList) obj2).ensureCapacity(collection.size());
        }
        Collection collection2 = (Collection) obj2;
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            collection2.add(m28438a(it2.next()));
        }
    }

    /* renamed from: c */
    public static void m28440c(Object obj, Class<?> cls, Object obj2) {
        boolean zIsAssignableFrom = C4646n.class.isAssignableFrom(cls);
        if (zIsAssignableFrom || !Map.class.isAssignableFrom(cls)) {
            C4638g c4638gM28427f = zIsAssignableFrom ? ((C4646n) obj).classInfo : C4638g.m28427f(cls);
            Iterator<String> it = c4638gM28427f.f21280a.iterator();
            while (it.hasNext()) {
                C4645m c4645mM28430b = c4638gM28427f.m28430b(it.next());
                if (!c4645mM28430b.m28470h() && (!zIsAssignableFrom || !c4645mM28430b.m28471i())) {
                    Object objM28469g = c4645mM28430b.m28469g(obj);
                    if (objM28469g != null) {
                        c4645mM28430b.m28472m(obj2, m28438a(objM28469g));
                    }
                }
            }
            return;
        }
        if (!C4626a.class.isAssignableFrom(cls)) {
            Map map = (Map) obj2;
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                map.put((String) entry.getKey(), m28438a(entry.getValue()));
            }
            return;
        }
        C4626a c4626a = (C4626a) obj2;
        C4626a c4626a2 = (C4626a) obj;
        int size = c4626a2.size();
        for (int i10 = 0; i10 < size; i10++) {
            c4626a.m28382n(i10, m28438a(c4626a2.m28379k(i10)));
        }
    }

    /* renamed from: d */
    public static boolean m28441d(Object obj) {
        return obj != null && obj == f21301m.get(obj.getClass());
    }

    /* renamed from: e */
    public static boolean m28442e(Type type) {
        if (type instanceof WildcardType) {
            type = C4637f0.m28414c((WildcardType) type);
        }
        if (!(type instanceof Class)) {
            return false;
        }
        Class cls = (Class) type;
        return cls.isPrimitive() || cls == Character.class || cls == String.class || cls == Integer.class || cls == Long.class || cls == Short.class || cls == Byte.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == C4644l.class || cls == Boolean.class;
    }

    /* renamed from: f */
    public static boolean m28443f(Object obj) {
        return obj == null || m28442e(obj.getClass());
    }

    /* renamed from: g */
    public static Map<String, Object> m28444g(Object obj) {
        return (obj == null || m28441d(obj)) ? Collections.emptyMap() : obj instanceof Map ? (Map) obj : new C4643k(obj, false);
    }

    /* renamed from: h */
    public static Collection<Object> m28445h(Type type) {
        if (type instanceof WildcardType) {
            type = C4637f0.m28414c((WildcardType) type);
        }
        if (type instanceof ParameterizedType) {
            type = ((ParameterizedType) type).getRawType();
        }
        Class cls = type instanceof Class ? (Class) type : null;
        if (type == null || (type instanceof GenericArrayType) || (cls != null && (cls.isArray() || cls.isAssignableFrom(ArrayList.class)))) {
            return new ArrayList();
        }
        if (cls != null) {
            return cls.isAssignableFrom(HashSet.class) ? new HashSet() : cls.isAssignableFrom(TreeSet.class) ? new TreeSet() : (Collection) C4637f0.m28424m(cls);
        }
        throw new IllegalArgumentException("unable to create new instance of type: " + type);
    }

    /* renamed from: i */
    public static Map<String, Object> m28446i(Class<?> cls) {
        return (cls == null || cls.isAssignableFrom(C4626a.class)) ? C4626a.m28373d() : cls.isAssignableFrom(TreeMap.class) ? new TreeMap() : (Map) C4637f0.m28424m(cls);
    }

    /* renamed from: j */
    public static <T> T m28447j(Class<?> cls) {
        ConcurrentHashMap<Class<?>, Object> concurrentHashMap = f21301m;
        Object objM28424m = (T) concurrentHashMap.get(cls);
        if (objM28424m == null) {
            synchronized (concurrentHashMap) {
                try {
                    objM28424m = concurrentHashMap.get(cls);
                    if (objM28424m == null) {
                        if (cls.isArray()) {
                            int i10 = 0;
                            Class<?> componentType = cls;
                            do {
                                componentType = componentType.getComponentType();
                                i10++;
                            } while (componentType.isArray());
                            objM28424m = (T) Array.newInstance(componentType, new int[i10]);
                        } else if (cls.isEnum()) {
                            C4645m c4645mM28430b = C4638g.m28427f(cls).m28430b(null);
                            C4627a0.m28393f(c4645mM28430b, "enum missing constant with @NullValue annotation: %s", cls);
                            objM28424m = c4645mM28430b.m28464a();
                        } else {
                            objM28424m = C4637f0.m28424m(cls);
                        }
                        f21301m.put(cls, objM28424m);
                    }
                } finally {
                }
            }
        }
        return (T) objM28424m;
    }

    /* renamed from: k */
    public static Object m28448k(Class<?> cls, String str) {
        if (cls == Byte.class || cls == Byte.TYPE) {
            return Byte.valueOf(str);
        }
        if (cls == Short.class || cls == Short.TYPE) {
            return Short.valueOf(str);
        }
        if (cls == Integer.class || cls == Integer.TYPE) {
            return Integer.valueOf(str);
        }
        if (cls == Long.class || cls == Long.TYPE) {
            if (Pattern.compile("(\\d*).[0]").matcher(str).matches()) {
                str = str.replace(".0", "");
            }
            return Long.valueOf(str);
        }
        if (cls == Float.class || cls == Float.TYPE) {
            return Float.valueOf(str);
        }
        if (cls == Double.class || cls == Double.TYPE) {
            return Double.valueOf(str);
        }
        throw new IllegalArgumentException("expected primitive class, but got: " + cls);
    }

    /* renamed from: l */
    public static Object m28449l(Type type, String str) {
        Class cls = type instanceof Class ? (Class) type : null;
        C4627a0.m28389b(type == null || cls != null, "expected primitive class, but got: " + type);
        if (cls == Void.class) {
            return null;
        }
        if (str == null || cls == null || cls.isAssignableFrom(String.class)) {
            return str;
        }
        if (cls != Character.class && cls != Character.TYPE) {
            return (cls == Boolean.class || cls == Boolean.TYPE) ? Boolean.valueOf(str) : cls == C4644l.class ? C4644l.m28457d(str) : cls == BigInteger.class ? new BigInteger(str) : cls == BigDecimal.class ? new BigDecimal(str) : cls.isEnum() ? C4638g.m28427f(cls).m28430b(str).m28464a() : m28448k(cls, str);
        }
        if (str.length() == 1) {
            return Character.valueOf(str.charAt(0));
        }
        throw new IllegalArgumentException("expected type Character/char but got " + cls);
    }

    /* renamed from: m */
    public static Type m28450m(List<Type> list, Type type) {
        if (type instanceof WildcardType) {
            type = C4637f0.m28414c((WildcardType) type);
        }
        while (type instanceof TypeVariable) {
            Type typeM28425n = C4637f0.m28425n(list, (TypeVariable) type);
            if (typeM28425n != null) {
                type = typeM28425n;
            }
            if (type instanceof TypeVariable) {
                type = ((TypeVariable) type).getBounds()[0];
            }
        }
        return type;
    }
}

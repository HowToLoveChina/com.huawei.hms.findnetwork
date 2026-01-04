package p481n1;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;
import p244e1.C9390n;
import p274f1.InterfaceC9641b;

/* renamed from: n1.d */
/* loaded from: classes.dex */
public class C11592d implements Comparable<C11592d> {

    /* renamed from: a */
    public final String f53768a;

    /* renamed from: b */
    public final Method f53769b;

    /* renamed from: c */
    public final Field f53770c;

    /* renamed from: d */
    public int f53771d;

    /* renamed from: e */
    public final Class<?> f53772e;

    /* renamed from: f */
    public final Type f53773f;

    /* renamed from: g */
    public final Class<?> f53774g;

    /* renamed from: h */
    public final boolean f53775h;

    /* renamed from: i */
    public final int f53776i;

    /* renamed from: j */
    public final int f53777j;

    /* renamed from: k */
    public final String f53778k;

    /* renamed from: l */
    public final InterfaceC9641b f53779l;

    /* renamed from: m */
    public final InterfaceC9641b f53780m;

    /* renamed from: n */
    public final boolean f53781n;

    /* renamed from: o */
    public final boolean f53782o;

    /* renamed from: p */
    public final char[] f53783p;

    /* renamed from: q */
    public final boolean f53784q;

    /* renamed from: r */
    public final boolean f53785r;

    /* renamed from: s */
    public final boolean f53786s;

    /* renamed from: t */
    public final String f53787t;

    /* renamed from: u */
    public final String[] f53788u;

    /* renamed from: v */
    public final long f53789v;

    public C11592d(String str, Method method, Field field, Class<?> cls, Type type, int i10, int i11, int i12, InterfaceC9641b interfaceC9641b, InterfaceC9641b interfaceC9641b2, String str2) {
        this(str, method, field, cls, type, i10, i11, i12, interfaceC9641b, interfaceC9641b2, str2, null);
    }

    /* renamed from: h */
    public static boolean m69191h(Type[] typeArr, Map<TypeVariable, Type> map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        boolean z10 = false;
        for (int i10 = 0; i10 < typeArr.length; i10++) {
            Type type = typeArr[i10];
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (m69191h(actualTypeArguments, map)) {
                    typeArr[i10] = C9390n.m58849b(new C11599k(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType()));
                    z10 = true;
                }
            } else if ((type instanceof TypeVariable) && map.containsKey(type)) {
                typeArr[i10] = map.get(type);
                z10 = true;
            }
        }
        return z10;
    }

    /* renamed from: i */
    public static boolean m69192i(Type[] typeArr, TypeVariable[] typeVariableArr, Type[] typeArr2) {
        if (typeArr2 == null || typeVariableArr.length == 0) {
            return false;
        }
        boolean z10 = false;
        for (int i10 = 0; i10 < typeArr.length; i10++) {
            Type type = typeArr[i10];
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (m69192i(actualTypeArguments, typeVariableArr, typeArr2)) {
                    typeArr[i10] = C9390n.m58849b(new C11599k(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType()));
                    z10 = true;
                }
            } else if (type instanceof TypeVariable) {
                for (int i11 = 0; i11 < typeVariableArr.length; i11++) {
                    if (type.equals(typeVariableArr[i11])) {
                        typeArr[i10] = typeArr2[i11];
                        z10 = true;
                    }
                }
            }
        }
        return z10;
    }

    /* renamed from: p */
    public static Type m69193p(Class<?> cls, Type type, Type type2) {
        return m69194q(cls, type, type2, null);
    }

    /* renamed from: q */
    public static Type m69194q(Class<?> cls, Type type, Type type2, Map<TypeVariable, Type> map) {
        TypeVariable<Class<?>>[] typeParameters;
        ParameterizedType parameterizedType;
        if (cls != null && type != null) {
            if (type2 instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                Type typeM69194q = m69194q(cls, type, genericComponentType, map);
                return genericComponentType != typeM69194q ? Array.newInstance(C11603o.m69271P(typeM69194q), 0).getClass() : type2;
            }
            if (!C11603o.m69311o0(type)) {
                return type2;
            }
            if (type2 instanceof TypeVariable) {
                ParameterizedType parameterizedType2 = (ParameterizedType) C11603o.m69280Y(type);
                TypeVariable typeVariable = (TypeVariable) type2;
                TypeVariable<Class<?>>[] typeParameters2 = C11603o.m69271P(parameterizedType2).getTypeParameters();
                for (int i10 = 0; i10 < typeParameters2.length; i10++) {
                    if (typeParameters2[i10].getName().equals(typeVariable.getName())) {
                        return parameterizedType2.getActualTypeArguments()[i10];
                    }
                }
            }
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType3 = (ParameterizedType) type2;
                Type[] actualTypeArguments = parameterizedType3.getActualTypeArguments();
                boolean zM69191h = m69191h(actualTypeArguments, map);
                if (!zM69191h) {
                    if (type instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) type;
                        typeParameters = cls.getTypeParameters();
                    } else if (cls.getGenericSuperclass() instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) cls.getGenericSuperclass();
                        typeParameters = cls.getSuperclass().getTypeParameters();
                    } else {
                        typeParameters = type.getClass().getTypeParameters();
                        parameterizedType = parameterizedType3;
                    }
                    zM69191h = m69192i(actualTypeArguments, typeParameters, parameterizedType.getActualTypeArguments());
                }
                if (zM69191h) {
                    return C9390n.m58849b(new C11599k(actualTypeArguments, parameterizedType3.getOwnerType(), parameterizedType3.getRawType()));
                }
            }
        }
        return type2;
    }

    /* renamed from: s */
    public static Type m69195s(Class<?> cls, Type type, TypeVariable<?> typeVariable) {
        Type[] actualTypeArguments;
        Class<?> cls2 = typeVariable.getGenericDeclaration() instanceof Class ? (Class) typeVariable.getGenericDeclaration() : null;
        if (cls2 == cls) {
            actualTypeArguments = type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments() : null;
        } else {
            Type[] typeArr = null;
            while (cls != null && cls != Object.class && cls != cls2) {
                Type genericSuperclass = cls.getGenericSuperclass();
                if (genericSuperclass instanceof ParameterizedType) {
                    Type[] actualTypeArguments2 = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                    m69192i(actualTypeArguments2, cls.getTypeParameters(), typeArr);
                    typeArr = actualTypeArguments2;
                }
                cls = cls.getSuperclass();
            }
            actualTypeArguments = typeArr;
        }
        if (actualTypeArguments == null || cls2 == null) {
            return null;
        }
        TypeVariable<Class<?>>[] typeParameters = cls2.getTypeParameters();
        for (int i10 = 0; i10 < typeParameters.length; i10++) {
            if (typeVariable.equals(typeParameters[i10])) {
                return actualTypeArguments[i10];
            }
        }
        return null;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(C11592d c11592d) {
        Method method = c11592d.f53769b;
        if (method != null && this.f53769b != null && method.isBridge() && !this.f53769b.isBridge() && c11592d.f53769b.getName().equals(this.f53769b.getName())) {
            return 1;
        }
        int i10 = this.f53771d;
        int i11 = c11592d.f53771d;
        if (i10 < i11) {
            return -1;
        }
        if (i10 > i11) {
            return 1;
        }
        int iCompareTo = this.f53768a.compareTo(c11592d.f53768a);
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        Class<?> clsM69200k = m69200k();
        Class<?> clsM69200k2 = c11592d.m69200k();
        if (clsM69200k != null && clsM69200k2 != null && clsM69200k != clsM69200k2) {
            if (clsM69200k.isAssignableFrom(clsM69200k2)) {
                return -1;
            }
            if (clsM69200k2.isAssignableFrom(clsM69200k)) {
                return 1;
            }
        }
        Field field = this.f53770c;
        boolean z10 = false;
        boolean z11 = field != null && field.getType() == this.f53772e;
        Field field2 = c11592d.f53770c;
        if (field2 != null && field2.getType() == c11592d.f53772e) {
            z10 = true;
        }
        if (z11 && !z10) {
            return 1;
        }
        if (z10 && !z11) {
            return -1;
        }
        if (c11592d.f53772e.isPrimitive() && !this.f53772e.isPrimitive()) {
            return 1;
        }
        if (this.f53772e.isPrimitive() && !c11592d.f53772e.isPrimitive()) {
            return -1;
        }
        if (c11592d.f53772e.getName().startsWith("java.") && !this.f53772e.getName().startsWith("java.")) {
            return 1;
        }
        if (!this.f53772e.getName().startsWith("java.") || c11592d.f53772e.getName().startsWith("java.")) {
            return this.f53772e.getName().compareTo(c11592d.f53772e.getName());
        }
        return -1;
    }

    /* renamed from: b */
    public char[] m69197b() {
        int length = this.f53768a.length();
        char[] cArr = new char[length + 3];
        String str = this.f53768a;
        str.getChars(0, str.length(), cArr, 1);
        cArr[0] = '\"';
        cArr[length + 1] = '\"';
        cArr[length + 2] = ':';
        return cArr;
    }

    /* renamed from: e */
    public Object m69198e(Object obj) throws IllegalAccessException, InvocationTargetException {
        Method method = this.f53769b;
        return method != null ? method.invoke(obj, new Object[0]) : this.f53770c.get(obj);
    }

    /* renamed from: f */
    public InterfaceC9641b m69199f() {
        InterfaceC9641b interfaceC9641b = this.f53779l;
        return interfaceC9641b != null ? interfaceC9641b : this.f53780m;
    }

    /* renamed from: k */
    public Class<?> m69200k() {
        Method method = this.f53769b;
        if (method != null) {
            return method.getDeclaringClass();
        }
        Field field = this.f53770c;
        if (field != null) {
            return field.getDeclaringClass();
        }
        return null;
    }

    /* renamed from: r */
    public String m69201r() {
        return this.f53787t;
    }

    /* renamed from: t */
    public Member m69202t() {
        Method method = this.f53769b;
        return method != null ? method : this.f53770c;
    }

    public String toString() {
        return this.f53768a;
    }

    /* renamed from: u */
    public final long m69203u(String str, InterfaceC9641b interfaceC9641b) {
        return (interfaceC9641b == null || interfaceC9641b.name().length() == 0) ? C11603o.m69259J(str) : C11603o.m69261K(str);
    }

    /* renamed from: v */
    public void m69204v(Object obj, Object obj2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = this.f53769b;
        if (method != null) {
            method.invoke(obj, obj2);
        } else {
            this.f53770c.set(obj, obj2);
        }
    }

    /* renamed from: w */
    public void m69205w() throws SecurityException {
        Method method = this.f53769b;
        if (method != null) {
            C11603o.m69264L0(method);
        } else {
            C11603o.m69264L0(this.f53770c);
        }
    }

    public C11592d(String str, Class<?> cls, Class<?> cls2, Type type, Field field, int i10, int i11, int i12) {
        this.f53771d = 0;
        i10 = i10 < 0 ? 0 : i10;
        this.f53768a = str;
        this.f53774g = cls;
        this.f53772e = cls2;
        this.f53773f = type;
        this.f53769b = null;
        this.f53770c = field;
        this.f53771d = i10;
        this.f53776i = i11;
        this.f53777j = i12;
        this.f53784q = cls2.isEnum();
        if (field != null) {
            int modifiers = field.getModifiers();
            this.f53781n = true;
            this.f53782o = Modifier.isTransient(modifiers);
        } else {
            this.f53782o = false;
            this.f53781n = false;
        }
        this.f53783p = m69197b();
        if (field != null) {
            C11603o.m69264L0(field);
        }
        this.f53778k = "";
        InterfaceC9641b interfaceC9641b = field == null ? null : (InterfaceC9641b) C11603o.m69267N(field, InterfaceC9641b.class);
        this.f53779l = interfaceC9641b;
        this.f53780m = null;
        this.f53775h = false;
        this.f53785r = false;
        this.f53786s = false;
        this.f53787t = null;
        this.f53788u = new String[0];
        this.f53789v = m69203u(str, interfaceC9641b);
    }

    public C11592d(String str, Method method, Field field, Class<?> cls, Type type, int i10, int i11, int i12, InterfaceC9641b interfaceC9641b, InterfaceC9641b interfaceC9641b2, String str2, Map<TypeVariable, Type> map) {
        boolean zJsonDirect;
        boolean zIsFinal;
        Class<?> cls2;
        Type type2;
        Type typeM69195s;
        Class<?> cls3;
        Class<?> cls4;
        Type genericReturnType;
        Class<?> returnType;
        Type type3;
        boolean z10 = false;
        this.f53771d = 0;
        if (field != null) {
            String name = field.getName();
            if (name.equals(str)) {
                str = name;
            }
        }
        i10 = i10 < 0 ? 0 : i10;
        this.f53768a = str;
        this.f53769b = method;
        this.f53770c = field;
        this.f53771d = i10;
        this.f53776i = i11;
        this.f53777j = i12;
        this.f53779l = interfaceC9641b;
        this.f53780m = interfaceC9641b2;
        if (field != null) {
            int modifiers = field.getModifiers();
            this.f53781n = (modifiers & 1) != 0 || method == null;
            this.f53782o = Modifier.isTransient(modifiers) || C11603o.m69329x0(method);
        } else {
            this.f53781n = false;
            this.f53782o = C11603o.m69329x0(method);
        }
        if (str2 != null && str2.length() > 0) {
            this.f53778k = str2;
        } else {
            this.f53778k = "";
        }
        InterfaceC9641b interfaceC9641bM69199f = m69199f();
        this.f53789v = m69203u(str, interfaceC9641bM69199f);
        if (interfaceC9641bM69199f != null) {
            String str3 = interfaceC9641bM69199f.format();
            str = str3.trim().length() != 0 ? str3 : null;
            zJsonDirect = interfaceC9641bM69199f.jsonDirect();
            this.f53786s = interfaceC9641bM69199f.unwrapped();
            this.f53788u = interfaceC9641bM69199f.alternateNames();
        } else {
            this.f53786s = false;
            this.f53788u = new String[0];
            zJsonDirect = false;
        }
        this.f53787t = str;
        this.f53783p = m69197b();
        if (method != null) {
            C11603o.m69264L0(method);
        }
        if (field != null) {
            C11603o.m69264L0(field);
        }
        if (method != null) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1) {
                cls4 = parameterTypes[0];
                type3 = method.getGenericParameterTypes()[0];
            } else if (parameterTypes.length == 2 && (cls3 = parameterTypes[0]) == String.class && parameterTypes[1] == Object.class) {
                cls4 = cls3;
                type3 = cls3;
            } else {
                zIsFinal = true;
                returnType = method.getReturnType();
                genericReturnType = method.getGenericReturnType();
                this.f53774g = method.getDeclaringClass();
                cls2 = returnType;
                type2 = genericReturnType;
            }
            zIsFinal = false;
            returnType = cls4;
            genericReturnType = type3;
            this.f53774g = method.getDeclaringClass();
            cls2 = returnType;
            type2 = genericReturnType;
        } else {
            Class<?> type4 = field.getType();
            Type genericType = field.getGenericType();
            this.f53774g = field.getDeclaringClass();
            zIsFinal = Modifier.isFinal(field.getModifiers());
            cls2 = type4;
            type2 = genericType;
        }
        this.f53775h = zIsFinal;
        if (zJsonDirect && cls2 == String.class) {
            z10 = true;
        }
        this.f53785r = z10;
        if (cls != null && cls2 == Object.class && (type2 instanceof TypeVariable) && (typeM69195s = m69195s(cls, type, (TypeVariable) type2)) != null) {
            this.f53772e = C11603o.m69271P(typeM69195s);
            this.f53773f = typeM69195s;
            this.f53784q = cls2.isEnum();
            return;
        }
        boolean z11 = type2 instanceof Class;
        Class<?> cls5 = cls2;
        Type type5 = type2;
        if (!z11) {
            Type typeM69194q = m69194q(cls, type == null ? cls : type, type2, map);
            Class<?> clsM69271P = cls2;
            if (typeM69194q != type2) {
                if (typeM69194q instanceof ParameterizedType) {
                    clsM69271P = C11603o.m69271P(typeM69194q);
                } else {
                    clsM69271P = cls2;
                    if (typeM69194q instanceof Class) {
                        clsM69271P = C11603o.m69271P(typeM69194q);
                    }
                }
            }
            type5 = typeM69194q;
            cls5 = clsM69271P;
        }
        this.f53773f = type5;
        this.f53772e = cls5;
        this.f53784q = cls5.isEnum();
    }
}

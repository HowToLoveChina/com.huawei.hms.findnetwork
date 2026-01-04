package p481n1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p244e1.C9380d;
import p244e1.EnumC9389m;
import p274f1.InterfaceC9640a;
import p274f1.InterfaceC9641b;
import p274f1.InterfaceC9643d;

/* renamed from: n1.i */
/* loaded from: classes.dex */
public class C11597i {

    /* renamed from: a */
    public final Class<?> f53814a;

    /* renamed from: b */
    public final Class<?> f53815b;

    /* renamed from: c */
    public final Constructor<?> f53816c;

    /* renamed from: d */
    public final Constructor<?> f53817d;

    /* renamed from: e */
    public final Method f53818e;

    /* renamed from: f */
    public final Method f53819f;

    /* renamed from: g */
    public final int f53820g;

    /* renamed from: h */
    public final C11592d[] f53821h;

    /* renamed from: i */
    public final C11592d[] f53822i;

    /* renamed from: j */
    public final int f53823j;

    /* renamed from: k */
    public final InterfaceC9643d f53824k;

    /* renamed from: l */
    public final String f53825l;

    /* renamed from: m */
    public final String f53826m;

    /* renamed from: n */
    public String[] f53827n;

    /* renamed from: o */
    public Type[] f53828o;

    /* renamed from: p */
    public String[] f53829p;

    /* renamed from: q */
    public boolean f53830q;

    /* renamed from: r */
    public Constructor<?> f53831r;

    public C11597i(Class<?> cls, Class<?> cls2, Constructor<?> constructor, Constructor<?> constructor2, Method method, Method method2, InterfaceC9643d interfaceC9643d, List<C11592d> list) {
        InterfaceC9641b interfaceC9641b;
        this.f53814a = cls;
        this.f53815b = cls2;
        this.f53816c = constructor;
        this.f53817d = constructor2;
        this.f53818e = method;
        this.f53823j = C11603o.m69291e0(cls);
        this.f53819f = method2;
        this.f53824k = interfaceC9643d;
        if (interfaceC9643d != null) {
            String strTypeName = interfaceC9643d.typeName();
            String strTypeKey = interfaceC9643d.typeKey();
            this.f53826m = strTypeKey.length() <= 0 ? null : strTypeKey;
            if (strTypeName.length() != 0) {
                this.f53825l = strTypeName;
            } else {
                this.f53825l = cls.getName();
            }
            String[] strArrOrders = interfaceC9643d.orders();
            this.f53827n = strArrOrders.length == 0 ? null : strArrOrders;
        } else {
            this.f53825l = cls.getName();
            this.f53826m = null;
            this.f53827n = null;
        }
        C11592d[] c11592dArr = new C11592d[list.size()];
        this.f53821h = c11592dArr;
        list.toArray(c11592dArr);
        C11592d[] c11592dArr2 = new C11592d[c11592dArr.length];
        int i10 = 0;
        if (this.f53827n != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
            for (C11592d c11592d : c11592dArr) {
                linkedHashMap.put(c11592d.f53768a, c11592d);
            }
            int i11 = 0;
            for (String str : this.f53827n) {
                C11592d c11592d2 = (C11592d) linkedHashMap.get(str);
                if (c11592d2 != null) {
                    c11592dArr2[i11] = c11592d2;
                    linkedHashMap.remove(str);
                    i11++;
                }
            }
            Iterator it = linkedHashMap.values().iterator();
            while (it.hasNext()) {
                c11592dArr2[i11] = (C11592d) it.next();
                i11++;
            }
        } else {
            System.arraycopy(c11592dArr, 0, c11592dArr2, 0, c11592dArr.length);
            Arrays.sort(c11592dArr2);
        }
        this.f53822i = Arrays.equals(this.f53821h, c11592dArr2) ? this.f53821h : c11592dArr2;
        if (constructor != null) {
            this.f53820g = constructor.getParameterTypes().length;
        } else if (method != null) {
            this.f53820g = method.getParameterTypes().length;
        } else {
            this.f53820g = 0;
        }
        if (constructor2 != null) {
            this.f53828o = constructor2.getParameterTypes();
            boolean zM69319s0 = C11603o.m69319s0(cls);
            this.f53830q = zM69319s0;
            if (!zM69319s0) {
                if (this.f53828o.length == this.f53821h.length) {
                    while (true) {
                        Type[] typeArr = this.f53828o;
                        if (i10 >= typeArr.length) {
                            return;
                        }
                        if (typeArr[i10] != this.f53821h[i10].f53772e) {
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
                this.f53829p = C11590b.m69189f(constructor2);
                return;
            }
            this.f53829p = C11603o.m69281Z(cls);
            try {
                this.f53831r = cls.getConstructor(new Class[0]);
            } catch (Throwable unused) {
            }
            Annotation[][] annotationArrM69287c0 = C11603o.m69287c0(constructor2);
            for (int i12 = 0; i12 < this.f53829p.length && i12 < annotationArrM69287c0.length; i12++) {
                Annotation[] annotationArr = annotationArrM69287c0[i12];
                int length = annotationArr.length;
                int i13 = 0;
                while (true) {
                    if (i13 >= length) {
                        interfaceC9641b = null;
                        break;
                    }
                    Annotation annotation = annotationArr[i13];
                    if (annotation instanceof InterfaceC9641b) {
                        interfaceC9641b = (InterfaceC9641b) annotation;
                        break;
                    }
                    i13++;
                }
                if (interfaceC9641b != null) {
                    String strName = interfaceC9641b.name();
                    if (strName.length() > 0) {
                        this.f53829p[i12] = strName;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m69222a(List<C11592d> list, C11592d c11592d) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C11592d c11592d2 = list.get(size);
            if (c11592d2.f53768a.equals(c11592d.f53768a) && (!c11592d2.f53775h || c11592d.f53775h)) {
                if (c11592d2.f53772e.isAssignableFrom(c11592d.f53772e)) {
                    list.set(size, c11592d);
                    return true;
                }
                if (c11592d2.compareTo(c11592d) >= 0) {
                    return false;
                }
                list.set(size, c11592d);
                return true;
            }
        }
        list.add(c11592d);
        return true;
    }

    /* renamed from: b */
    public static C11597i m69223b(Class<?> cls, Type type, EnumC9389m enumC9389m) {
        return m69224c(cls, type, enumC9389m, false, C11603o.f53866b, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x04f0  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x06e9  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0888  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x08a9  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x08b5  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x08b9  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x096f  */
    /* JADX WARN: Removed duplicated region for block: B:407:0x0987  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x099c  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x09a3  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x09cd  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x09d0  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x0a72  */
    /* JADX WARN: Removed duplicated region for block: B:434:0x0a8a  */
    /* JADX WARN: Removed duplicated region for block: B:489:0x0bfc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01e0  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static p481n1.C11597i m69224c(java.lang.Class<?> r57, java.lang.reflect.Type r58, p244e1.EnumC9389m r59, boolean r60, boolean r61, boolean r62) {
        /*
            Method dump skipped, instructions count: 3242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p481n1.C11597i.m69224c(java.lang.Class, java.lang.reflect.Type, e1.m, boolean, boolean, boolean):n1.i");
    }

    /* renamed from: d */
    public static Map<TypeVariable, Type> m69225d(Class<?> cls) {
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap map = null;
        if (superclass == null) {
            return null;
        }
        while (true) {
            Class<? super Object> cls2 = superclass;
            Class<?> cls3 = cls;
            cls = cls2;
            if (cls == null || cls == Object.class) {
                break;
            }
            if (cls3.getGenericSuperclass() instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) cls3.getGenericSuperclass()).getActualTypeArguments();
                TypeVariable<Class<?>>[] typeParameters = cls.getTypeParameters();
                for (int i10 = 0; i10 < actualTypeArguments.length; i10++) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    if (map.containsKey(actualTypeArguments[i10])) {
                        map.put(typeParameters[i10], map.get(actualTypeArguments[i10]));
                    } else {
                        map.put(typeParameters[i10], actualTypeArguments[i10]);
                    }
                }
            }
            superclass = cls.getSuperclass();
        }
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0019 A[EDGE_INSN: B:44:0x0019->B:6:0x0019 BREAK  A[LOOP:1: B:20:0x0055->B:45:?]] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m69226e(java.lang.Class<?> r20, java.lang.reflect.Type r21, p244e1.EnumC9389m r22, java.util.List<p481n1.C11592d> r23, java.lang.reflect.Field[] r24) {
        /*
            r0 = r22
            r1 = r24
            java.util.Map r15 = m69225d(r20)
            int r14 = r1.length
            r16 = 0
            r13 = r16
        Ld:
            if (r13 >= r14) goto Ldc
            r5 = r1[r13]
            int r2 = r5.getModifiers()
            r3 = r2 & 8
            if (r3 == 0) goto L21
        L19:
            r2 = r23
            r17 = r13
            r18 = r14
            goto Ld6
        L21:
            r2 = r2 & 16
            if (r2 == 0) goto L51
            java.lang.Class r2 = r5.getType()
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            boolean r3 = r3.isAssignableFrom(r2)
            if (r3 != 0) goto L51
            java.lang.Class<java.util.Collection> r3 = java.util.Collection.class
            boolean r3 = r3.isAssignableFrom(r2)
            if (r3 != 0) goto L51
            java.lang.Class<java.util.concurrent.atomic.AtomicLong> r3 = java.util.concurrent.atomic.AtomicLong.class
            boolean r3 = r3.equals(r2)
            if (r3 != 0) goto L51
            java.lang.Class<java.util.concurrent.atomic.AtomicInteger> r3 = java.util.concurrent.atomic.AtomicInteger.class
            boolean r3 = r3.equals(r2)
            if (r3 != 0) goto L51
            java.lang.Class<java.util.concurrent.atomic.AtomicBoolean> r3 = java.util.concurrent.atomic.AtomicBoolean.class
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L19
        L51:
            java.util.Iterator r2 = r23.iterator()
        L55:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L6e
            java.lang.Object r3 = r2.next()
            n1.d r3 = (p481n1.C11592d) r3
            java.lang.String r3 = r3.f53768a
            java.lang.String r4 = r5.getName()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L55
            goto L19
        L6e:
            java.lang.String r2 = r5.getName()
            java.lang.Class<f1.b> r3 = p274f1.InterfaceC9641b.class
            java.lang.annotation.Annotation r3 = p481n1.C11603o.m69267N(r5, r3)
            r12 = r3
            f1.b r12 = (p274f1.InterfaceC9641b) r12
            if (r12 == 0) goto Laa
            boolean r3 = r12.deserialize()
            if (r3 != 0) goto L84
            goto L19
        L84:
            int r3 = r12.ordinal()
            j1.e1[] r4 = r12.serialzeFeatures()
            int r4 = p381j1.EnumC10653e1.m65243h(r4)
            h1.b[] r6 = r12.parseFeatures()
            int r6 = p323h1.EnumC10078b.m62750f(r6)
            java.lang.String r7 = r12.name()
            int r7 = r7.length()
            if (r7 == 0) goto La6
            java.lang.String r2 = r12.name()
        La6:
            r8 = r3
            r9 = r4
            r10 = r6
            goto Lae
        Laa:
            r8 = r16
            r9 = r8
            r10 = r9
        Lae:
            if (r0 == 0) goto Lb4
            java.lang.String r2 = r0.m58848b(r2)
        Lb4:
            r3 = r2
            n1.d r11 = new n1.d
            r17 = 0
            r18 = 0
            r4 = 0
            r2 = r11
            r6 = r20
            r7 = r21
            r19 = r11
            r11 = r17
            r17 = r13
            r13 = r18
            r18 = r14
            r14 = r15
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r2 = r23
            r3 = r19
            m69222a(r2, r3)
        Ld6:
            int r13 = r17 + 1
            r14 = r18
            goto Ld
        Ldc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p481n1.C11597i.m69226e(java.lang.Class, java.lang.reflect.Type, e1.m, java.util.List, java.lang.reflect.Field[]):void");
    }

    /* renamed from: f */
    public static Class<?> m69227f(Class<?> cls, InterfaceC9643d interfaceC9643d) {
        Class<?> clsBuilder;
        if (cls != null && cls.getName().equals("org.springframework.security.web.savedrequest.DefaultSavedRequest")) {
            return C11603o.m69333z0("org.springframework.security.web.savedrequest.DefaultSavedRequest$Builder");
        }
        if (interfaceC9643d == null || (clsBuilder = interfaceC9643d.builder()) == Void.class) {
            return null;
        }
        return clsBuilder;
    }

    /* renamed from: g */
    public static Constructor<?> m69228g(Constructor[] constructorArr) {
        Constructor constructor = null;
        for (Constructor constructor2 : constructorArr) {
            if (((InterfaceC9640a) constructor2.getAnnotation(InterfaceC9640a.class)) != null) {
                if (constructor != null) {
                    throw new C9380d("multi-JSONCreator");
                }
                constructor = constructor2;
            }
        }
        if (constructor != null) {
            return constructor;
        }
        for (Constructor constructor3 : constructorArr) {
            Annotation[][] annotationArrM69287c0 = C11603o.m69287c0(constructor3);
            if (annotationArrM69287c0.length != 0) {
                int length = annotationArrM69287c0.length;
                int i10 = 0;
                while (true) {
                    if (i10 < length) {
                        for (Annotation annotation : annotationArrM69287c0[i10]) {
                            if (annotation instanceof InterfaceC9641b) {
                                break;
                            }
                        }
                    } else {
                        if (constructor != null) {
                            throw new C9380d("multi-JSONCreator");
                        }
                        constructor = constructor3;
                    }
                    i10++;
                }
            }
        }
        return constructor;
    }

    /* renamed from: h */
    public static Constructor<?> m69229h(Class<?> cls, Constructor<?>[] constructorArr) {
        Constructor<?> constructor = null;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        int length = constructorArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            Constructor<?> constructor2 = constructorArr[i10];
            if (constructor2.getParameterTypes().length == 0) {
                constructor = constructor2;
                break;
            }
            i10++;
        }
        if (constructor != null || !cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
            return constructor;
        }
        for (Constructor<?> constructor3 : constructorArr) {
            Class<?>[] parameterTypes = constructor3.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0].equals(cls.getDeclaringClass())) {
                return constructor3;
            }
        }
        return constructor;
    }

    /* renamed from: i */
    public static Method m69230i(Class<?> cls, Method[] methodArr, boolean z10) {
        Method method = null;
        for (Method method2 : methodArr) {
            if (Modifier.isStatic(method2.getModifiers()) && cls.isAssignableFrom(method2.getReturnType()) && ((InterfaceC9640a) C11603o.m69269O(method2, InterfaceC9640a.class)) != null) {
                if (method != null) {
                    throw new C9380d("multi-JSONCreator");
                }
                method = method2;
            }
        }
        if (method != null || !z10) {
            return method;
        }
        for (Method method3 : methodArr) {
            if (C11603o.m69317r0(method3)) {
                return method3;
            }
        }
        return method;
    }

    /* renamed from: j */
    public static C11592d m69231j(List<C11592d> list, String str) {
        for (C11592d c11592d : list) {
            if (c11592d.f53768a.equals(str)) {
                return c11592d;
            }
            Field field = c11592d.f53770c;
            if (field != null && c11592d.m69199f() != null && field.getName().equals(str)) {
                return c11592d;
            }
        }
        return null;
    }
}

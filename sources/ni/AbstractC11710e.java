package ni;

import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.C4637f0;
import com.huawei.cloud.base.util.C4638g;
import com.huawei.cloud.base.util.C4642j;
import com.huawei.cloud.base.util.C4645m;
import com.huawei.cloud.base.util.C4646n;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import ni.InterfaceC11711f;

/* renamed from: ni.e */
/* loaded from: classes.dex */
public abstract class AbstractC11710e {

    /* renamed from: a */
    public static final Lock f54190a = new ReentrantLock();

    /* renamed from: b */
    public static WeakHashMap<Class<?>, Field> f54191b = new WeakHashMap<>();

    /* renamed from: ni.e$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f54192a;

        static {
            int[] iArr = new int[EnumC11713h.values().length];
            f54192a = iArr;
            try {
                iArr[EnumC11713h.START_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f54192a[EnumC11713h.START_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f54192a[EnumC11713h.END_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f54192a[EnumC11713h.FIELD_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f54192a[EnumC11713h.END_OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f54192a[EnumC11713h.VALUE_TRUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f54192a[EnumC11713h.VALUE_FALSE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f54192a[EnumC11713h.VALUE_NUMBER_FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f54192a[EnumC11713h.VALUE_NUMBER_INT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f54192a[EnumC11713h.VALUE_STRING.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f54192a[EnumC11713h.VALUE_NULL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* renamed from: d */
    public static Field m69857d(Class<?> cls) {
        Field field = null;
        if (cls == null) {
            return null;
        }
        Lock lock = f54190a;
        lock.lock();
        try {
            if (f54191b.containsKey(cls)) {
                Field field2 = f54191b.get(cls);
                lock.unlock();
                return field2;
            }
            Iterator<C4645m> it = C4638g.m28427f(cls).m28431c().iterator();
            while (it.hasNext()) {
                Field fieldM28465b = it.next().m28465b();
                InterfaceC11711f interfaceC11711f = (InterfaceC11711f) fieldM28465b.getAnnotation(InterfaceC11711f.class);
                if (interfaceC11711f != null) {
                    C4627a0.m28390c(field == null, "Class contains more than one field with @JsonPolymorphicTypeMap annotation: %s", cls);
                    C4627a0.m28390c(C4642j.m28442e(fieldM28465b.getType()), "Field which has the @JsonPolymorphicTypeMap, %s, is not a supported type: %s", cls, fieldM28465b.getType());
                    InterfaceC11711f.a[] aVarArrTypeDefinitions = interfaceC11711f.typeDefinitions();
                    HashSet hashSet = new HashSet();
                    C4627a0.m28389b(aVarArrTypeDefinitions.length > 0, "@JsonPolymorphicTypeMap must have at least one @TypeDef");
                    for (InterfaceC11711f.a aVar : aVarArrTypeDefinitions) {
                        C4627a0.m28390c(hashSet.add(aVar.key()), "Class contains two @TypeDef annotations with identical key: %s", aVar.key());
                    }
                    field = fieldM28465b;
                }
            }
            f54191b.put(cls, field);
            return field;
        } finally {
            f54190a.unlock();
        }
    }

    /* renamed from: A */
    public final Object m69858A(Type type, Class<?> cls) throws IOException {
        if (cls == null || cls.isAssignableFrom(BigDecimal.class)) {
            return mo69872g();
        }
        if (cls == Double.class || cls == Double.TYPE) {
            return Double.valueOf(mo69873h());
        }
        if (cls == Float.class || cls == Float.TYPE) {
            return Float.valueOf(mo69875j());
        }
        throw new IllegalArgumentException("expected numeric type but got " + type);
    }

    /* renamed from: B */
    public final Object m69859B(Field field, Type type, Class<?> cls) throws IOException {
        C4627a0.m28389b(field == null || field.getAnnotation(InterfaceC11712g.class) == null, "number type formatted as a JSON number cannot use @JsonString annotation");
        return cls == BigInteger.class ? mo69868b() : (cls == Byte.class || cls == Byte.TYPE) ? Byte.valueOf(mo69869c()) : (cls == Long.class || cls == Long.TYPE) ? Long.valueOf(mo69877l()) : (cls == Integer.class || cls == Integer.TYPE) ? Integer.valueOf(mo69876k()) : (cls == Short.class || cls == Short.TYPE) ? Short.valueOf(mo69879n()) : m69858A(type, cls);
    }

    /* renamed from: C */
    public final Object m69860C(Field field, Type type, ArrayList<Type> arrayList, Object obj, C11706a c11706a, boolean z10, Class<?> cls) throws IOException {
        C4627a0.m28390c(!C4637f0.m28421j(type), "expected object or map type but got %s", type);
        Class<?> clsRef = null;
        Field fieldM69857d = z10 ? m69857d(cls) : null;
        boolean z11 = cls != null && C4637f0.m28422k(cls, Map.class);
        Object objM69878m = m69878m(fieldM69857d, obj, c11706a, z11, cls);
        int size = arrayList.size();
        if (type != null) {
            arrayList.add(type);
        }
        if (z11 && !C4646n.class.isAssignableFrom(cls)) {
            Type typeM28416e = Map.class.isAssignableFrom(cls) ? C4637f0.m28416e(type) : null;
            if (typeM28416e != null) {
                m69890y(field, (Map) objM69878m, typeM28416e, arrayList, c11706a);
                return objM69878m;
            }
        }
        m69885t(arrayList, objM69878m, c11706a);
        if (type != null) {
            arrayList.remove(size);
        }
        if (fieldM69857d == null) {
            return objM69878m;
        }
        Object obj2 = ((C11707b) objM69878m).get(fieldM69857d.getName());
        C4627a0.m28389b(obj2 != null, "No value specified for @JsonPolymorphicTypeMap field");
        String string = obj2.toString();
        InterfaceC11711f.a[] aVarArrTypeDefinitions = ((InterfaceC11711f) fieldM69857d.getAnnotation(InterfaceC11711f.class)).typeDefinitions();
        int length = aVarArrTypeDefinitions.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            InterfaceC11711f.a aVar = aVarArrTypeDefinitions[i10];
            if (aVar.key().equals(string)) {
                clsRef = aVar.ref();
                break;
            }
            i10++;
        }
        C4627a0.m28389b(clsRef != null, "No TypeDef annotation found with key: " + string);
        AbstractC11708c abstractC11708cMo69874i = mo69874i();
        AbstractC11710e abstractC11710eMo69832e = abstractC11708cMo69874i.mo69832e(abstractC11708cMo69874i.m69835h(objM69878m));
        abstractC11710eMo69832e.m69865H();
        return abstractC11710eMo69832e.m69862E(field, clsRef, arrayList, null, null, false);
    }

    /* renamed from: D */
    public final Object m69861D(Field field, Type type, Class<?> cls) throws IOException {
        String lowerCase = mo69880o().trim().toLowerCase(Locale.US);
        if ((cls != Float.TYPE && cls != Float.class && cls != Double.TYPE && cls != Double.class) || (!lowerCase.equals("nan") && !lowerCase.equals("infinity") && !lowerCase.equals("-infinity"))) {
            C4627a0.m28389b((cls != null && Number.class.isAssignableFrom(cls) && (field == null || field.getAnnotation(InterfaceC11712g.class) == null)) ? false : true, "number field formatted as a JSON string must use the @JsonString annotation");
        }
        return C4642j.m28449l(type, mo69880o());
    }

    /* renamed from: E */
    public final Object m69862E(Field field, Type type, ArrayList<Type> arrayList, Object obj, C11706a c11706a, boolean z10) throws IOException {
        Type typeM28450m = C4642j.m28450m(arrayList, type);
        Class<?> clsM28418g = typeM28450m instanceof Class ? (Class) typeM28450m : null;
        if (typeM28450m instanceof ParameterizedType) {
            clsM28418g = C4637f0.m28418g((ParameterizedType) typeM28450m);
        }
        Class<?> cls = clsM28418g;
        if (cls == Void.class) {
            mo69863F();
            return null;
        }
        EnumC11713h enumC11713hMo69871f = mo69871f();
        try {
            switch (a.f54192a[mo69871f().ordinal()]) {
                case 1:
                case 4:
                case 5:
                    return m69860C(field, typeM28450m, arrayList, obj, c11706a, z10, cls);
                case 2:
                case 3:
                    return m69889x(field, typeM28450m, arrayList, obj, c11706a, cls);
                case 6:
                case 7:
                    C4627a0.m28390c(typeM28450m == null || cls == Boolean.TYPE || (cls != null && cls.isAssignableFrom(Boolean.class)), "expected type Boolean or boolean but got %s", typeM28450m);
                    return enumC11713hMo69871f == EnumC11713h.VALUE_TRUE ? Boolean.TRUE : Boolean.FALSE;
                case 8:
                case 9:
                    return m69859B(field, typeM28450m, cls);
                case 10:
                    return m69861D(field, typeM28450m, cls);
                case 11:
                    return m69891z(arrayList, typeM28450m, cls);
                default:
                    throw new IllegalArgumentException("unexpected JSON node type: " + enumC11713hMo69871f);
            }
        } catch (IllegalArgumentException e10) {
            StringBuilder sb2 = new StringBuilder();
            String strMo69870e = mo69870e();
            if (strMo69870e != null) {
                sb2.append("key ");
                sb2.append(strMo69870e);
            }
            if (field != null) {
                if (strMo69870e != null) {
                    sb2.append(", ");
                }
                sb2.append("field ");
                sb2.append(field);
            }
            throw new IllegalArgumentException(sb2.toString(), e10);
        }
    }

    /* renamed from: F */
    public abstract AbstractC11710e mo69863F() throws IOException;

    /* renamed from: G */
    public final String m69864G(Set<String> set) throws IOException {
        EnumC11713h enumC11713hM69866I = m69866I();
        while (enumC11713hM69866I == EnumC11713h.FIELD_NAME) {
            String strMo69880o = mo69880o();
            mo69881p();
            if (set.contains(strMo69880o)) {
                return strMo69880o;
            }
            mo69863F();
            enumC11713hM69866I = mo69881p();
        }
        return null;
    }

    /* renamed from: H */
    public final EnumC11713h m69865H() throws IOException {
        EnumC11713h enumC11713hMo69871f = mo69871f();
        if (enumC11713hMo69871f == null) {
            enumC11713hMo69871f = mo69881p();
        }
        C4627a0.m28389b(enumC11713hMo69871f != null, "no JSON input found");
        return enumC11713hMo69871f;
    }

    /* renamed from: I */
    public final EnumC11713h m69866I() throws IOException {
        EnumC11713h enumC11713hM69865H = m69865H();
        int i10 = a.f54192a[enumC11713hM69865H.ordinal()];
        boolean z10 = true;
        if (i10 != 1) {
            return i10 != 2 ? enumC11713hM69865H : mo69881p();
        }
        EnumC11713h enumC11713hMo69881p = mo69881p();
        if (enumC11713hMo69881p != EnumC11713h.FIELD_NAME && enumC11713hMo69881p != EnumC11713h.END_OBJECT) {
            z10 = false;
        }
        C4627a0.m28389b(z10, enumC11713hMo69881p);
        return enumC11713hMo69881p;
    }

    /* renamed from: a */
    public abstract void mo69867a() throws IOException;

    /* renamed from: b */
    public abstract BigInteger mo69868b() throws IOException;

    /* renamed from: c */
    public abstract byte mo69869c() throws IOException;

    /* renamed from: e */
    public abstract String mo69870e() throws IOException;

    /* renamed from: f */
    public abstract EnumC11713h mo69871f();

    /* renamed from: g */
    public abstract BigDecimal mo69872g() throws IOException;

    /* renamed from: h */
    public abstract double mo69873h() throws IOException;

    /* renamed from: i */
    public abstract AbstractC11708c mo69874i();

    /* renamed from: j */
    public abstract float mo69875j() throws IOException;

    /* renamed from: k */
    public abstract int mo69876k() throws IOException;

    /* renamed from: l */
    public abstract long mo69877l() throws IOException;

    /* renamed from: m */
    public final Object m69878m(Field field, Object obj, C11706a c11706a, boolean z10, Class<?> cls) {
        return field != null ? new C11707b() : (z10 || cls == null) ? C4642j.m28446i(cls) : C4637f0.m28424m(cls);
    }

    /* renamed from: n */
    public abstract short mo69879n() throws IOException;

    /* renamed from: o */
    public abstract String mo69880o() throws IOException;

    /* renamed from: p */
    public abstract EnumC11713h mo69881p() throws IOException;

    /* renamed from: q */
    public final <T> T m69882q(Class<T> cls, C11706a c11706a) throws IOException {
        return (T) m69884s(cls, false, c11706a);
    }

    /* renamed from: r */
    public Object m69883r(Type type, boolean z10) throws IOException {
        return m69884s(type, z10, null);
    }

    /* renamed from: s */
    public Object m69884s(Type type, boolean z10, C11706a c11706a) throws IOException {
        try {
            if (!Void.class.equals(type)) {
                m69865H();
            }
            Object objM69862E = m69862E(null, type, new ArrayList<>(), null, c11706a, true);
            if (z10) {
                mo69867a();
            }
            return objM69862E;
        } catch (Throwable th2) {
            if (z10) {
                mo69867a();
            }
            throw th2;
        }
    }

    /* renamed from: t */
    public final void m69885t(ArrayList<Type> arrayList, Object obj, C11706a c11706a) throws IOException {
        if (obj instanceof C11707b) {
            ((C11707b) obj).setFactory(mo69874i());
        }
        EnumC11713h enumC11713hM69866I = m69866I();
        Class<?> cls = obj.getClass();
        C4638g c4638gM28427f = C4638g.m28427f(cls);
        boolean zIsAssignableFrom = C4646n.class.isAssignableFrom(cls);
        if (!zIsAssignableFrom && Map.class.isAssignableFrom(cls)) {
            m69890y(null, (Map) obj, C4637f0.m28416e(cls), arrayList, c11706a);
            return;
        }
        while (enumC11713hM69866I == EnumC11713h.FIELD_NAME) {
            String strMo69880o = mo69880o();
            mo69881p();
            C4645m c4645mM28430b = c4638gM28427f.m28430b(strMo69880o);
            if (c4645mM28430b != null) {
                if (c4645mM28430b.m28470h() && !c4645mM28430b.m28471i()) {
                    throw new IllegalArgumentException("final array/object fields are not supported");
                }
                Field fieldM28465b = c4645mM28430b.m28465b();
                int size = arrayList.size();
                arrayList.add(fieldM28465b.getGenericType());
                Object objM69862E = m69862E(fieldM28465b, c4645mM28430b.m28466d(), arrayList, obj, c11706a, true);
                arrayList.remove(size);
                c4645mM28430b.m28472m(obj, objM69862E);
            } else if (zIsAssignableFrom) {
                ((C4646n) obj).set(strMo69880o, m69862E(null, null, arrayList, obj, c11706a, true));
            } else {
                mo69863F();
            }
            enumC11713hM69866I = mo69881p();
        }
    }

    /* renamed from: u */
    public final <T> T m69886u(Class<T> cls) throws IOException {
        return (T) m69887v(cls, null);
    }

    /* renamed from: v */
    public final <T> T m69887v(Class<T> cls, C11706a c11706a) throws IOException {
        try {
            return (T) m69882q(cls, c11706a);
        } finally {
            mo69867a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: w */
    public final <T> void m69888w(Field field, Collection<T> collection, Type type, ArrayList<Type> arrayList, C11706a c11706a) throws IOException {
        EnumC11713h enumC11713hM69866I = m69866I();
        while (enumC11713hM69866I != EnumC11713h.END_ARRAY) {
            collection.add(m69862E(field, type, arrayList, collection, c11706a, true));
            enumC11713hM69866I = mo69881p();
        }
    }

    /* renamed from: x */
    public final Object m69889x(Field field, Type type, ArrayList<Type> arrayList, Object obj, C11706a c11706a, Class<?> cls) throws IOException {
        boolean zM28421j = C4637f0.m28421j(type);
        C4627a0.m28390c(type == null || zM28421j || (cls != null && C4637f0.m28422k(cls, Collection.class)), "expected collection or array type but got %s", type);
        Collection<Object> collectionM28445h = C4642j.m28445h(type);
        Type typeM28450m = C4642j.m28450m(arrayList, zM28421j ? C4637f0.m28413b(type) : (cls == null || !Iterable.class.isAssignableFrom(cls)) ? null : C4637f0.m28415d(type));
        m69888w(field, collectionM28445h, typeM28450m, arrayList, c11706a);
        return zM28421j ? C4637f0.m28426o(collectionM28445h, C4637f0.m28417f(arrayList, typeM28450m)) : collectionM28445h;
    }

    /* renamed from: y */
    public final void m69890y(Field field, Map<String, Object> map, Type type, ArrayList<Type> arrayList, C11706a c11706a) throws IOException {
        EnumC11713h enumC11713hM69866I = m69866I();
        while (enumC11713hM69866I == EnumC11713h.FIELD_NAME) {
            String strMo69880o = mo69880o();
            mo69881p();
            map.put(strMo69880o, m69862E(field, type, arrayList, map, c11706a, true));
            enumC11713hM69866I = mo69881p();
        }
    }

    /* renamed from: z */
    public final Object m69891z(ArrayList<Type> arrayList, Type type, Class<?> cls) {
        C4627a0.m28389b(cls == null || !cls.isPrimitive(), "primitive number field but found a JSON null");
        if (cls != null && (cls.getModifiers() & 1536) != 0) {
            if (C4637f0.m28422k(cls, Collection.class)) {
                return C4642j.m28447j(C4642j.m28445h(type).getClass());
            }
            if (C4637f0.m28422k(cls, Map.class)) {
                return C4642j.m28447j(C4642j.m28446i(cls).getClass());
            }
        }
        return C4642j.m28447j(C4637f0.m28417f(arrayList, type));
    }
}

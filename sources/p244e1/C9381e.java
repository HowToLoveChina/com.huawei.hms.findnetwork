package p244e1;

import java.io.IOException;
import java.io.NotActiveException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import p274f1.InterfaceC9641b;
import p323h1.C10085i;
import p323h1.EnumC10078b;
import p481n1.C11603o;

/* renamed from: e1.e */
/* loaded from: classes.dex */
public class C9381e extends AbstractC9377a implements Map<String, Object>, Cloneable, Serializable, InvocationHandler {
    private static final long serialVersionUID = 1;

    /* renamed from: k */
    public final Map<String, Object> f46791k;

    /* renamed from: e1.e$a */
    public static class a extends ObjectInputStream {

        /* renamed from: a */
        public static Field[] f46792a;

        /* renamed from: b */
        public static volatile boolean f46793b;

        public a(ObjectInputStream objectInputStream) throws IllegalAccessException, IOException, IllegalArgumentException {
            super(objectInputStream);
            int i10 = 0;
            while (true) {
                try {
                    Field[] fieldArr = f46792a;
                    if (i10 >= fieldArr.length) {
                        return;
                    }
                    Field field = fieldArr[i10];
                    field.set(this, field.get(objectInputStream));
                    i10++;
                } catch (IllegalAccessException unused) {
                    f46793b = true;
                    return;
                }
            }
        }

        /* renamed from: s */
        public static void m58797s() {
            if (f46792a != null || f46793b) {
                return;
            }
            try {
                Field[] declaredFields = ObjectInputStream.class.getDeclaredFields();
                String[] strArr = {"bin", "passHandle", "handles", "curContext"};
                Field[] fieldArr = new Field[4];
                for (int i10 = 0; i10 < 4; i10++) {
                    Field fieldM69278W = C11603o.m69278W(ObjectInputStream.class, strArr[i10], declaredFields);
                    fieldM69278W.setAccessible(true);
                    fieldArr[i10] = fieldM69278W;
                }
                f46792a = fieldArr;
            } catch (Throwable unused) {
                f46793b = true;
            }
        }

        @Override // java.io.ObjectInputStream
        public void readStreamHeader() throws IOException {
        }

        @Override // java.io.ObjectInputStream
        public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
            String name = objectStreamClass.getName();
            if (name.length() > 2) {
                int iLastIndexOf = name.lastIndexOf(91);
                if (iLastIndexOf != -1) {
                    name = name.substring(iLastIndexOf + 1);
                }
                if (name.length() > 2 && name.charAt(0) == 'L' && name.charAt(name.length() - 1) == ';') {
                    name = name.substring(1, name.length() - 1);
                }
                if (C11603o.m69272Q(name) == null) {
                    C10085i.f49239z.m62861j(name, null, EnumC10078b.SupportAutoType.f49196a);
                }
            }
            return super.resolveClass(objectStreamClass);
        }

        @Override // java.io.ObjectInputStream
        public Class<?> resolveProxyClass(String[] strArr) throws IOException, ClassNotFoundException {
            for (String str : strArr) {
                if (C11603o.m69272Q(str) == null) {
                    C10085i.f49239z.m62860i(str, null);
                }
            }
            return super.resolveProxyClass(strArr);
        }
    }

    public C9381e() {
        this(16, false);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        a.m58797s();
        if (a.f46792a != null && !a.f46793b) {
            try {
                new a(objectInputStream).defaultReadObject();
                return;
            } catch (NotActiveException unused) {
            }
        }
        objectInputStream.defaultReadObject();
        for (Map.Entry<String, Object> entry : this.f46791k.entrySet()) {
            String key = entry.getKey();
            if (key != null) {
                C10085i.f49239z.m62859h(key.getClass());
            }
            Object value = entry.getValue();
            if (value != null) {
                C10085i.f49239z.m62859h(value.getClass());
            }
        }
    }

    /* renamed from: E */
    public C9381e clone() {
        return new C9381e((Map<String, Object>) (this.f46791k instanceof LinkedHashMap ? new LinkedHashMap(this.f46791k) : new HashMap(this.f46791k)));
    }

    /* renamed from: F */
    public C9381e m58787F(String str, Object obj) {
        this.f46791k.put(str, obj);
        return this;
    }

    /* renamed from: G */
    public double m58788G(String str) {
        Double dM69314q = C11603o.m69314q(get(str));
        if (dM69314q == null) {
            return 0.0d;
        }
        return dM69314q.doubleValue();
    }

    /* renamed from: H */
    public float m58789H(String str) {
        Float fM69318s = C11603o.m69318s(get(str));
        if (fM69318s == null) {
            return 0.0f;
        }
        return fM69318s.floatValue();
    }

    /* renamed from: J */
    public Map<String, Object> m58790J() {
        return this.f46791k;
    }

    /* renamed from: K */
    public int m58791K(String str) {
        Integer numM69320t = C11603o.m69320t(get(str));
        if (numM69320t == null) {
            return 0;
        }
        return numM69320t.intValue();
    }

    /* renamed from: L */
    public Long m58792L(String str) {
        return C11603o.m69324v(get(str));
    }

    /* renamed from: M */
    public long m58793M(String str) {
        Long lM69324v = C11603o.m69324v(get(str));
        if (lM69324v == null) {
            return 0L;
        }
        return lM69324v.longValue();
    }

    /* renamed from: N */
    public String m58794N(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    @Override // java.util.Map
    /* renamed from: O */
    public Object put(String str, Object obj) {
        return this.f46791k.put(str, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: P */
    public <T> T m58796P(Class<T> cls, C10085i c10085i, int i10) {
        return cls == Map.class ? this : (cls != Object.class || containsKey(AbstractC9377a.f46780c)) ? (T) C11603o.m69322u(this, cls, c10085i) : this;
    }

    @Override // java.util.Map
    public void clear() {
        this.f46791k.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        boolean zContainsKey = this.f46791k.containsKey(obj);
        return !zContainsKey ? ((obj instanceof Number) || (obj instanceof Character) || (obj instanceof Boolean) || (obj instanceof UUID)) ? this.f46791k.containsKey(obj.toString()) : zContainsKey : zContainsKey;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.f46791k.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        return this.f46791k.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj instanceof C9381e ? this.f46791k.equals(((C9381e) obj).f46791k) : this.f46791k.equals(obj);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        Object obj2 = this.f46791k.get(obj);
        return obj2 == null ? ((obj instanceof Number) || (obj instanceof Character) || (obj instanceof Boolean) || (obj instanceof UUID)) ? this.f46791k.get(obj.toString()) : obj2 : obj2;
    }

    @Override // java.util.Map
    public Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.f46791k.hashCode();
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        Class<?>[] parameterTypes = method.getParameterTypes();
        String strName = null;
        if (parameterTypes.length == 1) {
            if (method.getName().equals("equals")) {
                return Boolean.valueOf(equals(objArr[0]));
            }
            if (method.getReturnType() != Void.TYPE) {
                throw new C9380d("illegal setter");
            }
            InterfaceC9641b interfaceC9641b = (InterfaceC9641b) C11603o.m69269O(method, InterfaceC9641b.class);
            String strName2 = (interfaceC9641b == null || interfaceC9641b.name().length() == 0) ? null : interfaceC9641b.name();
            if (strName2 == null) {
                String name = method.getName();
                if (!name.startsWith("set")) {
                    throw new C9380d("illegal setter");
                }
                String strSubstring = name.substring(3);
                if (strSubstring.length() == 0) {
                    throw new C9380d("illegal setter");
                }
                strName2 = Character.toLowerCase(strSubstring.charAt(0)) + strSubstring.substring(1);
            }
            this.f46791k.put(strName2, objArr[0]);
            return null;
        }
        if (parameterTypes.length != 0) {
            throw new UnsupportedOperationException(method.toGenericString());
        }
        if (method.getReturnType() == Void.TYPE) {
            throw new C9380d("illegal getter");
        }
        InterfaceC9641b interfaceC9641b2 = (InterfaceC9641b) C11603o.m69269O(method, InterfaceC9641b.class);
        if (interfaceC9641b2 != null && interfaceC9641b2.name().length() != 0) {
            strName = interfaceC9641b2.name();
        }
        if (strName == null) {
            String name2 = method.getName();
            if (name2.startsWith("get")) {
                String strSubstring2 = name2.substring(3);
                if (strSubstring2.length() == 0) {
                    throw new C9380d("illegal getter");
                }
                strName = Character.toLowerCase(strSubstring2.charAt(0)) + strSubstring2.substring(1);
            } else {
                if (!name2.startsWith("is")) {
                    if (name2.startsWith("hashCode")) {
                        return Integer.valueOf(hashCode());
                    }
                    if (name2.startsWith("toString")) {
                        return toString();
                    }
                    throw new C9380d("illegal getter");
                }
                String strSubstring3 = name2.substring(2);
                if (strSubstring3.length() == 0) {
                    throw new C9380d("illegal getter");
                }
                strName = Character.toLowerCase(strSubstring3.charAt(0)) + strSubstring3.substring(1);
            }
        }
        return C11603o.m69296h(this.f46791k.get(strName), method.getGenericReturnType(), C10085i.m62849t());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f46791k.isEmpty();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.f46791k.keySet();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Object> map) {
        this.f46791k.putAll(map);
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return this.f46791k.remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return this.f46791k.size();
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return this.f46791k.values();
    }

    public C9381e(int i10) {
        this(i10, false);
    }

    public C9381e(boolean z10) {
        this(16, z10);
    }

    public C9381e(Map<String, Object> map) {
        if (map != null) {
            this.f46791k = map;
            return;
        }
        throw new IllegalArgumentException("map is null.");
    }

    public C9381e(int i10, boolean z10) {
        if (z10) {
            this.f46791k = new LinkedHashMap(i10);
        } else {
            this.f46791k = new HashMap(i10);
        }
    }
}

package p481n1;

import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Path;
import java.sql.Clob;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Deque;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p244e1.AbstractC9377a;
import p244e1.C9378b;
import p244e1.C9380d;
import p244e1.C9381e;
import p244e1.C9382f;
import p244e1.EnumC9389m;
import p274f1.InterfaceC9641b;
import p274f1.InterfaceC9643d;
import p323h1.C10077a;
import p323h1.C10082f;
import p323h1.C10085i;
import p323h1.EnumC10078b;
import p354i1.C10396h;
import p354i1.C10403o;
import p354i1.InterfaceC10408t;
import p381j1.C10677p;
import p381j1.C10698z0;
import p381j1.EnumC10653e1;
import p408jw.InterfaceC10943i;
import p790xw.C13874c;
import p790xw.C13875d;
import p790xw.C13876e;
import p790xw.C13879h;
import p790xw.C13882k;
import p824yw.InterfaceC14052d;
import p824yw.InterfaceC14053e;

/* renamed from: n1.o */
/* loaded from: classes.dex */
public class C11603o {

    /* renamed from: A */
    public static volatile Map<Class, String[]> f53841A;

    /* renamed from: B */
    public static volatile boolean f53842B;

    /* renamed from: D */
    public static Class<?> f53844D;

    /* renamed from: N */
    public static Class f53854N;

    /* renamed from: O */
    public static InterfaceC11593e<Class, Boolean> f53855O;

    /* renamed from: P */
    public static InterfaceC11593e<Object, Object> f53856P;

    /* renamed from: Q */
    public static InterfaceC11593e<Object, Object> f53857Q;

    /* renamed from: R */
    public static InterfaceC11593e<Object, Object> f53858R;

    /* renamed from: S */
    public static InterfaceC11591c<Object, Class, Object> f53859S;

    /* renamed from: T */
    public static InterfaceC11593e<Map<String, Class<?>>, Void> f53860T;

    /* renamed from: U */
    public static final Map f53861U;

    /* renamed from: V */
    public static final Set<String> f53862V;

    /* renamed from: W */
    public static Object f53863W;

    /* renamed from: X */
    public static boolean f53864X;

    /* renamed from: b */
    public static boolean f53866b;

    /* renamed from: c */
    public static boolean f53867c;

    /* renamed from: f */
    public static Method f53870f;

    /* renamed from: h */
    public static Method f53872h;

    /* renamed from: j */
    public static Class<?> f53874j;

    /* renamed from: l */
    public static Class<? extends Annotation> f53876l;

    /* renamed from: s */
    public static volatile Class f53883s;

    /* renamed from: t */
    public static volatile boolean f53884t;

    /* renamed from: u */
    public static volatile boolean f53885u;

    /* renamed from: v */
    public static volatile Constructor f53886v;

    /* renamed from: w */
    public static volatile Method f53887w;

    /* renamed from: x */
    public static volatile Method f53888x;

    /* renamed from: y */
    public static volatile Method f53889y;

    /* renamed from: z */
    public static volatile boolean f53890z;

    /* renamed from: a */
    public static final Pattern f53865a = Pattern.compile("\\.0*$");

    /* renamed from: d */
    public static boolean f53868d = true;

    /* renamed from: e */
    public static boolean f53869e = false;

    /* renamed from: g */
    public static boolean f53871g = false;

    /* renamed from: i */
    public static boolean f53873i = false;

    /* renamed from: k */
    public static boolean f53875k = false;

    /* renamed from: m */
    public static Class<? extends Annotation> f53877m = null;

    /* renamed from: n */
    public static boolean f53878n = false;

    /* renamed from: o */
    public static Class<? extends Annotation> f53879o = null;

    /* renamed from: p */
    public static boolean f53880p = false;

    /* renamed from: q */
    public static Method f53881q = null;

    /* renamed from: r */
    public static boolean f53882r = false;

    /* renamed from: C */
    public static ConcurrentMap<String, Class<?>> f53843C = new ConcurrentHashMap(256, 0.75f, 1);

    /* renamed from: E */
    public static boolean f53845E = false;

    /* renamed from: F */
    public static Class<? extends Annotation> f53846F = null;

    /* renamed from: G */
    public static boolean f53847G = false;

    /* renamed from: H */
    public static volatile Class f53848H = null;

    /* renamed from: I */
    public static volatile Class f53849I = null;

    /* renamed from: J */
    public static volatile boolean f53850J = false;

    /* renamed from: K */
    public static volatile Method f53851K = null;

    /* renamed from: L */
    public static volatile Field f53852L = null;

    /* renamed from: M */
    public static volatile Object f53853M = null;

    /* renamed from: n1.o$a */
    public static class a implements InterfaceC11593e<Class, Boolean> {
        @Override // p481n1.InterfaceC11593e
        /* renamed from: a */
        public Boolean apply(Class cls) {
            return Boolean.valueOf(Clob.class.isAssignableFrom(cls));
        }
    }

    /* renamed from: n1.o$b */
    public static class b implements InterfaceC11593e<Object, Object> {
        @Override // p481n1.InterfaceC11593e
        public Object apply(Object obj) throws NumberFormatException {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Date) {
                return (Date) obj;
            }
            if (obj instanceof java.util.Date) {
                return new Date(((java.util.Date) obj).getTime());
            }
            if (obj instanceof Calendar) {
                return new Date(((Calendar) obj).getTimeInMillis());
            }
            long jM69248D0 = obj instanceof BigDecimal ? C11603o.m69248D0((BigDecimal) obj) : obj instanceof Number ? ((Number) obj).longValue() : 0L;
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                    return null;
                }
                if (C11603o.m69323u0(str)) {
                    jM69248D0 = Long.parseLong(str);
                } else {
                    C10082f c10082f = new C10082f(str);
                    if (!c10082f.m62838u1(false)) {
                        throw new C9380d("can not cast to Timestamp, value : " + str);
                    }
                    jM69248D0 = c10082f.m62795G0().getTime().getTime();
                }
            }
            if (jM69248D0 > 0) {
                return new Date(jM69248D0);
            }
            throw new C9380d("can not cast to Date, value : " + obj);
        }
    }

    /* renamed from: n1.o$c */
    public static class c implements InterfaceC11593e<Object, Object> {
        @Override // p481n1.InterfaceC11593e
        public Object apply(Object obj) throws NumberFormatException {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Time) {
                return (Time) obj;
            }
            if (obj instanceof java.util.Date) {
                return new Time(((java.util.Date) obj).getTime());
            }
            if (obj instanceof Calendar) {
                return new Time(((Calendar) obj).getTimeInMillis());
            }
            long jM69248D0 = obj instanceof BigDecimal ? C11603o.m69248D0((BigDecimal) obj) : obj instanceof Number ? ((Number) obj).longValue() : 0L;
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0 || "null".equalsIgnoreCase(str)) {
                    return null;
                }
                if (C11603o.m69323u0(str)) {
                    jM69248D0 = Long.parseLong(str);
                } else {
                    if (str.length() == 8 && str.charAt(2) == ':' && str.charAt(5) == ':') {
                        return Time.valueOf(str);
                    }
                    C10082f c10082f = new C10082f(str);
                    if (!c10082f.m62838u1(false)) {
                        throw new C9380d("can not cast to Timestamp, value : " + str);
                    }
                    jM69248D0 = c10082f.m62795G0().getTime().getTime();
                }
            }
            if (jM69248D0 > 0) {
                return new Time(jM69248D0);
            }
            throw new C9380d("can not cast to Date, value : " + obj);
        }
    }

    /* renamed from: n1.o$d */
    public static class d implements InterfaceC11593e<Object, Object> {
        @Override // p481n1.InterfaceC11593e
        public Object apply(Object obj) throws NumberFormatException {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Calendar) {
                return new Timestamp(((Calendar) obj).getTimeInMillis());
            }
            if (obj instanceof Timestamp) {
                return (Timestamp) obj;
            }
            if (obj instanceof java.util.Date) {
                return new Timestamp(((java.util.Date) obj).getTime());
            }
            long jM69248D0 = obj instanceof BigDecimal ? C11603o.m69248D0((BigDecimal) obj) : obj instanceof Number ? ((Number) obj).longValue() : 0L;
            if (obj instanceof String) {
                String strSubstring = (String) obj;
                if (strSubstring.length() == 0 || "null".equals(strSubstring) || "NULL".equals(strSubstring)) {
                    return null;
                }
                if (strSubstring.endsWith(".000000000")) {
                    strSubstring = strSubstring.substring(0, strSubstring.length() - 10);
                } else if (strSubstring.endsWith(".000000")) {
                    strSubstring = strSubstring.substring(0, strSubstring.length() - 7);
                }
                if (strSubstring.length() == 29 && strSubstring.charAt(4) == '-' && strSubstring.charAt(7) == '-' && strSubstring.charAt(10) == ' ' && strSubstring.charAt(13) == ':' && strSubstring.charAt(16) == ':' && strSubstring.charAt(19) == '.') {
                    return new Timestamp(C11603o.m69254G0(strSubstring.charAt(0), strSubstring.charAt(1), strSubstring.charAt(2), strSubstring.charAt(3)) - 1900, C11603o.m69252F0(strSubstring.charAt(5), strSubstring.charAt(6)) - 1, C11603o.m69252F0(strSubstring.charAt(8), strSubstring.charAt(9)), C11603o.m69252F0(strSubstring.charAt(11), strSubstring.charAt(12)), C11603o.m69252F0(strSubstring.charAt(14), strSubstring.charAt(15)), C11603o.m69252F0(strSubstring.charAt(17), strSubstring.charAt(18)), C11603o.m69256H0(strSubstring.charAt(20), strSubstring.charAt(21), strSubstring.charAt(22), strSubstring.charAt(23), strSubstring.charAt(24), strSubstring.charAt(25), strSubstring.charAt(26), strSubstring.charAt(27), strSubstring.charAt(28)));
                }
                if (C11603o.m69323u0(strSubstring)) {
                    jM69248D0 = Long.parseLong(strSubstring);
                } else {
                    C10082f c10082f = new C10082f(strSubstring);
                    if (!c10082f.m62838u1(false)) {
                        throw new C9380d("can not cast to Timestamp, value : " + strSubstring);
                    }
                    jM69248D0 = c10082f.m62795G0().getTime().getTime();
                }
            }
            return new Timestamp(jM69248D0);
        }
    }

    /* renamed from: n1.o$e */
    public static class e implements InterfaceC11591c<Object, Class, Object> {
        @Override // p481n1.InterfaceC11591c
        /* renamed from: a */
        public Object apply(Object obj, Class cls) {
            if (cls == Date.class) {
                return C11603o.m69328x(obj);
            }
            if (cls == Time.class) {
                return C11603o.m69330y(obj);
            }
            if (cls == Timestamp.class) {
                return C11603o.m69241A(obj);
            }
            return null;
        }
    }

    /* renamed from: n1.o$f */
    public static class f implements InterfaceC11593e<Map<String, Class<?>>, Void> {
        @Override // p481n1.InterfaceC11593e
        /* renamed from: a */
        public Void apply(Map<String, Class<?>> map) {
            Class<?>[] clsArr = {Time.class, Date.class, Timestamp.class};
            for (int i10 = 0; i10 < 3; i10++) {
                Class<?> cls = clsArr[i10];
                if (cls != null) {
                    map.put(cls.getName(), cls);
                }
            }
            return null;
        }
    }

    /* renamed from: n1.o$g */
    public static class g extends HashMap<Class, String> {
        public g(int i10) {
            super(i10);
            put(Boolean.TYPE, "Z");
            put(Character.TYPE, "C");
            put(Byte.TYPE, CloudBackupConstant.UserPackageInfo.ONE_T_MEMBER);
            put(Short.TYPE, CloudBackupConstant.UserPackageInfo.SILVER_MEMBER);
            put(Integer.TYPE, "I");
            put(Long.TYPE, RequestOptions.AD_CONTENT_CLASSIFICATION_J);
            put(Float.TYPE, "F");
            put(Double.TYPE, "D");
        }
    }

    /* renamed from: n1.o$h */
    public static class h extends HashSet<String> {
        public h(int i10) {
            super(i10);
            add("net.sf.cglib.proxy.Factory");
            add("org.springframework.cglib.proxy.Factory");
            add("javassist.util.proxy.ProxyObject");
            add("org.apache.ibatis.javassist.util.proxy.ProxyObject");
            add("org.hibernate.proxy.HibernateProxy");
            add("org.springframework.context.annotation.ConfigurationClassEnhancer$EnhancedConfiguration");
        }
    }

    /* renamed from: n1.o$i */
    public static class i implements Comparator<Method> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Method method, Method method2) {
            int iCompareTo = method.getName().compareTo(method2.getName());
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            Class<?> returnType = method.getReturnType();
            Class<?> returnType2 = method2.getReturnType();
            if (returnType.equals(returnType2)) {
                return 0;
            }
            if (returnType.isAssignableFrom(returnType2)) {
                return -1;
            }
            return returnType2.isAssignableFrom(returnType) ? 1 : 0;
        }
    }

    static {
        f53866b = false;
        f53867c = false;
        f53854N = null;
        try {
            f53866b = FaqConstants.DISABLE_HA_REPORT.equals(C11595g.m69213h("fastjson.compatibleWithJavaBean"));
            f53867c = FaqConstants.DISABLE_HA_REPORT.equals(C11595g.m69213h("fastjson.compatibleWithFieldName"));
        } catch (Throwable unused) {
        }
        try {
            f53854N = Deque.class;
        } catch (Throwable unused2) {
        }
        f53855O = new a();
        f53856P = new b();
        f53857Q = new c();
        f53858R = new d();
        f53859S = new e();
        f53860T = new f();
        m69282a();
        f53861U = new g(8);
        f53862V = new h(6);
        f53864X = false;
    }

    /* renamed from: A */
    public static Object m69241A(Object obj) {
        return C11598j.m69234c(f53858R, obj);
    }

    /* renamed from: A0 */
    public static Class<?> m69242A0(String str, ClassLoader classLoader) {
        return m69244B0(str, classLoader, false);
    }

    /* renamed from: B */
    public static void m69243B(Class<?> cls, Map<String, String> map, EnumC9389m enumC9389m, Map<String, C11592d> map2, Field[] fieldArr) {
        String strLabel;
        int i10;
        int i11;
        int i12;
        for (Field field : fieldArr) {
            if (!Modifier.isStatic(field.getModifiers())) {
                InterfaceC9641b interfaceC9641b = (InterfaceC9641b) m69267N(field, InterfaceC9641b.class);
                String name = field.getName();
                if (interfaceC9641b == null) {
                    strLabel = null;
                    i10 = 0;
                    i11 = 0;
                    i12 = 0;
                } else if (interfaceC9641b.serialize()) {
                    int iOrdinal = interfaceC9641b.ordinal();
                    int iM65243h = EnumC10653e1.m65243h(interfaceC9641b.serialzeFeatures());
                    int iM62750f = EnumC10078b.m62750f(interfaceC9641b.parseFeatures());
                    if (interfaceC9641b.name().length() != 0) {
                        name = interfaceC9641b.name();
                    }
                    strLabel = interfaceC9641b.label().length() != 0 ? interfaceC9641b.label() : null;
                    i10 = iOrdinal;
                    i11 = iM65243h;
                    i12 = iM62750f;
                }
                if (map == null || (name = map.get(name)) != null) {
                    if (enumC9389m != null) {
                        name = enumC9389m.m58848b(name);
                    }
                    String str = name;
                    if (!map2.containsKey(str)) {
                        map2.put(str, new C11592d(str, null, field, cls, null, i10, i11, i12, null, interfaceC9641b, strLabel));
                    }
                }
            }
        }
    }

    /* renamed from: B0 */
    public static Class<?> m69244B0(String str, ClassLoader classLoader, boolean z10) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.length() > 198) {
            throw new C9380d("illegal className : " + str);
        }
        Class<?> clsLoadClass = f53843C.get(str);
        if (clsLoadClass != null) {
            return clsLoadClass;
        }
        if (str.charAt(0) == '[') {
            return Array.newInstance(m69242A0(str.substring(1), classLoader), 0).getClass();
        }
        if (str.startsWith("L") && str.endsWith(";")) {
            return m69242A0(str.substring(1, str.length() - 1), classLoader);
        }
        if (classLoader != null) {
            try {
                clsLoadClass = classLoader.loadClass(str);
                if (z10) {
                    f53843C.put(str, clsLoadClass);
                }
                return clsLoadClass;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null && contextClassLoader != classLoader) {
                clsLoadClass = contextClassLoader.loadClass(str);
                if (z10) {
                    f53843C.put(str, clsLoadClass);
                }
                return clsLoadClass;
            }
        } catch (Throwable unused) {
        }
        try {
            clsLoadClass = Class.forName(str);
            if (z10) {
                f53843C.put(str, clsLoadClass);
            }
        } catch (Throwable unused2) {
        }
        return clsLoadClass;
    }

    /* JADX WARN: Code restructure failed: missing block: B:429:0x02a6, code lost:
    
        if (r1 == null) goto L389;
     */
    /* JADX WARN: Code restructure failed: missing block: B:462:0x0331, code lost:
    
        if (r2 == null) goto L389;
     */
    /* JADX WARN: Code restructure failed: missing block: B:515:0x0440, code lost:
    
        if (r2 == null) goto L487;
     */
    /* JADX WARN: Code restructure failed: missing block: B:536:0x0499, code lost:
    
        if (r0 == null) goto L488;
     */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:439:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:487:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:488:0x03c5 A[PHI: r13
  0x03c5: PHI (r13v5 java.util.Map<java.lang.String, java.lang.String>) = 
  (r13v4 java.util.Map<java.lang.String, java.lang.String>)
  (r13v7 java.util.Map<java.lang.String, java.lang.String>)
  (r13v7 java.util.Map<java.lang.String, java.lang.String>)
  (r13v12 java.util.Map<java.lang.String, java.lang.String>)
 binds: [B:487:0x03c3, B:554:0x04e4, B:548:0x04d4, B:536:0x0499] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:520:0x044a  */
    /* renamed from: C */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<p481n1.C11592d> m69245C(java.lang.Class<?> r40, p274f1.InterfaceC9643d r41, java.util.Map<java.lang.String, java.lang.String> r42, java.util.Map<java.lang.String, java.lang.reflect.Field> r43, boolean r44, p244e1.EnumC9389m r45) throws java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 1325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p481n1.C11603o.m69245C(java.lang.Class, f1.d, java.util.Map, java.util.Map, boolean, e1.m):java.util.List");
    }

    /* renamed from: C0 */
    public static long m69246C0(Number number) {
        return number instanceof BigDecimal ? ((BigDecimal) number).longValueExact() : number.longValue();
    }

    /* renamed from: D */
    public static List<C11592d> m69247D(Class<?> cls, Map<String, String> map, boolean z10, EnumC9389m enumC9389m) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            m69243B(superclass, map, enumC9389m, linkedHashMap, superclass.getDeclaredFields());
        }
        return m69279X(cls, z10, linkedHashMap);
    }

    /* renamed from: D0 */
    public static long m69248D0(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return 0L;
        }
        int iScale = bigDecimal.scale();
        return (iScale < -100 || iScale > 100) ? bigDecimal.longValueExact() : bigDecimal.longValue();
    }

    /* renamed from: E */
    public static Map<TypeVariable, Type> m69249E(TypeVariable[] typeVariableArr, Type[] typeArr) {
        int length = typeVariableArr.length;
        HashMap map = new HashMap(length);
        for (int i10 = 0; i10 < length; i10++) {
            map.put(typeVariableArr[i10], typeArr[i10]);
        }
        return map;
    }

    /* renamed from: E0 */
    public static ParameterizedType m69250E0(Class<?> cls, Type[] typeArr, Map<TypeVariable, Type> map) {
        int length = typeArr.length;
        Type[] typeArr2 = new Type[length];
        for (int i10 = 0; i10 < length; i10++) {
            typeArr2[i10] = m69263L(typeArr[i10], map);
        }
        return new C11599k(typeArr2, null, cls);
    }

    /* renamed from: F */
    public static Collection m69251F(Type type) {
        Class<?> cls;
        Class<?> clsM69297h0 = m69297h0(type);
        if (clsM69297h0 == AbstractCollection.class || clsM69297h0 == Collection.class) {
            return new ArrayList();
        }
        if (clsM69297h0.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (clsM69297h0.isAssignableFrom(LinkedHashSet.class)) {
            return new LinkedHashSet();
        }
        if (clsM69297h0.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
        }
        if (clsM69297h0.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        if (clsM69297h0.isAssignableFrom(EnumSet.class)) {
            return EnumSet.noneOf((Class) (type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class));
        }
        if (clsM69297h0.isAssignableFrom(Queue.class) || ((cls = f53854N) != null && clsM69297h0.isAssignableFrom(cls))) {
            return new LinkedList();
        }
        try {
            return (Collection) clsM69297h0.newInstance();
        } catch (Exception unused) {
            throw new C9380d("create instance error, class " + clsM69297h0.getName());
        }
    }

    /* renamed from: F0 */
    public static int m69252F0(char c10, char c11) {
        if (c10 < '0' || c10 > '9' || c11 < '0' || c11 > '9') {
            return -1;
        }
        return ((c10 - '0') * 10) + (c11 - '0');
    }

    /* renamed from: G */
    public static Set m69253G(Type type) {
        Class<?> clsM69297h0 = m69297h0(type);
        if (clsM69297h0 == AbstractCollection.class || clsM69297h0 == Collection.class) {
            return new HashSet();
        }
        if (clsM69297h0.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (clsM69297h0.isAssignableFrom(LinkedHashSet.class)) {
            return new LinkedHashSet();
        }
        if (clsM69297h0.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
        }
        if (clsM69297h0.isAssignableFrom(EnumSet.class)) {
            return EnumSet.noneOf((Class) (type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class));
        }
        try {
            return (Set) clsM69297h0.newInstance();
        } catch (Exception unused) {
            throw new C9380d("create instance error, class " + clsM69297h0.getName());
        }
    }

    /* renamed from: G0 */
    public static int m69254G0(char c10, char c11, char c12, char c13) {
        if (c10 < '0' || c10 > '9' || c11 < '0' || c11 > '9' || c12 < '0' || c12 > '9' || c13 < '0' || c13 > '9') {
            return -1;
        }
        return ((c10 - '0') * 1000) + ((c11 - '0') * 100) + ((c12 - '0') * 10) + (c13 - '0');
    }

    /* renamed from: H */
    public static String m69255H(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    /* renamed from: H0 */
    public static int m69256H0(char c10, char c11, char c12, char c13, char c14, char c15, char c16, char c17, char c18) {
        if (c10 < '0' || c10 > '9' || c11 < '0' || c11 > '9' || c12 < '0' || c12 > '9' || c13 < '0' || c13 > '9' || c14 < '0' || c14 > '9' || c15 < '0' || c15 > '9' || c16 < '0' || c16 > '9' || c17 < '0' || c17 > '9' || c18 < '0' || c18 > '9') {
            return -1;
        }
        return ((c10 - '0') * 100000000) + ((c11 - '0') * ExceptionCode.CRASH_EXCEPTION) + ((c12 - '0') * Constants.MILLON) + ((c13 - '0') * 100000) + ((c14 - '0') * 10000) + ((c15 - '0') * 1000) + ((c16 - '0') * 100) + ((c17 - '0') * 10) + (c18 - '0');
    }

    /* renamed from: I */
    public static long m69257I(String str) {
        long jCharAt = -3750763034362895579L;
        for (int i10 = 0; i10 < str.length(); i10++) {
            jCharAt = (jCharAt ^ str.charAt(i10)) * 1099511628211L;
        }
        return jCharAt;
    }

    /* renamed from: I0 */
    public static Object m69258I0(Type type) {
        Class<?> clsM69271P;
        if (f53864X || (clsM69271P = m69271P(type)) == null) {
            return null;
        }
        String name = clsM69271P.getName();
        if (!"java.util.Optional".equals(name)) {
            return null;
        }
        if (f53863W == null) {
            try {
                f53863W = Class.forName(name).getMethod("empty", new Class[0]).invoke(null, new Object[0]);
            } catch (Throwable unused) {
                f53864X = true;
            }
        }
        return f53863W;
    }

    /* renamed from: J */
    public static long m69259J(String str) {
        long j10 = -3750763034362895579L;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt != '_' && cCharAt != '-') {
                if (cCharAt >= 'A' && cCharAt <= 'Z') {
                    cCharAt = (char) (cCharAt + ' ');
                }
                j10 = (j10 ^ cCharAt) * 1099511628211L;
            }
        }
        return j10;
    }

    /* renamed from: J0 */
    public static double m69260J0(String str) {
        double d10;
        double d11;
        int length = str.length();
        if (length > 10) {
            return Double.parseDouble(str);
        }
        long j10 = 0;
        boolean z10 = false;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            char cCharAt = str.charAt(i11);
            if (cCharAt == '-' && i11 == 0) {
                z10 = true;
            } else if (cCharAt == '.') {
                if (i10 != 0) {
                    return Double.parseDouble(str);
                }
                i10 = (length - i11) - 1;
            } else {
                if (cCharAt < '0' || cCharAt > '9') {
                    return Double.parseDouble(str);
                }
                j10 = (j10 * 10) + (cCharAt - '0');
            }
        }
        if (z10) {
            j10 = -j10;
        }
        switch (i10) {
            case 0:
                return j10;
            case 1:
                d10 = j10;
                d11 = 10.0d;
                break;
            case 2:
                d10 = j10;
                d11 = 100.0d;
                break;
            case 3:
                d10 = j10;
                d11 = 1000.0d;
                break;
            case 4:
                d10 = j10;
                d11 = 10000.0d;
                break;
            case 5:
                d10 = j10;
                d11 = 100000.0d;
                break;
            case 6:
                d10 = j10;
                d11 = 1000000.0d;
                break;
            case 7:
                d10 = j10;
                d11 = 1.0E7d;
                break;
            case 8:
                d10 = j10;
                d11 = 1.0E8d;
                break;
            case 9:
                d10 = j10;
                d11 = 1.0E9d;
                break;
            default:
                return Double.parseDouble(str);
        }
        return d10 / d11;
    }

    /* renamed from: K */
    public static long m69261K(String str) {
        long j10 = -3750763034362895579L;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt >= 'A' && cCharAt <= 'Z') {
                cCharAt = (char) (cCharAt + ' ');
            }
            j10 = (j10 ^ cCharAt) * 1099511628211L;
        }
        return j10;
    }

    /* renamed from: K0 */
    public static float m69262K0(String str) {
        float f10;
        float f11;
        int length = str.length();
        if (length >= 10) {
            return Float.parseFloat(str);
        }
        long j10 = 0;
        boolean z10 = false;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            char cCharAt = str.charAt(i11);
            if (cCharAt == '-' && i11 == 0) {
                z10 = true;
            } else if (cCharAt == '.') {
                if (i10 != 0) {
                    return Float.parseFloat(str);
                }
                i10 = (length - i11) - 1;
            } else {
                if (cCharAt < '0' || cCharAt > '9') {
                    return Float.parseFloat(str);
                }
                j10 = (j10 * 10) + (cCharAt - '0');
            }
        }
        if (z10) {
            j10 = -j10;
        }
        switch (i10) {
            case 0:
                return j10;
            case 1:
                f10 = j10;
                f11 = 10.0f;
                break;
            case 2:
                f10 = j10;
                f11 = 100.0f;
                break;
            case 3:
                f10 = j10;
                f11 = 1000.0f;
                break;
            case 4:
                f10 = j10;
                f11 = 10000.0f;
                break;
            case 5:
                f10 = j10;
                f11 = 100000.0f;
                break;
            case 6:
                f10 = j10;
                f11 = 1000000.0f;
                break;
            case 7:
                f10 = j10;
                f11 = 1.0E7f;
                break;
            case 8:
                f10 = j10;
                f11 = 1.0E8f;
                break;
            case 9:
                f10 = j10;
                f11 = 1.0E9f;
                break;
            default:
                return Float.parseFloat(str);
        }
        return f10 / f11;
    }

    /* renamed from: L */
    public static Type m69263L(Type type, Map<TypeVariable, Type> map) {
        return type instanceof TypeVariable ? map.get(type) : type instanceof ParameterizedType ? m69250E0(m69297h0(type), ((ParameterizedType) type).getActualTypeArguments(), map) : type instanceof GenericArrayType ? new C11594f(m69263L(((GenericArrayType) type).getGenericComponentType(), map)) : type;
    }

    /* renamed from: L0 */
    public static void m69264L0(AccessibleObject accessibleObject) {
        if (f53868d && !accessibleObject.isAccessible()) {
            try {
                accessibleObject.setAccessible(true);
            } catch (Throwable unused) {
                f53868d = false;
            }
        }
    }

    /* renamed from: M */
    public static <A extends Annotation> A m69265M(Class<?> cls, Class<A> cls2) {
        A a10 = (A) cls.getAnnotation(cls2);
        Type typeM58761f = AbstractC9377a.m58761f(cls);
        Class cls3 = typeM58761f instanceof Class ? (Class) typeM58761f : null;
        if (cls3 != null) {
            A a11 = (A) cls3.getAnnotation(cls2);
            Annotation[] annotations = cls3.getAnnotations();
            if (a11 == null && annotations.length > 0) {
                for (Annotation annotation : annotations) {
                    a11 = (A) annotation.annotationType().getAnnotation(cls2);
                    if (a11 != null) {
                        break;
                    }
                }
            }
            if (a11 != null) {
                return a11;
            }
        }
        Annotation[] annotations2 = cls.getAnnotations();
        if (a10 == null && annotations2.length > 0) {
            for (Annotation annotation2 : annotations2) {
                a10 = (A) annotation2.annotationType().getAnnotation(cls2);
                if (a10 != null) {
                    break;
                }
            }
        }
        return a10;
    }

    /* renamed from: M0 */
    public static short m69266M0(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return (short) 0;
        }
        int iScale = bigDecimal.scale();
        return (iScale < -100 || iScale > 100) ? bigDecimal.shortValueExact() : bigDecimal.shortValue();
    }

    /* renamed from: N */
    public static <A extends Annotation> A m69267N(Field field, Class<A> cls) throws NoSuchFieldException {
        A a10;
        A a11 = (A) field.getAnnotation(cls);
        Type typeM58761f = AbstractC9377a.m58761f(field.getDeclaringClass());
        Field declaredField = null;
        Class superclass = typeM58761f instanceof Class ? (Class) typeM58761f : null;
        if (superclass != null) {
            String name = field.getName();
            while (superclass != null && superclass != Object.class) {
                try {
                    declaredField = superclass.getDeclaredField(name);
                    break;
                } catch (NoSuchFieldException unused) {
                    superclass = superclass.getSuperclass();
                }
            }
            if (declaredField != null && (a10 = (A) declaredField.getAnnotation(cls)) != null) {
                return a10;
            }
        }
        return a11;
    }

    /* renamed from: N0 */
    public static Locale m69268N0(String str) {
        String[] strArrSplit = str.split("_");
        return strArrSplit.length == 1 ? new Locale(strArrSplit[0]) : strArrSplit.length == 2 ? new Locale(strArrSplit[0], strArrSplit[1]) : new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
    }

    /* renamed from: O */
    public static <A extends Annotation> A m69269O(Method method, Class<A> cls) throws NoSuchMethodException, SecurityException {
        A a10;
        A a11 = (A) method.getAnnotation(cls);
        Type typeM58761f = AbstractC9377a.m58761f(method.getDeclaringClass());
        Method declaredMethod = null;
        Class superclass = typeM58761f instanceof Class ? (Class) typeM58761f : null;
        if (superclass != null) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            while (superclass != null && superclass != Object.class) {
                try {
                    declaredMethod = superclass.getDeclaredMethod(name, parameterTypes);
                    break;
                } catch (NoSuchMethodException unused) {
                    superclass = superclass.getSuperclass();
                }
            }
            if (declaredMethod != null && (a10 = (A) declaredMethod.getAnnotation(cls)) != null) {
                return a10;
            }
        }
        return a11;
    }

    /* renamed from: O0 */
    public static Type m69270O0(Type type) {
        if (!f53873i) {
            try {
                f53874j = Class.forName("java.util.Optional");
            } catch (Exception unused) {
            } catch (Throwable th2) {
                f53873i = true;
                throw th2;
            }
            f53873i = true;
        }
        if (!(type instanceof ParameterizedType)) {
            return type;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        return parameterizedType.getRawType() == f53874j ? parameterizedType.getActualTypeArguments()[0] : type;
    }

    /* renamed from: P */
    public static Class<?> m69271P(Type type) {
        if (type.getClass() == Class.class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return m69271P(((ParameterizedType) type).getRawType());
        }
        if (type instanceof TypeVariable) {
            Type type2 = ((TypeVariable) type).getBounds()[0];
            return type2 instanceof Class ? (Class) type2 : m69271P(type2);
        }
        if (!(type instanceof WildcardType)) {
            return Object.class;
        }
        Type[] upperBounds = ((WildcardType) type).getUpperBounds();
        return upperBounds.length == 1 ? m69271P(upperBounds[0]) : Object.class;
    }

    /* renamed from: Q */
    public static Class<?> m69272Q(String str) {
        return f53843C.get(str);
    }

    /* renamed from: R */
    public static Class<?> m69273R(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return Object.class;
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
            if (upperBounds.length == 1) {
                type2 = upperBounds[0];
            }
        }
        if (!(type2 instanceof Class)) {
            throw new C9380d("can not create ASMParser");
        }
        Class<?> cls = (Class) type2;
        if (Modifier.isPublic(cls.getModifiers())) {
            return cls;
        }
        throw new C9380d("can not create ASMParser");
    }

    /* renamed from: S */
    public static Type m69274S(Class<?> cls) {
        return cls.getName().startsWith("java.") ? Object.class : m69276U(m69277V(cls));
    }

    /* renamed from: T */
    public static Type m69275T(ParameterizedType parameterizedType) {
        Type rawType = parameterizedType.getRawType();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (rawType == Collection.class) {
            return m69301j0(actualTypeArguments[0]);
        }
        Class cls = (Class) rawType;
        Map<TypeVariable, Type> mapM69249E = m69249E(cls.getTypeParameters(), actualTypeArguments);
        Type typeM69277V = m69277V(cls);
        if (!(typeM69277V instanceof ParameterizedType)) {
            return m69274S((Class) typeM69277V);
        }
        Class<?> clsM69297h0 = m69297h0(typeM69277V);
        Type[] actualTypeArguments2 = ((ParameterizedType) typeM69277V).getActualTypeArguments();
        return actualTypeArguments2.length > 0 ? m69275T(m69250E0(clsM69297h0, actualTypeArguments2, mapM69249E)) : m69274S(clsM69297h0);
    }

    /* renamed from: U */
    public static Type m69276U(Type type) {
        return type instanceof ParameterizedType ? m69275T((ParameterizedType) type) : type instanceof Class ? m69274S((Class) type) : Object.class;
    }

    /* renamed from: V */
    public static Type m69277V(Class<?> cls) {
        Type type = null;
        for (Type type2 : cls.getGenericInterfaces()) {
            Class<?> clsM69297h0 = m69297h0(type2);
            if (clsM69297h0 == Collection.class) {
                return type2;
            }
            if (Collection.class.isAssignableFrom(clsM69297h0)) {
                type = type2;
            }
        }
        return type == null ? cls.getGenericSuperclass() : type;
    }

    /* renamed from: W */
    public static Field m69278W(Class<?> cls, String str, Field[] fieldArr) {
        char cCharAt;
        char cCharAt2;
        for (Field field : fieldArr) {
            String name = field.getName();
            if (str.equals(name)) {
                return field;
            }
            if (str.length() > 2 && (cCharAt = str.charAt(0)) >= 'a' && cCharAt <= 'z' && (cCharAt2 = str.charAt(1)) >= 'A' && cCharAt2 <= 'Z' && str.equalsIgnoreCase(name)) {
                return field;
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || superclass == Object.class) {
            return null;
        }
        return m69278W(superclass, str, superclass.getDeclaredFields());
    }

    /* renamed from: X */
    public static List<C11592d> m69279X(Class<?> cls, boolean z10, Map<String, C11592d> map) {
        ArrayList arrayList = new ArrayList();
        InterfaceC9643d interfaceC9643d = (InterfaceC9643d) m69265M(cls, InterfaceC9643d.class);
        String[] strArrOrders = interfaceC9643d != null ? interfaceC9643d.orders() : null;
        if (strArrOrders == null || strArrOrders.length <= 0) {
            arrayList.addAll(map.values());
            if (z10) {
                Collections.sort(arrayList);
            }
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap(map.size());
            for (C11592d c11592d : map.values()) {
                linkedHashMap.put(c11592d.f53768a, c11592d);
            }
            for (String str : strArrOrders) {
                C11592d c11592d2 = (C11592d) linkedHashMap.get(str);
                if (c11592d2 != null) {
                    arrayList.add(c11592d2);
                    linkedHashMap.remove(str);
                }
            }
            arrayList.addAll(linkedHashMap.values());
        }
        return arrayList;
    }

    /* renamed from: Y */
    public static Type m69280Y(Type type) {
        return (!(type instanceof ParameterizedType) && (type instanceof Class)) ? m69280Y(((Class) type).getGenericSuperclass()) : type;
    }

    /* renamed from: Z */
    public static String[] m69281Z(Class cls) {
        if (f53886v == null && !f53885u) {
            try {
                f53886v = Class.forName("kotlin.reflect.jvm.internal.KClassImpl").getConstructor(Class.class);
            } catch (Throwable unused) {
                f53885u = true;
            }
        }
        if (f53886v == null) {
            return null;
        }
        if (f53887w == null && !f53885u) {
            try {
                f53887w = Class.forName("kotlin.reflect.jvm.internal.KClassImpl").getMethod("getConstructors", new Class[0]);
            } catch (Throwable unused2) {
                f53885u = true;
            }
        }
        if (f53888x == null && !f53885u) {
            try {
                f53888x = InterfaceC14052d.class.getMethod("getParameters", new Class[0]);
            } catch (Throwable unused3) {
                f53885u = true;
            }
        }
        if (f53889y == null && !f53885u) {
            try {
                f53889y = InterfaceC14053e.class.getMethod("getName", new Class[0]);
            } catch (Throwable unused4) {
                f53885u = true;
            }
        }
        if (f53890z) {
            return null;
        }
        try {
            Iterator it = ((Iterable) f53887w.invoke(f53886v.newInstance(cls), new Object[0])).iterator();
            Object obj = null;
            while (it.hasNext()) {
                Object next = it.next();
                List list = (List) f53888x.invoke(next, new Object[0]);
                if (obj == null || list.size() != 0) {
                    obj = next;
                }
                it.hasNext();
            }
            if (obj == null) {
                return null;
            }
            List list2 = (List) f53888x.invoke(obj, new Object[0]);
            String[] strArr = new String[list2.size()];
            for (int i10 = 0; i10 < list2.size(); i10++) {
                strArr[i10] = (String) f53889y.invoke(list2.get(i10), new Object[0]);
            }
            return strArr;
        } catch (Throwable th2) {
            th2.printStackTrace();
            f53890z = true;
            return null;
        }
    }

    /* renamed from: a */
    public static void m69282a() {
        f53843C.put("byte", Byte.TYPE);
        f53843C.put("short", Short.TYPE);
        f53843C.put("int", Integer.TYPE);
        f53843C.put("long", Long.TYPE);
        f53843C.put("float", Float.TYPE);
        f53843C.put("double", Double.TYPE);
        f53843C.put("boolean", Boolean.TYPE);
        f53843C.put("char", Character.TYPE);
        f53843C.put("[byte", byte[].class);
        f53843C.put("[short", short[].class);
        f53843C.put("[int", int[].class);
        f53843C.put("[long", long[].class);
        f53843C.put("[float", float[].class);
        f53843C.put("[double", double[].class);
        f53843C.put("[boolean", boolean[].class);
        f53843C.put("[char", char[].class);
        f53843C.put("[B", byte[].class);
        f53843C.put("[S", short[].class);
        f53843C.put("[I", int[].class);
        f53843C.put("[J", long[].class);
        f53843C.put("[F", float[].class);
        f53843C.put("[D", double[].class);
        f53843C.put("[C", char[].class);
        f53843C.put("[Z", boolean[].class);
        Class<?>[] clsArr = {Object.class, Cloneable.class, m69333z0("java.lang.AutoCloseable"), Exception.class, RuntimeException.class, IllegalAccessError.class, IllegalAccessException.class, IllegalArgumentException.class, IllegalMonitorStateException.class, IllegalStateException.class, IllegalThreadStateException.class, IndexOutOfBoundsException.class, InstantiationError.class, InstantiationException.class, InternalError.class, InterruptedException.class, LinkageError.class, NegativeArraySizeException.class, NoClassDefFoundError.class, NoSuchFieldError.class, NoSuchFieldException.class, NoSuchMethodError.class, NoSuchMethodException.class, NullPointerException.class, NumberFormatException.class, OutOfMemoryError.class, SecurityException.class, StackOverflowError.class, StringIndexOutOfBoundsException.class, TypeNotPresentException.class, VerifyError.class, StackTraceElement.class, HashMap.class, LinkedHashMap.class, Hashtable.class, TreeMap.class, IdentityHashMap.class, WeakHashMap.class, LinkedHashMap.class, HashSet.class, LinkedHashSet.class, TreeSet.class, ArrayList.class, TimeUnit.class, ConcurrentHashMap.class, AtomicInteger.class, AtomicLong.class, Collections.EMPTY_MAP.getClass(), Boolean.class, Character.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, Number.class, String.class, BigDecimal.class, BigInteger.class, BitSet.class, Calendar.class, java.util.Date.class, Locale.class, UUID.class, SimpleDateFormat.class, C9381e.class, C9382f.class, C9378b.class};
        for (int i10 = 0; i10 < 69; i10++) {
            Class<?> cls = clsArr[i10];
            if (cls != null) {
                f53843C.put(cls.getName(), cls);
            }
        }
        C11598j.m69234c(f53860T, f53843C);
    }

    /* renamed from: a0 */
    public static Constructor m69283a0(Constructor[] constructorArr) {
        return m69285b0(constructorArr, null);
    }

    /* renamed from: b */
    public static void m69284b(String str, Class<?> cls) {
        f53843C.put(str, cls);
    }

    /* renamed from: b0 */
    public static Constructor m69285b0(Constructor[] constructorArr, String[] strArr) {
        Constructor constructor = null;
        for (Constructor constructor2 : constructorArr) {
            Class<?>[] parameterTypes = constructor2.getParameterTypes();
            if ((strArr == null || parameterTypes.length == strArr.length) && ((parameterTypes.length <= 0 || !parameterTypes[parameterTypes.length - 1].getName().equals("uw.g")) && (constructor == null || constructor.getParameterTypes().length < parameterTypes.length))) {
                constructor = constructor2;
            }
        }
        return constructor;
    }

    /* renamed from: c */
    public static C10698z0 m69286c(Class<?> cls, Map<String, String> map, EnumC9389m enumC9389m) {
        return m69288d(cls, map, enumC9389m, false);
    }

    /* renamed from: c0 */
    public static Annotation[][] m69287c0(Constructor constructor) {
        Annotation[][] parameterAnnotations;
        Constructor declaredConstructor;
        Annotation[][] parameterAnnotations2 = constructor.getParameterAnnotations();
        Type typeM58761f = AbstractC9377a.m58761f(constructor.getDeclaringClass());
        Constructor constructor2 = null;
        Class cls = typeM58761f instanceof Class ? (Class) typeM58761f : null;
        if (cls != null) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            ArrayList arrayList = new ArrayList(2);
            for (Class<?> enclosingClass = cls.getEnclosingClass(); enclosingClass != null; enclosingClass = enclosingClass.getEnclosingClass()) {
                arrayList.add(enclosingClass);
            }
            int size = arrayList.size();
            Class superclass = cls;
            while (true) {
                if (superclass == null || superclass == Object.class) {
                    break;
                }
                try {
                    if (size != 0) {
                        Class<?>[] clsArr = new Class[parameterTypes.length + size];
                        System.arraycopy(parameterTypes, 0, clsArr, size, parameterTypes.length);
                        for (int i10 = size; i10 > 0; i10--) {
                            int i11 = i10 - 1;
                            clsArr[i11] = (Class) arrayList.get(i11);
                        }
                        declaredConstructor = cls.getDeclaredConstructor(clsArr);
                    } else {
                        declaredConstructor = cls.getDeclaredConstructor(parameterTypes);
                    }
                    constructor2 = declaredConstructor;
                } catch (NoSuchMethodException unused) {
                    size--;
                    superclass = superclass.getSuperclass();
                }
            }
            if (constructor2 != null && (parameterAnnotations = constructor2.getParameterAnnotations()) != null) {
                return parameterAnnotations;
            }
        }
        return parameterAnnotations2;
    }

    /* renamed from: d */
    public static C10698z0 m69288d(Class<?> cls, Map<String, String> map, EnumC9389m enumC9389m, boolean z10) {
        EnumC9389m enumC9389m2;
        int i10;
        String[] strArr;
        String str;
        String str2;
        List<C11592d> listM69247D;
        InterfaceC9643d interfaceC9643d = (InterfaceC9643d) m69265M(cls, InterfaceC9643d.class);
        if (interfaceC9643d != null) {
            String[] strArrOrders = interfaceC9643d.orders();
            String strTypeName = interfaceC9643d.typeName();
            if (strTypeName.length() == 0) {
                strTypeName = null;
            }
            EnumC9389m enumC9389mNaming = interfaceC9643d.naming();
            if (enumC9389mNaming == EnumC9389m.NeverUseThisValueExceptDefaultValue) {
                enumC9389mNaming = enumC9389m;
            }
            int iM65243h = EnumC10653e1.m65243h(interfaceC9643d.serialzeFeatures());
            String strTypeKey = null;
            for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
                InterfaceC9643d interfaceC9643d2 = (InterfaceC9643d) m69265M(superclass, InterfaceC9643d.class);
                if (interfaceC9643d2 == null) {
                    break;
                }
                strTypeKey = interfaceC9643d2.typeKey();
                if (strTypeKey.length() != 0) {
                    break;
                }
            }
            for (Class<?> cls2 : cls.getInterfaces()) {
                InterfaceC9643d interfaceC9643d3 = (InterfaceC9643d) m69265M(cls2, InterfaceC9643d.class);
                if (interfaceC9643d3 != null) {
                    strTypeKey = interfaceC9643d3.typeKey();
                    if (strTypeKey.length() != 0) {
                        break;
                    }
                }
            }
            str2 = (strTypeKey == null || strTypeKey.length() != 0) ? strTypeKey : null;
            str = strTypeName;
            enumC9389m2 = enumC9389mNaming;
            i10 = iM65243h;
            strArr = strArrOrders;
        } else {
            enumC9389m2 = enumC9389m;
            i10 = 0;
            strArr = null;
            str = null;
            str2 = null;
        }
        HashMap map2 = new HashMap();
        C10085i.m62851y(cls, map2);
        List<C11592d> listM69247D2 = z10 ? m69247D(cls, map, false, enumC9389m2) : m69245C(cls, interfaceC9643d, map, map2, false, enumC9389m2);
        C11592d[] c11592dArr = new C11592d[listM69247D2.size()];
        listM69247D2.toArray(c11592dArr);
        if (strArr == null || strArr.length == 0) {
            ArrayList arrayList = new ArrayList(listM69247D2);
            Collections.sort(arrayList);
            listM69247D = arrayList;
        } else {
            listM69247D = z10 ? m69247D(cls, map, true, enumC9389m2) : m69245C(cls, interfaceC9643d, map, map2, true, enumC9389m2);
        }
        C11592d[] c11592dArr2 = new C11592d[listM69247D.size()];
        listM69247D.toArray(c11592dArr2);
        return new C10698z0(cls, interfaceC9643d, str, str2, i10, c11592dArr, Arrays.equals(c11592dArr2, c11592dArr) ? c11592dArr : c11592dArr2);
    }

    /* renamed from: d0 */
    public static Annotation[][] m69289d0(Method method) {
        Annotation[][] parameterAnnotations;
        Annotation[][] parameterAnnotations2 = method.getParameterAnnotations();
        Type typeM58761f = AbstractC9377a.m58761f(method.getDeclaringClass());
        Method declaredMethod = null;
        Class superclass = typeM58761f instanceof Class ? (Class) typeM58761f : null;
        if (superclass != null) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            while (superclass != null && superclass != Object.class) {
                try {
                    declaredMethod = superclass.getDeclaredMethod(name, parameterTypes);
                    break;
                } catch (NoSuchMethodException unused) {
                    superclass = superclass.getSuperclass();
                }
            }
            if (declaredMethod != null && (parameterAnnotations = declaredMethod.getParameterAnnotations()) != null) {
                return parameterAnnotations;
            }
        }
        return parameterAnnotations2;
    }

    /* renamed from: e */
    public static byte m69290e(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return (byte) 0;
        }
        int iScale = bigDecimal.scale();
        return (iScale < -100 || iScale > 100) ? bigDecimal.byteValueExact() : bigDecimal.byteValue();
    }

    /* renamed from: e0 */
    public static int m69291e0(Class<?> cls) {
        InterfaceC9643d interfaceC9643d = (InterfaceC9643d) m69265M(cls, InterfaceC9643d.class);
        if (interfaceC9643d == null) {
            return 0;
        }
        return EnumC10078b.m62750f(interfaceC9643d.parseFeatures());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: f */
    public static <T> T m69292f(Object obj, Class<T> cls, C10085i c10085i) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        Object obj2;
        int i10 = 0;
        if (obj == 0) {
            if (cls == Integer.TYPE) {
                return (T) 0;
            }
            if (cls == Long.TYPE) {
                return (T) 0L;
            }
            if (cls == Short.TYPE) {
                return (T) (short) 0;
            }
            if (cls == Byte.TYPE) {
                return (T) (byte) 0;
            }
            if (cls == Float.TYPE) {
                return (T) Float.valueOf(0.0f);
            }
            if (cls == Double.TYPE) {
                return (T) Double.valueOf(0.0d);
            }
            if (cls == Boolean.TYPE) {
                return (T) Boolean.FALSE;
            }
            return null;
        }
        if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        }
        if (cls == obj.getClass()) {
            return obj;
        }
        if (obj instanceof Map) {
            if (cls == Map.class) {
                return obj;
            }
            Map map = (Map) obj;
            return (cls != Object.class || map.containsKey(AbstractC9377a.f46780c)) ? (T) m69322u(map, cls, c10085i) : obj;
        }
        if (cls.isArray()) {
            if (obj instanceof Collection) {
                Collection collection = (Collection) obj;
                T t10 = (T) Array.newInstance(cls.getComponentType(), collection.size());
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    Array.set(t10, i10, m69292f(it.next(), cls.getComponentType(), c10085i));
                    i10++;
                }
                return t10;
            }
            if (cls == byte[].class) {
                return (T) m69306m(obj);
            }
        }
        if (cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            return (T) m69302k(obj);
        }
        if (cls == Byte.TYPE || cls == Byte.class) {
            return (T) m69304l(obj);
        }
        if (cls == Character.TYPE || cls == Character.class) {
            return (T) m69308n(obj);
        }
        if (cls == Short.TYPE || cls == Short.class) {
            return (T) m69326w(obj);
        }
        if (cls == Integer.TYPE || cls == Integer.class) {
            return (T) m69320t(obj);
        }
        if (cls == Long.TYPE || cls == Long.class) {
            return (T) m69324v(obj);
        }
        if (cls == Float.TYPE || cls == Float.class) {
            return (T) m69318s(obj);
        }
        if (cls == Double.TYPE || cls == Double.class) {
            return (T) m69314q(obj);
        }
        if (cls == String.class) {
            return (T) m69332z(obj);
        }
        if (cls == BigDecimal.class) {
            return (T) m69298i(obj);
        }
        if (cls == BigInteger.class) {
            return (T) m69300j(obj);
        }
        if (cls == java.util.Date.class) {
            return (T) m69310o(obj);
        }
        T t11 = (T) C11598j.m69233b(f53859S, obj, cls);
        if (t11 != null) {
            return t11;
        }
        if (cls.isEnum()) {
            return (T) m69316r(obj, cls, c10085i);
        }
        if (Calendar.class.isAssignableFrom(cls)) {
            java.util.Date dateM69310o = m69310o(obj);
            if (cls == Calendar.class) {
                obj2 = (T) Calendar.getInstance(AbstractC9377a.f46778a, AbstractC9377a.f46779b);
            } else {
                try {
                    obj2 = (T) ((Calendar) cls.newInstance());
                } catch (Exception e10) {
                    throw new C9380d("can not cast to : " + cls.getName(), e10);
                }
            }
            ((Calendar) obj2).setTime(dateM69310o);
            return (T) obj2;
        }
        String name = cls.getName();
        if (name.equals("javax.xml.datatype.XMLGregorianCalendar")) {
            java.util.Date dateM69310o2 = m69310o(obj);
            Calendar calendar = Calendar.getInstance(AbstractC9377a.f46778a, AbstractC9377a.f46779b);
            calendar.setTime(dateM69310o2);
            return (T) C10677p.f51313b.m65309g(calendar);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (cls == Currency.class) {
                return (T) Currency.getInstance(str);
            }
            if (cls == Locale.class) {
                return (T) m69268N0(str);
            }
            if (name.startsWith("java.time.")) {
                return (T) AbstractC9377a.m58769p(AbstractC9377a.m58774x(str), cls);
            }
        }
        if (c10085i.m62864m(cls) != null) {
            return (T) AbstractC9377a.m58769p(AbstractC9377a.m58774x(obj), cls);
        }
        throw new C9380d("can not cast to : " + cls.getName());
    }

    /* renamed from: f0 */
    public static String m69293f0(Map<String, Field> map, String str, String str2, int i10) {
        if (!f53867c || map.containsKey(str2)) {
            return str2;
        }
        String strSubstring = str.substring(i10);
        return map.containsKey(strSubstring) ? strSubstring : str2;
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [T, java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r10v6, types: [T, java.util.HashMap, java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v14, types: [T, java.util.Map$Entry] */
    /* renamed from: g */
    public static <T> T m69294g(Object obj, ParameterizedType parameterizedType, C10085i c10085i) {
        Type rawType = parameterizedType.getRawType();
        if (rawType == List.class || rawType == ArrayList.class) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof List) {
                List list = (List) obj;
                ?? r10 = (T) new ArrayList(list.size());
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    r10.add(type instanceof Class ? (next == null || next.getClass() != C9381e.class) ? m69292f(next, (Class) type, c10085i) : ((C9381e) next).m58796P((Class) type, c10085i, 0) : m69296h(next, type, c10085i));
                }
                return r10;
            }
        }
        if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == Collection.class || rawType == List.class || rawType == ArrayList.class) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof Iterable) {
                T t10 = (rawType == Set.class || rawType == HashSet.class) ? (T) new HashSet() : rawType == TreeSet.class ? (T) new TreeSet() : (T) new ArrayList();
                Iterator<T> it2 = ((Iterable) obj).iterator();
                while (it2.hasNext()) {
                    T next2 = it2.next();
                    ((Collection) t10).add(type2 instanceof Class ? (next2 == null || next2.getClass() != C9381e.class) ? m69292f(next2, (Class) type2, c10085i) : ((C9381e) next2).m58796P((Class) type2, c10085i, 0) : m69296h(next2, type2, c10085i));
                }
                return t10;
            }
        }
        if (rawType == Map.class || rawType == HashMap.class) {
            Type type3 = parameterizedType.getActualTypeArguments()[0];
            Type type4 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof Map) {
                ?? r102 = (T) new HashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    r102.put(m69296h(entry.getKey(), type3, c10085i), m69296h(entry.getValue(), type4, c10085i));
                }
                return r102;
            }
        }
        if ((obj instanceof String) && ((String) obj).length() == 0) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (actualTypeArguments.length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
            return (T) m69296h(obj, rawType, c10085i);
        }
        if (rawType == Map.Entry.class && (obj instanceof Map)) {
            Map map = (Map) obj;
            if (map.size() == 1) {
                ?? r92 = (T) ((Map.Entry) map.entrySet().iterator().next());
                Object value = r92.getValue();
                if (actualTypeArguments.length == 2 && (value instanceof Map)) {
                    r92.setValue(m69296h(value, actualTypeArguments[1], c10085i));
                }
                return r92;
            }
        }
        if (rawType instanceof Class) {
            if (c10085i == null) {
                c10085i = C10085i.f49239z;
            }
            InterfaceC10408t interfaceC10408tM62867p = c10085i.m62867p(rawType);
            if (interfaceC10408tM62867p != null) {
                return (T) interfaceC10408tM62867p.mo63891b(new C10077a(AbstractC9377a.m58774x(obj), c10085i), parameterizedType, null);
            }
        }
        throw new C9380d("can not cast to : " + parameterizedType);
    }

    /* renamed from: g0 */
    public static String m69295g0(String str) {
        return Character.toLowerCase(str.charAt(3)) + str.substring(4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: h */
    public static <T> T m69296h(Object obj, Type type, C10085i c10085i) {
        if (obj == 0) {
            return null;
        }
        if (type instanceof Class) {
            return (T) m69292f(obj, (Class) type, c10085i);
        }
        if (type instanceof ParameterizedType) {
            return (T) m69294g(obj, (ParameterizedType) type, c10085i);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
        }
        if (type instanceof TypeVariable) {
            return obj;
        }
        throw new C9380d("can not cast to : " + type);
    }

    /* renamed from: h0 */
    public static Class<?> m69297h0(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return m69297h0(((ParameterizedType) type).getRawType());
        }
        if (!(type instanceof WildcardType)) {
            throw new C9380d("TODO");
        }
        Type[] upperBounds = ((WildcardType) type).getUpperBounds();
        if (upperBounds.length == 1) {
            return m69297h0(upperBounds[0]);
        }
        throw new C9380d("TODO");
    }

    /* renamed from: i */
    public static BigDecimal m69298i(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Float) {
            Float f10 = (Float) obj;
            if (Float.isNaN(f10.floatValue()) || Float.isInfinite(f10.floatValue())) {
                return null;
            }
        } else if (obj instanceof Double) {
            Double d10 = (Double) obj;
            if (Double.isNaN(d10.doubleValue()) || Double.isInfinite(d10.doubleValue())) {
                return null;
            }
        } else {
            if (obj instanceof BigDecimal) {
                return (BigDecimal) obj;
            }
            if (obj instanceof BigInteger) {
                return new BigDecimal((BigInteger) obj);
            }
            if ((obj instanceof Map) && ((Map) obj).size() == 0) {
                return null;
            }
        }
        String string = obj.toString();
        if (string.length() == 0 || string.equalsIgnoreCase("null")) {
            return null;
        }
        if (string.length() <= 65535) {
            return new BigDecimal(string);
        }
        throw new C9380d("decimal overflow");
    }

    /* renamed from: i0 */
    public static InterfaceC9641b m69299i0(Class<?> cls, Method method) throws SecurityException {
        Class<?>[] interfaces = cls.getInterfaces();
        if (interfaces.length > 0) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> cls2 : interfaces) {
                for (Method method2 : cls2.getMethods()) {
                    Class<?>[] parameterTypes2 = method2.getParameterTypes();
                    if (parameterTypes2.length == parameterTypes.length && method2.getName().equals(method.getName())) {
                        int i10 = 0;
                        while (true) {
                            if (i10 >= parameterTypes.length) {
                                InterfaceC9641b interfaceC9641b = (InterfaceC9641b) m69269O(method2, InterfaceC9641b.class);
                                if (interfaceC9641b != null) {
                                    return interfaceC9641b;
                                }
                            } else {
                                if (!parameterTypes2[i10].equals(parameterTypes[i10])) {
                                    break;
                                }
                                i10++;
                            }
                        }
                    }
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && Modifier.isAbstract(superclass.getModifiers())) {
            Class<?>[] parameterTypes3 = method.getParameterTypes();
            for (Method method3 : superclass.getMethods()) {
                Class<?>[] parameterTypes4 = method3.getParameterTypes();
                if (parameterTypes4.length == parameterTypes3.length && method3.getName().equals(method.getName())) {
                    int i11 = 0;
                    while (true) {
                        if (i11 >= parameterTypes3.length) {
                            InterfaceC9641b interfaceC9641b2 = (InterfaceC9641b) m69269O(method3, InterfaceC9641b.class);
                            if (interfaceC9641b2 != null) {
                                return interfaceC9641b2;
                            }
                        } else {
                            if (!parameterTypes4[i11].equals(parameterTypes3[i11])) {
                                break;
                            }
                            i11++;
                        }
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: j */
    public static BigInteger m69300j(Object obj) {
        BigDecimal bigDecimal;
        int iScale;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Float) {
            Float f10 = (Float) obj;
            if (Float.isNaN(f10.floatValue()) || Float.isInfinite(f10.floatValue())) {
                return null;
            }
            return BigInteger.valueOf(f10.longValue());
        }
        if (obj instanceof Double) {
            Double d10 = (Double) obj;
            if (Double.isNaN(d10.doubleValue()) || Double.isInfinite(d10.doubleValue())) {
                return null;
            }
            return BigInteger.valueOf(d10.longValue());
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if ((obj instanceof BigDecimal) && (iScale = (bigDecimal = (BigDecimal) obj).scale()) > -1000 && iScale < 1000) {
            return bigDecimal.toBigInteger();
        }
        String string = obj.toString();
        if (string.length() == 0 || string.equalsIgnoreCase("null")) {
            return null;
        }
        if (string.length() <= 65535) {
            return new BigInteger(string);
        }
        throw new C9380d("decimal overflow");
    }

    /* renamed from: j0 */
    public static Type m69301j0(Type type) {
        if (!(type instanceof WildcardType)) {
            return type;
        }
        Type[] upperBounds = ((WildcardType) type).getUpperBounds();
        return upperBounds.length > 0 ? upperBounds[0] : Object.class;
    }

    /* renamed from: k */
    public static Boolean m69302k(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof BigDecimal) {
            return Boolean.valueOf(m69303k0((BigDecimal) obj) == 1);
        }
        if (obj instanceof Number) {
            return Boolean.valueOf(((Number) obj).intValue() == 1);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (FaqConstants.DISABLE_HA_REPORT.equalsIgnoreCase(str) || "1".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(str) || "0".equals(str)) {
                return Boolean.FALSE;
            }
            if ("Y".equalsIgnoreCase(str) || CloudBackupConstant.UserPackageInfo.TRIAL_MEMBER.equals(str)) {
                return Boolean.TRUE;
            }
            if ("F".equalsIgnoreCase(str) || "N".equals(str)) {
                return Boolean.FALSE;
            }
        }
        throw new C9380d("can not cast to boolean, value : " + obj);
    }

    /* renamed from: k0 */
    public static int m69303k0(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return 0;
        }
        int iScale = bigDecimal.scale();
        return (iScale < -100 || iScale > 100) ? bigDecimal.intValueExact() : bigDecimal.intValue();
    }

    /* renamed from: l */
    public static Byte m69304l(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return Byte.valueOf(m69290e((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            return Byte.valueOf(Byte.parseByte(str));
        }
        if (obj instanceof Boolean) {
            return Byte.valueOf(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
        }
        throw new C9380d("can not cast to byte, value : " + obj);
    }

    /* renamed from: l0 */
    public static boolean m69305l0(Method method) {
        if (method == null) {
            return false;
        }
        if (f53879o == null && !f53880p) {
            try {
                f53879o = Class.forName("javax.persistence.ManyToMany");
            } catch (Throwable unused) {
                f53880p = true;
            }
        }
        if (f53879o != null) {
            return method.isAnnotationPresent(f53877m) || method.isAnnotationPresent(f53879o);
        }
        return false;
    }

    /* renamed from: m */
    public static byte[] m69306m(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            return C11595g.m69207b((String) obj);
        }
        throw new C9380d("can not cast to byte[], value : " + obj);
    }

    /* renamed from: m0 */
    public static boolean m69307m0(Method method) {
        if (method == null) {
            return false;
        }
        if (f53877m == null && !f53878n) {
            try {
                f53877m = Class.forName("javax.persistence.OneToMany");
            } catch (Throwable unused) {
                f53878n = true;
            }
        }
        Class<? extends Annotation> cls = f53877m;
        return cls != null && method.isAnnotationPresent(cls);
    }

    /* renamed from: n */
    public static Character m69308n(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (!(obj instanceof String)) {
            throw new C9380d("can not cast to char, value : " + obj);
        }
        String str = (String) obj;
        if (str.length() == 0) {
            return null;
        }
        if (str.length() == 1) {
            return Character.valueOf(str.charAt(0));
        }
        throw new C9380d("can not cast to char, value : " + obj);
    }

    /* renamed from: n0 */
    public static boolean m69309n0(Class cls) {
        Boolean bool = (Boolean) C11598j.m69234c(f53855O, cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* renamed from: o */
    public static java.util.Date m69310o(Object obj) {
        return m69312p(obj, null);
    }

    /* renamed from: o0 */
    public static boolean m69311o0(Type type) {
        if (type instanceof ParameterizedType) {
            return true;
        }
        if (!(type instanceof Class)) {
            return false;
        }
        Type genericSuperclass = ((Class) type).getGenericSuperclass();
        return genericSuperclass != Object.class && m69311o0(genericSuperclass);
    }

    /* renamed from: p */
    public static java.util.Date m69312p(Object obj, String str) throws NumberFormatException {
        long j10;
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.util.Date) {
            return (java.util.Date) obj;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof BigDecimal) {
            return new java.util.Date(m69248D0((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            long jLongValue = ((Number) obj).longValue();
            if ("unixtime".equals(str)) {
                jLongValue *= 1000;
            }
            return new java.util.Date(jLongValue);
        }
        if (obj instanceof String) {
            String strSubstring = (String) obj;
            C10082f c10082f = new C10082f(strSubstring);
            try {
                if (c10082f.m62838u1(false)) {
                    return c10082f.m62795G0().getTime();
                }
                c10082f.close();
                if (strSubstring.startsWith("/Date(") && strSubstring.endsWith(")/")) {
                    strSubstring = strSubstring.substring(6, strSubstring.length() - 2);
                }
                if (strSubstring.indexOf(45) > 0 || strSubstring.indexOf(43) > 0 || str != null) {
                    if (str == null) {
                        int length = strSubstring.length();
                        str = (length == AbstractC9377a.f46782e.length() || (length == 22 && AbstractC9377a.f46782e.equals("yyyyMMddHHmmssSSSZ"))) ? AbstractC9377a.f46782e : length == 10 ? "yyyy-MM-dd" : length == 19 ? "yyyy-MM-dd HH:mm:ss" : (length == 29 && strSubstring.charAt(26) == ':' && strSubstring.charAt(28) == '0') ? "yyyy-MM-dd'T'HH:mm:ss.SSSXXX" : (length == 23 && strSubstring.charAt(19) == ',') ? "yyyy-MM-dd HH:mm:ss,SSS" : "yyyy-MM-dd HH:mm:ss.SSS";
                    }
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, AbstractC9377a.f46779b);
                    simpleDateFormat.setTimeZone(AbstractC9377a.f46778a);
                    try {
                        return simpleDateFormat.parse(strSubstring);
                    } catch (ParseException unused) {
                        throw new C9380d("can not cast to Date, value : " + strSubstring);
                    }
                }
                if (strSubstring.length() == 0) {
                    return null;
                }
                j10 = Long.parseLong(strSubstring);
            } finally {
                c10082f.close();
            }
        } else {
            j10 = -1;
        }
        if (j10 != -1) {
            return new java.util.Date(j10);
        }
        Class<?> cls = obj.getClass();
        if ("oracle.sql.TIMESTAMP".equals(cls.getName())) {
            if (f53870f == null && !f53869e) {
                try {
                    f53870f = cls.getMethod("toJdbc", new Class[0]);
                } catch (NoSuchMethodException unused2) {
                } catch (Throwable th2) {
                    f53869e = true;
                    throw th2;
                }
                f53869e = true;
            }
            try {
                return (java.util.Date) f53870f.invoke(obj, new Object[0]);
            } catch (Exception e10) {
                throw new C9380d("can not cast oracle.sql.TIMESTAMP to Date", e10);
            }
        }
        if (!"oracle.sql.DATE".equals(cls.getName())) {
            throw new C9380d("can not cast to Date, value : " + obj);
        }
        if (f53872h == null && !f53871g) {
            try {
                f53872h = cls.getMethod("toJdbc", new Class[0]);
            } catch (NoSuchMethodException unused3) {
            } catch (Throwable th3) {
                f53871g = true;
                throw th3;
            }
            f53871g = true;
        }
        try {
            return (java.util.Date) f53872h.invoke(obj, new Object[0]);
        } catch (Exception e11) {
            throw new C9380d("can not cast oracle.sql.DATE to Date", e11);
        }
    }

    /* renamed from: p0 */
    public static boolean m69313p0(Object obj) {
        if (obj == null) {
            return false;
        }
        if (f53881q == null && !f53882r) {
            try {
                f53881q = Class.forName("org.hibernate.Hibernate").getMethod("isInitialized", Object.class);
            } catch (Throwable unused) {
                f53882r = true;
            }
        }
        Method method = f53881q;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(null, obj)).booleanValue();
            } catch (Throwable unused2) {
            }
        }
        return true;
    }

    /* renamed from: q */
    public static Double m69314q(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (!(obj instanceof String)) {
            if (obj instanceof Boolean) {
                return Double.valueOf(((Boolean) obj).booleanValue() ? 1.0d : 0.0d);
            }
            throw new C9380d("can not cast to double, value : " + obj);
        }
        String string = obj.toString();
        if (string.length() == 0 || "null".equals(string) || "NULL".equals(string)) {
            return null;
        }
        if (string.indexOf(44) != -1) {
            string = string.replaceAll(",", "");
        }
        return Double.valueOf(Double.parseDouble(string));
    }

    /* renamed from: q0 */
    public static boolean m69315q0(Class<?> cls, String str) {
        InterfaceC9643d interfaceC9643d = (InterfaceC9643d) m69265M(cls, InterfaceC9643d.class);
        if (interfaceC9643d != null) {
            String[] strArrIncludes = interfaceC9643d.includes();
            if (strArrIncludes.length > 0) {
                for (String str2 : strArrIncludes) {
                    if (str.equals(str2)) {
                        return false;
                    }
                }
                return true;
            }
            for (String str3 : interfaceC9643d.ignores()) {
                if (str.equals(str3)) {
                    return true;
                }
            }
        }
        if (cls.getSuperclass() == Object.class || cls.getSuperclass() == null) {
            return false;
        }
        return m69315q0(cls.getSuperclass(), str);
    }

    /* renamed from: r */
    public static <T> T m69316r(Object obj, Class<T> cls, C10085i c10085i) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                if (c10085i == null) {
                    c10085i = C10085i.m62849t();
                }
                InterfaceC10408t interfaceC10408tM62867p = c10085i.m62867p(cls);
                return interfaceC10408tM62867p instanceof C10396h ? (T) ((C10396h) interfaceC10408tM62867p).m63901d(m69257I(str)) : (T) Enum.valueOf(cls, str);
            }
            if (obj instanceof BigDecimal) {
                int iM69303k0 = m69303k0((BigDecimal) obj);
                T[] enumConstants = cls.getEnumConstants();
                if (iM69303k0 < enumConstants.length) {
                    return enumConstants[iM69303k0];
                }
            }
            if (obj instanceof Number) {
                int iIntValue = ((Number) obj).intValue();
                T[] enumConstants2 = cls.getEnumConstants();
                if (iIntValue < enumConstants2.length) {
                    return enumConstants2[iIntValue];
                }
            }
            throw new C9380d("can not cast to : " + cls.getName());
        } catch (Exception e10) {
            throw new C9380d("can not cast to : " + cls.getName(), e10);
        }
    }

    /* renamed from: r0 */
    public static boolean m69317r0(Method method) {
        if (method == null) {
            return false;
        }
        if (f53846F == null && !f53847G) {
            try {
                f53846F = Class.forName("com.fasterxml.jackson.annotation.JsonCreator");
            } catch (Throwable unused) {
                f53847G = true;
            }
        }
        Class<? extends Annotation> cls = f53846F;
        return cls != null && method.isAnnotationPresent(cls);
    }

    /* renamed from: s */
    public static Float m69318s(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (!(obj instanceof String)) {
            if (obj instanceof Boolean) {
                return Float.valueOf(((Boolean) obj).booleanValue() ? 1.0f : 0.0f);
            }
            throw new C9380d("can not cast to float, value : " + obj);
        }
        String string = obj.toString();
        if (string.length() == 0 || "null".equals(string) || "NULL".equals(string)) {
            return null;
        }
        if (string.indexOf(44) != -1) {
            string = string.replaceAll(",", "");
        }
        return Float.valueOf(Float.parseFloat(string));
    }

    /* renamed from: s0 */
    public static boolean m69319s0(Class cls) {
        if (f53883s == null && !f53884t) {
            try {
                f53883s = InterfaceC10943i.class;
            } catch (Throwable unused) {
                f53884t = true;
            }
        }
        return f53883s != null && cls.isAnnotationPresent(f53883s);
    }

    /* renamed from: t */
    public static Integer m69320t(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof BigDecimal) {
            return Integer.valueOf(m69303k0((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            String strReplaceAll = (String) obj;
            if (strReplaceAll.length() == 0 || "null".equals(strReplaceAll) || "NULL".equals(strReplaceAll)) {
                return null;
            }
            if (strReplaceAll.indexOf(44) != -1) {
                strReplaceAll = strReplaceAll.replaceAll(",", "");
            }
            Matcher matcher = f53865a.matcher(strReplaceAll);
            if (matcher.find()) {
                strReplaceAll = matcher.replaceAll("");
            }
            return Integer.valueOf(Integer.parseInt(strReplaceAll));
        }
        if (obj instanceof Boolean) {
            return Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                Iterator it = map.values().iterator();
                it.next();
                return m69320t(it.next());
            }
        }
        throw new C9380d("can not cast to int, value : " + obj);
    }

    /* renamed from: t0 */
    public static boolean m69321t0(Class cls, String str) {
        if (f53841A == null && !f53842B) {
            try {
                HashMap map = new HashMap();
                C13874c.a aVar = C13874c.f62164e;
                map.put(C13874c.class, new String[]{"getEndInclusive", "isEmpty"});
                C13879h.a aVar2 = C13879h.f62178e;
                map.put(C13879h.class, new String[]{"getEndInclusive", "isEmpty"});
                C13882k.a aVar3 = C13882k.f62188e;
                map.put(C13882k.class, new String[]{"getEndInclusive", "isEmpty"});
                map.put(C13876e.class, new String[]{"getEndInclusive", "isEmpty"});
                map.put(C13875d.class, new String[]{"getEndInclusive", "isEmpty"});
                f53841A = map;
            } catch (Throwable unused) {
                f53842B = true;
            }
        }
        if (f53841A == null) {
            return false;
        }
        String[] strArr = f53841A.get(cls);
        return strArr != null && Arrays.binarySearch(strArr, str) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: u */
    public static <T> T m69322u(Map<String, Object> map, Class<T> cls, C10085i c10085i) throws ClassNotFoundException {
        try {
            if (cls == StackTraceElement.class) {
                String str = (String) map.get("className");
                String str2 = (String) map.get("methodName");
                String str3 = (String) map.get(ContentResource.FILE_NAME);
                Number number = (Number) map.get("lineNumber");
                return (T) new StackTraceElement(str, str2, str3, number == null ? 0 : number instanceof BigDecimal ? ((BigDecimal) number).intValueExact() : number.intValue());
            }
            Object obj = map.get(AbstractC9377a.f46780c);
            if (obj instanceof String) {
                String str4 = (String) obj;
                if (c10085i == null) {
                    c10085i = C10085i.f49239z;
                }
                Class<?> clsM62860i = c10085i.m62860i(str4, null);
                if (clsM62860i == null) {
                    throw new ClassNotFoundException(str4 + " not found");
                }
                if (!clsM62860i.equals(cls)) {
                    return (T) m69322u(map, clsM62860i, c10085i);
                }
            }
            if (cls.isInterface()) {
                C9381e c9381e = map instanceof C9381e ? (C9381e) map : new C9381e(map);
                if (c10085i == null) {
                    c10085i = C10085i.m62849t();
                }
                return c10085i.m62864m(cls) != null ? (T) AbstractC9377a.m58769p(AbstractC9377a.m58774x(c9381e), cls) : (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, c9381e);
            }
            if (cls == Locale.class) {
                Object obj2 = map.get(FaqConstants.FAQ_EMUI_LANGUAGE);
                Object obj3 = map.get("country");
                if (obj2 instanceof String) {
                    String str5 = (String) obj2;
                    if (obj3 instanceof String) {
                        return (T) new Locale(str5, (String) obj3);
                    }
                    if (obj3 == null) {
                        return (T) new Locale(str5);
                    }
                }
            }
            if (cls == String.class && (map instanceof C9381e)) {
                return (T) map.toString();
            }
            if (cls == AbstractC9377a.class && (map instanceof C9381e)) {
                return map;
            }
            if (cls == LinkedHashMap.class && (map instanceof C9381e)) {
                T t10 = (T) ((C9381e) map).m58790J();
                if (t10 instanceof LinkedHashMap) {
                    return t10;
                }
            }
            if (cls.isInstance(map)) {
                return map;
            }
            if (cls == C9381e.class) {
                return (T) new C9381e(map);
            }
            if (c10085i == null) {
                c10085i = C10085i.m62849t();
            }
            InterfaceC10408t interfaceC10408tM62867p = c10085i.m62867p(cls);
            C10403o c10403o = interfaceC10408tM62867p instanceof C10403o ? (C10403o) interfaceC10408tM62867p : null;
            if (c10403o != null) {
                return (T) c10403o.m63920g(map, c10085i);
            }
            throw new C9380d("can not get javaBeanDeserializer. " + cls.getName());
        } catch (Exception e10) {
            throw new C9380d(e10.getMessage(), e10);
        }
    }

    /* renamed from: u0 */
    public static boolean m69323u0(String str) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '+' || cCharAt == '-') {
                if (i10 != 0) {
                    return false;
                }
            } else if (cCharAt < '0' || cCharAt > '9') {
                return false;
            }
        }
        return true;
    }

    /* renamed from: v */
    public static Long m69324v(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return Long.valueOf(m69248D0((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String strReplaceAll = (String) obj;
            if (strReplaceAll.length() == 0 || "null".equals(strReplaceAll) || "NULL".equals(strReplaceAll)) {
                return null;
            }
            if (strReplaceAll.indexOf(44) != -1) {
                strReplaceAll = strReplaceAll.replaceAll(",", "");
            }
            try {
                return Long.valueOf(Long.parseLong(strReplaceAll));
            } catch (NumberFormatException unused) {
                C10082f c10082f = new C10082f(strReplaceAll);
                Calendar calendarM62795G0 = c10082f.m62838u1(false) ? c10082f.m62795G0() : null;
                c10082f.close();
                if (calendarM62795G0 != null) {
                    return Long.valueOf(calendarM62795G0.getTimeInMillis());
                }
            }
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                Iterator it = map.values().iterator();
                it.next();
                return m69324v(it.next());
            }
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
        }
        throw new C9380d("can not cast to long, value : " + obj);
    }

    /* renamed from: v0 */
    public static boolean m69325v0(Class<?> cls) {
        if (f53844D == null && !f53845E) {
            try {
                f53844D = Path.class;
            } catch (Throwable unused) {
                f53845E = true;
            }
        }
        Class<?> cls2 = f53844D;
        if (cls2 != null) {
            return cls2.isAssignableFrom(cls);
        }
        return false;
    }

    /* renamed from: w */
    public static Short m69326w(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return Short.valueOf(m69266M0((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            return Short.valueOf(Short.parseShort(str));
        }
        if (obj instanceof Boolean) {
            return Short.valueOf(((Boolean) obj).booleanValue() ? (short) 1 : (short) 0);
        }
        throw new C9380d("can not cast to short, value : " + obj);
    }

    /* renamed from: w0 */
    public static boolean m69327w0(Class<?> cls) {
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (f53862V.contains(cls2.getName())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: x */
    public static Object m69328x(Object obj) {
        return C11598j.m69234c(f53856P, obj);
    }

    /* renamed from: x0 */
    public static boolean m69329x0(Method method) {
        if (method == null) {
            return false;
        }
        if (!f53875k) {
            try {
                f53876l = Class.forName("java.beans.Transient");
            } catch (Exception unused) {
            } catch (Throwable th2) {
                f53875k = true;
                throw th2;
            }
            f53875k = true;
        }
        Class<? extends Annotation> cls = f53876l;
        return (cls == null || m69269O(method, cls) == null) ? false : true;
    }

    /* renamed from: y */
    public static Object m69330y(Object obj) {
        return C11598j.m69234c(f53857Q, obj);
    }

    /* renamed from: y0 */
    public static boolean m69331y0(Class cls) {
        Annotation annotationM69265M;
        Object objInvoke;
        if (f53849I == null && !f53850J) {
            try {
                f53849I = Class.forName("javax.xml.bind.annotation.XmlAccessorType");
            } catch (Throwable unused) {
                f53850J = true;
            }
        }
        if (f53849I == null || (annotationM69265M = m69265M(cls, f53849I)) == null) {
            return false;
        }
        if (f53851K == null && !f53850J) {
            try {
                f53851K = f53849I.getMethod("value", new Class[0]);
            } catch (Throwable unused2) {
                f53850J = true;
            }
        }
        if (f53851K == null) {
            return false;
        }
        if (f53850J) {
            objInvoke = null;
        } else {
            try {
                objInvoke = f53851K.invoke(annotationM69265M, new Object[0]);
            } catch (Throwable unused3) {
                f53850J = true;
            }
        }
        if (objInvoke == null) {
            return false;
        }
        if (f53848H == null && !f53850J) {
            try {
                f53848H = Class.forName("javax.xml.bind.annotation.XmlAccessType");
                f53852L = f53848H.getField("FIELD");
                f53853M = f53852L.get(null);
            } catch (Throwable unused4) {
                f53850J = true;
            }
        }
        return objInvoke == f53853M;
    }

    /* renamed from: z */
    public static String m69332z(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    /* renamed from: z0 */
    public static Class<?> m69333z0(String str) {
        return m69242A0(str, null);
    }
}

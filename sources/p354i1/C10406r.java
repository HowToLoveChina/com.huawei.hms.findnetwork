package p354i1;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import p244e1.AbstractC9377a;
import p244e1.C9380d;
import p244e1.C9381e;
import p323h1.C10077a;
import p323h1.C10083g;
import p323h1.C10084h;
import p323h1.EnumC10078b;
import p323h1.InterfaceC10079c;

/* renamed from: i1.r */
/* loaded from: classes.dex */
public class C10406r extends AbstractC10393e implements InterfaceC10408t {

    /* renamed from: a */
    public static C10406r f50233a = new C10406r();

    /* renamed from: j */
    public static Object m63938j(C10077a c10077a, Map<Object, Object> map, Type type, Type type2, Object obj) {
        Object objMo63891b;
        InterfaceC10079c interfaceC10079c = c10077a.f49153f;
        if (interfaceC10079c.mo62768a0() != 12 && interfaceC10079c.mo62768a0() != 16) {
            throw new C9380d("syntax error, expect {, actual " + interfaceC10079c.mo62782t0());
        }
        InterfaceC10408t interfaceC10408tM62867p = c10077a.m62737s().m62867p(type);
        InterfaceC10408t interfaceC10408tM62867p2 = c10077a.m62737s().m62867p(type2);
        interfaceC10079c.mo62756D(interfaceC10408tM62867p.mo63892c());
        C10084h c10084hM62739t = c10077a.m62739t();
        while (interfaceC10079c.mo62768a0() != 13) {
            try {
                Object obj2 = null;
                if (interfaceC10079c.mo62768a0() == 4 && interfaceC10079c.mo62754B0() && !interfaceC10079c.mo62788x0(EnumC10078b.DisableSpecialKeyDetect)) {
                    interfaceC10079c.mo62762I(4);
                    if (interfaceC10079c.mo62768a0() != 4) {
                        throw new C9380d("illegal ref, " + C10083g.m62844a(interfaceC10079c.mo62768a0()));
                    }
                    String strMo62763J = interfaceC10079c.mo62763J();
                    if ("..".equals(strMo62763J)) {
                        obj2 = c10084hM62739t.f49223b.f49222a;
                    } else if ("$".equals(strMo62763J)) {
                        C10084h c10084h = c10084hM62739t;
                        while (true) {
                            C10084h c10084h2 = c10084h.f49223b;
                            if (c10084h2 == null) {
                                break;
                            }
                            c10084h = c10084h2;
                        }
                        obj2 = c10084h.f49222a;
                    } else {
                        c10077a.m62726g(new C10077a.a(c10084hM62739t, strMo62763J));
                        c10077a.m62746x0(1);
                    }
                    interfaceC10079c.mo62756D(13);
                    if (interfaceC10079c.mo62768a0() != 13) {
                        throw new C9380d("illegal ref");
                    }
                    interfaceC10079c.mo62756D(16);
                    return obj2;
                }
                if (map.size() == 0 && interfaceC10079c.mo62768a0() == 4 && AbstractC9377a.f46780c.equals(interfaceC10079c.mo62763J()) && !interfaceC10079c.mo62788x0(EnumC10078b.DisableSpecialKeyDetect)) {
                    interfaceC10079c.mo62762I(4);
                    interfaceC10079c.mo62756D(16);
                    if (interfaceC10079c.mo62768a0() == 13) {
                        interfaceC10079c.mo62790z();
                        return map;
                    }
                    interfaceC10079c.mo62756D(interfaceC10408tM62867p.mo63892c());
                }
                if (interfaceC10079c.mo62768a0() == 4 && (interfaceC10408tM62867p instanceof C10403o)) {
                    String strMo62763J2 = interfaceC10079c.mo62763J();
                    interfaceC10079c.mo62790z();
                    C10077a c10077a2 = new C10077a(strMo62763J2, c10077a.m62737s(), c10077a.m62706A().mo62770c0());
                    c10077a2.m62740t0(c10077a.m62741u());
                    objMo63891b = interfaceC10408tM62867p.mo63891b(c10077a2, type, null);
                } else {
                    objMo63891b = interfaceC10408tM62867p.mo63891b(c10077a, type, null);
                }
                if (interfaceC10079c.mo62768a0() != 17) {
                    throw new C9380d("syntax error, expect :, actual " + interfaceC10079c.mo62768a0());
                }
                interfaceC10079c.mo62756D(interfaceC10408tM62867p2.mo63892c());
                Object objMo63891b2 = interfaceC10408tM62867p2.mo63891b(c10077a, type2, objMo63891b);
                c10077a.m62729i(map, objMo63891b);
                map.put(objMo63891b, objMo63891b2);
                if (interfaceC10079c.mo62768a0() == 16) {
                    interfaceC10079c.mo62756D(interfaceC10408tM62867p.mo63892c());
                }
            } finally {
                c10077a.m62738s0(c10084hM62739t);
            }
        }
        interfaceC10079c.mo62756D(16);
        return map;
    }

    /* JADX WARN: Code restructure failed: missing block: B:245:0x022e, code lost:
    
        return r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:227:0x01ec A[Catch: all -> 0x00c3, TRY_ENTER, TryCatch #1 {all -> 0x00c3, blocks: (B:160:0x00a5, B:164:0x00b8, B:170:0x00d0, B:195:0x0165, B:197:0x0177, B:199:0x017f, B:201:0x0185, B:205:0x019c, B:208:0x01a7, B:211:0x01ae, B:212:0x01b6, B:214:0x01be, B:216:0x01c7, B:219:0x01ce, B:221:0x01db, B:223:0x01df, B:224:0x01e2, B:227:0x01ec, B:229:0x01f1, B:230:0x01f4, B:232:0x01fc, B:234:0x0205, B:240:0x0220, B:233:0x0201, B:173:0x00e3, B:174:0x00fb, B:177:0x0100, B:182:0x0113, B:184:0x011b, B:187:0x012d, B:188:0x0145, B:189:0x0146, B:190:0x014b, B:191:0x014c, B:193:0x0154, B:246:0x022f, B:247:0x024f, B:248:0x0250, B:249:0x0255), top: B:255:0x00a5 }] */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map m63939k(p323h1.C10077a r11, java.util.Map<java.lang.String, java.lang.Object> r12, java.lang.reflect.Type r13, java.lang.Object r14, int r15) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p354i1.C10406r.m63939k(h1.a, java.util.Map, java.lang.reflect.Type, java.lang.Object, int):java.util.Map");
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 12;
    }

    @Override // p354i1.AbstractC10393e
    /* renamed from: f */
    public <T> T mo63893f(C10077a c10077a, Type type, Object obj, String str, int i10) {
        if (type == C9381e.class && c10077a.m62747y() == null) {
            return (T) c10077a.m62720a0();
        }
        InterfaceC10079c interfaceC10079c = c10077a.f49153f;
        if (interfaceC10079c.mo62768a0() == 8) {
            interfaceC10079c.mo62756D(16);
            return null;
        }
        boolean z10 = (type instanceof Class) && "java.util.Collections$UnmodifiableMap".equals(((Class) type).getName());
        Map<Object, Object> mapM63941h = (interfaceC10079c.mo62770c0() & EnumC10078b.OrderedField.f49196a) != 0 ? m63941h(type, interfaceC10079c.mo62770c0()) : m63940g(type);
        C10084h c10084hM62739t = c10077a.m62739t();
        try {
            c10077a.m62735q0(c10084hM62739t, mapM63941h, obj);
            Map map = (T) m63942i(c10077a, type, obj, mapM63941h, i10);
            if (z10) {
                map = (T) Collections.unmodifiableMap(map);
            }
            return (T) map;
        } finally {
            c10077a.m62738s0(c10084hM62739t);
        }
    }

    /* renamed from: g */
    public Map<Object, Object> m63940g(Type type) {
        return m63941h(type, AbstractC9377a.f46784g);
    }

    /* renamed from: h */
    public Map<Object, Object> m63941h(Type type, int i10) {
        if (type == Properties.class) {
            return new Properties();
        }
        if (type == Hashtable.class) {
            return new Hashtable();
        }
        if (type == IdentityHashMap.class) {
            return new IdentityHashMap();
        }
        if (type == SortedMap.class || type == TreeMap.class) {
            return new TreeMap();
        }
        if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
            return new ConcurrentHashMap();
        }
        if (type == Map.class) {
            return (EnumC10078b.OrderedField.f49196a & i10) != 0 ? new LinkedHashMap() : new HashMap();
        }
        if (type == HashMap.class) {
            return new HashMap();
        }
        if (type == LinkedHashMap.class) {
            return new LinkedHashMap();
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            return EnumMap.class.equals(rawType) ? new EnumMap((Class) parameterizedType.getActualTypeArguments()[0]) : m63941h(rawType, i10);
        }
        Class cls = (Class) type;
        if (cls.isInterface()) {
            throw new C9380d("unsupport type " + type);
        }
        if ("java.util.Collections$UnmodifiableMap".equals(cls.getName())) {
            return new HashMap();
        }
        try {
            return (Map) cls.newInstance();
        } catch (Exception e10) {
            throw new C9380d("unsupport type " + type, e10);
        }
    }

    /* renamed from: i */
    public Object m63942i(C10077a c10077a, Type type, Object obj, Map map, int i10) {
        if (!(type instanceof ParameterizedType)) {
            return c10077a.m62731j0(map, obj);
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type type2 = parameterizedType.getActualTypeArguments()[0];
        Type type3 = map.getClass().getName().equals("org.springframework.util.LinkedMultiValueMap") ? List.class : parameterizedType.getActualTypeArguments()[1];
        return String.class == type2 ? m63939k(c10077a, map, type3, obj, i10) : m63938j(c10077a, map, type2, type3, obj);
    }
}

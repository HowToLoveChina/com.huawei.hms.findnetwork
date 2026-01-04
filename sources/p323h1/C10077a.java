package p323h1;

import java.io.Closeable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import p244e1.AbstractC9377a;
import p244e1.C9378b;
import p244e1.C9380d;
import p244e1.C9381e;
import p244e1.C9383g;
import p244e1.C9384h;
import p354i1.AbstractC10400l;
import p354i1.C10403o;
import p354i1.C10413y;
import p354i1.InterfaceC10397i;
import p354i1.InterfaceC10398j;
import p354i1.InterfaceC10399k;
import p354i1.InterfaceC10401m;
import p354i1.InterfaceC10408t;
import p354i1.InterfaceC10411w;
import p381j1.C10641a1;
import p381j1.C10649d0;
import p381j1.C10656f1;
import p381j1.C10676o0;
import p481n1.C11592d;
import p481n1.C11603o;

/* renamed from: h1.a */
/* loaded from: classes.dex */
public class C10077a implements Closeable {

    /* renamed from: q */
    public static final Set<Class<?>> f49147q;

    /* renamed from: a */
    public final Object f49148a;

    /* renamed from: b */
    public final C10086j f49149b;

    /* renamed from: c */
    public C10085i f49150c;

    /* renamed from: d */
    public String f49151d;

    /* renamed from: e */
    public DateFormat f49152e;

    /* renamed from: f */
    public final InterfaceC10079c f49153f;

    /* renamed from: g */
    public C10084h f49154g;

    /* renamed from: h */
    public C10084h[] f49155h;

    /* renamed from: i */
    public int f49156i;

    /* renamed from: j */
    public List<a> f49157j;

    /* renamed from: k */
    public int f49158k;

    /* renamed from: l */
    public List<InterfaceC10399k> f49159l;

    /* renamed from: m */
    public List<InterfaceC10398j> f49160m;

    /* renamed from: n */
    public InterfaceC10401m f49161n;

    /* renamed from: o */
    public int f49162o;

    /* renamed from: p */
    public String[] f49163p;

    /* renamed from: h1.a$a */
    public static class a {

        /* renamed from: a */
        public final C10084h f49164a;

        /* renamed from: b */
        public final String f49165b;

        /* renamed from: c */
        public AbstractC10400l f49166c;

        /* renamed from: d */
        public C10084h f49167d;

        public a(C10084h c10084h, String str) {
            this.f49164a = c10084h;
            this.f49165b = str;
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f49147q = hashSet;
        hashSet.addAll(Arrays.asList(Boolean.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Boolean.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, BigInteger.class, BigDecimal.class, String.class));
    }

    public C10077a(String str) {
        this(str, C10085i.m62849t(), AbstractC9377a.f46783f);
    }

    /* renamed from: A */
    public InterfaceC10079c m62706A() {
        return this.f49153f;
    }

    /* renamed from: B */
    public Object m62707B(String str) {
        for (int i10 = 0; i10 < this.f49156i; i10++) {
            if (str.equals(this.f49155h[i10].toString())) {
                return this.f49155h[i10].f49222a;
            }
        }
        return null;
    }

    /* renamed from: C */
    public int m62708C() {
        return this.f49158k;
    }

    /* renamed from: D */
    public C10086j m62709D() {
        return this.f49149b;
    }

    /* renamed from: E */
    public void m62710E(Object obj) {
        Object objM58805f;
        C10084h c10084h;
        C11592d c11592d;
        List<a> list = this.f49157j;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            a aVar = this.f49157j.get(i10);
            String str = aVar.f49165b;
            C10084h c10084h2 = aVar.f49167d;
            Object obj2 = c10084h2 != null ? c10084h2.f49222a : null;
            if (str.startsWith("$")) {
                objM58805f = m62707B(str);
                if (objM58805f == null) {
                    try {
                        C9383g c9383g = new C9383g(str, C10641a1.m65181g(), this.f49150c, true);
                        if (c9383g.m58813o()) {
                            objM58805f = c9383g.m58805f(obj);
                        }
                    } catch (C9384h unused) {
                    }
                }
            } else {
                objM58805f = aVar.f49164a.f49222a;
            }
            AbstractC10400l abstractC10400l = aVar.f49166c;
            if (abstractC10400l != null) {
                if (objM58805f != null && objM58805f.getClass() == C9381e.class && (c11592d = abstractC10400l.f50198a) != null && !Map.class.isAssignableFrom(c11592d.f53772e)) {
                    Object obj3 = this.f49155h[0].f49222a;
                    C9383g c9383gM58801b = C9383g.m58801b(str);
                    if (c9383gM58801b.m58813o()) {
                        objM58805f = c9383gM58801b.m58805f(obj3);
                    }
                }
                if (abstractC10400l.m63908c() != null && !abstractC10400l.m63908c().isInstance(obj2) && (c10084h = aVar.f49167d.f49223b) != null) {
                    while (true) {
                        if (c10084h == null) {
                            break;
                        }
                        if (abstractC10400l.m63908c().isInstance(c10084h.f49222a)) {
                            obj2 = c10084h.f49222a;
                            break;
                        }
                        c10084h = c10084h.f49223b;
                    }
                }
                abstractC10400l.mo63911h(obj2, objM58805f);
            }
        }
    }

    /* renamed from: F */
    public boolean m62711F(EnumC10078b enumC10078b) {
        return this.f49153f.mo62788x0(enumC10078b);
    }

    /* renamed from: G */
    public Object m62712G() {
        return m62714I(null);
    }

    /* renamed from: H */
    public Object m62713H(InterfaceC10411w interfaceC10411w, Object obj) {
        String strMo62780s0;
        int i10 = 0;
        if (this.f49153f.mo62768a0() != 12) {
            String str = "syntax error, expect {, actual " + this.f49153f.mo62782t0();
            if (obj instanceof String) {
                str = (str + ", fieldName ") + obj;
            }
            String str2 = (str + ", ") + this.f49153f.mo62781t();
            C9378b c9378b = new C9378b();
            m62718Y(c9378b, obj);
            if (c9378b.size() == 1) {
                Object obj2 = c9378b.get(0);
                if (obj2 instanceof C9381e) {
                    return (C9381e) obj2;
                }
            }
            throw new C9380d(str2);
        }
        C10084h c10084h = this.f49154g;
        while (true) {
            try {
                this.f49153f.mo62775n0();
                char cMo62773j0 = this.f49153f.mo62773j0();
                if (this.f49153f.mo62788x0(EnumC10078b.AllowArbitraryCommas)) {
                    while (cMo62773j0 == ',') {
                        this.f49153f.next();
                        this.f49153f.mo62775n0();
                        cMo62773j0 = this.f49153f.mo62773j0();
                    }
                }
                if (cMo62773j0 == '\"') {
                    strMo62780s0 = this.f49153f.mo62767Z(this.f49149b, '\"');
                    this.f49153f.mo62775n0();
                    if (this.f49153f.mo62773j0() != ':') {
                        throw new C9380d("expect ':' at " + this.f49153f.mo62779s());
                    }
                } else {
                    if (cMo62773j0 == '}') {
                        this.f49153f.next();
                        this.f49153f.mo62776o0();
                        this.f49153f.mo62756D(16);
                        return interfaceC10411w;
                    }
                    if (cMo62773j0 == '\'') {
                        if (!this.f49153f.mo62788x0(EnumC10078b.AllowSingleQuotes)) {
                            throw new C9380d("syntax error");
                        }
                        strMo62780s0 = this.f49153f.mo62767Z(this.f49149b, '\'');
                        this.f49153f.mo62775n0();
                        if (this.f49153f.mo62773j0() != ':') {
                            throw new C9380d("expect ':' at " + this.f49153f.mo62779s());
                        }
                    } else {
                        if (!this.f49153f.mo62788x0(EnumC10078b.AllowUnQuotedFieldNames)) {
                            throw new C9380d("syntax error");
                        }
                        strMo62780s0 = this.f49153f.mo62780s0(this.f49149b);
                        this.f49153f.mo62775n0();
                        char cMo62773j02 = this.f49153f.mo62773j0();
                        if (cMo62773j02 != ':') {
                            throw new C9380d("expect ':' at " + this.f49153f.mo62779s() + ", actual " + cMo62773j02);
                        }
                    }
                }
                this.f49153f.next();
                this.f49153f.mo62775n0();
                this.f49153f.mo62773j0();
                this.f49153f.mo62776o0();
                Object objM62727g0 = null;
                if (strMo62780s0 != AbstractC9377a.f46780c || this.f49153f.mo62788x0(EnumC10078b.DisableSpecialKeyDetect)) {
                    this.f49153f.mo62790z();
                    if (i10 != 0) {
                        m62738s0(c10084h);
                    }
                    Type typeM63944c = interfaceC10411w.m63944c(strMo62780s0);
                    if (this.f49153f.mo62768a0() == 8) {
                        this.f49153f.mo62790z();
                    } else {
                        objM62727g0 = m62727g0(typeM63944c, strMo62780s0);
                    }
                    interfaceC10411w.m63943b(strMo62780s0, objM62727g0);
                    m62735q0(c10084h, objM62727g0, strMo62780s0);
                    m62738s0(c10084h);
                    int iMo62768a0 = this.f49153f.mo62768a0();
                    if (iMo62768a0 == 20 || iMo62768a0 == 15) {
                        break;
                    }
                    if (iMo62768a0 == 13) {
                        this.f49153f.mo62790z();
                        return interfaceC10411w;
                    }
                } else {
                    Class<?> clsM62861j = this.f49150c.m62861j(this.f49153f.mo62767Z(this.f49149b, '\"'), null, this.f49153f.mo62770c0());
                    if (!Map.class.isAssignableFrom(clsM62861j)) {
                        InterfaceC10408t interfaceC10408tM62867p = this.f49150c.m62867p(clsM62861j);
                        this.f49153f.mo62756D(16);
                        m62746x0(2);
                        if (c10084h != null && !(obj instanceof Integer)) {
                            m62733n0();
                        }
                        return (Map) interfaceC10408tM62867p.mo63891b(this, clsM62861j, obj);
                    }
                    this.f49153f.mo62756D(16);
                    if (this.f49153f.mo62768a0() == 13) {
                        this.f49153f.mo62756D(16);
                        return interfaceC10411w;
                    }
                }
                i10++;
            } finally {
                m62738s0(c10084h);
            }
        }
        return interfaceC10411w;
    }

    /* renamed from: I */
    public Object m62714I(Object obj) {
        InterfaceC10079c interfaceC10079c = this.f49153f;
        int iMo62768a0 = interfaceC10079c.mo62768a0();
        if (iMo62768a0 == 2) {
            Number numberMo62765X = interfaceC10079c.mo62765X();
            interfaceC10079c.mo62790z();
            return numberMo62765X;
        }
        if (iMo62768a0 == 3) {
            Number numberMo62784u0 = interfaceC10079c.mo62784u0(interfaceC10079c.mo62788x0(EnumC10078b.UseBigDecimal));
            interfaceC10079c.mo62790z();
            return numberMo62784u0;
        }
        if (iMo62768a0 == 4) {
            String strMo62763J = interfaceC10079c.mo62763J();
            interfaceC10079c.mo62756D(16);
            if (interfaceC10079c.mo62788x0(EnumC10078b.AllowISO8601DateFormat)) {
                C10082f c10082f = new C10082f(strMo62763J);
                try {
                    if (c10082f.m62837t1()) {
                        return c10082f.m62795G0().getTime();
                    }
                } finally {
                    c10082f.close();
                }
            }
            return strMo62763J;
        }
        if (iMo62768a0 == 12) {
            return m62731j0(m62711F(EnumC10078b.UseNativeJavaObject) ? interfaceC10079c.mo62788x0(EnumC10078b.OrderedField) ? new HashMap() : new LinkedHashMap() : new C9381e(interfaceC10079c.mo62788x0(EnumC10078b.OrderedField)), obj);
        }
        if (iMo62768a0 == 14) {
            Collection arrayList = m62711F(EnumC10078b.UseNativeJavaObject) ? new ArrayList() : new C9378b();
            m62718Y(arrayList, obj);
            return interfaceC10079c.mo62788x0(EnumC10078b.UseObjectArray) ? arrayList.toArray() : arrayList;
        }
        if (iMo62768a0 == 18) {
            if ("NaN".equals(interfaceC10079c.mo62763J())) {
                interfaceC10079c.mo62790z();
                return null;
            }
            throw new C9380d("syntax error, " + interfaceC10079c.mo62781t());
        }
        if (iMo62768a0 == 26) {
            byte[] bArrMo62761H = interfaceC10079c.mo62761H();
            interfaceC10079c.mo62790z();
            return bArrMo62761H;
        }
        switch (iMo62768a0) {
            case 6:
                interfaceC10079c.mo62790z();
                return Boolean.TRUE;
            case 7:
                interfaceC10079c.mo62790z();
                return Boolean.FALSE;
            case 8:
                interfaceC10079c.mo62790z();
                return null;
            case 9:
                interfaceC10079c.mo62756D(18);
                if (interfaceC10079c.mo62768a0() != 18) {
                    throw new C9380d("syntax error");
                }
                interfaceC10079c.mo62756D(10);
                m62723d(10);
                long jLongValue = interfaceC10079c.mo62765X().longValue();
                m62723d(2);
                m62723d(11);
                return new Date(jLongValue);
            default:
                switch (iMo62768a0) {
                    case 20:
                        if (interfaceC10079c.mo62786w()) {
                            return null;
                        }
                        throw new C9380d("unterminated json string, " + interfaceC10079c.mo62781t());
                    case 21:
                        interfaceC10079c.mo62790z();
                        HashSet hashSet = new HashSet();
                        m62718Y(hashSet, obj);
                        return hashSet;
                    case 22:
                        interfaceC10079c.mo62790z();
                        TreeSet treeSet = new TreeSet();
                        m62718Y(treeSet, obj);
                        return treeSet;
                    case 23:
                        interfaceC10079c.mo62790z();
                        return null;
                    default:
                        throw new C9380d("syntax error, " + interfaceC10079c.mo62781t());
                }
        }
    }

    /* renamed from: J */
    public void m62715J(Type type, Collection collection) {
        m62716V(type, collection, null);
    }

    /* renamed from: V */
    public void m62716V(Type type, Collection collection, Object obj) {
        InterfaceC10408t interfaceC10408tM62867p;
        int iMo62768a0 = this.f49153f.mo62768a0();
        if (iMo62768a0 == 21 || iMo62768a0 == 22) {
            this.f49153f.mo62790z();
            iMo62768a0 = this.f49153f.mo62768a0();
        }
        if (iMo62768a0 != 14) {
            throw new C9380d("field " + obj + " expect '[', but " + C10083g.m62844a(iMo62768a0) + ", " + this.f49153f.mo62781t());
        }
        if (Integer.TYPE == type) {
            interfaceC10408tM62867p = C10649d0.f51188a;
            this.f49153f.mo62756D(2);
        } else if (String.class == type) {
            interfaceC10408tM62867p = C10656f1.f51252a;
            this.f49153f.mo62756D(4);
        } else {
            interfaceC10408tM62867p = this.f49150c.m62867p(type);
            this.f49153f.mo62756D(interfaceC10408tM62867p.mo63892c());
        }
        C10084h c10084h = this.f49154g;
        m62736r0(collection, obj);
        int i10 = 0;
        while (true) {
            try {
                if (this.f49153f.mo62788x0(EnumC10078b.AllowArbitraryCommas)) {
                    while (this.f49153f.mo62768a0() == 16) {
                        this.f49153f.mo62790z();
                    }
                }
                if (this.f49153f.mo62768a0() == 15) {
                    m62738s0(c10084h);
                    this.f49153f.mo62756D(16);
                    return;
                }
                Object objMo63891b = null;
                if (Integer.TYPE == type) {
                    collection.add(C10649d0.f51188a.mo63891b(this, null, null));
                } else if (String.class == type) {
                    if (this.f49153f.mo62768a0() == 4) {
                        objMo63891b = this.f49153f.mo62763J();
                        this.f49153f.mo62756D(16);
                    } else {
                        Object objM62712G = m62712G();
                        if (objM62712G != null) {
                            objMo63891b = objM62712G.toString();
                        }
                    }
                    collection.add(objMo63891b);
                } else {
                    if (this.f49153f.mo62768a0() == 8) {
                        this.f49153f.mo62790z();
                    } else {
                        objMo63891b = interfaceC10408tM62867p.mo63891b(this, type, Integer.valueOf(i10));
                    }
                    collection.add(objMo63891b);
                    m62728h(collection);
                }
                if (this.f49153f.mo62768a0() == 16) {
                    this.f49153f.mo62756D(interfaceC10408tM62867p.mo63892c());
                }
                i10++;
            } catch (Throwable th2) {
                m62738s0(c10084h);
                throw th2;
            }
        }
    }

    /* renamed from: X */
    public final void m62717X(Collection collection) {
        m62718Y(collection, null);
    }

    /* renamed from: Y */
    public final void m62718Y(Collection collection, Object obj) {
        Object objMo62784u0;
        InterfaceC10079c interfaceC10079c = this.f49153f;
        if (interfaceC10079c.mo62768a0() == 21 || interfaceC10079c.mo62768a0() == 22) {
            interfaceC10079c.mo62790z();
        }
        if (interfaceC10079c.mo62768a0() != 14) {
            throw new C9380d("syntax error, expect [, actual " + C10083g.m62844a(interfaceC10079c.mo62768a0()) + ", pos " + interfaceC10079c.mo62779s() + ", fieldName " + obj);
        }
        interfaceC10079c.mo62756D(4);
        C10084h c10084h = this.f49154g;
        if (c10084h != null && c10084h.f49225d > 512) {
            throw new C9380d("array level > 512");
        }
        m62736r0(collection, obj);
        int i10 = 0;
        while (true) {
            try {
                try {
                    if (interfaceC10079c.mo62788x0(EnumC10078b.AllowArbitraryCommas)) {
                        while (interfaceC10079c.mo62768a0() == 16) {
                            interfaceC10079c.mo62790z();
                        }
                    }
                    int iMo62768a0 = interfaceC10079c.mo62768a0();
                    if (iMo62768a0 == 2) {
                        Number numberMo62765X = interfaceC10079c.mo62765X();
                        interfaceC10079c.mo62756D(16);
                        objMo62784u0 = numberMo62765X;
                    } else if (iMo62768a0 == 3) {
                        objMo62784u0 = interfaceC10079c.mo62788x0(EnumC10078b.UseBigDecimal) ? interfaceC10079c.mo62784u0(true) : interfaceC10079c.mo62784u0(false);
                        interfaceC10079c.mo62756D(16);
                    } else if (iMo62768a0 == 4) {
                        String strMo62763J = interfaceC10079c.mo62763J();
                        interfaceC10079c.mo62756D(16);
                        objMo62784u0 = strMo62763J;
                        if (interfaceC10079c.mo62788x0(EnumC10078b.AllowISO8601DateFormat)) {
                            C10082f c10082f = new C10082f(strMo62763J);
                            Object time = strMo62763J;
                            if (c10082f.m62837t1()) {
                                time = c10082f.m62795G0().getTime();
                            }
                            c10082f.close();
                            objMo62784u0 = time;
                        }
                    } else if (iMo62768a0 == 6) {
                        Boolean bool = Boolean.TRUE;
                        interfaceC10079c.mo62756D(16);
                        objMo62784u0 = bool;
                    } else if (iMo62768a0 != 7) {
                        objMo62784u0 = null;
                        objMo62784u0 = null;
                        if (iMo62768a0 == 8) {
                            interfaceC10079c.mo62756D(4);
                        } else if (iMo62768a0 == 12) {
                            objMo62784u0 = m62731j0(new C9381e(interfaceC10079c.mo62788x0(EnumC10078b.OrderedField)), Integer.valueOf(i10));
                        } else {
                            if (iMo62768a0 == 20) {
                                throw new C9380d("unclosed jsonArray");
                            }
                            if (iMo62768a0 == 23) {
                                interfaceC10079c.mo62756D(4);
                            } else if (iMo62768a0 == 14) {
                                C9378b c9378b = new C9378b();
                                m62718Y(c9378b, Integer.valueOf(i10));
                                objMo62784u0 = c9378b;
                                if (interfaceC10079c.mo62788x0(EnumC10078b.UseObjectArray)) {
                                    objMo62784u0 = c9378b.toArray();
                                }
                            } else {
                                if (iMo62768a0 == 15) {
                                    interfaceC10079c.mo62756D(16);
                                    m62738s0(c10084h);
                                    return;
                                }
                                objMo62784u0 = m62712G();
                            }
                        }
                    } else {
                        Boolean bool2 = Boolean.FALSE;
                        interfaceC10079c.mo62756D(16);
                        objMo62784u0 = bool2;
                    }
                    collection.add(objMo62784u0);
                    m62728h(collection);
                    if (interfaceC10079c.mo62768a0() == 16) {
                        interfaceC10079c.mo62756D(4);
                    }
                    i10++;
                } catch (ClassCastException e10) {
                    throw new C9380d("unkown error", e10);
                }
            } catch (Throwable th2) {
                m62738s0(c10084h);
                throw th2;
            }
        }
    }

    /* renamed from: Z */
    public void m62719Z(Object obj, String str) {
        this.f49153f.mo62778r0();
        List<InterfaceC10399k> list = this.f49159l;
        Type typeM63905d = null;
        if (list != null) {
            Iterator<InterfaceC10399k> it = list.iterator();
            while (it.hasNext()) {
                typeM63905d = it.next().m63905d(obj, str);
            }
        }
        Object objM62712G = typeM63905d == null ? m62712G() : m62722c0(typeM63905d);
        if (obj instanceof InterfaceC10397i) {
            ((InterfaceC10397i) obj).m63903a(str, objM62712G);
            return;
        }
        List<InterfaceC10398j> list2 = this.f49160m;
        if (list2 != null) {
            Iterator<InterfaceC10398j> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().m63904a(obj, str, objM62712G);
            }
        }
        if (this.f49158k == 1) {
            this.f49158k = 0;
        }
    }

    /* renamed from: a0 */
    public C9381e m62720a0() {
        Object objM62730i0 = m62730i0(new C9381e(this.f49153f.mo62788x0(EnumC10078b.OrderedField)));
        if (objM62730i0 instanceof C9381e) {
            return (C9381e) objM62730i0;
        }
        if (objM62730i0 == null) {
            return null;
        }
        return new C9381e((Map<String, Object>) objM62730i0);
    }

    /* renamed from: b0 */
    public <T> T m62721b0(Class<T> cls) {
        return (T) m62727g0(cls, null);
    }

    /* renamed from: c0 */
    public <T> T m62722c0(Type type) {
        return (T) m62727g0(type, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InterfaceC10079c interfaceC10079c = this.f49153f;
        try {
            if (interfaceC10079c.mo62788x0(EnumC10078b.AutoCloseSource) && interfaceC10079c.mo62768a0() != 20) {
                throw new C9380d("not close json text, token : " + C10083g.m62844a(interfaceC10079c.mo62768a0()));
            }
        } finally {
            interfaceC10079c.close();
        }
    }

    /* renamed from: d */
    public final void m62723d(int i10) {
        InterfaceC10079c interfaceC10079c = this.f49153f;
        if (interfaceC10079c.mo62768a0() == i10) {
            interfaceC10079c.mo62790z();
            return;
        }
        throw new C9380d("syntax error, expect " + C10083g.m62844a(i10) + ", actual " + C10083g.m62844a(interfaceC10079c.mo62768a0()));
    }

    /* renamed from: e */
    public void m62724e(String str) {
        InterfaceC10079c interfaceC10079c = this.f49153f;
        interfaceC10079c.mo62778r0();
        if (interfaceC10079c.mo62768a0() != 4) {
            throw new C9380d("type not match error");
        }
        if (!str.equals(interfaceC10079c.mo62763J())) {
            throw new C9380d("type not match error");
        }
        interfaceC10079c.mo62790z();
        if (interfaceC10079c.mo62768a0() == 16) {
            interfaceC10079c.mo62790z();
        }
    }

    /* renamed from: f */
    public final void m62725f(C10084h c10084h) {
        int i10 = this.f49156i;
        this.f49156i = i10 + 1;
        C10084h[] c10084hArr = this.f49155h;
        if (c10084hArr == null) {
            this.f49155h = new C10084h[8];
        } else if (i10 >= c10084hArr.length) {
            C10084h[] c10084hArr2 = new C10084h[(c10084hArr.length * 3) / 2];
            System.arraycopy(c10084hArr, 0, c10084hArr2, 0, c10084hArr.length);
            this.f49155h = c10084hArr2;
        }
        this.f49155h[i10] = c10084h;
    }

    /* renamed from: g */
    public void m62726g(a aVar) {
        if (this.f49157j == null) {
            this.f49157j = new ArrayList(2);
        }
        this.f49157j.add(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: g0 */
    public <T> T m62727g0(Type type, Object obj) {
        int iMo62768a0 = this.f49153f.mo62768a0();
        if (iMo62768a0 == 8) {
            this.f49153f.mo62790z();
            return (T) C11603o.m69258I0(type);
        }
        if (iMo62768a0 == 4) {
            if (type == byte[].class) {
                T t10 = (T) this.f49153f.mo62761H();
                this.f49153f.mo62790z();
                return t10;
            }
            if (type == char[].class) {
                String strMo62763J = this.f49153f.mo62763J();
                this.f49153f.mo62790z();
                return (T) strMo62763J.toCharArray();
            }
        }
        InterfaceC10408t interfaceC10408tM62867p = this.f49150c.m62867p(type);
        try {
            if (interfaceC10408tM62867p.getClass() != C10403o.class) {
                return (T) interfaceC10408tM62867p.mo63891b(this, type, obj);
            }
            if (this.f49153f.mo62768a0() != 12 && this.f49153f.mo62768a0() != 14) {
                throw new C9380d("syntax error,expect start with { or [,but actually start with " + this.f49153f.mo62782t0());
            }
            return (T) ((C10403o) interfaceC10408tM62867p).m63921h(this, type, obj, 0);
        } catch (C9380d e10) {
            throw e10;
        } catch (Throwable th2) {
            throw new C9380d(th2.getMessage(), th2);
        }
    }

    /* renamed from: h */
    public void m62728h(Collection collection) {
        if (this.f49158k == 1) {
            if (!(collection instanceof List)) {
                a aVarM62748z = m62748z();
                aVarM62748z.f49166c = new C10413y(collection);
                aVarM62748z.f49167d = this.f49154g;
                m62746x0(0);
                return;
            }
            int size = collection.size() - 1;
            a aVarM62748z2 = m62748z();
            aVarM62748z2.f49166c = new C10413y(this, (List) collection, size);
            aVarM62748z2.f49167d = this.f49154g;
            m62746x0(0);
        }
    }

    /* renamed from: i */
    public void m62729i(Map map, Object obj) {
        if (this.f49158k == 1) {
            C10413y c10413y = new C10413y(map, obj);
            a aVarM62748z = m62748z();
            aVarM62748z.f49166c = c10413y;
            aVarM62748z.f49167d = this.f49154g;
            m62746x0(0);
        }
    }

    /* renamed from: i0 */
    public Object m62730i0(Map map) {
        return m62731j0(map, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:579:0x02a6, code lost:
    
        r5.mo62756D(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:580:0x02b1, code lost:
    
        if (r5.mo62768a0() != 13) goto L602;
     */
    /* JADX WARN: Code restructure failed: missing block: B:581:0x02b3, code lost:
    
        r5.mo62756D(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:583:0x02be, code lost:
    
        if ((r17.f49150c.m62867p(r8) instanceof p354i1.C10403o) == false) goto L587;
     */
    /* JADX WARN: Code restructure failed: missing block: B:584:0x02c0, code lost:
    
        r13 = p481n1.C11603o.m69292f(r18, r8, r17.f49150c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:585:0x02c8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:587:0x02ca, code lost:
    
        if (r13 != null) goto L598;
     */
    /* JADX WARN: Code restructure failed: missing block: B:589:0x02ce, code lost:
    
        if (r8 != java.lang.Cloneable.class) goto L591;
     */
    /* JADX WARN: Code restructure failed: missing block: B:590:0x02d0, code lost:
    
        r13 = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:592:0x02dc, code lost:
    
        if ("java.util.Collections$EmptyMap".equals(r7) == false) goto L594;
     */
    /* JADX WARN: Code restructure failed: missing block: B:593:0x02de, code lost:
    
        r13 = java.util.Collections.emptyMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:595:0x02e9, code lost:
    
        if ("java.util.Collections$UnmodifiableMap".equals(r7) == false) goto L597;
     */
    /* JADX WARN: Code restructure failed: missing block: B:596:0x02eb, code lost:
    
        r13 = java.util.Collections.unmodifiableMap(new java.util.HashMap());
     */
    /* JADX WARN: Code restructure failed: missing block: B:597:0x02f5, code lost:
    
        r13 = r8.newInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:598:0x02f9, code lost:
    
        m62738s0(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:599:0x02fc, code lost:
    
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:601:0x0304, code lost:
    
        throw new p244e1.C9380d("create instance error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:602:0x0305, code lost:
    
        m62746x0(2);
        r3 = r17.f49154g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:603:0x030b, code lost:
    
        if (r3 == null) goto L610;
     */
    /* JADX WARN: Code restructure failed: missing block: B:604:0x030d, code lost:
    
        if (r19 == null) goto L610;
     */
    /* JADX WARN: Code restructure failed: missing block: B:606:0x0311, code lost:
    
        if ((r19 instanceof java.lang.Integer) != false) goto L610;
     */
    /* JADX WARN: Code restructure failed: missing block: B:608:0x0317, code lost:
    
        if ((r3.f49224c instanceof java.lang.Integer) != false) goto L610;
     */
    /* JADX WARN: Code restructure failed: missing block: B:609:0x0319, code lost:
    
        m62733n0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:611:0x0320, code lost:
    
        if (r18.size() <= 0) goto L615;
     */
    /* JADX WARN: Code restructure failed: missing block: B:612:0x0322, code lost:
    
        r0 = p481n1.C11603o.m69292f(r18, r8, r17.f49150c);
        m62746x0(0);
        m62732m0(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:613:0x032f, code lost:
    
        m62738s0(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:614:0x0332, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:615:0x0333, code lost:
    
        r0 = r17.f49150c.m62867p(r8);
        r3 = r0.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:616:0x0343, code lost:
    
        if (p354i1.C10403o.class.isAssignableFrom(r3) == false) goto L622;
     */
    /* JADX WARN: Code restructure failed: missing block: B:618:0x0347, code lost:
    
        if (r3 == p354i1.C10403o.class) goto L622;
     */
    /* JADX WARN: Code restructure failed: missing block: B:620:0x034b, code lost:
    
        if (r3 == p354i1.C10389b0.class) goto L622;
     */
    /* JADX WARN: Code restructure failed: missing block: B:621:0x034d, code lost:
    
        m62746x0(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:623:0x0354, code lost:
    
        if ((r0 instanceof p354i1.C10406r) == false) goto L625;
     */
    /* JADX WARN: Code restructure failed: missing block: B:624:0x0356, code lost:
    
        m62746x0(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:625:0x035a, code lost:
    
        r0 = r0.mo63891b(r17, r8, r19);
     */
    /* JADX WARN: Code restructure failed: missing block: B:626:0x035e, code lost:
    
        m62738s0(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:627:0x0361, code lost:
    
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:547:0x021e A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:454:0x0074, B:456:0x0078, B:461:0x0085, B:464:0x0098, B:468:0x00ad, B:547:0x021e, B:548:0x0224, B:550:0x022f, B:552:0x0237, B:556:0x024d, B:558:0x025b, B:578:0x029e, B:579:0x02a6, B:581:0x02b3, B:582:0x02b6, B:584:0x02c0, B:590:0x02d0, B:591:0x02d6, B:593:0x02de, B:594:0x02e3, B:596:0x02eb, B:597:0x02f5, B:600:0x02fd, B:601:0x0304, B:602:0x0305, B:605:0x030f, B:607:0x0313, B:609:0x0319, B:610:0x031c, B:612:0x0322, B:615:0x0333, B:621:0x034d, B:625:0x035a, B:622:0x0352, B:624:0x0356, B:560:0x0261, B:563:0x026c, B:567:0x0278, B:569:0x027e, B:574:0x028b, B:575:0x028e, B:633:0x036b, B:637:0x0377, B:639:0x037f, B:641:0x0389, B:643:0x039a, B:645:0x03a4, B:647:0x03ac, B:649:0x03b0, B:651:0x03b6, B:654:0x03bb, B:656:0x03bf, B:679:0x0424, B:681:0x042c, B:684:0x0435, B:685:0x044f, B:658:0x03c5, B:660:0x03cd, B:663:0x03d3, B:664:0x03e0, B:667:0x03e9, B:670:0x03ef, B:673:0x03f4, B:674:0x0401, B:676:0x040b, B:678:0x0419, B:686:0x0450, B:687:0x046e, B:689:0x0471, B:691:0x0475, B:693:0x0479, B:696:0x047f, B:700:0x0488, B:706:0x0498, B:708:0x04a7, B:710:0x04b2, B:711:0x04ba, B:712:0x04bd, B:724:0x04e9, B:726:0x04f4, B:730:0x0501, B:733:0x0511, B:734:0x0531, B:719:0x04cd, B:721:0x04d7, B:723:0x04e6, B:722:0x04dc, B:737:0x0536, B:739:0x0540, B:741:0x0548, B:742:0x054b, B:744:0x0556, B:745:0x055a, B:747:0x0565, B:750:0x056c, B:753:0x0578, B:754:0x057d, B:757:0x0582, B:759:0x0587, B:763:0x0593, B:765:0x059b, B:767:0x05ae, B:771:0x05c9, B:773:0x05d1, B:776:0x05d7, B:778:0x05dd, B:780:0x05e5, B:783:0x05f5, B:786:0x05fd, B:788:0x0601, B:789:0x0608, B:791:0x060d, B:792:0x0610, B:794:0x0618, B:797:0x0622, B:800:0x062c, B:801:0x0631, B:802:0x0636, B:803:0x0650, B:768:0x05b7, B:769:0x05bc, B:804:0x0651, B:806:0x0663, B:809:0x066a, B:812:0x0678, B:813:0x0698, B:471:0x00c1, B:472:0x00df, B:475:0x00e4, B:477:0x00ef, B:479:0x00f3, B:481:0x00f7, B:484:0x00fd, B:491:0x010c, B:493:0x0114, B:496:0x0126, B:497:0x013e, B:498:0x013f, B:499:0x0144, B:510:0x0159, B:511:0x015f, B:513:0x0166, B:515:0x0171, B:522:0x0183, B:525:0x018d, B:526:0x01a5, B:520:0x017e, B:514:0x016b, B:527:0x01a6, B:528:0x01be, B:534:0x01c8, B:536:0x01d0, B:539:0x01e3, B:540:0x0203, B:541:0x0204, B:542:0x0209, B:543:0x020a, B:545:0x0214, B:814:0x0699, B:815:0x06a0, B:816:0x06a1, B:817:0x06a6, B:818:0x06a7, B:819:0x06ac), top: B:822:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:578:0x029e A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:454:0x0074, B:456:0x0078, B:461:0x0085, B:464:0x0098, B:468:0x00ad, B:547:0x021e, B:548:0x0224, B:550:0x022f, B:552:0x0237, B:556:0x024d, B:558:0x025b, B:578:0x029e, B:579:0x02a6, B:581:0x02b3, B:582:0x02b6, B:584:0x02c0, B:590:0x02d0, B:591:0x02d6, B:593:0x02de, B:594:0x02e3, B:596:0x02eb, B:597:0x02f5, B:600:0x02fd, B:601:0x0304, B:602:0x0305, B:605:0x030f, B:607:0x0313, B:609:0x0319, B:610:0x031c, B:612:0x0322, B:615:0x0333, B:621:0x034d, B:625:0x035a, B:622:0x0352, B:624:0x0356, B:560:0x0261, B:563:0x026c, B:567:0x0278, B:569:0x027e, B:574:0x028b, B:575:0x028e, B:633:0x036b, B:637:0x0377, B:639:0x037f, B:641:0x0389, B:643:0x039a, B:645:0x03a4, B:647:0x03ac, B:649:0x03b0, B:651:0x03b6, B:654:0x03bb, B:656:0x03bf, B:679:0x0424, B:681:0x042c, B:684:0x0435, B:685:0x044f, B:658:0x03c5, B:660:0x03cd, B:663:0x03d3, B:664:0x03e0, B:667:0x03e9, B:670:0x03ef, B:673:0x03f4, B:674:0x0401, B:676:0x040b, B:678:0x0419, B:686:0x0450, B:687:0x046e, B:689:0x0471, B:691:0x0475, B:693:0x0479, B:696:0x047f, B:700:0x0488, B:706:0x0498, B:708:0x04a7, B:710:0x04b2, B:711:0x04ba, B:712:0x04bd, B:724:0x04e9, B:726:0x04f4, B:730:0x0501, B:733:0x0511, B:734:0x0531, B:719:0x04cd, B:721:0x04d7, B:723:0x04e6, B:722:0x04dc, B:737:0x0536, B:739:0x0540, B:741:0x0548, B:742:0x054b, B:744:0x0556, B:745:0x055a, B:747:0x0565, B:750:0x056c, B:753:0x0578, B:754:0x057d, B:757:0x0582, B:759:0x0587, B:763:0x0593, B:765:0x059b, B:767:0x05ae, B:771:0x05c9, B:773:0x05d1, B:776:0x05d7, B:778:0x05dd, B:780:0x05e5, B:783:0x05f5, B:786:0x05fd, B:788:0x0601, B:789:0x0608, B:791:0x060d, B:792:0x0610, B:794:0x0618, B:797:0x0622, B:800:0x062c, B:801:0x0631, B:802:0x0636, B:803:0x0650, B:768:0x05b7, B:769:0x05bc, B:804:0x0651, B:806:0x0663, B:809:0x066a, B:812:0x0678, B:813:0x0698, B:471:0x00c1, B:472:0x00df, B:475:0x00e4, B:477:0x00ef, B:479:0x00f3, B:481:0x00f7, B:484:0x00fd, B:491:0x010c, B:493:0x0114, B:496:0x0126, B:497:0x013e, B:498:0x013f, B:499:0x0144, B:510:0x0159, B:511:0x015f, B:513:0x0166, B:515:0x0171, B:522:0x0183, B:525:0x018d, B:526:0x01a5, B:520:0x017e, B:514:0x016b, B:527:0x01a6, B:528:0x01be, B:534:0x01c8, B:536:0x01d0, B:539:0x01e3, B:540:0x0203, B:541:0x0204, B:542:0x0209, B:543:0x020a, B:545:0x0214, B:814:0x0699, B:815:0x06a0, B:816:0x06a1, B:817:0x06a6, B:818:0x06a7, B:819:0x06ac), top: B:822:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:628:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:677:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:689:0x0471 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:454:0x0074, B:456:0x0078, B:461:0x0085, B:464:0x0098, B:468:0x00ad, B:547:0x021e, B:548:0x0224, B:550:0x022f, B:552:0x0237, B:556:0x024d, B:558:0x025b, B:578:0x029e, B:579:0x02a6, B:581:0x02b3, B:582:0x02b6, B:584:0x02c0, B:590:0x02d0, B:591:0x02d6, B:593:0x02de, B:594:0x02e3, B:596:0x02eb, B:597:0x02f5, B:600:0x02fd, B:601:0x0304, B:602:0x0305, B:605:0x030f, B:607:0x0313, B:609:0x0319, B:610:0x031c, B:612:0x0322, B:615:0x0333, B:621:0x034d, B:625:0x035a, B:622:0x0352, B:624:0x0356, B:560:0x0261, B:563:0x026c, B:567:0x0278, B:569:0x027e, B:574:0x028b, B:575:0x028e, B:633:0x036b, B:637:0x0377, B:639:0x037f, B:641:0x0389, B:643:0x039a, B:645:0x03a4, B:647:0x03ac, B:649:0x03b0, B:651:0x03b6, B:654:0x03bb, B:656:0x03bf, B:679:0x0424, B:681:0x042c, B:684:0x0435, B:685:0x044f, B:658:0x03c5, B:660:0x03cd, B:663:0x03d3, B:664:0x03e0, B:667:0x03e9, B:670:0x03ef, B:673:0x03f4, B:674:0x0401, B:676:0x040b, B:678:0x0419, B:686:0x0450, B:687:0x046e, B:689:0x0471, B:691:0x0475, B:693:0x0479, B:696:0x047f, B:700:0x0488, B:706:0x0498, B:708:0x04a7, B:710:0x04b2, B:711:0x04ba, B:712:0x04bd, B:724:0x04e9, B:726:0x04f4, B:730:0x0501, B:733:0x0511, B:734:0x0531, B:719:0x04cd, B:721:0x04d7, B:723:0x04e6, B:722:0x04dc, B:737:0x0536, B:739:0x0540, B:741:0x0548, B:742:0x054b, B:744:0x0556, B:745:0x055a, B:747:0x0565, B:750:0x056c, B:753:0x0578, B:754:0x057d, B:757:0x0582, B:759:0x0587, B:763:0x0593, B:765:0x059b, B:767:0x05ae, B:771:0x05c9, B:773:0x05d1, B:776:0x05d7, B:778:0x05dd, B:780:0x05e5, B:783:0x05f5, B:786:0x05fd, B:788:0x0601, B:789:0x0608, B:791:0x060d, B:792:0x0610, B:794:0x0618, B:797:0x0622, B:800:0x062c, B:801:0x0631, B:802:0x0636, B:803:0x0650, B:768:0x05b7, B:769:0x05bc, B:804:0x0651, B:806:0x0663, B:809:0x066a, B:812:0x0678, B:813:0x0698, B:471:0x00c1, B:472:0x00df, B:475:0x00e4, B:477:0x00ef, B:479:0x00f3, B:481:0x00f7, B:484:0x00fd, B:491:0x010c, B:493:0x0114, B:496:0x0126, B:497:0x013e, B:498:0x013f, B:499:0x0144, B:510:0x0159, B:511:0x015f, B:513:0x0166, B:515:0x0171, B:522:0x0183, B:525:0x018d, B:526:0x01a5, B:520:0x017e, B:514:0x016b, B:527:0x01a6, B:528:0x01be, B:534:0x01c8, B:536:0x01d0, B:539:0x01e3, B:540:0x0203, B:541:0x0204, B:542:0x0209, B:543:0x020a, B:545:0x0214, B:814:0x0699, B:815:0x06a0, B:816:0x06a1, B:817:0x06a6, B:818:0x06a7, B:819:0x06ac), top: B:822:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:706:0x0498 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:454:0x0074, B:456:0x0078, B:461:0x0085, B:464:0x0098, B:468:0x00ad, B:547:0x021e, B:548:0x0224, B:550:0x022f, B:552:0x0237, B:556:0x024d, B:558:0x025b, B:578:0x029e, B:579:0x02a6, B:581:0x02b3, B:582:0x02b6, B:584:0x02c0, B:590:0x02d0, B:591:0x02d6, B:593:0x02de, B:594:0x02e3, B:596:0x02eb, B:597:0x02f5, B:600:0x02fd, B:601:0x0304, B:602:0x0305, B:605:0x030f, B:607:0x0313, B:609:0x0319, B:610:0x031c, B:612:0x0322, B:615:0x0333, B:621:0x034d, B:625:0x035a, B:622:0x0352, B:624:0x0356, B:560:0x0261, B:563:0x026c, B:567:0x0278, B:569:0x027e, B:574:0x028b, B:575:0x028e, B:633:0x036b, B:637:0x0377, B:639:0x037f, B:641:0x0389, B:643:0x039a, B:645:0x03a4, B:647:0x03ac, B:649:0x03b0, B:651:0x03b6, B:654:0x03bb, B:656:0x03bf, B:679:0x0424, B:681:0x042c, B:684:0x0435, B:685:0x044f, B:658:0x03c5, B:660:0x03cd, B:663:0x03d3, B:664:0x03e0, B:667:0x03e9, B:670:0x03ef, B:673:0x03f4, B:674:0x0401, B:676:0x040b, B:678:0x0419, B:686:0x0450, B:687:0x046e, B:689:0x0471, B:691:0x0475, B:693:0x0479, B:696:0x047f, B:700:0x0488, B:706:0x0498, B:708:0x04a7, B:710:0x04b2, B:711:0x04ba, B:712:0x04bd, B:724:0x04e9, B:726:0x04f4, B:730:0x0501, B:733:0x0511, B:734:0x0531, B:719:0x04cd, B:721:0x04d7, B:723:0x04e6, B:722:0x04dc, B:737:0x0536, B:739:0x0540, B:741:0x0548, B:742:0x054b, B:744:0x0556, B:745:0x055a, B:747:0x0565, B:750:0x056c, B:753:0x0578, B:754:0x057d, B:757:0x0582, B:759:0x0587, B:763:0x0593, B:765:0x059b, B:767:0x05ae, B:771:0x05c9, B:773:0x05d1, B:776:0x05d7, B:778:0x05dd, B:780:0x05e5, B:783:0x05f5, B:786:0x05fd, B:788:0x0601, B:789:0x0608, B:791:0x060d, B:792:0x0610, B:794:0x0618, B:797:0x0622, B:800:0x062c, B:801:0x0631, B:802:0x0636, B:803:0x0650, B:768:0x05b7, B:769:0x05bc, B:804:0x0651, B:806:0x0663, B:809:0x066a, B:812:0x0678, B:813:0x0698, B:471:0x00c1, B:472:0x00df, B:475:0x00e4, B:477:0x00ef, B:479:0x00f3, B:481:0x00f7, B:484:0x00fd, B:491:0x010c, B:493:0x0114, B:496:0x0126, B:497:0x013e, B:498:0x013f, B:499:0x0144, B:510:0x0159, B:511:0x015f, B:513:0x0166, B:515:0x0171, B:522:0x0183, B:525:0x018d, B:526:0x01a5, B:520:0x017e, B:514:0x016b, B:527:0x01a6, B:528:0x01be, B:534:0x01c8, B:536:0x01d0, B:539:0x01e3, B:540:0x0203, B:541:0x0204, B:542:0x0209, B:543:0x020a, B:545:0x0214, B:814:0x0699, B:815:0x06a0, B:816:0x06a1, B:817:0x06a6, B:818:0x06a7, B:819:0x06ac), top: B:822:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:713:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:726:0x04f4 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:454:0x0074, B:456:0x0078, B:461:0x0085, B:464:0x0098, B:468:0x00ad, B:547:0x021e, B:548:0x0224, B:550:0x022f, B:552:0x0237, B:556:0x024d, B:558:0x025b, B:578:0x029e, B:579:0x02a6, B:581:0x02b3, B:582:0x02b6, B:584:0x02c0, B:590:0x02d0, B:591:0x02d6, B:593:0x02de, B:594:0x02e3, B:596:0x02eb, B:597:0x02f5, B:600:0x02fd, B:601:0x0304, B:602:0x0305, B:605:0x030f, B:607:0x0313, B:609:0x0319, B:610:0x031c, B:612:0x0322, B:615:0x0333, B:621:0x034d, B:625:0x035a, B:622:0x0352, B:624:0x0356, B:560:0x0261, B:563:0x026c, B:567:0x0278, B:569:0x027e, B:574:0x028b, B:575:0x028e, B:633:0x036b, B:637:0x0377, B:639:0x037f, B:641:0x0389, B:643:0x039a, B:645:0x03a4, B:647:0x03ac, B:649:0x03b0, B:651:0x03b6, B:654:0x03bb, B:656:0x03bf, B:679:0x0424, B:681:0x042c, B:684:0x0435, B:685:0x044f, B:658:0x03c5, B:660:0x03cd, B:663:0x03d3, B:664:0x03e0, B:667:0x03e9, B:670:0x03ef, B:673:0x03f4, B:674:0x0401, B:676:0x040b, B:678:0x0419, B:686:0x0450, B:687:0x046e, B:689:0x0471, B:691:0x0475, B:693:0x0479, B:696:0x047f, B:700:0x0488, B:706:0x0498, B:708:0x04a7, B:710:0x04b2, B:711:0x04ba, B:712:0x04bd, B:724:0x04e9, B:726:0x04f4, B:730:0x0501, B:733:0x0511, B:734:0x0531, B:719:0x04cd, B:721:0x04d7, B:723:0x04e6, B:722:0x04dc, B:737:0x0536, B:739:0x0540, B:741:0x0548, B:742:0x054b, B:744:0x0556, B:745:0x055a, B:747:0x0565, B:750:0x056c, B:753:0x0578, B:754:0x057d, B:757:0x0582, B:759:0x0587, B:763:0x0593, B:765:0x059b, B:767:0x05ae, B:771:0x05c9, B:773:0x05d1, B:776:0x05d7, B:778:0x05dd, B:780:0x05e5, B:783:0x05f5, B:786:0x05fd, B:788:0x0601, B:789:0x0608, B:791:0x060d, B:792:0x0610, B:794:0x0618, B:797:0x0622, B:800:0x062c, B:801:0x0631, B:802:0x0636, B:803:0x0650, B:768:0x05b7, B:769:0x05bc, B:804:0x0651, B:806:0x0663, B:809:0x066a, B:812:0x0678, B:813:0x0698, B:471:0x00c1, B:472:0x00df, B:475:0x00e4, B:477:0x00ef, B:479:0x00f3, B:481:0x00f7, B:484:0x00fd, B:491:0x010c, B:493:0x0114, B:496:0x0126, B:497:0x013e, B:498:0x013f, B:499:0x0144, B:510:0x0159, B:511:0x015f, B:513:0x0166, B:515:0x0171, B:522:0x0183, B:525:0x018d, B:526:0x01a5, B:520:0x017e, B:514:0x016b, B:527:0x01a6, B:528:0x01be, B:534:0x01c8, B:536:0x01d0, B:539:0x01e3, B:540:0x0203, B:541:0x0204, B:542:0x0209, B:543:0x020a, B:545:0x0214, B:814:0x0699, B:815:0x06a0, B:816:0x06a1, B:817:0x06a6, B:818:0x06a7, B:819:0x06ac), top: B:822:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:781:0x05f0  */
    /* JADX WARN: Removed duplicated region for block: B:783:0x05f5 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:454:0x0074, B:456:0x0078, B:461:0x0085, B:464:0x0098, B:468:0x00ad, B:547:0x021e, B:548:0x0224, B:550:0x022f, B:552:0x0237, B:556:0x024d, B:558:0x025b, B:578:0x029e, B:579:0x02a6, B:581:0x02b3, B:582:0x02b6, B:584:0x02c0, B:590:0x02d0, B:591:0x02d6, B:593:0x02de, B:594:0x02e3, B:596:0x02eb, B:597:0x02f5, B:600:0x02fd, B:601:0x0304, B:602:0x0305, B:605:0x030f, B:607:0x0313, B:609:0x0319, B:610:0x031c, B:612:0x0322, B:615:0x0333, B:621:0x034d, B:625:0x035a, B:622:0x0352, B:624:0x0356, B:560:0x0261, B:563:0x026c, B:567:0x0278, B:569:0x027e, B:574:0x028b, B:575:0x028e, B:633:0x036b, B:637:0x0377, B:639:0x037f, B:641:0x0389, B:643:0x039a, B:645:0x03a4, B:647:0x03ac, B:649:0x03b0, B:651:0x03b6, B:654:0x03bb, B:656:0x03bf, B:679:0x0424, B:681:0x042c, B:684:0x0435, B:685:0x044f, B:658:0x03c5, B:660:0x03cd, B:663:0x03d3, B:664:0x03e0, B:667:0x03e9, B:670:0x03ef, B:673:0x03f4, B:674:0x0401, B:676:0x040b, B:678:0x0419, B:686:0x0450, B:687:0x046e, B:689:0x0471, B:691:0x0475, B:693:0x0479, B:696:0x047f, B:700:0x0488, B:706:0x0498, B:708:0x04a7, B:710:0x04b2, B:711:0x04ba, B:712:0x04bd, B:724:0x04e9, B:726:0x04f4, B:730:0x0501, B:733:0x0511, B:734:0x0531, B:719:0x04cd, B:721:0x04d7, B:723:0x04e6, B:722:0x04dc, B:737:0x0536, B:739:0x0540, B:741:0x0548, B:742:0x054b, B:744:0x0556, B:745:0x055a, B:747:0x0565, B:750:0x056c, B:753:0x0578, B:754:0x057d, B:757:0x0582, B:759:0x0587, B:763:0x0593, B:765:0x059b, B:767:0x05ae, B:771:0x05c9, B:773:0x05d1, B:776:0x05d7, B:778:0x05dd, B:780:0x05e5, B:783:0x05f5, B:786:0x05fd, B:788:0x0601, B:789:0x0608, B:791:0x060d, B:792:0x0610, B:794:0x0618, B:797:0x0622, B:800:0x062c, B:801:0x0631, B:802:0x0636, B:803:0x0650, B:768:0x05b7, B:769:0x05bc, B:804:0x0651, B:806:0x0663, B:809:0x066a, B:812:0x0678, B:813:0x0698, B:471:0x00c1, B:472:0x00df, B:475:0x00e4, B:477:0x00ef, B:479:0x00f3, B:481:0x00f7, B:484:0x00fd, B:491:0x010c, B:493:0x0114, B:496:0x0126, B:497:0x013e, B:498:0x013f, B:499:0x0144, B:510:0x0159, B:511:0x015f, B:513:0x0166, B:515:0x0171, B:522:0x0183, B:525:0x018d, B:526:0x01a5, B:520:0x017e, B:514:0x016b, B:527:0x01a6, B:528:0x01be, B:534:0x01c8, B:536:0x01d0, B:539:0x01e3, B:540:0x0203, B:541:0x0204, B:542:0x0209, B:543:0x020a, B:545:0x0214, B:814:0x0699, B:815:0x06a0, B:816:0x06a1, B:817:0x06a6, B:818:0x06a7, B:819:0x06ac), top: B:822:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:788:0x0601 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:454:0x0074, B:456:0x0078, B:461:0x0085, B:464:0x0098, B:468:0x00ad, B:547:0x021e, B:548:0x0224, B:550:0x022f, B:552:0x0237, B:556:0x024d, B:558:0x025b, B:578:0x029e, B:579:0x02a6, B:581:0x02b3, B:582:0x02b6, B:584:0x02c0, B:590:0x02d0, B:591:0x02d6, B:593:0x02de, B:594:0x02e3, B:596:0x02eb, B:597:0x02f5, B:600:0x02fd, B:601:0x0304, B:602:0x0305, B:605:0x030f, B:607:0x0313, B:609:0x0319, B:610:0x031c, B:612:0x0322, B:615:0x0333, B:621:0x034d, B:625:0x035a, B:622:0x0352, B:624:0x0356, B:560:0x0261, B:563:0x026c, B:567:0x0278, B:569:0x027e, B:574:0x028b, B:575:0x028e, B:633:0x036b, B:637:0x0377, B:639:0x037f, B:641:0x0389, B:643:0x039a, B:645:0x03a4, B:647:0x03ac, B:649:0x03b0, B:651:0x03b6, B:654:0x03bb, B:656:0x03bf, B:679:0x0424, B:681:0x042c, B:684:0x0435, B:685:0x044f, B:658:0x03c5, B:660:0x03cd, B:663:0x03d3, B:664:0x03e0, B:667:0x03e9, B:670:0x03ef, B:673:0x03f4, B:674:0x0401, B:676:0x040b, B:678:0x0419, B:686:0x0450, B:687:0x046e, B:689:0x0471, B:691:0x0475, B:693:0x0479, B:696:0x047f, B:700:0x0488, B:706:0x0498, B:708:0x04a7, B:710:0x04b2, B:711:0x04ba, B:712:0x04bd, B:724:0x04e9, B:726:0x04f4, B:730:0x0501, B:733:0x0511, B:734:0x0531, B:719:0x04cd, B:721:0x04d7, B:723:0x04e6, B:722:0x04dc, B:737:0x0536, B:739:0x0540, B:741:0x0548, B:742:0x054b, B:744:0x0556, B:745:0x055a, B:747:0x0565, B:750:0x056c, B:753:0x0578, B:754:0x057d, B:757:0x0582, B:759:0x0587, B:763:0x0593, B:765:0x059b, B:767:0x05ae, B:771:0x05c9, B:773:0x05d1, B:776:0x05d7, B:778:0x05dd, B:780:0x05e5, B:783:0x05f5, B:786:0x05fd, B:788:0x0601, B:789:0x0608, B:791:0x060d, B:792:0x0610, B:794:0x0618, B:797:0x0622, B:800:0x062c, B:801:0x0631, B:802:0x0636, B:803:0x0650, B:768:0x05b7, B:769:0x05bc, B:804:0x0651, B:806:0x0663, B:809:0x066a, B:812:0x0678, B:813:0x0698, B:471:0x00c1, B:472:0x00df, B:475:0x00e4, B:477:0x00ef, B:479:0x00f3, B:481:0x00f7, B:484:0x00fd, B:491:0x010c, B:493:0x0114, B:496:0x0126, B:497:0x013e, B:498:0x013f, B:499:0x0144, B:510:0x0159, B:511:0x015f, B:513:0x0166, B:515:0x0171, B:522:0x0183, B:525:0x018d, B:526:0x01a5, B:520:0x017e, B:514:0x016b, B:527:0x01a6, B:528:0x01be, B:534:0x01c8, B:536:0x01d0, B:539:0x01e3, B:540:0x0203, B:541:0x0204, B:542:0x0209, B:543:0x020a, B:545:0x0214, B:814:0x0699, B:815:0x06a0, B:816:0x06a1, B:817:0x06a6, B:818:0x06a7, B:819:0x06ac), top: B:822:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:791:0x060d A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:454:0x0074, B:456:0x0078, B:461:0x0085, B:464:0x0098, B:468:0x00ad, B:547:0x021e, B:548:0x0224, B:550:0x022f, B:552:0x0237, B:556:0x024d, B:558:0x025b, B:578:0x029e, B:579:0x02a6, B:581:0x02b3, B:582:0x02b6, B:584:0x02c0, B:590:0x02d0, B:591:0x02d6, B:593:0x02de, B:594:0x02e3, B:596:0x02eb, B:597:0x02f5, B:600:0x02fd, B:601:0x0304, B:602:0x0305, B:605:0x030f, B:607:0x0313, B:609:0x0319, B:610:0x031c, B:612:0x0322, B:615:0x0333, B:621:0x034d, B:625:0x035a, B:622:0x0352, B:624:0x0356, B:560:0x0261, B:563:0x026c, B:567:0x0278, B:569:0x027e, B:574:0x028b, B:575:0x028e, B:633:0x036b, B:637:0x0377, B:639:0x037f, B:641:0x0389, B:643:0x039a, B:645:0x03a4, B:647:0x03ac, B:649:0x03b0, B:651:0x03b6, B:654:0x03bb, B:656:0x03bf, B:679:0x0424, B:681:0x042c, B:684:0x0435, B:685:0x044f, B:658:0x03c5, B:660:0x03cd, B:663:0x03d3, B:664:0x03e0, B:667:0x03e9, B:670:0x03ef, B:673:0x03f4, B:674:0x0401, B:676:0x040b, B:678:0x0419, B:686:0x0450, B:687:0x046e, B:689:0x0471, B:691:0x0475, B:693:0x0479, B:696:0x047f, B:700:0x0488, B:706:0x0498, B:708:0x04a7, B:710:0x04b2, B:711:0x04ba, B:712:0x04bd, B:724:0x04e9, B:726:0x04f4, B:730:0x0501, B:733:0x0511, B:734:0x0531, B:719:0x04cd, B:721:0x04d7, B:723:0x04e6, B:722:0x04dc, B:737:0x0536, B:739:0x0540, B:741:0x0548, B:742:0x054b, B:744:0x0556, B:745:0x055a, B:747:0x0565, B:750:0x056c, B:753:0x0578, B:754:0x057d, B:757:0x0582, B:759:0x0587, B:763:0x0593, B:765:0x059b, B:767:0x05ae, B:771:0x05c9, B:773:0x05d1, B:776:0x05d7, B:778:0x05dd, B:780:0x05e5, B:783:0x05f5, B:786:0x05fd, B:788:0x0601, B:789:0x0608, B:791:0x060d, B:792:0x0610, B:794:0x0618, B:797:0x0622, B:800:0x062c, B:801:0x0631, B:802:0x0636, B:803:0x0650, B:768:0x05b7, B:769:0x05bc, B:804:0x0651, B:806:0x0663, B:809:0x066a, B:812:0x0678, B:813:0x0698, B:471:0x00c1, B:472:0x00df, B:475:0x00e4, B:477:0x00ef, B:479:0x00f3, B:481:0x00f7, B:484:0x00fd, B:491:0x010c, B:493:0x0114, B:496:0x0126, B:497:0x013e, B:498:0x013f, B:499:0x0144, B:510:0x0159, B:511:0x015f, B:513:0x0166, B:515:0x0171, B:522:0x0183, B:525:0x018d, B:526:0x01a5, B:520:0x017e, B:514:0x016b, B:527:0x01a6, B:528:0x01be, B:534:0x01c8, B:536:0x01d0, B:539:0x01e3, B:540:0x0203, B:541:0x0204, B:542:0x0209, B:543:0x020a, B:545:0x0214, B:814:0x0699, B:815:0x06a0, B:816:0x06a1, B:817:0x06a6, B:818:0x06a7, B:819:0x06ac), top: B:822:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:797:0x0622 A[Catch: all -> 0x0080, TRY_ENTER, TryCatch #0 {all -> 0x0080, blocks: (B:454:0x0074, B:456:0x0078, B:461:0x0085, B:464:0x0098, B:468:0x00ad, B:547:0x021e, B:548:0x0224, B:550:0x022f, B:552:0x0237, B:556:0x024d, B:558:0x025b, B:578:0x029e, B:579:0x02a6, B:581:0x02b3, B:582:0x02b6, B:584:0x02c0, B:590:0x02d0, B:591:0x02d6, B:593:0x02de, B:594:0x02e3, B:596:0x02eb, B:597:0x02f5, B:600:0x02fd, B:601:0x0304, B:602:0x0305, B:605:0x030f, B:607:0x0313, B:609:0x0319, B:610:0x031c, B:612:0x0322, B:615:0x0333, B:621:0x034d, B:625:0x035a, B:622:0x0352, B:624:0x0356, B:560:0x0261, B:563:0x026c, B:567:0x0278, B:569:0x027e, B:574:0x028b, B:575:0x028e, B:633:0x036b, B:637:0x0377, B:639:0x037f, B:641:0x0389, B:643:0x039a, B:645:0x03a4, B:647:0x03ac, B:649:0x03b0, B:651:0x03b6, B:654:0x03bb, B:656:0x03bf, B:679:0x0424, B:681:0x042c, B:684:0x0435, B:685:0x044f, B:658:0x03c5, B:660:0x03cd, B:663:0x03d3, B:664:0x03e0, B:667:0x03e9, B:670:0x03ef, B:673:0x03f4, B:674:0x0401, B:676:0x040b, B:678:0x0419, B:686:0x0450, B:687:0x046e, B:689:0x0471, B:691:0x0475, B:693:0x0479, B:696:0x047f, B:700:0x0488, B:706:0x0498, B:708:0x04a7, B:710:0x04b2, B:711:0x04ba, B:712:0x04bd, B:724:0x04e9, B:726:0x04f4, B:730:0x0501, B:733:0x0511, B:734:0x0531, B:719:0x04cd, B:721:0x04d7, B:723:0x04e6, B:722:0x04dc, B:737:0x0536, B:739:0x0540, B:741:0x0548, B:742:0x054b, B:744:0x0556, B:745:0x055a, B:747:0x0565, B:750:0x056c, B:753:0x0578, B:754:0x057d, B:757:0x0582, B:759:0x0587, B:763:0x0593, B:765:0x059b, B:767:0x05ae, B:771:0x05c9, B:773:0x05d1, B:776:0x05d7, B:778:0x05dd, B:780:0x05e5, B:783:0x05f5, B:786:0x05fd, B:788:0x0601, B:789:0x0608, B:791:0x060d, B:792:0x0610, B:794:0x0618, B:797:0x0622, B:800:0x062c, B:801:0x0631, B:802:0x0636, B:803:0x0650, B:768:0x05b7, B:769:0x05bc, B:804:0x0651, B:806:0x0663, B:809:0x066a, B:812:0x0678, B:813:0x0698, B:471:0x00c1, B:472:0x00df, B:475:0x00e4, B:477:0x00ef, B:479:0x00f3, B:481:0x00f7, B:484:0x00fd, B:491:0x010c, B:493:0x0114, B:496:0x0126, B:497:0x013e, B:498:0x013f, B:499:0x0144, B:510:0x0159, B:511:0x015f, B:513:0x0166, B:515:0x0171, B:522:0x0183, B:525:0x018d, B:526:0x01a5, B:520:0x017e, B:514:0x016b, B:527:0x01a6, B:528:0x01be, B:534:0x01c8, B:536:0x01d0, B:539:0x01e3, B:540:0x0203, B:541:0x0204, B:542:0x0209, B:543:0x020a, B:545:0x0214, B:814:0x0699, B:815:0x06a0, B:816:0x06a1, B:817:0x06a6, B:818:0x06a7, B:819:0x06ac), top: B:822:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:830:0x02a6 A[EDGE_INSN: B:830:0x02a6->B:579:0x02a6 BREAK  A[LOOP:0: B:461:0x0085->B:852:0x0085], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:843:0x0618 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:849:0x04fd A[SYNTHETIC] */
    /* renamed from: j0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m62731j0(java.util.Map r18, java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 1713
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p323h1.C10077a.m62731j0(java.util.Map, java.lang.Object):java.lang.Object");
    }

    /* renamed from: m0 */
    public void m62732m0(Object obj) {
        Object objMo63891b;
        Class<?> cls = obj.getClass();
        InterfaceC10408t interfaceC10408tM62867p = this.f49150c.m62867p(cls);
        C10403o c10403o = interfaceC10408tM62867p instanceof C10403o ? (C10403o) interfaceC10408tM62867p : null;
        if (this.f49153f.mo62768a0() != 12 && this.f49153f.mo62768a0() != 16) {
            throw new C9380d("syntax error, expect {, actual " + this.f49153f.mo62782t0());
        }
        while (true) {
            String strMo62772i0 = this.f49153f.mo62772i0(this.f49149b);
            if (strMo62772i0 == null) {
                if (this.f49153f.mo62768a0() == 13) {
                    this.f49153f.mo62756D(16);
                    return;
                } else if (this.f49153f.mo62768a0() != 16 || !this.f49153f.mo62788x0(EnumC10078b.AllowArbitraryCommas)) {
                }
            }
            AbstractC10400l abstractC10400lM63924k = c10403o != null ? c10403o.m63924k(strMo62772i0) : null;
            if (abstractC10400lM63924k != null) {
                C11592d c11592d = abstractC10400lM63924k.f50198a;
                Class<?> cls2 = c11592d.f53772e;
                Type type = c11592d.f53773f;
                if (cls2 == Integer.TYPE) {
                    this.f49153f.mo62762I(2);
                    objMo63891b = C10649d0.f51188a.mo63891b(this, type, null);
                } else if (cls2 == String.class) {
                    this.f49153f.mo62762I(4);
                    objMo63891b = C10656f1.m65245f(this);
                } else if (cls2 == Long.TYPE) {
                    this.f49153f.mo62762I(2);
                    objMo63891b = C10676o0.f51312a.mo63891b(this, type, null);
                } else {
                    InterfaceC10408t interfaceC10408tM62866o = this.f49150c.m62866o(cls2, type);
                    this.f49153f.mo62762I(interfaceC10408tM62866o.mo63892c());
                    objMo63891b = interfaceC10408tM62866o.mo63891b(this, type, null);
                }
                abstractC10400lM63924k.mo63911h(obj, objMo63891b);
                if (this.f49153f.mo62768a0() != 16 && this.f49153f.mo62768a0() == 13) {
                    this.f49153f.mo62756D(16);
                    return;
                }
            } else {
                if (!this.f49153f.mo62788x0(EnumC10078b.IgnoreNotMatch)) {
                    throw new C9380d("setter not found, class " + cls.getName() + ", property " + strMo62772i0);
                }
                this.f49153f.mo62778r0();
                m62712G();
                if (this.f49153f.mo62768a0() == 13) {
                    this.f49153f.mo62790z();
                    return;
                }
            }
        }
    }

    /* renamed from: n0 */
    public void m62733n0() {
        if (this.f49153f.mo62788x0(EnumC10078b.DisableCircularReferenceDetect)) {
            return;
        }
        this.f49154g = this.f49154g.f49223b;
        int i10 = this.f49156i;
        if (i10 <= 0) {
            return;
        }
        int i11 = i10 - 1;
        this.f49156i = i11;
        this.f49155h[i11] = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0022, code lost:
    
        return null;
     */
    /* renamed from: o0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object m62734o0(java.lang.String r5) {
        /*
            r4 = this;
            h1.h[] r0 = r4.f49155h
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            r0 = 0
        L7:
            h1.h[] r2 = r4.f49155h
            int r3 = r2.length
            if (r0 >= r3) goto L22
            int r3 = r4.f49156i
            if (r0 >= r3) goto L22
            r2 = r2[r0]
            java.lang.String r3 = r2.toString()
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L1f
            java.lang.Object r4 = r2.f49222a
            return r4
        L1f:
            int r0 = r0 + 1
            goto L7
        L22:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p323h1.C10077a.m62734o0(java.lang.String):java.lang.Object");
    }

    /* renamed from: q0 */
    public C10084h m62735q0(C10084h c10084h, Object obj, Object obj2) {
        if (this.f49153f.mo62788x0(EnumC10078b.DisableCircularReferenceDetect)) {
            return null;
        }
        C10084h c10084h2 = new C10084h(c10084h, obj, obj2);
        this.f49154g = c10084h2;
        m62725f(c10084h2);
        return this.f49154g;
    }

    /* renamed from: r0 */
    public C10084h m62736r0(Object obj, Object obj2) {
        if (this.f49153f.mo62788x0(EnumC10078b.DisableCircularReferenceDetect)) {
            return null;
        }
        return m62735q0(this.f49154g, obj, obj2);
    }

    /* renamed from: s */
    public C10085i m62737s() {
        return this.f49150c;
    }

    /* renamed from: s0 */
    public void m62738s0(C10084h c10084h) {
        if (this.f49153f.mo62788x0(EnumC10078b.DisableCircularReferenceDetect)) {
            return;
        }
        this.f49154g = c10084h;
    }

    /* renamed from: t */
    public C10084h m62739t() {
        return this.f49154g;
    }

    /* renamed from: t0 */
    public void m62740t0(String str) {
        this.f49151d = str;
        this.f49152e = null;
    }

    /* renamed from: u */
    public String m62741u() {
        return this.f49151d;
    }

    /* renamed from: u0 */
    public void m62742u0(InterfaceC10401m interfaceC10401m) {
        this.f49161n = interfaceC10401m;
    }

    /* renamed from: v */
    public DateFormat m62743v() {
        if (this.f49152e == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.f49151d, this.f49153f.mo62791z0());
            this.f49152e = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.f49153f.mo62764V());
        }
        return this.f49152e;
    }

    /* renamed from: w */
    public List<InterfaceC10398j> m62744w() {
        if (this.f49160m == null) {
            this.f49160m = new ArrayList(2);
        }
        return this.f49160m;
    }

    /* renamed from: x */
    public List<InterfaceC10399k> m62745x() {
        if (this.f49159l == null) {
            this.f49159l = new ArrayList(2);
        }
        return this.f49159l;
    }

    /* renamed from: x0 */
    public void m62746x0(int i10) {
        this.f49158k = i10;
    }

    /* renamed from: y */
    public InterfaceC10401m m62747y() {
        return this.f49161n;
    }

    /* renamed from: z */
    public a m62748z() {
        return this.f49157j.get(r1.size() - 1);
    }

    public C10077a(String str, C10085i c10085i) {
        this(str, new C10082f(str, AbstractC9377a.f46783f), c10085i);
    }

    public C10077a(String str, C10085i c10085i, int i10) {
        this(str, new C10082f(str, i10), c10085i);
    }

    public C10077a(Object obj, InterfaceC10079c interfaceC10079c, C10085i c10085i) {
        this.f49151d = AbstractC9377a.f46782e;
        this.f49156i = 0;
        this.f49158k = 0;
        this.f49159l = null;
        this.f49160m = null;
        this.f49161n = null;
        this.f49162o = 0;
        this.f49163p = null;
        this.f49153f = interfaceC10079c;
        this.f49148a = obj;
        this.f49150c = c10085i;
        this.f49149b = c10085i.f49244e;
        char cMo62773j0 = interfaceC10079c.mo62773j0();
        if (cMo62773j0 == '{') {
            interfaceC10079c.next();
            ((AbstractC10080d) interfaceC10079c).f49200a = 12;
        } else if (cMo62773j0 == '[') {
            interfaceC10079c.next();
            ((AbstractC10080d) interfaceC10079c).f49200a = 14;
        } else {
            interfaceC10079c.mo62790z();
        }
    }
}

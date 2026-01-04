package p244e1;

import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import p274f1.InterfaceC9643d;
import p323h1.C10077a;
import p323h1.C10085i;
import p323h1.EnumC10078b;
import p323h1.InterfaceC10079c;
import p354i1.InterfaceC10398j;
import p354i1.InterfaceC10399k;
import p354i1.InterfaceC10401m;
import p354i1.InterfaceC10410v;
import p381j1.C10641a1;
import p381j1.C10650d1;
import p381j1.C10664i0;
import p381j1.C10666j0;
import p381j1.EnumC10653e1;
import p381j1.InterfaceC10644b1;
import p381j1.InterfaceC10658g0;
import p381j1.InterfaceC10686t0;
import p481n1.C11595g;
import p481n1.C11603o;

/* renamed from: e1.a */
/* loaded from: classes.dex */
public abstract class AbstractC9377a implements InterfaceC9386j, InterfaceC9379c {

    /* renamed from: i */
    public static final ThreadLocal<byte[]> f46786i;

    /* renamed from: j */
    public static final ThreadLocal<char[]> f46787j;

    /* renamed from: a */
    public static TimeZone f46778a = TimeZone.getDefault();

    /* renamed from: b */
    public static Locale f46779b = Locale.getDefault();

    /* renamed from: c */
    public static String f46780c = "@type";

    /* renamed from: d */
    public static final InterfaceC10644b1[] f46781d = new InterfaceC10644b1[0];

    /* renamed from: e */
    public static String f46782e = "yyyy-MM-dd HH:mm:ss";

    /* renamed from: h */
    public static final ConcurrentHashMap<Type, Type> f46785h = new ConcurrentHashMap<>(16);

    /* renamed from: f */
    public static int f46783f = ((((((EnumC10078b.AutoCloseSource.m62751b() | EnumC10078b.InternFieldNames.m62751b()) | EnumC10078b.UseBigDecimal.m62751b()) | EnumC10078b.AllowUnQuotedFieldNames.m62751b()) | EnumC10078b.AllowSingleQuotes.m62751b()) | EnumC10078b.AllowArbitraryCommas.m62751b()) | EnumC10078b.SortFeidFastMatch.m62751b()) | EnumC10078b.IgnoreNotMatch.m62751b();

    /* renamed from: g */
    public static int f46784g = ((EnumC10653e1.QuoteFieldNames.m65244b() | EnumC10653e1.SkipTransientField.m65244b()) | EnumC10653e1.WriteEnumUsingName.m65244b()) | EnumC10653e1.SortField.m65244b();

    static {
        m58760d(C11595g.f53791a);
        f46786i = new ThreadLocal<>();
        f46787j = new ThreadLocal<>();
    }

    /* renamed from: B */
    public static String m58758B(Object obj, C10641a1 c10641a1, EnumC10653e1... enumC10653e1Arr) {
        return m58775y(obj, c10641a1, null, enumC10653e1Arr);
    }

    /* renamed from: C */
    public static String m58759C(Object obj, InterfaceC10644b1[] interfaceC10644b1Arr, EnumC10653e1... enumC10653e1Arr) {
        return m58776z(obj, C10641a1.f51151j, interfaceC10644b1Arr, null, f46784g, enumC10653e1Arr);
    }

    /* renamed from: d */
    public static void m58760d(Properties properties) {
        String property = properties.getProperty("fastjson.serializerFeatures.MapSortField");
        int iM65244b = EnumC10653e1.MapSortField.m65244b();
        if (FaqConstants.DISABLE_HA_REPORT.equals(property)) {
            f46784g |= iM65244b;
        } else if ("false".equals(property)) {
            f46784g &= ~iM65244b;
        }
        if (FaqConstants.DISABLE_HA_REPORT.equals(properties.getProperty("parser.features.NonStringKeyAsString"))) {
            f46783f |= EnumC10078b.NonStringKeyAsString.m62751b();
        }
        if (FaqConstants.DISABLE_HA_REPORT.equals(properties.getProperty("parser.features.ErrorOnEnumNotMatch")) || FaqConstants.DISABLE_HA_REPORT.equals(properties.getProperty("fastjson.parser.features.ErrorOnEnumNotMatch"))) {
            f46783f |= EnumC10078b.ErrorOnEnumNotMatch.m62751b();
        }
        if ("false".equals(properties.getProperty("fastjson.asmEnable"))) {
            C10085i.f49239z.m62852A(false);
            C10641a1.f51151j.m65191l(false);
        }
    }

    /* renamed from: f */
    public static Type m58761f(Type type) {
        if (type != null) {
            return f46785h.get(type);
        }
        return null;
    }

    /* renamed from: g */
    public static Object m58762g(String str) {
        return m58763j(str, f46783f);
    }

    /* renamed from: j */
    public static Object m58763j(String str, int i10) {
        return m58765l(str, C10085i.m62849t(), i10);
    }

    /* renamed from: k */
    public static Object m58764k(String str, C10085i c10085i) {
        return m58765l(str, c10085i, f46783f);
    }

    /* renamed from: l */
    public static Object m58765l(String str, C10085i c10085i, int i10) {
        if (str == null) {
            return null;
        }
        C10077a c10077a = new C10077a(str, c10085i, i10);
        Object objM62712G = c10077a.m62712G();
        c10077a.m62710E(objM62712G);
        c10077a.close();
        return objM62712G;
    }

    /* renamed from: m */
    public static C9378b m58766m(String str) {
        return m58767n(str, C10085i.f49239z);
    }

    /* renamed from: n */
    public static C9378b m58767n(String str, C10085i c10085i) {
        C9378b c9378b = null;
        if (str == null) {
            return null;
        }
        C10077a c10077a = new C10077a(str, c10085i);
        InterfaceC10079c interfaceC10079c = c10077a.f49153f;
        if (interfaceC10079c.mo62768a0() == 8) {
            interfaceC10079c.mo62790z();
        } else if (interfaceC10079c.mo62768a0() != 20 || !interfaceC10079c.mo62786w()) {
            c9378b = new C9378b();
            c10077a.m62717X(c9378b);
            c10077a.m62710E(c9378b);
        }
        c10077a.close();
        return c9378b;
    }

    /* renamed from: o */
    public static C9381e m58768o(String str) {
        Object objM58762g = m58762g(str);
        if (objM58762g instanceof C9381e) {
            return (C9381e) objM58762g;
        }
        try {
            return (C9381e) m58772u(objM58762g);
        } catch (RuntimeException e10) {
            throw new C9380d("can not cast to JSONObject.", e10);
        }
    }

    /* renamed from: p */
    public static <T> T m58769p(String str, Class<T> cls) {
        return (T) m58770q(str, cls, new EnumC10078b[0]);
    }

    /* renamed from: q */
    public static <T> T m58770q(String str, Class<T> cls, EnumC10078b... enumC10078bArr) {
        return (T) m58771r(str, cls, C10085i.f49239z, null, f46783f, enumC10078bArr);
    }

    /* renamed from: r */
    public static <T> T m58771r(String str, Type type, C10085i c10085i, InterfaceC10410v interfaceC10410v, int i10, EnumC10078b... enumC10078bArr) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (enumC10078bArr != null) {
            for (EnumC10078b enumC10078b : enumC10078bArr) {
                i10 |= enumC10078b.f49196a;
            }
        }
        C10077a c10077a = new C10077a(str, c10085i, i10);
        if (interfaceC10410v != null) {
            if (interfaceC10410v instanceof InterfaceC10399k) {
                c10077a.m62745x().add((InterfaceC10399k) interfaceC10410v);
            }
            if (interfaceC10410v instanceof InterfaceC10398j) {
                c10077a.m62744w().add((InterfaceC10398j) interfaceC10410v);
            }
            if (interfaceC10410v instanceof InterfaceC10401m) {
                c10077a.m62742u0((InterfaceC10401m) interfaceC10410v);
            }
        }
        T t10 = (T) c10077a.m62727g0(type, null);
        c10077a.m62710E(t10);
        c10077a.close();
        return t10;
    }

    /* renamed from: u */
    public static Object m58772u(Object obj) {
        return m58773w(obj, C10641a1.f51151j);
    }

    /* renamed from: w */
    public static Object m58773w(Object obj, C10641a1 c10641a1) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof AbstractC9377a) {
            return obj;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            int size = map.size();
            C9381e c9381e = new C9381e((Map<String, Object>) (map instanceof LinkedHashMap ? new LinkedHashMap(size) : map instanceof TreeMap ? new TreeMap() : new HashMap(size)));
            for (Map.Entry entry : map.entrySet()) {
                c9381e.put(C11603o.m69332z(entry.getKey()), m58773w(entry.getValue(), c10641a1));
            }
            return c9381e;
        }
        if (obj instanceof Collection) {
            Collection collection = (Collection) obj;
            C9378b c9378b = new C9378b(collection.size());
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                c9378b.add(m58773w(it.next(), c10641a1));
            }
            return c9378b;
        }
        if (obj instanceof InterfaceC10658g0) {
            return m58762g(m58774x(obj));
        }
        Class<?> cls = obj.getClass();
        if (cls.isEnum()) {
            return ((Enum) obj).name();
        }
        boolean z10 = false;
        if (cls.isArray()) {
            int length = Array.getLength(obj);
            C9378b c9378b2 = new C9378b(length);
            for (int i10 = 0; i10 < length; i10++) {
                c9378b2.add(m58772u(Array.get(obj, i10)));
            }
            return c9378b2;
        }
        if (C10085i.m62850w(cls)) {
            return obj;
        }
        InterfaceC10686t0 interfaceC10686t0M65187h = c10641a1.m65187h(cls);
        if (!(interfaceC10686t0M65187h instanceof C10666j0)) {
            return m58762g(m58758B(obj, c10641a1, new EnumC10653e1[0]));
        }
        C10666j0 c10666j0 = (C10666j0) interfaceC10686t0M65187h;
        InterfaceC9643d interfaceC9643dM65295x = c10666j0.m65295x();
        if (interfaceC9643dM65295x != null) {
            boolean z11 = false;
            for (EnumC10653e1 enumC10653e1 : interfaceC9643dM65295x.serialzeFeatures()) {
                if (enumC10653e1 == EnumC10653e1.SortField || enumC10653e1 == EnumC10653e1.MapSortField) {
                    z11 = true;
                }
            }
            z10 = z11;
        }
        C9381e c9381e2 = new C9381e(z10);
        try {
            for (Map.Entry<String, Object> entry2 : c10666j0.m65294w(obj).entrySet()) {
                c9381e2.put(entry2.getKey(), m58773w(entry2.getValue(), c10641a1));
            }
            return c9381e2;
        } catch (Exception e10) {
            throw new C9380d("toJSON error", e10);
        }
    }

    /* renamed from: x */
    public static String m58774x(Object obj) {
        return m58759C(obj, f46781d, new EnumC10653e1[0]);
    }

    /* renamed from: y */
    public static String m58775y(Object obj, C10641a1 c10641a1, InterfaceC10644b1 interfaceC10644b1, EnumC10653e1... enumC10653e1Arr) {
        return m58776z(obj, c10641a1, new InterfaceC10644b1[]{interfaceC10644b1}, null, f46784g, enumC10653e1Arr);
    }

    /* renamed from: z */
    public static String m58776z(Object obj, C10641a1 c10641a1, InterfaceC10644b1[] interfaceC10644b1Arr, String str, int i10, EnumC10653e1... enumC10653e1Arr) {
        C10650d1 c10650d1 = new C10650d1(null, i10, enumC10653e1Arr);
        try {
            C10664i0 c10664i0 = new C10664i0(c10650d1, c10641a1);
            if (str != null && str.length() != 0) {
                c10664i0.m65261F(str);
                c10664i0.m65269q(EnumC10653e1.WriteDateUseDateFormat, true);
            }
            if (interfaceC10644b1Arr != null) {
                for (InterfaceC10644b1 interfaceC10644b1 : interfaceC10644b1Arr) {
                    c10664i0.m65195b(interfaceC10644b1);
                }
            }
            c10664i0.m65262G(obj);
            String string = c10650d1.toString();
            c10650d1.close();
            return string;
        } catch (Throwable th2) {
            c10650d1.close();
            throw th2;
        }
    }

    /* renamed from: D */
    public <T> T m58777D(Type type) {
        return (T) C11603o.m69296h(this, type, C10085i.m62849t());
    }

    @Override // p244e1.InterfaceC9386j
    /* renamed from: b */
    public void mo58778b(Appendable appendable) {
        C10650d1 c10650d1 = new C10650d1();
        try {
            try {
                new C10664i0(c10650d1).m65262G(this);
                appendable.append(c10650d1.toString());
            } catch (IOException e10) {
                throw new C9380d(e10.getMessage(), e10);
            }
        } finally {
            c10650d1.close();
        }
    }

    @Override // p244e1.InterfaceC9379c
    /* renamed from: c */
    public String mo58779c() {
        C10650d1 c10650d1 = new C10650d1();
        try {
            new C10664i0(c10650d1).m65262G(this);
            return c10650d1.toString();
        } finally {
            c10650d1.close();
        }
    }

    public String toString() {
        return mo58779c();
    }
}

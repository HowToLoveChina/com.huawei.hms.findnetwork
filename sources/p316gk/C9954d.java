package p316gk;

import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

/* renamed from: gk.d */
/* loaded from: classes6.dex */
public class C9954d {

    /* renamed from: b */
    public static final C9957g f48727b = new C9957g(new String[]{",", "(", ")", "=", "<", ">", "<=", ">=", "!="}, new String[]{" ", "\r", "\n", "\f", "\t"}, null, new String[]{"'", "'", "\"", "\""});

    /* renamed from: c */
    public static final Comparator f48728c = Comparator.nullsFirst(Comparator.naturalOrder());

    /* renamed from: a */
    public Map<String, InterfaceC9958h> f48729a;

    /* renamed from: gk.d$a */
    public class a implements InterfaceC9955e {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC9958h f48730a;

        /* renamed from: b */
        public final /* synthetic */ InterfaceC9958h f48731b;

        /* renamed from: c */
        public final /* synthetic */ g f48732c;

        public a(InterfaceC9958h interfaceC9958h, InterfaceC9958h interfaceC9958h2, g gVar) {
            this.f48730a = interfaceC9958h;
            this.f48731b = interfaceC9958h2;
            this.f48732c = gVar;
        }

        @Override // p316gk.InterfaceC9955e
        /* renamed from: a */
        public Collection<String> mo61753a() {
            return Arrays.asList(this.f48730a.name(), this.f48731b.name());
        }

        @Override // p316gk.InterfaceC9955e
        /* renamed from: b */
        public boolean mo61754b(Function<String, Object> function) {
            return this.f48732c.mo61756b(C9954d.m61747n(this.f48730a, function), C9954d.m61747n(this.f48731b, function));
        }
    }

    /* renamed from: gk.d$b */
    public class b implements InterfaceC9955e {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC9958h f48733a;

        /* renamed from: b */
        public final /* synthetic */ Object f48734b;

        /* renamed from: c */
        public final /* synthetic */ g f48735c;

        public b(InterfaceC9958h interfaceC9958h, Object obj, g gVar) {
            this.f48733a = interfaceC9958h;
            this.f48734b = obj;
            this.f48735c = gVar;
        }

        @Override // p316gk.InterfaceC9955e
        /* renamed from: a */
        public Collection<String> mo61753a() {
            return Arrays.asList(this.f48733a.name());
        }

        @Override // p316gk.InterfaceC9955e
        /* renamed from: b */
        public boolean mo61754b(Function<String, Object> function) {
            return this.f48735c.mo61756b(C9954d.m61747n(this.f48733a, function), this.f48733a.mo61778f(this.f48734b));
        }
    }

    /* renamed from: gk.d$c */
    public class c implements InterfaceC9955e {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC9958h f48736a;

        /* renamed from: b */
        public final /* synthetic */ g f48737b;

        /* renamed from: c */
        public final /* synthetic */ List f48738c;

        public c(InterfaceC9958h interfaceC9958h, g gVar, List list) {
            this.f48736a = interfaceC9958h;
            this.f48737b = gVar;
            this.f48738c = list;
        }

        @Override // p316gk.InterfaceC9955e
        /* renamed from: a */
        public Collection<String> mo61753a() {
            return Arrays.asList(this.f48736a.name());
        }

        @Override // p316gk.InterfaceC9955e
        /* renamed from: b */
        public boolean mo61754b(Function<String, Object> function) {
            return this.f48737b.mo61756b(C9954d.m61747n(this.f48736a, function), this.f48738c);
        }
    }

    /* renamed from: gk.d$d */
    public class d implements InterfaceC9955e {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC9958h f48739a;

        /* renamed from: b */
        public final /* synthetic */ Object f48740b;

        /* renamed from: c */
        public final /* synthetic */ g f48741c;

        public d(InterfaceC9958h interfaceC9958h, Object obj, g gVar) {
            this.f48739a = interfaceC9958h;
            this.f48740b = obj;
            this.f48741c = gVar;
        }

        @Override // p316gk.InterfaceC9955e
        /* renamed from: a */
        public Collection<String> mo61753a() {
            return Arrays.asList(this.f48739a.name());
        }

        @Override // p316gk.InterfaceC9955e
        /* renamed from: b */
        public boolean mo61754b(Function<String, Object> function) {
            return this.f48741c.mo61756b(this.f48739a.mo61778f(this.f48740b), C9954d.m61747n(this.f48739a, function));
        }
    }

    /* renamed from: gk.d$e */
    public class e implements InterfaceC9955e {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC9955e f48742a;

        /* renamed from: b */
        public final /* synthetic */ InterfaceC9955e f48743b;

        public e(InterfaceC9955e interfaceC9955e, InterfaceC9955e interfaceC9955e2) {
            this.f48742a = interfaceC9955e;
            this.f48743b = interfaceC9955e2;
        }

        @Override // p316gk.InterfaceC9955e
        /* renamed from: a */
        public Collection<String> mo61753a() {
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.f48742a.mo61753a());
            hashSet.addAll(this.f48743b.mo61753a());
            return hashSet;
        }

        @Override // p316gk.InterfaceC9955e
        /* renamed from: b */
        public boolean mo61754b(Function<String, Object> function) {
            return this.f48742a.mo61754b(function) && this.f48743b.mo61754b(function);
        }
    }

    /* renamed from: gk.d$f */
    public class f implements InterfaceC9955e {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC9955e f48744a;

        /* renamed from: b */
        public final /* synthetic */ InterfaceC9955e f48745b;

        public f(InterfaceC9955e interfaceC9955e, InterfaceC9955e interfaceC9955e2) {
            this.f48744a = interfaceC9955e;
            this.f48745b = interfaceC9955e2;
        }

        @Override // p316gk.InterfaceC9955e
        /* renamed from: a */
        public Collection<String> mo61753a() {
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.f48744a.mo61753a());
            hashSet.addAll(this.f48745b.mo61753a());
            return hashSet;
        }

        @Override // p316gk.InterfaceC9955e
        /* renamed from: b */
        public boolean mo61754b(Function<String, Object> function) {
            return this.f48744a.mo61754b(function) || this.f48745b.mo61754b(function);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: gk.d$g */
    public static abstract class g {

        /* renamed from: b */
        public static final g f48746b;

        /* renamed from: c */
        public static final g f48747c;

        /* renamed from: d */
        public static final g f48748d;

        /* renamed from: e */
        public static final g f48749e;

        /* renamed from: f */
        public static final g f48750f;

        /* renamed from: g */
        public static final g f48751g;

        /* renamed from: h */
        public static final g f48752h;

        /* renamed from: i */
        public static final g f48753i;

        /* renamed from: j */
        public static final g f48754j;

        /* renamed from: k */
        public static final /* synthetic */ g[] f48755k;

        /* renamed from: a */
        public String f48756a;

        /* renamed from: gk.d$g$a */
        public enum a extends g {
            public a(String str, int i10, String str2) {
                super(str, i10, str2, null);
            }

            @Override // p316gk.C9954d.g
            /* renamed from: b */
            public boolean mo61756b(Object obj, Object obj2) {
                return Objects.equals(obj, obj2);
            }
        }

        /* renamed from: gk.d$g$b */
        public enum b extends g {
            public b(String str, int i10, String str2) {
                super(str, i10, str2, null);
            }

            @Override // p316gk.C9954d.g
            /* renamed from: b */
            public boolean mo61756b(Object obj, Object obj2) {
                return !Objects.equals(obj, obj2);
            }
        }

        /* renamed from: gk.d$g$c */
        public enum c extends g {
            public c(String str, int i10, String str2) {
                super(str, i10, str2, null);
            }

            @Override // p316gk.C9954d.g
            /* renamed from: b */
            public boolean mo61756b(Object obj, Object obj2) {
                return C9954d.f48728c.compare(obj, obj2) > 0;
            }
        }

        /* renamed from: gk.d$g$d */
        public enum d extends g {
            public d(String str, int i10, String str2) {
                super(str, i10, str2, null);
            }

            @Override // p316gk.C9954d.g
            /* renamed from: b */
            public boolean mo61756b(Object obj, Object obj2) {
                return C9954d.f48728c.compare(obj, obj2) >= 0;
            }
        }

        /* renamed from: gk.d$g$e */
        public enum e extends g {
            public e(String str, int i10, String str2) {
                super(str, i10, str2, null);
            }

            @Override // p316gk.C9954d.g
            /* renamed from: b */
            public boolean mo61756b(Object obj, Object obj2) {
                return C9954d.f48728c.compare(obj, obj2) < 0;
            }
        }

        /* renamed from: gk.d$g$f */
        public enum f extends g {
            public f(String str, int i10, String str2) {
                super(str, i10, str2, null);
            }

            @Override // p316gk.C9954d.g
            /* renamed from: b */
            public boolean mo61756b(Object obj, Object obj2) {
                return C9954d.f48728c.compare(obj, obj2) <= 0;
            }
        }

        /* renamed from: gk.d$g$g, reason: collision with other inner class name */
        public enum C14504g extends g {
            public C14504g(String str, int i10, String str2) {
                super(str, i10, str2, null);
            }

            @Override // p316gk.C9954d.g
            /* renamed from: b */
            public boolean mo61756b(Object obj, Object obj2) {
                return obj2 == null ? obj == null : obj2 instanceof Collection ? ((Collection) obj2).contains(obj) : Objects.equals(obj, obj2);
            }
        }

        /* renamed from: gk.d$g$h */
        public enum h extends g {
            public h(String str, int i10, String str2) {
                super(str, i10, str2, null);
            }

            @Override // p316gk.C9954d.g
            /* renamed from: b */
            public boolean mo61756b(Object obj, Object obj2) {
                return obj2 == null ? obj == null : obj2 instanceof Collection ? true ^ ((Collection) obj2).contains(obj) : true ^ Objects.equals(obj, obj2);
            }
        }

        /* renamed from: gk.d$g$i */
        public enum i extends g {
            public i(String str, int i10, String str2) {
                super(str, i10, str2, null);
            }

            @Override // p316gk.C9954d.g
            /* renamed from: b */
            public boolean mo61756b(Object obj, Object obj2) {
                if (obj2 == null) {
                    return obj == null;
                }
                String str = (String) obj;
                if (!(obj2 instanceof Collection)) {
                    try {
                        return str.startsWith((String) obj2);
                    } catch (Exception unused) {
                        return false;
                    }
                }
                Iterator it = ((Collection) obj2).iterator();
                while (it.hasNext()) {
                    try {
                        if (str.startsWith((String) it.next())) {
                            return true;
                        }
                    } catch (Exception unused2) {
                    }
                }
                return false;
            }
        }

        static {
            a aVar = new a("EQ", 0, "=");
            f48746b = aVar;
            b bVar = new b("NE", 1, "!=");
            f48747c = bVar;
            c cVar = new c("GT", 2, ">");
            f48748d = cVar;
            d dVar = new d("GE", 3, ">=");
            f48749e = dVar;
            e eVar = new e("LT", 4, "<");
            f48750f = eVar;
            f fVar = new f("LE", 5, "<=");
            f48751g = fVar;
            C14504g c14504g = new C14504g(FaqConstants.OPEN_TYPE_IN, 6, "in");
            f48752h = c14504g;
            h hVar = new h("NIN", 7, "nin");
            f48753i = hVar;
            i iVar = new i("LIKE", 8, "like");
            f48754j = iVar;
            f48755k = new g[]{aVar, bVar, cVar, dVar, eVar, fVar, c14504g, hVar, iVar};
        }

        public /* synthetic */ g(String str, int i10, String str2, a aVar) {
            this(str, i10, str2);
        }

        /* renamed from: e */
        public static g m61755e(String str) {
            str.hashCode();
            switch (str) {
                case "<":
                    return f48750f;
                case "=":
                    return f48746b;
                case ">":
                    return f48748d;
                case "!=":
                    return f48747c;
                case "<=":
                    return f48751g;
                case ">=":
                    return f48749e;
                case "in":
                    return f48752h;
                case "nin":
                    return f48753i;
                case "like":
                    return f48754j;
                default:
                    throw new C9952b("operator '" + str + "' not supported");
            }
        }

        public static g valueOf(String str) {
            return (g) Enum.valueOf(g.class, str);
        }

        public static g[] values() {
            return (g[]) f48755k.clone();
        }

        /* renamed from: b */
        public abstract boolean mo61756b(Object obj, Object obj2);

        public g(String str, int i10, String str2) {
            this.f48756a = str2;
        }
    }

    public C9954d(List<InterfaceC9958h> list) {
        final HashMap map = new HashMap();
        list.forEach(new Consumer() { // from class: gk.c
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C9954d.m61748o(map, (InterfaceC9958h) obj);
            }
        });
        this.f48729a = map;
    }

    /* renamed from: d */
    public static InterfaceC9955e m61740d(InterfaceC9958h interfaceC9958h, g gVar, InterfaceC9958h interfaceC9958h2) {
        return new a(interfaceC9958h, interfaceC9958h2, gVar);
    }

    /* renamed from: e */
    public static InterfaceC9955e m61741e(InterfaceC9958h interfaceC9958h, g gVar, Object obj) {
        return new b(interfaceC9958h, obj, gVar);
    }

    /* renamed from: f */
    public static InterfaceC9955e m61742f(InterfaceC9958h interfaceC9958h, g gVar, List<Object> list) {
        return new c(interfaceC9958h, gVar, list);
    }

    /* renamed from: g */
    public static InterfaceC9955e m61743g(Object obj, g gVar, InterfaceC9958h interfaceC9958h) {
        return new d(interfaceC9958h, obj, gVar);
    }

    /* renamed from: h */
    public static InterfaceC9955e m61744h(InterfaceC9955e interfaceC9955e, InterfaceC9955e interfaceC9955e2) {
        return new e(interfaceC9955e, interfaceC9955e2);
    }

    /* renamed from: i */
    public static InterfaceC9955e m61745i(InterfaceC9955e interfaceC9955e, InterfaceC9955e interfaceC9955e2) {
        return new f(interfaceC9955e, interfaceC9955e2);
    }

    /* renamed from: m */
    public static List<String> m61746m(C9959i c9959i) throws C9952b {
        ArrayList arrayList = new ArrayList();
        if (!"(".equals(c9959i.m61786d())) {
            arrayList.add(c9959i.m61785c());
            return arrayList;
        }
        c9959i.m61784b("(");
        arrayList.add(c9959i.m61785c());
        String strM61786d = c9959i.m61786d();
        while (",".equals(strM61786d)) {
            c9959i.m61784b(",");
            arrayList.add(c9959i.m61785c());
            strM61786d = c9959i.m61786d();
        }
        c9959i.m61784b(")");
        return arrayList;
    }

    /* renamed from: n */
    public static Object m61747n(InterfaceC9958h interfaceC9958h, Function<String, Object> function) {
        return interfaceC9958h.mo61778f(function.apply(interfaceC9958h.name()));
    }

    /* renamed from: o */
    public static /* synthetic */ void m61748o(Map map, InterfaceC9958h interfaceC9958h) {
        map.put(interfaceC9958h.name(), interfaceC9958h);
    }

    /* renamed from: j */
    public InterfaceC9955e m61749j(String str) {
        return m61751l(f48727b.m61760d(str));
    }

    /* renamed from: k */
    public final InterfaceC9955e m61750k(C9959i c9959i) throws C9952b {
        if ("(".equals(c9959i.m61786d())) {
            c9959i.m61784b("(");
            InterfaceC9955e interfaceC9955eM61751l = m61751l(c9959i);
            c9959i.m61784b(")");
            return interfaceC9955eM61751l;
        }
        List<String> listM61746m = m61746m(c9959i);
        if (listM61746m.size() != 1) {
            throw new C9952b("term not allow");
        }
        String str = listM61746m.get(0);
        String strM61785c = c9959i.m61785c();
        List<String> listM61746m2 = m61746m(c9959i);
        g gVarM61755e = g.m61755e(strM61785c);
        if (g.f48752h != gVarM61755e && g.f48754j != gVarM61755e && g.f48753i != gVarM61755e) {
            if (listM61746m2.size() != 1) {
                throw new C9952b("term not allow");
            }
            String str2 = listM61746m2.get(0);
            InterfaceC9958h interfaceC9958hM61752p = m61752p(str);
            InterfaceC9958h interfaceC9958hM61752p2 = m61752p(str2);
            if (interfaceC9958hM61752p != null) {
                return interfaceC9958hM61752p2 != null ? m61740d(interfaceC9958hM61752p, gVarM61755e, interfaceC9958hM61752p2) : m61741e(interfaceC9958hM61752p, gVarM61755e, str2);
            }
            if (interfaceC9958hM61752p2 != null) {
                return m61743g(str, gVarM61755e, interfaceC9958hM61752p2);
            }
            throw new C9952b("term not find");
        }
        InterfaceC9958h interfaceC9958hM61752p3 = m61752p(str);
        if (interfaceC9958hM61752p3 == null) {
            throw new C9952b("term not find");
        }
        ArrayList arrayList = new ArrayList();
        for (String str3 : listM61746m2) {
            InterfaceC9958h interfaceC9958hM61752p4 = m61752p(str3);
            if (interfaceC9958hM61752p4 == null) {
                arrayList.add(interfaceC9958hM61752p3.mo61778f(str3));
            } else {
                arrayList.add(interfaceC9958hM61752p4);
            }
        }
        return m61742f(interfaceC9958hM61752p3, gVarM61755e, arrayList);
    }

    /* renamed from: l */
    public final InterfaceC9955e m61751l(C9959i c9959i) throws C9952b {
        InterfaceC9955e interfaceC9955eM61750k = m61750k(c9959i);
        if (!c9959i.m61783a()) {
            String strM61786d = c9959i.m61786d();
            while (true) {
                if (!"and".equals(strM61786d) && !"or".equals(strM61786d)) {
                    break;
                }
                boolean zEquals = "and".equals(c9959i.m61785c());
                InterfaceC9955e interfaceC9955eM61750k2 = m61750k(c9959i);
                interfaceC9955eM61750k = zEquals ? m61744h(interfaceC9955eM61750k, interfaceC9955eM61750k2) : m61745i(interfaceC9955eM61750k, interfaceC9955eM61750k2);
                if (c9959i.m61783a()) {
                    break;
                }
                strM61786d = c9959i.m61786d();
            }
        }
        return interfaceC9955eM61750k;
    }

    /* renamed from: p */
    public InterfaceC9958h m61752p(String str) {
        return this.f48729a.get(str);
    }
}

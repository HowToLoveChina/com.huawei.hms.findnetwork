package p692uw;

import ax.C1046p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kw.C11170d0;
import kw.C11172e0;
import kw.C11186m;
import kw.C11187n;
import p408jw.C10944j;
import p408jw.C10948n;
import p641sw.C12870a;
import p824yw.InterfaceC14050b;
import tw.InterfaceC13075a;
import tw.InterfaceC13076b;
import tw.InterfaceC13077c;
import tw.InterfaceC13078d;
import tw.InterfaceC13079e;
import tw.InterfaceC13080f;
import tw.InterfaceC13081g;
import tw.InterfaceC13082h;
import tw.InterfaceC13083i;
import tw.InterfaceC13084j;
import tw.InterfaceC13085k;
import tw.InterfaceC13086l;
import tw.InterfaceC13087m;
import tw.InterfaceC13088n;
import tw.InterfaceC13089o;
import tw.InterfaceC13090p;
import tw.InterfaceC13091q;
import tw.InterfaceC13092r;
import tw.InterfaceC13093s;
import tw.InterfaceC13094t;
import tw.InterfaceC13095u;
import tw.InterfaceC13096v;
import tw.InterfaceC13097w;

/* renamed from: uw.e */
/* loaded from: classes9.dex */
public final class C13262e implements InterfaceC14050b<Object>, InterfaceC13261d {

    /* renamed from: b */
    public static final a f59967b = new a(null);

    /* renamed from: c */
    public static final Map<Class<Object>, Integer> f59968c;

    /* renamed from: d */
    public static final HashMap<String, String> f59969d;

    /* renamed from: e */
    public static final HashMap<String, String> f59970e;

    /* renamed from: f */
    public static final HashMap<String, String> f59971f;

    /* renamed from: g */
    public static final Map<String, String> f59972g;

    /* renamed from: a */
    public final Class<?> f59973a;

    /* renamed from: uw.e$a */
    public static final class a {
        public /* synthetic */ a(C13264g c13264g) {
            this();
        }

        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        List listM67177g = C11186m.m67177g(InterfaceC13075a.class, InterfaceC13086l.class, InterfaceC13090p.class, InterfaceC13091q.class, InterfaceC13092r.class, InterfaceC13093s.class, InterfaceC13094t.class, InterfaceC13095u.class, InterfaceC13096v.class, InterfaceC13097w.class, InterfaceC13076b.class, InterfaceC13077c.class, InterfaceC13078d.class, InterfaceC13079e.class, InterfaceC13080f.class, InterfaceC13081g.class, InterfaceC13082h.class, InterfaceC13083i.class, InterfaceC13084j.class, InterfaceC13085k.class, InterfaceC13087m.class, InterfaceC13088n.class, InterfaceC13089o.class);
        ArrayList arrayList = new ArrayList(C11187n.m67182l(listM67177g, 10));
        int i10 = 0;
        for (Object obj : listM67177g) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C11186m.m67181k();
            }
            arrayList.add(C10948n.m66075a((Class) obj, Integer.valueOf(i10)));
            i10 = i11;
        }
        f59968c = C11172e0.m67138g(arrayList);
        HashMap<String, String> map = new HashMap<>();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        f59969d = map;
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        f59970e = map2;
        HashMap<String, String> map3 = new HashMap<>();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        C13267j.m79676d(collectionValues, "primitiveFqNames.values");
        for (String str : collectionValues) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("kotlin.jvm.internal.");
            C13267j.m79676d(str, "kotlinName");
            sb2.append(C1046p.m6269F(str, '.', null, 2, null));
            sb2.append("CompanionObject");
            C10944j c10944jM66075a = C10948n.m66075a(sb2.toString(), str + ".Companion");
            map3.put(c10944jM66075a.m66068d(), c10944jM66075a.m66069e());
        }
        for (Map.Entry<Class<Object>, Integer> entry : f59968c.entrySet()) {
            map3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        f59971f = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(C11170d0.m67131a(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), C1046p.m6269F((String) entry2.getValue(), '.', null, 2, null));
        }
        f59972g = linkedHashMap;
    }

    public C13262e(Class<?> cls) {
        C13267j.m79677e(cls, "jClass");
        this.f59973a = cls;
    }

    @Override // p692uw.InterfaceC13261d
    /* renamed from: a */
    public Class<?> mo79668a() {
        return this.f59973a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C13262e) && C13267j.m79673a(C12870a.m77225b(this), C12870a.m77225b((InterfaceC14050b) obj));
    }

    public int hashCode() {
        return C12870a.m77225b(this).hashCode();
    }

    public String toString() {
        return mo79668a().toString() + " (Kotlin reflection is not available)";
    }
}

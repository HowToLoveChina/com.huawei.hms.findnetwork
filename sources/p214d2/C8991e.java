package p214d2;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: d2.e */
/* loaded from: classes.dex */
public final class C8991e implements InterfaceC8989c {

    /* renamed from: c */
    public final Map<String, List<InterfaceC8990d>> f45596c;

    /* renamed from: d */
    public volatile Map<String, String> f45597d;

    /* renamed from: d2.e$a */
    public static final class a {

        /* renamed from: d */
        public static final String f45598d;

        /* renamed from: e */
        public static final Map<String, List<InterfaceC8990d>> f45599e;

        /* renamed from: a */
        public boolean f45600a = true;

        /* renamed from: b */
        public Map<String, List<InterfaceC8990d>> f45601b = f45599e;

        /* renamed from: c */
        public boolean f45602c = true;

        static {
            String strM56828g = m56828g();
            f45598d = strM56828g;
            HashMap map = new HashMap(2);
            if (!TextUtils.isEmpty(strM56828g)) {
                map.put("User-Agent", Collections.singletonList(new b(strM56828g)));
            }
            f45599e = Collections.unmodifiableMap(map);
        }

        /* renamed from: g */
        public static String m56828g() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb2 = new StringBuilder(property.length());
            for (int i10 = 0; i10 < length; i10++) {
                char cCharAt = property.charAt(i10);
                if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                    sb2.append(cCharAt);
                } else {
                    sb2.append('?');
                }
            }
            return sb2.toString();
        }

        /* renamed from: a */
        public a m56829a(String str, InterfaceC8990d interfaceC8990d) {
            if (this.f45602c && "User-Agent".equalsIgnoreCase(str)) {
                return m56835h(str, interfaceC8990d);
            }
            m56833e();
            m56834f(str).add(interfaceC8990d);
            return this;
        }

        /* renamed from: b */
        public a m56830b(String str, String str2) {
            return m56829a(str, new b(str2));
        }

        /* renamed from: c */
        public C8991e m56831c() {
            this.f45600a = true;
            return new C8991e(this.f45601b);
        }

        /* renamed from: d */
        public final Map<String, List<InterfaceC8990d>> m56832d() {
            HashMap map = new HashMap(this.f45601b.size());
            for (Map.Entry<String, List<InterfaceC8990d>> entry : this.f45601b.entrySet()) {
                map.put(entry.getKey(), new ArrayList(entry.getValue()));
            }
            return map;
        }

        /* renamed from: e */
        public final void m56833e() {
            if (this.f45600a) {
                this.f45600a = false;
                this.f45601b = m56832d();
            }
        }

        /* renamed from: f */
        public final List<InterfaceC8990d> m56834f(String str) {
            List<InterfaceC8990d> list = this.f45601b.get(str);
            if (list != null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            this.f45601b.put(str, arrayList);
            return arrayList;
        }

        /* renamed from: h */
        public a m56835h(String str, InterfaceC8990d interfaceC8990d) {
            m56833e();
            if (interfaceC8990d == null) {
                this.f45601b.remove(str);
            } else {
                List<InterfaceC8990d> listM56834f = m56834f(str);
                listM56834f.clear();
                listM56834f.add(interfaceC8990d);
            }
            if (this.f45602c && "User-Agent".equalsIgnoreCase(str)) {
                this.f45602c = false;
            }
            return this;
        }
    }

    /* renamed from: d2.e$b */
    public static final class b implements InterfaceC8990d {

        /* renamed from: a */
        public final String f45603a;

        public b(String str) {
            this.f45603a = str;
        }

        @Override // p214d2.InterfaceC8990d
        /* renamed from: a */
        public String mo56825a() {
            return this.f45603a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f45603a.equals(((b) obj).f45603a);
            }
            return false;
        }

        public int hashCode() {
            return this.f45603a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f45603a + "'}";
        }
    }

    public C8991e(Map<String, List<InterfaceC8990d>> map) {
        this.f45596c = Collections.unmodifiableMap(map);
    }

    @Override // p214d2.InterfaceC8989c
    /* renamed from: a */
    public Map<String, String> mo56824a() {
        if (this.f45597d == null) {
            synchronized (this) {
                try {
                    if (this.f45597d == null) {
                        this.f45597d = Collections.unmodifiableMap(m56827c());
                    }
                } finally {
                }
            }
        }
        return this.f45597d;
    }

    /* renamed from: b */
    public final String m56826b(List<InterfaceC8990d> list) {
        StringBuilder sb2 = new StringBuilder();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            String strMo56825a = list.get(i10).mo56825a();
            if (!TextUtils.isEmpty(strMo56825a)) {
                sb2.append(strMo56825a);
                if (i10 != list.size() - 1) {
                    sb2.append(',');
                }
            }
        }
        return sb2.toString();
    }

    /* renamed from: c */
    public final Map<String, String> m56827c() {
        HashMap map = new HashMap();
        for (Map.Entry<String, List<InterfaceC8990d>> entry : this.f45596c.entrySet()) {
            String strM56826b = m56826b(entry.getValue());
            if (!TextUtils.isEmpty(strM56826b)) {
                map.put(entry.getKey(), strM56826b);
            }
        }
        return map;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C8991e) {
            return this.f45596c.equals(((C8991e) obj).f45596c);
        }
        return false;
    }

    public int hashCode() {
        return this.f45596c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f45596c + '}';
    }
}

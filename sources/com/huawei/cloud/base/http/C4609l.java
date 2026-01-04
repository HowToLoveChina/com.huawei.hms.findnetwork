package com.huawei.cloud.base.http;

import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.C4628b;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.cloud.base.util.C4635e0;
import com.huawei.cloud.base.util.C4637f0;
import com.huawei.cloud.base.util.C4638g;
import com.huawei.cloud.base.util.C4641i;
import com.huawei.cloud.base.util.C4642j;
import com.huawei.cloud.base.util.C4645m;
import com.huawei.cloud.base.util.C4646n;
import com.huawei.cloud.base.util.C4650r;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.hms.network.embedded.C5966j2;
import com.huawei.hms.network.embedded.C6069r1;
import com.huawei.location.base.activity.constant.ActivityRecognitionConstants;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.huawei.cloud.base.http.l */
/* loaded from: classes.dex */
public class C4609l extends C4646n {

    /* renamed from: b */
    @InterfaceC4648p(C5966j2.f27080v)
    public List<String> f21165b;

    /* renamed from: c */
    @InterfaceC4648p(FeedbackWebConstants.AUTHORIZATION)
    public List<String> f21166c;

    /* renamed from: d */
    @InterfaceC4648p("Content-Encoding")
    public List<String> f21167d;

    /* renamed from: e */
    @InterfaceC4648p("Content-Length")
    public List<Long> f21168e;

    /* renamed from: f */
    @InterfaceC4648p("Content-Range")
    public List<String> f21169f;

    /* renamed from: g */
    @InterfaceC4648p("Content-Type")
    public List<String> f21170g;

    /* renamed from: h */
    @InterfaceC4648p(C6069r1.b.f27986o)
    public List<String> f21171h;

    /* renamed from: i */
    @InterfaceC4648p("If-Match")
    public List<String> f21172i;

    /* renamed from: j */
    @InterfaceC4648p(C6069r1.b.f27985n)
    public List<String> f21173j;

    /* renamed from: k */
    @InterfaceC4648p("If-Unmodified-Since")
    public List<String> f21174k;

    /* renamed from: l */
    @InterfaceC4648p("If-Range")
    public List<String> f21175l;

    /* renamed from: m */
    @InterfaceC4648p(ActivityRecognitionConstants.LOCATION_MODULE)
    public List<String> f21176m;

    /* renamed from: n */
    @InterfaceC4648p("Range")
    public List<String> f21177n;

    /* renamed from: o */
    @InterfaceC4648p("User-Agent")
    public List<String> f21178o;

    /* renamed from: com.huawei.cloud.base.http.l$a */
    public static class a extends AbstractC4622y {

        /* renamed from: g */
        public final C4609l f21179g;

        /* renamed from: h */
        public final b f21180h;

        public a(C4609l c4609l, b bVar) {
            this.f21179g = c4609l;
            this.f21180h = bVar;
        }

        @Override // com.huawei.cloud.base.http.AbstractC4622y
        /* renamed from: a */
        public void mo28242a(String str, String str2) {
            this.f21179g.m28241z(str, str2, this.f21180h);
        }

        @Override // com.huawei.cloud.base.http.AbstractC4622y
        /* renamed from: c */
        public AbstractC4623z mo28243c() throws IOException {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: com.huawei.cloud.base.http.l$b */
    public static final class b {

        /* renamed from: a */
        public final C4628b f21181a;

        /* renamed from: b */
        public final StringBuilder f21182b;

        /* renamed from: c */
        public final C4638g f21183c;

        /* renamed from: d */
        public final List<Type> f21184d;

        public b(C4609l c4609l, StringBuilder sb2) {
            Class<?> cls = c4609l.getClass();
            this.f21184d = Collections.singletonList(cls);
            this.f21183c = C4638g.m28428g(cls, true);
            this.f21182b = sb2;
            this.f21181a = new C4628b(c4609l);
        }

        /* renamed from: a */
        public void m28244a() {
            this.f21181a.m28398b();
        }
    }

    public C4609l() {
        super(EnumSet.of(C4646n.c.IGNORE_CASE));
        this.f21165b = new ArrayList(Collections.singleton(Constants.GZIP));
    }

    /* renamed from: A */
    public static Object m28208A(Type type, List<Type> list, String str) {
        return C4642j.m28449l(C4642j.m28450m(list, type), str);
    }

    /* renamed from: B */
    public static void m28209B(C4609l c4609l, StringBuilder sb2, C4650r c4650r, AbstractC4622y abstractC4622y) throws IOException {
        m28210C(c4609l, sb2, c4650r, abstractC4622y, null);
    }

    /* renamed from: C */
    public static void m28210C(C4609l c4609l, StringBuilder sb2, C4650r c4650r, AbstractC4622y abstractC4622y, Writer writer) throws IOException {
        HashSet hashSet = new HashSet();
        for (Map.Entry<String, Object> entry : c4609l.entrySet()) {
            String key = entry.getKey();
            C4627a0.m28390c(hashSet.add(key), "multiple headers of the same name (headers are case insensitive): %s", key);
            Object value = entry.getValue();
            if (value != null) {
                C4645m c4645mM28430b = c4609l.getClassInfo().m28430b(key);
                if (c4645mM28430b != null) {
                    key = c4645mM28430b.m28467e();
                }
                String str = key;
                Class<?> cls = value.getClass();
                if ((value instanceof Iterable) || cls.isArray()) {
                    Iterator it = C4637f0.m28423l(value).iterator();
                    while (it.hasNext()) {
                        m28213b(c4650r, sb2, abstractC4622y, str, it.next(), writer);
                    }
                } else {
                    m28213b(c4650r, sb2, abstractC4622y, str, value, writer);
                }
            }
        }
        if (writer != null) {
            writer.flush();
        }
    }

    /* renamed from: D */
    public static void m28211D(C4609l c4609l, StringBuilder sb2, C4650r c4650r, Writer writer) throws IOException {
        m28210C(c4609l, sb2, c4650r, null, writer);
    }

    /* renamed from: U */
    public static String m28212U(Object obj) {
        return obj instanceof Enum ? C4645m.m28461j((Enum) obj).m28467e() : obj.toString();
    }

    /* renamed from: b */
    public static void m28213b(C4650r c4650r, StringBuilder sb2, AbstractC4622y abstractC4622y, String str, Object obj, Writer writer) throws IOException {
        if (obj == null || C4642j.m28441d(obj)) {
            return;
        }
        String strM28212U = m28212U(obj);
        if (str != null && C4641i.f21286a.contains(str.toLowerCase(Locale.US))) {
            C4641i.f21288c.put(str, Integer.valueOf(strM28212U.length()));
        }
        if (sb2 != null) {
            sb2.append(str);
            sb2.append(": ");
            sb2.append(strM28212U);
            sb2.append(C4633d0.f21267b);
        }
        if (abstractC4622y != null) {
            abstractC4622y.mo28242a(str, strM28212U);
        }
        if (writer != null) {
            writer.write(str);
            writer.write(": ");
            writer.write(strM28212U);
            writer.write("\r\n");
        }
    }

    @Override // com.huawei.cloud.base.util.C4646n
    /* renamed from: E */
    public C4609l set(String str, Object obj) {
        return (C4609l) super.set(str, obj);
    }

    /* renamed from: F */
    public C4609l m28215F(String str) {
        this.f21165b = m28232q(str);
        return this;
    }

    /* renamed from: G */
    public C4609l m28216G(String str) {
        return m28217H(m28232q(str));
    }

    /* renamed from: H */
    public C4609l m28217H(List<String> list) {
        this.f21166c = list;
        return this;
    }

    /* renamed from: J */
    public C4609l m28218J(String str) {
        this.f21167d = m28232q(str);
        return this;
    }

    /* renamed from: K */
    public C4609l m28219K(Long l10) {
        this.f21168e = m28232q(l10);
        return this;
    }

    /* renamed from: L */
    public C4609l m28220L(String str) {
        this.f21169f = m28232q(str);
        return this;
    }

    /* renamed from: M */
    public C4609l m28221M(String str) {
        this.f21170g = m28232q(str);
        return this;
    }

    /* renamed from: N */
    public C4609l m28222N(String str) {
        this.f21172i = m28232q(str);
        return this;
    }

    /* renamed from: O */
    public C4609l m28223O(String str) {
        this.f21171h = m28232q(str);
        return this;
    }

    /* renamed from: P */
    public C4609l m28224P(String str) {
        this.f21173j = m28232q(str);
        return this;
    }

    /* renamed from: Q */
    public C4609l m28225Q(String str) {
        this.f21175l = m28232q(str);
        return this;
    }

    /* renamed from: R */
    public C4609l m28226R(String str) {
        this.f21174k = m28232q(str);
        return this;
    }

    /* renamed from: S */
    public C4609l m28227S(String str) {
        this.f21177n = m28232q(str);
        return this;
    }

    /* renamed from: T */
    public C4609l m28228T(String str) {
        this.f21178o = m28232q(str);
        return this;
    }

    @Override // com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
    /* renamed from: f */
    public C4609l clone() {
        return (C4609l) super.clone();
    }

    /* renamed from: k */
    public final void m28230k(C4609l c4609l) {
        try {
            b bVar = new b(this, null);
            m28209B(c4609l, null, null, new a(this, bVar));
            bVar.m28244a();
        } catch (IOException e10) {
            throw C4635e0.m28408a(e10);
        }
    }

    /* renamed from: p */
    public final void m28231p(AbstractC4623z abstractC4623z, StringBuilder sb2) throws IOException {
        clear();
        b bVar = new b(this, sb2);
        int iMo28356e = abstractC4623z.mo28356e();
        for (int i10 = 0; i10 < iMo28356e; i10++) {
            m28241z(abstractC4623z.mo28357f(i10), abstractC4623z.mo28358g(i10), bVar);
        }
        bVar.m28244a();
    }

    /* renamed from: q */
    public final <T> List<T> m28232q(T t10) {
        if (t10 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(t10);
        return arrayList;
    }

    /* renamed from: r */
    public final List<String> m28233r() {
        return this.f21166c;
    }

    /* renamed from: s */
    public final Long m28234s() {
        return (Long) m28238w(this.f21168e);
    }

    /* renamed from: t */
    public final String m28235t() {
        return (String) m28238w(this.f21169f);
    }

    /* renamed from: u */
    public final String m28236u() {
        return (String) m28238w(this.f21170g);
    }

    /* renamed from: v */
    public String m28237v(String str) {
        Object obj = get(str.toLowerCase(Locale.US));
        if (obj == null) {
            return null;
        }
        Class<?> cls = obj.getClass();
        if ((obj instanceof Iterable) || cls.isArray()) {
            Iterator it = C4637f0.m28423l(obj).iterator();
            if (it.hasNext()) {
                return m28212U(it.next());
            }
        }
        return m28212U(obj);
    }

    /* renamed from: w */
    public final <T> T m28238w(List<T> list) {
        if (list == null) {
            return null;
        }
        return list.get(0);
    }

    /* renamed from: x */
    public final String m28239x() {
        return (String) m28238w(this.f21176m);
    }

    /* renamed from: y */
    public final String m28240y() {
        return (String) m28238w(this.f21178o);
    }

    /* renamed from: z */
    public void m28241z(String str, String str2, b bVar) {
        List<Type> list = bVar.f21184d;
        C4638g c4638g = bVar.f21183c;
        C4628b c4628b = bVar.f21181a;
        StringBuilder sb2 = bVar.f21182b;
        if (sb2 != null) {
            sb2.append(str);
            sb2.append(": ");
            sb2.append(str2);
            sb2.append(C4633d0.f21267b);
        }
        C4645m c4645mM28430b = c4638g.m28430b(str);
        if (c4645mM28430b == null) {
            ArrayList arrayList = (ArrayList) get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                set(str, arrayList);
            }
            arrayList.add(str2);
            return;
        }
        Type typeM28450m = C4642j.m28450m(list, c4645mM28430b.m28466d());
        if (C4637f0.m28421j(typeM28450m)) {
            Class<?> clsM28417f = C4637f0.m28417f(list, C4637f0.m28413b(typeM28450m));
            c4628b.m28397a(c4645mM28430b.m28465b(), clsM28417f, m28208A(clsM28417f, list, str2));
        } else {
            if (!C4637f0.m28422k(C4637f0.m28417f(list, typeM28450m), Iterable.class)) {
                c4645mM28430b.m28472m(this, m28208A(typeM28450m, list, str2));
                return;
            }
            Collection<Object> collectionM28445h = (Collection) c4645mM28430b.m28469g(this);
            if (collectionM28445h == null) {
                collectionM28445h = C4642j.m28445h(typeM28450m);
                c4645mM28430b.m28472m(this, collectionM28445h);
            }
            collectionM28445h.add(m28208A(typeM28450m == Object.class ? null : C4637f0.m28415d(typeM28450m), list, str2));
        }
    }
}

package com.huawei.cloud.base.http;

import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.C4646n;
import com.huawei.hms.network.embedded.C5929g4;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import p656ti.AbstractC13015b;
import p656ti.C13014a;
import p656ti.C13016c;

/* renamed from: com.huawei.cloud.base.http.g */
/* loaded from: classes.dex */
public class C4604g extends C4646n {

    /* renamed from: h */
    public static final AbstractC13015b f21156h = new C13016c("=&-_.!~*'()@:$,;/?:", false);

    /* renamed from: b */
    public String f21157b;

    /* renamed from: c */
    public String f21158c;

    /* renamed from: d */
    public String f21159d;

    /* renamed from: e */
    public int f21160e;

    /* renamed from: f */
    public List<String> f21161f;

    /* renamed from: g */
    public String f21162g;

    public C4604g() {
        this.f21160e = -1;
    }

    /* renamed from: b */
    public static void m28191b(Set<Map.Entry<String, Object>> set, StringBuilder sb2) {
        boolean zM28192f = true;
        for (Map.Entry<String, Object> entry : set) {
            Object value = entry.getValue();
            if (value != null) {
                String strM78327e = C13014a.m78327e(entry.getKey());
                if (value instanceof Collection) {
                    Iterator it = ((Collection) value).iterator();
                    while (it.hasNext()) {
                        zM28192f = m28192f(zM28192f, sb2, strM78327e, it.next());
                    }
                } else {
                    zM28192f = m28192f(zM28192f, sb2, strM78327e, value);
                }
            }
        }
    }

    /* renamed from: f */
    public static boolean m28192f(boolean z10, StringBuilder sb2, String str, Object obj) {
        if (z10) {
            sb2.append('?');
            z10 = false;
        } else {
            sb2.append('&');
        }
        sb2.append(str);
        String strM78327e = C13014a.m78327e(obj.toString());
        if (strM78327e.length() != 0) {
            sb2.append('=');
            sb2.append(strM78327e);
        }
        return z10;
    }

    /* renamed from: t */
    public static URL m28193t(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    /* renamed from: z */
    public static List<String> m28194z(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        boolean z10 = true;
        while (z10) {
            int iIndexOf = str.indexOf(47, i10);
            boolean z11 = iIndexOf != -1;
            arrayList.add(C13014a.m78323a(z11 ? str.substring(i10, iIndexOf) : str.substring(i10)));
            i10 = iIndexOf + 1;
            z10 = z11;
        }
        return arrayList;
    }

    /* renamed from: A */
    public final URL m28195A() {
        return m28193t(m28198p());
    }

    /* renamed from: B */
    public final URL m28196B(String str) {
        try {
            return new URL(m28195A(), str);
        } catch (MalformedURLException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (super.equals(obj) && (obj instanceof C4604g)) {
            return m28198p().equals(((C4604g) obj).m28198p());
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return m28198p().hashCode();
    }

    /* renamed from: k */
    public final void m28197k(StringBuilder sb2) {
        int size = this.f21161f.size();
        for (int i10 = 0; i10 < size; i10++) {
            String str = this.f21161f.get(i10);
            if (i10 != 0) {
                sb2.append(C5929g4.f26852n);
            }
            if (str.length() != 0) {
                sb2.append(C13014a.m78325c(str));
            }
        }
    }

    /* renamed from: p */
    public final String m28198p() {
        return m28199q() + m28200r();
    }

    /* renamed from: q */
    public final String m28199q() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append((String) C4627a0.m28391d(this.f21157b));
        sb2.append("://");
        String str = this.f21159d;
        if (str != null) {
            sb2.append(C13014a.m78328f(str));
            sb2.append('@');
        }
        sb2.append((String) C4627a0.m28391d(this.f21158c));
        int i10 = this.f21160e;
        if (i10 != -1) {
            sb2.append(':');
            sb2.append(i10);
        }
        return sb2.toString();
    }

    /* renamed from: r */
    public final String m28200r() {
        StringBuilder sb2 = new StringBuilder();
        if (this.f21161f != null) {
            m28197k(sb2);
        }
        m28191b(entrySet(), sb2);
        String str = this.f21162g;
        if (str != null) {
            sb2.append('#');
            sb2.append(f21156h.mo78329a(str));
        }
        return sb2.toString();
    }

    @Override // com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public C4604g clone() {
        C4604g c4604g = (C4604g) super.clone();
        if (this.f21161f != null) {
            c4604g.f21161f = new ArrayList(this.f21161f);
        }
        return c4604g;
    }

    @Override // java.util.AbstractMap
    public String toString() {
        return m28198p();
    }

    @Override // com.huawei.cloud.base.util.C4646n
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public C4604g set(String str, Object obj) {
        return (C4604g) super.set(str, obj);
    }

    /* renamed from: v */
    public final void m28203v(String str) {
        this.f21158c = (String) C4627a0.m28391d(str);
    }

    /* renamed from: w */
    public final void m28204w(int i10) {
        C4627a0.m28389b(i10 >= -1, "expected port >= -1");
        this.f21160e = i10;
    }

    /* renamed from: x */
    public void m28205x(String str) {
        this.f21161f = m28194z(str);
    }

    /* renamed from: y */
    public final void m28206y(String str) {
        this.f21157b = (String) C4627a0.m28391d(str);
    }

    public C4604g(String str) {
        this(m28193t(str));
    }

    public C4604g(URL url) {
        this(url.getProtocol(), url.getHost(), url.getPort(), url.getPath(), url.getRef(), url.getQuery(), url.getUserInfo());
    }

    public C4604g(String str, String str2, int i10, String str3, String str4, String str5, String str6) {
        this.f21160e = -1;
        this.f21157b = str.toLowerCase(Locale.US);
        this.f21158c = str2;
        this.f21160e = i10;
        this.f21161f = m28194z(str3);
        this.f21162g = str4 != null ? C13014a.m78323a(str4) : null;
        if (str5 != null) {
            C4601d0.m28183d(str5, this);
        }
        this.f21159d = str6 != null ? C13014a.m78323a(str6) : null;
    }
}

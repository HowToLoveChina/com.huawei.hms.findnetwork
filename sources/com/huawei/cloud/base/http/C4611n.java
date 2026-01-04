package com.huawei.cloud.base.http;

import com.huawei.cloud.base.util.C4627a0;
import com.huawei.hms.network.embedded.C5929g4;
import com.huawei.hms.network.embedded.C6036o7;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.huawei.cloud.base.http.n */
/* loaded from: classes.dex */
public final class C4611n {

    /* renamed from: e */
    public static final Pattern f21185e = Pattern.compile("[\\w!#$&.+\\-\\^_]+|[*]");

    /* renamed from: f */
    public static final Pattern f21186f = Pattern.compile("[\\p{ASCII}&&[^\\p{Cntrl} ;/=\\[\\]\\(\\)\\<\\>\\@\\,\\:\\\"\\?\\=]]+");

    /* renamed from: g */
    public static final Pattern f21187g = Pattern.compile("\\s*([^\\s/=;\"]+)/([^\\s/=;\"]+)\\s*(;.*)?", 32);

    /* renamed from: h */
    public static final Pattern f21188h;

    /* renamed from: a */
    public final SortedMap<String, String> f21189a = new TreeMap();

    /* renamed from: b */
    public String f21190b = "application";

    /* renamed from: c */
    public String f21191c = "octet-stream";

    /* renamed from: d */
    public String f21192d;

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C6036o7.f27617f);
        sb2.append("|");
        sb2.append("[^\\s;\"]*");
        f21188h = Pattern.compile("\\s*;\\s*([^\\s/=;\"]+)=(" + sb2.toString() + ")");
    }

    public C4611n(String str) {
        m28250c(str);
    }

    /* renamed from: h */
    public static boolean m28246h(String str) {
        return f21186f.matcher(str).matches();
    }

    /* renamed from: i */
    public static String m28247i(String str) {
        return "\"" + str.replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
    }

    /* renamed from: a */
    public String m28248a() {
        String str = this.f21192d;
        if (str != null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f21190b);
        sb2.append(C5929g4.f26852n);
        sb2.append(this.f21191c);
        SortedMap<String, String> sortedMap = this.f21189a;
        if (sortedMap != null) {
            for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
                String value = entry.getValue();
                sb2.append("; ");
                sb2.append(entry.getKey());
                sb2.append("=");
                if (!m28246h(value)) {
                    value = m28247i(value);
                }
                sb2.append(value);
            }
        }
        String string = sb2.toString();
        this.f21192d = string;
        return string;
    }

    /* renamed from: b */
    public boolean m28249b(C4611n c4611n) {
        return c4611n != null && m28254g().equalsIgnoreCase(c4611n.m28254g()) && m28253f().equalsIgnoreCase(c4611n.m28253f());
    }

    /* renamed from: c */
    public final C4611n m28250c(String str) {
        Matcher matcher = f21187g.matcher(str);
        C4627a0.m28389b(matcher.matches(), "Type must be in the 'maintype/subtype; parameter=value' format");
        m28259n(matcher.group(1));
        m28258m(matcher.group(2));
        String strGroup = matcher.group(3);
        if (strGroup != null) {
            Matcher matcher2 = f21188h.matcher(strGroup);
            while (matcher2.find()) {
                String strGroup2 = matcher2.group(1);
                String strGroup3 = matcher2.group(3);
                if (strGroup3 == null) {
                    strGroup3 = matcher2.group(2);
                }
                m28257l(strGroup2, strGroup3);
            }
        }
        return this;
    }

    /* renamed from: d */
    public Charset m28251d() {
        String strM28252e = m28252e("charset");
        if (strM28252e == null) {
            return null;
        }
        return Charset.forName(strM28252e);
    }

    /* renamed from: e */
    public String m28252e(String str) {
        return this.f21189a.get(str.toLowerCase(Locale.US));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C4611n)) {
            return false;
        }
        C4611n c4611n = (C4611n) obj;
        return m28249b(c4611n) && this.f21189a.equals(c4611n.f21189a);
    }

    /* renamed from: f */
    public String m28253f() {
        return this.f21191c;
    }

    /* renamed from: g */
    public String m28254g() {
        return this.f21190b;
    }

    public int hashCode() {
        return m28248a().hashCode();
    }

    /* renamed from: j */
    public C4611n m28255j(String str) {
        this.f21192d = null;
        this.f21189a.remove(str.toLowerCase(Locale.US));
        return this;
    }

    /* renamed from: k */
    public C4611n m28256k(Charset charset) {
        m28257l("charset", charset == null ? null : charset.name());
        return this;
    }

    /* renamed from: l */
    public C4611n m28257l(String str, String str2) {
        if (str2 == null) {
            m28255j(str);
            return this;
        }
        C4627a0.m28389b(f21186f.matcher(str).matches(), "Name contains reserved characters");
        this.f21192d = null;
        this.f21189a.put(str.toLowerCase(Locale.US), str2);
        return this;
    }

    /* renamed from: m */
    public C4611n m28258m(String str) {
        C4627a0.m28389b(f21185e.matcher(str).matches(), "Subtype contains reserved characters");
        this.f21191c = str;
        this.f21192d = null;
        return this;
    }

    /* renamed from: n */
    public C4611n m28259n(String str) {
        C4627a0.m28389b(f21185e.matcher(str).matches(), "Type contains reserved characters");
        this.f21190b = str;
        this.f21192d = null;
        return this;
    }

    public String toString() {
        return m28248a();
    }
}

package com.huawei.hms.network.embedded;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.huawei.hms.network.embedded.o7 */
/* loaded from: classes8.dex */
public final class C6036o7 {

    /* renamed from: e */
    public static final String f27616e = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";

    /* renamed from: f */
    public static final String f27617f = "\"([^\"]*)\"";

    /* renamed from: g */
    public static final Pattern f27618g = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: h */
    public static final Pattern f27619h = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: a */
    public final String f27620a;

    /* renamed from: b */
    public final String f27621b;

    /* renamed from: c */
    public final String f27622c;

    /* renamed from: d */
    public final String f27623d;

    public C6036o7(String str, String str2, String str3, String str4) {
        this.f27620a = str;
        this.f27621b = str2;
        this.f27622c = str3;
        this.f27623d = str4;
    }

    /* renamed from: a */
    public static C6036o7 m34922a(String str) {
        Matcher matcher = f27618g.matcher(str);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
        }
        String strGroup = matcher.group(1);
        Locale locale = Locale.US;
        String lowerCase = strGroup.toLowerCase(locale);
        String lowerCase2 = matcher.group(2).toLowerCase(locale);
        Matcher matcher2 = f27619h.matcher(str);
        String str2 = null;
        for (int iEnd = matcher.end(); iEnd < str.length(); iEnd = matcher2.end()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                throw new IllegalArgumentException("Parameter is not formatted correctly: \"" + str.substring(iEnd) + "\" for: \"" + str + '\"');
            }
            String strGroup2 = matcher2.group(1);
            if (strGroup2 != null && strGroup2.equalsIgnoreCase("charset")) {
                String strGroup3 = matcher2.group(2);
                if (strGroup3 == null) {
                    strGroup3 = matcher2.group(3);
                } else if (strGroup3.startsWith("'") && strGroup3.endsWith("'") && strGroup3.length() > 2) {
                    strGroup3 = strGroup3.substring(1, strGroup3.length() - 1);
                }
                if (str2 != null && !strGroup3.equalsIgnoreCase(str2)) {
                    throw new IllegalArgumentException("Multiple charsets defined: \"" + str2 + "\" and: \"" + strGroup3 + "\" for: \"" + str + '\"');
                }
                str2 = strGroup3;
            }
        }
        return new C6036o7(str, lowerCase, lowerCase2, str2);
    }

    /* renamed from: b */
    public static C6036o7 m34923b(String str) {
        try {
            return m34922a(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: c */
    public String m34927c() {
        return this.f27621b;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C6036o7) && ((C6036o7) obj).f27620a.equals(this.f27620a);
    }

    public int hashCode() {
        return this.f27620a.hashCode();
    }

    public String toString() {
        return this.f27620a;
    }

    /* renamed from: a */
    public Charset m34924a() {
        return m34925a((Charset) null);
    }

    /* renamed from: b */
    public String m34926b() {
        return this.f27622c;
    }

    /* renamed from: a */
    public Charset m34925a(Charset charset) {
        try {
            String str = this.f27623d;
            return str != null ? Charset.forName(str) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}

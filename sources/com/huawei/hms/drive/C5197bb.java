package com.huawei.hms.drive;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.huawei.hms.drive.bb */
/* loaded from: classes8.dex */
public final class C5197bb {

    /* renamed from: a */
    private static final Pattern f23832a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: b */
    private static final Pattern f23833b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: c */
    private final String f23834c;

    /* renamed from: d */
    private final String f23835d;

    /* renamed from: e */
    private final String f23836e;

    /* renamed from: f */
    private final String f23837f;

    private C5197bb(String str, String str2, String str3, String str4) {
        this.f23834c = str;
        this.f23835d = str2;
        this.f23836e = str3;
        this.f23837f = str4;
    }

    /* renamed from: a */
    public static C5197bb m31036a(String str) {
        Matcher matcher = f23832a.matcher(str);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
        }
        String strGroup = matcher.group(1);
        Locale locale = Locale.US;
        String lowerCase = strGroup.toLowerCase(locale);
        String lowerCase2 = matcher.group(2).toLowerCase(locale);
        Matcher matcher2 = f23833b.matcher(str);
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
        return new C5197bb(str, lowerCase, lowerCase2, str2);
    }

    /* renamed from: b */
    public static C5197bb m31037b(String str) {
        try {
            return m31036a(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof C5197bb) && ((C5197bb) obj).f23834c.equals(this.f23834c);
    }

    public int hashCode() {
        return this.f23834c.hashCode();
    }

    public String toString() {
        return this.f23834c;
    }

    /* renamed from: a */
    public Charset m31038a() {
        return m31039a((Charset) null);
    }

    /* renamed from: a */
    public Charset m31039a(Charset charset) {
        try {
            String str = this.f23837f;
            return str != null ? Charset.forName(str) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}

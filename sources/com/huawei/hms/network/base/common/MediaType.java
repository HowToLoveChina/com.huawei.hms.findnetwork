package com.huawei.hms.network.base.common;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes8.dex */
public final class MediaType {

    /* renamed from: e */
    private static final String f26181e = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";

    /* renamed from: f */
    private static final String f26182f = "\"([^\"]*)\"";

    /* renamed from: g */
    private static final Pattern f26183g = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: h */
    private static final Pattern f26184h = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: a */
    private final String f26185a;

    /* renamed from: b */
    private final String f26186b;

    /* renamed from: c */
    private final String f26187c;

    /* renamed from: d */
    private final String f26188d;

    private MediaType(String str, String str2, String str3, String str4) {
        this.f26188d = str4;
        this.f26187c = str3;
        this.f26185a = str;
        this.f26186b = str2;
    }

    public static MediaType get(String str) {
        Matcher matcher = f26184h.matcher(str);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
        }
        String strGroup = matcher.group(1);
        Locale locale = Locale.US;
        String lowerCase = strGroup.toLowerCase(locale);
        String lowerCase2 = matcher.group(2).toLowerCase(locale);
        Matcher matcher2 = f26183g.matcher(str);
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
        return new MediaType(str, lowerCase, lowerCase2, str2);
    }

    public static MediaType parse(String str) {
        Matcher matcher = f26184h.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String strGroup = matcher.group(2);
        Locale locale = Locale.US;
        String lowerCase = strGroup.toLowerCase(locale);
        String lowerCase2 = matcher.group(1).toLowerCase(locale);
        Matcher matcher2 = f26183g.matcher(str);
        String str2 = null;
        for (int iEnd = matcher.end(); iEnd < str.length(); iEnd = matcher2.end()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                return null;
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
                    throw new IllegalArgumentException("multiple different charsets: " + str);
                }
                str2 = strGroup3;
            }
        }
        return new MediaType(str, lowerCase2, lowerCase, str2);
    }

    public Charset charset() {
        String str = this.f26188d;
        if (str != null) {
            return Charset.forName(str);
        }
        return null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MediaType) && ((MediaType) obj).f26185a.equals(this.f26185a);
    }

    public int hashCode() {
        return this.f26185a.hashCode();
    }

    public String subtype() {
        return this.f26187c;
    }

    public String toString() {
        return this.f26185a;
    }

    public String type() {
        return this.f26186b;
    }

    public Charset charset(Charset charset) {
        String str = this.f26188d;
        return str != null ? Charset.forName(str) : charset;
    }
}

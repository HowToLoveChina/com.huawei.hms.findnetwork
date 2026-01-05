package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: okhttp3.a0 */
/* loaded from: classes9.dex */
public final class MimeClass {

    /* renamed from: e */
    public static final Pattern f55149e = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: f */
    public static final Pattern f55150f = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: a */
    public final String f55151a;

    /* renamed from: b */
    public final String f55152b;

    /* renamed from: c */
    public final String f55153c;

    /* renamed from: d */
    public final String f55154d;

    public MimeClass(String str, String str2, String str3, String str4) {
        this.f55151a = str;
        this.f55152b = str2;
        this.f55153c = str3;
        this.f55154d = str4;
    }

    /* renamed from: c */
    public static MimeClass m71444c(String str) {
        Matcher matcher = f55149e.matcher(str);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
        }
        String strGroup = matcher.group(1);
        Locale locale = Locale.US;
        String lowerCase = strGroup.toLowerCase(locale);
        String lowerCase2 = matcher.group(2).toLowerCase(locale);
        Matcher matcher2 = f55150f.matcher(str);
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
        return new MimeClass(str, lowerCase, lowerCase2, str2);
    }

    /* renamed from: d */
    public static MimeClass m71445d(String str) {
        try {
            return m71444c(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public Charset m71446a() {
        return m71447b(null);
    }

    /* renamed from: b */
    public Charset m71447b(Charset charset) {
        try {
            String str = this.f55154d;
            return str != null ? Charset.forName(str) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof MimeClass) && ((MimeClass) obj).f55151a.equals(this.f55151a);
    }

    public int hashCode() {
        return this.f55151a.hashCode();
    }

    public String toString() {
        return this.f55151a;
    }
}

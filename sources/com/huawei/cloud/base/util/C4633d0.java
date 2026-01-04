package com.huawei.cloud.base.util;

import com.huawei.openalliance.p169ad.constant.Constants;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.regex.PatternSyntaxException;

/* renamed from: com.huawei.cloud.base.util.d0 */
/* loaded from: classes.dex */
public class C4633d0 {

    /* renamed from: a */
    public static final C4650r f21266a = C4650r.m28485f("StringUtils");

    /* renamed from: b */
    public static final String f21267b = System.getProperty("line.separator");

    /* renamed from: c */
    public static final Charset f21268c = Charset.forName(Constants.UTF_8);

    /* renamed from: a */
    public static boolean m28404a(String str) {
        return str == null || str.isEmpty();
    }

    /* renamed from: b */
    public static String m28405b(String str) {
        for (String str2 : C4641i.f21288c.keySet()) {
            Map<String, Integer> map = C4641i.f21288c;
            if (map.get(str2) != null) {
                try {
                    str = str.replaceAll("((?i)" + str2 + ").{" + (map.get(str2).intValue() + 2) + "}", str2 + ": *****");
                } catch (PatternSyntaxException e10) {
                    f21266a.m28492j("maskLogBody PatternSyntaxException: " + e10.getPattern());
                }
            }
        }
        for (String str3 : C4641i.f21287b) {
            try {
                str = str.replaceAll("\"(?i)" + str3 + "\":.*?([,}])", "\"" + str3 + "\":*****$1");
            } catch (PatternSyntaxException e11) {
                f21266a.m28492j("maskLogBody PatternSyntaxException: " + e11.getPattern());
            }
        }
        return str;
    }
}

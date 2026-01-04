package com.huawei.updatesdk.p177a.p178a.p183d;

import java.util.List;

/* renamed from: com.huawei.updatesdk.a.a.d.f */
/* loaded from: classes9.dex */
public class C8784f {
    /* renamed from: a */
    private static String m56055a(String str) {
        return str == null ? "" : str;
    }

    /* renamed from: a */
    public static String m56056a(List<String> list, String str) {
        return m56057a(list, str, (String) null, (String) null);
    }

    /* renamed from: a */
    public static String m56057a(List<String> list, String str, String str2, String str3) {
        return (list == null || list.isEmpty()) ? "" : m56059a((String[]) list.toArray(new String[0]), str, str2, str3);
    }

    /* renamed from: a */
    public static String m56058a(String[] strArr, String str) {
        return m56059a(strArr, str, (String) null, (String) null);
    }

    /* renamed from: a */
    public static String m56059a(String[] strArr, String str, String str2, String str3) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        String strM56055a = m56055a(str);
        String strM56055a2 = m56055a(str2);
        String strM56055a3 = m56055a(str3);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(strM56055a2);
        sb2.append(strArr[0]);
        sb2.append(strM56055a3);
        for (int i10 = 1; i10 < strArr.length; i10++) {
            sb2.append(strM56055a);
            sb2.append(strM56055a2);
            sb2.append(strArr[i10]);
            sb2.append(strM56055a3);
        }
        return sb2.toString();
    }
}

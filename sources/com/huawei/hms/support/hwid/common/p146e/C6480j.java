package com.huawei.hms.support.hwid.common.p146e;

import java.util.regex.Pattern;

/* renamed from: com.huawei.hms.support.hwid.common.e.j */
/* loaded from: classes8.dex */
public class C6480j {
    /* renamed from: a */
    public static String m36912a(String str, String[] strArr) {
        return Pattern.compile(strArr[0]).matcher(str).replaceAll(strArr[1]);
    }

    /* renamed from: a */
    public static int m36911a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e10) {
            C6477g.m36907c("StringUtil", "paseInt error " + e10.getClass().getSimpleName(), true);
            return -1;
        }
    }
}

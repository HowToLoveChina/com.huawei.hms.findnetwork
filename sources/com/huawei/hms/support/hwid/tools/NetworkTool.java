package com.huawei.hms.support.hwid.tools;

import android.text.TextUtils;

/* loaded from: classes8.dex */
public final class NetworkTool {
    /* renamed from: a */
    private static boolean m36969a(Boolean bool) {
        return bool != null && bool.booleanValue();
    }

    public static String buildNetworkCookie(String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, Long l10) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append("=");
        if (!TextUtils.isEmpty(str2)) {
            sb2.append(str2);
        }
        if (m36969a(bool)) {
            sb2.append(";HttpOnly");
        }
        if (m36969a(bool2)) {
            sb2.append(";Secure");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb2.append(";Domain=");
            sb2.append(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb2.append(";Path=");
            sb2.append(str4);
        }
        if (l10 != null && l10.longValue() > 0) {
            sb2.append(";Max-Age=");
            sb2.append(l10);
        }
        return sb2.toString();
    }

    public static String buildNetworkUrl(String str, Boolean bool) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        String str2 = m36969a(bool) ? "https" : "http";
        StringBuilder sb2 = new StringBuilder(str2.length() + 3 + String.valueOf(str).length());
        sb2.append(str2);
        sb2.append("://");
        sb2.append(str);
        return sb2.toString();
    }
}

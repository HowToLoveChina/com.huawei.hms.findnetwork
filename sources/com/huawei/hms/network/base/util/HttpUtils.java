package com.huawei.hms.network.base.util;

import android.text.TextUtils;

/* loaded from: classes8.dex */
public class HttpUtils {
    public static final String HTTPS_PREFIX = "https://";
    public static final String HTTP_PREFIX = "http://";

    /* renamed from: a */
    private static final String f26230a = "HttpUtils";

    public static boolean isHttpOrGrsUrl(String str) {
        return isHttpUrl(str) || str.startsWith("grs://");
    }

    public static boolean isHttpUrl(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }
}

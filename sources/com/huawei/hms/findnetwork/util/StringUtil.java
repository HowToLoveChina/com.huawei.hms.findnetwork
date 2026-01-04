package com.huawei.hms.findnetwork.util;

import android.text.TextUtils;

/* loaded from: classes8.dex */
public class StringUtil {
    public static String wrapQuotes(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith("\"") && str.endsWith("\"")) {
            return str;
        }
        if (!str.startsWith("\"")) {
            str = '\"' + str;
        }
        if (str.endsWith("\"")) {
            return str;
        }
        return str + '\"';
    }
}

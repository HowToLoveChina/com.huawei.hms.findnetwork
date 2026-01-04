package com.huawei.fastengine.fastview.util;

import android.text.TextUtils;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import com.huawei.openalliance.p169ad.constant.Constants;

/* loaded from: classes5.dex */
public class ParseDeeplinkUtils {
    private static final String TAG = "ParseDeeplinkUtils";
    private static final String UNION_SCHEME = "hap://app/";

    public static String getPackageName(String str) {
        if (TextUtils.isEmpty(str)) {
            FastViewLogUtils.m28724e(TAG, "url is empty");
            return "";
        }
        if (str.startsWith(UNION_SCHEME)) {
            String strSubstring = str.substring(10);
            return strSubstring.indexOf("/") == -1 ? strSubstring : strSubstring.substring(0, strSubstring.indexOf("/"));
        }
        FastViewLogUtils.m28722d(TAG, "un matched scheme:" + str);
        return "";
    }

    public static String getPath(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            FastViewLogUtils.m28724e(TAG, "url or packageName is empty");
            return "";
        }
        int iIndexOf = str.indexOf(str2) + str2.length();
        if (iIndexOf == -1) {
            return "";
        }
        int iIndexOf2 = str.indexOf(Constants.QUESTION_STR);
        return iIndexOf2 == -1 ? str.substring(iIndexOf) : str.substring(iIndexOf, iIndexOf2);
    }
}

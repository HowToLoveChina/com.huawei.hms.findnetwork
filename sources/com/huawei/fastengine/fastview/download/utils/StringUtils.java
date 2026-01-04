package com.huawei.fastengine.fastview.download.utils;

/* loaded from: classes5.dex */
public abstract class StringUtils {
    private static final String TAG = "StringUtils";

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static String toDBC(String str) {
        char[] charArray = str.toCharArray();
        for (int i10 = 0; i10 < charArray.length; i10++) {
            char c10 = charArray[i10];
            if (c10 == 12288) {
                charArray[i10] = ' ';
            } else if (c10 > 65280 && c10 < 65375) {
                charArray[i10] = (char) (c10 - 65248);
            }
        }
        return new String(charArray);
    }
}

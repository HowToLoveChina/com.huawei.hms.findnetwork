package com.huawei.hms.findnetwork.comm.util;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* loaded from: classes8.dex */
public class VerifyUtil {
    private static final int SHARE_DEVICE_KEY_LEN = 64;
    private static final int SRC_TRAN_ID_LEN = 24;
    public static final int UNAVAILABLE_FLOOR = -100;
    public static final int UNAVAILABLE_SPEED = -1;

    public static boolean verifyFloor(int i10) {
        return i10 != -100;
    }

    public static boolean verifyMAC(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches(RegularExpressionConstants.MAC_PATTERN, str);
    }

    public static boolean verifyShareDeviceKey(String str) {
        return !TextUtils.isEmpty(str) && str.length() == 64;
    }

    public static boolean verifySn(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static boolean verifySrcTranId(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 24) {
            return Pattern.matches(RegularExpressionConstants.SRC_TRAN_ID_PATTERN, str);
        }
        return false;
    }
}

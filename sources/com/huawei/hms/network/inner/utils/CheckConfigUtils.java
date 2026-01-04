package com.huawei.hms.network.inner.utils;

import android.text.TextUtils;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class CheckConfigUtils {

    public static final class Constants {
        public static final String HTTP_1_1 = "http/1.1";
        public static final String HTTP_2 = "h2";
        public static final int MAX_CONNECTION_ATTEMPT_DELAY = 2000;
        public static final int MAX_DNS_RESULT_TTL = 86400;
        public static final int MAX_REQUEST_DISCRETE_TIME = 3000;
        public static final int MAX_RETRY_AFTER_TIME = 8000;
        public static final int MAX_RETRY_WAITING_TIME = 8000;
        public static final int MIN_CALL_TIMEOUT = 20;
        public static final int MIN_CONNECTION_ATTEMPT_DELAY = 100;
        public static final int MIN_CONNECT_TIMEOUT = 1000;
        public static final int MIN_DNS_RESULT_TTL = 60;
        public static final int ZERO = 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01e2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean checkIsCorrect(java.lang.String r5, java.lang.Object r6) {
        /*
            Method dump skipped, instructions count: 646
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.inner.utils.CheckConfigUtils.checkIsCorrect(java.lang.String, java.lang.Object):boolean");
    }

    public static boolean isBoolean(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.trim().equalsIgnoreCase("false") || str.trim().equalsIgnoreCase(FaqConstants.DISABLE_HA_REPORT);
    }

    public static boolean isMap(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new JSONObject(str).keys().hasNext();
        } catch (JSONException unused) {
            return false;
        }
    }

    public static boolean isValidProtocols(String str) {
        String[] strArrSplit = str.replace("[", "").replace("]", "").split(",");
        if (strArrSplit.length > 2) {
            return false;
        }
        for (String str2 : strArrSplit) {
            String strTrim = str2.trim();
            if (!"http/1.1".equalsIgnoreCase(strTrim) && !"h2".equalsIgnoreCase(strTrim)) {
                return false;
            }
        }
        return true;
    }
}

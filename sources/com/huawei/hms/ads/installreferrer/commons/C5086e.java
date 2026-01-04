package com.huawei.hms.ads.installreferrer.commons;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.net.URLDecoder;

/* renamed from: com.huawei.hms.ads.installreferrer.commons.e */
/* loaded from: classes8.dex */
public class C5086e {
    /* renamed from: a */
    public static String m30334a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLDecoder.decode(str, Constants.UTF_8);
        } catch (Throwable th2) {
            LogUtil.logError("StringUtils", "unsupport decoding, err: " + th2.getClass().getSimpleName());
            return null;
        }
    }
}

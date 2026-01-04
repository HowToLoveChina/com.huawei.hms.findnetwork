package com.huawei.hms.network.embedded;

import android.annotation.TargetApi;
import com.huawei.hms.framework.common.SecurityRandomHelper;
import eu.C9560a;

/* renamed from: com.huawei.hms.network.embedded.x1 */
/* loaded from: classes8.dex */
public class C6147x1 {

    /* renamed from: a */
    public static final String f28911a = "KeyGen";

    /* renamed from: b */
    public static final String f28912b = "RestClient_8.0.1.309_apple";

    /* renamed from: c */
    public static final int f28913c = 16;

    /* renamed from: a */
    public static String m35769a(String str) {
        return C9560a.m59677f(f28912b, str);
    }

    /* renamed from: b */
    public static String m35771b(String str) {
        return C9560a.m59680i(f28912b, str);
    }

    @TargetApi(23)
    /* renamed from: a */
    public static byte[] m35770a() {
        return SecurityRandomHelper.getInstance().generateSecureRandom(16);
    }
}

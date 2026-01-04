package com.huawei.hms.network.embedded;

import android.content.Context;
import android.os.Build;
import com.huawei.hms.framework.common.PackageUtils;
import com.huawei.hms.framework.common.StringUtils;

/* renamed from: com.huawei.hms.network.embedded.j1 */
/* loaded from: classes8.dex */
public class C5965j1 {

    /* renamed from: a */
    public static final String f27071a = "8.0.1.309";

    /* renamed from: b */
    public static final String f27072b = "2025-03-31";

    /* renamed from: c */
    public static final int f27073c = C6067r.f27959h.intValue();

    /* renamed from: d */
    public static String f27074d = null;

    /* renamed from: com.huawei.hms.network.embedded.j1$a */
    public static class a {
        public static final int CATTLE = 3;
        public static final int DRAGON = 6;
        public static final int RABBIT = 5;
        public static final int RAT = 2;
        public static final int SNAKE = 7;
        public static final int TIGER = 4;
    }

    public static String getAgent(Context context) {
        return context == null ? StringUtils.format("RestClient/%s", getVersion()) : StringUtils.format("%s/%s (Linux; Android %s; %s) RestClient/%s", context.getPackageName(), PackageUtils.getVersionName(context), Build.VERSION.RELEASE, Build.MODEL, getVersion());
    }

    public static int getApiLevel() {
        return f27073c;
    }

    public static String getBuildTime() {
        return "2025-03-31";
    }

    public static String getUserAgent(Context context) {
        if (f27074d == null) {
            f27074d = getAgent(context);
        }
        return f27074d;
    }

    public static String getVersion() {
        return "8.0.1.309";
    }
}

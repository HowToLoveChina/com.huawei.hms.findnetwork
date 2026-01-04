package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.huawei.openalliance.p169ad.AbstractC7185ho;

/* renamed from: com.huawei.openalliance.ad.utils.bn */
/* loaded from: classes2.dex */
public class C7767bn {
    /* renamed from: a */
    public static Integer m47805a(Context context, String str, String str2) {
        try {
            Object objM47806b = m47806b(context, str, str2);
            if (objM47806b != null) {
                return AbstractC7806cz.m48178h(objM47806b.toString());
            }
            return null;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("MetaDataUtils", "getIntegerMetaData %s err: %s", str2, th2.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: b */
    private static Object m47806b(Context context, String str, String str2) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return null;
            }
            return bundle.get(str2);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("MetaDataUtils", "getMetaData %d err: %s", str2, th2.getClass().getSimpleName());
            return null;
        }
    }
}

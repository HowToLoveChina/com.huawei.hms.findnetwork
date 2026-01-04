package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;

/* renamed from: com.huawei.openalliance.ad.utils.cb */
/* loaded from: classes2.dex */
public class C7782cb {
    /* renamed from: a */
    public static String m47876a(Context context) {
        if (context.getPackageManager() != null) {
            return m47878a(context, Binder.getCallingUid(), Binder.getCallingPid());
        }
        AbstractC7185ho.m43823c("PackageNameUtil", "pm is null");
        return "";
    }

    /* renamed from: a */
    private static String m47877a(Context context, int i10) {
        return null;
    }

    /* renamed from: a */
    public static String m47878a(Context context, int i10, int i11) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return "";
        }
        try {
            String nameForUid = packageManager.getNameForUid(i10);
            if (!TextUtils.isEmpty(nameForUid) && nameForUid.contains(":")) {
                AbstractC7185ho.m43820b("PackageNameUtil", "pkg=" + nameForUid);
                nameForUid = m47877a(context, i11);
            }
            if (!TextUtils.isEmpty(nameForUid)) {
                return nameForUid;
            }
            String[] packagesForUid = packageManager.getPackagesForUid(i10);
            return !AbstractC7760bg.m47769a(packagesForUid) ? packagesForUid[0] : nameForUid;
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("PackageNameUtil", "get name for uid error");
            return "";
        }
    }
}

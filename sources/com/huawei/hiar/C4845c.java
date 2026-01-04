package com.huawei.hiar;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.huawei.openalliance.p169ad.constant.Constants;

/* renamed from: com.huawei.hiar.c */
/* loaded from: classes5.dex */
public class C4845c extends HuaweiArApkBase {

    /* renamed from: a */
    public static final String f22041a = "c";

    /* renamed from: b */
    public static final C4845c f22042b = new C4845c();

    /* renamed from: d */
    public static C4845c m29082d() {
        return f22042b;
    }

    @Override // com.huawei.hiar.HuaweiArApkBase
    /* renamed from: b */
    public boolean mo29081b(Context context) {
        return m29083c(context) >= 55;
    }

    /* renamed from: c */
    public long m29083c(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return -1L;
            }
            long longVersionCode = packageManager.getPackageInfo(Constants.AR_ENGINE_PACKAGE, 0).getLongVersionCode();
            Log.i(f22041a, "getHuaweiArApkVersionNumber version:" + longVersionCode);
            return longVersionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e(f22041a, "getHuaweiArApkVersionNumber NameNotFoundException.");
            return -1L;
        }
    }
}

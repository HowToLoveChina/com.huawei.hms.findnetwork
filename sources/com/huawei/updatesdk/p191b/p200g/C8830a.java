package com.huawei.updatesdk.p191b.p200g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8777a;
import com.huawei.updatesdk.p177a.p186b.p187a.C8793a;
import com.huawei.updatesdk.p191b.p196c.C8811b;

/* renamed from: com.huawei.updatesdk.b.g.a */
/* loaded from: classes9.dex */
public final class C8830a {

    /* renamed from: a */
    private static String f45170a;

    /* renamed from: a */
    public static String m56296a() throws PackageManager.NameNotFoundException {
        String str = f45170a;
        if (str != null) {
            return str;
        }
        Context contextM56133a = C8793a.m56132c().m56133a();
        try {
            StringBuilder sb2 = new StringBuilder("UpdateSDK");
            sb2.append("##");
            sb2.append("5.0.1.300");
            String str2 = Build.BRAND;
            if (TextUtils.isEmpty(str2)) {
                str2 = "other";
            }
            sb2.append("##");
            sb2.append(str2);
            sb2.append("##");
            sb2.append(C8811b.m56233a().m56235e());
            sb2.append("##");
            sb2.append(contextM56133a.getPackageName());
            PackageInfo packageInfo = contextM56133a.getPackageManager().getPackageInfo(contextM56133a.getPackageName(), 0);
            if (packageInfo != null) {
                sb2.append("##");
                sb2.append(packageInfo.versionName);
            }
            String string = sb2.toString();
            f45170a = string;
            return string;
        } catch (Exception e10) {
            C8777a.m56028b("ApplicationSession", "getUserAgent() " + e10.getMessage());
            return null;
        }
    }
}

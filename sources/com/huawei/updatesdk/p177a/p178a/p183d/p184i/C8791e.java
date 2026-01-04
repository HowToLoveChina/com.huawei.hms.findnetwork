package com.huawei.updatesdk.p177a.p178a.p183d.p184i;

import android.text.TextUtils;
import com.huawei.updatesdk.p177a.p178a.C8774a;

/* renamed from: com.huawei.updatesdk.a.a.d.i.e */
/* loaded from: classes9.dex */
public class C8791e {

    /* renamed from: a */
    private static String f45099a = "";

    /* renamed from: a */
    public static boolean m56124a() {
        if ("KidWatch".equals(f45099a)) {
            return true;
        }
        String strM56089a = C8789c.m56089a("ro.vendor.market.type", "");
        f45099a = strM56089a;
        C8774a.m56009b("WearDeviceUtil", "Children watch property value is " + strM56089a);
        if (TextUtils.isEmpty(strM56089a)) {
            return false;
        }
        return "KidWatch".equals(strM56089a);
    }
}

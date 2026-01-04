package com.huawei.hms.support.hwid.common.p146e;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;

/* renamed from: com.huawei.hms.support.hwid.common.e.i */
/* loaded from: classes8.dex */
public class C6479i {

    /* renamed from: a */
    private static Boolean f30074a;

    /* renamed from: a */
    public static boolean m36910a(Context context) {
        if (context == null) {
            C6477g.m36907c("SDKUtil", "context is null", true);
            return false;
        }
        Boolean bool = f30074a;
        if (bool != null && !bool.booleanValue()) {
            C6477g.m36904a("SDKUtil", "isPhoneStillInLockMode is already false", true);
            return false;
        }
        int i10 = Build.VERSION.SDK_INT;
        UserManager userManager = (UserManager) context.getSystemService(UserManager.class);
        if (userManager == null) {
            C6477g.m36907c("SDKUtil", "userManager is null.", true);
            return false;
        }
        if (userManager.isUserUnlocked()) {
            f30074a = Boolean.FALSE;
            C6477g.m36904a("SDKUtil", "isPhoneStillInLockMode false", true);
        } else {
            C6477g.m36907c("SDKUtil", "isPhoneStillInLockMode true", true);
            f30074a = Boolean.TRUE;
        }
        C6477g.m36907c("SDKUtil", "Build.VERSION.SDK_INT : " + i10 + " isPhoneStillInLockMode " + f30074a, true);
        Boolean bool2 = f30074a;
        return bool2 != null && bool2.booleanValue();
    }
}

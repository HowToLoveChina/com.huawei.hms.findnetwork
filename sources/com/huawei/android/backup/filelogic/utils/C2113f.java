package com.huawei.android.backup.filelogic.utils;

import android.content.Context;
import android.os.UserManager;
import com.huawei.android.backup.service.utils.C2157a;
import p229di.C9141f;
import p229di.C9155t;
import p229di.C9156u;

/* renamed from: com.huawei.android.backup.filelogic.utils.f */
/* loaded from: classes.dex */
public class C2113f {
    /* renamed from: a */
    public static boolean m12661a(Context context, int i10) {
        if (context == null || !C2157a.m13177L(context) || i10 == -1) {
            return false;
        }
        try {
            UserManager userManager = (UserManager) context.getSystemService("user");
            if (userManager == null) {
                return false;
            }
            return C9141f.m57461b() ? C9156u.m57501b(C9156u.m57500a(userManager, i10)) : C9156u.m57501b(C9155t.m57498c(userManager, i10));
        } catch (Exception unused) {
            C2111d.m12648d("SubUserUtil", "happen exception when judge privacy user");
            return false;
        }
    }
}

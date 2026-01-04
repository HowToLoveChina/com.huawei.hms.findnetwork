package com.huawei.android.backup.filelogic.utils;

import android.content.Context;
import android.content.pm.PackageManager;

/* renamed from: com.huawei.android.backup.filelogic.utils.b */
/* loaded from: classes.dex */
public class C2109b {

    /* renamed from: a */
    public static Context f9529a = null;

    /* renamed from: b */
    public static String f9530b = "";

    /* renamed from: a */
    public static String m12624a() {
        C2111d.m12653i("FileBackupContext", " getVersion:" + f9530b);
        return f9530b;
    }

    /* renamed from: b */
    public static void m12625b(Context context) {
        if (f9529a == null) {
            f9529a = context;
        }
        if (context != null) {
            try {
                f9530b = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).versionName;
            } catch (PackageManager.NameNotFoundException unused) {
                C2111d.m12648d("FileBackupContext", "Name not found");
            }
        }
    }
}

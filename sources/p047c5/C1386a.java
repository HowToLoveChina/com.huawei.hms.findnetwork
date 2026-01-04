package p047c5;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.android.backup.filelogic.utils.C2111d;

/* renamed from: c5.a */
/* loaded from: classes.dex */
public class C1386a {

    /* renamed from: a */
    @SuppressLint({"StaticFieldLeak"})
    public static Context f5946a = null;

    /* renamed from: b */
    public static String f5947b = "";

    /* renamed from: a */
    public static Context m7941a() {
        return f5946a;
    }

    /* renamed from: b */
    public static void m7942b(Context context) {
        if (f5946a == null) {
            f5946a = context.getApplicationContext();
        }
        try {
            f5947b = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            C2111d.m12648d("BackupServiceContext", "Name not found");
        }
    }
}

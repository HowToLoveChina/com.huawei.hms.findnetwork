package p229di;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.util.ArrayList;
import java.util.List;
import p229di.C9142g;

/* renamed from: di.o */
/* loaded from: classes4.dex */
public class C9150o {
    /* renamed from: a */
    public static ApplicationInfo m57487a(PackageManager packageManager, String str, int i10, int i11) {
        try {
            Class cls = Integer.TYPE;
            return (ApplicationInfo) C9142g.a.m57467b(packageManager, String.class, cls, cls).m57470d("getApplicationInfoAsUser", str, Integer.valueOf(i10), Integer.valueOf(i11)).m57472f();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static PackageInfo m57488b(PackageManager packageManager, String str, int i10, int i11) {
        try {
            Class cls = Integer.TYPE;
            return (PackageInfo) C9142g.a.m57467b(packageManager, String.class, cls, cls).m57470d("getPackageInfoAsUser", str, Integer.valueOf(i10), Integer.valueOf(i11)).m57472f();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    public static boolean m57489c(PackageManager packageManager, String str, int i10) {
        try {
            C9142g.a.m57467b(packageManager, String.class, Integer.TYPE).m57470d("installExistingPackageAsUser", str, Integer.valueOf(i10));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: d */
    public static List<ResolveInfo> m57490d(PackageManager packageManager, Intent intent, int i10, int i11) {
        try {
            Class cls = Integer.TYPE;
            return (List) C9142g.a.m57467b(packageManager, Intent.class, cls, cls).m57470d("queryIntentActivitiesAsUser", intent, Integer.valueOf(i10), Integer.valueOf(i11)).m57472f();
        } catch (Exception unused) {
            return new ArrayList();
        }
    }
}

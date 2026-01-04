package p229di;

import android.app.ActivityManager;
import p229di.C9142g;

/* renamed from: di.k */
/* loaded from: classes4.dex */
public class C9146k {
    /* renamed from: a */
    public static boolean m57480a(ActivityManager activityManager, String str) {
        try {
            C9142g.a.m57467b(activityManager, String.class).m57470d("forceStopPackage", str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m57481b(ActivityManager activityManager, String str, int i10) {
        try {
            C9142g.a.m57467b(activityManager, String.class, Integer.TYPE).m57470d("forceStopPackageAsUser", str, Integer.valueOf(i10));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}

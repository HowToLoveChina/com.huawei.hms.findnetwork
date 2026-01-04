package p229di;

import android.content.pm.PackageInstaller;
import p229di.C9142g;

/* renamed from: di.n */
/* loaded from: classes4.dex */
public class C9149n {
    /* renamed from: a */
    public static boolean m57486a(PackageInstaller.Session session, float f10) {
        try {
            C9142g.a.m57467b(session, Float.TYPE).m57470d("addProgress", Float.valueOf(f10));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}

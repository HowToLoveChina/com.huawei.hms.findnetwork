package p229di;

import android.p018os.IBackupSessionCallback;
import p229di.C9142g;

/* renamed from: di.b */
/* loaded from: classes4.dex */
public class C9137b {

    /* renamed from: a */
    public static final String f45936a;

    static {
        f45936a = C9142g.m57463b() ? "com.hihonor.android.app.PackageManagerEx" : "com.huawei.android.app.PackageManagerEx";
    }

    /* renamed from: a */
    public static int m57449a(int i10, String str) {
        try {
            return ((Integer) C9142g.a.m57468c(f45936a, Integer.TYPE, String.class).m57470d("executeBackupTask", Integer.valueOf(i10), str).m57472f()).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: b */
    public static int m57450b(int i10) {
        try {
            return ((Integer) C9142g.a.m57468c(f45936a, Integer.TYPE).m57470d("finishBackupSession", Integer.valueOf(i10)).m57472f()).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: c */
    public static boolean m57451c(String str) {
        try {
            return ((Boolean) C9142g.a.m57468c(f45936a, String.class).m57470d("hasHwSystemFeature", str).m57472f()).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m57452d() {
        try {
            return C9142g.a.m57468c(f45936a, Integer.TYPE).m57474i("finishBackupSession").m57472f() != null;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: e */
    public static int m57453e(IBackupSessionCallback iBackupSessionCallback) {
        try {
            return ((Integer) C9142g.a.m57468c(f45936a, IBackupSessionCallback.class).m57470d("startBackupSession", iBackupSessionCallback).m57472f()).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }
}

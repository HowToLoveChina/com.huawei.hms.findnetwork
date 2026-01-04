package lc;

import android.content.Context;
import p015ak.C0213f;
import p015ak.C0214f0;
import p514o9.C11839m;

/* renamed from: lc.a */
/* loaded from: classes3.dex */
public class C11267a {

    /* renamed from: a */
    public static Context f52890a;

    /* renamed from: a */
    public static boolean m67617a() {
        f52890a = C0213f.m1377a();
        C11839m.m70688i("ResetMoreDataUtil", "resetMoreData start");
        boolean zM67618b = m67618b();
        C11839m.m70688i("ResetMoreDataUtil", "resetMoreData end");
        return zM67618b;
    }

    /* renamed from: b */
    public static boolean m67618b() {
        boolean zCommit = C0214f0.m1382b(f52890a, "cloudbackupsms", 0).edit().clear().commit();
        boolean zCommit2 = C0214f0.m1382b(f52890a, "cloudbackup", 0).edit().clear().commit();
        if (zCommit && zCommit2) {
            return true;
        }
        C11839m.m70687e("ResetMoreDataUtil", "clear sp Failed clearSms:" + zCommit + ",clearCalllog:" + zCommit2);
        return false;
    }
}

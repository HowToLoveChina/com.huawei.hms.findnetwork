package p430kl;

import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.CloudRestoreTask;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4880b;
import fk.C9721b;
import mk.C11477c;
import p015ak.C0213f;
import p015ak.C0241z;
import p514o9.C11839m;
import p618rm.C12590s0;
import p709vj.C13452e;
import p713vo.C13473a;
import sl.C12811b;
import sl.C12816g;
import tl.C13029h;
import tl.C13030i;
import tl.C13035n;

/* renamed from: kl.a */
/* loaded from: classes6.dex */
public class C11061a {
    /* renamed from: a */
    public static int m66671a() {
        C11839m.m70688i("CloudBackupCoreClient", "command backup result = -1");
        return -1;
    }

    /* renamed from: b */
    public static int m66672b(String str, String str2, int i10, int i11) {
        if (i11 == 1) {
            RestoreProgress.clearCache();
            new C13035n().clear();
        }
        C12590s0.m75749G2();
        int i12 = CBAccess.addTask(new CloudRestoreTask(str, i10, str2, i11, false, false, false)) ? 0 : -1;
        C11839m.m70688i("CloudBackupCoreClient", "command restore result = " + i12);
        return i12;
    }

    /* renamed from: c */
    public static int m66673c(boolean z10, boolean z11, boolean z12) {
        C13029h c13029hM78495f;
        String strM68636f;
        C13030i c13030i = new C13030i();
        try {
            c13029hM78495f = c13030i.m78495f(3);
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupCoreClient", "restoreRetry error " + e10.toString());
            ICBBroadcastManager.sendCancelRestoreBroadcast(C0213f.m1377a());
            C13452e.m80781L().m80890b();
            c13029hM78495f = null;
        }
        if (c13029hM78495f == null) {
            return -1;
        }
        String strM68633c = C11477c.m68633c(c13029hM78495f.m78488y());
        if (strM68633c == null || strM68633c.isEmpty()) {
            try {
                strM68633c = C13473a.m81139b(c13029hM78495f.m78488y(), "cbc_key_common_accountandbackup");
                if (strM68633c != null) {
                    if (strM68633c.isEmpty() || (strM68636f = C11477c.m68636f(strM68633c)) == null || strM68636f.isEmpty()) {
                        return -1;
                    }
                    c13029hM78495f.m78460Z(strM68636f);
                    c13030i.m78496g(c13029hM78495f);
                }
                return -1;
            } catch (C9721b e11) {
                C11839m.m70687e("CloudBackupCoreClient", "decrypt exception: " + e11.toString());
                return -1;
            }
        }
        String str = strM68633c;
        String strM78478s = c13029hM78495f.m78478s();
        if (strM78478s.contains(CloudRestoreTask.REFURBISHMENT_TAG)) {
            strM78478s = strM78478s.replace(CloudRestoreTask.REFURBISHMENT_TAG, "").trim();
        }
        if (strM78478s.contains(CloudRestoreTask.MYHUAWEI_TAG)) {
            strM78478s = strM78478s.replace(CloudRestoreTask.MYHUAWEI_TAG, "").trim();
        }
        boolean zAddTask = CBAccess.addTask(new CloudRestoreTask(str, c13029hM78495f.m78489z(), c13029hM78495f.m78465h(), C0241z.m1685c(strM78478s), z11, z10, z12));
        if (zAddTask) {
            C13452e.m80781L().m80914f3(1);
        }
        return zAddTask ? 0 : -1;
    }

    /* renamed from: d */
    public static int m66674d(boolean z10, boolean z11, boolean z12) {
        C13029h c13029hM78495f;
        boolean z13;
        boolean z14;
        try {
            c13029hM78495f = new C13030i().m78495f(3);
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupCoreClient", "restoreRetry error " + e10.toString());
            ICBBroadcastManager.sendCancelRestoreBroadcast(C0213f.m1377a());
            C13452e.m80781L().m80890b();
            c13029hM78495f = null;
        }
        if (c13029hM78495f != null) {
            String strM75924y0 = C12590s0.m75924y0(c13029hM78495f);
            String strM75928z0 = C12590s0.m75928z0(c13029hM78495f);
            if (strM75924y0.isEmpty()) {
                return -1;
            }
            String strM78478s = c13029hM78495f.m78478s();
            if (strM78478s.contains(CloudRestoreTask.REFURBISHMENT_TAG)) {
                strM78478s = strM78478s.replace(CloudRestoreTask.REFURBISHMENT_TAG, "").trim();
                z13 = true;
            } else {
                z13 = false;
            }
            if (strM78478s.contains("_temp_backup")) {
                strM78478s = strM78478s.replace("_temp_backup", "").trim();
                z14 = true;
            } else {
                z14 = false;
            }
            if (strM78478s.contains(CloudRestoreTask.MYHUAWEI_TAG)) {
                strM78478s = strM78478s.replace(CloudRestoreTask.MYHUAWEI_TAG, "").trim();
            }
            C4880b c4880b = new C4880b(strM75924y0, strM75928z0, c13029hM78495f.m78465h(), C0241z.m1685c(strM78478s), z11, z10, c13029hM78495f.m78480t(), z12);
            c4880b.m29810s0(z13);
            c4880b.m29814w0(z14);
            boolean zAddTask = CBAccess.addTask(c4880b);
            i = zAddTask ? 0 : -1;
            if (zAddTask) {
                C13452e.m80781L().m80914f3(1);
            }
        }
        return i;
    }

    /* renamed from: e */
    public static int m66675e(String str, String str2, String str3, int i10, String str4, String str5) {
        if (i10 == 1) {
            RestoreProgress.clearCache();
            new C12816g().clear();
        }
        C12590s0.m75749G2();
        new C12811b().clear();
        C4880b c4880b = new C4880b(str, str2, str3, i10, false, false, str4, false);
        c4880b.m29804m0(str5);
        int i11 = CBAccess.addTask(c4880b) ? 0 : -1;
        C11839m.m70688i("CloudBackupCoreClient", "command restore result = " + i11);
        return i11;
    }
}

package p261el;

import com.huawei.android.hicloud.agd.ads.RestoreAdAppInfo;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import com.huawei.hicloud.cloudbackup.store.database.tags.CloudRestoreStatus;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p260ek.C9499a;
import p514o9.C11839m;
import p617rl.C12526j;
import p617rl.C12527k;
import sl.C12810a;
import sl.C12811b;
import sl.C12816g;
import tl.C13035n;

/* renamed from: el.a */
/* loaded from: classes6.dex */
public class C9500a {
    /* renamed from: a */
    public static int m59437a(String str, int i10) {
        return C9499a.m59435c(new C12526j().m75351N0("appBackupAGDConfig"), str, i10);
    }

    /* renamed from: b */
    public static C12527k m59438b() {
        return new C12526j().m75407n("appBackupAGDConfig");
    }

    /* renamed from: c */
    public static List<RestoreAdAppInfo> m59439c() {
        List<CloudRestoreStatus> listM78552d;
        C13035n c13035n = new C13035n();
        ArrayList arrayList = new ArrayList();
        try {
            listM78552d = c13035n.m78552d();
        } catch (C9721b e10) {
            C11839m.m70689w("AppUtils", "getRestoreAdAppInfoListV2 query all restore status error: " + e10.getMessage());
            listM78552d = null;
        }
        if (listM78552d == null) {
            return arrayList;
        }
        for (CloudRestoreStatus cloudRestoreStatus : listM78552d) {
            if (cloudRestoreStatus.getStatus() != 8 && cloudRestoreStatus.getAppType() == 3) {
                arrayList.add(new RestoreAdAppInfo(cloudRestoreStatus.getAppName(), cloudRestoreStatus.getAppId(), cloudRestoreStatus.getVersionCode(), cloudRestoreStatus.getVersion()));
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public static List<RestoreAdAppInfo> m59440d() {
        C12810a c12810aM76879d;
        C12816g c12816g = new C12816g();
        C12811b c12811b = new C12811b();
        ArrayList arrayList = new ArrayList();
        for (CloudRestoreStatusV3 cloudRestoreStatusV3 : c12816g.m76946j()) {
            if (cloudRestoreStatusV3.getStatus() != 8 && (c12810aM76879d = c12811b.m76879d(cloudRestoreStatusV3.getAppId(), "apk")) != null && c12810aM76879d.m76854e().equals(String.valueOf(3))) {
                arrayList.add(new RestoreAdAppInfo(cloudRestoreStatusV3.getAppName(), cloudRestoreStatusV3.m29470M(), cloudRestoreStatusV3.getVersionCode(), cloudRestoreStatusV3.m29466K()));
            }
        }
        return arrayList;
    }
}

package p618rm;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.BackupModuleInfo;
import com.huawei.android.hicloud.cloudbackup.bean.BackupModuleList;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.UserSpaceUtil;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import p015ak.C0241z;
import p292fn.C9733f;
import p371ik.C10527a;
import p429kk.C11058a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p684un.C13230i;
import p709vj.C13452e;
import p711vl.C13466f;
import p814yl.C13998b0;
import p815ym.AbstractC14026a;
import tl.C13029h;
import tl.C13030i;
import tl.C13032k;
import tl.C13033l;

/* renamed from: rm.v */
/* loaded from: classes6.dex */
public class C12598v {

    /* renamed from: rm.v$a */
    public class a extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f57992a;

        public a(String str) {
            this.f57992a = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            int iM60763v = C9733f.m60705z().m60763v("disableCacheClearScanLost");
            C11839m.m70688i("CloudBackupStorageUtil", "backup cache clear scan lost switch status is:" + iM60763v);
            boolean z10 = true;
            if (iM60763v != 1) {
                String strM81079g = C13466f.m81073d().m81079g(CloudBackupConstant.BACKUP_DEVICE_ID, "");
                if (TextUtils.isEmpty(strM81079g) || !C12598v.m76040h()) {
                    C11839m.m70689w("CloudBackupStorageUtil", "backupDeviceId empty or no expired modules.");
                    z10 = false;
                } else {
                    String strM66627b = C11058a.m66627b("02027");
                    C13998b0 c13998b0 = new C13998b0();
                    C11839m.m70688i("CloudBackupStorageUtil", "begin to call scanLost.");
                    c13998b0.m84119P0(strM66627b, strM81079g, "dirtyClear");
                }
            } else {
                z10 = false;
            }
            C12598v.m76044l(this.f57992a, z10);
            C12598v.m76035c();
        }
    }

    /* renamed from: c */
    public static void m76035c() {
        Optional.ofNullable(m76038f()).ifPresent(new Consumer() { // from class: rm.u
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C12598v.m76042j((BackupModuleList) obj);
            }
        });
    }

    /* renamed from: d */
    public static void m76036d(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("CloudBackupStorageUtil", "saveTimeExpiredModule error,appId is empty.");
            return;
        }
        String strM81079g = C13466f.m81073d().m81079g(CloudBackupConstant.TIME_EXPIRED_MODULES_INFO, null);
        if (strM81079g == null) {
            C11839m.m70686d("CloudBackupStorageUtil", "savedTimeExpiredModule empty,no need to delete.");
            return;
        }
        BackupModuleList backupModuleList = (BackupModuleList) C10527a.m64629g(strM81079g, BackupModuleList.class);
        if (backupModuleList == null) {
            C11839m.m70686d("CloudBackupStorageUtil", "parse json from SP error,result is null");
            return;
        }
        List<BackupModuleInfo> backupModuleList2 = backupModuleList.getBackupModuleList();
        if (AbstractC14026a.m84159a(backupModuleList2)) {
            return;
        }
        Iterator<BackupModuleInfo> it = backupModuleList2.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().getAppId())) {
                it.remove();
                C11839m.m70688i("CloudBackupStorageUtil", "deleteTimeExpiredModuleInSp,appId is:" + str);
            }
        }
        if (AbstractC14026a.m84159a(backupModuleList2)) {
            backupModuleList.setBackupId("");
        }
        C11839m.m70688i("CloudBackupStorageUtil", "after delete,reset module size:" + backupModuleList2.size() + ",list is:" + backupModuleList2);
        C13466f.m81073d().m81084l(CloudBackupConstant.TIME_EXPIRED_MODULES_INFO, C10527a.m64633k(backupModuleList));
    }

    /* renamed from: e */
    public static void m76037e(String str, String str2, BackupModuleList backupModuleList) {
        backupModuleList.setBackupId(str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BackupModuleInfo(str2));
        backupModuleList.setBackupModuleList(arrayList);
        C13466f.m81073d().m81084l(CloudBackupConstant.TIME_EXPIRED_MODULES_INFO, C10527a.m64633k(backupModuleList));
    }

    /* renamed from: f */
    public static BackupModuleList m76038f() {
        String strM81079g = C13466f.m81073d().m81079g(CloudBackupConstant.TIME_EXPIRED_MODULES_INFO, null);
        if (strM81079g != null) {
            return (BackupModuleList) C10527a.m64629g(strM81079g, BackupModuleList.class);
        }
        C11839m.m70686d("CloudBackupStorageUtil", "getSavedModuleList:savedTimeExpiredModule empty");
        return null;
    }

    /* renamed from: g */
    public static void m76039g(String str) {
        C12515a.m75110o().m75172d(new a(str));
    }

    /* renamed from: h */
    public static boolean m76040h() {
        BackupModuleList backupModuleListM76038f = m76038f();
        if (backupModuleListM76038f == null) {
            C11839m.m70688i("CloudBackupStorageUtil", "saved timeExpired modules is null,no need to report");
            return false;
        }
        if (!AbstractC14026a.m84159a(backupModuleListM76038f.getBackupModuleList())) {
            return true;
        }
        C11839m.m70688i("CloudBackupStorageUtil", "There's no expired modules in sp.");
        return false;
    }

    /* renamed from: i */
    public static boolean m76041i() {
        C11839m.m70688i("CloudBackupStorageUtil", "isSpaceEnoughAfterPay begin");
        C13033l c13033l = new C13033l();
        C13032k c13032kM78546d = c13033l.m78546d(1);
        if (c13032kM78546d != null && c13032kM78546d.m78530n() == 3001) {
            C11839m.m70688i("CloudBackupStorageUtil", "last backup failed for no space");
            try {
                long availableSpace = UserSpaceUtil.getAvailableSpace();
                C13030i c13030i = new C13030i();
                C13029h c13029hM78495f = c13030i.m78495f(1);
                if (c13029hM78495f == null) {
                    c13029hM78495f = c13030i.m78495f(2);
                }
                if (c13029hM78495f != null) {
                    long jM78445K = c13029hM78495f.m78445K();
                    String strM78482u = c13029hM78495f.m78482u();
                    long jM1688f = C0241z.m1688f(strM78482u);
                    long j10 = availableSpace - jM1688f;
                    C11839m.m70688i("CloudBackupStorageUtil", "checkSpaceEnough availableSpace = " + availableSpace + " usedSpace = " + jM78445K + " backupSize = " + jM1688f + " remainSpace = " + j10 + " data3 = " + strM78482u);
                    if (j10 > 0) {
                        c13032kM78546d.m78512I(1001);
                        c13033l.m78547e(c13032kM78546d);
                    }
                    return j10 > 0;
                }
            } catch (C9721b e10) {
                C11839m.m70687e("CloudBackupStorageUtil", "get cloud space error:" + e10.getMessage());
            }
        }
        return false;
    }

    /* renamed from: j */
    public static /* synthetic */ void m76042j(BackupModuleList backupModuleList) {
        C11839m.m70688i("CloudBackupStorageUtil", "clearTimeExpiredModulesInSp");
        C13466f.m81073d().m81084l(CloudBackupConstant.TIME_EXPIRED_MODULES_INFO, null);
    }

    /* renamed from: k */
    public static boolean m76043k(C4879a c4879a) {
        if (c4879a == null) {
            C11839m.m70689w("CloudBackupStorageUtil", "client is null");
            return true;
        }
        if (c4879a.isRefurbishment()) {
            C11839m.m70688i("CloudBackupStorageUtil", "refurbish backup skip space check.");
            return true;
        }
        if (c4879a.m29738q1()) {
            C11839m.m70688i("CloudBackupStorageUtil", "no need to spacePreCheck:spaceByPass by server.");
            return true;
        }
        if (c4879a.mo29591n() && Objects.equals(c4879a.m29636F0(), 0)) {
            C11839m.m70688i("CloudBackupStorageUtil", "temp backup free space");
            return true;
        }
        if (c4879a.isAutoBackup() || !c4879a.m29711h1() || !c4879a.m29740r0()) {
            return false;
        }
        C11839m.m70688i("CloudBackupStorageUtil", "manual backup byPass on Fault:true");
        return true;
    }

    /* renamed from: l */
    public static void m76044l(String str, boolean z10) {
        BackupModuleList backupModuleListM76038f = m76038f();
        if (backupModuleListM76038f == null) {
            C11839m.m70688i("CloudBackupStorageUtil", "saved timeExpired modules is null,no need to report");
            return;
        }
        List<BackupModuleInfo> backupModuleList = backupModuleListM76038f.getBackupModuleList();
        if (AbstractC14026a.m84159a(backupModuleList)) {
            C11839m.m70688i("CloudBackupStorageUtil", "There's no expired modules in sp.");
            return;
        }
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("reportType", str);
        String backupId = backupModuleListM76038f.getBackupId();
        linkedHashMapM79497A.put("backupId", backupId);
        linkedHashMapM79497A.put("timeExpiredModules", backupModuleList.toString());
        linkedHashMapM79497A.put("isExecuteScanLost", String.valueOf(z10));
        C11839m.m70688i("CloudBackupStorageUtil", "begin to report timeExpired modules,type is:" + str + ",backupId:" + backupId + ",timeExpiredModules:" + backupModuleList.toString());
        UBAAnalyze.m29947H("CKC", "action_unfinished_time_expired_modules", linkedHashMapM79497A);
    }

    /* renamed from: m */
    public static void m76045m(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            C11839m.m70687e("CloudBackupStorageUtil", "saveTimeExpiredModule error,appId is empty.");
            return;
        }
        C11839m.m70686d("CloudBackupStorageUtil", "saveTimeExpiredModule,backupId:" + str + ",appId:" + str2);
        String strM81079g = C13466f.m81073d().m81079g(CloudBackupConstant.TIME_EXPIRED_MODULES_INFO, null);
        BackupModuleList backupModuleList = new BackupModuleList();
        if (strM81079g == null) {
            m76037e(str, str2, backupModuleList);
            return;
        }
        BackupModuleList backupModuleList2 = (BackupModuleList) C10527a.m64629g(strM81079g, BackupModuleList.class);
        if (backupModuleList2 == null || backupModuleList2.getBackupModuleList() == null) {
            m76037e(str, str2, backupModuleList2);
            return;
        }
        backupModuleList2.setBackupId(str);
        List<BackupModuleInfo> backupModuleList3 = backupModuleList2.getBackupModuleList();
        BackupModuleInfo backupModuleInfo = new BackupModuleInfo(str2);
        if (!backupModuleList3.contains(backupModuleInfo)) {
            backupModuleList3.add(backupModuleInfo);
        }
        C13466f.m81073d().m81084l(CloudBackupConstant.TIME_EXPIRED_MODULES_INFO, C10527a.m64633k(backupModuleList2));
    }
}

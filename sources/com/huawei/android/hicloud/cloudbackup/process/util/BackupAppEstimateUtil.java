package com.huawei.android.hicloud.cloudbackup.process.util;

import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.util.BackupNewBmTypeUtil;
import com.huawei.android.hicloud.cloudbackup.util.TransferedUtil;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import gp.C10028c;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0240y;
import p336he.C10155f;
import p459lp.C11333k;
import p514o9.C11839m;
import p617rl.C12526j;
import tl.C13026e;

/* loaded from: classes2.dex */
public class BackupAppEstimateUtil {
    private static final int DEFAULT = -1;
    private static final long ONE_HOUR_MILLIS = 3600000;
    private static final String TAG = "BackupAppEstimateUtil";

    public static long getThirdAppDataSize(String str) {
        BackupOptionItem backupOptionItemQueryMergeTwinItem;
        if (C0240y.m1682d(C0213f.m1377a(), str) && (backupOptionItemQueryMergeTwinItem = TransferedUtil.queryMergeTwinItem(str, false)) != null) {
            return backupOptionItemQueryMergeTwinItem.getTotalIncrease();
        }
        return -1L;
    }

    public static boolean isShow() {
        boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
        boolean zM1166E1 = C0209d.m1166E1();
        boolean zM63301y = C10155f.m63301y();
        boolean zM62413x = C10028c.m62182c0().m62413x();
        boolean zM75390f1 = new C12526j().m75390f1(4);
        List<BackupOptionItem> listM78397u = new C13026e().m78397u();
        boolean z10 = listM78397u != null && listM78397u.size() > 0;
        C11839m.m70688i(TAG, "isShow isSwitchOpen " + zM62388s + " isOwnerUser " + zM1166E1 + " isShowCloudBackupItemView " + zM63301y + " cloudSpaceFunctionItemSwitch " + zM62413x + " isSwitchRecommend  isHaveData" + z10);
        return zM62388s && zM1166E1 && zM63301y && zM62413x && zM75390f1 && z10;
    }

    public static boolean isSpaceEnoughForBackup(long j10, long j11, long j12, long j13) {
        if (j10 <= 0) {
            return false;
        }
        if (BackupNewBmTypeUtil.isNewBmUserBackupOnlyBaseData()) {
            return true;
        }
        long j14 = (j10 - j12) - j13;
        C11839m.m70688i(TAG, "checkSize " + j13 + " getAvailable " + j10 + " spaceAvailableSize " + j14 + " totalSize " + j11 + " increase " + j12);
        return j14 > 0;
    }

    public static boolean isSpaceRunningOut(long j10, long j11, long j12, long j13) {
        if (j10 <= 0) {
            return false;
        }
        long j14 = (j10 - j12) - j13;
        boolean zM75390f1 = new C12526j().m75390f1(2);
        int iM68088c = C11333k.m68086b().m68088c(j14);
        C11839m.m70688i(TAG, "checkSize " + j13 + " getAvailable " + j10 + "  spaceAvailableSize " + j14 + " totalSize " + j11 + " increase " + j12 + " isShow " + zM75390f1 + "storageStatus " + iM68088c);
        return iM68088c == 1 && zM75390f1;
    }

    public static boolean isSwitch3rdApp() {
        return new C12526j().m75353O0();
    }

    public static boolean isValid() {
        return System.currentTimeMillis() - new SettingOperator().queryThirdAppInitTime() <= ((long) new C12526j().m75393h().getCacheExpires()) * 3600000;
    }
}

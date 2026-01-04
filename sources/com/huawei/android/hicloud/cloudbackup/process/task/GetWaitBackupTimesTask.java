package com.huawei.android.hicloud.cloudbackup.process.task;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.operator.SnapshotBackupMetaOperator;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.request.cbs.bean.CBSbkFlowHead;
import fk.C9721b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p015ak.C0213f;
import p015ak.C0214f0;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p617rl.C12526j;
import p618rm.C12590s0;
import p762x4.C13694a;
import sl.C12815f;
import tl.C13026e;
import tl.C13027f;
import tl.C13029h;
import tl.C13030i;

/* loaded from: classes2.dex */
public class GetWaitBackupTimesTask extends AbstractC12367d {
    private static final String TAG = "GetWaitBackupTimesTask";

    private static long getApkSize(Map<String, Boolean> map) throws PackageManager.NameNotFoundException {
        Context contextM1377a = C0213f.m1377a();
        Set<String> stringSet = C0214f0.m1382b(contextM1377a, "backup_clone_app_sp", 0).getStringSet("backup_clone_third_app_list", null);
        long j10 = 0;
        if (stringSet != null) {
            for (String str : stringSet) {
                if (map == null || map.get(str) == null || map.get(str).booleanValue()) {
                    long jM82323a = C13694a.m82323a(contextM1377a, str);
                    C11839m.m70686d(TAG, "getApkSize " + str + " ,apk size: " + jM82323a);
                    j10 += jM82323a;
                }
            }
        }
        return j10;
    }

    private static Map<String, Boolean> getEnableModuleFromDb(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70689w(TAG, "getEnableModuleFromDb backupId is null");
            return null;
        }
        HashMap map = new HashMap();
        long jM75406m0 = 0;
        try {
            C13029h c13029hM75882n2 = C12590s0.m75882n2();
            jM75406m0 = new C12526j().m75406m0(c13029hM75882n2 != null && c13029hM75882n2.m78442H() == 2);
            for (SnapshotBackupMeta snapshotBackupMeta : new SnapshotBackupMetaOperator(str).queryAllRootNodeMetas()) {
                map.put(snapshotBackupMeta.getAppId(), Boolean.valueOf(ICBUtil.isNeedUpload(snapshotBackupMeta, jM75406m0)));
            }
            return map;
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "getEnableModuleFromDb snapshot error: " + e10.getMessage());
            String str2 = CBSbkFlowHead.BKMODE_MANUAL;
            try {
                try {
                    if (new C13030i().m78495f(4) != null) {
                        str2 = "Refurbishment";
                    }
                } catch (C9721b e11) {
                    C11839m.m70686d(TAG, "get backupAction error, " + e11.getMessage());
                }
                List<CloudBackupStatus> listM76931j = new C12815f(str2).m76931j();
                if (listM76931j.isEmpty()) {
                    return null;
                }
                for (CloudBackupStatus cloudBackupStatus : listM76931j) {
                    map.put(cloudBackupStatus.m29870d(), Boolean.valueOf(ICBUtil.isNeedUploadV3(cloudBackupStatus, jM75406m0)));
                }
                return map;
            } catch (C9721b e12) {
                C11839m.m70689w(TAG, "getEnableModuleFromDb error: " + e12.getMessage());
                return null;
            }
        }
    }

    private static long getWaitBackupModuleSize(String str) {
        GetOptionsInfoFromCloneTask.checkCacheInvalid();
        List<BackupOptionItem> listM78397u = new C13026e().m78397u();
        if (listM78397u == null || listM78397u.isEmpty()) {
            C11839m.m70689w(TAG, "getWaitBackupModuleSize itemList empty");
            return 0L;
        }
        Map<String, Boolean> enableModuleFromDb = getEnableModuleFromDb(str);
        long j10 = 0;
        for (BackupOptionItem backupOptionItem : listM78397u) {
            String appId = backupOptionItem.getAppId();
            if (!backupOptionItem.getBackupSwitch()) {
                C11839m.m70686d(TAG, "module " + appId + " is closed");
            } else if (enableModuleFromDb == null || enableModuleFromDb.get(appId) == null || enableModuleFromDb.get(appId).booleanValue()) {
                long totalIncrease = backupOptionItem.getTotalIncrease() > 0 ? backupOptionItem.getTotalIncrease() : backupOptionItem.getDataBytes();
                j10 += totalIncrease;
                C11839m.m70686d(TAG, "getWaitBackupModuleSize appId: " + backupOptionItem.getAppId() + " ,size: " + totalIncrease);
            } else {
                C11839m.m70686d(TAG, "module " + appId + " is uploaded");
            }
        }
        return j10 + getApkSize(enableModuleFromDb);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C11839m.m70688i(TAG, "GetWaitBackupTimesTask start");
        String strM78465h = null;
        try {
            C13030i c13030i = new C13030i();
            C13029h c13029hM78495f = c13030i.m78495f(2);
            if (c13029hM78495f == null) {
                c13029hM78495f = c13030i.m78495f(1);
            }
            if (c13029hM78495f != null && !"empty_default_id".equals(c13029hM78495f.m78465h()) && c13029hM78495f.m78441G() != 4) {
                strM78465h = c13029hM78495f.m78465h();
            }
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "GetWaitBackupTimesTask no backuprecord: " + e10.getMessage());
        }
        long waitBackupModuleSize = getWaitBackupModuleSize(strM78465h);
        long jM78409g = new C13027f().m78409g();
        if (jM78409g <= 0) {
            jM78409g = 2097;
        }
        C11839m.m70688i(TAG, "waitBackupModuleSize waitBackupModuleSize: " + waitBackupModuleSize + " ,validSpeed: " + jM78409g);
        long j10 = waitBackupModuleSize / jM78409g;
        int i10 = (j10 <= 0 || j10 >= 60000) ? (int) (j10 / 60000) : 1;
        C11839m.m70688i(TAG, "GetWaitBackupTimesTask end mintue: " + i10);
        Message messageObtain = Message.obtain();
        messageObtain.arg1 = i10;
        messageObtain.what = 3213;
        CBCallBack.getInstance().sendMessage(messageObtain);
    }
}

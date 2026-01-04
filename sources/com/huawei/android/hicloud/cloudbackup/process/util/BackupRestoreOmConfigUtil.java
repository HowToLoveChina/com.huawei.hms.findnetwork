package com.huawei.android.hicloud.cloudbackup.process.util;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.AppInfoList;
import com.huawei.android.hicloud.cloudbackup.bean.AppVer;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackup;
import com.huawei.android.hicloud.cloudbackup.bean.EmuiVersConflict;
import com.huawei.android.hicloud.cloudbackup.bean.RestoreConfig;
import com.huawei.android.hicloud.cloudbackup.bean.RestoreExclude;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.BackupRecordMeta;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.operator.SnapshotBackupMetaOperator;
import com.huawei.hicloud.request.cbs.bean.CBSBaseReq;
import fk.C9721b;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import p015ak.C0209d;
import p015ak.C0241z;
import p514o9.C11839m;
import p617rl.C12519c;
import p617rl.C12520d;
import p709vj.C13452e;
import tl.C13030i;

/* loaded from: classes2.dex */
public class BackupRestoreOmConfigUtil {
    private static final String TAG = "BackupRestoreOmConfigUtil";
    private String backupEmuiVersion;
    private String mBackupId;
    private C12520d restoreConfigOperator = new C12520d();
    private C12519c appInfoListOperator = new C12519c();
    private List<RestoreConfig> restoreConfigList = this.restoreConfigOperator.m75310c();
    private String mCurrentDeviceId = C13452e.m80781L().m80950o();

    public BackupRestoreOmConfigUtil(String str) {
        this.mBackupId = str;
    }

    private boolean checkEmuiVersConflictList(List<EmuiVersConflict> list) {
        return list == null || list.isEmpty();
    }

    private String getBackupEmuiVersion() throws C9721b {
        if (CBSBaseReq.CURRENT_API_VERSION.equalsIgnoreCase(new C13030i().m78495f(3).m78480t())) {
            C11839m.m70688i(TAG, "backupEmuiVersion is " + this.backupEmuiVersion);
            if (TextUtils.isEmpty(this.backupEmuiVersion)) {
                return null;
            }
            return this.backupEmuiVersion;
        }
        BackupRecordMeta backupRecordMetaQueryLastBackupRecordMeta = new SnapshotBackupMetaOperator(this.mBackupId).queryLastBackupRecordMeta();
        if (backupRecordMetaQueryLastBackupRecordMeta == null) {
            return null;
        }
        String emuiVersion = backupRecordMetaQueryLastBackupRecordMeta.getEmuiVersion();
        C11839m.m70688i(TAG, "emuiVersion is " + emuiVersion);
        return emuiVersion;
    }

    private boolean getEmuiVersionResult(String str, String str2, String str3) throws C9721b {
        String backupEmuiVersion = getBackupEmuiVersion();
        return !TextUtils.isEmpty(backupEmuiVersion) && backupEmuiVersion.startsWith(str) && str3.startsWith(str2);
    }

    private boolean getMatchBackupEmuiReg(String str) throws C9721b {
        String backupEmuiVersion = getBackupEmuiVersion();
        if (!TextUtils.isEmpty(backupEmuiVersion)) {
            return backupEmuiVersion.startsWith(str);
        }
        C11839m.m70688i(TAG, "backEmuiVersion is null");
        return false;
    }

    private boolean matchAppVersRegex(int i10, List<String> list) {
        if (list == null || list.isEmpty()) {
            C11839m.m70688i(TAG, " versionCode is not filtered.");
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (matchVer(String.valueOf(i10), it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean matchAppVersion(int i10, List<AppVer> list, List<String> list2) {
        if (i10 >= 0 && list != null && !list.isEmpty()) {
            for (AppVer appVer : list) {
                if (appVer != null) {
                    String min = appVer.getMin();
                    String max = appVer.getMax();
                    if (TextUtils.isEmpty(min) && TextUtils.isEmpty(max)) {
                        if (matchAppVersRegex(i10, list2)) {
                            return true;
                        }
                    } else if (!TextUtils.isEmpty(min) && TextUtils.isEmpty(max)) {
                        if (i10 >= C0241z.m1685c(min)) {
                            return true;
                        }
                    } else if (!TextUtils.isEmpty(min) || TextUtils.isEmpty(max)) {
                        if (TextUtils.isEmpty(min) || TextUtils.isEmpty(max)) {
                            return true;
                        }
                        if (C0241z.m1685c(min) <= i10 && i10 <= C0241z.m1685c(max)) {
                            return true;
                        }
                    } else if (i10 <= C0241z.m1685c(max)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean matchEmuiVer(RestoreExclude restoreExclude) {
        boolean emuiVersionResult;
        List<EmuiVersConflict> emuiVersConflict = restoreExclude.getEmuiVersConflict();
        if (checkEmuiVersConflictList(emuiVersConflict)) {
            C11839m.m70686d(TAG, "matchEmuiVer emuiVersConflictList is null");
            return false;
        }
        try {
            String strM1186L = C0209d.m1186L();
            for (EmuiVersConflict emuiVersConflict2 : emuiVersConflict) {
                String backEmuiReg = emuiVersConflict2.getBackEmuiReg();
                String restoreEmuiReg = emuiVersConflict2.getRestoreEmuiReg();
                if (TextUtils.isEmpty(strM1186L)) {
                    C11839m.m70686d(TAG, "get emuiVersion is null");
                    return false;
                }
                C11839m.m70686d(TAG, "backEmuiReg: " + backEmuiReg + "  restoreEmuiReg  " + restoreEmuiReg + "emuiVersion " + strM1186L);
                if (!TextUtils.isEmpty(backEmuiReg) || !TextUtils.isEmpty(restoreEmuiReg)) {
                    if (TextUtils.isEmpty(backEmuiReg) && !TextUtils.isEmpty(restoreEmuiReg)) {
                        emuiVersionResult = strM1186L.startsWith(restoreEmuiReg);
                    } else if (!TextUtils.isEmpty(backEmuiReg) && TextUtils.isEmpty(restoreEmuiReg)) {
                        emuiVersionResult = getMatchBackupEmuiReg(backEmuiReg);
                    } else if (!TextUtils.isEmpty(backEmuiReg) && !TextUtils.isEmpty(restoreEmuiReg)) {
                        emuiVersionResult = getEmuiVersionResult(backEmuiReg, restoreEmuiReg, strM1186L);
                    }
                    if (emuiVersionResult) {
                        return true;
                    }
                }
            }
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "matchEmuiVer error: " + e10.getMessage());
        }
        return false;
    }

    private boolean matchRestoreTermTypes(RestoreExclude restoreExclude) {
        List<String> termTypes = restoreExclude.getTermTypes();
        if (termTypes.isEmpty()) {
            return false;
        }
        String str = Build.MODEL;
        C11839m.m70688i(TAG, "currentDeviceType is " + str);
        Iterator<String> it = termTypes.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next().replaceAll("\\*", ""))) {
                return true;
            }
        }
        return false;
    }

    private boolean matchVer(String str, String str2) {
        return Pattern.matches(str2, str);
    }

    public boolean isMatchDevCompatible(String str, String str2) {
        CloudBackup cloudBackup;
        List<AppInfoList> listM75300k = this.appInfoListOperator.m75300k(str2);
        if (listM75300k.isEmpty()) {
            return false;
        }
        Iterator<AppInfoList> it = listM75300k.iterator();
        while (it.hasNext() && (cloudBackup = it.next().getCloudBackup()) != null) {
            if (cloudBackup.getDevCompatible() == 0 && !this.mCurrentDeviceId.equals(str)) {
                C11839m.m70686d(TAG, "isMatchDevCompatible filter appId: " + str2);
                return true;
            }
        }
        return false;
    }

    public boolean isMatchRestoreConfig(String str, int i10) {
        List<RestoreConfig> list = this.restoreConfigList;
        if (list != null && !list.isEmpty()) {
            if (C0209d.m1269j1()) {
                C11839m.m70688i(TAG, "current device is hornor product, return isMatchRestoreConfig false.");
                return false;
            }
            for (RestoreConfig restoreConfig : this.restoreConfigList) {
                if (restoreConfig.getAppId().equals(str)) {
                    boolean zMatchAppVersion = matchAppVersion(i10, restoreConfig.getAppVer(), restoreConfig.getAppVersRegex());
                    C11839m.m70686d(TAG, "isMatchRestoreConfig appVersionCode result: " + zMatchAppVersion);
                    if (zMatchAppVersion) {
                        List<RestoreExclude> exclude = restoreConfig.getExclude();
                        if (exclude.isEmpty()) {
                            continue;
                        } else {
                            for (RestoreExclude restoreExclude : exclude) {
                                boolean zMatchEmuiVer = matchEmuiVer(restoreExclude);
                                boolean zMatchRestoreTermTypes = matchRestoreTermTypes(restoreExclude);
                                C11839m.m70688i(TAG, "isMatchRestoreConfig restoreEmuiVer = " + zMatchEmuiVer + ", restoreTermType = " + zMatchRestoreTermTypes);
                                if (zMatchEmuiVer || zMatchRestoreTermTypes) {
                                    return true;
                                }
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return false;
    }

    public BackupRestoreOmConfigUtil(String str, String str2) {
        this.mBackupId = str;
        this.backupEmuiVersion = str2;
    }
}

package com.huawei.android.hicloud.cloudbackup.restore;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.model.RestoreCache;
import com.huawei.android.hicloud.cloudbackup.p076db.bean.Settings;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreOmConfigUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.QueryOneModuleRestoreMetas;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.restore.CloudRestoreClient;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeManagementService;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.p088ui.notification.RestoreNotification;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.feedback.mail.zip.p099sp.SharedPreferencesStorage;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.hicloud.cloudbackup.model.RestoreStatus;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import com.huawei.hicloud.cloudbackup.store.database.tags.CloudRestoreStatus;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.request.cbs.bean.CBSAppInfo;
import com.huawei.hicloud.request.cbs.bean.CBSFileInfo;
import fk.C9721b;
import gp.C10028c;
import hk.C10278a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0221j;
import p015ak.C0241z;
import p514o9.C11839m;
import p618rm.C12565k;
import p618rm.C12590s0;
import p709vj.C13452e;
import p815ym.AbstractC14026a;
import p848zl.C14333b;
import pl.C12168j;
import pl.C12169k;
import sl.C12816g;
import tl.C13035n;

/* loaded from: classes2.dex */
public class CloudRestoreClient {
    private static final String TAG = "CloudRestoreClient";

    private void apkExtend(CloudRestoreStatus cloudRestoreStatus) throws C9721b {
        if (!cloudRestoreStatus.is3rdAppType() || cloudRestoreStatus.m29539i().isEmpty()) {
            return;
        }
        try {
            String strM29539i = cloudRestoreStatus.m29539i();
            String str = File.separator;
            String strSubstring = strM29539i.substring(0, strM29539i.lastIndexOf(str));
            int iM1685c = C0241z.m1685c(strSubstring.substring(strSubstring.lastIndexOf(str) + 1));
            String strSubstring2 = strM29539i.substring(strM29539i.lastIndexOf(str) + 1);
            cloudRestoreStatus.m29525M0(iM1685c).m29534U(strSubstring2.substring(strSubstring2.lastIndexOf(95) + 1));
            if (cloudRestoreStatus.m29522L().isEmpty()) {
                return;
            }
            String strM29522L = cloudRestoreStatus.m29522L();
            String strSubstring3 = strM29522L.substring(strM29522L.lastIndexOf(str) + 1);
            cloudRestoreStatus.m29513D0(strSubstring3.substring(strSubstring3.lastIndexOf(95) + 1));
        } catch (Exception e10) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "create status error." + e10.getMessage(), "createStatus");
        }
    }

    private void appExtend(CloudRestoreStatus cloudRestoreStatus, Map<String, String> map) {
        cloudRestoreStatus.setAppName(value(map, SnapshotBackupMeta.KEY_STRING_APP_NAME)).m29527N0(value(map, SnapshotBackupMeta.KEY_STRING_APP_VERSION)).m29525M0(C0241z.m1685c(value(map, SnapshotBackupMeta.KEY_STRING_APP_VERSION_CODE))).setAsize(C0241z.m1685c(value(map, SnapshotBackupMeta.KEY_STRING_APP_SIZE))).setCount(C0241z.m1685c(value(map, "count"))).m29554z0(value(map, SnapshotBackupMeta.KEY_STRING_APP_EXTEND)).m29552x0(value(map, SnapshotBackupMeta.KEY_SHOW_TYPE));
        if (cloudRestoreStatus.is3rdAppType()) {
            int iM1685c = C0241z.m1685c(value(map, SnapshotBackupMeta.KEY_FLAG_WITH_APP_DATA));
            if (iM1685c == 2) {
                cloudRestoreStatus.setAppType(0);
                cloudRestoreStatus.m29554z0(String.valueOf(1));
            } else {
                cloudRestoreStatus.m29510A0(String.valueOf(iM1685c));
                boolean zM12611e = PmsCheckUtil.m12611e();
                if (iM1685c != 1 || !zM12611e || cloudRestoreStatus.getAction() == 1) {
                    cloudRestoreStatus.setAction(1);
                    cloudRestoreStatus.m29510A0(String.valueOf(0));
                }
            }
            HashMap map2 = new HashMap();
            String str = "com.huawei.appmarket";
            if (map.containsKey(CloudBackupConstant.ReportAppMarket.KEY_SUB_SOURCE)) {
                String strValue = value(map, CloudBackupConstant.ReportAppMarket.KEY_SUB_SOURCE);
                if (("com.huawei.hidisk".equals(strValue) || "null".equals(strValue)) && cloudRestoreStatus.getAppType() == 3) {
                    C11839m.m70688i(TAG, "subsource is hidisk and app is standed");
                } else {
                    str = strValue;
                }
            } else if (cloudRestoreStatus.getAppType() != 3) {
                str = "";
            }
            String strValue2 = value(map, CloudBackupConstant.ReportAppMarket.KEY_PKG_CHANNEL_ID);
            map2.put(CloudBackupConstant.ReportAppMarket.KEY_SUB_SOURCE, str);
            map2.put(CloudBackupConstant.ReportAppMarket.KEY_PKG_CHANNEL_ID, strValue2);
            cloudRestoreStatus.m29511B0(new Gson().toJson(map2));
        } else {
            if (cloudRestoreStatus.getVersionCode() == 0) {
                cloudRestoreStatus.m29525M0(C0241z.m1685c(value(map, "backupApkVersion")));
            }
            C11839m.m70688i(TAG, "appId: " + cloudRestoreStatus.getAppId() + ", current: " + C12590s0.m75790R(cloudRestoreStatus.getAppId()) + ", backup: " + cloudRestoreStatus.getVersionCode());
        }
        if (isEncrypt()) {
            cloudRestoreStatus.m29547t0(value(map, SnapshotBackupMeta.KEY_STRING_APP_SLICE_PATH));
        }
    }

    private int appType(String str, CBSAppInfo cBSAppInfo, int i10) {
        if (i10 == 1) {
            return 3;
        }
        if (i10 == 2) {
            return 4;
        }
        if (C14333b.m85486u().containsKey(str)) {
            return C14333b.m85482q().contains(str) ? -1 : 0;
        }
        int apkType = cBSAppInfo.getApkType();
        if (apkType <= 0) {
            return 3;
        }
        return apkType;
    }

    private void checkLauncherStatus(List<CloudRestoreStatus> list, CloudRestoreStatus cloudRestoreStatus, int i10, int i11) throws C9721b {
        if (cloudRestoreStatus == null) {
            return;
        }
        int type = cloudRestoreStatus.getType();
        if (cloudRestoreStatus.getStatus() != 8 || type != 1) {
            cloudRestoreStatus.setStatus(0).setType(0).setCurrent(0);
            list.add(cloudRestoreStatus);
            new C12169k().m73216s("HWlanucher", 0);
        } else {
            if (i11 <= 0 || i10 != 0) {
                return;
            }
            cloudRestoreStatus.setStatus(0).setType(0).setCurrent(0);
            list.add(cloudRestoreStatus);
            new C12169k().m73216s("HWlanucher", 0);
        }
    }

    private void correctSize(CloudRestoreStatus cloudRestoreStatus) {
        int appType = cloudRestoreStatus.getAppType();
        if (cloudRestoreStatus.is3rdAppType() && appType != 3) {
            long size = cloudRestoreStatus.getSize() - cloudRestoreStatus.getAsize();
            if (size >= 0) {
                cloudRestoreStatus.setSize(size);
                return;
            }
            C11839m.m70689w(TAG, "correctSize is error = " + size);
        }
    }

    private int countFailApp(List<CloudRestoreStatus> list, int i10, CloudRestoreStatus cloudRestoreStatus) {
        cloudRestoreStatus.setStatus(0).setType(0).setCurrent(0);
        list.add(cloudRestoreStatus);
        return cloudRestoreStatus.is3rdAppType() ? i10 + 1 : i10;
    }

    private void delete3rdApkIconMeta(CloudRestoreStatus cloudRestoreStatus, C12169k c12169k) throws C9721b {
        if (cloudRestoreStatus.is3rdAppType()) {
            String appId = cloudRestoreStatus.getAppId();
            String apkTempPath = ICBUtil.getApkTempPath(appId);
            String iconTempPath = ICBUtil.getIconTempPath(appId);
            c12169k.m73199b(apkTempPath, appId);
            c12169k.m73199b(iconTempPath, appId);
        }
    }

    private void dispatchRestoreNotification(int i10, int i11, boolean z10) {
        RestoreNotification restoreNotification = RestoreNotification.getInstance();
        float fM80911f0 = C13452e.m80781L().m80911f0();
        C11839m.m70686d(TAG, "dispatchRestoreNotification restoreProgress =" + fM80911f0 + " status = " + i10);
        switch (i10) {
            case 1:
                restoreNotification.sendRestoreNotification();
                break;
            case 2:
            case 3:
                C13452e.m80781L().m80909e3(100.0f);
                restoreNotification.completedNotification(100.0f, i10, i11, z10);
                break;
            case 4:
            case 5:
            case 7:
                restoreNotification.completedNotification(fM80911f0, i10, i11, z10);
                break;
            case 6:
                restoreNotification.showNetErrNotification(fM80911f0);
                break;
            case 8:
                restoreNotification.cancelNotification();
                break;
        }
    }

    private static Context getContext() {
        return C0213f.m1377a();
    }

    private String getServerPathByCloudPath(SnapshotBackupMeta snapshotBackupMeta, String str, String str2) {
        return str2 + str + "/" + snapshotBackupMeta.getCloudPath();
    }

    private static boolean isEncrypt() {
        return !C10028c.m62182c0().m62420y1();
    }

    private boolean isOnlySupport3rdAPK(CloudRestoreStatus cloudRestoreStatus, String str, String str2) {
        boolean zM12611e = PmsCheckUtil.m12611e();
        BackupRestoreOmConfigUtil backupRestoreOmConfigUtil = new BackupRestoreOmConfigUtil(str2);
        String appId = cloudRestoreStatus.getAppId();
        boolean zIsMatchDevCompatible = backupRestoreOmConfigUtil.isMatchDevCompatible(str, appId);
        boolean zIsMatchRestoreConfig = backupRestoreOmConfigUtil.isMatchRestoreConfig(appId, cloudRestoreStatus.getVersionCode());
        boolean z10 = cloudRestoreStatus.getAction() == 1;
        C11839m.m70688i(TAG, "isSupportPMS = " + zM12611e + ", isMatchDevCompatible = " + zIsMatchDevCompatible + ", isMatchRestoreConfig = " + zIsMatchRestoreConfig + ", isPartSupport = " + z10);
        return !zM12611e || zIsMatchDevCompatible || zIsMatchRestoreConfig || z10;
    }

    private void isUnSupported(CloudRestoreStatus cloudRestoreStatus, int i10, boolean z10, String str) {
        String appId = cloudRestoreStatus.getAppId();
        cloudRestoreStatus.setStatus(0);
        if (C2157a.m13200h().contains(appId)) {
            C11839m.m70688i(TAG, "app blackName " + appId + " not support to restore");
            cloudRestoreStatus.setStatus(-1);
        }
        if (i10 == 3 && !C12565k.m75525k()) {
            C11839m.m70688i(TAG, "maple app " + appId + " not support to restore");
            cloudRestoreStatus.setStatus(-1);
        }
        if (!z10 && C14333b.m85484s().contains(appId)) {
            C11839m.m70688i(TAG, "Google Gms not Installed, " + appId + " not support to restore");
            cloudRestoreStatus.setStatus(-1);
        }
        if (C14333b.m85454J().contains(appId)) {
            C11839m.m70688i(TAG, "system app, " + appId + " not support to restore");
            cloudRestoreStatus.setStatus(-1);
        }
        if (!cloudRestoreStatus.is3rdAppType() || str == null || str.isEmpty()) {
            return;
        }
        Map<String, String> mapParams = params(str);
        String str2 = mapParams.get("ohosArk");
        if (C4633d0.m28404a(str2) || !str2.equals(String.valueOf(1))) {
            return;
        }
        if (!C12565k.m75526l()) {
            C11839m.m70688i(TAG, "ohos ark app " + appId + " not support to restore");
            cloudRestoreStatus.setStatus(-1);
            return;
        }
        if (C12565k.m75527m(mapParams.get("ohosArkVersion"))) {
            return;
        }
        C11839m.m70688i(TAG, "ohos ark app " + appId + " not support to restore");
        cloudRestoreStatus.setStatus(-4);
    }

    public static /* synthetic */ boolean lambda$getActionStatusListV2$0(String str, CloudRestoreItem cloudRestoreItem) {
        return str.equals(cloudRestoreItem.getAppId());
    }

    public static Map<String, String> params(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split("&")) {
            String[] strArrSplit = str2.split("=");
            if (strArrSplit.length == 2) {
                map.put(strArrSplit[0], strArrSplit[1]);
            }
        }
        return map;
    }

    private void refresh3rdPath(SnapshotTreeManagementService snapshotTreeManagementService, String str, CloudRestoreStatus cloudRestoreStatus) throws C9721b {
        if (cloudRestoreStatus.is3rdAppType() && cloudRestoreStatus.m29539i().isEmpty()) {
            String appId = cloudRestoreStatus.getAppId();
            C11839m.m70688i(TAG, "refresh3rdPath start appId = " + appId);
            SnapshotBackupMeta snapshotBackupMetaQueryAppApkFile = snapshotTreeManagementService.queryAppApkFile(appId, str);
            if (snapshotBackupMetaQueryAppApkFile != null) {
                cloudRestoreStatus.m29535V(snapshotBackupMetaQueryAppApkFile.getAppId() + "/" + cloudRestoreStatus.getVersionCode() + "/" + snapshotBackupMetaQueryAppApkFile.getAppId() + ".apk_" + snapshotBackupMetaQueryAppApkFile.getHash1()).setAppType(1);
            }
            SnapshotBackupMeta snapshotBackupMetaQueryAppIconFile = snapshotTreeManagementService.queryAppIconFile(appId, str);
            if (snapshotBackupMetaQueryAppIconFile != null) {
                cloudRestoreStatus.m29515F0(snapshotBackupMetaQueryAppIconFile.getAppId() + "/" + cloudRestoreStatus.getVersionCode() + "/" + snapshotBackupMetaQueryAppIconFile.getAppId() + ".icon_" + snapshotBackupMetaQueryAppIconFile.getHash1());
            }
            C11839m.m70688i(TAG, "refresh3rdPath end appId = " + appId);
        }
    }

    private static void refreshStatusByDefaultOrPause(RestoreStatus restoreStatus, int i10, List<RestoreStatus> list, int i11) {
        if (i10 != 2 && i10 != 3) {
            if (i10 == 4) {
                if (i11 == 1004) {
                    restoreStatus.setStatus(0);
                } else {
                    restoreStatus.setStatus(8).setType(2);
                }
                list.add(restoreStatus);
                return;
            }
            if (i10 != 5) {
                if (i10 != 8) {
                    return;
                }
                restoreStatus.setStatus(1);
                list.add(restoreStatus);
                return;
            }
        }
        restoreStatus.setStatus(8).setType(2);
        list.add(restoreStatus);
    }

    private static void refreshStatusByDownloadOrRestore(RestoreStatus restoreStatus, int i10, List<RestoreStatus> list, int i11) {
        if (i10 == 0 || i10 == 1) {
            return;
        }
        if (i10 == 4) {
            if (i11 == 1004) {
                restoreStatus.setStatus(0);
            } else {
                restoreStatus.setStatus(8).setType(2);
            }
            list.add(restoreStatus);
            return;
        }
        if (i10 == 6) {
            restoreStatus.setStatus(0);
            list.add(restoreStatus);
        } else if (i10 != 8) {
            restoreStatus.setStatus(8).setType(2);
            list.add(restoreStatus);
        } else {
            restoreStatus.setStatus(1);
            list.add(restoreStatus);
        }
    }

    public static String value(Map<String, String> map, String str) {
        String str2 = map.get(str);
        return str2 == null ? "" : str2;
    }

    public CloudRestoreStatus buildRestoreStatus(CBSAppInfo cBSAppInfo, Boolean bool) throws C9721b {
        List<CBSFileInfo> fileInfos;
        CloudRestoreStatus cloudRestoreStatus = new CloudRestoreStatus();
        String appId = cBSAppInfo.getAppId();
        Map<String, String> map = TextUtils.isEmpty(cBSAppInfo.getExtend()) ? new HashMap<>() : params(cBSAppInfo.getExtend());
        int iM1686d = 0;
        if (bool == null ? RestoreUtil.isNewBmRecord() : bool.booleanValue()) {
            iM1686d = C0241z.m1686d(value(map, "bmAppDataType"), 0);
        }
        cloudRestoreStatus.setAppId(appId).setAppType(appType(appId, cBSAppInfo, iM1686d)).setSize(cBSAppInfo.getSize()).m29535V(cBSAppInfo.getApkPath()).m29547t0(cBSAppInfo.getApkUrl()).m29515F0(cBSAppInfo.getIconPath()).setBmAppDataType(iM1686d).m29516G0(isEncrypt() ? cBSAppInfo.getIconPath() : cBSAppInfo.getIconUrl());
        appExtend(cloudRestoreStatus, map);
        correctSize(cloudRestoreStatus);
        apkExtend(cloudRestoreStatus);
        if ((HNConstants.DataType.MEDIA.equals(appId) || "music".equals(appId)) && (fileInfos = cBSAppInfo.getFileInfos()) != null && fileInfos.size() > 0) {
            int size = fileInfos.size();
            if (HNConstants.DataType.MEDIA.equals(appId)) {
                size--;
            }
            cloudRestoreStatus.setCount(size);
        }
        return cloudRestoreStatus;
    }

    public void createSnapshotMetas(SnapshotTreeManagementService snapshotTreeManagementService, String str, CloudRestoreStatus cloudRestoreStatus, String str2, String str3) throws C9721b {
        String appId = cloudRestoreStatus.getAppId();
        C11839m.m70688i(TAG, "createSnapshotMetas start appId = " + appId);
        refresh3rdPath(snapshotTreeManagementService, str, cloudRestoreStatus);
        C12169k c12169k = new C12169k();
        if (cloudRestoreStatus.is3rdAppType() && isOnlySupport3rdAPK(cloudRestoreStatus, str3, str)) {
            if (cloudRestoreStatus.getAction() == 0) {
                cloudRestoreStatus.m29510A0(String.valueOf(0));
                cloudRestoreStatus.m29512C0(-1);
            }
            cloudRestoreStatus.setAction(1);
            SnapshotBackupMeta snapshotBackupMetaQueryAppInfoFile = snapshotTreeManagementService.queryAppInfoFile(appId, str);
            C12168j c12168jConvertToAppRestoreMeta = snapshotBackupMetaQueryAppInfoFile.convertToAppRestoreMeta(appId);
            c12168jConvertToAppRestoreMeta.m73197z(getServerPathByCloudPath(snapshotBackupMetaQueryAppInfoFile, appId, str2));
            c12169k.m73214q(c12168jConvertToAppRestoreMeta);
            return;
        }
        SnapshotTreeManagementService.getInstance().snapshotDataToRestoreMeta(appId, str, str2);
        delete3rdApkIconMeta(cloudRestoreStatus, c12169k);
        int size = new QueryOneModuleRestoreMetas(appId).getSize();
        if (HNConstants.DataType.MEDIA.equals(appId)) {
            cloudRestoreStatus.setCount(size - 1);
            C11839m.m70686d(TAG, appId + " count = " + cloudRestoreStatus.getCount());
        }
        if ("music".equals(appId)) {
            cloudRestoreStatus.setCount(size);
            C11839m.m70686d(TAG, appId + " count = " + size);
        }
        long jM73212o = c12169k.m73212o(appId);
        long jM73213p = c12169k.m73213p(appId);
        C0221j.m1493c(jM73212o, jM73213p, getContext());
        C11839m.m70688i(TAG, "createSnapshotMetas end  appId = " + appId + " file info size = " + size + " sdCardSize = " + jM73212o + " udiskSize = " + jM73213p);
    }

    public CloudRestoreStatus createStatus(CBSAppInfo cBSAppInfo, int i10, boolean z10) throws C9721b {
        CloudRestoreStatus cloudRestoreStatusBuildRestoreStatus = buildRestoreStatus(cBSAppInfo, null);
        cloudRestoreStatusBuildRestoreStatus.m29523L0(i10);
        isUnSupported(cloudRestoreStatusBuildRestoreStatus, cBSAppInfo.getRuntimeType(), z10, cBSAppInfo.getExtend());
        return cloudRestoreStatusBuildRestoreStatus;
    }

    public void dealNotifySetting(long j10, String str, int i10, String str2) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(getContext(), SharedPreferencesStorage.BACKUPOPTION_SPFILE, 0);
        if (sharedPreferencesM1382b != null && !sharedPreferencesM1382b.getBoolean("backup_key", false)) {
            CloudBackupReport.reportOpenCloudBackup("10", i10, str2);
            CloudBackupService.getInstance().cloudbackupOpr(true);
        }
        if (j10 == 0) {
            return;
        }
        SettingOperator settingOperator = new SettingOperator();
        long jQueryinitopentime = settingOperator.queryinitopentime();
        String strM80950o = C13452e.m80781L().m80950o();
        if (strM80950o != null && strM80950o.equals(str) && jQueryinitopentime > j10) {
            settingOperator.replace(new Settings[]{new Settings("lastbackuptime", String.valueOf(j10), "2")});
        }
        settingOperator.replace(new Settings[]{new Settings("lastnotifytime", String.valueOf(j10), "2")});
    }

    public Map<String, CloudRestoreStatus> getActionStatusListV2(List<CloudRestoreItem> list) {
        HashMap map = new HashMap();
        for (CloudRestoreItem cloudRestoreItem : list) {
            final String appId = cloudRestoreItem.getAppId();
            List<CloudRestoreItem> listM29202r = cloudRestoreItem.m29202r();
            if (AbstractC14026a.m84159a(listM29202r)) {
                CloudRestoreStatus cloudRestoreStatus = new CloudRestoreStatus();
                cloudRestoreStatus.setAppId(appId);
                cloudRestoreStatus.update(cloudRestoreItem);
                cloudRestoreStatus.setAppName(cloudRestoreItem.getAppName()).setAppType(cloudRestoreItem.getAppType());
                if (cloudRestoreItem.is3rdAppType()) {
                    if (!cloudRestoreItem.m29187M() || cloudRestoreStatus.getAction() != 2) {
                        List<CloudRestoreItem> list2 = RestoreCache.getInstance().get3rdAppDataStatusList();
                        if (!list2.isEmpty()) {
                            List list3 = (List) list2.stream().filter(new Predicate() { // from class: m8.a
                                @Override // java.util.function.Predicate
                                public final boolean test(Object obj) {
                                    return CloudRestoreClient.lambda$getActionStatusListV2$0(appId, (CloudRestoreItem) obj);
                                }
                            }).collect(Collectors.toList());
                            Iterator it = list3.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                int action = ((CloudRestoreItem) it.next()).getAction();
                                if (cloudRestoreStatus.getAction() == 0 && action == 2) {
                                    C11839m.m70688i(TAG, "do not restore app file data, appId = " + appId);
                                    cloudRestoreStatus.setAction(1);
                                    break;
                                }
                            }
                            if (list3.isEmpty() && cloudRestoreStatus.getAction() == 0) {
                                cloudRestoreStatus.setAction(1);
                            }
                        } else if (cloudRestoreStatus.getAction() == 0) {
                            cloudRestoreStatus.setAction(1);
                        }
                    }
                }
                map.put(cloudRestoreStatus.getAppId(), cloudRestoreStatus);
            } else if (!"thirdAppData".equals(cloudRestoreItem.getAppId())) {
                map.putAll(getActionStatusListV2(listM29202r));
            }
        }
        return map;
    }

    public void refreshOneModuleStatus(RestoreStatus restoreStatus, int i10, List<RestoreStatus> list, C9721b c9721b) {
        int status = restoreStatus.getStatus();
        int iM60659c = c9721b != null ? c9721b.m60659c() : -1;
        C11839m.m70688i(TAG, "refreshOneModuleStatus the appid is " + restoreStatus.getAppId() + ",status is:" + status + ",errorCode is:" + iM60659c);
        if (status != 0) {
            switch (status) {
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    refreshStatusByDownloadOrRestore(restoreStatus, i10, list, iM60659c);
                    break;
                case 8:
                    if (2 == restoreStatus.getType() && RestoreUtil.isRestoreNeedAutoRetry(iM60659c)) {
                        refreshStatusByDownloadOrRestore(restoreStatus, i10, list, iM60659c);
                        break;
                    }
                    break;
            }
        }
        refreshStatusByDefaultOrPause(restoreStatus, i10, list, iM60659c);
    }

    public void refreshStatus(int i10, List<CloudRestoreStatus> list, C13035n c13035n, C9721b c9721b) {
        RestoreProgress.initRestoreItems();
        ArrayList arrayList = new ArrayList();
        for (CloudRestoreStatus cloudRestoreStatus : list) {
            if (cloudRestoreStatus == null) {
                C11839m.m70689w(TAG, "refreshStatus restoreStatus is null.");
            } else {
                refreshOneModuleStatus(cloudRestoreStatus, i10, arrayList, c9721b);
                RestoreProgress.updateStatus(cloudRestoreStatus);
            }
        }
        for (RestoreStatus restoreStatus : arrayList) {
            if (restoreStatus == null) {
                C11839m.m70689w(TAG, "refreshStatus status is null.");
            } else {
                c13035n.m78558j(restoreStatus.getAppId(), restoreStatus.getStatus(), restoreStatus.getType());
            }
        }
    }

    public void refreshStatusV3(int i10, List<CloudRestoreStatusV3> list, C12816g c12816g, C9721b c9721b) {
        ArrayList arrayList = new ArrayList();
        for (CloudRestoreStatusV3 cloudRestoreStatusV3 : list) {
            if (cloudRestoreStatusV3 == null) {
                C11839m.m70689w(TAG, "refreshStatus restoreStatus is null.");
            } else {
                refreshOneModuleStatus(cloudRestoreStatusV3, i10, arrayList, c9721b);
                RestoreProgress.updateStatus(cloudRestoreStatusV3);
            }
        }
        for (RestoreStatus restoreStatus : arrayList) {
            if (restoreStatus == null) {
                C11839m.m70689w(TAG, "refreshStatus status is null.");
            } else {
                c12816g.m76959w(restoreStatus.getAppId(), restoreStatus.getStatus(), restoreStatus.getUid(), restoreStatus.getType(), restoreStatus.getSubStatus());
            }
        }
    }

    public Bundle restoreCloneBundle(CloudRestoreStatus cloudRestoreStatus, String str) {
        String appId = cloudRestoreStatus.getAppId();
        Bundle bundle = new Bundle();
        bundle.putInt(CloneService.KEY_ACTION_FLAG, 11);
        if (cloudRestoreStatus.is3rdAppType()) {
            if (!cloudRestoreStatus.m29532S()) {
                cloudRestoreStatus.setDoneStatusAndType(1, cloudRestoreStatus.getType());
                return null;
            }
            if (C10278a.m63440f(C10278a.m63442h(str + "/" + appId)) == null) {
                C11839m.m70688i(TAG, "restoreCloneBundle error, " + appId + " file list is null.");
                return null;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt(appId, 1);
            bundle.putBundle("app", bundle2);
        } else if (HNConstants.DataType.CONTACT.equals(appId)) {
            Bundle bundle3 = new Bundle();
            bundle3.putString("AccountName", "Phone");
            bundle3.putString("AccountType", "com.android.huawei.phone");
            Bundle bundle4 = new Bundle();
            bundle4.putBundle("0", bundle3);
            bundle.putBundle(HNConstants.DataType.CONTACT, bundle4);
        } else if (C14333b.m85491z().contains(appId)) {
            C11839m.m70686d(TAG, "put media restore key!");
            bundle.putInt("key_media_restore_location", 2);
        }
        return bundle;
    }

    public void sendClearCacheSuccessMessage() {
        C11839m.m70688i(TAG, "sendClearCacheSuccessMessage");
        CBCallBack.getInstance().sendMessageDelayed(Message.obtain((Handler) null, 33015), 500L);
    }

    public void sendMessage(int i10, int i11, boolean z10) {
        C13452e.m80781L().m80914f3(i10);
        dispatchRestoreNotification(i10, i11, z10);
        CBCallBack.getInstance().sendMessage(Message.obtain(null, 3205, i10, i11, Boolean.TRUE));
    }

    public void updateStatusBeforeRetry() throws C9721b {
        C13035n c13035n = new C13035n();
        List<CloudRestoreStatus> listM78552d = c13035n.m78552d();
        ArrayList arrayList = new ArrayList();
        CloudRestoreStatus cloudRestoreStatus = null;
        int i10 = 0;
        int iCountFailApp = 0;
        for (CloudRestoreStatus cloudRestoreStatus2 : listM78552d) {
            if (!"HWlanucher".equals(cloudRestoreStatus2.getAppId())) {
                int status = cloudRestoreStatus2.getStatus();
                int type = cloudRestoreStatus2.getType();
                switch (status) {
                    case 2:
                        if (cloudRestoreStatus2.is3rdAppType()) {
                            i10++;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        iCountFailApp = countFailApp(arrayList, iCountFailApp, cloudRestoreStatus2);
                        break;
                    case 8:
                        if (type != 1) {
                            iCountFailApp = countFailApp(arrayList, iCountFailApp, cloudRestoreStatus2);
                            break;
                        } else {
                            break;
                        }
                }
            } else {
                cloudRestoreStatus = cloudRestoreStatus2;
            }
        }
        checkLauncherStatus(arrayList, cloudRestoreStatus, i10, iCountFailApp);
        c13035n.batchReplace(arrayList);
        new C12169k().m73220w();
    }
}

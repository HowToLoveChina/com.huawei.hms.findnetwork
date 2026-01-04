package com.huawei.hicloud.notification.manager;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.BackupClears;
import com.huawei.hicloud.notification.p106db.bean.BannerSpacePositionConfig;
import com.huawei.hicloud.notification.p106db.bean.BannerSpacePositionConfigActivity;
import com.huawei.hicloud.notification.p106db.bean.CloudBackupClears;
import com.huawei.hicloud.notification.p106db.bean.HiCloudSpaceSceneNotices;
import com.huawei.hicloud.notification.task.QueryHiCloudSceneHomePageBannerTask;
import com.huawei.hicloud.notification.task.QueryHiCloudSceneSpaceMgrBannerTask;
import java.io.File;
import java.io.FileInputStream;
import p015ak.C0209d;
import p015ak.C0213f;
import p459lp.C11327e;
import p616rk.C12515a;

/* loaded from: classes6.dex */
public class HiCloudSceneSpaceMgrManager {
    private static final String TAG = "HiCloudSceneSpaceMgrManager";

    public static class Holder {
        private static HiCloudSceneSpaceMgrManager INSTANCE = new HiCloudSceneSpaceMgrManager();

        private Holder() {
        }
    }

    public /* synthetic */ HiCloudSceneSpaceMgrManager(C49271 c49271) {
        this();
    }

    private void clearConfigFile() {
        Context contextM1378b = C0213f.m1378b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(contextM1378b.getFilesDir());
        String str = File.separator;
        sb2.append(str);
        sb2.append("recommend_card_config");
        sb2.append(str);
        RecommendCardManager.getInstance().clearFile(sb2.toString() + "HiCloudSceneSpaceMgrBanner.json");
    }

    public static HiCloudSceneSpaceMgrManager getInstance() {
        return Holder.INSTANCE;
    }

    public void clearConfigFileAndDb() {
        clearConfigFile();
        C11327e.m68059b("HiCloudSceneSpaceMgrBanner");
    }

    public BackupClears getBackupClears(int i10, String str) {
        String activityId;
        try {
            BannerSpacePositionConfig configByEntrance = HiCloudSpacePositionMgrManager.getInstance().getConfigByEntrance(str);
            if (configByEntrance != null) {
                BannerSpacePositionConfigActivity[] activities = configByEntrance.getActivities();
                int length = activities.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        activityId = null;
                        break;
                    }
                    BannerSpacePositionConfigActivity bannerSpacePositionConfigActivity = activities[i11];
                    if (RecommendCardConstants.ActivityType.CLOUD_BACKUP_CLEAR.equals(bannerSpacePositionConfigActivity.getActivityType())) {
                        activityId = bannerSpacePositionConfigActivity.getActivityId();
                        break;
                    }
                    i11++;
                }
                if (TextUtils.isEmpty(activityId)) {
                    NotifyLogger.m29914e(TAG, "getBackupClears activityId is null");
                    return null;
                }
                NotifyLogger.m29915i(TAG, "getBackupClears entrance: " + str + ", activityId: " + activityId);
                HiCloudSpaceSceneNotices configFromFile = getConfigFromFile(str);
                if (configFromFile != null) {
                    for (CloudBackupClears cloudBackupClears : configFromFile.getSceneNotices().getCloudBackupClears()) {
                        if (activityId.equals(cloudBackupClears.getActivityId())) {
                            for (BackupClears backupClears : cloudBackupClears.getBackupClears()) {
                                if (i10 == backupClears.getEnableBackup()) {
                                    return backupClears;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getBackupClears error: " + e10.toString());
        }
        return null;
    }

    public HiCloudSpaceSceneNotices getConfigFromFile(String str) {
        Context contextM1378b = C0213f.m1378b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(contextM1378b.getFilesDir());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("recommend_card_config");
        sb2.append(str2);
        String string = sb2.toString();
        if (str.equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
            string = string + "HiCloudSceneHomePageBanner.json";
        } else if (str.equals("manage")) {
            string = string + "HiCloudSceneSpaceMgrBanner.json";
        }
        File file = new File(string);
        if (!file.exists()) {
            NotifyLogger.m29915i(TAG, "config file not existed");
            getConfigFromOM(str);
            return null;
        }
        try {
            return (HiCloudSpaceSceneNotices) new Gson().fromJson(C0209d.m1290o2(new FileInputStream(file)), HiCloudSpaceSceneNotices.class);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getConfigFromFile exception: " + e10.toString());
            return null;
        }
    }

    public void getConfigFromOM(String str) {
        NotifyLogger.m29915i(TAG, "getConfigFromOM entrance：" + str);
        if (str.equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
            C12515a.m75110o().m75172d(new QueryHiCloudSceneHomePageBannerTask());
        } else if (str.equals("manage")) {
            C12515a.m75110o().m75172d(new QueryHiCloudSceneSpaceMgrBannerTask());
        }
    }

    public int getOverMonths(int i10) {
        BackupClears backupClears = getBackupClears(i10, "manage");
        if (backupClears == null) {
            return 0;
        }
        NotifyLogger.m29915i(TAG, "backupClearConfig: " + backupClears.toString());
        return backupClears.getOverMonths();
    }

    private HiCloudSceneSpaceMgrManager() {
    }
}

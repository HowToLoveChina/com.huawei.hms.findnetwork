package com.huawei.hicloud.notification.manager;

import android.content.Context;
import com.google.gson.Gson;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.BannerSpacePositionConfig;
import com.huawei.hicloud.notification.p106db.bean.HiCloudSpacePositionMgr;
import com.huawei.hicloud.notification.p106db.bean.SpacePositionMgr;
import com.huawei.hicloud.notification.task.QueryHiCloudSpacePositionMgrTask;
import java.io.File;
import java.io.FileInputStream;
import p015ak.C0209d;
import p015ak.C0213f;
import p459lp.C11327e;
import p616rk.C12515a;
import p709vj.C13452e;

/* loaded from: classes6.dex */
public class HiCloudSpacePositionMgrManager {
    private static final String TAG = "HiCloudSpacePositionMgrManager";

    public static class Holder {
        private static HiCloudSpacePositionMgrManager INSTANCE = new HiCloudSpacePositionMgrManager();

        private Holder() {
        }
    }

    private void clearConfigFile() {
        Context contextM1378b = C0213f.m1378b();
        if (contextM1378b == null) {
            NotifyLogger.m29914e(TAG, "context is null");
            return;
        }
        File file = new File(contextM1378b.getFilesDir() + File.separator + "HiCloudSpacePositionMgr.json");
        if (!file.exists()) {
            NotifyLogger.m29915i(TAG, "config file not exist");
        } else {
            if (file.delete()) {
                return;
            }
            NotifyLogger.m29914e(TAG, "config file delete fail");
        }
    }

    public static HiCloudSpacePositionMgrManager getInstance() {
        return Holder.INSTANCE;
    }

    public void clearConfigFileAndDb() {
        clearConfigFile();
        C11327e.m68059b("HiCloudSpacePositionMgr");
    }

    public BannerSpacePositionConfig getConfigByEntrance(String str) {
        if (!RecommendCardManager.getInstance().checkEntrance(str)) {
            return null;
        }
        HiCloudSpacePositionMgr configFromFile = getConfigFromFile();
        if (configFromFile == null) {
            NotifyLogger.m29914e(TAG, "hiCloudSpacePositionMgr is null");
            return null;
        }
        SpacePositionMgr spacePositionMgr = configFromFile.getSpacePositionMgr();
        if (spacePositionMgr == null) {
            NotifyLogger.m29914e(TAG, "spacePositionMgr is null");
            return null;
        }
        BannerSpacePositionConfig[] bannerSpacePositionConfigs = spacePositionMgr.getBannerSpacePositionConfigs();
        if (bannerSpacePositionConfigs == null) {
            NotifyLogger.m29914e(TAG, "bannerSpacePositionConfigs is null");
            return null;
        }
        for (int i10 = 0; i10 < bannerSpacePositionConfigs.length && i10 < 3; i10++) {
            BannerSpacePositionConfig bannerSpacePositionConfig = bannerSpacePositionConfigs[i10];
            if (bannerSpacePositionConfig == null) {
                NotifyLogger.m29914e(TAG, "bannerSpacePositionConfig is null");
            } else if (str.equals(bannerSpacePositionConfig.getEntrance())) {
                NotifyLogger.m29915i(TAG, "match entrance");
                return bannerSpacePositionConfig;
            }
        }
        NotifyLogger.m29914e(TAG, "not match entrance");
        return null;
    }

    public HiCloudSpacePositionMgr getConfigFromFile() {
        Context contextM1378b = C0213f.m1378b();
        if (contextM1378b == null) {
            NotifyLogger.m29914e(TAG, "DE context is null");
            return null;
        }
        File file = new File(contextM1378b.getFilesDir() + File.separator + "HiCloudSpacePositionMgr.json");
        if (!file.exists()) {
            NotifyLogger.m29915i(TAG, "config file not existed");
            getConfigFromOM();
            return null;
        }
        try {
            return (HiCloudSpacePositionMgr) new Gson().fromJson(C0209d.m1290o2(new FileInputStream(file)), HiCloudSpacePositionMgr.class);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getConfigFromFile exception: " + e10.toString());
            return null;
        }
    }

    public void getConfigFromOM() {
        if (!C13452e.m80781L().m80842P0()) {
            NotifyLogger.m29915i(TAG, "not login");
        } else {
            if (!C0209d.m1333z1(C0213f.m1377a())) {
                NotifyLogger.m29915i(TAG, "no notwork connected");
                return;
            }
            NotifyLogger.m29915i(TAG, "getConfigFromOM");
            C12515a.m75110o().m75172d(new QueryHiCloudSpacePositionMgrTask());
        }
    }

    public int getNotifyBarDay(String str) {
        BannerSpacePositionConfig configByEntrance = getInstance().getConfigByEntrance(str);
        if (configByEntrance != null) {
            return configByEntrance.getNotifyBarDay();
        }
        NotifyLogger.m29914e(TAG, "bannerSpacePositionConfig is null");
        return -1;
    }

    public int getNotifyBarTimes(String str) {
        BannerSpacePositionConfig configByEntrance = getInstance().getConfigByEntrance(str);
        if (configByEntrance != null) {
            return configByEntrance.getNotifyBarTimes();
        }
        NotifyLogger.m29914e(TAG, "bannerSpacePositionConfig is null");
        return -1;
    }

    private HiCloudSpacePositionMgrManager() {
    }
}

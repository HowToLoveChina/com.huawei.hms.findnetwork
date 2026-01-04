package com.huawei.hicloud.notification.manager;

import android.content.Context;
import android.database.SQLException;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.p106db.operator.HiCloudSpaceSceneNoticesOperator;
import java.io.File;
import p015ak.C0213f;
import p459lp.C11327e;

/* loaded from: classes6.dex */
public class HiCloudSpaceSceneNoticesManager {
    private static final String TAG = "HiCloudSpaceSceneNoticesManager";

    public static class Holder {
        private static HiCloudSpaceSceneNoticesManager INSTANCE = new HiCloudSpaceSceneNoticesManager();

        private Holder() {
        }
    }

    public static HiCloudSpaceSceneNoticesManager getInstance() {
        return Holder.INSTANCE;
    }

    public void clearConfigFileAndDb() throws SQLException {
        Context contextM1378b = C0213f.m1378b();
        RecommendCardManager recommendCardManager = RecommendCardManager.getInstance();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(contextM1378b.getFilesDir());
        String str = File.separator;
        sb2.append(str);
        sb2.append(RecommendCardConstants.LanguageFileName.HICLOUD_SPACE_SCENE_NOTICES);
        recommendCardManager.clearFile(sb2.toString());
        RecommendCardManager.getInstance().clearFile(contextM1378b.getFilesDir() + str + "HiCloudSpaceSceneNotices.json");
        new HiCloudSpaceSceneNoticesOperator().clear();
        C11327e.m68059b("HiCloudSpaceSceneNotices");
    }

    private HiCloudSpaceSceneNoticesManager() {
    }
}

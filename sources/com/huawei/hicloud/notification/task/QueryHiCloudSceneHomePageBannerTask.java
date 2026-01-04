package com.huawei.hicloud.notification.task;

import android.text.TextUtils;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.HiCloudSceneBannerManager;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguage;
import com.huawei.hicloud.notification.p106db.bean.HiCloudSpaceSceneNotices;
import com.huawei.hicloud.notification.p106db.bean.SceneNotices;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.service.C5028v;
import fk.C9721b;
import gp.C10028c;
import p292fn.C9734g;
import p459lp.C11327e;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;

/* loaded from: classes6.dex */
public class QueryHiCloudSceneHomePageBannerTask extends AbstractC12367d {
    private static final String TAG = "QueryHiCloudSceneHomePageBannerTask";

    private void extractConfig() {
        NotifyLogger.m29915i(TAG, "extractConfig");
        HiCloudSpaceSceneNotices configFromFile = HiCloudSceneBannerManager.getInstance().getConfigFromFile(RecommendCardConstants.Entrance.HOMEPAGE);
        if (configFromFile == null) {
            NotifyLogger.m29914e(TAG, "hiCloudSpaceSceneNotices is null");
            return;
        }
        SceneNotices sceneNotices = configFromFile.getSceneNotices();
        if (sceneNotices == null) {
            NotifyLogger.m29914e(TAG, "sceneNotices is null");
            return;
        }
        CommonLanguage language = sceneNotices.getLanguage();
        if (language == null) {
            NotifyLogger.m29914e(TAG, "language is null");
            return;
        }
        int iM62189B = C10028c.m62182c0().m62189B(RecommendCardConstants.LanguageVersion.HICLOUD_SCENE_HOMEPAGE_BANNER);
        int version = language.getVersion();
        String strM62184A = C10028c.m62182c0().m62184A(RecommendCardConstants.LanguageHash.HICLOUD_SCENE_HOMEPAGE_BANNER);
        String hash = language.getHash();
        NotifyLogger.m29915i(TAG, "localLanguageVersion: " + iM62189B + ", omLanguageVersion: " + version + "localLanguageHash: " + strM62184A + ", omLanguageHash: " + hash);
        if (iM62189B == 0 || TextUtils.isEmpty(strM62184A) || (iM62189B < version && !TextUtils.equals(strM62184A, hash))) {
            HiCloudSceneBannerManager.getInstance().clearLanguageXml(RecommendCardConstants.Entrance.HOMEPAGE);
            HiCloudSceneBannerManager.getInstance().clearLanguageDb(RecommendCardConstants.Entrance.HOMEPAGE);
            C12515a.m75110o().m75175e(new QueryHiCloudSceneBannerLanguageTask(language, RecommendCardConstants.Entrance.HOMEPAGE), false);
        }
        HiCloudSceneBannerManager.getInstance().downloadSceneNoticesPictures(sceneNotices, RecommendCardConstants.Entrance.HOMEPAGE);
    }

    private void getConfig(C5028v c5028v) {
        if (c5028v == null) {
            c5028v = new C5028v(null);
        }
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
            } catch (C9721b e10) {
                NotifyLogger.m29914e(TAG, "get config exception: " + e10.toString());
                if (NotifyUtil.procFlowControlException(e10, "HiCloudSceneHomePageBanner")) {
                    return;
                }
                if (e10.m60659c() == 304) {
                    NotifyLogger.m29914e(TAG, "HTTP_NOT_MODIFY extract sync module config");
                    return;
                } else {
                    if (!c5028v.isExceptionNeedRetry(e10) || i10 >= 2) {
                        return;
                    }
                    NotifyLogger.m29915i(TAG, "getConfig exception retry, retry num: " + i10);
                }
            }
            if (c5028v.getLatestConfig()) {
                NotifyLogger.m29915i(TAG, "get config success");
                C9734g.m60767a().m60769c("HiCloudSceneHomePageBanner");
                extractConfig();
                return;
            }
            NotifyLogger.m29914e(TAG, "get config fail");
            if (i10 >= 2) {
                return;
            }
            NotifyLogger.m29915i(TAG, "getLatestConfig failed retry, retry num: " + i10);
        }
    }

    private void getConfigVersion() {
        long configVersion;
        NotifyLogger.m29915i(TAG, "getConfigVersion");
        C5028v c5028v = new C5028v(null);
        int i10 = 0;
        while (true) {
            if (i10 > 2) {
                configVersion = 0;
                break;
            }
            try {
                configVersion = c5028v.getConfigVersion();
                break;
            } catch (C9721b e10) {
                NotifyLogger.m29914e(TAG, "getConfigVersion exception: " + e10.toString());
                if (!c5028v.isExceptionNeedRetry(e10) || i10 >= 2) {
                    return;
                }
                NotifyLogger.m29915i(TAG, "getConfigVersion exception retry, retry num: " + i10);
                i10++;
            }
        }
        if (C11327e.m68063f("HiCloudSceneHomePageBanner") < configVersion) {
            NotifyLogger.m29915i(TAG, "version updated, query config");
            getConfig(c5028v);
        } else {
            NotifyLogger.m29915i(TAG, "version not updated, extract config");
            extractConfig();
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        getConfigVersion();
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.RECOMMEND_CARD;
    }
}

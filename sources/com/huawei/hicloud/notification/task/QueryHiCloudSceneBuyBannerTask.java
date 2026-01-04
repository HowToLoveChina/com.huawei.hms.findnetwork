package com.huawei.hicloud.notification.task;

import android.text.TextUtils;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.HiCloudSceneBannerManager;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguage;
import com.huawei.hicloud.notification.p106db.bean.HiCloudSpaceSceneNotices;
import com.huawei.hicloud.notification.p106db.bean.SceneNotices;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.service.C5027u;
import fk.C9721b;
import gp.C10028c;
import p292fn.C9734g;
import p459lp.C11327e;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;

/* loaded from: classes6.dex */
public class QueryHiCloudSceneBuyBannerTask extends AbstractC12367d {
    private static final String TAG = "QueryHiCloudSceneBuyBannerTask";

    private void extractConfig() {
        NotifyLogger.m29915i(TAG, "extractConfig");
        HiCloudSpaceSceneNotices configFromFile = HiCloudSceneBannerManager.getInstance().getConfigFromFile(RecommendCardConstants.Entrance.BUY);
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
        int iM62189B = C10028c.m62182c0().m62189B(RecommendCardConstants.LanguageVersion.HICLOUD_SCENE_BUY_BANNER);
        String strM62184A = C10028c.m62182c0().m62184A(RecommendCardConstants.LanguageHash.HICLOUD_SCENE_BUY_BANNER);
        int version = language.getVersion();
        String hash = language.getHash();
        NotifyLogger.m29915i(TAG, "localLanguageVersion: " + iM62189B + ", omLanguageVersion: " + version + "localLanguageHash: " + strM62184A + ", omLanguageHash: " + hash);
        if (iM62189B == 0 || TextUtils.isEmpty(strM62184A) || (iM62189B < version && !TextUtils.equals(strM62184A, hash))) {
            HiCloudSceneBannerManager.getInstance().clearLanguageXml(RecommendCardConstants.Entrance.BUY);
            HiCloudSceneBannerManager.getInstance().clearLanguageDb(RecommendCardConstants.Entrance.BUY);
            C12515a.m75110o().m75175e(new QueryHiCloudSceneBannerLanguageTask(language, RecommendCardConstants.Entrance.BUY), false);
        }
        HiCloudSceneBannerManager.getInstance().downloadSceneNoticesPictures(sceneNotices, RecommendCardConstants.Entrance.BUY);
    }

    private void getConfig(C5027u c5027u) {
        if (c5027u == null) {
            c5027u = new C5027u(null);
        }
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
            } catch (C9721b e10) {
                NotifyLogger.m29914e(TAG, "get scene config exception: " + e10.toString());
                if (NotifyUtil.procFlowControlException(e10, "HiCloudSceneBuyBanner")) {
                    return;
                }
                if (e10.m60659c() == 304) {
                    NotifyLogger.m29914e(TAG, "HTTP_NOT_MODIFY extract sync module config");
                    return;
                } else {
                    if (!c5027u.isExceptionNeedRetry(e10) || i10 >= 2) {
                        return;
                    }
                    NotifyLogger.m29915i(TAG, "getConfig exception retry, retry num: " + i10);
                }
            }
            if (c5027u.getLatestConfig()) {
                NotifyLogger.m29915i(TAG, "get scene config success");
                C9734g.m60767a().m60769c("HiCloudSceneBuyBanner");
                extractConfig();
                return;
            }
            NotifyLogger.m29914e(TAG, "get scene config fail");
            if (i10 >= 2) {
                return;
            }
            NotifyLogger.m29915i(TAG, "getLatestConfig failed retry, retry num: " + i10);
        }
    }

    private void getConfigVersion() {
        long configVersion;
        NotifyLogger.m29915i(TAG, "getConfigVersion");
        C5027u c5027u = new C5027u(null);
        int i10 = 0;
        while (true) {
            if (i10 > 2) {
                configVersion = 0;
                break;
            }
            try {
                configVersion = c5027u.getConfigVersion();
                break;
            } catch (C9721b e10) {
                NotifyLogger.m29914e(TAG, "getConfigVersion exception: " + e10.toString());
                if (!c5027u.isExceptionNeedRetry(e10) || i10 >= 2) {
                    return;
                }
                NotifyLogger.m29915i(TAG, "getConfigVersion exception retry, retry num: " + i10);
                i10++;
            }
        }
        if (C11327e.m68063f("HiCloudSceneBuyBanner") < configVersion) {
            NotifyLogger.m29915i(TAG, "version updated, query config");
            getConfig(c5027u);
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

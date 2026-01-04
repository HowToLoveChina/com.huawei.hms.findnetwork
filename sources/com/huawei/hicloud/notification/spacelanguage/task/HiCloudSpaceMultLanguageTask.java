package com.huawei.hicloud.notification.spacelanguage.task;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.spacelanguage.bean.Configurations;
import com.huawei.hicloud.notification.spacelanguage.bean.SpaceMultLanguage;
import com.huawei.hicloud.notification.spacelanguage.bean.SpaceMultLanguageConfig;
import com.huawei.hicloud.notification.spacelanguage.manager.SpaceMultLanguageDownloader;
import com.huawei.hicloud.notification.spacelanguage.util.SpaceMultLanguageUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.service.C5031y;
import fk.C9721b;
import gp.C10028c;
import java.io.File;
import p015ak.C0213f;
import p292fn.C9734g;
import p459lp.C11327e;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* loaded from: classes6.dex */
public class HiCloudSpaceMultLanguageTask extends AbstractC12367d {
    private static final String TAG = "HiCloudSpaceMultLanguageTask";
    private int cmd;

    public HiCloudSpaceMultLanguageTask(int i10) {
        this.cmd = i10;
    }

    private void downloadAndParseLanguageXml(Context context, SpaceMultLanguageConfig spaceMultLanguageConfig) throws NumberFormatException {
        int i10;
        int iM62189B;
        if (spaceMultLanguageConfig == null) {
            NotifyLogger.m29914e(TAG, "downloadAndParseLanguageXml spacLanguagePageConfig is null.");
            SpaceMultLanguageUtil.saveLanguageDownloadingFlag(false);
            return;
        }
        Configurations configurations = spaceMultLanguageConfig.getConfigurations();
        if (configurations == null) {
            NotifyLogger.m29914e(TAG, "properties is null");
            return;
        }
        SpaceMultLanguage language = configurations.getLanguage();
        if (language == null) {
            NotifyLogger.m29914e(TAG, "language is null");
            SpaceMultLanguageUtil.saveLanguageDownloadingFlag(false);
            return;
        }
        try {
            i10 = Integer.parseInt(language.getVersion());
            iM62189B = C10028c.m62182c0().m62189B(RecommendCardConstants.LanguageVersion.HICLOUD_SPACE_MULT_LANGUAGE);
            NotifyLogger.m29915i(TAG, "downloadAndParseCloudSpaceLanguage localVersion ：" + iM62189B + ",cloudVersion:" + i10);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "downloadAndParseCloudSpaceLanguage language version:" + e10);
        }
        if (iM62189B >= i10) {
            NotifyLogger.m29916w(TAG, "downloadAndParseCloudSpaceLanguage language has no newVersion!");
            return;
        }
        C10028c.m62182c0().m62386r2(RecommendCardConstants.LanguageVersion.HICLOUD_SPACE_MULT_LANGUAGE, i10);
        String url = language.getUrl();
        if (TextUtils.isEmpty(url)) {
            NotifyLogger.m29914e(TAG, "downloadAndParseLanguageXml url is null.");
            SpaceMultLanguageUtil.saveLanguageDownloadingFlag(false);
        } else if (new SpaceMultLanguageDownloader(context, url, RecommendCardConstants.spaceLanguage.SPACE_MULT_LANGUAGE_XML_NAME, language.getHash()).start()) {
            SpaceMultLanguageUtil.saveLanguageDownloadingFlag(false);
            NotifyLogger.m29915i(TAG, "download cloud spacLanguage language success.");
        } else {
            NotifyLogger.m29914e(TAG, "downloadAndParseLanguageXml spacLanguageLanguageDownload failed.");
            SpaceMultLanguageUtil.saveLanguageDownloadingFlag(false);
        }
    }

    private void getConfig() throws NumberFormatException {
        Context contextM1377a;
        NotifyLogger.m29915i(TAG, "getConfig()");
        C5031y c5031y = new C5031y(null);
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
                contextM1377a = C0213f.m1377a();
            } catch (C9721b e10) {
                NotifyLogger.m29914e(TAG, "getConfig() exception:" + e10.toString());
                SpaceMultLanguageUtil.saveLanguageDownloadingFlag(false);
                if (NotifyUtil.procFlowControlException(e10, "HiCloudSpaceMultLanguage")) {
                    return;
                }
                if (e10.m60659c() == 304) {
                    NotifyLogger.m29914e(TAG, "HTTP_NOT_MODIFY extract sync module config");
                    return;
                } else {
                    if (!c5031y.isExceptionNeedRetry(e10) || i10 >= 2) {
                        return;
                    }
                    NotifyLogger.m29915i(TAG, "getLatestConfig exception retry, retry num: " + i10);
                }
            }
            if (contextM1377a == null) {
                NotifyLogger.m29914e(TAG, "getConfig() context is null.");
                return;
            }
            if (c5031y.getLatestConfig()) {
                NotifyLogger.m29915i(TAG, "requestConfig success");
                C9734g.m60767a().m60769c("HiCloudSpaceMultLanguage");
                SpaceMultLanguageUtil.saveLanguageDownloadingFlag(true);
                NotifyLogger.m29915i(TAG, "SpaceMultLanguageUtil.readConfigFromJson getFile" + contextM1377a.getFilesDir());
                downloadAndParseLanguageXml(contextM1377a, SpaceMultLanguageUtil.readConfigFromJson(contextM1377a.getFilesDir() + "/space_mult_language.json"));
                return;
            }
            NotifyLogger.m29914e(TAG, "query cloud notify config failed");
            SpaceMultLanguageUtil.saveLanguageDownloadingFlag(false);
            if (i10 >= 2) {
                return;
            }
            NotifyLogger.m29915i(TAG, "getLatestConfig failed retry, retry num: " + i10);
        }
    }

    private void getLanguageXml() throws NumberFormatException {
        Context contextM1377a = C0213f.m1377a();
        String str = contextM1377a.getFilesDir() + "/";
        if (new File(str + RecommendCardConstants.spaceLanguage.SPACE_MULT_LANGUAGE_XML_NAME_CLOUD).exists()) {
            return;
        }
        NotifyLogger.m29916w(TAG, "getLanguageXml spacLanguageFile is not exist,try agaign.");
        downloadAndParseLanguageXml(contextM1377a, SpaceMultLanguageUtil.readConfigFromJson(str + "space_mult_language.json"));
    }

    private void getVersion() throws NumberFormatException {
        C5031y c5031y = new C5031y(null);
        long configVersion = 0;
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
                configVersion = c5031y.getConfigVersion();
                NotifyLogger.m29915i(TAG, "requestConfigVersion latestVersion:" + configVersion);
                break;
            } catch (C9721b e10) {
                NotifyLogger.m29914e(TAG, ("requestConfigVersion exception:" + e10.toString()) + " retryNum = " + i10);
                if (!c5031y.isExceptionNeedRetry(e10) || i10 >= 2) {
                    return;
                }
                NotifyLogger.m29915i(TAG, "requestConfigVersion exception retry, retry num: " + i10);
            }
        }
        long jM68063f = C11327e.m68063f("HiCloudSpaceMultLanguage");
        NotifyLogger.m29915i(TAG, "configService localVersion:" + jM68063f);
        if (jM68063f < configVersion) {
            NotifyLogger.m29915i(TAG, "version updated, query config");
            getConfig();
        } else {
            NotifyLogger.m29916w(TAG, "getVersion fail. localVersion > latestVersion");
            getLanguageXml();
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws NumberFormatException {
        NotifyLogger.m29915i(TAG, "HiCloudSpaceMultLanguageTask call getVersion ");
        if (this.cmd == 1) {
            getVersion();
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.SPACE_MULT_LANGUAGE;
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public boolean syncLock() {
        return true;
    }
}

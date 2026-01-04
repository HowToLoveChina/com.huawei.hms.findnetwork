package com.huawei.hicloud.notification.manager;

import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.bean.HiCloudSpaceNoticeConfiguration;
import com.huawei.hicloud.notification.p106db.languageoperator.SpaceNoticeV3LanguageOperator;
import gp.C10028c;
import java.io.File;
import java.util.ArrayList;
import p015ak.C0209d;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p529op.C11984f;
import p616rk.AbstractRunnableC12516b;
import p709vj.C13452e;
import tj.C13019a;

/* loaded from: classes6.dex */
public class SpaceNoticeV3LangDownloader extends NoticeCfgLanguageBaseManager {
    private static final SpaceNoticeV3LangDownloader INSTANCE = new SpaceNoticeV3LangDownloader();
    private static final Object LOCK_OBJ = new Object();
    private static final String TAG = "SpaceNoticeV3LangDownloader";
    private volatile boolean isScreenOn = false;
    private long sleepTime = 0;
    private boolean isCpuReductionOpen = false;
    private boolean isHarmonyOSFour = false;
    private SpaceV3Listener spaceV3Listener = null;

    public class SpaceV3Listener implements C11984f.d {
        private SpaceV3Listener() {
        }

        @Override // p529op.C11984f.d
        public void onScreenOff() {
            NotifyLogger.m29915i(SpaceNoticeV3LangDownloader.TAG, "SpaceV3Listener:screen is off");
            SpaceNoticeV3LangDownloader.this.isScreenOn = false;
        }

        @Override // p529op.C11984f.d
        public void onScreenOn() {
            NotifyLogger.m29915i(SpaceNoticeV3LangDownloader.TAG, "SpaceV3Listener:screen is on");
            SpaceNoticeV3LangDownloader.this.isScreenOn = true;
        }

        @Override // p529op.C11984f.d
        public void onUserPresent() {
        }
    }

    public static SpaceNoticeV3LangDownloader getInstance() {
        return INSTANCE;
    }

    public void checkLanguageDataBase(HiCloudSpaceNoticeConfiguration hiCloudSpaceNoticeConfiguration) {
        if (hiCloudSpaceNoticeConfiguration == null) {
            NotifyLogger.m29914e(TAG, "No ExtraNoticeConfiguration");
            return;
        }
        String languageFilePath = getLanguageFilePath();
        if (!TextUtils.equals(hiCloudSpaceNoticeConfiguration.getCommonLanguage().getHash(), generateFileHash(languageFilePath))) {
            NotifyLogger.m29914e(TAG, "SpaceNoticeV3 language hash not equals");
            return;
        }
        if (!C10028c.m62182c0().m62204E()) {
            NotifyLogger.m29914e(TAG, "checkLanguageDataBase, languageDbStatus err, clear db");
            clearLanguageDb();
            C10028c.m62182c0().m62401u2(true);
        }
        if (!new File(languageFilePath).exists() || databaseHasRecord()) {
            return;
        }
        synchronized (LOCK_OBJ) {
            NotifyLogger.m29915i(TAG, "checkLanguageDataBase, need parseLanguageXml");
            parseLanguageFile(languageFilePath);
        }
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearCurrentLanguageDownloadResult() {
        C10028c.m62182c0().m62353l("space_notice_v3_download_result");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearLangVersionAndResult() {
        NotifyLogger.m29915i(TAG, "clear notice language");
        C10028c.m62182c0().m62353l("space_notice_v3_version");
        C10028c.m62182c0().m62353l("space_notice_v3_download_result");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearLanguageDb() throws SQLException {
        NotifyLogger.m29915i(TAG, "clearLanguageDb");
        new SpaceNoticeV3LanguageOperator().clear();
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public boolean databaseHasRecord() {
        try {
            return new SpaceNoticeV3LanguageOperator().hasRecord();
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "databaseHasRecord exceptions:" + e10.toString());
            return false;
        }
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public String getCurrentLanguageHash() {
        return C10028c.m62182c0().m62184A("space_notice_v3_hash");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public int getCurrentLanguageVersion() {
        return C10028c.m62182c0().m62189B("space_notice_v3_version");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public boolean getExtractResult() {
        return C10028c.m62182c0().m62324f0("space_notice_v3_download_result");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public String getLanguageFilePath() {
        return C0213f.m1377a().getFilesDir() + File.separator + "space_usage_notice_v3_language.xml";
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public AbstractRunnableC12516b.a getLanguageTaskEnum() {
        return AbstractRunnableC12516b.a.SPACE_V3_LANGUAGE_PARSE;
    }

    public Object getLockObj() {
        return LOCK_OBJ;
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public C11060c getStat() {
        if (this.stat == null) {
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07034"), "07034", C13452e.m80781L().m80971t0());
            this.stat = c11060cM66626a;
            c11060cM66626a.m66665u("0");
        }
        return this.stat;
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void insertLanguageToDB(ArrayList<CommonLanguageDbString> arrayList) {
        try {
            new SpaceNoticeV3LanguageOperator().batchInsert(arrayList);
        } catch (Exception e10) {
            String str = "insertDataToDB exceptions:" + e10.toString();
            NotifyLogger.m29914e(TAG, str);
            reportDownloadInfo("1", str, -1);
        }
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void onHashCheckSuccess(String str) {
        synchronized (LOCK_OBJ) {
            super.onHashCheckSuccess(str);
        }
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void printLog(String str) {
        NotifyLogger.m29915i(TAG, str);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void registerListener() {
        if (this.spaceV3Listener == null) {
            this.spaceV3Listener = new SpaceV3Listener();
            C11984f.m72128c().m72129b(this.spaceV3Listener);
            this.isScreenOn = C0209d.m1194N1(C0213f.m1377a());
            this.isHarmonyOSFour = C0209d.m1253f1();
            this.sleepTime = getConfigSleepTime();
            this.isCpuReductionOpen = isCpuReductionOpen();
            NotifyLogger.m29915i(TAG, "registerSpaceV3Listener, isScreenOn " + this.isScreenOn + ", isHarmonyOSFour " + this.isHarmonyOSFour + ", sleepTime " + this.sleepTime + ", isCpuReductionOpen " + this.isCpuReductionOpen);
        }
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setCurrentLanguageHash(String str) {
        C10028c.m62182c0().m62381q2("space_notice_v3_hash", str);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setCurrentLanguageVersion(int i10) {
        C10028c.m62182c0().m62386r2("space_notice_v3_version", i10);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setExtractResult(boolean z10) {
        C10028c.m62182c0().m62281U2("space_notice_v3_download_result", z10);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void tryToSleep() throws InterruptedException {
        if (this.isHarmonyOSFour && this.isCpuReductionOpen && this.sleepTime > 0 && this.isScreenOn && C13019a.m78347n().m78350l() <= 0) {
            NotifyLogger.m29915i(TAG, "tryToSleep");
            try {
                Thread.sleep(this.sleepTime);
            } catch (Exception e10) {
                NotifyLogger.m29914e(TAG, "tryToSleep exception: " + e10);
            }
        }
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void unregisterListener() {
        if (this.spaceV3Listener != null) {
            C11984f.m72128c().m72131e(this.spaceV3Listener);
            this.spaceV3Listener = null;
            NotifyLogger.m29915i(TAG, "unregisterSpaceV3Listener");
        }
    }
}

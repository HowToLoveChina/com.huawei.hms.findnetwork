package com.huawei.hicloud.notification.manager;

import android.database.SQLException;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguage;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.bean.HiCloudSpaceNoticeConfiguration;
import com.huawei.hicloud.notification.p106db.operator.H5LanguageConfigOperator;
import gp.C10028c;
import java.io.File;
import java.util.ArrayList;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p616rk.AbstractRunnableC12516b;
import p709vj.C13452e;

/* loaded from: classes6.dex */
public class H5ConfigLangDownloader extends NoticeCfgLanguageBaseManager {
    private static final H5ConfigLangDownloader INSTANCE = new H5ConfigLangDownloader();
    private static final String TAG = "H5ConfigLangDownloader";
    private String resourceId;

    public static H5ConfigLangDownloader getInstance() {
        return INSTANCE;
    }

    public void checkLanguageDataBase(HiCloudSpaceNoticeConfiguration hiCloudSpaceNoticeConfiguration) throws Throwable {
        if (hiCloudSpaceNoticeConfiguration == null) {
            NotifyLogger.m29914e(TAG, "No ExtraNoticeConfiguration");
            return;
        }
        String languageFilePath = getLanguageFilePath();
        if (!new File(languageFilePath).exists() || databaseHasRecord()) {
            return;
        }
        NotifyLogger.m29915i(TAG, "checkLanguageDataBase, need parseLanguageXml");
        parseLanguageFile(languageFilePath);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearCurrentLanguageDownloadResult() {
        C10028c.m62182c0().m62353l("h5_language_download_result");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearLangVersionAndResult() {
        NotifyLogger.m29915i(TAG, "clear notice language");
        C10028c.m62182c0().m62353l("h5_language_version");
        C10028c.m62182c0().m62353l("h5_language_download_result");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearLanguageDb() throws SQLException {
        new H5LanguageConfigOperator().clear();
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public boolean databaseHasRecord() {
        try {
            return new H5LanguageConfigOperator().hasRecord();
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "databaseHasRecord exceptions:" + e10.toString());
            return false;
        }
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void downloadAndParseLanguage(CommonLanguage commonLanguage, int i10) {
        new NoticeCfgLanguageBaseManager.LanguageTask(commonLanguage, i10, getLanguageFilePath()).call();
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public String getCurrentLanguageHash() {
        return C10028c.m62182c0().m62184A("h5_language_hash");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public int getCurrentLanguageVersion() {
        return C10028c.m62182c0().m62189B("h5_language_version");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public boolean getExtractResult() {
        return C10028c.m62182c0().m62324f0("h5_language_download_result");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public String getLanguageFilePath() {
        return C0213f.m1377a().getFilesDir() + File.separator + "h5_language.xml";
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public AbstractRunnableC12516b.a getLanguageTaskEnum() {
        return AbstractRunnableC12516b.a.SYNC_CONFIG;
    }

    public String getResourceId() {
        return this.resourceId;
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public C11060c getStat() {
        if (this.stat == null) {
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07036"), "07036", C13452e.m80781L().m80971t0());
            this.stat = c11060cM66626a;
            c11060cM66626a.m66665u("0");
        }
        return this.stat;
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void insertLanguageToDB(ArrayList<CommonLanguageDbString> arrayList) {
        try {
            new H5LanguageConfigOperator().batchInsert(arrayList);
        } catch (Exception e10) {
            String str = "insertDataToDB exceptions:" + e10.toString();
            NotifyLogger.m29914e(TAG, str);
            reportDownloadInfo("1", str, -1);
        }
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setCurrentLanguageHash(String str) {
        C10028c.m62182c0().m62381q2("h5_language_hash", str);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setCurrentLanguageVersion(int i10) {
        C10028c.m62182c0().m62386r2("h5_language_version", i10);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setExtractResult(boolean z10) {
        C10028c.m62182c0().m62281U2("h5_language_download_result", z10);
    }

    public void setResourceId(String str) {
        this.resourceId = str;
    }
}

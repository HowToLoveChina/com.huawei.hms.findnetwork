package com.huawei.hicloud.notification.manager;

import android.database.SQLException;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.languageoperator.HiCloudUpgradeNoticeLanguageOperator;
import gp.C10028c;
import java.io.File;
import java.util.ArrayList;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p616rk.AbstractRunnableC12516b;
import p709vj.C13452e;

/* loaded from: classes6.dex */
public class HiCloudUpgradeNoticeLangDownloader extends NoticeCfgLanguageBaseManager {
    private static final String HI_CLOUDUPGRADE_DIR = "HiCloudUpgrade";
    private static final HiCloudUpgradeNoticeLangDownloader INSTANCE = new HiCloudUpgradeNoticeLangDownloader();
    private static final Object LOCK_OBJ = new Object();
    private static final String TAG = "HiCloudUpgradeNoticeLangDownloader";
    private String hiCloudUpgradeId;

    public HiCloudUpgradeNoticeLangDownloader(String str) {
        this.hiCloudUpgradeId = str;
    }

    public static HiCloudUpgradeNoticeLangDownloader getInstance() {
        return INSTANCE;
    }

    public static String getV5LanguageDir() {
        return C0213f.m1377a().getFilesDir() + File.separator + HI_CLOUDUPGRADE_DIR;
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearCurrentLanguageDownloadResult() {
        C10028c.m62182c0().m62353l(this.hiCloudUpgradeId + "_hicloud_upgrade_notice_download_result");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearLangVersionAndResult() {
        NotifyLogger.m29915i(TAG, "clear notice language");
        C10028c.m62182c0().m62353l("_hicloud_upgrade_notice_version");
        C10028c.m62182c0().m62353l("_hicloud_upgrade_notice_download_result");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearLanguageDb() throws SQLException {
        NotifyLogger.m29915i(TAG, "clearLanguageDb");
        new HiCloudUpgradeNoticeLanguageOperator().clear(this.hiCloudUpgradeId);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public boolean databaseHasRecord() {
        try {
            return new HiCloudUpgradeNoticeLanguageOperator().hasRecord();
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "databaseHasRecord exceptions:" + e10);
            return false;
        }
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public String getCurrentLanguageHash() {
        return C10028c.m62182c0().m62184A(this.hiCloudUpgradeId + "_hicloud_upgrade_notice_hash");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public int getCurrentLanguageVersion() {
        return C10028c.m62182c0().m62189B(this.hiCloudUpgradeId + "_hicloud_upgrade_notice_version");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public boolean getExtractResult() {
        return C10028c.m62182c0().m62324f0(this.hiCloudUpgradeId + "_hicloud_upgrade_notice_download_result");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public String getLanguageFilePath() {
        return getV5LanguageDir() + File.separator + this.hiCloudUpgradeId + "_hicloud_upgrade_notice_language.xml";
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public AbstractRunnableC12516b.a getLanguageTaskEnum() {
        return AbstractRunnableC12516b.a.HICLOUD_UPGRADE;
    }

    public Object getLockObj() {
        return LOCK_OBJ;
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public C11060c getStat() {
        if (this.stat == null) {
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07071"), "07071", C13452e.m80781L().m80971t0());
            this.stat = c11060cM66626a;
            c11060cM66626a.m66665u("0");
        }
        return this.stat;
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void insertLanguageToDB(ArrayList<CommonLanguageDbString> arrayList) {
        try {
            new HiCloudUpgradeNoticeLanguageOperator().batchInsert(arrayList);
        } catch (Exception e10) {
            String str = "insertDataToDB exceptions:" + e10;
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
    public void setCurrentLanguageHash(String str) {
        C10028c.m62182c0().m62381q2(this.hiCloudUpgradeId + "_hicloud_upgrade_notice_hash", str);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setCurrentLanguageVersion(int i10) {
        C10028c.m62182c0().m62386r2(this.hiCloudUpgradeId + "_hicloud_upgrade_notice_version", i10);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setExtractResult(boolean z10) {
        C10028c.m62182c0().m62281U2(this.hiCloudUpgradeId + "_hicloud_upgrade_notice_download_result", z10);
    }

    public HiCloudUpgradeNoticeLangDownloader() {
    }
}

package com.huawei.hicloud.notification.manager;

import android.database.SQLException;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.languageoperator.BackupSpaceInsuffWindowNoticeLanguageOperator;
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
public class BackupSpaceV5WindowNoticeLangDownloader extends NoticeCfgLanguageBaseManager {
    private static final BackupSpaceV5WindowNoticeLangDownloader INSTANCE = new BackupSpaceV5WindowNoticeLangDownloader();
    private static final Object LOCK_OBJ = new Object();
    private static final String TAG = "BackupSpaceInsuffWindowNoticeLocalLangDownloader";
    private static final String V5_LANGUAGE_DIR = "v5Language";
    private String backupSpaceInsufficientId;
    private volatile boolean isScreenOn = false;
    private long sleepTime = 0;
    private boolean isCpuReductionOpen = false;
    private boolean isHarmonyOSFour = false;
    private SpaceV5Listener spaceV5Listener = null;

    public class SpaceV5Listener implements C11984f.d {
        private SpaceV5Listener() {
        }

        @Override // p529op.C11984f.d
        public void onScreenOff() {
            NotifyLogger.m29915i(BackupSpaceV5WindowNoticeLangDownloader.TAG, "SpaceV4Listener:screen is off");
            BackupSpaceV5WindowNoticeLangDownloader.this.isScreenOn = false;
        }

        @Override // p529op.C11984f.d
        public void onScreenOn() {
            NotifyLogger.m29915i(BackupSpaceV5WindowNoticeLangDownloader.TAG, "SpaceV4Listener:screen is on");
            BackupSpaceV5WindowNoticeLangDownloader.this.isScreenOn = true;
        }

        @Override // p529op.C11984f.d
        public void onUserPresent() {
        }

        public /* synthetic */ SpaceV5Listener(BackupSpaceV5WindowNoticeLangDownloader backupSpaceV5WindowNoticeLangDownloader, C49161 c49161) {
            this();
        }
    }

    public BackupSpaceV5WindowNoticeLangDownloader(String str) {
        this.backupSpaceInsufficientId = str;
    }

    public static BackupSpaceV5WindowNoticeLangDownloader getInstance() {
        return INSTANCE;
    }

    public static String getV5LanguageDir() {
        return C0213f.m1377a().getFilesDir() + File.separator + V5_LANGUAGE_DIR;
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearCurrentLanguageDownloadResult() {
        C10028c.m62182c0().m62353l(this.backupSpaceInsufficientId + "_backup_space_Insuff_window_notice_download_result");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearLangVersionAndResult() {
        NotifyLogger.m29915i(TAG, "clear notice language");
        C10028c.m62182c0().m62353l("_backup_space_Insuff_window_notice_version");
        C10028c.m62182c0().m62353l("_backup_space_Insuff_window_notice_download_result");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearLanguageDb() throws SQLException {
        NotifyLogger.m29915i(TAG, "clearLanguageDb");
        new BackupSpaceInsuffWindowNoticeLanguageOperator().clear(this.backupSpaceInsufficientId);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public boolean databaseHasRecord() {
        try {
            return new BackupSpaceInsuffWindowNoticeLanguageOperator().hasRecord();
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "databaseHasRecord exceptions:" + e10);
            return false;
        }
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public String getCurrentLanguageHash() {
        return C10028c.m62182c0().m62184A(this.backupSpaceInsufficientId + "_backup_space_Insuff_window_notice_hash");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public int getCurrentLanguageVersion() {
        return C10028c.m62182c0().m62189B(this.backupSpaceInsufficientId + "_backup_space_Insuff_window_notice_version");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public boolean getExtractResult() {
        return C10028c.m62182c0().m62324f0(this.backupSpaceInsufficientId + "_backup_space_Insuff_window_notice_download_result");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public String getLanguageFilePath() {
        return getV5LanguageDir() + File.separator + this.backupSpaceInsufficientId + "_backup_space_Insuff_window_notice_language.xml";
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public AbstractRunnableC12516b.a getLanguageTaskEnum() {
        return AbstractRunnableC12516b.a.SPACE_V5_LANGUAGE_PARSE;
    }

    public Object getLockObj() {
        return LOCK_OBJ;
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public C11060c getStat() {
        if (this.stat == null) {
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07062"), "07062", C13452e.m80781L().m80971t0());
            this.stat = c11060cM66626a;
            c11060cM66626a.m66665u("0");
        }
        return this.stat;
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void insertLanguageToDB(ArrayList<CommonLanguageDbString> arrayList) {
        try {
            new BackupSpaceInsuffWindowNoticeLanguageOperator().batchInsert(arrayList);
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
    public void registerListener() {
        if (this.spaceV5Listener == null) {
            this.spaceV5Listener = new SpaceV5Listener();
            C11984f.m72128c().m72129b(this.spaceV5Listener);
            this.isScreenOn = C0209d.m1194N1(C0213f.m1377a());
            this.isHarmonyOSFour = C0209d.m1253f1();
            this.sleepTime = getConfigSleepTime();
            this.isCpuReductionOpen = isCpuReductionOpen();
            NotifyLogger.m29915i(TAG, "registerSpaceV4Listener, isScreenOn " + this.isScreenOn + ", isHarmonyOSFour " + this.isHarmonyOSFour + ", sleepTime " + this.sleepTime + ", isCpuReductionOpen " + this.isCpuReductionOpen);
        }
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setCurrentLanguageHash(String str) {
        C10028c.m62182c0().m62381q2(this.backupSpaceInsufficientId + "_backup_space_Insuff_window_notice_hash", str);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setCurrentLanguageVersion(int i10) {
        C10028c.m62182c0().m62386r2(this.backupSpaceInsufficientId + "_backup_space_Insuff_window_notice_version", i10);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setExtractResult(boolean z10) {
        C10028c.m62182c0().m62281U2(this.backupSpaceInsufficientId + "_backup_space_Insuff_window_notice_download_result", z10);
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
        if (this.spaceV5Listener != null) {
            C11984f.m72128c().m72131e(this.spaceV5Listener);
            this.spaceV5Listener = null;
            NotifyLogger.m29915i(TAG, "unregisterSpaceV4Listener");
        }
    }

    public BackupSpaceV5WindowNoticeLangDownloader() {
    }
}

package com.huawei.android.hicloud.cloudbackup.process.task;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.bean.AppInfoList;
import com.huawei.android.hicloud.cloudbackup.bean.BackupConfig;
import com.huawei.android.hicloud.cloudbackup.bean.BlackModules;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupConfig;
import com.huawei.android.hicloud.cloudbackup.bean.HiCloudAppFilesBean;
import com.huawei.android.hicloud.cloudbackup.bean.Language;
import com.huawei.android.hicloud.cloudbackup.bean.RuleConfig;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import fk.C9721b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p292fn.C9734g;
import p459lp.C11327e;
import p459lp.C11329g;
import p495nm.C11720a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p617rl.C12517a;
import p617rl.C12519c;
import p617rl.C12520d;
import p617rl.C12521e;
import p617rl.C12522f;
import p617rl.C12526j;
import p618rm.C12585q1;
import p684un.C13225d;
import p711vl.C13465e;
import p711vl.C13466f;

/* loaded from: classes2.dex */
public class QueryOmAppBackupScopeTask extends AbstractC12367d {
    private static final String TAG = "QueryOmAppBackupScopeTask";
    private JSONObject cloudBackupConfigParams;
    private long latestVersion;
    private long localVersion;
    private boolean retryDownloadJson;

    public QueryOmAppBackupScopeTask() {
        this.cloudBackupConfigParams = new JSONObject();
        this.retryDownloadJson = false;
        this.localVersion = 0L;
        this.latestVersion = 0L;
    }

    private void createTempTable(SQLiteDatabase sQLiteDatabase) throws C9721b, SQLException {
        execSQL(sQLiteDatabase, "create table if not exists app_config_version_temp(id text not null,date text not null,version integer,data text)");
        execSQL(sQLiteDatabase, "create table if not exists cloud_backup_om_config_temp(name text,value text)");
        execSQL(sQLiteDatabase, "create table if not exists app_file_info_temp(id text not null,appId text not null,appType integer,appName text,appIcon text,listType integer,appVer text,appVersRegex text,emuiVersRegex text,devCompatible integer,include text,exclude text,wakeUpService text,skipWhenInsuff integer,supportOsVersRegex integer,osVersRegex text,priority integer,foregroundBackup integer,foregroundBackupTime text,minClientVersion integer,effectDevice text,effectPackage text,sdcardAcptErrNum integer,sdcardAcptErrRate integer,dataAcptErrNum integer,dataAcptErrRate integer,isSupportTwinApp integer,data1 text,data2 text,data3 text,data4 text,data5 text,data6 text,primary key(id))");
        execSQL(sQLiteDatabase, "create table if not exists app_restore_sequence_temp(appId text not null,sequence text)");
        execSQL(sQLiteDatabase, "create table if not exists app_restore_thread_sequence_temp(appId text not null,sequence text)");
        execSQL(sQLiteDatabase, "create table if not exists cloud_restore_config_temp(id text not null,appId text not null,appVer text not null,appVersRegex text,exclude text, data text,primary key(id))");
    }

    private void deletePrimalTable(SQLiteDatabase sQLiteDatabase) throws C9721b, SQLException {
        execSQL(sQLiteDatabase, "delete from app_config_version");
        execSQL(sQLiteDatabase, "delete from cloud_backup_om_config");
        execSQL(sQLiteDatabase, "delete from app_file_info");
        execSQL(sQLiteDatabase, "delete from app_restore_sequence");
        execSQL(sQLiteDatabase, "delete from app_restore_thread_sequence");
        execSQL(sQLiteDatabase, "delete from cloud_restore_config");
    }

    private void dropTempTableExecSql(SQLiteDatabase sQLiteDatabase) throws C9721b, SQLException {
        execSQL(sQLiteDatabase, "drop table if exists app_config_version_temp");
        execSQL(sQLiteDatabase, "drop table if exists cloud_backup_om_config_temp");
        execSQL(sQLiteDatabase, "drop table if exists app_file_info_temp");
        execSQL(sQLiteDatabase, "drop table if exists app_restore_sequence_temp");
        execSQL(sQLiteDatabase, "drop table if exists app_restore_thread_sequence_temp");
        execSQL(sQLiteDatabase, "drop table if exists cloud_restore_config_temp");
    }

    private BlackModules getBlackModules(HiCloudAppFilesBean hiCloudAppFilesBean) {
        CloudBackupConfig cloudBackupConfig = hiCloudAppFilesBean.getCloudBackupConfig();
        if (cloudBackupConfig == null) {
            C11839m.m70688i(TAG, "cloud backup config is null.");
            return null;
        }
        BackupConfig cloudBackup = cloudBackupConfig.getCloudBackup();
        if (cloudBackup == null) {
            C11839m.m70688i(TAG, "backup config is null.");
            return null;
        }
        RuleConfig ruleConfig = cloudBackup.getRuleConfig();
        if (ruleConfig == null) {
            C11839m.m70688i(TAG, "rule config is null.");
            return null;
        }
        List<BlackModules> appDataBlackModule = ruleConfig.getAppDataBlackModule();
        if (appDataBlackModule == null || appDataBlackModule.size() == 0) {
            C11839m.m70688i(TAG, "black modules list is empty.");
            return null;
        }
        BlackModules blackModules = appDataBlackModule.get(0);
        if (blackModules != null) {
            return blackModules;
        }
        C11839m.m70688i(TAG, "black modules is null.");
        return null;
    }

    private void getConfig(C11329g c11329g) {
        if (c11329g == null) {
            c11329g = new C11329g(null);
        }
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "get HiCloudAppFiles config exception: " + e10.toString());
                if (NotifyUtil.procFlowControlException(e10, "HiCloudAppFiles")) {
                    report("flow control, version: " + this.localVersion + ", latestVersion: " + this.latestVersion);
                    return;
                }
                if (e10.m60659c() == 304) {
                    C11839m.m70687e(TAG, "HiCloudAppFiles HTTP_NOT_MODIFY extract sync module config");
                } else if ((c11329g.isExceptionNeedRetry(e10) && i10 < 2) || e10.m60659c() == 3312) {
                    C11839m.m70688i(TAG, "HiCloudAppFiles getLatestConfig exception retry, retry num: " + i10);
                }
                report("getConfig error " + e10.toString() + ", version: " + this.localVersion + ", latestVersion: " + this.latestVersion);
                return;
            }
            if (c11329g.getLatestConfig()) {
                C11839m.m70688i(TAG, "get HiCloudAppFiles config success");
                C9734g.m60767a().m60769c("HiCloudAppFiles");
                readConfigFile();
                return;
            }
            C11839m.m70687e(TAG, "get HiCloudAppFiles config failed");
            if (i10 >= 2) {
                report("get HiCloudAppFiles config failed, version: " + this.localVersion + ", latestVersion: " + this.latestVersion);
                return;
            }
            C11839m.m70688i(TAG, "getLatestConfig failed retry, retry num: " + i10);
        }
    }

    private void getVersion() {
        C11329g c11329g = new C11329g(null);
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
                this.latestVersion = c11329g.getConfigVersion();
                break;
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "get HiCloudAppFiles config version exception: " + e10.toString());
                if (!c11329g.isExceptionNeedRetry(e10) || i10 >= 2) {
                    report("getVersion error " + e10.toString());
                    return;
                }
                C11839m.m70688i(TAG, "get HiCloudAppFiles config version exception retry, retry num: " + i10);
            }
        }
        long jM68063f = C11327e.m68063f("HiCloudAppFiles");
        this.localVersion = jM68063f;
        if (jM68063f < this.latestVersion) {
            C11839m.m70688i(TAG, "HiCloudAppFiles version updated, query config");
            getConfig(c11329g);
            return;
        }
        C11839m.m70689w(TAG, "getVersion fail. localVersion > latestVersion");
        try {
            readConfigFile();
        } catch (C9721b e11) {
            C11839m.m70687e(TAG, "read config file error: " + e11.getMessage());
            report("read config file error: " + e11.toString() + ", version: " + this.localVersion + ", latestVersion: " + this.latestVersion);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void parseBackupOmConfig(com.huawei.android.hicloud.cloudbackup.bean.HiCloudAppFilesBean r7, com.huawei.android.hicloud.cloudbackup.bean.CloudBackupConfig r8) throws fk.C9721b, android.database.SQLException {
        /*
            r6 = this;
            java.lang.String r0 = "parse backup omConfig start."
            java.lang.String r1 = "QueryOmAppBackupScopeTask"
            p514o9.C11839m.m70688i(r1, r0)
            ul.j$c r0 = p682ul.C13216j.c.SETTING
            r2 = 0
            android.database.sqlite.SQLiteDatabase r0 = p682ul.C13216j.m79427l(r0, r2)
            if (r0 == 0) goto L58
            vl.f r2 = p711vl.C13466f.m81073d()
            java.lang.String r3 = "backup_read_om_config_state"
            r4 = -1
            int r2 = r2.m81077e(r3, r4)
            if (r2 == r4) goto L34
            if (r2 == 0) goto L34
            r5 = 1
            if (r2 == r5) goto L29
            r5 = 2
            if (r2 == r5) goto L34
            r5 = 3
            if (r2 == r5) goto L29
            goto L52
        L29:
            r6.replacePrimalTableByOm(r7, r8, r0)
            vl.f r6 = p711vl.C13466f.m81073d()
            r6.m81082j(r3, r4)
            goto L52
        L34:
            r6.dropTempTableExecSql(r0)
            r6.createTempTable(r0)
            vl.f r2 = p711vl.C13466f.m81073d()
            r5 = 0
            r2.m81082j(r3, r5)
            r6.replaceTempTable(r0)
            r6.replacePrimalTableByOm(r7, r8, r0)
            vl.f r7 = p711vl.C13466f.m81073d()
            r7.m81082j(r3, r4)
            r6.dropTempTableExecSql(r0)
        L52:
            java.lang.String r6 = "parse backup omConfig end."
            p514o9.C11839m.m70688i(r1, r6)
            return
        L58:
            java.lang.String r6 = "database is null."
            p514o9.C11839m.m70689w(r1, r6)
            java.lang.String r7 = "parseBackupOmConfig database is null."
            com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport.reportOmError(r7)
            fk.b r7 = new fk.b
            r8 = 1012(0x3f4, float:1.418E-42)
            java.lang.String r0 = "execSQL"
            r7.<init>(r8, r6, r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.task.QueryOmAppBackupScopeTask.parseBackupOmConfig(com.huawei.android.hicloud.cloudbackup.bean.HiCloudAppFilesBean, com.huawei.android.hicloud.cloudbackup.bean.CloudBackupConfig):void");
    }

    private void parseBlackModules(HiCloudAppFilesBean hiCloudAppFilesBean) {
        BlackModules blackModules = getBlackModules(hiCloudAppFilesBean);
        if (blackModules == null) {
            C11839m.m70688i(TAG, "black modules is null, parse local property file.");
            new BackupAppLanguageDownloader(C0213f.m1377a(), "", "").parseLocalPropertiesFile();
            return;
        }
        if (!C11327e.m68060c("hicloud_black_module_config_fix", false)) {
            C11839m.m70688i(TAG, "do black module config fix");
            C11327e.m68071n("HiCloudMsgBlackModuleConfig", 0L);
            C11327e.m68066i("hicloud_black_module_config_fix", true);
        }
        long version = blackModules.getVersion();
        long jM68063f = C11327e.m68063f("HiCloudMsgBlackModuleConfig");
        BackupAppLanguageDownloader backupAppLanguageDownloader = new BackupAppLanguageDownloader(C0213f.m1377a(), blackModules.getUrl(), blackModules.getHash());
        if (jM68063f >= version) {
            C11839m.m70688i(TAG, "localVersion > latestVersion read properties file.");
            backupAppLanguageDownloader.parseBlackModuleAndInsertDB(new File(backupAppLanguageDownloader.getBlackModulePath()));
            return;
        }
        C11839m.m70688i(TAG, "localVersion < lastVersion download and read properties file.");
        try {
            if (backupAppLanguageDownloader.startDownloadBlackModule()) {
                C11327e.m68071n("HiCloudMsgBlackModuleConfig", version);
            } else {
                C11839m.m70687e(TAG, "download black modules failed.");
                backupAppLanguageDownloader.parseLocalPropertiesFile();
            }
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "download black modules error: " + e10.toString());
            backupAppLanguageDownloader.parseLocalPropertiesFile();
        }
    }

    private HiCloudAppFilesBean readConfigFromJson(String str) throws C9721b, IOException {
        File file = new File(str);
        HiCloudAppFilesBean hiCloudAppFilesBean = new HiCloudAppFilesBean();
        if (!file.exists()) {
            C11839m.m70688i(TAG, "Config file not exist");
            CloudBackupReport.reportOmError("Config file not exist");
            return hiCloudAppFilesBean;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                String strM1290o2 = C0209d.m1290o2(fileInputStream);
                this.cloudBackupConfigParams = new JSONObject(strM1290o2).getJSONObject("cloudBackupConfig");
                HiCloudAppFilesBean hiCloudAppFilesBean2 = (HiCloudAppFilesBean) new Gson().fromJson(strM1290o2, HiCloudAppFilesBean.class);
                fileInputStream.close();
                return hiCloudAppFilesBean2;
            } finally {
            }
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "read config from json error, msg:" + e10.getMessage());
            CloudBackupReport.reportOmError("read config from json error, msg:" + e10.getMessage());
            throw new C9721b(3312, "read config from json error", "readConfigFromJson");
        }
    }

    private void replacePrimalTableByOm(HiCloudAppFilesBean hiCloudAppFilesBean, CloudBackupConfig cloudBackupConfig, SQLiteDatabase sQLiteDatabase) throws C9721b, SQLException {
        try {
            deletePrimalTable(sQLiteDatabase);
            new C12517a().m75223c(hiCloudAppFilesBean);
            C12526j c12526j = new C12526j();
            c12526j.m75398i1(this.cloudBackupConfigParams);
            c12526j.m75383d();
            new C12520d().m75311d(c12526j.m75379b1(cloudBackupConfig));
            C12519c c12519c = new C12519c();
            List<AppInfoList> appInfoList = hiCloudAppFilesBean.getAppInfoList();
            if (appInfoList.isEmpty()) {
                CloudBackupReport.reportOmError("appFilesBean appInfoList is empty");
            }
            c12519c.m75307r(appInfoList);
            new C12521e().m75315d(cloudBackupConfig.getRestoreSequence());
            new C12522f().m75319d(cloudBackupConfig.getRestoreThreadSeq());
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "operator update failed, error: " + e10.getMessage());
            report("replacePrimalTableByOm error: " + e10.toString());
            C13466f.m81073d().m81082j("backup_read_om_config_state", 3);
            rollBackPrimalTable(sQLiteDatabase);
        }
    }

    private void replacePrimalTableExecSql(SQLiteDatabase sQLiteDatabase) throws C9721b, SQLException {
        execSQL(sQLiteDatabase, "replace into app_config_version select * from app_config_version_temp");
        execSQL(sQLiteDatabase, "replace into cloud_backup_om_config select * from cloud_backup_om_config_temp");
        execSQL(sQLiteDatabase, "replace into app_file_info select * from app_file_info_temp");
        execSQL(sQLiteDatabase, "replace into app_restore_sequence select * from app_restore_sequence_temp");
        execSQL(sQLiteDatabase, "replace into app_restore_thread_sequence select * from app_restore_thread_sequence_temp");
        execSQL(sQLiteDatabase, "replace into cloud_restore_config select * from cloud_restore_config_temp");
    }

    private void replaceTempTable(SQLiteDatabase sQLiteDatabase) throws C9721b, SQLException {
        try {
            replaceTempTableExecSql(sQLiteDatabase);
            C13466f.m81073d().m81082j("backup_read_om_config_state", 1);
        } catch (C9721b e10) {
            C13466f.m81073d().m81082j("backup_read_om_config_state", 2);
            dropTempTableExecSql(sQLiteDatabase);
            C13466f.m81073d().m81082j("backup_read_om_config_state", -1);
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "replace temp table error: " + e10.toString());
        }
    }

    private void replaceTempTableExecSql(SQLiteDatabase sQLiteDatabase) throws C9721b, SQLException {
        execSQL(sQLiteDatabase, "replace into app_config_version_temp select * from app_config_version");
        execSQL(sQLiteDatabase, "replace into cloud_backup_om_config_temp select * from cloud_backup_om_config");
        execSQL(sQLiteDatabase, "replace into app_file_info_temp select * from app_file_info");
        execSQL(sQLiteDatabase, "replace into app_restore_sequence_temp select * from app_restore_sequence");
        execSQL(sQLiteDatabase, "replace into app_restore_thread_sequence_temp select * from app_restore_thread_sequence");
        execSQL(sQLiteDatabase, "replace into cloud_restore_config_temp select * from cloud_restore_config");
    }

    private void report(String str) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("errorReason", str);
        C13225d.m79490f1().m79591l0("backup_om_error", linkedHashMap);
        C13225d.m79490f1().m79573U("backup_om_error", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "backup_om_error", linkedHashMap);
    }

    private void retryDownload(File file) {
        if (this.retryDownloadJson) {
            C11839m.m70688i(TAG, "retryDownload config.");
            C11327e.m68067j("HiCloudAppFiles", "");
            C11327e.m68071n("HiCloudAppFiles", 0L);
            if (file != null && file.exists()) {
                file.delete();
            }
            new QueryOmAppBackupScopeTask(false).call();
        }
    }

    private void rollBackPrimalTable(SQLiteDatabase sQLiteDatabase) throws C9721b, SQLException {
        int i10 = 0;
        while (i10 <= 2) {
            try {
                deletePrimalTable(sQLiteDatabase);
                replacePrimalTableExecSql(sQLiteDatabase);
                break;
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "roll back has error: " + e10.getMessage());
                i10++;
            }
        }
        C13466f.m81073d().m81082j("backup_read_om_config_state", -1);
        dropTempTableExecSql(sQLiteDatabase);
        C11839m.m70688i(TAG, "roll back retry times: " + i10);
        if (i10 > 2) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "exec roll back primal table error. ");
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C11839m.m70688i(TAG, "start dowload HiCloudAppFiles config");
        getVersion();
    }

    public void execSQL(SQLiteDatabase sQLiteDatabase, String str) throws C9721b, SQLException {
        try {
            sQLiteDatabase.execSQL(str);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "exec sql error." + e10.getMessage());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "exec sql error. " + e10.getMessage(), "execSQL");
        }
    }

    public void parseBackupConfig(String str) throws C9721b, IOException, SQLException {
        HiCloudAppFilesBean configFromJson = readConfigFromJson(str);
        if (configFromJson == null) {
            C11839m.m70687e(TAG, "app files bean is null.");
            CloudBackupReport.reportOmError("app files bean is null., version: " + this.localVersion + ", latestVersion: " + this.latestVersion);
            C11327e.m68059b("HiCloudAppFiles");
            return;
        }
        CloudBackupConfig cloudBackupConfig = configFromJson.getCloudBackupConfig();
        if (cloudBackupConfig == null) {
            C11839m.m70687e(TAG, "app files config error, no need to parse backup config.");
            CloudBackupReport.reportOmError("app files config error, no need to parse backup config., version: " + this.localVersion + ", latestVersion: " + this.latestVersion);
            C11327e.m68059b("HiCloudAppFiles");
            return;
        }
        parseBlackModules(configFromJson);
        Language language = configFromJson.getLanguage();
        if (language == null) {
            C11839m.m70688i(TAG, "language is null");
        } else {
            long version = language.getVersion();
            long jM68063f = C11327e.m68063f("HiCloudAppFilesLanguage");
            BackupAppLanguageDownloader backupAppLanguageDownloader = new BackupAppLanguageDownloader(C0213f.m1377a(), language.getUrl(), language.getHash());
            if (jM68063f < version) {
                C11839m.m70688i(TAG, "localVersion < lastVersion download xml file");
                try {
                    if (backupAppLanguageDownloader.start()) {
                        C11327e.m68071n("HiCloudAppFilesLanguage", version);
                    } else {
                        File file = new File(C0213f.m1377a().getFilesDir() + "/hicloud_backup_app_language.xml");
                        if (file.exists() && file.delete()) {
                            C11839m.m70688i(TAG, "parse language failed, delete local language xml file successfully");
                        }
                        C11839m.m70687e(TAG, "downloadAndParseLanguageXml BackupAppLanguageDownload failed.");
                    }
                } catch (C9721b e10) {
                    String str2 = "download language failed: " + e10.toString();
                    C11839m.m70687e(TAG, str2);
                    CloudBackupReport.reportOmError(str2 + ", version: " + this.localVersion + ", latestVersion: " + this.latestVersion);
                }
            } else {
                C11839m.m70688i(TAG, "localVersion >= latestVersion read local path xml");
                backupAppLanguageDownloader.clearDB();
                if (!backupAppLanguageDownloader.parseLanguageXmlAndInsertDB(C0213f.m1377a().getFilesDir() + File.separator + "hicloud_backup_app_language.xml")) {
                    return;
                }
            }
        }
        parseBackupOmConfig(configFromJson, cloudBackupConfig);
        CloudBackup3rdIconUtil.downloadVirtualIcon();
        C11720a.m69921a().m69923c();
        C12585q1.m75696f();
    }

    public void readConfigFile() throws C9721b {
        C11839m.m70688i(TAG, "readConfigFile");
        if (C13465e.m81052f().m81058g("firsOmTime", 0L) == 0) {
            C13465e.m81052f().m81065n("firsOmTime", System.currentTimeMillis());
        }
        parseBackupConfig(C0213f.m1377a().getFilesDir() + File.separator + "HiCloudAppFiles.json");
    }

    public QueryOmAppBackupScopeTask(boolean z10) {
        this.cloudBackupConfigParams = new JSONObject();
        this.localVersion = 0L;
        this.latestVersion = 0L;
        this.retryDownloadJson = z10;
    }
}

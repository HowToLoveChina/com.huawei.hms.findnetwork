package kp;

import android.database.SQLException;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.HiCloudMsgNoticeLangDownloader;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.languageoperator.TextLinkLanguageOperator;
import gp.C10028c;
import java.io.File;
import java.util.ArrayList;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p616rk.AbstractRunnableC12516b;
import p709vj.C13452e;

/* renamed from: kp.c */
/* loaded from: classes7.dex */
public class C11127c extends HiCloudMsgNoticeLangDownloader {
    @Override // com.huawei.hicloud.notification.manager.HiCloudMsgNoticeLangDownloader, com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearCurrentLanguageDownloadResult() {
        C10028c.m62182c0().m62353l("text_link_language_download_result");
    }

    @Override // com.huawei.hicloud.notification.manager.HiCloudMsgNoticeLangDownloader, com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearLangVersionAndResult() {
        NotifyLogger.m29915i("TextLinkLanguageManager", "clear notice language");
        C10028c.m62182c0().m62353l("text_link_language_version");
        C10028c.m62182c0().m62353l("text_link_language_download_result");
    }

    @Override // com.huawei.hicloud.notification.manager.HiCloudMsgNoticeLangDownloader, com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearLanguageDb() throws SQLException {
        NotifyLogger.m29915i("TextLinkLanguageManager", "clearLanguageDb");
        new TextLinkLanguageOperator().clear();
    }

    @Override // com.huawei.hicloud.notification.manager.HiCloudMsgNoticeLangDownloader, com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public boolean databaseHasRecord() {
        try {
            return new TextLinkLanguageOperator().hasRecord();
        } catch (Exception e10) {
            NotifyLogger.m29914e("TextLinkLanguageManager", "databaseHasRecord exceptions:" + e10.toString());
            return false;
        }
    }

    @Override // com.huawei.hicloud.notification.manager.HiCloudMsgNoticeLangDownloader, com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public String getCurrentLanguageHash() {
        return C10028c.m62182c0().m62184A("text_link_language_hash");
    }

    @Override // com.huawei.hicloud.notification.manager.HiCloudMsgNoticeLangDownloader, com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public int getCurrentLanguageVersion() {
        return C10028c.m62182c0().m62189B("text_link_language_version");
    }

    @Override // com.huawei.hicloud.notification.manager.HiCloudMsgNoticeLangDownloader, com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public boolean getExtractResult() {
        return C10028c.m62182c0().m62324f0("text_link_language_download_result");
    }

    @Override // com.huawei.hicloud.notification.manager.HiCloudMsgNoticeLangDownloader, com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public String getLanguageFilePath() {
        return C0213f.m1378b().getFilesDir() + File.separator + "text_link_language.json";
    }

    @Override // com.huawei.hicloud.notification.manager.HiCloudMsgNoticeLangDownloader, com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public AbstractRunnableC12516b.a getLanguageTaskEnum() {
        return AbstractRunnableC12516b.a.SYNC_CONFIG;
    }

    @Override // com.huawei.hicloud.notification.manager.HiCloudMsgNoticeLangDownloader, com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public C11060c getStat() {
        if (this.stat == null) {
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07055"), "07055", C13452e.m80781L().m80971t0());
            this.stat = c11060cM66626a;
            c11060cM66626a.m66665u("0");
        }
        return this.stat;
    }

    @Override // com.huawei.hicloud.notification.manager.HiCloudMsgNoticeLangDownloader, com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void insertLanguageToDB(ArrayList<CommonLanguageDbString> arrayList) {
        try {
            new TextLinkLanguageOperator().batchInsert(arrayList);
        } catch (Exception e10) {
            String str = "insertDataToDB exceptions:" + e10.toString();
            NotifyLogger.m29914e("TextLinkLanguageManager", str);
            reportDownloadInfo("1", str, -1);
        }
    }

    @Override // com.huawei.hicloud.notification.manager.HiCloudMsgNoticeLangDownloader, com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setCurrentLanguageHash(String str) {
        C10028c.m62182c0().m62381q2("text_link_language_hash", str);
    }

    @Override // com.huawei.hicloud.notification.manager.HiCloudMsgNoticeLangDownloader, com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setCurrentLanguageVersion(int i10) {
        C10028c.m62182c0().m62386r2("text_link_language_version", i10);
    }

    @Override // com.huawei.hicloud.notification.manager.HiCloudMsgNoticeLangDownloader, com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setExtractResult(boolean z10) {
        C10028c.m62182c0().m62281U2("text_link_language_download_result", z10);
    }
}

package p778xk;

import android.database.SQLException;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.languageoperator.CampaignActivityLanguageOperator;
import gp.C10028c;
import java.io.File;
import java.util.ArrayList;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p616rk.AbstractRunnableC12516b;
import p709vj.C13452e;

/* renamed from: xk.c */
/* loaded from: classes6.dex */
public class C13822c extends NoticeCfgLanguageBaseManager {
    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearCurrentLanguageDownloadResult() {
        C10028c.m62182c0().m62353l("campaign_activity_language_download_result");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearLangVersionAndResult() {
        NotifyLogger.m29915i("CampaignLanguageManager", "clear notice language");
        C10028c.m62182c0().m62353l("campaign_activity_language_version");
        C10028c.m62182c0().m62353l("campaign_activity_language_download_result");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearLanguageDb() throws SQLException {
        NotifyLogger.m29915i("CampaignLanguageManager", "clearLanguageDb");
        new CampaignActivityLanguageOperator().clear();
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public boolean databaseHasRecord() {
        try {
            return new CampaignActivityLanguageOperator().hasRecord();
        } catch (Exception e10) {
            NotifyLogger.m29914e("CampaignLanguageManager", "databaseHasRecord exceptions:" + e10.toString());
            return false;
        }
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public String getCurrentLanguageHash() {
        return C10028c.m62182c0().m62184A("campaign_activity_language_hash");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public int getCurrentLanguageVersion() {
        return C10028c.m62182c0().m62189B("campaign_activity_language_version");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public boolean getExtractResult() {
        return C10028c.m62182c0().m62324f0("campaign_activity_language_download_result");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public String getLanguageFilePath() {
        return C0213f.m1378b().getFilesDir() + File.separator + "campaign_activity_language.json";
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public AbstractRunnableC12516b.a getLanguageTaskEnum() {
        return AbstractRunnableC12516b.a.SYNC_CONFIG;
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public C11060c getStat() {
        if (this.stat == null) {
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07051"), "07051", C13452e.m80781L().m80971t0());
            this.stat = c11060cM66626a;
            c11060cM66626a.m66665u("0");
        }
        return this.stat;
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void insertLanguageToDB(ArrayList<CommonLanguageDbString> arrayList) {
        try {
            new CampaignActivityLanguageOperator().batchInsert(arrayList);
        } catch (Exception e10) {
            String str = "insertDataToDB exceptions:" + e10.toString();
            NotifyLogger.m29914e("CampaignLanguageManager", str);
            reportDownloadInfo("1", str, -1);
        }
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setCurrentLanguageHash(String str) {
        C10028c.m62182c0().m62381q2("campaign_activity_language_hash", str);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setCurrentLanguageVersion(int i10) {
        C10028c.m62182c0().m62386r2("campaign_activity_language_version", i10);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setExtractResult(boolean z10) {
        C10028c.m62182c0().m62281U2("campaign_activity_language_download_result", z10);
    }
}

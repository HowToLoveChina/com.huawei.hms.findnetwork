package p805yb;

import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguage;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.languageoperator.NpsNotifyLanguageOperator;
import gp.C10028c;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p429kk.C11060c;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;

/* renamed from: yb.a */
/* loaded from: classes3.dex */
public class C13931a extends NoticeCfgLanguageBaseManager {
    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearCurrentLanguageDownloadResult() {
        C10028c.m62182c0().m62353l("nps_notify_language_download_result");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearLangVersionAndResult() {
        C10028c.m62182c0().m62353l("nps_notify_language_version");
        C10028c.m62182c0().m62353l("nps_notify_language_download_result");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearLanguageDb() throws SQLException {
        NotifyLogger.m29915i("HiCloudNPSNoticeLangDownloader", "clearLanguageDb");
        new NpsNotifyLanguageOperator().clear();
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public boolean databaseHasRecord() {
        return false;
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void downloadAndParseLanguage(CommonLanguage commonLanguage, int i10) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        NoticeCfgLanguageBaseManager.LanguageTask languageTask = new NoticeCfgLanguageBaseManager.LanguageTask(commonLanguage, i10, getLanguageFilePath(), countDownLatch);
        boolean zAwait = false;
        C12515a.m75110o().m75175e(languageTask, false);
        try {
            zAwait = countDownLatch.await(5000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            NotifyLogger.m29915i("HiCloudNPSNoticeLangDownloader", "downloadAndParseLanguage, await exception: " + e10.toString());
        }
        NotifyLogger.m29915i("HiCloudNPSNoticeLangDownloader", "downloadAndParseLanguage, awaitResult: " + zAwait);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void extractCommonLanguage(CommonLanguage commonLanguage) {
        super.extractCommonLanguage(commonLanguage);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public String getCurrentLanguageHash() {
        return C10028c.m62182c0().m62184A("nps_notify_language_hash");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public int getCurrentLanguageVersion() {
        return C10028c.m62182c0().m62189B("nps_notify_language_version");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public boolean getExtractResult() {
        return C10028c.m62182c0().m62324f0("nps_notify_language_download_result");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public String getLanguageFilePath() {
        return C0213f.m1378b().getFilesDir() + File.separator + "nps_notify_language.json";
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public AbstractRunnableC12516b.a getLanguageTaskEnum() {
        return AbstractRunnableC12516b.a.SYNC_CONFIG;
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public C11060c getStat() {
        return null;
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void insertLanguageToDB(ArrayList<CommonLanguageDbString> arrayList) {
        try {
            new NpsNotifyLanguageOperator().batchInsert(arrayList);
        } catch (Exception e10) {
            String str = "insertDataToDB exceptions:" + e10.toString();
            NotifyLogger.m29914e("HiCloudNPSNoticeLangDownloader", str);
            reportDownloadInfo("1", str, -1);
        }
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void onHashCheckSuccess(String str) throws IOException {
        clearCurrentLanguageDownloadResult();
        parseLanguageFile(str);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void parseLanguageFile(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            NotifyLogger.m29914e("HiCloudNPSNoticeLangDownloader", "language file not exist");
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                ArrayList<CommonLanguageDbString> arrayList = new ArrayList<>();
                JSONObject jSONObject = new JSONObject(C0209d.m1290o2(fileInputStream));
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    Iterator<String> itKeys2 = jSONObject2.keys();
                    while (itKeys2.hasNext()) {
                        String next2 = itKeys2.next();
                        String string = jSONObject2.getString(next2);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(next2) && !TextUtils.isEmpty(string)) {
                            CommonLanguageDbString commonLanguageDbString = new CommonLanguageDbString();
                            commonLanguageDbString.setLanguage(next);
                            commonLanguageDbString.setName(next2);
                            commonLanguageDbString.setValue(string);
                            arrayList.add(commonLanguageDbString);
                        }
                    }
                }
                clearLanguageDb();
                insertLanguageToDB(arrayList);
                setExtractResult(true);
                NotifyLogger.m29915i("HiCloudNPSNoticeLangDownloader", "parse language file success");
                fileInputStream.close();
            } finally {
            }
        } catch (Exception e10) {
            NotifyLogger.m29914e("HiCloudNPSNoticeLangDownloader", "parse language file error:" + e10.toString());
        }
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setCurrentLanguageHash(String str) {
        C10028c.m62182c0().m62381q2("nps_notify_language_hash", str);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setCurrentLanguageVersion(int i10) {
        C10028c.m62182c0().m62386r2("nps_notify_language_version", i10);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setExtractResult(boolean z10) {
        C10028c.m62182c0().m62281U2("nps_notify_language_download_result", z10);
    }
}

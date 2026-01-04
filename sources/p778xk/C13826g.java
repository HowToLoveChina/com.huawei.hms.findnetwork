package p778xk;

import android.database.SQLException;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hicloud.campaign.bean.QuestBean;
import com.huawei.hicloud.campaign.bean.QuestRoot;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.bean.CommonPicture;
import com.huawei.hicloud.notification.p106db.languageoperator.CampaignQuestLanguageOperator;
import com.huawei.hicloud.notification.task.BaseDownLoadFileTask;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.service.C5020n;
import fk.C9721b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0227m;
import p015ak.C0234s;
import p292fn.C9734g;
import p616rk.C12515a;
import p783xp.C13843a;

/* renamed from: xk.g */
/* loaded from: classes6.dex */
public class C13826g {

    /* renamed from: a */
    public C5020n f62039a;

    /* renamed from: b */
    public String f62040b;

    /* renamed from: xk.g$b */
    public static class b {

        /* renamed from: a */
        public static C13826g f62041a = new C13826g();
    }

    /* renamed from: l */
    public static C13826g m82950l() {
        return b.f62041a;
    }

    /* renamed from: n */
    public static String m82951n() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C0213f.m1378b().getFilesDir());
        String str = File.separator;
        sb2.append(str);
        sb2.append("campaignQuests");
        sb2.append(str);
        return sb2.toString();
    }

    /* renamed from: o */
    public static String m82952o(String str) {
        return m82951n() + C0227m.m1593f(str);
    }

    /* renamed from: a */
    public void m82953a() throws IOException {
        ArrayList<CommonPicture> arrayListM82961i = m82961i();
        if (arrayListM82961i.isEmpty()) {
            NotifyLogger.m29915i("TaskConfigManager", "pictures is empty");
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<CommonPicture> it = arrayListM82961i.iterator();
        while (it.hasNext()) {
            CommonPicture next = it.next();
            if (m82954b(next) && !hashSet.contains(next.getUrl())) {
                String url = next.getUrl();
                C12515a.m75110o().m75175e(new BaseDownLoadFileTask(url, m82952o(url), next.getHash(), null), false);
                hashSet.add(url);
            }
        }
    }

    /* renamed from: b */
    public final boolean m82954b(CommonPicture commonPicture) throws Throwable {
        String strM1591d;
        if (commonPicture == null) {
            return false;
        }
        String url = commonPicture.getUrl();
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        String hash = commonPicture.getHash();
        if (TextUtils.isEmpty(hash)) {
            return false;
        }
        try {
            strM1591d = C0227m.m1591d(m82952o(url));
        } catch (C9721b e10) {
            NotifyLogger.m29916w("TaskConfigManager", "get quest File Sha256 exception: " + e10.toString());
            strM1591d = null;
        }
        return TextUtils.isEmpty(strM1591d) || !hash.equals(strM1591d);
    }

    /* renamed from: c */
    public void m82955c() throws SQLException {
        NotifyLogger.m29915i("TaskConfigManager", "clear all files");
        m82957e();
        m82958f();
        m82959g();
    }

    /* renamed from: d */
    public final void m82956d() {
        new C13827h().clearLangVersionAndResult();
    }

    /* renamed from: e */
    public final void m82957e() throws SQLException {
        C13827h c13827h = new C13827h();
        c13827h.clearLanguageDb();
        c13827h.clearLangVersionAndResult();
        c13827h.clearCurrentLanguageDownloadResult();
        c13827h.deleteLanguageFile();
    }

    /* renamed from: f */
    public final void m82958f() {
        NotifyLogger.m29915i("TaskConfigManager", "clear cached pictures");
        C13843a.m83085g(m82951n());
    }

    /* renamed from: g */
    public final void m82959g() {
        File file = new File(this.f62039a.getConfigFilePath());
        if (!file.exists() || file.delete()) {
            return;
        }
        NotifyLogger.m29914e("TaskConfigManager", "delete config file failed");
    }

    /* renamed from: h */
    public final void m82960h() throws IOException {
        NotifyLogger.m29915i("TaskConfigManager", "start extractLanguage");
        QuestRoot questRootM82963k = m82963k();
        if (questRootM82963k != null) {
            new C13827h().extractCommonLanguage(questRootM82963k.getCommonLanguage());
        }
    }

    /* renamed from: i */
    public final ArrayList<CommonPicture> m82961i() throws IOException {
        CommonPicture picture;
        ArrayList<CommonPicture> arrayList = new ArrayList<>();
        QuestRoot questRootM82963k = m82963k();
        if (questRootM82963k != null && questRootM82963k.getConfig() != null) {
            for (QuestBean questBean : questRootM82963k.getConfig()) {
                if (questBean != null && (picture = questBean.getPicture()) != null && !TextUtils.isEmpty(picture.getUrl())) {
                    arrayList.add(picture);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: j */
    public void m82962j() throws IOException {
        NotifyLogger.m29915i("TaskConfigManager", "requestConfig");
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
            } catch (C9721b e10) {
                NotifyLogger.m29914e("TaskConfigManager", "request notice config exception: " + e10.toString());
                if (NotifyUtil.procFlowControlException(e10, "HiCloudCampaignQuests")) {
                    return;
                }
                if (e10.m60659c() == 304) {
                    NotifyLogger.m29914e("TaskConfigManager", "HTTP_NOT_MODIFY extract sync module config");
                    m82960h();
                    m82953a();
                    return;
                } else {
                    if (!this.f62039a.isExceptionNeedRetry(e10) || i10 >= 2) {
                        return;
                    }
                    NotifyLogger.m29915i("TaskConfigManager", "getLatestConfig exception retry, retry num: " + i10);
                }
            }
            if (this.f62039a.getLatestConfig()) {
                NotifyLogger.m29915i("TaskConfigManager", "request config success");
                C9734g.m60767a().m60769c("HiCloudCampaignQuests");
                m82956d();
                m82960h();
                m82953a();
                return;
            }
            NotifyLogger.m29914e("TaskConfigManager", "getConfig failed");
            if (i10 >= 2) {
                return;
            }
            NotifyLogger.m29915i("TaskConfigManager", "getLatestConfig failed retry, retry num: " + i10);
        }
    }

    /* renamed from: k */
    public QuestRoot m82963k() throws IOException {
        QuestRoot questRoot;
        Exception e10;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(this.f62039a.getConfigFilePath()));
        } catch (Exception e11) {
            questRoot = null;
            e10 = e11;
        }
        try {
            questRoot = (QuestRoot) new Gson().fromJson(C0209d.m1290o2(fileInputStream), QuestRoot.class);
            try {
                fileInputStream.close();
            } catch (Exception e12) {
                e10 = e12;
                NotifyLogger.m29914e("TaskConfigManager", "config file not exitst, msg = " + e10.getMessage());
                return questRoot;
            }
            return questRoot;
        } finally {
        }
    }

    /* renamed from: m */
    public final List<CommonLanguageDbString> m82964m(String str, String str2, String str3) {
        return new CampaignQuestLanguageOperator().queryString(str, str2, HNConstants.Language.EN_STANDARD, str3);
    }

    /* renamed from: p */
    public QuestBean[] m82965p() throws IOException {
        QuestRoot questRootM82963k = m82963k();
        return (questRootM82963k == null || questRootM82963k.getConfig() == null) ? new QuestBean[0] : questRootM82963k.getConfig();
    }

    /* renamed from: q */
    public String m82966q(String str) {
        return NotifyUtil.getStringFromConfig(str, true, true, m82964m(C0234s.m1631i(), HNUtil.getCurrentBaseLanguage(), str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
    
        if (p459lp.C11327e.m68063f(r7.f62040b) >= r2) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005a, code lost:
    
        com.huawei.hicloud.notification.log.NotifyLogger.m29915i("TaskConfigManager", "version updated, query config");
        m82962j();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0063, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
    
        com.huawei.hicloud.notification.log.NotifyLogger.m29915i("TaskConfigManager", "version not updated, extract sync module config");
        m82960h();
        m82953a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
    
        return false;
     */
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m82967r() {
        /*
            r7 = this;
            java.lang.String r0 = "request config version"
            java.lang.String r1 = "TaskConfigManager"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r0)
            r0 = 0
            r2 = r0
        L9:
            r3 = 2
            if (r2 > r3) goto L4e
            com.huawei.hicloud.service.n r4 = r7.f62039a     // Catch: fk.C9721b -> L13
            long r2 = r4.getConfigVersion()     // Catch: fk.C9721b -> L13
            goto L50
        L13:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "request campaign activity config version exception: "
            r5.append(r6)
            java.lang.String r6 = r4.toString()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r1, r5)
            com.huawei.hicloud.service.n r5 = r7.f62039a
            boolean r4 = r5.isExceptionNeedRetry(r4)
            if (r4 == 0) goto L4d
            if (r2 >= r3) goto L4d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "requestConfigVersion exception retry, retry num: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r3)
            int r2 = r2 + 1
            goto L9
        L4d:
            return r0
        L4e:
            r2 = 0
        L50:
            java.lang.String r4 = r7.f62040b
            long r4 = p459lp.C11327e.m68063f(r4)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L64
            java.lang.String r0 = "version updated, query config"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r0)
            r7.m82962j()
            r7 = 1
            return r7
        L64:
            java.lang.String r2 = "version not updated, extract sync module config"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r2)
            r7.m82960h()
            r7.m82953a()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p778xk.C13826g.m82967r():boolean");
    }

    public C13826g() {
        this.f62039a = null;
        this.f62040b = null;
        this.f62039a = new C5020n(null);
        this.f62040b = "HiCloudCampaignQuests";
    }
}

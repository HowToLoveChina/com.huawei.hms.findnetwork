package p778xk;

import android.annotation.SuppressLint;
import android.database.SQLException;
import android.icu.text.SimpleDateFormat;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.huawei.hicloud.campaign.bean.Award;
import com.huawei.hicloud.campaign.bean.CampaignActivityConfig;
import com.huawei.hicloud.campaign.bean.CampaignActivityRoot;
import com.huawei.hicloud.campaign.bean.CampaignEntery;
import com.huawei.hicloud.campaign.bean.Quest;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.bean.CommonPicture;
import com.huawei.hicloud.notification.p106db.languageoperator.CampaignActivityLanguageOperator;
import com.huawei.hicloud.notification.task.BaseDownLoadFileTask;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.service.C5018l;
import fk.C9721b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
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

/* renamed from: xk.b */
/* loaded from: classes6.dex */
public class C13821b {

    /* renamed from: a */
    public C5018l f62026a;

    /* renamed from: b */
    public String f62027b;

    /* renamed from: xk.b$b */
    public static class b {

        /* renamed from: a */
        public static C13821b f62028a = new C13821b();
    }

    /* renamed from: G */
    public static /* synthetic */ int m82865G(Award award, Award award2) {
        return award.getQuota() - award2.getQuota();
    }

    /* renamed from: w */
    public static C13821b m82867w() {
        return b.f62028a;
    }

    /* renamed from: A */
    public String m82868A(String str) throws IOException {
        Award award;
        Award[] awardArrM82871D = m82871D(str);
        return (awardArrM82871D == null || awardArrM82871D.length == 0 || (award = awardArrM82871D[0]) == null) ? "" : award.getName();
    }

    /* renamed from: B */
    public String m82869B() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C0213f.m1378b().getFilesDir());
        String str = File.separator;
        sb2.append(str);
        sb2.append("campaignActivity");
        sb2.append(str);
        return sb2.toString();
    }

    /* renamed from: C */
    public String m82870C(String str) {
        return m82869B() + C0227m.m1593f(str);
    }

    /* renamed from: D */
    public Award[] m82871D(String str) throws IOException {
        Award[] awardArrM82889p = m82889p(str);
        if (awardArrM82889p != null && awardArrM82889p.length != 0) {
            Arrays.sort(awardArrM82889p, new Comparator() { // from class: xk.a
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return C13821b.m82865G((Award) obj, (Award) obj2);
                }
            });
        }
        return awardArrM82889p;
    }

    /* renamed from: E */
    public String m82872E(String str) {
        return NotifyUtil.getStringFromConfig(str, true, true, m82897y(C0234s.m1631i(), HNUtil.getCurrentBaseLanguage(), str));
    }

    /* renamed from: F */
    public boolean m82873F(String str) throws IOException, ParseException {
        if (TextUtils.isEmpty(str)) {
            NotifyLogger.m29914e("CampaignConfigManager", "isActivityFinished activityId is empty");
            return true;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        CampaignActivityConfig campaignActivityConfigM82891r = m82891r(str);
        if (campaignActivityConfigM82891r == null) {
            NotifyLogger.m29914e("CampaignConfigManager", "isActivityFinished config is empty");
            return true;
        }
        String beginTime = campaignActivityConfigM82891r.getBeginTime();
        String endTime = campaignActivityConfigM82891r.getEndTime();
        if (TextUtils.isEmpty(endTime) || TextUtils.isEmpty(beginTime)) {
            NotifyLogger.m29914e("CampaignConfigManager", "isActivityFinished endTime or beginTime is empty");
            return true;
        }
        try {
            Date date = simpleDateFormat.parse(beginTime);
            Date date2 = simpleDateFormat.parse(endTime);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date2);
            long timeInMillis = calendar.getTimeInMillis();
            calendar.setTime(date);
            long timeInMillis2 = calendar.getTimeInMillis();
            NotifyLogger.m29913d("CampaignConfigManager", "isActivityFinished endTimeInMillis:" + timeInMillis + ", beginTimeInMillis" + timeInMillis2);
            if (timeInMillis >= System.currentTimeMillis()) {
                return timeInMillis2 > System.currentTimeMillis();
            }
            return true;
        } catch (Exception e10) {
            NotifyLogger.m29914e("CampaignConfigManager", "isActivityFinished error:" + e10.getMessage());
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
    
        if (p459lp.C11327e.m68063f(r7.f62027b) >= r2) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005a, code lost:
    
        com.huawei.hicloud.notification.log.NotifyLogger.m29915i("CampaignConfigManager", "version updated, query config");
        m82893t();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0063, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
    
        com.huawei.hicloud.notification.log.NotifyLogger.m29915i("CampaignConfigManager", "version not updated, extract sync module config");
        m82882i();
        m82875b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
    
        return false;
     */
    /* renamed from: H */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m82874H() {
        /*
            r7 = this;
            java.lang.String r0 = "request config version"
            java.lang.String r1 = "CampaignConfigManager"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r0)
            r0 = 0
            r2 = r0
        L9:
            r3 = 2
            if (r2 > r3) goto L4e
            com.huawei.hicloud.service.l r4 = r7.f62026a     // Catch: fk.C9721b -> L13
            long r2 = r4.getConfigVersion()     // Catch: fk.C9721b -> L13
            goto L50
        L13:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "request campaign activity config version exception "
            r5.append(r6)
            java.lang.String r6 = r4.toString()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r1, r5)
            com.huawei.hicloud.service.l r5 = r7.f62026a
            boolean r4 = r5.isExceptionNeedRetry(r4)
            if (r4 == 0) goto L4d
            if (r2 >= r3) goto L4d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "requestConfigVersion exception retry, retry num = "
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
            java.lang.String r4 = r7.f62027b
            long r4 = p459lp.C11327e.m68063f(r4)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L64
            java.lang.String r0 = "version updated, query config"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r0)
            r7.m82893t()
            r7 = 1
            return r7
        L64:
            java.lang.String r2 = "version not updated, extract sync module config"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r2)
            r7.m82882i()
            r7.m82875b()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p778xk.C13821b.m82874H():boolean");
    }

    /* renamed from: b */
    public void m82875b() {
        ArrayList<CommonPicture> arrayListM82888o = m82888o();
        if (arrayListM82888o.isEmpty()) {
            NotifyLogger.m29915i("CampaignConfigManager", "pictures is empty");
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<CommonPicture> it = arrayListM82888o.iterator();
        while (it.hasNext()) {
            CommonPicture next = it.next();
            if (m82876c(next) && !hashSet.contains(next.getUrl())) {
                String url = next.getUrl();
                C12515a.m75110o().m75175e(new BaseDownLoadFileTask(url, m82870C(url), next.getHash(), null), false);
                hashSet.add(url);
            }
        }
    }

    /* renamed from: c */
    public final boolean m82876c(CommonPicture commonPicture) throws Throwable {
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
            strM1591d = C0227m.m1591d(m82870C(url));
        } catch (C9721b e10) {
            NotifyLogger.m29916w("CampaignConfigManager", "getFileSha256 exception: " + e10.toString());
            strM1591d = null;
        }
        return TextUtils.isEmpty(strM1591d) || !hash.equals(strM1591d);
    }

    /* renamed from: d */
    public void m82877d() throws SQLException {
        NotifyLogger.m29915i("CampaignConfigManager", "clear all files");
        m82879f();
        m82880g();
        m82881h();
    }

    /* renamed from: e */
    public final void m82878e() throws IOException {
        CampaignActivityRoot campaignActivityRootM82894u = m82894u();
        if (campaignActivityRootM82894u != null) {
            campaignActivityRootM82894u.getCommonLanguage().getHash();
        }
        new C13822c().clearLangVersionAndResult();
    }

    /* renamed from: f */
    public final void m82879f() throws SQLException {
        C13822c c13822c = new C13822c();
        c13822c.clearLanguageDb();
        c13822c.clearLangVersionAndResult();
        c13822c.clearCurrentLanguageDownloadResult();
        c13822c.deleteLanguageFile();
    }

    /* renamed from: g */
    public final void m82880g() {
        NotifyLogger.m29915i("CampaignConfigManager", "delete cached pictures");
        C13843a.m83085g(m82869B());
    }

    /* renamed from: h */
    public final void m82881h() {
        File file = new File(this.f62026a.getConfigFilePath());
        if (!file.exists() || file.delete()) {
            return;
        }
        NotifyLogger.m29914e("CampaignConfigManager", "delete config file failed");
    }

    /* renamed from: i */
    public final void m82882i() throws IOException {
        NotifyLogger.m29915i("CampaignConfigManager", "start extractLanguage");
        CampaignActivityRoot campaignActivityRootM82894u = m82894u();
        if (campaignActivityRootM82894u != null) {
            new C13822c().extractCommonLanguage(campaignActivityRootM82894u.getCommonLanguage());
        }
    }

    /* renamed from: j */
    public CampaignActivityConfig m82883j(String str) throws IOException {
        CampaignActivityConfig[] config;
        if (TextUtils.isEmpty(str)) {
            NotifyLogger.m29914e("CampaignConfigManager", "getActionById but id is empty");
            return null;
        }
        CampaignActivityRoot campaignActivityRootM82894u = m82867w().m82894u();
        if (campaignActivityRootM82894u != null && campaignActivityRootM82894u.getConfig() != null && (config = campaignActivityRootM82894u.getConfig()) != null && config.length != 0) {
            for (CampaignActivityConfig campaignActivityConfig : config) {
                String id2 = campaignActivityConfig.getId();
                if (id2 != null && id2.equals(str)) {
                    return campaignActivityConfig;
                }
            }
        }
        return null;
    }

    /* renamed from: k */
    public String m82884k(String str) throws IOException {
        CampaignActivityConfig campaignActivityConfigM82891r = m82891r(str);
        return campaignActivityConfigM82891r != null ? campaignActivityConfigM82891r.getEndTime() : "";
    }

    /* renamed from: l */
    public long m82885l(String str) throws IOException, ParseException {
        if (TextUtils.isEmpty(str)) {
            return Long.MAX_VALUE;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strM82884k = m82884k(str);
        if (TextUtils.isEmpty(strM82884k)) {
            return Long.MAX_VALUE;
        }
        try {
            Date date = simpleDateFormat.parse(strM82884k);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.getTimeInMillis();
        } catch (Exception e10) {
            NotifyLogger.m29914e("CampaignConfigManager", "getActivityFinishDays error:" + e10.getMessage());
            return Long.MAX_VALUE;
        }
    }

    @SuppressLint({"SimpleDateFormat"})
    /* renamed from: m */
    public int m82886m(String str) throws IOException, ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strM82884k = m82884k(str);
        if (TextUtils.isEmpty(strM82884k)) {
            return -1;
        }
        try {
            Date date = simpleDateFormat.parse(strM82884k);
            Calendar.getInstance().setTime(date);
            return (int) Math.ceil(((r5.getTimeInMillis() - System.currentTimeMillis()) * 1.0d) / 86400000);
        } catch (Exception e10) {
            NotifyLogger.m29914e("CampaignConfigManager", "getActivityFinishDays error:" + e10.getMessage());
            return -1;
        }
    }

    /* renamed from: n */
    public Quest[] m82887n(String str) throws IOException {
        CampaignActivityConfig campaignActivityConfigM82891r = m82891r(str);
        return campaignActivityConfigM82891r != null ? campaignActivityConfigM82891r.getQuests() : new Quest[0];
    }

    /* renamed from: o */
    public final ArrayList<CommonPicture> m82888o() throws IOException {
        ArrayList<CommonPicture> arrayList = new ArrayList<>();
        CampaignActivityRoot campaignActivityRootM82894u = m82894u();
        if (campaignActivityRootM82894u != null && campaignActivityRootM82894u.getConfig() != null) {
            for (CampaignActivityConfig campaignActivityConfig : campaignActivityRootM82894u.getConfig()) {
                if (campaignActivityConfig != null && campaignActivityConfig.getEnterys() != null) {
                    for (CampaignEntery campaignEntery : campaignActivityConfig.getEnterys()) {
                        if (campaignEntery.getPictures() != null) {
                            for (CommonPicture commonPicture : campaignEntery.getPictures()) {
                                if (commonPicture != null && !TextUtils.isEmpty(commonPicture.getUrl())) {
                                    arrayList.add(commonPicture);
                                }
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: p */
    public Award[] m82889p(String str) throws IOException {
        CampaignActivityConfig campaignActivityConfigM82891r = m82891r(str);
        return campaignActivityConfigM82891r != null ? campaignActivityConfigM82891r.getAwards() : new Award[0];
    }

    /* renamed from: q */
    public String m82890q(String str) throws IOException {
        CampaignActivityRoot campaignActivityRootM82894u = m82894u();
        if (campaignActivityRootM82894u == null || campaignActivityRootM82894u.getConfig() == null) {
            return "";
        }
        for (CampaignActivityConfig campaignActivityConfig : campaignActivityRootM82894u.getConfig()) {
            if (str.equals(campaignActivityConfig.getId())) {
                return campaignActivityConfig.getBannerText();
            }
        }
        return "";
    }

    /* renamed from: r */
    public CampaignActivityConfig m82891r(String str) throws IOException {
        CampaignActivityRoot campaignActivityRootM82894u = m82894u();
        if (campaignActivityRootM82894u == null || campaignActivityRootM82894u.getConfig() == null) {
            return null;
        }
        for (CampaignActivityConfig campaignActivityConfig : campaignActivityRootM82894u.getConfig()) {
            if (str.equals(campaignActivityConfig.getId())) {
                return campaignActivityConfig;
            }
        }
        return null;
    }

    /* renamed from: s */
    public CampaignEntery m82892s(int i10, String str) throws IOException {
        CampaignEntery[] enterys;
        CampaignActivityRoot campaignActivityRootM82894u = m82894u();
        if (campaignActivityRootM82894u == null || campaignActivityRootM82894u.getConfig() == null) {
            return null;
        }
        for (CampaignActivityConfig campaignActivityConfig : campaignActivityRootM82894u.getConfig()) {
            if (str.equals(campaignActivityConfig.getId()) && (enterys = campaignActivityConfig.getEnterys()) != null) {
                for (CampaignEntery campaignEntery : enterys) {
                    if (campaignEntery != null && String.valueOf(i10).equals(campaignEntery.getChannel())) {
                        return campaignEntery;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: t */
    public void m82893t() throws IOException {
        NotifyLogger.m29915i("CampaignConfigManager", "requestConfig");
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
            } catch (C9721b e10) {
                NotifyLogger.m29914e("CampaignConfigManager", "request notice config exception: " + e10.toString());
                if (NotifyUtil.procFlowControlException(e10, this.f62027b)) {
                    return;
                }
                if (e10.m60659c() == 304) {
                    NotifyLogger.m29914e("CampaignConfigManager", "HTTP_NOT_MODIFY extract sync module config");
                    m82882i();
                    m82875b();
                    return;
                } else {
                    if (!this.f62026a.isExceptionNeedRetry(e10) || i10 >= 2) {
                        return;
                    }
                    NotifyLogger.m29915i("CampaignConfigManager", "getLatestConfig exception retry, retry num = " + i10);
                }
            }
            if (this.f62026a.getLatestConfig()) {
                NotifyLogger.m29915i("CampaignConfigManager", "request config success");
                C9734g.m60767a().m60769c(this.f62027b);
                m82878e();
                m82882i();
                m82875b();
                return;
            }
            NotifyLogger.m29914e("CampaignConfigManager", "getConfig failed");
            if (i10 >= 2) {
                return;
            }
            NotifyLogger.m29915i("CampaignConfigManager", "getLatestConfig failed retry, retry num: " + i10);
        }
    }

    /* renamed from: u */
    public CampaignActivityRoot m82894u() throws IOException {
        CampaignActivityRoot campaignActivityRoot;
        Exception e10;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(this.f62026a.getConfigFilePath()));
        } catch (Exception e11) {
            campaignActivityRoot = null;
            e10 = e11;
        }
        try {
            campaignActivityRoot = (CampaignActivityRoot) new Gson().fromJson(C0209d.m1290o2(fileInputStream), CampaignActivityRoot.class);
            try {
                fileInputStream.close();
            } catch (Exception e12) {
                e10 = e12;
                NotifyLogger.m29914e("CampaignConfigManager", "config file not exitst, msg = " + e10.getMessage());
                return campaignActivityRoot;
            }
            return campaignActivityRoot;
        } finally {
        }
    }

    /* renamed from: v */
    public JsonObject m82895v() throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(this.f62026a.getConfigFilePath()));
            try {
                JsonObject jsonObject = (JsonObject) new Gson().fromJson(C0209d.m1290o2(fileInputStream), JsonObject.class);
                fileInputStream.close();
                return jsonObject;
            } finally {
            }
        } catch (Exception e10) {
            NotifyLogger.m29914e("CampaignConfigManager", "config file not exitst, msg = " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: x */
    public List<CommonLanguageDbString> m82896x(String str) {
        return new CampaignActivityLanguageOperator().queryAllStringByName(str);
    }

    /* renamed from: y */
    public final List<CommonLanguageDbString> m82897y(String str, String str2, String str3) {
        return new CampaignActivityLanguageOperator().queryString(str, str2, HNConstants.Language.EN_STANDARD, str3);
    }

    /* renamed from: z */
    public String m82898z(String str) throws IOException {
        Award award;
        Award[] awardArrM82871D = m82871D(str);
        return (awardArrM82871D == null || awardArrM82871D.length == 0 || (award = awardArrM82871D[awardArrM82871D.length + (-1)]) == null) ? "" : award.getName();
    }

    public C13821b() {
        this.f62026a = null;
        this.f62027b = null;
        this.f62026a = new C5018l(null);
        this.f62027b = "HiCloudCampaignActivities";
    }
}

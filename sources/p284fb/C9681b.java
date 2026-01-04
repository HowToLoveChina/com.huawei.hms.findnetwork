package p284fb;

import android.content.Context;
import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.manager.HiCloudNotificationManager;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.router.data.CloudSpaceUsageConfig;
import com.huawei.hicloud.router.data.CloudSpaceUsageLanguage;
import com.huawei.hicloud.router.data.FamilyShareLanguage;
import com.huawei.hicloud.router.data.FamilySharePageConfig;
import com.huawei.hicloud.router.data.FamilySharePageParams;
import com.huawei.hicloud.router.data.FamilyShareResource;
import com.huawei.hicloud.router.data.FamilyShareStaticPages;
import fk.C9721b;
import gb.C9902a;
import gb.C9903b;
import hk.C10280c;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;
import p015ak.C0209d;
import p015ak.C0213f;
import p052cb.C1412i;
import p254eb.C9440a;
import p254eb.C9441b;
import p333hb.C10136a;
import p364ib.C10465b;
import p429kk.C11058a;
import p429kk.C11060c;
import p459lp.C11327e;
import p514o9.C11829c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p742wj.C13612b;
import p746wn.C13622a;

/* renamed from: fb.b */
/* loaded from: classes3.dex */
public class C9681b {

    /* renamed from: d */
    public static final C9681b f47895d = new C9681b();

    /* renamed from: a */
    public C11060c f47896a;

    /* renamed from: b */
    public SoftReference<FamilySharePageConfig> f47897b;

    /* renamed from: c */
    public SoftReference<FamilySharePageConfig> f47898c;

    /* renamed from: fb.b$b */
    public static class b extends AbstractC12367d {
        public b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            try {
                C11829c.m70629x0(false);
            } catch (C1412i unused) {
                C11839m.m70687e("FamilyShareManager", "query family share status");
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* renamed from: l */
    public static C9681b m60470l() {
        return f47895d;
    }

    /* renamed from: A */
    public void m60471A() {
        C11839m.m70688i("FamilyShareManager", "onPushQuitOwnerFamilyShare");
        new HiCloudNotificationManager(C0213f.m1377a()).sendQuitOwnerFamilyShareNotify();
    }

    /* renamed from: B */
    public void m60472B() {
        if (C13612b.m81829B().isLogin()) {
            m60480J();
        } else {
            C11839m.m70688i("FamilyShareManager", "processOMConfig user not login.");
        }
    }

    /* renamed from: C */
    public void m60473C(FamilySharePageConfig familySharePageConfig) {
        if (familySharePageConfig == null) {
            return;
        }
        C11839m.m70688i("FamilyShareManager", "refreshCloudConfigRef");
        this.f47898c = new SoftReference<>(familySharePageConfig);
    }

    /* renamed from: D */
    public void m60474D(FamilySharePageConfig familySharePageConfig) {
        if (familySharePageConfig == null) {
            return;
        }
        C11839m.m70688i("FamilyShareManager", "refreshLocalConfigRef");
        this.f47897b = new SoftReference<>(familySharePageConfig);
    }

    /* renamed from: E */
    public void m60475E() {
        C12515a.m75110o().m75172d(new b());
    }

    /* renamed from: F */
    public void m60476F(Map<String, String> map) {
        C13622a.m81969o(C0213f.m1377a(), this.f47896a, map);
    }

    /* renamed from: G */
    public void m60477G(String str) {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            C13227f.m79492i1().m79567R(str, linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", str, "1", "23", linkedHashMapM79497A);
        } catch (Exception e10) {
            C11839m.m70687e("FamilyShareManager", "ERROR OCCUR:" + e10.getMessage());
        }
    }

    /* renamed from: H */
    public void m60478H(String str, String str2, String str3, String str4, String str5) {
        try {
            m60503x();
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            m60481a(str, str2, str3, str4, str5, linkedHashMapM79497A);
            C13227f.m79492i1().m79567R("07015", linkedHashMapM79497A);
            UBAAnalyze.m29947H("CKC", "07015", linkedHashMapM79497A);
            m60476F(linkedHashMapM79497A);
        } catch (Exception e10) {
            C11839m.m70687e("FamilyShareManager", "ERROR OCCUR:" + e10.getMessage());
        }
    }

    /* renamed from: I */
    public void m60479I(String str, String str2, String str3, String str4, String str5, String str6) {
        try {
            m60503x();
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            m60482b(str, str2, str3, str4, str5, linkedHashMapM79497A, str6);
            C13227f.m79492i1().m79567R("07015", linkedHashMapM79497A);
            UBAAnalyze.m29947H("CKC", "07015", linkedHashMapM79497A);
            m60476F(linkedHashMapM79497A);
        } catch (Exception e10) {
            C11839m.m70687e("FamilyShareManager", "ERROR OCCUR:" + e10.getMessage());
        }
    }

    /* renamed from: J */
    public void m60480J() {
        C11839m.m70688i("FamilyShareManager", "startDownloadTask");
        if (!C0209d.m1333z1(C0213f.m1377a())) {
            C11839m.m70688i("FamilyShareManager", "startDownloadTask no network");
        } else {
            C12515a.m75110o().m75172d(new C10136a(1));
        }
    }

    /* renamed from: a */
    public final void m60481a(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        map.put("space_share_entry_type", str);
        map.put(FamilyShareConstants.Report.SPACE_SHARE_EXTRA_KEY, str2);
        map.put(FamilyShareConstants.Report.SPACE_SHARE_OPERATE_TYPE, str3);
        map.put(FamilyShareConstants.Report.SPACE_SHARE_OPERATE_RESULT, str4);
        map.put(FamilyShareConstants.Report.SPACE_SHARE_RETCODE, str5);
    }

    /* renamed from: b */
    public final void m60482b(String str, String str2, String str3, String str4, String str5, Map<String, String> map, String str6) {
        m60481a(str, str2, str3, str4, str5, map);
        map.put(FamilyShareConstants.Report.USER_PAY_TYPE, str6);
    }

    /* renamed from: c */
    public boolean m60483c() throws SQLException {
        C11839m.m70688i("FamilyShareManager", "checkConfigExistAndDownload");
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("FamilyShareManager", "checkConfigExistAndDownload context is null.");
            return false;
        }
        C9902a c9902a = new C9902a();
        if (!new File(contextM1377a.getFilesDir() + "/family_share.json").exists()) {
            C11327e.m68059b("HiCloudStaticPage");
            m60470l().m60472B();
            return false;
        }
        if (c9902a.hasRecord()) {
            return true;
        }
        C11839m.m70688i("FamilyShareManager", "file exist but no language in db");
        C11327e.m68059b("HiCloudStaticPage");
        m60470l().m60486f(contextM1377a);
        m60470l().m60472B();
        return false;
    }

    /* renamed from: d */
    public void m60484d() {
        C11839m.m70688i("FamilyShareManager", "checkLanguageDataBase");
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("FamilyShareManager", "checkLanguageDataBase, context is null");
            return;
        }
        String str = contextM1377a.getFilesDir() + "/";
        String str2 = str + FamilyShareConstants.FamilyShareConfig.FAMILY_SHARE_PAGE_LANGUAGE_XML_NAME_CLOUD;
        File file = new File(str2);
        C9903b c9903b = new C9903b();
        if (file.exists() && !c9903b.hasRecord()) {
            C11839m.m70688i("FamilyShareManager", "checkLanguageDataBase, need parse familyShare LanguageXml");
            C9680a.m60462g(contextM1377a, str2, FamilyShareConstants.FamilyShareConfig.FAMILY_SHARE_PAGE_LANGUAGE_XML_NAME_CLOUD);
        }
        String str3 = str + FamilyShareConstants.FamilyShareConfig.CLOUD_SPACE_USAGE_LANGUAGE_XML_NAME_CLOUD;
        File file2 = new File(str3);
        C9902a c9902a = new C9902a();
        if (!file2.exists() || c9902a.hasRecord()) {
            return;
        }
        C11839m.m70688i("FamilyShareManager", "checkLanguageDataBase, need parse spaceUsage LanguageXml");
        C9680a.m60462g(contextM1377a, str3, FamilyShareConstants.FamilyShareConfig.CLOUD_SPACE_USAGE_LANGUAGE_XML_NAME_CLOUD);
    }

    /* renamed from: e */
    public void m60485e() {
        C11839m.m70688i("FamilyShareManager", CloudBackupConstant.REPORT_TYPE_BASE_CLEAR_CACHE);
        this.f47897b = null;
        this.f47898c = null;
    }

    /* renamed from: f */
    public void m60486f(Context context) throws SQLException {
        if (context == null) {
            C11839m.m70688i("FamilyShareManager", "clearConfigAndDB context is null.");
            return;
        }
        C10465b.m64292b(context, "family_share.json");
        C10465b.m64292b(context, FamilyShareConstants.FamilyShareConfig.FAMILY_SHARE_LOCAL);
        C10465b.m64292b(context, FamilyShareConstants.FamilyShareConfig.CLOUD_SPACE_USAGE_LANGUAGE_XML_NAME_CLOUD);
        C10465b.m64292b(context, FamilyShareConstants.FamilyShareConfig.CLOUD_SPACE_USAGE_LANGUAGE_XML_NAME_LOCAL);
        C10465b.m64292b(context, FamilyShareConstants.FamilyShareConfig.FAMILY_SHARE_PAGE_LANGUAGE_XML_NAME_CLOUD);
        C10465b.m64292b(context, FamilyShareConstants.FamilyShareConfig.FAMILY_SHARE_PAGE_LANGUAGE_XML_NAME_LOCAL);
        new C9902a().clearDB();
        new C9903b().clearDB();
    }

    /* renamed from: g */
    public FamilySharePageConfig m60487g(SoftReference<FamilySharePageConfig> softReference) {
        if (softReference == null || softReference.get() == null) {
            return null;
        }
        return softReference.get();
    }

    /* renamed from: h */
    public FamilySharePageConfig m60488h(String str) throws Throwable {
        String str2;
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("FamilyShareManager", "getFamilyShareConfigFromFile context is null.");
            return null;
        }
        String str3 = contextM1377a.getFilesDir() + "/";
        if ("family_share".equals(str)) {
            str2 = str3 + FamilyShareConstants.FamilyShareConfig.FAMILY_SHARE_PAGE_LANGUAGE_XML_NAME_CLOUD;
        } else if (FamilyShareConstants.FamilyShareConfig.CLOUD_USAGE.equals(str)) {
            str2 = str3 + FamilyShareConstants.FamilyShareConfig.CLOUD_SPACE_USAGE_LANGUAGE_XML_NAME_CLOUD;
        } else {
            str2 = "";
        }
        if (!new File(str2).exists()) {
            FamilySharePageConfig familySharePageConfigM60487g = m60487g(this.f47897b);
            if (familySharePageConfigM60487g != null) {
                return familySharePageConfigM60487g;
            }
            C11839m.m70688i("FamilyShareManager", "getFamilyShareConfigFromLocalFile");
            FamilySharePageConfig familySharePageConfigM60489i = m60489i(contextM1377a, str);
            m60474D(familySharePageConfigM60489i);
            return familySharePageConfigM60489i;
        }
        FamilySharePageConfig familySharePageConfigM60487g2 = m60487g(this.f47898c);
        if (familySharePageConfigM60487g2 != null) {
            return familySharePageConfigM60487g2;
        }
        C11839m.m70688i("FamilyShareManager", "getFamilyShareConfigFromCloudFile");
        FamilySharePageConfig familySharePageConfigM64305o = C10465b.m64305o(str3 + "family_share.json");
        m60473C(familySharePageConfigM64305o);
        return familySharePageConfigM64305o;
    }

    /* renamed from: i */
    public final FamilySharePageConfig m60489i(Context context, String str) throws Throwable {
        C11839m.m70688i("FamilyShareManager", "getFamilyShareConfigFromLocalFile");
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("FamilyShareManager", "getFamilyShareConfigFromLocalFile invalid type.");
            return null;
        }
        if (context == null) {
            C11839m.m70687e("FamilyShareManager", "getFamilyShareConfigFromLocalFile context is null.");
            return null;
        }
        String str2 = context.getFilesDir() + "/" + FamilyShareConstants.FamilyShareConfig.FAMILY_SHARE_LOCAL;
        if (!new File(str2).exists()) {
            C11839m.m70688i("FamilyShareManager", "getFamilyShareConfigFromLocalFile file is not exist.");
            C10280c.m63455c(context, FamilyShareConstants.FamilyShareConfig.FAMILY_SHARE_LOCAL, str2);
        }
        FamilySharePageConfig familySharePageConfigM64305o = C10465b.m64305o(str2);
        if (familySharePageConfigM64305o == null) {
            C11839m.m70687e("FamilyShareManager", "getFamilyShareConfigFromLocalFile familySharePageConfig is null.");
            return null;
        }
        if ("family_share".equals(str)) {
            if (new File(context.getFilesDir() + "/" + FamilyShareConstants.FamilyShareConfig.FAMILY_SHARE_PAGE_LANGUAGE_XML_NAME_LOCAL).exists()) {
                return familySharePageConfigM64305o;
            }
            FamilyShareResource familyShareResource = familySharePageConfigM64305o.getFamilyShareResource();
            if (familyShareResource == null) {
                C11839m.m70687e("FamilyShareManager", "getFamilyShareConfigFromLocalFile familyShareResource is null.");
                return null;
            }
            FamilyShareLanguage familyShareLanguage = familyShareResource.getFamilyShareLanguage();
            if (familyShareLanguage == null) {
                C11839m.m70687e("FamilyShareManager", "getFamilyShareConfigFromLocalFile familyShareLanguage is null.");
                return null;
            }
            String url = familyShareLanguage.getUrl();
            if (TextUtils.isEmpty(url)) {
                C11839m.m70687e("FamilyShareManager", "getFamilyShareConfigFromLocalFile url is null.");
                return null;
            }
            new C9680a(context, url, FamilyShareConstants.FamilyShareConfig.FAMILY_SHARE_PAGE_LANGUAGE_XML_NAME, false, familyShareLanguage.getHash()).m60469j();
        } else if (FamilyShareConstants.FamilyShareConfig.CLOUD_USAGE.equals(str)) {
            if (new File(context.getFilesDir() + "/" + FamilyShareConstants.FamilyShareConfig.CLOUD_SPACE_USAGE_LANGUAGE_XML_NAME_LOCAL).exists()) {
                return familySharePageConfigM64305o;
            }
            CloudSpaceUsageConfig cloudSpaceUsageConfig = familySharePageConfigM64305o.getCloudSpaceUsageConfig();
            if (cloudSpaceUsageConfig == null) {
                C11839m.m70687e("FamilyShareManager", "getFamilyShareConfigFromLocalFile cloudSpaceUsageConfig is null.");
                return null;
            }
            CloudSpaceUsageLanguage cloudSpaceUsageLanguage = cloudSpaceUsageConfig.getCloudSpaceUsageLanguage();
            if (cloudSpaceUsageLanguage == null) {
                C11839m.m70687e("FamilyShareManager", "getFamilyShareConfigFromLocalFile cloudSpaceUsageConfig is null.");
                return null;
            }
            String url2 = cloudSpaceUsageLanguage.getUrl();
            if (TextUtils.isEmpty(url2)) {
                C11839m.m70687e("FamilyShareManager", "getFamilyShareConfigFromLocalFile cloudSpaceUsageLanguageUrl is null.");
                return null;
            }
            new C9680a(context, url2, FamilyShareConstants.FamilyShareConfig.CLOUD_SPACE_USAGE_LANGUAGE_XML_NAME, false, cloudSpaceUsageLanguage.getHash()).m60469j();
        }
        return familySharePageConfigM64305o;
    }

    /* renamed from: j */
    public FamilyShareStaticPages m60490j() {
        FamilySharePageConfig familySharePageConfigM60488h = m60488h("family_share");
        if (familySharePageConfigM60488h == null) {
            C11839m.m70687e("FamilyShareManager", "getFamilyShareStaticPages familySharePageConfig is null.");
            return null;
        }
        FamilyShareResource familyShareResource = familySharePageConfigM60488h.getFamilyShareResource();
        if (familyShareResource == null) {
            C11839m.m70687e("FamilyShareManager", "getFamilyShareStaticPages familyShareResource is null.");
            return null;
        }
        FamilyShareStaticPages familyShareStaticPages = familyShareResource.getFamilyShareStaticPages();
        if (familyShareStaticPages != null) {
            return familyShareStaticPages;
        }
        C11839m.m70687e("FamilyShareManager", "getFamilyShareStaticPages familyShareStaticPages is null.");
        return null;
    }

    /* renamed from: k */
    public final C9440a m60491k() throws Throwable {
        C9440a c9440a = new C9440a();
        FamilySharePageConfig familySharePageConfigM60488h = m60488h("family_share");
        if (familySharePageConfigM60488h == null) {
            C11839m.m70687e("FamilyShareManager", "getFinishShareDetail familySharePageConfig is null.");
            return c9440a;
        }
        FamilyShareResource familyShareResource = familySharePageConfigM60488h.getFamilyShareResource();
        if (familyShareResource == null) {
            C11839m.m70687e("FamilyShareManager", "getFinishShareDetail familyShareResource is null.");
            return c9440a;
        }
        FamilyShareStaticPages familyShareStaticPages = familyShareResource.getFamilyShareStaticPages();
        if (familyShareStaticPages == null) {
            C11839m.m70687e("FamilyShareManager", "getFinishShareDetail familyShareStaticPages is null.");
            return c9440a;
        }
        c9440a.m59220l(C10465b.m64299i(familyShareStaticPages.getFinishTitle()));
        c9440a.m59215g(C10465b.m64299i(familyShareStaticPages.getFinishMainText()));
        c9440a.m59217i(C10465b.m64299i(familyShareStaticPages.getFinishButton1()));
        return c9440a;
    }

    /* renamed from: m */
    public final C9440a m60492m() throws Throwable {
        C9440a c9440a = new C9440a();
        FamilySharePageConfig familySharePageConfigM60488h = m60488h("family_share");
        if (familySharePageConfigM60488h == null) {
            C11839m.m70687e("FamilyShareManager", "getJoinDetail familySharePageConfig is null.");
            return c9440a;
        }
        FamilyShareResource familyShareResource = familySharePageConfigM60488h.getFamilyShareResource();
        if (familyShareResource == null) {
            C11839m.m70687e("FamilyShareManager", "getJoinDetail familyShareResource is null.");
            return c9440a;
        }
        FamilyShareStaticPages familyShareStaticPages = familyShareResource.getFamilyShareStaticPages();
        if (familyShareStaticPages == null) {
            C11839m.m70687e("FamilyShareManager", "getJoinDetail familyShareStaticPages is null.");
            return c9440a;
        }
        c9440a.m59220l(C10465b.m64299i(familyShareStaticPages.getJoinTitle()));
        c9440a.m59215g(C10465b.m64299i(familyShareStaticPages.getJoinMainText()));
        c9440a.m59217i(C10465b.m64299i(familyShareStaticPages.getJoinButton1()));
        c9440a.m59219k(C10465b.m64299i(familyShareStaticPages.getJoinButton2()));
        return c9440a;
    }

    /* renamed from: n */
    public final C9440a m60493n() throws Throwable {
        C9440a c9440a = new C9440a();
        FamilySharePageConfig familySharePageConfigM60488h = m60488h("family_share");
        if (familySharePageConfigM60488h == null) {
            C11839m.m70687e("FamilyShareManager", "getLessThanSpaceDetail familySharePageConfig is null.");
            return c9440a;
        }
        FamilyShareResource familyShareResource = familySharePageConfigM60488h.getFamilyShareResource();
        if (familyShareResource == null) {
            C11839m.m70687e("FamilyShareManager", "getLessThanSpaceDetail familyShareResource is null.");
            return c9440a;
        }
        FamilyShareStaticPages familyShareStaticPages = familyShareResource.getFamilyShareStaticPages();
        if (familyShareStaticPages == null) {
            C11839m.m70687e("FamilyShareManager", "getLessThanSpaceDetail familyShareStaticPages is null.");
            return c9440a;
        }
        c9440a.m59220l(C10465b.m64299i(familyShareStaticPages.getStart1Title()));
        c9440a.m59215g(C10465b.m64299i(familyShareStaticPages.getStart1MainText()));
        c9440a.m59217i(C10465b.m64299i(familyShareStaticPages.getStart1Button1()));
        FamilySharePageParams familySharePageParams = familyShareResource.getFamilySharePageParams();
        if (familySharePageParams == null) {
            C11839m.m70687e("FamilyShareManager", "getLessThanSpaceDetail familySharePageParams is null.");
            return c9440a;
        }
        c9440a.m59216h(familySharePageParams.getStart1ShowMore());
        c9440a.m59218j(familySharePageParams.getStart1MoreUri());
        return c9440a;
    }

    /* renamed from: o */
    public final C9441b m60494o() throws Throwable {
        C9441b c9441b = new C9441b();
        FamilySharePageConfig familySharePageConfigM60488h = m60488h("family_share");
        if (familySharePageConfigM60488h == null) {
            C11839m.m70687e("FamilyShareManager", "getMembeUpgradeStopShareText familySharePageConfig is null.");
            return c9441b;
        }
        FamilyShareResource familyShareResource = familySharePageConfigM60488h.getFamilyShareResource();
        if (familyShareResource == null) {
            C11839m.m70687e("FamilyShareManager", "getMembeUpgradeStopShareText familyShareResource is null.");
            return c9441b;
        }
        FamilyShareStaticPages familyShareStaticPages = familyShareResource.getFamilyShareStaticPages();
        if (familyShareStaticPages == null) {
            C11839m.m70687e("FamilyShareManager", "getMembeUpgradeStopShareText familyShareStaticPages is null.");
            return c9441b;
        }
        c9441b.m59228h(C10465b.m64299i(familyShareStaticPages.getMemberUpgradeTitle()));
        c9441b.m59227g(C10465b.m64299i(familyShareStaticPages.getMemberUpgradeMainText()));
        c9441b.m59226f(C10465b.m64299i(familyShareStaticPages.getMemberUpgradeButton2()));
        c9441b.m59225e(C10465b.m64299i(familyShareStaticPages.getMemberUpgradeButton1()));
        return c9441b;
    }

    /* renamed from: p */
    public final C9441b m60495p() throws Throwable {
        C9441b c9441b = new C9441b();
        FamilySharePageConfig familySharePageConfigM60488h = m60488h("family_share");
        if (familySharePageConfigM60488h == null) {
            C11839m.m70687e("FamilyShareManager", "getMemberQuitShareText familySharePageConfig is null.");
            return c9441b;
        }
        FamilyShareResource familyShareResource = familySharePageConfigM60488h.getFamilyShareResource();
        if (familyShareResource == null) {
            C11839m.m70687e("FamilyShareManager", "getMemberQuitShareText familyShareResource is null.");
            return c9441b;
        }
        FamilyShareStaticPages familyShareStaticPages = familyShareResource.getFamilyShareStaticPages();
        if (familyShareStaticPages == null) {
            C11839m.m70687e("FamilyShareManager", "getMemberQuitShareText familyShareStaticPages is null.");
            return c9441b;
        }
        c9441b.m59228h(C10465b.m64299i(familyShareStaticPages.getMemberStopTitle()));
        if (C13452e.m80781L().m80887a1()) {
            c9441b.m59227g(C10465b.m64299i(familyShareStaticPages.getBmMemberStopMainText()));
        } else {
            c9441b.m59227g(C10465b.m64299i(familyShareStaticPages.getMemberStopMainText()));
        }
        c9441b.m59226f(C10465b.m64299i(familyShareStaticPages.getMemberStopButton1()));
        c9441b.m59225e(C10465b.m64299i(familyShareStaticPages.getMemberStopButton2()));
        return c9441b;
    }

    /* renamed from: q */
    public C9440a m60496q() throws Throwable {
        C9440a c9440a = new C9440a();
        FamilySharePageConfig familySharePageConfigM60488h = m60488h("family_share");
        if (familySharePageConfigM60488h == null) {
            C11839m.m70687e("FamilyShareManager", "getMemberRecommendText familySharePageConfig is null.");
            return c9440a;
        }
        FamilyShareResource familyShareResource = familySharePageConfigM60488h.getFamilyShareResource();
        if (familyShareResource == null) {
            C11839m.m70687e("FamilyShareManager", "getMemberRecommendText familyShareResource is null.");
            return c9440a;
        }
        FamilyShareStaticPages familyShareStaticPages = familyShareResource.getFamilyShareStaticPages();
        if (familyShareStaticPages == null) {
            C11839m.m70687e("FamilyShareManager", "getMemberRecommendText familyShareStaticPages is null.");
            return c9440a;
        }
        c9440a.m59220l(C10465b.m64299i(familyShareStaticPages.getBuyTile()));
        c9440a.m59215g(C10465b.m64299i(familyShareStaticPages.getBuyMainText()));
        c9440a.m59217i(C10465b.m64299i(familyShareStaticPages.getBuyComment1()));
        return c9440a;
    }

    /* renamed from: r */
    public final C9441b m60497r() throws Throwable {
        C9441b c9441b = new C9441b();
        FamilySharePageConfig familySharePageConfigM60488h = m60488h("family_share");
        if (familySharePageConfigM60488h == null) {
            C11839m.m70687e("FamilyShareManager", "getMemberStopUseShareText familySharePageConfig is null.");
            return c9441b;
        }
        FamilyShareResource familyShareResource = familySharePageConfigM60488h.getFamilyShareResource();
        if (familyShareResource == null) {
            C11839m.m70687e("FamilyShareManager", "getMemberStopUseShareText familyShareResource is null.");
            return c9441b;
        }
        FamilyShareStaticPages familyShareStaticPages = familyShareResource.getFamilyShareStaticPages();
        if (familyShareStaticPages == null) {
            C11839m.m70687e("FamilyShareManager", "getMemberStopUseShareText familyShareStaticPages is null.");
            return c9441b;
        }
        c9441b.m59228h(C10465b.m64299i(familyShareStaticPages.getMemberStopTitle()));
        if (C13452e.m80781L().m80887a1()) {
            c9441b.m59227g(C10465b.m64299i(familyShareStaticPages.getBmMemberStopMainText()));
        } else {
            c9441b.m59227g(C10465b.m64299i(familyShareStaticPages.getMemberStopMainText()));
        }
        c9441b.m59226f(C10465b.m64299i(familyShareStaticPages.getMemberStopButton2()));
        c9441b.m59225e(C10465b.m64299i(familyShareStaticPages.getMemberStopButton1()));
        return c9441b;
    }

    /* renamed from: s */
    public final C9440a m60498s() throws Throwable {
        C9440a c9440a = new C9440a();
        FamilySharePageConfig familySharePageConfigM60488h = m60488h("family_share");
        if (familySharePageConfigM60488h == null) {
            C11839m.m70687e("FamilyShareManager", "getMoreThanSpaceDetail familySharePageConfig is null.");
            return c9440a;
        }
        FamilyShareResource familyShareResource = familySharePageConfigM60488h.getFamilyShareResource();
        if (familyShareResource == null) {
            C11839m.m70687e("FamilyShareManager", "getMoreThanSpaceDetail familyShareResource is null.");
            return c9440a;
        }
        FamilyShareStaticPages familyShareStaticPages = familyShareResource.getFamilyShareStaticPages();
        if (familyShareStaticPages == null) {
            C11839m.m70687e("FamilyShareManager", "getMoreThanSpaceDetail familyShareStaticPages is null.");
            return c9440a;
        }
        c9440a.m59220l(C10465b.m64299i(familyShareStaticPages.getStart2Title()));
        c9440a.m59215g(C10465b.m64299i(familyShareStaticPages.getStart2MainText()));
        c9440a.m59217i(C10465b.m64299i(familyShareStaticPages.getStart2Button1()));
        c9440a.m59219k(C10465b.m64299i(familyShareStaticPages.getStart2Button2()));
        FamilySharePageParams familySharePageParams = familyShareResource.getFamilySharePageParams();
        if (familySharePageParams == null) {
            C11839m.m70687e("FamilyShareManager", "getMoreThanSpaceDetail familySharePageParams is null.");
            return c9440a;
        }
        c9440a.m59216h(familySharePageParams.getStart2ShowMore());
        c9440a.m59218j(familySharePageParams.getStart2MoreUri());
        return c9440a;
    }

    /* renamed from: t */
    public C9440a m60499t(int i10) {
        if (i10 == 1) {
            return m60493n();
        }
        if (i10 == 2) {
            return m60498s();
        }
        if (i10 == 3) {
            return m60491k();
        }
        if (i10 == 4) {
            return m60492m();
        }
        if (i10 != 5) {
            C11839m.m70688i("FamilyShareManager", "getShareSpaceDetail invalid type = " + i10);
        }
        return null;
    }

    /* renamed from: u */
    public C9441b m60500u(int i10) {
        if (i10 == 1) {
            return m60502w();
        }
        if (i10 == 2) {
            return m60501v();
        }
        if (i10 == 3) {
            return m60497r();
        }
        if (i10 == 4) {
            return m60495p();
        }
        if (i10 == 5) {
            return m60494o();
        }
        C11839m.m70688i("FamilyShareManager", "getShareSpaceDialogDetail invalid type = " + i10);
        return null;
    }

    /* renamed from: v */
    public final C9441b m60501v() throws Throwable {
        C9441b c9441b = new C9441b();
        FamilySharePageConfig familySharePageConfigM60488h = m60488h("family_share");
        if (familySharePageConfigM60488h == null) {
            C11839m.m70687e("FamilyShareManager", "getShareSpaceNotEnoughText familySharePageConfig is null.");
            return c9441b;
        }
        FamilyShareResource familyShareResource = familySharePageConfigM60488h.getFamilyShareResource();
        if (familyShareResource == null) {
            C11839m.m70687e("FamilyShareManager", "getShareSpaceNotEnoughText familyShareResource is null.");
            return c9441b;
        }
        FamilyShareStaticPages familyShareStaticPages = familyShareResource.getFamilyShareStaticPages();
        if (familyShareStaticPages == null) {
            C11839m.m70687e("FamilyShareManager", "getShareSpaceNotEnoughText familyShareStaticPages is null.");
            return c9441b;
        }
        c9441b.m59228h(C10465b.m64299i(familyShareStaticPages.getJoinInsuffTitle()));
        c9441b.m59227g(C10465b.m64299i(familyShareStaticPages.getJoinInsuffMainText()));
        c9441b.m59226f(C10465b.m64299i(familyShareStaticPages.getJoinInsuffButton1()));
        return c9441b;
    }

    /* renamed from: w */
    public final C9441b m60502w() throws Throwable {
        C9441b c9441b = new C9441b();
        FamilySharePageConfig familySharePageConfigM60488h = m60488h("family_share");
        if (familySharePageConfigM60488h == null) {
            C11839m.m70687e("FamilyShareManager", "getStopShareDialogText familySharePageConfig is null.");
            return c9441b;
        }
        FamilyShareResource familyShareResource = familySharePageConfigM60488h.getFamilyShareResource();
        if (familyShareResource == null) {
            C11839m.m70687e("FamilyShareManager", "getStopShareDialogText familyShareResource is null.");
            return c9441b;
        }
        FamilyShareStaticPages familyShareStaticPages = familyShareResource.getFamilyShareStaticPages();
        if (familyShareStaticPages == null) {
            C11839m.m70687e("FamilyShareManager", "getStopShareDialogText familyShareStaticPages is null.");
            return c9441b;
        }
        c9441b.m59228h(C10465b.m64299i(familyShareStaticPages.getStopTitle()));
        c9441b.m59227g(C10465b.m64299i(familyShareStaticPages.getStopMainText()));
        c9441b.m59226f(C10465b.m64299i(familyShareStaticPages.getStopButton2()));
        c9441b.m59225e(C10465b.m64299i(familyShareStaticPages.getStopButton1()));
        return c9441b;
    }

    /* renamed from: x */
    public final void m60503x() {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07015"), "07015", C13452e.m80781L().m80971t0());
        this.f47896a = c11060cM66626a;
        c11060cM66626a.m66665u("0");
    }

    /* renamed from: y */
    public void m60504y(String str, long j10) {
        C11839m.m70688i("FamilyShareManager", "onPushNotifyShareDisable");
        new HiCloudNotificationManager(C0213f.m1377a()).sendFamilyShareStopNotify(C0213f.m1377a());
    }

    /* renamed from: z */
    public void m60505z(String str, long j10) {
        C11839m.m70688i("FamilyShareManager", "onPushNotifyShareEnable");
        new HiCloudNotificationManager(C0213f.m1377a()).sendFamilyShareEnableNotify(j10);
    }
}

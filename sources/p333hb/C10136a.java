package p333hb;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.router.data.CloudSpaceUsageConfig;
import com.huawei.hicloud.router.data.CloudSpaceUsageLanguage;
import com.huawei.hicloud.router.data.FamilyShareLanguage;
import com.huawei.hicloud.router.data.FamilySharePageConfig;
import com.huawei.hicloud.service.C5006d;
import fk.C9721b;
import gp.C10028c;
import java.io.File;
import p015ak.C0213f;
import p284fb.C9680a;
import p284fb.C9681b;
import p292fn.C9734g;
import p364ib.C10465b;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* renamed from: hb.a */
/* loaded from: classes3.dex */
public class C10136a extends AbstractC12367d {

    /* renamed from: a */
    public int f49425a;

    public C10136a(int i10) {
        this.f49425a = i10;
    }

    /* renamed from: c */
    public final void m63180c(Context context, FamilySharePageConfig familySharePageConfig) {
        if (familySharePageConfig == null) {
            C11839m.m70687e("FamilyShareConfigTask", "downloadAndParseCloudSpaceLanguage familySharePageConfig is null.");
            return;
        }
        CloudSpaceUsageConfig cloudSpaceUsageConfig = familySharePageConfig.getCloudSpaceUsageConfig();
        if (cloudSpaceUsageConfig == null) {
            C11839m.m70687e("FamilyShareConfigTask", "downloadAndParseCloudSpaceLanguage usageConfig null");
            C10465b.m64306p("downloadAndParseCloudSpaceLanguage usageConfig null");
            return;
        }
        CloudSpaceUsageLanguage cloudSpaceUsageLanguage = cloudSpaceUsageConfig.getCloudSpaceUsageLanguage();
        if (cloudSpaceUsageLanguage == null) {
            C11839m.m70689w("FamilyShareConfigTask", "downloadAndParseCloudSpaceLanguage language null");
            C10465b.m64306p("downloadAndParseCloudSpaceLanguage language null");
            return;
        }
        String url = cloudSpaceUsageLanguage.getUrl();
        if (TextUtils.isEmpty(url)) {
            C10465b.m64306p("downloadAndParseCloudSpaceLanguage spaceUrl null");
        } else if (new C9680a(context, url, FamilyShareConstants.FamilyShareConfig.CLOUD_SPACE_USAGE_LANGUAGE_XML_NAME, true, cloudSpaceUsageLanguage.getHash()).m60469j()) {
            C11839m.m70688i("FamilyShareConfigTask", "download cloud space usage language success.");
        } else {
            C11839m.m70687e("FamilyShareConfigTask", "downloadAndParseCloudSpaceLanguage cloudSpaceUsageTask failed.");
            C10465b.m64306p("downloadAndParseCloudSpaceLanguage cloudSpaceUsageTask failed.");
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws NumberFormatException {
        if (this.f49425a == 1) {
            getVersion();
        }
    }

    /* renamed from: d */
    public final void m63181d(Context context, FamilySharePageConfig familySharePageConfig) throws NumberFormatException {
        int i10;
        int iM62189B;
        if (familySharePageConfig == null) {
            C11839m.m70687e("FamilyShareConfigTask", "downloadAndParseLanguageXml familySharePageConfig is null.");
            C10465b.m64306p("downloadAndParseLanguageXml familySharePageConfig is null.");
            C10465b.m64308r(false);
            return;
        }
        if (familySharePageConfig.getFamilyShareResource() == null) {
            C11839m.m70687e("FamilyShareConfigTask", "downloadAndParseLanguageXml familyShareResource is null.");
            C10465b.m64306p("downloadAndParseLanguageXml familyShareResource is null.");
            C10465b.m64308r(false);
            return;
        }
        FamilyShareLanguage familyShareLanguage = familySharePageConfig.getFamilyShareResource().getFamilyShareLanguage();
        if (familyShareLanguage == null) {
            C11839m.m70687e("FamilyShareConfigTask", "downloadAndParseLanguageXml familyShareLanguage is null.");
            C10465b.m64306p("downloadAndParseLanguageXml familyShareLanguage is null.");
            C10465b.m64308r(false);
            return;
        }
        try {
            i10 = Integer.parseInt(familyShareLanguage.getVersion());
            iM62189B = C10028c.m62182c0().m62189B(RecommendCardConstants.LanguageVersion.HICLOUD_FAMILY_SHARE_LANGUAGE);
            C11839m.m70688i("FamilyShareConfigTask", "downloadAndParseCloudSpaceLanguage localVersion ：" + iM62189B + ",cloudVersion:" + i10);
        } catch (Exception e10) {
            C11839m.m70687e("FamilyShareConfigTask", "downloadAndParseCloudSpaceLanguage language version:" + e10);
        }
        if (iM62189B >= i10) {
            C11839m.m70689w("FamilyShareConfigTask", "downloadAndParseCloudSpaceLanguage language has no newVersion!");
            return;
        }
        C10028c.m62182c0().m62386r2(RecommendCardConstants.LanguageVersion.HICLOUD_FAMILY_SHARE_LANGUAGE, i10);
        String url = familyShareLanguage.getUrl();
        if (TextUtils.isEmpty(url)) {
            C11839m.m70687e("FamilyShareConfigTask", "downloadAndParseLanguageXml url is null.");
            C10465b.m64306p("downloadAndParseLanguageXml url is null.");
            C10465b.m64308r(false);
        } else if (new C9680a(context, url, FamilyShareConstants.FamilyShareConfig.FAMILY_SHARE_PAGE_LANGUAGE_XML_NAME, true, familyShareLanguage.getHash()).m60469j()) {
            C10465b.m64308r(false);
            C11839m.m70688i("FamilyShareConfigTask", "download cloud familyshare language success.");
        } else {
            C11839m.m70687e("FamilyShareConfigTask", "downloadAndParseLanguageXml familyShareLanguageDownload failed.");
            C10465b.m64306p("downloadAndParseLanguageXml familyShareLanguageDownload failed.");
            C10465b.m64308r(false);
        }
    }

    public final void getConfig() throws NumberFormatException {
        Context contextM1377a;
        C11839m.m70688i("FamilyShareConfigTask", "getConfig()");
        C5006d c5006d = new C5006d(null);
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
                contextM1377a = C0213f.m1377a();
            } catch (C9721b e10) {
                String str = "getConfig() exception:" + e10.toString();
                C11839m.m70687e("FamilyShareConfigTask", str);
                C10465b.m64307q(str, i10);
                C10465b.m64308r(false);
                if (NotifyUtil.procFlowControlException(e10, "HiCloudStaticPage")) {
                    return;
                }
                if (e10.m60659c() == 304) {
                    C11839m.m70687e("FamilyShareConfigTask", "HTTP_NOT_MODIFY extract sync module config");
                    return;
                } else {
                    if (!c5006d.isExceptionNeedRetry(e10) || i10 >= 2) {
                        return;
                    }
                    C11839m.m70688i("FamilyShareConfigTask", "getLatestConfig exception retry, retry num: " + i10);
                }
            }
            if (contextM1377a == null) {
                C11839m.m70687e("FamilyShareConfigTask", "getConfig() context is null.");
                C10465b.m64306p("getConfig() context is null.");
                return;
            }
            if (c5006d.getLatestConfig()) {
                C11839m.m70688i("FamilyShareConfigTask", "requestConfig success");
                C9734g.m60767a().m60769c("HiCloudStaticPage");
                C10465b.m64308r(true);
                C10465b.m64292b(contextM1377a, FamilyShareConstants.FamilyShareConfig.FAMILY_SHARE_LOCAL);
                FamilySharePageConfig familySharePageConfigM64305o = C10465b.m64305o(contextM1377a.getFilesDir() + "/family_share.json");
                C9681b.m60470l().m60473C(familySharePageConfigM64305o);
                m63180c(contextM1377a, familySharePageConfigM64305o);
                m63181d(contextM1377a, familySharePageConfigM64305o);
                return;
            }
            C11839m.m70687e("FamilyShareConfigTask", "query cloud notify config failed");
            C10465b.m64307q("query cloud notify config failed.", i10);
            C10465b.m64308r(false);
            if (i10 >= 2) {
                return;
            }
            C11839m.m70688i("FamilyShareConfigTask", "getLatestConfig failed retry, retry num: " + i10);
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.FAMILY_SHARE;
    }

    public final void getLanguageXml() throws NumberFormatException {
        Context contextM1377a = C0213f.m1377a();
        String str = contextM1377a.getFilesDir() + "/";
        String str2 = str + FamilyShareConstants.FamilyShareConfig.FAMILY_SHARE_PAGE_LANGUAGE_XML_NAME_CLOUD;
        String str3 = str + FamilyShareConstants.FamilyShareConfig.CLOUD_SPACE_USAGE_LANGUAGE_XML_NAME_CLOUD;
        File file = new File(str2);
        File file2 = new File(str3);
        if (!file.exists()) {
            C11839m.m70689w("FamilyShareConfigTask", "getLanguageXml familyShareFile is not exist,try agaign.");
            m63181d(contextM1377a, C10465b.m64305o(str + "family_share.json"));
        }
        if (file2.exists()) {
            return;
        }
        C11839m.m70689w("FamilyShareConfigTask", "getLanguageXml cloudUsageFile is not exist,try agaign.");
        m63180c(contextM1377a, C10465b.m64305o(str + "family_share.json"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006b, code lost:
    
        if (p459lp.C11327e.m68063f("HiCloudStaticPage") >= r0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006d, code lost:
    
        p514o9.C11839m.m70688i("FamilyShareConfigTask", "version updated, query config");
        getConfig();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0075, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0076, code lost:
    
        p514o9.C11839m.m70689w("FamilyShareConfigTask", "getVersion fail. localVersion > latestVersion");
        p364ib.C10465b.m64306p("getVersion fail. localVersion > latestVersion");
        getLanguageXml();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0081, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getVersion() throws java.lang.NumberFormatException {
        /*
            r8 = this;
            com.huawei.hicloud.service.d r0 = new com.huawei.hicloud.service.d
            r1 = 0
            r0.<init>(r1)
            r1 = 0
        L7:
            r2 = 2
            java.lang.String r3 = "FamilyShareConfigTask"
            if (r1 > r2) goto L61
            long r0 = r0.getConfigVersion()     // Catch: fk.C9721b -> L11
            goto L63
        L11:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "requestConfigVersion exception:"
            r5.append(r6)
            java.lang.String r6 = r4.toString()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            java.lang.String r7 = " retryNum = "
            r6.append(r7)
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r3, r6)
            p364ib.C10465b.m64307q(r5, r1)
            boolean r4 = r0.isExceptionNeedRetry(r4)
            if (r4 == 0) goto L60
            if (r1 >= r2) goto L60
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "requestConfigVersion exception retry, retry num: "
            r2.append(r4)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            p514o9.C11839m.m70688i(r3, r2)
            int r1 = r1 + 1
            goto L7
        L60:
            return
        L61:
            r0 = 0
        L63:
            java.lang.String r2 = "HiCloudStaticPage"
            long r4 = p459lp.C11327e.m68063f(r2)
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 >= 0) goto L76
            java.lang.String r0 = "version updated, query config"
            p514o9.C11839m.m70688i(r3, r0)
            r8.getConfig()
            return
        L76:
            java.lang.String r0 = "getVersion fail. localVersion > latestVersion"
            p514o9.C11839m.m70689w(r3, r0)
            p364ib.C10465b.m64306p(r0)
            r8.getLanguageXml()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p333hb.C10136a.getVersion():void");
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public boolean syncLock() {
        return true;
    }
}

package com.huawei.hicloud.notification.task;

import android.text.TextUtils;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.HiCloudBrandBannerManager;
import com.huawei.hicloud.notification.p106db.bean.BrandMarket;
import com.huawei.hicloud.notification.p106db.bean.BrandMarkets;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguage;
import com.huawei.hicloud.notification.p106db.bean.CommonPicture;
import com.huawei.hicloud.notification.p106db.bean.HiCloudSpaceBrandMarkets;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.service.C5017k;
import fk.C9721b;
import gp.C10028c;
import p292fn.C9734g;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;

/* loaded from: classes6.dex */
public class QueryHiCloudBrandHomePageBannerTask extends AbstractC12367d {
    private static final String TAG = "QueryHiCloudBrandHomePageBannerTask";

    private void extractConfig() {
        NotifyLogger.m29915i(TAG, "extractConfig");
        HiCloudSpaceBrandMarkets configFromFile = HiCloudBrandBannerManager.getInstance().getConfigFromFile(RecommendCardConstants.Entrance.HOMEPAGE);
        if (configFromFile == null) {
            NotifyLogger.m29914e(TAG, "hiCloudSpaceBrandMarkets is null");
            return;
        }
        BrandMarkets brandMarkets = configFromFile.getBrandMarkets();
        if (brandMarkets == null) {
            NotifyLogger.m29914e(TAG, "brandMarkets is null");
            return;
        }
        CommonLanguage language = brandMarkets.getLanguage();
        if (language == null) {
            NotifyLogger.m29914e(TAG, "language is null");
            return;
        }
        int iM62189B = C10028c.m62182c0().m62189B(RecommendCardConstants.LanguageVersion.HICLOUD_BRAND_HOMEPAGE_BANNER);
        int version = language.getVersion();
        String strM62184A = C10028c.m62182c0().m62184A(RecommendCardConstants.LanguageHash.HICLOUD_BRAND_HOMEPAGE_BANNER);
        String hash = language.getHash();
        NotifyLogger.m29915i(TAG, "localLanguageVersion: " + iM62189B + ", omLanguageVersion: " + version + "localLanguageHash: " + strM62184A + ", omLanguageHash: " + hash);
        if (iM62189B == 0 || TextUtils.isEmpty(strM62184A) || (iM62189B != version && !TextUtils.equals(strM62184A, hash))) {
            C10028c.m62182c0().m62386r2(RecommendCardConstants.LanguageVersion.HICLOUD_BRAND_HOMEPAGE_BANNER, 0);
            C10028c.m62182c0().m62381q2(RecommendCardConstants.LanguageHash.HICLOUD_BRAND_HOMEPAGE_BANNER, "");
            HiCloudBrandBannerManager.getInstance().clearLanguageXml(RecommendCardConstants.Entrance.HOMEPAGE);
            HiCloudBrandBannerManager.getInstance().clearLanguageDb(RecommendCardConstants.Entrance.HOMEPAGE);
            C12515a.m75110o().m75175e(new QueryHiCloudBrandBannerLanguageTask(language, RecommendCardConstants.Entrance.HOMEPAGE), false);
        }
        BrandMarket[] brandMarkets2 = brandMarkets.getBrandMarkets();
        if (brandMarkets2 == null || brandMarkets2.length == 0) {
            NotifyLogger.m29914e(TAG, "brandMarketArray is null");
            return;
        }
        for (BrandMarket brandMarket : brandMarkets2) {
            if (brandMarket == null) {
                NotifyLogger.m29914e(TAG, "brandMarket is null");
                return;
            }
            CommonPicture[] picturesSecond = brandMarket.getPicturesSecond();
            if (picturesSecond != null) {
                C12515a.m75110o().m75175e(new QueryHiCloudBannerPicturesTask(picturesSecond), false);
            }
            CommonPicture[] pictures = brandMarket.getPictures();
            if (pictures != null) {
                C12515a.m75110o().m75175e(new QueryHiCloudBannerPicturesTask(pictures), false);
            }
        }
    }

    private void getConfig(C5017k c5017k) {
        if (c5017k == null) {
            c5017k = new C5017k(null);
        }
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
            } catch (C9721b e10) {
                NotifyLogger.m29914e(TAG, "get config exception: " + e10.toString());
                if (NotifyUtil.procFlowControlException(e10, "HiCloudBrandHomePageBanner")) {
                    return;
                }
                if (e10.m60659c() == 304) {
                    NotifyLogger.m29914e(TAG, "HTTP_NOT_MODIFY extract sync module config");
                    return;
                } else {
                    if (!c5017k.isExceptionNeedRetry(e10) || i10 >= 2) {
                        return;
                    }
                    NotifyLogger.m29915i(TAG, "getConfig exception retry, retry num: " + i10);
                }
            }
            if (c5017k.getLatestConfig()) {
                NotifyLogger.m29915i(TAG, "get config success");
                C9734g.m60767a().m60769c("HiCloudBrandHomePageBanner");
                extractConfig();
                return;
            }
            NotifyLogger.m29914e(TAG, "get config fail");
            if (i10 >= 2) {
                return;
            }
            NotifyLogger.m29915i(TAG, "getLatestConfig failed retry, retry num: " + i10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0059, code lost:
    
        if (p459lp.C11327e.m68063f("HiCloudBrandHomePageBanner") == r2) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005b, code lost:
    
        com.huawei.hicloud.notification.log.NotifyLogger.m29915i(com.huawei.hicloud.notification.task.QueryHiCloudBrandHomePageBannerTask.TAG, "version updated, query config");
        getConfig(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0064, code lost:
    
        com.huawei.hicloud.notification.log.NotifyLogger.m29915i(com.huawei.hicloud.notification.task.QueryHiCloudBrandHomePageBannerTask.TAG, "version not updated, extract config");
        extractConfig();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void getConfigVersion() {
        /*
            r7 = this;
            java.lang.String r0 = "getConfigVersion"
            java.lang.String r1 = "QueryHiCloudBrandHomePageBannerTask"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r0)
            com.huawei.hicloud.service.k r0 = new com.huawei.hicloud.service.k
            r2 = 0
            r0.<init>(r2)
            r2 = 0
        Le:
            r3 = 2
            if (r2 > r3) goto L4f
            long r2 = r0.getConfigVersion()     // Catch: fk.C9721b -> L16
            goto L51
        L16:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "getConfigVersion exception: "
            r5.append(r6)
            java.lang.String r6 = r4.toString()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r1, r5)
            boolean r4 = r0.isExceptionNeedRetry(r4)
            if (r4 == 0) goto L4e
            if (r2 >= r3) goto L4e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "getConfigVersion exception retry, retry num: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r3)
            int r2 = r2 + 1
            goto Le
        L4e:
            return
        L4f:
            r2 = 0
        L51:
            java.lang.String r4 = "HiCloudBrandHomePageBanner"
            long r4 = p459lp.C11327e.m68063f(r4)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 == 0) goto L64
            java.lang.String r2 = "version updated, query config"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r2)
            r7.getConfig(r0)
            goto L6c
        L64:
            java.lang.String r0 = "version not updated, extract config"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r0)
            r7.extractConfig()
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.notification.task.QueryHiCloudBrandHomePageBannerTask.getConfigVersion():void");
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        getConfigVersion();
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.RECOMMEND_CARD;
    }
}

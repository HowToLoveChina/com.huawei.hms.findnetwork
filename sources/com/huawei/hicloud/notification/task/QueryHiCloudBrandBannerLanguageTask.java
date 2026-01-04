package com.huawei.hicloud.notification.task;

import android.text.TextUtils;
import com.huawei.hicloud.download.C4896a;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.HiCloudBrandBannerManager;
import com.huawei.hicloud.notification.manager.RecommendCardManager;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguage;
import com.huawei.hicloud.notification.util.NotifyUtil;
import fk.C9721b;
import java.io.File;
import p015ak.C0227m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* loaded from: classes6.dex */
public class QueryHiCloudBrandBannerLanguageTask extends AbstractC12367d {
    private static final String TAG = "QueryHiCloudBrandBannerLanguageTask";
    private String entrance;
    private CommonLanguage language;

    public QueryHiCloudBrandBannerLanguageTask(CommonLanguage commonLanguage, String str) {
        this.language = commonLanguage;
        this.entrance = str;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws Throwable {
        NotifyLogger.m29915i(TAG, "call");
        if (RecommendCardManager.getInstance().checkLanguageParam(this.language, this.entrance)) {
            String url = this.language.getUrl();
            String hash = this.language.getHash();
            String languageXMLPath = HiCloudBrandBannerManager.getInstance().getLanguageXMLPath(this.entrance);
            if (TextUtils.isEmpty(languageXMLPath)) {
                NotifyLogger.m29914e(TAG, "languageXMLPath is empty");
                return;
            }
            C4896a c4896a = new C4896a(url, languageXMLPath, 0L);
            for (int i10 = 0; i10 <= 2; i10++) {
                try {
                    NotifyUtil.downloadFileToPath(languageXMLPath, c4896a.getUrl(), c4896a);
                } catch (C9721b e10) {
                    NotifyLogger.m29914e(TAG, "download language exception: " + e10.toString());
                    try {
                        Thread.sleep(5000L);
                    } catch (InterruptedException e11) {
                        NotifyLogger.m29914e(TAG, "download language sleep exception: " + e11.toString());
                    }
                }
                if (new File(languageXMLPath).exists()) {
                    NotifyLogger.m29915i(TAG, "download language success");
                    if (hash.equals(C0227m.m1591d(languageXMLPath))) {
                        NotifyLogger.m29915i(TAG, "language hash is same");
                        HiCloudBrandBannerManager.getInstance().parseLanguageXML(this.entrance, languageXMLPath, this.language);
                    } else {
                        NotifyLogger.m29914e(TAG, "language hash not equal");
                        HiCloudBrandBannerManager.getInstance().clearLanguageXml(this.entrance);
                    }
                    return;
                }
                continue;
            }
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.RECOMMEND_CARD;
    }
}

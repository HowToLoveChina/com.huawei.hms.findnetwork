package com.huawei.hicloud.notification.task;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.AdSwitchManager;
import com.huawei.hicloud.notification.manager.HiCloudBrandBannerManager;
import com.huawei.hicloud.notification.manager.RecommendCardManager;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.INativeAdLoader;
import com.huawei.openalliance.p169ad.inter.NativeAdLoader;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener;
import com.huawei.secure.android.common.ssl.SecureX509TrustManager;
import fk.C9721b;
import gu.C10048b;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import p015ak.C0209d;
import p015ak.C0213f;
import p373iu.C10618f;
import p581qk.AbstractC12367d;
import p709vj.C13452e;

/* loaded from: classes6.dex */
public class InitFocusAdloaderTask extends AbstractC12367d {
    private static final int DEFAULT_BRAND = 1;
    private static final int DEVICE_TYPE_PHONE = 4;
    private static final int HORNOR_BRAND = 2;
    private static final String TAG = "InitFocusAdloaderTask";
    private String[] adIds;
    private INativeAdLoader adLoader;
    private Context context;
    private String entrance;
    private CountDownLatch latch;

    public class LoaderNativeAdListener implements NativeAdListener {
        public LoaderNativeAdListener() {
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener
        public void onAdFailed(int i10) {
            NotifyLogger.m29914e(InitFocusAdloaderTask.TAG, "load Ad failed, code = " + i10);
            InitFocusAdloaderTask.this.latch.countDown();
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener
        public void onAdsLoaded(Map<String, List<INativeAd>> map) {
            if (map == null) {
                NotifyLogger.m29915i(InitFocusAdloaderTask.TAG, "on ads loaded error, ads is null");
                InitFocusAdloaderTask.this.latch.countDown();
                return;
            }
            NotifyLogger.m29915i(InitFocusAdloaderTask.TAG, "on ads loaded, adId size = " + map.size() + " entrance: " + InitFocusAdloaderTask.this.entrance);
            RecommendCardManager.getInstance().setAds(InitFocusAdloaderTask.this.entrance, map);
            InitFocusAdloaderTask.this.latch.countDown();
        }
    }

    public InitFocusAdloaderTask(Context context, String str, CountDownLatch countDownLatch) {
        this.entrance = str;
        this.context = context;
        this.latch = countDownLatch;
    }

    private void initPPSSDK(Context context) {
        if (context == null) {
            NotifyLogger.m29914e(TAG, "init PPS SDK error, context is null");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            HiAd.getInstance(applicationContext).initLog(true, 4);
            HiAd.getInstance(applicationContext).setCustomSSLSocketFactory(C10618f.m65076c(applicationContext, C10048b.m62471c()), new SecureX509TrustManager(applicationContext));
            HiAd.getInstance(applicationContext).enableUserInfo(true);
            HiAd.getInstance(applicationContext).initGrs("hicloud");
            if (C0209d.m1269j1()) {
                HiAd.getInstance(applicationContext).setBrand(2);
            } else {
                HiAd.getInstance(applicationContext).setBrand(1);
            }
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "init PPS SDK error, e = " + e10.toString());
        }
    }

    private boolean isSupportDownloadAppActivities() {
        String strM80942m = C13452e.m80781L().m80942m();
        boolean zEqualsIgnoreCase = !TextUtils.isEmpty(strM80942m) ? "CN".equalsIgnoreCase(strM80942m) : false;
        boolean zM1202Q0 = C0209d.m1202Q0();
        boolean z10 = !C0209d.m1170F1();
        NotifyLogger.m29915i(TAG, "is support download app activities, is china user=" + zEqualsIgnoreCase + ", is china device=" + zM1202Q0 + ", is not pad= " + z10);
        return zEqualsIgnoreCase && zM1202Q0 && z10;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        if (!isSupportDownloadAppActivities()) {
            NotifyLogger.m29915i(TAG, "not support pps ads");
            RecommendCardManager.getInstance().clearAds(this.entrance);
            this.latch.countDown();
            return;
        }
        String[] ppsAdid = HiCloudBrandBannerManager.getInstance().getPpsAdid(this.entrance);
        this.adIds = ppsAdid;
        if (ppsAdid.length == 0) {
            RecommendCardManager.getInstance().clearAds(this.entrance);
            this.latch.countDown();
            return;
        }
        initPPSSDK(this.context);
        NotifyLogger.m29915i(TAG, "PpsAdid length: " + this.adIds.length);
        HiAd.getInstance(C0213f.m1377a()).initLog(true, 4);
        NativeAdLoader nativeAdLoader = new NativeAdLoader(this.context, this.adIds);
        this.adLoader = nativeAdLoader;
        nativeAdLoader.setRequestOptions(AdSwitchManager.getInstance().getPpsRequestOptionsBuilder().build());
        this.adLoader.setListener(new LoaderNativeAdListener());
        this.adLoader.loadAds(4, false);
    }
}

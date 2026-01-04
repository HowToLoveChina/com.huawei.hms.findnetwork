package com.huawei.openalliance.p169ad.analysis;

import android.content.Context;
import com.huawei.hms.ads.analysis.DynamicLoaderAnalysis;
import com.huawei.hms.ads.analysis.IDynamicLoaderAnalysis;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.inter.HiAd;

/* renamed from: com.huawei.openalliance.ad.analysis.g */
/* loaded from: classes8.dex */
public class C6926g {

    /* renamed from: a */
    private static a f31974a;

    /* renamed from: com.huawei.openalliance.ad.analysis.g$a */
    public static class a implements IDynamicLoaderAnalysis {

        /* renamed from: a */
        private Context f31975a;

        public a(Context context) {
            this.f31975a = context.getApplicationContext();
        }

        public void onLoaderException(String str, String str2, int i10, String str3) {
            if (HiAd.getInstance(this.f31975a).isEnableUserInfo()) {
                new C6928i(this.f31975a).m39206a(str, str2, i10, str3);
            }
        }

        public void onLoaderSuccess(String str, String str2, long j10) {
            if (HiAd.getInstance(this.f31975a).isEnableUserInfo()) {
                new C6928i(this.f31975a).m39207a(str, str2, j10);
            }
        }
    }

    /* renamed from: a */
    public static void m39168a(Context context) {
        try {
            if (f31974a == null) {
                f31974a = new a(context);
            }
            DynamicLoaderAnalysis.getInstance().registerDynamicLoaderAnalysis("hiadsdk", f31974a);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("DyLoaderAnalysisUtil", "init analysis err: %s", th2.getClass().getSimpleName());
        }
    }
}

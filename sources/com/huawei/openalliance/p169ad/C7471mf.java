package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.constant.Config;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.iab.omid.library.huawei.adsession.AdSessionContext;
import com.iab.omid.library.huawei.adsession.Partner;
import com.iab.omid.library.huawei.adsession.VerificationScriptResource;
import java.io.IOException;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.mf */
/* loaded from: classes8.dex */
public class C7471mf {

    /* renamed from: a */
    private static boolean f34632a = C7418ma.m45655a("com.iab.omid.library.huawei.adsession.AdSessionContext");

    /* renamed from: b */
    private Context f34633b;

    public C7471mf(Context context) {
        this.f34633b = context;
    }

    /* renamed from: a */
    public AdSessionContext m45833a(C7477ml c7477ml, String str) throws Throwable {
        String strM48154a;
        if (!C7418ma.m45655a("com.iab.omid.library.huawei.adsession.Partner") || !C7418ma.m45655a("com.iab.omid.library.huawei.adsession.VerificationScriptResource") || !C7418ma.m45655a("com.iab.omid.library.huawei.adsession.AdSessionContext")) {
            AbstractC7185ho.m43823c("AdSessionContextWrapper", "createNativeAdSessionContext, not available ");
            return null;
        }
        List<VerificationScriptResource> listM45845b = c7477ml.m45845b();
        if (listM45845b.isEmpty()) {
            return null;
        }
        try {
            strM48154a = AbstractC7806cz.m48154a("openmeasure/omsdk-v1.js", this.f34633b);
        } catch (IOException e10) {
            AbstractC7185ho.m43823c("AdSessionContextWrapper", "getNativeAdSession: " + AbstractC7819dl.m48375a(e10.getMessage()));
            strM48154a = null;
        }
        if (strM48154a == null) {
            return null;
        }
        return AdSessionContext.createNativeAdSessionContext(Partner.createPartner("Huawei", Config.SDK_VERSION), strM48154a, listM45845b, str, (String) null);
    }

    /* renamed from: a */
    public static boolean m45832a() {
        return f34632a;
    }
}

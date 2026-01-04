package com.huawei.openalliance.p169ad.beans.inner;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.exception.C7110b;

/* loaded from: classes8.dex */
public class GrsCountryCodeBean {
    private static final String TAG = "GrsCountryCodeBean";
    private static final String UNKNOWN = "UNKNOWN";
    private String countryCode = "UNKNOWN";

    /* renamed from: a */
    public String m39400a(Context context) {
        try {
            String issueCountryCode = GrsApp.getInstance().getIssueCountryCode(context);
            this.countryCode = issueCountryCode;
            return issueCountryCode;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c(TAG, "getIssueCountryCode via grs sdk: %s", th2.getClass().getSimpleName());
            throw new C7110b();
        }
    }
}

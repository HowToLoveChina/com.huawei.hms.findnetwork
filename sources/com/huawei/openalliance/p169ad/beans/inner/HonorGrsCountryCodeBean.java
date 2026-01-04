package com.huawei.openalliance.p169ad.beans.inner;

import android.content.Context;
import com.hihonor.common.grs.HihonorGrsApp;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import java.security.InvalidParameterException;

/* loaded from: classes8.dex */
public class HonorGrsCountryCodeBean {
    private static final String TAG = "HonorGrsCountryCodeBean";
    private static final String UNKNOWN = "UNKNOWN";
    private String countryCode = "UNKNOWN";

    /* renamed from: a */
    public String m39401a(Context context) {
        try {
            String issueCountryCode = HihonorGrsApp.getInstance().getIssueCountryCode(context);
            this.countryCode = issueCountryCode;
            return issueCountryCode;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c(TAG, "getIssueCountryCode via grs sdk: %s", th2.getClass().getSimpleName());
            throw new InvalidParameterException();
        }
    }
}

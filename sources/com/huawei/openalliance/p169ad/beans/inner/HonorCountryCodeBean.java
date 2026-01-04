package com.huawei.openalliance.p169ad.beans.inner;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.utils.C7736aj;
import com.huawei.openalliance.p169ad.utils.C7845x;
import java.util.Locale;

/* loaded from: classes8.dex */
public class HonorCountryCodeBean extends CountryCodeBean {
    private static final String TAG = "HonorCountryCodeBean";
    private static boolean isHonorGrsAvailable = C7736aj.m47499d();

    @Override // com.huawei.openalliance.p169ad.beans.inner.CountryCodeBean
    /* renamed from: a */
    public void mo39391a(Context context, boolean z10) {
        if (isHonorGrsAvailable && C6982bz.m41152b(context) && !C7845x.m48587n(context)) {
            try {
                this.countryCode = new HonorGrsCountryCodeBean().m39401a(context);
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c(TAG, "getIssueCountryCode via grs sdk: %s", th2.getClass().getSimpleName());
            }
        } else {
            m39392b(context, z10);
        }
        this.countryCode = this.countryCode.toUpperCase(Locale.ENGLISH);
    }
}

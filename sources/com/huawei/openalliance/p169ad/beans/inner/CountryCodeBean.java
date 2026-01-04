package com.huawei.openalliance.p169ad.beans.inner;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.constant.CountryConfig;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.C7736aj;
import com.huawei.openalliance.p169ad.utils.C7845x;
import java.util.Locale;

/* loaded from: classes8.dex */
public class CountryCodeBean {
    public static final String COUNTRYCODE_CN = "CN";
    private static final int COUNTRYCODE_SIZE = 2;
    private static final String LOCALE_COUNTRYSYSTEMPROP = "ro.product.locale";
    private static final String LOCALE_INFO = "LOCALE_INFO";
    public static final String LOCALE_REGION_COUNTRYSYSTEMPROP = "ro.product.locale.region";
    public static final String OVERSEAS = "OVERSEAS";
    private static final String SIM_COUNTRY = "SIM_COUNTRY";
    private static final String SPECIAL_COUNTRYCODE_CN = "cn";
    private static final String SPECIAL_COUNTRYCODE_EU = "eu";
    private static final String SPECIAL_COUNTRYCODE_LA = "la";
    private static final String TAG = "CountryCodeBean";
    public static final String UNKNOWN = "UNKNOWN";
    public static final String VENDORCOUNTRY_SYSTEMPROP = "ro.hw.country";
    public static final String VENDORCOUNTRY_SYSTEMPROP_HN = "msc.sys.country";
    private static final String VENDOR_COUNTRY = "VENDOR_COUNTRY";
    public static final String VENDOR_SYSTEMPROP = "ro.hw.vendor";
    public static final String VENDOR_SYSTEMPROP_HN = "msc.sys.vendor";
    private static boolean isGrsAvailable = C7736aj.m47498c();
    protected String countryCode;

    public CountryCodeBean(Context context) {
        this(context, false);
    }

    /* renamed from: b */
    private void m39383b(Context context) {
        m39387c(context, false);
    }

    /* renamed from: c */
    private void m39385c() {
        String str = this.countryCode;
        if (str == null || str.length() != 2) {
            this.countryCode = "UNKNOWN";
        }
    }

    /* renamed from: d */
    private void m39388d() {
        String strM48322d = AbstractC7811dd.m48322d();
        this.countryCode = strM48322d;
        if (TextUtils.isEmpty(strM48322d)) {
            this.countryCode = "UNKNOWN";
        }
    }

    /* renamed from: a */
    public String m39390a() {
        return this.countryCode;
    }

    public CountryCodeBean(Context context, boolean z10) {
        this.countryCode = "UNKNOWN";
        if (context == null) {
            return;
        }
        mo39391a(context.getApplicationContext(), z10);
    }

    /* renamed from: a */
    private void m39382a(Context context) {
        try {
            this.countryCode = AbstractC7811dd.m48289a(C6982bz.m41155e(context) ? VENDORCOUNTRY_SYSTEMPROP_HN : VENDORCOUNTRY_SYSTEMPROP);
            if (this.countryCode == null) {
                this.countryCode = "UNKNOWN";
            }
            if (!SPECIAL_COUNTRYCODE_EU.equalsIgnoreCase(this.countryCode) && !SPECIAL_COUNTRYCODE_LA.equalsIgnoreCase(this.countryCode) && CountryConfig.isValidCountryCode(this.countryCode)) {
                m39385c();
                return;
            }
            this.countryCode = "UNKNOWN";
        } catch (Exception unused) {
            AbstractC7185ho.m43823c(TAG, "get getVendorCountryCode error");
        }
    }

    /* renamed from: c */
    private void m39386c(Context context) {
        try {
            m39388d();
        } catch (Exception unused) {
            AbstractC7185ho.m43823c(TAG, "get getLocaleCountryCode error");
        }
    }

    /* renamed from: d */
    private void m39389d(Context context) {
        int iLastIndexOf;
        try {
            this.countryCode = AbstractC7811dd.m48289a(LOCALE_REGION_COUNTRYSYSTEMPROP);
            AbstractC7185ho.m43820b(TAG, "countryCode by ro.product.locale.region is:" + this.countryCode);
            if (TextUtils.isEmpty(this.countryCode) || "UNKNOWN".equals(this.countryCode)) {
                String strM48289a = AbstractC7811dd.m48289a(LOCALE_COUNTRYSYSTEMPROP);
                if (!TextUtils.isEmpty(strM48289a) && (iLastIndexOf = strM48289a.lastIndexOf("-")) != -1) {
                    this.countryCode = strM48289a.substring(iLastIndexOf + 1);
                    AbstractC7185ho.m43820b(TAG, "countryCode by ro.product.locale is:" + this.countryCode);
                }
            }
            if (SPECIAL_COUNTRYCODE_CN.equalsIgnoreCase(this.countryCode)) {
                return;
            }
            this.countryCode = "UNKNOWN";
        } catch (Exception unused) {
            AbstractC7185ho.m43823c(TAG, "get getProductCountryCode error");
        }
    }

    /* renamed from: b */
    public void m39392b(Context context, boolean z10) {
        if (context == null) {
            throw new NullPointerException("context must be not null.Please provide app's Context");
        }
        try {
            if (C6982bz.m41153c(context) && C6982bz.m41148a(context).mo41175d()) {
                this.countryCode = "CN";
                AbstractC7185ho.m43820b(TAG, "getCountryCode get country code from chinaROM");
                return;
            }
            if (C6982bz.m41152b(context)) {
                m39382a(context);
                if (m39384b()) {
                    AbstractC7185ho.m43820b(TAG, "get issue_country code from VENDOR_COUNTRY");
                    return;
                }
            }
            m39383b(context);
            if (m39384b()) {
                AbstractC7185ho.m43820b(TAG, "get issue_country code from SIM_COUNTRY");
                return;
            }
            if (C7845x.m48587n(context)) {
                AbstractC7185ho.m43820b(TAG, "pad skip locale get issue_country code from grs ip");
                return;
            }
            m39386c(context);
            if (m39384b()) {
                AbstractC7185ho.m43820b(TAG, "get issue_country code from LOCALE_INFO");
            } else {
                AbstractC7185ho.m43823c(TAG, "fail to get grs countryCode");
            }
        } catch (Exception unused) {
            AbstractC7185ho.m43823c(TAG, "get CountryCode error");
        }
    }

    /* renamed from: b */
    private boolean m39384b() {
        return !"UNKNOWN".equals(this.countryCode);
    }

    /* renamed from: c */
    private void m39387c(Context context, boolean z10) {
        StringBuilder sb2;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
            if (telephonyManager != null) {
                if (!z10 || telephonyManager.getPhoneType() == 2) {
                    this.countryCode = telephonyManager.getSimCountryIso();
                    sb2 = new StringBuilder();
                    sb2.append("countryCode by SimCountryIso is: ");
                    sb2.append(this.countryCode);
                } else {
                    this.countryCode = telephonyManager.getNetworkCountryIso();
                    sb2 = new StringBuilder();
                    sb2.append("countryCode by NetworkCountryIso is: ");
                    sb2.append(this.countryCode);
                }
                AbstractC7185ho.m43820b(TAG, sb2.toString());
            }
            m39385c();
        } catch (Exception unused) {
            AbstractC7185ho.m43823c(TAG, "get getSimCountryCode error");
        }
    }

    /* renamed from: a */
    public void mo39391a(Context context, boolean z10) {
        if (isGrsAvailable && C6982bz.m41152b(context) && !C7845x.m48587n(context)) {
            try {
                this.countryCode = new GrsCountryCodeBean().m39400a(context);
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c(TAG, "getIssueCountryCode via grs sdk: %s", th2.getClass().getSimpleName());
            }
        } else {
            m39392b(context, z10);
        }
        this.countryCode = this.countryCode.toUpperCase(Locale.ENGLISH);
    }
}

package com.huawei.hms.framework.network.grs.p122g;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.C5429a;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.p120e.C5434a;
import com.huawei.hms.framework.network.grs.p120e.C5436c;
import com.huawei.hms.framework.network.grs.p122g.p124j.C5453c;
import com.huawei.hms.framework.network.grs.p125h.C5459e;
import org.json.JSONException;

/* renamed from: com.huawei.hms.framework.network.grs.g.b */
/* loaded from: classes8.dex */
public class C5443b {

    /* renamed from: a */
    private final Context f24942a;

    /* renamed from: b */
    private final GrsBaseInfo f24943b;

    /* renamed from: c */
    private final C5434a f24944c;

    public C5443b(Context context, C5434a c5434a, GrsBaseInfo grsBaseInfo) {
        this.f24942a = context;
        this.f24943b = grsBaseInfo;
        this.f24944c = c5434a;
    }

    /* renamed from: a */
    public String m32245a(boolean z10) {
        String strM32301a;
        String str = C5429a.m32152a(this.f24944c.m32190a().m32200a("geoipCountryCode", ""), "geoip.countrycode").get("ROOT");
        Logger.m32141i("GeoipCountry", "geoIpCountry is: " + str);
        String strM32200a = this.f24944c.m32190a().m32200a("geoipCountryCodetime", "0");
        long j10 = 0;
        if (!TextUtils.isEmpty(strM32200a) && strM32200a.matches("\\d+")) {
            try {
                j10 = Long.parseLong(strM32200a);
            } catch (NumberFormatException e10) {
                Logger.m32146w("GeoipCountry", "convert urlParamKey from String to Long catch NumberFormatException.", e10);
            }
        }
        if (TextUtils.isEmpty(str) || C5459e.m32331a(Long.valueOf(j10))) {
            C5453c c5453c = new C5453c(this.f24943b, this.f24942a);
            c5453c.m32309a("geoip.countrycode");
            C5436c c5436cM32196c = this.f24944c.m32196c();
            if (c5436cM32196c != null) {
                try {
                    strM32301a = C5449h.m32301a(c5436cM32196c.m32200a("services", ""), c5453c.m32311c());
                } catch (JSONException e11) {
                    Logger.m32147w("GeoipCountry", "getGeoipCountry merge services occure jsonException. %s", StringUtils.anonymizeMessage(e11.getMessage()));
                    strM32301a = null;
                }
                if (!TextUtils.isEmpty(strM32301a)) {
                    c5436cM32196c.m32204b("services", strM32301a);
                }
            }
            if (z10) {
                C5445d c5445dM32297a = this.f24944c.m32194b().m32297a(c5453c, "geoip.countrycode", c5436cM32196c, -1);
                if (c5445dM32297a != null) {
                    str = C5429a.m32152a(c5445dM32297a.m32284j(), "geoip.countrycode").get("ROOT");
                }
                Logger.m32141i("GeoipCountry", "sync request to query geoip.countrycode is:" + str);
            } else {
                Logger.m32141i("GeoipCountry", "async request to query geoip.countrycode");
                this.f24944c.m32194b().m32299a(c5453c, null, "geoip.countrycode", c5436cM32196c, -1);
            }
        }
        return str;
    }
}

package com.huawei.hms.locationSdk;

import as.C1016d;
import com.huawei.hms.support.api.entity.location.coordinate.LonLat;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import p295fs.C9767a;
import p295fs.C9769c;

/* renamed from: com.huawei.hms.locationSdk.d */
/* loaded from: classes8.dex */
public class C5704d {
    /* renamed from: a */
    private static boolean m33045a(double d10, double d11) {
        return d10 >= -90.0d && d10 <= 90.0d && d11 >= -180.0d && d11 <= 180.0d;
    }

    /* renamed from: a */
    public static LonLat m33044a(double d10, double d11, int i10) {
        if (i10 != 1) {
            C1016d.m6183c("ConvertCoord", "coordType is not 84");
            return null;
        }
        if (!m33045a(d10, d11)) {
            HMSLocationLog.m36660e("ConvertCoord", "", "transform latLon is not Valid Coordinates");
            return null;
        }
        C9769c c9769cM60794a = C9767a.m60794a(d10, d11, i10);
        if (c9769cM60794a == null) {
            return null;
        }
        LonLat lonLat = new LonLat();
        lonLat.setLatitude(c9769cM60794a.m60801a());
        lonLat.setLongitude(c9769cM60794a.m60802b());
        return lonLat;
    }
}

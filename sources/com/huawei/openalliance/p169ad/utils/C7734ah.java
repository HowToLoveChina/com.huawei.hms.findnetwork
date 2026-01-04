package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7124fh;
import java.util.List;
import java.util.Locale;

/* renamed from: com.huawei.openalliance.ad.utils.ah */
/* loaded from: classes2.dex */
public class C7734ah {
    /* renamed from: a */
    public static Address m47484a(Context context, Double d10, Double d11) {
        List<Address> fromLocation;
        if (context == null) {
            return null;
        }
        try {
            fromLocation = new Geocoder(context, Locale.getDefault()).getFromLocation(d11.doubleValue(), d10.doubleValue(), 1);
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("GeoLocationUtil", "onGetGeoError Exception:" + th2.getClass().getSimpleName());
            fromLocation = null;
        }
        if (fromLocation == null || fromLocation.size() <= 0) {
            return null;
        }
        return fromLocation.get(0);
    }

    /* renamed from: a */
    public static com.huawei.openalliance.p169ad.beans.metadata.Address m47485a(Address address) {
        if (address == null) {
            return null;
        }
        com.huawei.openalliance.p169ad.beans.metadata.Address address2 = new com.huawei.openalliance.p169ad.beans.metadata.Address();
        address2.m39581a(address.getCountryCode());
        address2.m39582b(AbstractC7806cz.m48170d(address.getAdminArea()));
        address2.m39583c(AbstractC7806cz.m48170d(address.getLocality()));
        address2.m39584d(AbstractC7806cz.m48170d(address.getSubLocality()));
        address2.m39585e(AbstractC7806cz.m48170d(address.getSubAdminArea()));
        address2.m39586f(AbstractC7806cz.m48170d(address.getThoroughfare()));
        address2.m39587g(AbstractC7806cz.m48170d(address.getSubThoroughfare()));
        address2.m39588h(AbstractC7806cz.m48170d(address.getFeatureName()));
        address2.m39589i(address.getLocale().toString());
        return address2;
    }

    /* renamed from: a */
    public static boolean m47486a(Context context) {
        if (context == null) {
            return false;
        }
        if (C7124fh.m43316b(context).mo43089w()) {
            return true;
        }
        AbstractC7185ho.m43820b("GeoLocationUtil", "collect geoinfo switch off");
        return false;
    }
}

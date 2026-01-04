package com.huawei.openalliance.p169ad.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.beans.inner.LocationSwitches;
import com.huawei.openalliance.p169ad.beans.metadata.Location;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.utils.C7761bh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.utils.bi */
/* loaded from: classes2.dex */
public class C7762bi {

    /* renamed from: a */
    private static final byte[] f35934a = new byte[0];

    /* renamed from: b */
    private static LocationManager f35935b = null;

    /* renamed from: c */
    private static String f35936c = null;

    /* renamed from: d */
    private static Location f35937d = null;

    /* renamed from: e */
    private static long f35938e = -1;

    /* renamed from: f */
    private static long f35939f = 1800000;

    /* renamed from: g */
    private static volatile boolean f35940g = false;

    /* renamed from: com.huawei.openalliance.ad.utils.bi$1 */
    public static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f35941a;

        public AnonymousClass1(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C7762bi.m47779a(context).m39415d()) {
                C7762bi.m47787b(context, 1);
            } else {
                AbstractC7185ho.m43820b("LocationUtils", "loc_tag sendAsyncLocationByNative failed because switch is off");
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.bi$2 */
    public static class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f35942a;

        public AnonymousClass2(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C7762bi.m47791d(context);
            } catch (Throwable th2) {
                AbstractC7185ho.m43826d("LocationUtils", "loc_tag asyncLocation exception: " + th2.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.bi$3 */
    public static class AnonymousClass3 implements LocationListener {

        /* renamed from: a */
        final /* synthetic */ Context f35943a;

        public AnonymousClass3(Context context) {
            context = context;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(android.location.Location location) {
            try {
                if (location != null) {
                    AbstractC7185ho.m43818a("LocationUtils", "loc_tag getLocationByNative Listener lat = %s, lon = %s", AbstractC7819dl.m48375a(String.valueOf(location.getLatitude())), AbstractC7819dl.m48375a(String.valueOf(location.getLongitude())));
                    C7762bi.m47780a(context, location);
                } else {
                    AbstractC7185ho.m43823c("LocationUtils", "loc_tag getLocationByNative Listener, but location is null");
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43821b("LocationUtils", "onLocationChanged ex: %s", th2.getClass().getSimpleName());
            }
            C7762bi.m47789b(this);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            AbstractC7185ho.m43817a("LocationUtils", "loc_tag getLocationByNative onProviderDisabled");
            C7762bi.m47789b(this);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            AbstractC7185ho.m43817a("LocationUtils", "loc_tag getLocationByNative onProviderEnabled");
            C7762bi.m47789b(this);
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i10, Bundle bundle) {
            AbstractC7185ho.m43817a("LocationUtils", "loc_tag getLocationByNative onStatusChanged");
            C7762bi.m47789b(this);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.bi$4 */
    public static class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ LocationListener f35944a;

        public AnonymousClass4(LocationListener locationListener) {
            locationListener = locationListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7762bi.m47789b(locationListener);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.bi$5 */
    public static class AnonymousClass5 implements C7761bh.a {

        /* renamed from: a */
        final /* synthetic */ Context f35945a;

        public AnonymousClass5(Context context) {
            context = context;
        }

        @Override // com.huawei.openalliance.p169ad.utils.C7761bh.a
        /* renamed from: a */
        public void mo47777a() {
            try {
                C7762bi.m47787b(context, 2);
            } catch (Throwable th2) {
                AbstractC7185ho.m43821b("LocationUtils", "onLocationAcquireFailed ex: %s", th2.getClass().getSimpleName());
            }
        }

        @Override // com.huawei.openalliance.p169ad.utils.C7761bh.a
        /* renamed from: a */
        public void mo47778a(android.location.Location location) {
            try {
                C7762bi.m47780a(context, location);
            } catch (Throwable th2) {
                AbstractC7185ho.m43821b("LocationUtils", "onLocationAcquired ex: %s", th2.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: a */
    public static LocationSwitches m47779a(Context context) {
        boolean zMo43402bc;
        LocationSwitches locationSwitchesM47796i = m47796i(context);
        if (locationSwitchesM47796i.m39416e()) {
            zMo43402bc = C7124fh.m43316b(context).mo43402bc();
            AbstractC7185ho.m43818a("LocationUtils", "loc_tag isSdkServerLocationSwitch = %s", Boolean.valueOf(zMo43402bc));
        } else {
            zMo43402bc = false;
        }
        locationSwitchesM47796i.m39409a(zMo43402bc);
        return locationSwitchesM47796i;
    }

    /* renamed from: c */
    private static boolean m47790c(Context context) {
        long jAbs = Math.abs(System.currentTimeMillis() - f35938e);
        f35939f = C7124fh.m43316b(context).mo43365aw();
        AbstractC7185ho.m43817a("LocationUtils", "loc_tag isRefreshOk intervalRefreshTime = " + f35939f + ", intervalTime = " + jAbs);
        if (jAbs >= f35939f) {
            return true;
        }
        AbstractC7185ho.m43817a("LocationUtils", "loc_tag isRefreshOk = false, too frequently (no ok)");
        return false;
    }

    /* renamed from: d */
    public static void m47791d(Context context) {
        if (m47795h(context)) {
            AbstractC7185ho.m43817a("LocationUtils", "loc_tag asyncLocation has location-sdk");
            try {
                m47794g(context);
                return;
            } catch (Throwable th2) {
                AbstractC7185ho.m43823c("LocationUtils", "loc_tag get location by kit error, " + th2.getClass().getSimpleName());
            }
        } else {
            AbstractC7185ho.m43817a("LocationUtils", "loc_tag asyncLocation has not location-sdk");
        }
        m47787b(context, 2);
    }

    /* renamed from: e */
    private static void m47792e(Context context) {
        if (f35937d == null) {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43817a("LocationUtils", "restoreLastKnownLocation");
            }
            Location locationMo43387bN = C7124fh.m43316b(context).mo43387bN();
            if (locationMo43387bN != null) {
                f35937d = locationMo43387bN;
            }
        }
    }

    /* renamed from: f */
    private static void m47793f(Context context) {
        if (m47790c(context)) {
            f35938e = System.currentTimeMillis();
            AbstractC7185ho.m43817a("LocationUtils", "update lastRefreshTime");
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.utils.bi.2

                /* renamed from: a */
                final /* synthetic */ Context f35942a;

                public AnonymousClass2(Context context2) {
                    context = context2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        C7762bi.m47791d(context);
                    } catch (Throwable th2) {
                        AbstractC7185ho.m43826d("LocationUtils", "loc_tag asyncLocation exception: " + th2.getClass().getSimpleName());
                    }
                }
            });
        }
    }

    /* renamed from: g */
    private static void m47794g(Context context) {
        AbstractC7185ho.m43817a("LocationUtils", "loc_tag getLocationByKit");
        try {
            new C7761bh(context, new C7761bh.a() { // from class: com.huawei.openalliance.ad.utils.bi.5

                /* renamed from: a */
                final /* synthetic */ Context f35945a;

                public AnonymousClass5(Context context2) {
                    context = context2;
                }

                @Override // com.huawei.openalliance.p169ad.utils.C7761bh.a
                /* renamed from: a */
                public void mo47777a() {
                    try {
                        C7762bi.m47787b(context, 2);
                    } catch (Throwable th2) {
                        AbstractC7185ho.m43821b("LocationUtils", "onLocationAcquireFailed ex: %s", th2.getClass().getSimpleName());
                    }
                }

                @Override // com.huawei.openalliance.p169ad.utils.C7761bh.a
                /* renamed from: a */
                public void mo47778a(android.location.Location location) {
                    try {
                        C7762bi.m47780a(context, location);
                    } catch (Throwable th2) {
                        AbstractC7185ho.m43821b("LocationUtils", "onLocationAcquired ex: %s", th2.getClass().getSimpleName());
                    }
                }
            }).m47774a();
        } catch (Throwable th2) {
            AbstractC7185ho.m43826d("LocationUtils", "loc_tag getLocationByKit, exception = " + th2.getClass().getSimpleName());
        }
    }

    /* renamed from: h */
    private static boolean m47795h(Context context) {
        return C7830i.m48419a(context, C7830i.m48434e(context));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* renamed from: i */
    private static LocationSwitches m47796i(Context context) {
        ?? M47797j;
        boolean zMo41183l = C6982bz.m41148a(context).mo41183l();
        boolean zM48562f = C7845x.m48562f(context);
        boolean z10 = false;
        try {
            M47797j = m47797j(context);
        } catch (Throwable th2) {
            AbstractC7185ho.m43826d("LocationUtils", "loc_tag hasLocationPermission = " + th2.getClass().getSimpleName());
            M47797j = 0;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("LocationUtils", "loc_tag isBaseLocationSwitch = %s", Boolean.valueOf(zMo41183l));
            AbstractC7185ho.m43818a("LocationUtils", "loc_tag isGpsSwitchOpen = %s", Boolean.valueOf(zM48562f));
            AbstractC7185ho.m43818a("LocationUtils", "loc_tag hasLocationPermission = %s", Boolean.valueOf((boolean) M47797j));
        }
        LocationSwitches locationSwitches = new LocationSwitches();
        locationSwitches.m39408a(zMo41183l ? 1 : 0);
        locationSwitches.m39411b(zM48562f ? 1 : 0);
        locationSwitches.m39414c(M47797j);
        if (zMo41183l && zM48562f && M47797j != 0) {
            z10 = true;
        }
        locationSwitches.m39412b(z10);
        return locationSwitches;
    }

    @TargetApi(23)
    /* renamed from: j */
    private static boolean m47797j(Context context) {
        if (context == null) {
            return false;
        }
        if (!m47784a()) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!AbstractC7784cd.m47887a(context, (String) it.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static Location m47780a(Context context, android.location.Location location) {
        if (location == null) {
            return null;
        }
        synchronized (f35934a) {
            try {
                if (f35937d == null) {
                    f35937d = new Location();
                }
                f35937d.m40233a(Double.valueOf(location.getLongitude()));
                f35937d.m40236b(Double.valueOf(location.getLatitude()));
                f35937d.m40234a(Long.valueOf(System.currentTimeMillis()));
                C7124fh.m43316b(context).mo43325a(f35937d);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f35937d;
    }

    /* renamed from: b */
    public static void m47787b(Context context, int i10) {
        AbstractC7185ho.m43817a("LocationUtils", "loc_tag getLocationByNative");
        LocationManager locationManager = (LocationManager) context.getSystemService(JsbMapKeyNames.H5_LOC);
        f35935b = locationManager;
        if (locationManager == null) {
            AbstractC7185ho.m43826d("LocationUtils", "loc_tag getLocationByNative, nativeLocationManager is null, return");
            return;
        }
        List<String> providers = locationManager.getProviders(true);
        String str = "network";
        if (!providers.contains("network")) {
            str = "gps";
            if (!providers.contains("gps")) {
                AbstractC7185ho.m43823c("LocationUtils", "loc_tag nativeLocationProvider wrong, return");
                return;
            }
        }
        f35936c = str;
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("LocationUtils", "loc_tag native location provider is: %s", f35936c);
        }
        try {
            String str2 = f35936c;
            if (str2 != null) {
                if (1 == i10) {
                    android.location.Location lastKnownLocation = f35935b.getLastKnownLocation(str2);
                    if (lastKnownLocation == null) {
                        AbstractC7185ho.m43823c("LocationUtils", "loc_tag getLocationByNative, but location is null");
                        return;
                    } else {
                        AbstractC7185ho.m43818a("LocationUtils", "loc_tag getLocationByNative getLastKnownLocation lat =  %s, lon = %s", AbstractC7819dl.m48375a(String.valueOf(lastKnownLocation.getLatitude())), AbstractC7819dl.m48375a(String.valueOf(lastKnownLocation.getLongitude())));
                        m47780a(context, lastKnownLocation);
                        return;
                    }
                }
                if (2 != i10) {
                    AbstractC7185ho.m43817a("LocationUtils", "loc_tag requestLocationByNative not correct type");
                    return;
                }
                AbstractC7185ho.m43820b("LocationUtils", "loc_tag getLocationByNative requestLocationUpdates");
                f35940g = false;
                AnonymousClass3 anonymousClass3 = new LocationListener() { // from class: com.huawei.openalliance.ad.utils.bi.3

                    /* renamed from: a */
                    final /* synthetic */ Context f35943a;

                    public AnonymousClass3(Context context2) {
                        context = context2;
                    }

                    @Override // android.location.LocationListener
                    public void onLocationChanged(android.location.Location location) {
                        try {
                            if (location != null) {
                                AbstractC7185ho.m43818a("LocationUtils", "loc_tag getLocationByNative Listener lat = %s, lon = %s", AbstractC7819dl.m48375a(String.valueOf(location.getLatitude())), AbstractC7819dl.m48375a(String.valueOf(location.getLongitude())));
                                C7762bi.m47780a(context, location);
                            } else {
                                AbstractC7185ho.m43823c("LocationUtils", "loc_tag getLocationByNative Listener, but location is null");
                            }
                        } catch (Throwable th2) {
                            AbstractC7185ho.m43821b("LocationUtils", "onLocationChanged ex: %s", th2.getClass().getSimpleName());
                        }
                        C7762bi.m47789b(this);
                    }

                    @Override // android.location.LocationListener
                    public void onProviderDisabled(String str3) {
                        AbstractC7185ho.m43817a("LocationUtils", "loc_tag getLocationByNative onProviderDisabled");
                        C7762bi.m47789b(this);
                    }

                    @Override // android.location.LocationListener
                    public void onProviderEnabled(String str3) {
                        AbstractC7185ho.m43817a("LocationUtils", "loc_tag getLocationByNative onProviderEnabled");
                        C7762bi.m47789b(this);
                    }

                    @Override // android.location.LocationListener
                    public void onStatusChanged(String str3, int i102, Bundle bundle) {
                        AbstractC7185ho.m43817a("LocationUtils", "loc_tag getLocationByNative onStatusChanged");
                        C7762bi.m47789b(this);
                    }
                };
                f35935b.requestSingleUpdate(f35936c, anonymousClass3, Looper.getMainLooper());
                AbstractC7817dj.m48364a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.bi.4

                    /* renamed from: a */
                    final /* synthetic */ LocationListener f35944a;

                    public AnonymousClass4(LocationListener anonymousClass32) {
                        locationListener = anonymousClass32;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        C7762bi.m47789b(locationListener);
                    }
                }, 30000L);
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43826d("LocationUtils", "loc_tag getLocationByNative, exception = " + th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public static Location m47781a(Context context, RequestOptions requestOptions, Location location) {
        boolean zM47785a = m47785a(context, requestOptions);
        AbstractC7185ho.m43821b("LocationUtils", "loc_tag isMediaAllow: %s", Boolean.valueOf(zM47785a));
        LocationSwitches locationSwitchesM47779a = m47779a(context);
        Location location2 = null;
        if (zM47785a && locationSwitchesM47779a.m39415d()) {
            if (location == null) {
                m47793f(context);
                Location location3 = f35937d;
                if (location3 != null) {
                    location2 = location3.m40229a();
                }
            } else {
                Location locationM40229a = location.m40229a();
                locationM40229a.m40234a(Long.valueOf(System.currentTimeMillis()));
                locationM40229a.m40230a(1);
                location2 = locationM40229a;
            }
            m47792e(context);
        } else {
            AbstractC7185ho.m43820b("LocationUtils", "loc_tag isLocationAvailable = false, return null");
        }
        if (location2 == null) {
            location2 = new Location();
        }
        location2.m40232a(locationSwitchesM47779a);
        return location2;
    }

    /* renamed from: b */
    public static void m47788b(Context context, RequestOptions requestOptions) {
        if (m47785a(context, requestOptions) && m47790c(context)) {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.utils.bi.1

                /* renamed from: a */
                final /* synthetic */ Context f35941a;

                public AnonymousClass1(Context context2) {
                    context = context2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (C7762bi.m47779a(context).m39415d()) {
                        C7762bi.m47787b(context, 1);
                    } else {
                        AbstractC7185ho.m43820b("LocationUtils", "loc_tag sendAsyncLocationByNative failed because switch is off");
                    }
                }
            });
        }
    }

    /* renamed from: b */
    public static void m47789b(LocationListener locationListener) {
        if (f35940g || f35935b == null || locationListener == null) {
            return;
        }
        AbstractC7185ho.m43820b("LocationUtils", "loc_tag remove native location updates");
        try {
            f35935b.removeUpdates(locationListener);
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("LocationUtils", "loc_tag remove native location updates ex: %s", th2.getClass().getSimpleName());
        }
        f35940g = true;
    }

    /* renamed from: a */
    private static boolean m47784a() {
        return true;
    }

    /* renamed from: a */
    public static boolean m47785a(Context context, RequestOptions requestOptions) {
        Boolean boolM40724d;
        if (requestOptions == null || requestOptions.m40724d() == null) {
            RequestOptions requestConfiguration = HiAd.getInstance(context).getRequestConfiguration();
            if (requestConfiguration == null || requestConfiguration.m40724d() == null) {
                return true;
            }
            boolM40724d = requestConfiguration.m40724d();
        } else {
            boolM40724d = requestOptions.m40724d();
        }
        return boolM40724d.booleanValue();
    }
}

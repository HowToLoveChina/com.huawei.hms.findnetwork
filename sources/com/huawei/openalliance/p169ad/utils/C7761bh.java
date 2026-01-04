package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import com.huawei.hms.location.FusedLocationProviderClient;
import com.huawei.hms.location.LocationAvailability;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationResult;
import com.huawei.hms.location.LocationServices;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;

/* renamed from: com.huawei.openalliance.ad.utils.bh */
/* loaded from: classes2.dex */
public class C7761bh {

    /* renamed from: a */
    LocationCallback f35922a;

    /* renamed from: b */
    LocationRequest f35923b;

    /* renamed from: c */
    private FusedLocationProviderClient f35924c;

    /* renamed from: d */
    private a f35925d;

    /* renamed from: e */
    private volatile boolean f35926e = false;

    /* renamed from: com.huawei.openalliance.ad.utils.bh$a */
    public interface a {
        /* renamed from: a */
        void mo47777a();

        /* renamed from: a */
        void mo47778a(Location location);
    }

    public C7761bh(Context context, final a aVar) throws IllegalArgumentException {
        if (context == null || aVar == null) {
            return;
        }
        this.f35925d = aVar;
        this.f35924c = LocationServices.getFusedLocationProviderClient(context);
        LocationRequest locationRequest = new LocationRequest();
        this.f35923b = locationRequest;
        locationRequest.setPriority(100);
        this.f35923b.setNumUpdates(1);
        this.f35923b.setInterval(5000L);
        this.f35922a = new LocationCallback() { // from class: com.huawei.openalliance.ad.utils.bh.1
            @Override // com.huawei.hms.location.LocationCallback
            public void onLocationAvailability(LocationAvailability locationAvailability) {
                if (locationAvailability != null) {
                    AbstractC7185ho.m43818a("LocationUtils", "loc_tag onLocationResult onLocationAvailability isLocationAvailable: %s", Boolean.valueOf(locationAvailability.isLocationAvailable()));
                }
            }

            @Override // com.huawei.hms.location.LocationCallback
            public void onLocationResult(LocationResult locationResult) {
                String str;
                AbstractC7185ho.m43817a("LocationUtils", "loc_tag getLocationByKit onLocationResult-callback");
                if (locationResult == null) {
                    str = "loc_tag getLocationByKit onLocationResult-callback is null";
                } else if (AbstractC7760bg.m47767a(locationResult.getLocations())) {
                    str = "loc_tag getLocationByKit onLocationResult-callback getLocations() is wrong";
                } else {
                    Location location = locationResult.getLocations().get(0);
                    if (location != null) {
                        AbstractC7185ho.m43818a("LocationUtils", "loc_tag getLocationByKit onLocationResult-callback lat = %s, lon = %s", AbstractC7819dl.m48375a(String.valueOf(location.getLatitude())), AbstractC7819dl.m48375a(String.valueOf(location.getLongitude())));
                        aVar.mo47778a(location);
                        C7761bh.this.f35926e = true;
                    }
                    str = "loc_tag getLocationByKit onLocationResult-callback location is null";
                }
                AbstractC7185ho.m43823c("LocationUtils", str);
                aVar.mo47777a();
                C7761bh.this.f35926e = true;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m47772b() {
        if (this.f35926e) {
            return;
        }
        try {
            this.f35924c.removeLocationUpdates(this.f35922a).addOnSuccessListener(new InterfaceC8939g<Void>() { // from class: com.huawei.openalliance.ad.utils.bh.6
                @Override // p208cq.InterfaceC8939g
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(Void r22) {
                    AbstractC7185ho.m43817a("LocationUtils", "loc_tag removeLocationUpdates onSuccess");
                    C7761bh.this.f35926e = true;
                }
            }).addOnFailureListener(new InterfaceC8938f() { // from class: com.huawei.openalliance.ad.utils.bh.5
                @Override // p208cq.InterfaceC8938f
                public void onFailure(Exception exc) {
                    AbstractC7185ho.m43818a("LocationUtils", "loc_tag removeLocationUpdates onFailure:%s", exc.getClass().getSimpleName());
                    C7761bh.this.f35926e = false;
                }
            });
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("LocationUtils", "loc_tag removeLocationUpdates encounter exception:" + th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public void m47774a() {
        if (this.f35924c == null) {
            return;
        }
        this.f35926e = false;
        this.f35924c.requestLocationUpdates(this.f35923b, this.f35922a, Looper.getMainLooper()).addOnSuccessListener(new InterfaceC8939g<Void>() { // from class: com.huawei.openalliance.ad.utils.bh.3
            @Override // p208cq.InterfaceC8939g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r12) {
                AbstractC7185ho.m43820b("LocationUtils", "loc_tag requestLocationUpdates onSuccess");
            }
        }).addOnFailureListener(new InterfaceC8938f() { // from class: com.huawei.openalliance.ad.utils.bh.2
            @Override // p208cq.InterfaceC8938f
            public void onFailure(Exception exc) {
                AbstractC7185ho.m43826d("LocationUtils", "loc_tag requestLocationUpdates onFailure");
                C7761bh.this.f35925d.mo47777a();
                C7761bh.this.f35926e = true;
            }
        });
        AbstractC7817dj.m48364a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.bh.4
            @Override // java.lang.Runnable
            public void run() {
                C7761bh.this.m47772b();
            }
        }, 30000L);
    }
}

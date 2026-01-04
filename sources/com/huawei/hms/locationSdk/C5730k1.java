package com.huawei.hms.locationSdk;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.location.HWLocation;
import com.huawei.hms.location.LocationResult;
import com.huawei.hms.p148ui.SafeBundle;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.location.vdr.VdrManager;
import com.huawei.location.vdr.control.VDRControl;
import com.huawei.location.vdr.listener.IVdrLocationListener;
import com.huawei.riemann.location.common.utils.Constant;
import es.C9540e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"NewApi"})
/* renamed from: com.huawei.hms.locationSdk.k1 */
/* loaded from: classes8.dex */
public class C5730k1 extends C5727j1 implements IVdrLocationListener {

    /* renamed from: h */
    private AtomicBoolean f25528h;

    /* renamed from: i */
    private VdrManager f25529i;

    /* renamed from: j */
    private long f25530j;

    /* renamed from: k */
    private final String f25531k;

    /* renamed from: com.huawei.hms.locationSdk.k1$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLocationLog.m36662i(C5730k1.this.mo33104a(), ((AbstractC5696b) C5730k1.this).f25484a, "new thread to judge vdr config");
            if (new VDRControl().isSupport(C5730k1.this.f25531k)) {
                C5730k1.this.f25529i = VdrManager.getInstance();
                C5730k1.this.f25529i.registerVdrLocationLis(C5730k1.this);
            }
        }
    }

    /* renamed from: com.huawei.hms.locationSdk.k1$b */
    public class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ LocationResult f25533a;

        public b(LocationResult locationResult) {
            this.f25533a = locationResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5730k1.this.m33138a(this.f25533a);
            ((C5736m1) C5730k1.this).f25546d.m33121c().onLocationResult(this.f25533a);
        }
    }

    public C5730k1(String str, String str2, String str3, C5733l1 c5733l1, Looper looper, String str4, String str5) throws ApiException {
        super(str, str2, str3, c5733l1, looper, str4);
        this.f25528h = new AtomicBoolean(false);
        this.f25531k = str5;
    }

    @Override // com.huawei.location.vdr.listener.IVdrLocationListener
    public String getUuid() {
        return ((C5736m1) this).f25546d.m33126h();
    }

    @Override // com.huawei.location.vdr.listener.IVdrLocationListener
    public void onVdrLocationChanged(Location location) {
        HMSLocationLog.m36662i(mo33104a(), ((AbstractC5696b) this).f25484a, "onVdrLocationChanged");
        if (location != null && location.getElapsedRealtimeNanos() - this.f25530j >= TimeUnit.MILLISECONDS.toNanos(((C5736m1) this).f25546d.m33122d().getFastestInterval() + 100)) {
            HWLocation hWLocationM33114b = m33114b(location);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(hWLocationM33114b);
            this.f25549g.post(new b(LocationResult.create(arrayList)));
        }
    }

    @Override // com.huawei.hms.locationSdk.C5736m1
    /* renamed from: b */
    public void mo33116b(boolean z10) {
        super.mo33116b(z10);
        if (z10) {
            if (this.f25528h.get()) {
                HMSLocationLog.m36662i(mo33104a(), ((AbstractC5696b) this).f25484a, "vdr has been judged, do not new thread here");
                return;
            } else {
                this.f25528h.set(true);
                C9540e.m59581d().m59582a(new a());
                return;
            }
        }
        VdrManager vdrManager = this.f25529i;
        if (vdrManager != null) {
            vdrManager.unRegisterVdrLocationLis(((C5736m1) this).f25546d.m33126h());
            this.f25529i = null;
        }
    }

    /* renamed from: a */
    private boolean m33113a(Location location) {
        if (location == null) {
            return false;
        }
        return m33040a(new SafeBundle(location.getExtras()).getInt(Constant.LOCATION_SOURCE_TYPE, -1));
    }

    /* renamed from: b */
    public static HWLocation m33114b(Location location) {
        if (location == null) {
            return null;
        }
        HWLocation hWLocation = new HWLocation();
        hWLocation.setTime(location.getTime());
        hWLocation.setElapsedRealtimeNanos(location.getElapsedRealtimeNanos());
        hWLocation.setLatitude(location.getLatitude());
        hWLocation.setLongitude(location.getLongitude());
        hWLocation.setAltitude(location.getAltitude());
        hWLocation.setProvider(location.getProvider());
        hWLocation.setSpeed(location.getSpeed());
        hWLocation.setBearing(location.getBearing());
        hWLocation.setAccuracy(location.getAccuracy());
        hWLocation.setVerticalAccuracyMeters(location.getVerticalAccuracyMeters());
        hWLocation.setSpeedAccuracyMetersPerSecond(location.getSpeedAccuracyMetersPerSecond());
        hWLocation.setBearingAccuracyDegrees(location.getBearingAccuracyDegrees());
        HashMap map = new HashMap();
        Bundle extras = location.getExtras();
        if (extras != null && extras.containsKey("LocationSource")) {
            map.put("LocationSource", extras.get("LocationSource"));
        }
        hWLocation.setExtraInfo(map);
        return hWLocation;
    }

    @Override // com.huawei.hms.locationSdk.C5727j1, com.huawei.hms.locationSdk.C5736m1
    /* renamed from: a */
    public String mo33104a() {
        return "RequestLocationExVdrUpdatesTaskApiCall";
    }

    @Override // com.huawei.hms.locationSdk.C5736m1
    /* renamed from: b */
    public void mo33105b(LocationResult locationResult) {
        if (locationResult == null || locationResult.getLastHWLocation() == null) {
            HMSLocationLog.m36660e(mo33104a(), ((AbstractC5696b) this).f25484a, "locationResult is null or locationResult.getLastHWLocation is null");
            return;
        }
        VdrManager vdrManager = this.f25529i;
        if (vdrManager == null || !vdrManager.isVdrIntervalStart()) {
            m33138a(locationResult);
            ((C5736m1) this).f25546d.m33121c().onLocationResult(locationResult);
            return;
        }
        HMSLocationLog.m36657d(mo33104a(), ((AbstractC5696b) this).f25484a, "vdr sync location");
        if (m33113a(locationResult.getLastLocation())) {
            this.f25530j = locationResult.getLastLocation().getElapsedRealtimeNanos();
            ((C5736m1) this).f25546d.m33121c().onLocationResult(locationResult);
        }
        this.f25529i.syncLocation(locationResult.getLastLocation());
    }
}

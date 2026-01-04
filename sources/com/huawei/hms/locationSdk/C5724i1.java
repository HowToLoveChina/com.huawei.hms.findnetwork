package com.huawei.hms.locationSdk;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import as.C1016d;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.location.HWLocation;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationResult;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.location.mdc.AdsLocationControl;
import com.huawei.location.mdc.AdsLocationHelper;
import com.huawei.location.mdc.AdsLocationManager;
import com.huawei.location.mdc.IMdcLocationListener;
import es.C9540e;
import hu.C10343b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import p295fs.C9767a;
import p295fs.C9769c;

@SuppressLint({"NewApi"})
/* renamed from: com.huawei.hms.locationSdk.i1 */
/* loaded from: classes8.dex */
public class C5724i1 extends C5727j1 implements IMdcLocationListener {

    /* renamed from: h */
    private long f25520h;

    /* renamed from: com.huawei.hms.locationSdk.i1$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLocationLog.m36662i(C5724i1.this.mo33104a(), ((AbstractC5696b) C5724i1.this).f25484a, "new thread to start mdc location");
            if (C5724i1.this.m33100b()) {
                AdsLocationManager.getInstance().requestLocationUpdates(C5724i1.this);
            }
        }
    }

    /* renamed from: com.huawei.hms.locationSdk.i1$b */
    public class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Location f25522a;

        public b(Location location) {
            this.f25522a = location;
        }

        @Override // java.lang.Runnable
        public void run() {
            LocationResult locationResultM33103a = C5724i1.this.m33103a(this.f25522a);
            if (locationResultM33103a == null) {
                HMSLocationLog.m36660e(C5724i1.this.mo33104a(), ((AbstractC5696b) C5724i1.this).f25484a, "locationResult is null, return here.");
                return;
            }
            C5724i1.this.f25520h = SystemClock.elapsedRealtimeNanos();
            C5724i1.this.m33139d(locationResultM33103a);
            ((C5736m1) C5724i1.this).f25546d.m33121c().onLocationResult(locationResultM33103a);
        }
    }

    public C5724i1(String str, String str2, String str3, C5733l1 c5733l1, Looper looper, String str4, String str5) throws ApiException {
        super(str, str2, str3, c5733l1, looper, str4);
        m33102c();
    }

    /* renamed from: b */
    public static HWLocation m33099b(Location location) {
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

    /* renamed from: c */
    private void m33102c() {
        C9540e.m59581d().m59582a(new a());
    }

    @Override // com.huawei.location.mdc.IMdcLocationListener
    public String getUuid() {
        return ((C5736m1) this).f25546d.m33126h() == null ? "" : ((C5736m1) this).f25546d.m33126h();
    }

    @Override // com.huawei.location.mdc.IMdcLocationListener
    public void onMdcLocationChanged(Location location) {
        HMSLocationLog.m36657d(mo33104a(), ((AbstractC5696b) this).f25484a, "onMdcLocationChanged");
        if (location == null) {
            HMSLocationLog.m36660e(mo33104a(), ((AbstractC5696b) this).f25484a, "mdcLocation is null, return here.");
        } else {
            this.f25549g.post(new b(new Location(location)));
        }
    }

    @Override // com.huawei.location.mdc.IMdcLocationListener
    public void onMdcStatusChanged(boolean z10) {
    }

    @Override // com.huawei.hms.locationSdk.C5736m1
    /* renamed from: b */
    public void mo33105b(LocationResult locationResult) {
        if (locationResult == null || locationResult.getLastHWLocation() == null) {
            HMSLocationLog.m36660e(mo33104a(), ((AbstractC5696b) this).f25484a, "locationResult is null or locationResult.getLastHWLocation is null");
            return;
        }
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        if (m33097a(jElapsedRealtimeNanos)) {
            m33138a(locationResult);
            ((C5736m1) this).f25546d.m33121c().onLocationResult(locationResult);
            return;
        }
        HMSLocationLog.m36657d(mo33104a(), ((AbstractC5696b) this).f25484a, "do not report native location,lastReportTime: " + this.f25520h + ", currentTimeNanos: " + jElapsedRealtimeNanos);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m33100b() {
        return AdsLocationControl.isMdcControlEnable();
    }

    /* renamed from: a */
    public LocationResult m33103a(Location location) {
        String strMo33104a;
        String str;
        String str2;
        if (location == null) {
            strMo33104a = mo33104a();
            str = ((AbstractC5696b) this).f25484a;
            str2 = "location is null";
        } else {
            LocationRequest locationRequestM33122d = ((C5736m1) this).f25546d.m33122d();
            if (locationRequestM33122d != null) {
                int iM63687i = new C10343b(location.getExtras()).m63687i(AdsLocationHelper.MDC_COORDINATE_TYPE, -1);
                C1016d.m6186f(mo33104a(), "locationCoordinateType: " + iM63687i + ", location Request coordinateType: " + locationRequestM33122d.getCoordinateType());
                if (iM63687i == locationRequestM33122d.getCoordinateType()) {
                    return m33096a(location, iM63687i);
                }
                if (iM63687i == 0 && locationRequestM33122d.getCoordinateType() == 1) {
                    return m33101b(location, 1) ? m33096a(location, 1) : m33096a(location, 0);
                }
                if (iM63687i == 1 && locationRequestM33122d.getCoordinateType() == 0) {
                    return m33101b(location, 0) ? m33096a(location, 0) : m33096a(location, 1);
                }
                return null;
            }
            strMo33104a = mo33104a();
            str = ((AbstractC5696b) this).f25484a;
            str2 = "locationRequest is null";
        }
        HMSLocationLog.m36660e(strMo33104a, str, str2);
        return null;
    }

    /* renamed from: a */
    private LocationResult m33096a(Location location, int i10) {
        if (location == null) {
            return null;
        }
        HWLocation hWLocationM33099b = m33099b(location);
        hWLocationM33099b.setCoordinateType(i10);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(hWLocationM33099b);
        return LocationResult.create(arrayList);
    }

    /* renamed from: b */
    private boolean m33101b(Location location, int i10) {
        String strMo33104a;
        String str;
        String str2;
        try {
            C9769c c9769cM60796c = C9767a.m60796c(location.getLatitude(), location.getLongitude(), i10);
            if (c9769cM60796c == null) {
                HMSLocationLog.m36660e(mo33104a(), ((AbstractC5696b) this).f25484a, "convertCoordForMdc-- result is null");
                return false;
            }
            location.setLatitude(c9769cM60796c.m60801a());
            location.setLongitude(c9769cM60796c.m60802b());
            return true;
        } catch (ClassCastException unused) {
            strMo33104a = mo33104a();
            str = ((AbstractC5696b) this).f25484a;
            str2 = "convertCoordForMdc ClassCastException:";
            HMSLocationLog.m36660e(strMo33104a, str, str2);
            return false;
        } catch (Exception unused2) {
            strMo33104a = mo33104a();
            str = ((AbstractC5696b) this).f25484a;
            str2 = "convertCoordForMdc Exception";
            HMSLocationLog.m36660e(strMo33104a, str, str2);
            return false;
        }
    }

    @Override // com.huawei.hms.locationSdk.C5727j1, com.huawei.hms.locationSdk.C5736m1
    /* renamed from: a */
    public String mo33104a() {
        return "RequestLocationExMdcUpdatesTaskApiCall";
    }

    /* renamed from: a */
    private boolean m33097a(long j10) {
        return j10 - this.f25520h > TimeUnit.MILLISECONDS.toNanos(((C5736m1) this).f25546d.m33122d().getFastestInterval() + 1000);
    }
}

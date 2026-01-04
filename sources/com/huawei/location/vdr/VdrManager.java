package com.huawei.location.vdr;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import as.C1016d;
import at.C1021a;
import at.C1023c;
import bt.C1284a;
import bt.C1287d;
import com.huawei.location.vdr.listener.IVdrLocationListener;
import com.huawei.riemann.gnsslocation.api.vdr.VdrLocationClient;
import com.huawei.riemann.gnsslocation.core.bean.DeviceInfo;
import com.huawei.riemann.gnsslocation.core.bean.eph.Ephemeris;
import com.huawei.riemann.gnsslocation.core.bean.obs.Pvt;
import es.C9540e;
import es.C9542g;
import es.C9554s;
import et.C9557b;
import et.InterfaceC9556a;
import et.InterfaceC9558c;
import hu.C10343b;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import p236dt.C9307b;
import p296ft.C9770a;
import p296ft.C9772c;
import p531or.C11991a;

/* loaded from: classes8.dex */
public class VdrManager implements InterfaceC9558c, InterfaceC9556a {
    private static final String EPH_THREAD_NAME = "Loc-Vdr-EphUpdate";
    private static final long EPH_UPDATE_TIME = 30;
    private static final long SYNC_LOCATION_UPDATE_TIME = 200;
    private static final String TAG = "VdrManager";
    private static final byte[] VDR_SYNC_LOCK = new byte[0];
    private static volatile VdrManager instance;
    private Ephemeris currentEphemeris;
    private long ephExpiredTime = 0;
    private C1287d ephProvider;
    private final AtomicBoolean isVdrStart;
    private volatile long lastSyncTime;
    private final AtomicBoolean updateEphemeris;
    private C1023c vdrDataManager;
    private VdrLocationClient vdrLocationClient;

    /* renamed from: com.huawei.location.vdr.VdrManager$a */
    public class RunnableC6823a implements Runnable {
        public RunnableC6823a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Thread.currentThread().setName(VdrManager.EPH_THREAD_NAME + hashCode());
            VdrManager vdrManager = VdrManager.this;
            vdrManager.currentEphemeris = vdrManager.ephProvider.m7635e();
            if (VdrManager.this.currentEphemeris != null) {
                VdrManager vdrManager2 = VdrManager.this;
                vdrManager2.ephProvider.getClass();
                vdrManager2.ephExpiredTime = C1287d.m7629b();
                VdrManager.this.updateEphemeris.set(true);
            }
        }
    }

    private VdrManager() {
        C1016d.m6186f(TAG, "VdrManager init");
        this.isVdrStart = new AtomicBoolean(false);
        this.updateEphemeris = new AtomicBoolean(false);
    }

    private boolean checkAndUpdateEphemeris() {
        C1284a c1284a = new C1284a(System.currentTimeMillis());
        updateEphemeris(c1284a.m7619c());
        if (this.updateEphemeris.get() && this.currentEphemeris != null) {
            C1016d.m6186f(TAG, "updateEphemeris GpsEphemeris:" + C9542g.m59588a().toJson(this.currentEphemeris.getGpsEphemeris()));
            this.vdrLocationClient.updateEphemeris(this.currentEphemeris);
            this.updateEphemeris.set(false);
        }
        return c1284a.m7619c() < this.ephExpiredTime;
    }

    private boolean checkFirstRequestDataIsValid(C1021a c1021a) {
        return (c1021a.m6199b() == null || c1021a.m6200c() == null || c1021a.m6198a() == null) ? false : true;
    }

    private void clearVdr() {
        C1023c c1023c = this.vdrDataManager;
        if (c1023c != null) {
            c1023c.m6202b();
            this.vdrDataManager = null;
        }
        VdrLocationClient vdrLocationClient = this.vdrLocationClient;
        if (vdrLocationClient != null) {
            vdrLocationClient.stopLocation();
            this.vdrLocationClient = null;
        }
    }

    public static VdrManager getInstance() {
        if (instance == null) {
            synchronized (VDR_SYNC_LOCK) {
                try {
                    if (instance == null) {
                        instance = new VdrManager();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    private void handlerNativeLocationToVdr() {
        C1016d.m6186f(TAG, "vdr process fail, return native location here");
        C1023c c1023c = this.vdrDataManager;
        if (c1023c == null || c1023c.m6204d() == null) {
            return;
        }
        C9557b.m59666c().m59669d(this.vdrDataManager.m6204d());
    }

    private void handlerVdrLocation(C1021a c1021a) {
        Location locationM6199b = c1021a.m6199b();
        Pvt pvtBuild = locationM6199b != null ? Pvt.Builder.aPvt().withAccuracy(locationM6199b.getAccuracy()).withAltitude(locationM6199b.getAltitude()).withLatitude(locationM6199b.getLatitude()).withLongitude(locationM6199b.getLongitude()).withBearing(locationM6199b.getBearing()).withSpeed(locationM6199b.getSpeed()).withTime(locationM6199b.getTime()).build() : null;
        C1016d.m6181a(TAG, "process vdr start");
        Pvt pvtProcess = this.vdrLocationClient.process(pvtBuild, c1021a.m6200c(), c1021a.m6198a(), null);
        if (pvtProcess == null || pvtProcess.getLatitude() == 0.0d || pvtProcess.getLongitude() == 0.0d) {
            handlerNativeLocationToVdr();
            return;
        }
        C1016d.m6186f(TAG, "process vdr end, errorCode is: " + pvtProcess.getErrCode());
        C9557b c9557bM59666c = C9557b.m59666c();
        if (locationM6199b == null) {
            locationM6199b = new Location("GPS");
        }
        locationM6199b.setTime(System.currentTimeMillis());
        locationM6199b.setElapsedRealtimeNanos(SystemClock.elapsedRealtimeNanos());
        locationM6199b.setLongitude(pvtProcess.getLongitude());
        locationM6199b.setLatitude(pvtProcess.getLatitude());
        locationM6199b.setAltitude(pvtProcess.getAltitude());
        locationM6199b.setAccuracy(pvtProcess.getAccuracy());
        locationM6199b.setBearing(pvtProcess.getBearing());
        locationM6199b.setSpeed(pvtProcess.getSpeed());
        Bundle extras = locationM6199b.getExtras();
        C10343b c10343b = new C10343b(extras);
        if (pvtProcess.getErrCode() == 1) {
            if (c10343b.m63679a("LocationSource")) {
                c10343b.m63698t("LocationSource", extras.getInt("LocationSource") | 2);
            } else {
                c10343b.m63698t("LocationSource", 2);
            }
        }
        locationM6199b.setExtras(c10343b.m63683e());
        c9557bM59666c.m59669d(locationM6199b);
    }

    private void initVdrDataManager() {
        C1023c c1023c = new C1023c();
        this.vdrDataManager = c1023c;
        c1023c.m6206f(this);
        this.ephProvider = new C1287d();
    }

    private void loadVdrFile() {
        new C9307b().m58607g(this);
    }

    private synchronized void processVdrData(C1021a c1021a) {
        if (C9557b.m59666c().m59668b()) {
            C1016d.m6183c(TAG, "vdr listener is null");
            return;
        }
        if (this.vdrLocationClient == null) {
            C1016d.m6183c(TAG, "vdrLocationClient init failed");
            handlerNativeLocationToVdr();
            return;
        }
        if (c1021a == null) {
            C1016d.m6183c(TAG, "vdr data is null");
            handlerNativeLocationToVdr();
            return;
        }
        if (!checkAndUpdateEphemeris()) {
            C1016d.m6186f(TAG, "checkAndUpdateEphemeris failed,stop algo");
            if (this.isVdrStart.get()) {
                this.vdrLocationClient.stopLocation();
            }
            this.isVdrStart.set(false);
            handlerNativeLocationToVdr();
            return;
        }
        if (!this.isVdrStart.get()) {
            if (!checkFirstRequestDataIsValid(c1021a)) {
                C1016d.m6181a(TAG, "first requestData is not valid,dropping it!");
                handlerNativeLocationToVdr();
                return;
            }
            VdrLocationClient vdrLocationClient = this.vdrLocationClient;
            DeviceInfo.Builder builderWithSdkLevel = DeviceInfo.Builder.aDeviceInfo().withChipName(C9772c.m60806a(C9554s.m59653h("ro.board.platform", ""))).withManufacturer(Build.MANUFACTURER).withSdkLevel(Build.VERSION.SDK_INT);
            C1016d.m6186f("VdrAlgoUtil", "DeviceInfo:" + C9542g.m59588a().toJson(builderWithSdkLevel));
            int iStartLocation = vdrLocationClient.startLocation(builderWithSdkLevel.build());
            C1016d.m6186f(TAG, "processGnssLocation startLocation status:" + iStartLocation);
            if (iStartLocation != 0) {
                this.isVdrStart.set(false);
                handlerNativeLocationToVdr();
                return;
            }
            this.isVdrStart.set(true);
        }
        handlerVdrLocation(c1021a);
    }

    private void startVdrAlgo() throws IOException {
        VdrLocationClient vdrLocationClient = new VdrLocationClient(C11991a.m72145a(), C9770a.f48055b);
        this.vdrLocationClient = vdrLocationClient;
        DeviceInfo.Builder builderWithSdkLevel = DeviceInfo.Builder.aDeviceInfo().withChipName(C9772c.m60806a(C9554s.m59653h("ro.board.platform", ""))).withManufacturer(Build.MANUFACTURER).withSdkLevel(Build.VERSION.SDK_INT);
        C1016d.m6186f("VdrAlgoUtil", "DeviceInfo:" + C9542g.m59588a().toJson(builderWithSdkLevel));
        this.isVdrStart.set(vdrLocationClient.startLocation(builderWithSdkLevel.build()) == 0);
        Ephemeris ephemerisM7639k = this.ephProvider.m7639k();
        if (ephemerisM7639k != null) {
            this.ephProvider.getClass();
            this.ephExpiredTime = C1287d.m7629b();
            C1016d.m6186f(TAG, "updateEphemeris GpsEphemeris:" + C9542g.m59588a().toJson(ephemerisM7639k.getGpsEphemeris()));
            this.vdrLocationClient.updateEphemeris(ephemerisM7639k);
        }
    }

    private void updateEphemeris(long j10) {
        C1016d.m6186f(TAG, "currentGpsTime is : " + j10 + ", ephExpiredTime is : " + this.ephExpiredTime);
        if (j10 + EPH_UPDATE_TIME < this.ephExpiredTime) {
            return;
        }
        C9540e.m59581d().m59582a(new RunnableC6823a());
    }

    @Override // et.InterfaceC9556a
    public synchronized void handleLoadResult(boolean z10) {
        if (z10) {
            initVdrDataManager();
            startVdrAlgo();
        }
    }

    public boolean isVdrIntervalStart() {
        return this.vdrDataManager != null;
    }

    @Override // et.InterfaceC9558c
    public synchronized void onVdrDataReceived(C1021a c1021a) {
        processVdrData(c1021a);
    }

    public synchronized void registerVdrLocationLis(IVdrLocationListener iVdrLocationListener) {
        C9557b.m59666c().m59667a(iVdrLocationListener);
        if (!isVdrIntervalStart()) {
            loadVdrFile();
        }
    }

    public synchronized void syncLocation(Location location) {
        C1016d.m6181a(TAG, "ElapsedRealtimeNanos time is: " + location.getElapsedRealtimeNanos() + ", lastSyncTime is: " + this.lastSyncTime);
        if (location.getElapsedRealtimeNanos() - this.lastSyncTime < 200) {
            return;
        }
        C1023c c1023c = this.vdrDataManager;
        if (c1023c != null) {
            c1023c.m6205e(location);
            this.lastSyncTime = location.getElapsedRealtimeNanos();
        }
    }

    public synchronized void unRegisterVdrLocationLis(String str) {
        C9557b.m59666c().m59671f(str);
        if (C9557b.m59666c().m59668b()) {
            clearVdr();
            C1016d.m6186f(TAG, "stop vdr manager");
        }
    }
}

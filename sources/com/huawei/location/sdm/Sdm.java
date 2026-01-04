package com.huawei.location.sdm;

import android.location.GnssMeasurement;
import android.location.GnssMeasurementsEvent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import as.C1016d;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.hms.support.api.location.common.CollectionsUtil;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.StatusChangeMethods;
import com.huawei.riemann.common.api.location.SdmLocationClient;
import com.huawei.riemann.location.bean.DeviceInfo;
import com.huawei.riemann.location.bean.obs.GnssClock;
import com.huawei.riemann.location.bean.obs.GnssRawObservation;
import com.huawei.riemann.location.bean.obs.Pvt;
import com.huawei.riemann.location.bean.obs.SatelliteMeasurement;
import es.C9537b;
import es.C9550o;
import es.C9554s;
import hu.C10343b;
import ir.C10603b;
import p531or.C11991a;
import p659ts.C13067a;
import p717vs.C13486a;
import rs.C12622b;
import rs.C12623c;
import ss.C12850c;

/* loaded from: classes8.dex */
public class Sdm {

    /* renamed from: b */
    public LocationManager f31402b;

    /* renamed from: c */
    public HandlerC6811a f31403c;

    /* renamed from: d */
    public InterfaceC6822i f31404d;

    /* renamed from: e */
    public Location f31405e;

    /* renamed from: f */
    public HandlerThread f31406f;

    /* renamed from: g */
    public HandlerThread f31407g;

    /* renamed from: h */
    public C6812b f31408h;

    /* renamed from: i */
    public SdmLocationClient f31409i;

    /* renamed from: k */
    public DeviceInfo f31411k;

    /* renamed from: p */
    public C13067a f31416p;

    /* renamed from: q */
    public C12850c f31417q;

    /* renamed from: r */
    public C13486a f31418r;

    /* renamed from: s */
    public C10603b f31419s;

    /* renamed from: a */
    public long f31401a = -1;

    /* renamed from: j */
    public Config f31410j = null;

    /* renamed from: l */
    public int f31412l = 1;

    /* renamed from: m */
    public Boolean f31413m = Boolean.FALSE;

    /* renamed from: n */
    public long f31414n = 0;

    /* renamed from: o */
    public long f31415o = 0;

    /* renamed from: t */
    public GnssMeasurementsEvent.Callback f31420t = new C6813c();

    /* renamed from: com.huawei.location.sdm.Sdm$a */
    public class HandlerC6811a extends Handler {

        /* renamed from: b */
        public static final /* synthetic */ int f31421b = 0;

        public HandlerC6811a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            String str;
            String str2;
            int i10 = message.what;
            if (i10 == 1) {
                C1016d.m6186f("Sdm", "handleMessage: LOCATION_CHANGED");
                Object obj = message.obj;
                if (obj instanceof Location) {
                    Sdm.m38515t(Sdm.this, (Location) obj);
                    return;
                }
                str2 = "handleMessage not location obj";
            } else {
                if (i10 != 3) {
                    if (i10 == 2) {
                        C1016d.m6186f("Sdm", "stop begin");
                        Object obj2 = message.obj;
                        if (!(obj2 instanceof InterfaceC6822i)) {
                            C1016d.m6183c("Sdm", "handleMessage not SdmListener obj");
                            return;
                        }
                        if (((InterfaceC6822i) obj2).equals(Sdm.this.f31404d)) {
                            Sdm.this.f31404d = null;
                            Sdm.this.f31416p.m78829a();
                            if (Sdm.this.f31409i != null) {
                                Sdm.this.f31409i.stopLocation();
                            }
                            C1016d.m6186f("Sdm", "The algorithm is disabled");
                            if (Sdm.this.f31408h != null) {
                                C6812b c6812b = Sdm.this.f31408h;
                                Sdm.this.f31402b.removeUpdates(c6812b);
                            }
                            Sdm.m38505f(Sdm.this);
                            Sdm.this.f31412l = 1;
                            Sdm.m38503d(Sdm.this);
                            Sdm.this.f31414n = 0L;
                            Sdm.this.f31415o = 0L;
                        }
                        C1016d.m6186f("Sdm", "stop end");
                        return;
                    }
                    if (i10 != 4) {
                        C1016d.m6183c("Sdm", "unknown msg:" + message.what);
                        return;
                    }
                    C1016d.m6186f("Sdm", "add listener");
                    Object obj3 = message.obj;
                    if (!(obj3 instanceof InterfaceC6822i)) {
                        C1016d.m6183c("Sdm", "handleMessage not SdmListener obj");
                        return;
                    }
                    InterfaceC6822i interfaceC6822i = (InterfaceC6822i) obj3;
                    if (Sdm.this.f31404d == null) {
                        Sdm sdm = Sdm.this;
                        sdm.f31408h = new C6812b(sdm, 0);
                        C6812b c6812b2 = Sdm.this.f31408h;
                        Looper looper = getLooper();
                        c6812b2.getClass();
                        try {
                            Sdm.this.f31402b.requestLocationUpdates("gps", 1000L, 0.0f, c6812b2, looper);
                            C1016d.m6186f("Sdm", "location listener register success");
                        } catch (IllegalArgumentException unused) {
                            str = "LocationManager requestLocationUpdates throw IllegalArgumentException";
                            C1016d.m6183c("Sdm", str);
                            Sdm.m38507h(Sdm.this);
                            Sdm.this.f31404d = interfaceC6822i;
                            C1016d.m6186f("Sdm", "add listener success");
                            return;
                        } catch (SecurityException unused2) {
                            str = "LocationManager requestLocationUpdates throw SecurityException";
                            C1016d.m6183c("Sdm", str);
                            Sdm.m38507h(Sdm.this);
                            Sdm.this.f31404d = interfaceC6822i;
                            C1016d.m6186f("Sdm", "add listener success");
                            return;
                        } catch (Exception unused3) {
                            str = "LocationManager requestLocationUpdates throw other exception";
                            C1016d.m6183c("Sdm", str);
                            Sdm.m38507h(Sdm.this);
                            Sdm.this.f31404d = interfaceC6822i;
                            C1016d.m6186f("Sdm", "add listener success");
                            return;
                        }
                        Sdm.m38507h(Sdm.this);
                        Sdm.this.f31404d = interfaceC6822i;
                        C1016d.m6186f("Sdm", "add listener success");
                        return;
                    }
                    return;
                }
                C1016d.m6186f("Sdm", "handleMessage: LOCATION_PROCESS");
                Object obj4 = message.obj;
                if (obj4 instanceof GnssMeasurementsEvent) {
                    Sdm.m38514s(Sdm.this, (GnssMeasurementsEvent) obj4);
                    return;
                }
                str2 = "handleMessage not GnssMeasurementsEvent obj";
            }
            C1016d.m6183c("Sdm", str2);
        }
    }

    /* renamed from: com.huawei.location.sdm.Sdm$b */
    public class C6812b implements LocationListener {
        public C6812b() {
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            if (location == null) {
                C1016d.m6183c("Sdm", "location null");
                return;
            }
            if (Sdm.this.f31403c == null || Sdm.this.f31407g == null || !Sdm.this.f31407g.isAlive()) {
                Sdm.this.f31407g = new HandlerThread("Sdm");
                Sdm.this.f31407g.start();
                Sdm sdm = Sdm.this;
                Sdm sdm2 = Sdm.this;
                sdm.f31403c = sdm2.new HandlerC6811a(sdm2.f31407g.getLooper());
            }
            Sdm.this.f31403c.obtainMessage(1, location).sendToTarget();
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            C1016d.m6181a("Sdm", "onProviderDisabled");
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
            C1016d.m6181a("Sdm", "onProviderEnabled");
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i10, Bundle bundle) {
            C1016d.m6181a("Sdm", StatusChangeMethods.STATUS_CHANGE);
        }

        public /* synthetic */ C6812b(Sdm sdm, int i10) {
            this();
        }
    }

    /* renamed from: com.huawei.location.sdm.Sdm$c */
    public class C6813c extends GnssMeasurementsEvent.Callback {
        public C6813c() {
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public final void onGnssMeasurementsReceived(GnssMeasurementsEvent gnssMeasurementsEvent) {
            if (System.currentTimeMillis() - Sdm.this.f31401a < 900) {
                C1016d.m6186f("Sdm", "do nothing because MeasurementsEvent is too fast");
                return;
            }
            Sdm.this.f31401a = System.currentTimeMillis();
            if (Sdm.this.f31403c == null || Sdm.this.f31407g == null || !Sdm.this.f31407g.isAlive()) {
                Sdm.this.f31407g = new HandlerThread("Sdm");
                Sdm.this.f31407g.start();
                Sdm sdm = Sdm.this;
                Sdm sdm2 = Sdm.this;
                sdm.f31403c = sdm2.new HandlerC6811a(sdm2.f31407g.getLooper());
            }
            Sdm.this.f31403c.obtainMessage(3, gnssMeasurementsEvent).sendToTarget();
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public final void onStatusChanged(int i10) {
            C1016d.m6186f("Sdm", "GnssMeasurementsEvent onStatusChanged :" + i10);
            super.onStatusChanged(i10);
        }
    }

    public Sdm() {
        m38524q();
    }

    /* renamed from: d */
    public static /* synthetic */ void m38503d(Sdm sdm) {
        sdm.f31413m = Boolean.FALSE;
    }

    /* renamed from: f */
    public static void m38505f(Sdm sdm) {
        LocationManager locationManager = sdm.f31402b;
        if (locationManager != null) {
            locationManager.unregisterGnssMeasurementsCallback(sdm.f31420t);
        }
    }

    /* renamed from: h */
    public static void m38507h(Sdm sdm) {
        sdm.getClass();
        try {
            C1016d.m6186f("Sdm", "RegisterMeasurements:" + sdm.f31402b.registerGnssMeasurementsCallback(sdm.f31420t));
        } catch (Exception unused) {
            C1016d.m6183c("Sdm", "registerGnssMeasurements error.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00de  */
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m38514s(com.huawei.location.sdm.Sdm r11, android.location.GnssMeasurementsEvent r12) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.sdm.Sdm.m38514s(com.huawei.location.sdm.Sdm, android.location.GnssMeasurementsEvent):void");
    }

    /* renamed from: t */
    public static void m38515t(Sdm sdm, Location location) {
        if (location == null) {
            sdm.getClass();
            C1016d.m6186f("Sdm", "location is null");
            return;
        }
        if (sdm.f31405e == null || SystemClock.elapsedRealtime() - sdm.f31415o > RippleView.SINGLE_RIPPLE_TIME || !sdm.f31413m.booleanValue()) {
            InterfaceC6822i interfaceC6822i = sdm.f31404d;
            if (interfaceC6822i != null) {
                interfaceC6822i.onLocationChanged(location);
            }
        } else {
            InterfaceC6822i interfaceC6822i2 = sdm.f31404d;
            if (interfaceC6822i2 != null) {
                interfaceC6822i2.onLocationChanged(sdm.f31405e);
            }
        }
        sdm.f31405e = location;
        sdm.f31415o = SystemClock.elapsedRealtime();
        sdm.f31413m = Boolean.FALSE;
    }

    /* renamed from: l */
    public void m38521l(InterfaceC6822i interfaceC6822i) {
        HandlerThread handlerThread;
        if (interfaceC6822i == null) {
            C1016d.m6190j("Sdm", "no has listener");
            return;
        }
        if (this.f31403c != null && (handlerThread = this.f31407g) != null && handlerThread.isAlive()) {
            HandlerC6811a handlerC6811a = this.f31403c;
            int i10 = HandlerC6811a.f31421b;
            handlerC6811a.obtainMessage(2, interfaceC6822i).sendToTarget();
        }
        this.f31406f.quitSafely();
        this.f31406f = null;
    }

    /* renamed from: m */
    public void m38522m(InterfaceC6822i interfaceC6822i) {
        HandlerThread handlerThread;
        if (interfaceC6822i == null) {
            C1016d.m6190j("Sdm", "no has listener");
            return;
        }
        if (this.f31404d == null) {
            if (this.f31418r == null) {
                this.f31418r = new C13486a(this.f31410j.m38494b(), this.f31410j.m38495c());
            }
            Object systemService = C11991a.m72145a().getSystemService(JsbMapKeyNames.H5_LOC);
            if (systemService instanceof LocationManager) {
                this.f31402b = (LocationManager) systemService;
            }
            if (this.f31419s == null) {
                this.f31419s = new C10603b();
            }
            if (this.f31416p == null) {
                this.f31416p = new C13067a();
            }
            if (this.f31417q == null) {
                this.f31417q = new C12850c();
            }
            if (this.f31411k == null) {
                DeviceInfo.Builder builderADeviceInfo = DeviceInfo.Builder.aDeviceInfo();
                builderADeviceInfo.withChipName(C12623c.m76139a(C9554s.m59651f()));
                builderADeviceInfo.withManufacturer(Build.MANUFACTURER);
                builderADeviceInfo.withSdkLevel(Build.VERSION.SDK_INT);
                this.f31411k = builderADeviceInfo.build();
            }
            this.f31417q.m77159c();
            HandlerThread handlerThread2 = this.f31406f;
            if (handlerThread2 == null || !handlerThread2.isAlive()) {
                HandlerThread handlerThread3 = new HandlerThread("Location-SDM-SUPPORT");
                this.f31406f = handlerThread3;
                handlerThread3.start();
            }
            this.f31416p.m78831e(this.f31406f.getLooper(), this.f31419s, this.f31410j);
            if (this.f31403c == null || (handlerThread = this.f31407g) == null || !handlerThread.isAlive()) {
                HandlerThread handlerThread4 = new HandlerThread("Sdm");
                this.f31407g = handlerThread4;
                handlerThread4.start();
                this.f31403c = new HandlerC6811a(this.f31407g.getLooper());
            }
            this.f31403c.obtainMessage(4, interfaceC6822i).sendToTarget();
        }
    }

    /* renamed from: p */
    public final Location m38523p(GnssMeasurementsEvent gnssMeasurementsEvent, Location location) {
        GnssRawObservation[] gnssRawObservationArr;
        Pvt.Builder.aPvt();
        Pvt pvtBuild = Pvt.Builder.aPvt().withAccuracy(location.getAccuracy()).withAltitude(location.getAltitude()).withLatitude(location.getLatitude()).withBearing(location.getBearing()).withLongitude(location.getLongitude()).withSpeed(location.getSpeed()).withTime(location.getTime()).build();
        int i10 = 0;
        if (C9537b.m59560a(gnssMeasurementsEvent.getMeasurements()) || gnssMeasurementsEvent.getClock() == null) {
            gnssRawObservationArr = new GnssRawObservation[0];
        } else {
            GnssClock gnssClockBuild = GnssClock.Builder.aGnssClock().withBiasNanos(gnssMeasurementsEvent.getClock().hasBiasNanos() ? gnssMeasurementsEvent.getClock().getBiasNanos() : 0.0d).withBiasUncertaintyNanos(gnssMeasurementsEvent.getClock().hasBiasUncertaintyNanos() ? gnssMeasurementsEvent.getClock().getBiasUncertaintyNanos() : 0.0d).withDriftNanosPerSecond(gnssMeasurementsEvent.getClock().hasDriftNanosPerSecond() ? gnssMeasurementsEvent.getClock().getDriftNanosPerSecond() : 0.0d).withDriftUncertaintyNanosPerSecond(gnssMeasurementsEvent.getClock().hasDriftUncertaintyNanosPerSecond() ? gnssMeasurementsEvent.getClock().getDriftUncertaintyNanosPerSecond() : 0.0d).withFullBiasNanos(gnssMeasurementsEvent.getClock().getFullBiasNanos()).withHardwareClockDiscontinuityCount(gnssMeasurementsEvent.getClock().getHardwareClockDiscontinuityCount()).withLeapSecond(gnssMeasurementsEvent.getClock().hasLeapSecond() ? gnssMeasurementsEvent.getClock().getLeapSecond() : 0).withTimeNanos(gnssMeasurementsEvent.getClock().getTimeNanos()).withTimeUncertaintyNanos(gnssMeasurementsEvent.getClock().hasTimeUncertaintyNanos() ? gnssMeasurementsEvent.getClock().getTimeUncertaintyNanos() : 0.0d).withElapsedRealtimeMillis(gnssMeasurementsEvent.getClock().getElapsedRealtimeNanos()).build();
            int size = gnssMeasurementsEvent.getMeasurements().size();
            GnssRawObservation[] gnssRawObservationArr2 = new GnssRawObservation[size];
            for (GnssMeasurement gnssMeasurement : gnssMeasurementsEvent.getMeasurements()) {
                SatelliteMeasurement.Builder builderWithSvid = SatelliteMeasurement.Builder.aSatelliteMeasurement().withAccumulatedDeltaRangeMeters(gnssMeasurement.getAccumulatedDeltaRangeMeters()).withAccumulatedDeltaRangeState(gnssMeasurement.getAccumulatedDeltaRangeState()).withAccumulatedDeltaRangeUncertaintyMeters(gnssMeasurement.getAccumulatedDeltaRangeUncertaintyMeters()).withCarrierCycles(gnssMeasurement.hasCarrierCycles() ? gnssMeasurement.getCarrierCycles() : 0L).withCarrierFrequencyHz(gnssMeasurement.hasCarrierFrequencyHz() ? gnssMeasurement.getCarrierFrequencyHz() : 0.0f).withCarrierPhase(gnssMeasurement.hasCarrierPhase() ? gnssMeasurement.getCarrierPhase() : 0.0d).withCarrierPhaseUncertainty(gnssMeasurement.hasCarrierPhaseUncertainty() ? gnssMeasurement.getCarrierPhaseUncertainty() : 0.0d).withCn0DbHz(gnssMeasurement.getCn0DbHz()).withConstellationType(gnssMeasurement.getConstellationType()).withSnrInDb(gnssMeasurement.hasSnrInDb() ? gnssMeasurement.getSnrInDb() : 0.0d).withMultipathIndicator(gnssMeasurement.getMultipathIndicator()).withTimeOffsetNanos(gnssMeasurement.getTimeOffsetNanos()).withPseudorangeRateMetersPerSecond(gnssMeasurement.getPseudorangeRateMetersPerSecond()).withPseudorangeRateUncertaintyMetersPerSecond(gnssMeasurement.getPseudorangeRateUncertaintyMetersPerSecond()).withReceivedSvTimeNanos(gnssMeasurement.getReceivedSvTimeNanos()).withReceivedSvTimeUncertaintyNanos(gnssMeasurement.getReceivedSvTimeUncertaintyNanos()).withState(gnssMeasurement.getState()).withSvid(gnssMeasurement.getSvid());
                int i11 = Build.VERSION.SDK_INT;
                builderWithSvid.withAutomaticGainControlLevelInDb(gnssMeasurement.hasAutomaticGainControlLevelDb() ? gnssMeasurement.getAutomaticGainControlLevelDb() : 0.0d);
                if (i11 >= 30) {
                    builderWithSvid.withFullInterSignalBiasNanos(gnssMeasurement.hasFullInterSignalBiasNanos() ? gnssMeasurement.getFullInterSignalBiasNanos() : 0.0d);
                    builderWithSvid.withFullInterSignalBiasUncertaintyNanos(gnssMeasurement.hasFullInterSignalBiasUncertaintyNanos() ? gnssMeasurement.getFullInterSignalBiasUncertaintyNanos() : 0.0d);
                    builderWithSvid.withSatelliteInterSignalBiasNanos(gnssMeasurement.hasSatelliteInterSignalBiasNanos() ? gnssMeasurement.getSatelliteInterSignalBiasNanos() : 0.0d);
                    builderWithSvid.withSatelliteInterSignalBiasUncertaintyNanos(gnssMeasurement.hasSatelliteInterSignalBiasUncertaintyNanos() ? gnssMeasurement.getSatelliteInterSignalBiasUncertaintyNanos() : 0.0d);
                } else {
                    builderWithSvid.withFullInterSignalBiasNanos(0.0d);
                    builderWithSvid.withFullInterSignalBiasUncertaintyNanos(0.0d);
                    builderWithSvid.withSatelliteInterSignalBiasNanos(0.0d);
                    builderWithSvid.withSatelliteInterSignalBiasUncertaintyNanos(0.0d);
                }
                SatelliteMeasurement satelliteMeasurementBuild = builderWithSvid.build();
                if (i10 >= 0 && i10 < size) {
                    gnssRawObservationArr2[i10] = GnssRawObservation.Builder.aGnssRawObservation().withSatelliteMeasurement(satelliteMeasurementBuild).withGnssClock(gnssClockBuild).build();
                    i10++;
                }
            }
            gnssRawObservationArr = gnssRawObservationArr2;
        }
        if (!CollectionsUtil.isEmpty(gnssRawObservationArr) && gnssRawObservationArr.length >= 10) {
            Pvt pvtProcess = this.f31409i.process(pvtBuild, gnssRawObservationArr);
            if (pvtProcess.getErrCode() != 0) {
                this.f31413m = Boolean.FALSE;
                C1016d.m6186f("Sdm", "pvt handle error,errorCode is :" + pvtProcess.getErrCode());
                return location;
            }
            this.f31413m = Boolean.TRUE;
            location.setLongitude(pvtProcess.getLongitude());
            location.setLatitude(pvtProcess.getLatitude());
            location.setAccuracy(pvtProcess.getAccuracy());
            location.setBearing(pvtProcess.getBearing());
            location.setAltitude(pvtProcess.getAltitude());
            location.setSpeed(pvtProcess.getSpeed());
            Bundle extras = location.getExtras();
            C10343b c10343b = new C10343b(extras);
            if (c10343b.m63679a("LocationSource")) {
                c10343b.m63698t("LocationSource", extras.getInt("LocationSource") | 1);
            } else {
                c10343b.m63698t("LocationSource", 1);
            }
            location.setExtras(c10343b.m63683e());
            C1016d.m6186f("Sdm", "processLocation success here, the location has been deflected");
        }
        return location;
    }

    /* renamed from: q */
    public final void m38524q() {
        Config config = new Config();
        this.f31410j = config;
        if (config.m38493a()) {
            return;
        }
        this.f31410j = null;
    }

    public boolean support(long j10, float f10) {
        if (this.f31410j == null) {
            C1016d.m6190j("Sdm", "no config");
            return false;
        }
        if (j10 > 10000 || f10 > 10.0f) {
            C1016d.m6186f("Sdm", "not support sdm, minTime:" + j10 + ",minDistance:" + f10);
            return false;
        }
        String strM76140b = C12623c.m76140b(C9554s.m59651f());
        boolean z10 = C9550o.m59630c() != 3 ? !"".equals(strM76140b) && this.f31410j.m38499g(strM76140b, C12622b.m76138a(Build.VERSION.SDK_INT)) : false;
        C1016d.m6186f("Sdm", "SDM support:" + z10 + ",The phone ChipType:" + strM76140b + ",The phone OsVersion:" + C12622b.m76138a(Build.VERSION.SDK_INT));
        return z10;
    }
}

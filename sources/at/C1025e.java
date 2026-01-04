package at;

import android.annotation.SuppressLint;
import android.location.GnssMeasurement;
import android.location.GnssMeasurementsEvent;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import as.C1016d;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.riemann.gnsslocation.core.bean.obs.GnssClock;
import com.huawei.riemann.gnsslocation.core.bean.obs.GnssRawObservation;
import com.huawei.riemann.gnsslocation.core.bean.obs.SatelliteMeasurement;
import es.C9537b;
import es.C9548m;
import et.InterfaceC9559d;
import java.util.concurrent.TimeUnit;
import p531or.C11991a;
import p784xq.C13850f;

/* renamed from: at.e */
/* loaded from: classes8.dex */
public final class C1025e {

    /* renamed from: a */
    public HandlerThread f5081a;

    /* renamed from: b */
    public Handler f5082b;

    /* renamed from: c */
    public LocationManager f5083c;

    /* renamed from: d */
    public InterfaceC9559d f5084d;

    /* renamed from: e */
    public long f5085e;

    /* renamed from: f */
    public final GnssMeasurementsEvent.Callback f5086f = new a();

    /* renamed from: at.e$a */
    public class a extends GnssMeasurementsEvent.Callback {
        public a() {
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public final void onGnssMeasurementsReceived(GnssMeasurementsEvent gnssMeasurementsEvent) {
            C1025e.m6213c(C1025e.this, gnssMeasurementsEvent);
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public final void onStatusChanged(int i10) {
            C1016d.m6186f("GnssMeasurementsProvider", "GnssMeasurementsEvent onStatusChanged :" + i10);
            super.onStatusChanged(i10);
        }
    }

    /* renamed from: c */
    public static void m6213c(C1025e c1025e, GnssMeasurementsEvent gnssMeasurementsEvent) {
        GnssRawObservation[] gnssRawObservationArr;
        c1025e.getClass();
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        if (jElapsedRealtimeNanos - c1025e.f5085e < 600000) {
            C1016d.m6181a("GnssMeasurementsProvider", "The interval does not meet requirements,dropping this gnssRaw");
            return;
        }
        c1025e.f5085e = jElapsedRealtimeNanos;
        long millis = TimeUnit.NANOSECONDS.toMillis(jElapsedRealtimeNanos);
        int i10 = 0;
        if (C9537b.m59560a(gnssMeasurementsEvent.getMeasurements()) || gnssMeasurementsEvent.getClock() == null) {
            gnssRawObservationArr = new GnssRawObservation[0];
        } else {
            GnssClock gnssClockBuild = GnssClock.Builder.aGnssClock().withBiasNanos(gnssMeasurementsEvent.getClock().hasBiasNanos() ? gnssMeasurementsEvent.getClock().getBiasNanos() : 0.0d).withBiasUncertaintyNanos(gnssMeasurementsEvent.getClock().hasBiasUncertaintyNanos() ? gnssMeasurementsEvent.getClock().getBiasUncertaintyNanos() : 0.0d).withDriftNanosPerSecond(gnssMeasurementsEvent.getClock().hasDriftNanosPerSecond() ? gnssMeasurementsEvent.getClock().getDriftNanosPerSecond() : 0.0d).withDriftUncertaintyNanosPerSecond(gnssMeasurementsEvent.getClock().hasDriftUncertaintyNanosPerSecond() ? gnssMeasurementsEvent.getClock().getDriftUncertaintyNanosPerSecond() : 0.0d).withFullBiasNanos(gnssMeasurementsEvent.getClock().getFullBiasNanos()).withHardwareClockDiscontinuityCount(gnssMeasurementsEvent.getClock().getHardwareClockDiscontinuityCount()).withLeapSecond(gnssMeasurementsEvent.getClock().hasLeapSecond() ? gnssMeasurementsEvent.getClock().getLeapSecond() : 0).withTimeNanos(gnssMeasurementsEvent.getClock().getTimeNanos()).withTimeUncertaintyNanos(gnssMeasurementsEvent.getClock().hasTimeUncertaintyNanos() ? gnssMeasurementsEvent.getClock().getTimeUncertaintyNanos() : 0.0d).withElapsedRealtimeMillis(gnssMeasurementsEvent.getClock().getElapsedRealtimeNanos()).build();
            int size = gnssMeasurementsEvent.getMeasurements().size();
            GnssRawObservation[] gnssRawObservationArr2 = new GnssRawObservation[size];
            for (GnssMeasurement gnssMeasurement : gnssMeasurementsEvent.getMeasurements()) {
                long j10 = millis;
                SatelliteMeasurement.Builder builderWithSvid = SatelliteMeasurement.Builder.aSatelliteMeasurement().withBootTime(millis).withAccumulatedDeltaRangeMeters(gnssMeasurement.getAccumulatedDeltaRangeMeters()).withAccumulatedDeltaRangeState(gnssMeasurement.getAccumulatedDeltaRangeState()).withAccumulatedDeltaRangeUncertaintyMeters(gnssMeasurement.getAccumulatedDeltaRangeUncertaintyMeters()).withCarrierCycles(gnssMeasurement.hasCarrierCycles() ? gnssMeasurement.getCarrierCycles() : 0L).withCarrierFrequencyHz(gnssMeasurement.hasCarrierFrequencyHz() ? gnssMeasurement.getCarrierFrequencyHz() : 0.0f).withCarrierPhase(gnssMeasurement.hasCarrierPhase() ? gnssMeasurement.getCarrierPhase() : 0.0d).withCarrierPhaseUncertainty(gnssMeasurement.hasCarrierPhaseUncertainty() ? gnssMeasurement.getCarrierPhaseUncertainty() : 0.0d).withCn0DbHz(gnssMeasurement.getCn0DbHz()).withConstellationType(gnssMeasurement.getConstellationType()).withSnrInDb(gnssMeasurement.hasSnrInDb() ? gnssMeasurement.getSnrInDb() : 0.0d).withMultipathIndicator(gnssMeasurement.getMultipathIndicator()).withTimeOffsetNanos(gnssMeasurement.getTimeOffsetNanos()).withPseudorangeRateMetersPerSecond(gnssMeasurement.getPseudorangeRateMetersPerSecond()).withPseudorangeRateUncertaintyMetersPerSecond(gnssMeasurement.getPseudorangeRateUncertaintyMetersPerSecond()).withReceivedSvTimeNanos(gnssMeasurement.getReceivedSvTimeNanos()).withReceivedSvTimeUncertaintyNanos(gnssMeasurement.getReceivedSvTimeUncertaintyNanos()).withState(gnssMeasurement.getState()).withSvid(gnssMeasurement.getSvid());
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
                millis = j10;
            }
            gnssRawObservationArr = gnssRawObservationArr2;
        }
        if (gnssRawObservationArr.length < 10) {
            C13850f.m83120a(new StringBuilder("gnssRawObservations not enough, drop here. length is : "), gnssRawObservationArr.length, "GnssMeasurementsProvider");
            return;
        }
        InterfaceC9559d interfaceC9559d = c1025e.f5084d;
        if (interfaceC9559d != null) {
            ((C1023c) interfaceC9559d).m6203c(gnssRawObservationArr, jElapsedRealtimeNanos);
        } else {
            C1016d.m6183c("GnssMeasurementsProvider", "gnss listener is null!");
        }
    }

    /* renamed from: a */
    public final void m6214a() {
        LocationManager locationManager = this.f5083c;
        if (locationManager != null) {
            locationManager.unregisterGnssMeasurementsCallback(this.f5086f);
        }
        this.f5084d = null;
        HandlerThread handlerThread = this.f5081a;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        this.f5082b = null;
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: b */
    public final void m6215b() {
        boolean zRegisterGnssMeasurementsCallback;
        HandlerThread handlerThread = new HandlerThread("Loc-Vdr-gnssMeasure");
        this.f5081a = handlerThread;
        handlerThread.start();
        this.f5082b = new Handler(this.f5081a.getLooper());
        try {
            Object systemService = C11991a.m72145a().getSystemService(JsbMapKeyNames.H5_LOC);
            if (systemService instanceof LocationManager) {
                this.f5083c = (LocationManager) systemService;
                if (!C9548m.m59619b(C11991a.m72145a(), "android.permission.ACCESS_FINE_LOCATION")) {
                    C1016d.m6183c("GnssMeasurementsProvider", "init fail because of checkSelfPermission fail");
                    return;
                }
                zRegisterGnssMeasurementsCallback = this.f5083c.registerGnssMeasurementsCallback(this.f5086f, this.f5082b);
            } else {
                zRegisterGnssMeasurementsCallback = false;
            }
            C1016d.m6186f("GnssMeasurementsProvider", "RegisterMeasurements:" + zRegisterGnssMeasurementsCallback);
        } catch (Exception unused) {
            C1016d.m6183c("GnssMeasurementsProvider", "registerGnssMeasurements error.");
        }
    }

    /* renamed from: d */
    public final void m6216d(InterfaceC9559d interfaceC9559d) {
        this.f5084d = interfaceC9559d;
    }
}

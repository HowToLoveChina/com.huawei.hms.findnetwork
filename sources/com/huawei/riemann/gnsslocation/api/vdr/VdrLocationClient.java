package com.huawei.riemann.gnsslocation.api.vdr;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.huawei.location.C6742c;
import com.huawei.location.C6760g;
import com.huawei.riemann.gnsslocation.core.VdrLocationAlgoWrapper;
import com.huawei.riemann.gnsslocation.core.bean.DeviceInfo;
import com.huawei.riemann.gnsslocation.core.bean.eph.Ephemeris;
import com.huawei.riemann.gnsslocation.core.bean.obs.GnssClock;
import com.huawei.riemann.gnsslocation.core.bean.obs.GnssRawObservation;
import com.huawei.riemann.gnsslocation.core.bean.obs.Pvt;
import com.huawei.riemann.gnsslocation.core.bean.obs.SatelliteMeasurement;
import com.huawei.riemann.gnsslocation.core.bean.sensor.MotionSensors;

/* loaded from: classes5.dex */
public class VdrLocationClient {
    public static final String TAG = "com.huawei.riemann.gnsslocation.api.vdr.VdrLocationClient";
    public C6742c mVdrLocManager;

    public VdrLocationClient(Context context, String str) {
        try {
            if (context == null) {
                throw new IllegalArgumentException("Context can not be null");
            }
            this.mVdrLocManager = new C6742c(context.getApplicationContext(), str);
            Log.i(TAG, "VDR version time: 20211124");
        } catch (IllegalArgumentException e10) {
            Log.e(TAG, "vdr client error: " + e10.getMessage());
        }
    }

    public Pvt process(Pvt pvt, GnssRawObservation[] gnssRawObservationArr, MotionSensors motionSensors, Pvt pvt2) {
        C6742c c6742c = this.mVdrLocManager;
        if (c6742c == null) {
            Log.e(TAG, "proc manager null");
            return pvt;
        }
        Log.d("VdrLocationManager", "vdr process start");
        if (pvt == null) {
            Log.w("VdrLocationManager", "pvt null in proc");
        }
        if (gnssRawObservationArr == null) {
            Log.w("VdrLocationManager", "obs null in proc");
        }
        if (motionSensors == null) {
            Log.e("VdrLocationManager", "sensors null in proc");
            return null;
        }
        if (C6742c.f31213e == null || !VdrLocationAlgoWrapper.f40462c) {
            Log.e("VdrLocationManager", "wp is null in proc");
            return pvt;
        }
        GnssClock[] gnssClockArr = new GnssClock[0];
        SatelliteMeasurement[] satelliteMeasurementArr = new SatelliteMeasurement[0];
        if (gnssRawObservationArr != null) {
            gnssClockArr = new GnssClock[gnssRawObservationArr.length];
            satelliteMeasurementArr = new SatelliteMeasurement[gnssRawObservationArr.length];
            for (int i10 = 0; i10 < gnssRawObservationArr.length; i10++) {
                GnssRawObservation gnssRawObservation = gnssRawObservationArr[i10];
                if (gnssRawObservation == null) {
                    Log.w("VdrLocationManager", "rawMeasurements[" + i10 + "] is null");
                } else {
                    gnssClockArr[i10] = gnssRawObservation.getGnssClock();
                    satelliteMeasurementArr[i10] = gnssRawObservationArr[i10].getSatelliteMeasurement();
                }
            }
        }
        StringBuilder sb2 = new StringBuilder("vdr process algo start: ");
        int i11 = c6742c.f31216c + 1;
        c6742c.f31216c = i11;
        sb2.append(i11);
        Log.d("VdrLocationManager", sb2.toString());
        Pvt pvtVdrProcess = C6742c.f31213e.vdrProcess(pvt, gnssClockArr, satelliteMeasurementArr, motionSensors, pvt2);
        StringBuilder sb3 = new StringBuilder("vdr process algo finished: ");
        int i12 = c6742c.f31217d + 1;
        c6742c.f31217d = i12;
        sb3.append(i12);
        Log.d("VdrLocationManager", sb3.toString());
        if (c6742c.f31214a == null) {
            Log.v("VdrLocationManager", "lpm is null in proc");
            return pvtVdrProcess;
        }
        Log.e("LogPersistenceManager", "log p helper null when proc");
        return pvtVdrProcess;
    }

    public int startLocation(DeviceInfo deviceInfo) {
        String str;
        C6742c c6742c = this.mVdrLocManager;
        if (c6742c == null) {
            Log.e(TAG, "start n");
            return -1;
        }
        if (c6742c.f31215b) {
            str = "already started";
        } else {
            c6742c.f31215b = true;
            C6760g c6760g = c6742c.f31214a;
            if (c6760g == null) {
                Log.v("VdrLocationManager", "lph is null");
            } else {
                c6760g.m38370a();
                Log.v("LogPersistenceManager", "log ph is null when start");
            }
            if (C6742c.f31213e != null && VdrLocationAlgoWrapper.f40462c) {
                C6742c.f31213e.vdrStart(deviceInfo, "");
                Log.d("VdrLocationManager", "start vdr location finished, transPath: ".concat(""));
                return 0;
            }
            str = "start: wp is null";
        }
        Log.e("VdrLocationManager", str);
        return 0;
    }

    public void stopLocation() {
        String str;
        C6742c c6742c = this.mVdrLocManager;
        if (c6742c == null) {
            Log.e(TAG, "stop n");
            return;
        }
        if (c6742c.f31215b) {
            c6742c.f31215b = false;
            if (C6742c.f31213e != null && VdrLocationAlgoWrapper.f40462c) {
                C6742c.f31213e.vdrStop();
                C6760g c6760g = c6742c.f31214a;
                if (c6760g == null) {
                    Log.v("VdrLocationManager", "lpm is null");
                    return;
                }
                if (c6760g.f31326c) {
                    c6760g.f31326c = false;
                    Handler handler = c6760g.f31325b;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                    }
                    C6760g.a aVar = c6760g.f31324a;
                    if (aVar != null) {
                        aVar.quitSafely();
                    }
                    c6760g.f31325b = null;
                    c6760g.f31324a = null;
                }
                Log.v("LogPersistenceManager", "log ph is null when stop");
                Log.d("VdrLocationManager", "stop vdr location finished");
                return;
            }
            str = "stop: wp is null";
        } else {
            str = "already stopped";
        }
        Log.e("VdrLocationManager", str);
    }

    public void updateEphemeris(Ephemeris ephemeris) {
        String str;
        if (this.mVdrLocManager == null) {
            Log.e(TAG, "no ephemeris data");
            return;
        }
        Log.d(TAG, "updateEphemeris start");
        C6742c c6742c = this.mVdrLocManager;
        c6742c.getClass();
        if (C6742c.f31213e == null || !VdrLocationAlgoWrapper.f40462c) {
            str = "update: wp is null";
        } else {
            C6742c.f31213e.vdrUpdateEphemeris(ephemeris);
            if (c6742c.f31214a != null) {
                Log.e("LogPersistenceManager", "log p helper null when eph");
                Log.d("VdrLocationManager", "update ephemeris finished");
                return;
            }
            str = "lpm is null";
        }
        Log.e("VdrLocationManager", str);
    }
}

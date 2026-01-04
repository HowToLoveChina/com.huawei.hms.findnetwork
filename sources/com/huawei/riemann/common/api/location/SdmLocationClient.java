package com.huawei.riemann.common.api.location;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.huawei.location.C6739b;
import com.huawei.riemann.location.SdmLocationAlgoWrapper;
import com.huawei.riemann.location.bean.DeviceInfo;
import com.huawei.riemann.location.bean.eph.Ephemeris;
import com.huawei.riemann.location.bean.obs.GnssClock;
import com.huawei.riemann.location.bean.obs.GnssRawObservation;
import com.huawei.riemann.location.bean.obs.Pvt;
import com.huawei.riemann.location.bean.obs.SatelliteMeasurement;

/* loaded from: classes5.dex */
public class SdmLocationClient {
    public static final String TAG = "SdmLocationClient";
    public Context mContext;
    public C6739b mSdmLocManager;

    public SdmLocationClient(Context context, Intent intent, String str) {
        try {
            if (context == null) {
                throw new IllegalArgumentException("Context can not be null");
            }
            Context applicationContext = context.getApplicationContext();
            this.mContext = applicationContext;
            this.mSdmLocManager = new C6739b(applicationContext, intent, str);
        } catch (IllegalArgumentException e10) {
            Log.e(TAG, e10.getMessage() != null ? e10.getMessage() : "IllegalArgumentException2");
        }
    }

    public Pvt process(Pvt pvt, GnssRawObservation[] gnssRawObservationArr) {
        String str;
        String str2;
        C6739b c6739b = this.mSdmLocManager;
        if (c6739b == null) {
            Log.e(TAG, "proc n");
            return pvt;
        }
        if (pvt == null) {
            str2 = "pvt null";
        } else {
            if (gnssRawObservationArr != null) {
                SdmLocationAlgoWrapper sdmLocationAlgoWrapper = c6739b.f31201g;
                if (sdmLocationAlgoWrapper == null || !sdmLocationAlgoWrapper.f40562a) {
                    str = "wp is null";
                } else {
                    GnssClock[] gnssClockArr = new GnssClock[gnssRawObservationArr.length];
                    SatelliteMeasurement[] satelliteMeasurementArr = new SatelliteMeasurement[gnssRawObservationArr.length];
                    for (int i10 = 0; i10 < gnssRawObservationArr.length; i10++) {
                        gnssClockArr[i10] = gnssRawObservationArr[i10].getGnssClock();
                        satelliteMeasurementArr[i10] = gnssRawObservationArr[i10].getSatelliteMeasurement();
                    }
                    pvt = c6739b.f31201g.sdmProcess(pvt, gnssClockArr, satelliteMeasurementArr);
                    Log.v("SdmLocationManager", "p lph null");
                    if (c6739b.f31198d != null) {
                        return pvt;
                    }
                    str = "p ops null";
                }
                Log.e("SdmLocationManager", str);
                return pvt;
            }
            str2 = "obs null";
        }
        Log.e("SdmLocationManager", str2);
        return null;
    }

    public int startLocation(DeviceInfo deviceInfo, CityTileCallback cityTileCallback) {
        String str;
        C6739b c6739b = this.mSdmLocManager;
        if (c6739b == null) {
            Log.e(TAG, "start n");
            return -1;
        }
        if (c6739b.f31204j) {
            str = "already started";
        } else {
            c6739b.m38292a(null);
            C6739b.c cVar = c6739b.f31198d;
            if (cVar != null) {
                c6739b.f31203i = cityTileCallback;
                c6739b.f31202h = new C6739b.d(cVar, cityTileCallback);
            } else {
                c6739b.f31202h = new C6739b.d(new Handler(Looper.getMainLooper()), cityTileCallback);
            }
            Log.v("SdmLocationManager", "lph is null");
            SdmLocationAlgoWrapper sdmLocationAlgoWrapper = c6739b.f31201g;
            if (sdmLocationAlgoWrapper != null && sdmLocationAlgoWrapper.f40562a) {
                sdmLocationAlgoWrapper.sdmStart(deviceInfo, c6739b.f31202h, "");
                c6739b.f31204j = true;
                return 0;
            }
            str = "wp is null";
        }
        Log.e("SdmLocationManager", str);
        c6739b.f31204j = true;
        return 0;
    }

    public void stopLocation() {
        C6739b c6739b = this.mSdmLocManager;
        if (c6739b == null) {
            Log.e(TAG, "stop n");
            return;
        }
        if (c6739b.f31204j) {
            SdmLocationAlgoWrapper sdmLocationAlgoWrapper = c6739b.f31201g;
            if (sdmLocationAlgoWrapper == null || !sdmLocationAlgoWrapper.f40562a) {
                Log.e("SdmLocationManager", "wp is null");
            } else {
                sdmLocationAlgoWrapper.sdmStop();
            }
            c6739b.f31203i = null;
            c6739b.f31202h = null;
            if (c6739b.f31200f) {
                C6739b.e eVar = c6739b.f31196b;
                if (eVar != null) {
                    eVar.removeCallbacksAndMessages(null);
                }
                C6739b.c cVar = c6739b.f31198d;
                if (cVar != null) {
                    cVar.removeCallbacksAndMessages(null);
                }
                C6739b.b bVar = c6739b.f31197c;
                if (bVar != null) {
                    bVar.quitSafely();
                }
                c6739b.f31196b = null;
                c6739b.f31198d = null;
                c6739b.f31197c = null;
            }
            c6739b.f31200f = false;
            Log.v("SdmLocationManager", "lph is null");
        } else {
            Log.e("SdmLocationManager", "already stopped");
        }
        c6739b.f31204j = false;
    }

    public void updateEphemeris(Ephemeris ephemeris) {
        C6739b c6739b = this.mSdmLocManager;
        if (c6739b == null) {
            Log.e(TAG, "eph n");
            return;
        }
        SdmLocationAlgoWrapper sdmLocationAlgoWrapper = c6739b.f31201g;
        if (sdmLocationAlgoWrapper == null || !sdmLocationAlgoWrapper.f40562a) {
            Log.e("SdmLocationManager", "wp is null");
            return;
        }
        Log.v("SdmLocationManager", "e lph null");
        if (c6739b.f31198d == null) {
            Log.e("SdmLocationManager", "e ops null");
        }
        c6739b.f31201g.sdmUpdateEphemeris(ephemeris);
    }

    public SdmLocationClient(Context context, Looper looper, String str) {
        try {
            if (context == null) {
                throw new IllegalArgumentException("Context can not be null");
            }
            Context applicationContext = context.getApplicationContext();
            this.mContext = applicationContext;
            this.mSdmLocManager = new C6739b(applicationContext, looper, str);
        } catch (IllegalArgumentException e10) {
            Log.e(TAG, e10.getMessage() != null ? e10.getMessage() : "IllegalArgumentException3");
        }
    }

    public SdmLocationClient(Context context, String str) {
        try {
            if (context == null) {
                throw new IllegalArgumentException("Context can not be null");
            }
            Context applicationContext = context.getApplicationContext();
            this.mContext = applicationContext;
            this.mSdmLocManager = new C6739b(applicationContext, str);
        } catch (IllegalArgumentException e10) {
            Log.e(TAG, e10.getMessage() != null ? e10.getMessage() : "IllegalArgumentException1");
        }
    }
}

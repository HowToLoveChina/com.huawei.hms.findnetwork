package com.huawei.riemann.location;

import android.content.Context;
import com.huawei.location.C6759f;
import com.huawei.riemann.common.api.location.CityTileCallback;
import com.huawei.riemann.location.bean.DeviceInfo;
import com.huawei.riemann.location.bean.eph.Ephemeris;
import com.huawei.riemann.location.bean.obs.GnssClock;
import com.huawei.riemann.location.bean.obs.Pvt;
import com.huawei.riemann.location.bean.obs.SatelliteMeasurement;

/* loaded from: classes5.dex */
public class SdmLocationAlgoWrapper {

    /* renamed from: b */
    public static volatile SdmLocationAlgoWrapper f40560b;

    /* renamed from: c */
    public static final Object f40561c = new Object();

    /* renamed from: a */
    public boolean f40562a;

    public SdmLocationAlgoWrapper(Context context, String str) {
        this.f40562a = false;
        this.f40562a = C6759f.m38367a(context, str);
    }

    /* renamed from: a */
    public static SdmLocationAlgoWrapper m53566a(Context context, String str) {
        if (f40560b == null) {
            synchronized (f40561c) {
                try {
                    if (f40560b == null) {
                        f40560b = new SdmLocationAlgoWrapper(context, str);
                    }
                } finally {
                }
            }
        }
        return f40560b;
    }

    public native Pvt sdmProcess(Pvt pvt, GnssClock[] gnssClockArr, SatelliteMeasurement[] satelliteMeasurementArr);

    public native int sdmStart(DeviceInfo deviceInfo, CityTileCallback cityTileCallback, String str);

    public native int sdmStop();

    public native void sdmUpdateEphemeris(Ephemeris ephemeris);

    public native void sdmUpdateTileById(long j10, byte[] bArr);
}

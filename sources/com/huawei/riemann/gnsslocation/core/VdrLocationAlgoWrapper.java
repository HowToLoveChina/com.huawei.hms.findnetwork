package com.huawei.riemann.gnsslocation.core;

import android.content.Context;
import com.huawei.location.C6770j;
import com.huawei.riemann.gnsslocation.core.bean.DeviceInfo;
import com.huawei.riemann.gnsslocation.core.bean.eph.Ephemeris;
import com.huawei.riemann.gnsslocation.core.bean.obs.GnssClock;
import com.huawei.riemann.gnsslocation.core.bean.obs.Pvt;
import com.huawei.riemann.gnsslocation.core.bean.obs.SatelliteMeasurement;
import com.huawei.riemann.gnsslocation.core.bean.sensor.MotionSensors;

/* loaded from: classes5.dex */
public class VdrLocationAlgoWrapper {

    /* renamed from: a */
    public static volatile VdrLocationAlgoWrapper f40460a = null;

    /* renamed from: b */
    public static final Object f40461b = new Object();

    /* renamed from: c */
    public static boolean f40462c = false;

    public VdrLocationAlgoWrapper(Context context, String str) {
        f40462c = C6770j.m38374a(context, str);
    }

    /* renamed from: a */
    public static VdrLocationAlgoWrapper m53565a(Context context, String str) {
        if (f40460a == null) {
            synchronized (f40461b) {
                try {
                    if (f40460a == null) {
                        f40460a = new VdrLocationAlgoWrapper(context, str);
                    }
                } finally {
                }
            }
        }
        return f40460a;
    }

    public native Pvt vdrProcess(Pvt pvt, GnssClock[] gnssClockArr, SatelliteMeasurement[] satelliteMeasurementArr, MotionSensors motionSensors, Pvt pvt2);

    public native int vdrStart(DeviceInfo deviceInfo, String str);

    public native int vdrStop();

    public native void vdrUpdateEphemeris(Ephemeris ephemeris);
}

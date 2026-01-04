package com.huawei.riemann.location.gwivdr;

import as.C1016d;
import com.huawei.riemann.location.common.bean.Acceleration;
import com.huawei.riemann.location.common.bean.BiasData;
import com.huawei.riemann.location.common.bean.CalibrationPara;
import com.huawei.riemann.location.common.bean.Gyroscope;
import com.huawei.riemann.location.common.bean.LocationInfo;
import com.huawei.riemann.location.common.bean.RoadArea;
import com.huawei.riemann.location.common.bean.RotationAngle;
import com.huawei.riemann.location.common.bean.Vehicle;
import com.huawei.riemann.location.common.bean.obs.VdrGnssStatus;
import com.huawei.riemann.location.common.bean.obs.VdrResult;
import com.huawei.riemann.location.gwivdr.utils.LibraryUtils;

/* loaded from: classes5.dex */
public class GwiVdrAlgoWrapper {
    private static final Object LOCK = new Object();
    private static final String TAG = "GwiVdrAlgoWrapper";
    private static volatile GwiVdrAlgoWrapper gwiVdrAlgoWrapper;
    private final boolean isLibLoad;

    private GwiVdrAlgoWrapper(String str) {
        this.isLibLoad = LibraryUtils.loadSo(str);
    }

    public static GwiVdrAlgoWrapper getInstance(String str) {
        if (gwiVdrAlgoWrapper == null) {
            synchronized (LOCK) {
                try {
                    if (gwiVdrAlgoWrapper == null) {
                        gwiVdrAlgoWrapper = new GwiVdrAlgoWrapper(str);
                    }
                } finally {
                }
            }
        }
        return gwiVdrAlgoWrapper;
    }

    public boolean equals(Object obj) {
        C1016d.m6181a(TAG, "equals start.");
        return super.equals(obj);
    }

    public native VdrResult getResult();

    public int hashCode() {
        C1016d.m6181a(TAG, "hashCode start.");
        return super.hashCode();
    }

    public boolean isLibraryLoaded() {
        return this.isLibLoad;
    }

    public native void processAcc(Acceleration acceleration);

    public native void processGnss(LocationInfo locationInfo);

    public native void processGnssStatus(VdrGnssStatus[] vdrGnssStatusArr);

    public native void processGyroUncal(Gyroscope gyroscope);

    public native void processRoadArea(RoadArea roadArea);

    public native void processWss(Vehicle vehicle);

    public native void stopVdr();

    public String toString() {
        return TAG + super.toString();
    }

    public native void vdrInit(BiasData biasData, RotationAngle rotationAngle);

    public native void vdrInit2(BiasData biasData, CalibrationPara calibrationPara, RotationAngle rotationAngle);
}

package com.huawei.riemann.location.gwivdr;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import as.C1016d;
import com.huawei.riemann.location.common.bean.RotationAngle;
import com.huawei.riemann.location.common.bean.VdrInputData;
import com.huawei.riemann.location.common.utils.Constant;
import com.huawei.riemann.location.gwivdr.utils.KeepAliveManager;

/* loaded from: classes5.dex */
public class LocationClient {
    private static final String TAG = "LocationClient";
    private static volatile boolean isStarted = false;
    private static volatile LocationClient locationClient;
    private GwiVdrClient gwiVdrClient;
    private KeepAliveManager keepAliveManager;

    /* renamed from: com.huawei.riemann.location.gwivdr.LocationClient$1 */
    public static /* synthetic */ class C86821 {

        /* renamed from: $SwitchMap$com$huawei$riemann$location$common$bean$VdrInputData$DataType */
        static final /* synthetic */ int[] f40656xce12f30a;

        static {
            int[] iArr = new int[VdrInputData.DataType.values().length];
            f40656xce12f30a = iArr;
            try {
                iArr[VdrInputData.DataType.ACC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40656xce12f30a[VdrInputData.DataType.GYRO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40656xce12f30a[VdrInputData.DataType.VEHICLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f40656xce12f30a[VdrInputData.DataType.LOCATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f40656xce12f30a[VdrInputData.DataType.GNSS_INFO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private LocationClient(Context context, String str, RotationAngle rotationAngle) {
        if (str == null || str.isEmpty()) {
            C1016d.m6183c(TAG, "invalid input!");
            return;
        }
        GwiVdrClient gwiVdrClient = GwiVdrClient.getInstance(context, str, rotationAngle);
        this.gwiVdrClient = gwiVdrClient;
        this.keepAliveManager = new KeepAliveManager(gwiVdrClient);
    }

    public static LocationClient getInstance(Context context, String str, RotationAngle rotationAngle) {
        if (locationClient == null) {
            synchronized (LocationClient.class) {
                try {
                    if (locationClient == null) {
                        locationClient = new LocationClient(context, str, rotationAngle);
                    }
                } finally {
                }
            }
        }
        return locationClient;
    }

    public static void releaseInstance() {
        locationClient = null;
        setIsStarted(false);
        GwiVdrClient.releaseInstance();
    }

    private static void setIsStarted(boolean z10) {
        isStarted = z10;
    }

    public Location getVdrResult() {
        Location location;
        Bundle bundle;
        String str;
        int i10;
        if (this.gwiVdrClient == null || !isStarted) {
            C1016d.m6183c(TAG, "vdr not start yet, getVdrResult failed!");
            location = new Location(Constant.LOCATION_NAME_INVALID);
            bundle = new Bundle();
            str = Constant.SDK_RESULT_ERROR_CODE;
            i10 = 402;
        } else {
            KeepAliveManager keepAliveManager = this.keepAliveManager;
            str = Constant.ALGO_RESULT_ERROR_CODE;
            if (keepAliveManager != null && !keepAliveManager.isVdrStopped()) {
                Location vdrResult = this.gwiVdrClient.getVdrResult();
                if (vdrResult.getExtras() != null) {
                    this.keepAliveManager.setErrorCode(vdrResult.getExtras().getInt(Constant.ALGO_RESULT_ERROR_CODE));
                }
                return vdrResult;
            }
            location = new Location("fake");
            bundle = new Bundle();
            i10 = -1;
        }
        bundle.putInt(str, i10);
        location.setExtras(bundle);
        return location;
    }

    public boolean setVdrInput(VdrInputData vdrInputData) {
        String str;
        if (!isStarted) {
            str = "vdr not start yet, setInput failed!";
        } else if (this.gwiVdrClient == null) {
            str = "null vdr client!";
        } else if (vdrInputData == null) {
            str = "null VdrInputData!";
        } else {
            int i10 = C86821.f40656xce12f30a[vdrInputData.getDataType().ordinal()];
            if (i10 == 1) {
                return this.gwiVdrClient.setAcc(vdrInputData.getAcc());
            }
            if (i10 == 2) {
                return this.gwiVdrClient.setGyroUncal(vdrInputData.getGyro());
            }
            if (i10 == 3) {
                return this.gwiVdrClient.setWss(vdrInputData.getVehicle());
            }
            if (i10 == 4) {
                return this.gwiVdrClient.setLocation(vdrInputData.getLocation());
            }
            if (i10 == 5) {
                return this.gwiVdrClient.setGnssInfo(vdrInputData.getGnssInfo());
            }
            str = "unknown input: " + vdrInputData.getDataType();
        }
        C1016d.m6183c(TAG, str);
        return false;
    }

    public boolean startVdr() {
        if (isStarted) {
            C1016d.m6183c(TAG, "vdr already started!");
            return true;
        }
        if (this.gwiVdrClient == null) {
            C1016d.m6183c(TAG, "null vdr client!");
            return false;
        }
        setIsStarted(true);
        return this.gwiVdrClient.startVdr();
    }

    public void stopVdr() {
        String str;
        if (isStarted) {
            setIsStarted(false);
            GwiVdrClient gwiVdrClient = this.gwiVdrClient;
            if (gwiVdrClient != null) {
                gwiVdrClient.stopVdr();
                return;
            }
            str = "null vdr client!";
        } else {
            str = "vdr not start yet, stopVdr failed!";
        }
        C1016d.m6183c(TAG, str);
    }

    public String toString() {
        return "LocationClient{isStarted=" + isStarted + '}';
    }
}

package com.huawei.location.gwi;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import as.C1016d;
import com.huawei.location.gwi.config.CarGwiSoFileConstant;
import com.huawei.location.gwi.listener.CarVdrListenerManager;
import com.huawei.location.gwi.listener.ICarGwiSoLoadListener;
import com.huawei.location.gwi.listener.ICarVdrInitListener;
import com.huawei.location.gwi.listener.ICarVdrLocationListener;
import com.huawei.location.gwi.util.CarGwiUtil;
import com.huawei.location.gwi.util.GwiErrorCode;
import com.huawei.riemann.location.common.bean.RotationAngle;
import com.huawei.riemann.location.common.bean.VdrInputData;
import com.huawei.riemann.location.common.utils.Constant;
import com.huawei.riemann.location.gwivdr.LocationClient;
import hu.C10343b;
import java.util.concurrent.TimeUnit;
import p531or.C11991a;
import p784xq.C13850f;

/* loaded from: classes8.dex */
public class GwiLocationManager {
    private static final int GWI_LOCATION_TIME = 1000;
    private static final long LOCATION_VALID_TIME_THRESHOLD = 1200;
    private static final int MSG_GET_GWI_RESULT = 1;
    private static final String TAG = "GwiLocationManager";
    private static final byte[] VDR_SYNC_LOCK = new byte[0];
    private static volatile GwiLocationManager instance;
    private volatile boolean accuracyFilterEnable = false;
    private volatile float accuracyThreshold = 0.0f;
    private Handler handler;
    private HandlerThread handlerThread;
    private ICarVdrInitListener iCarVdrInitListener;
    private volatile Location inputLocation;
    private volatile long inputLocationTime;
    private LocationClient locationClient;
    private RotationAngle rotationAngle;

    private GwiLocationManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealGwiLocation() {
        try {
            Handler handler = this.handler;
            if (handler == null) {
                C1016d.m6183c(TAG, "handler is null, drop gnss data here.");
                return;
            }
            handler.removeCallbacksAndMessages(null);
            Handler handler2 = this.handler;
            handler2.sendMessageDelayed(handler2.obtainMessage(1), 1000L);
            Location validLocation = getValidLocation(getGwiLocation());
            if (validLocation != null) {
                CarVdrListenerManager.getInstance().onVdrLocationChanged(validLocation);
            }
        } catch (Exception e10) {
            C1016d.m6183c(TAG, "dealGwiLocation fail, msg is : " + e10.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealInitError(int i10) {
        if (this.iCarVdrInitListener == null) {
            return;
        }
        C1016d.m6183c(TAG, "dealInitError: " + GwiErrorCode.valueOf(i10).toString());
        this.iCarVdrInitListener.onFail(i10, GwiErrorCode.valueOfKey(i10));
    }

    private void dealVdrError(int i10, int i11) {
        CarVdrListenerManager.getInstance().onVdrError(i11, CarGwiUtil.getAlgErrorMsg(i10, i11));
    }

    private Location getGwiLocation() {
        try {
            LocationClient locationClient = this.locationClient;
            if (locationClient == null) {
                return null;
            }
            return getVdrResult(locationClient.getVdrResult());
        } catch (Exception e10) {
            C1016d.m6183c(TAG, "getGwiLocation exception: " + e10.getMessage());
            return null;
        }
    }

    public static GwiLocationManager getInstance() {
        if (instance == null) {
            synchronized (VDR_SYNC_LOCK) {
                try {
                    if (instance == null) {
                        instance = new GwiLocationManager();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    private Location getValidLocation(Location location) {
        if (location != null) {
            return location;
        }
        if (isInputLocationValid()) {
            return this.inputLocation;
        }
        return null;
    }

    private Location getVdrResult(Location location) {
        CarGwiUtil.getAndResetInputCount();
        if (location == null) {
            return null;
        }
        C10343b c10343b = new C10343b(location.getExtras());
        int iM63687i = c10343b.m63687i(Constant.SDK_RESULT_ERROR_CODE, -9);
        int iM63687i2 = c10343b.m63687i(Constant.ALGO_RESULT_ERROR_CODE, -9);
        if (iM63687i2 != 0 && iM63687i2 != 20) {
            dealVdrError(iM63687i, iM63687i2);
            return null;
        }
        int i10 = iM63687i2 == 0 ? 4 : 8;
        StringBuilder sb2 = new StringBuilder("gwiLocation received here,sdkErrorCode is: ");
        sb2.append(iM63687i);
        sb2.append(" ,algoErrorCode is: ");
        sb2.append(iM63687i2);
        sb2.append("locationSource is: ");
        C13850f.m83120a(sb2, i10, TAG);
        c10343b.m63698t("LocationSource", i10);
        location.setExtras(c10343b.m63683e());
        if (CarGwiUtil.isLocationValid(location)) {
            return location;
        }
        C1016d.m6183c(TAG, "location is not valid.");
        return null;
    }

    private void initHandler() {
        C1016d.m6186f(TAG, "initHandler.");
        if (this.handler != null) {
            C1016d.m6186f(TAG, "handler has been init, return here.");
            return;
        }
        HandlerThread handlerThread = new HandlerThread("Loc-gwi");
        this.handlerThread = handlerThread;
        handlerThread.start();
        this.handler = new Handler(this.handlerThread.getLooper()) { // from class: com.huawei.location.gwi.GwiLocationManager.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                C13850f.m83120a(new StringBuilder("msg.what="), message.what, GwiLocationManager.TAG);
                if (message.what != 1) {
                    return;
                }
                GwiLocationManager.this.dealGwiLocation();
            }
        };
    }

    private boolean isGwiStart() {
        return this.locationClient != null;
    }

    private boolean isInputLocationValid() {
        return this.inputLocation != null && SystemClock.elapsedRealtimeNanos() - this.inputLocationTime <= TimeUnit.MILLISECONDS.toNanos(LOCATION_VALID_TIME_THRESHOLD);
    }

    private void loadGwiFile() {
        new CarGwiFileManager().checkGwiSoService(new ICarGwiSoLoadListener() { // from class: com.huawei.location.gwi.GwiLocationManager.2
            @Override // com.huawei.location.gwi.listener.ICarGwiSoLoadListener
            public void handleLoadResult(boolean z10) {
                GwiLocationManager gwiLocationManager;
                int i10;
                C1016d.m6186f(GwiLocationManager.TAG, "handleLoadResult: " + z10);
                if (z10) {
                    boolean zIsFileExist = CarGwiFileManager.isFileExist();
                    gwiLocationManager = GwiLocationManager.this;
                    if (zIsFileExist) {
                        gwiLocationManager.startGwiRequest();
                        return;
                    }
                    i10 = 106;
                } else {
                    gwiLocationManager = GwiLocationManager.this;
                    i10 = 102;
                }
                gwiLocationManager.dealInitError(i10);
            }
        });
    }

    private void releaseHandler() {
        C1016d.m6186f(TAG, "releaseHandler.");
        HandlerThread handlerThread = this.handlerThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        this.handler = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void startGwiRequest() {
        LocationClient locationClient;
        C1016d.m6186f(TAG, "startGwiRequest.");
        try {
            initHandler();
            locationClient = LocationClient.getInstance(C11991a.m72145a(), CarGwiSoFileConstant.SO_PATH, this.rotationAngle);
            this.locationClient = locationClient;
        } catch (IllegalArgumentException unused) {
            C1016d.m6183c(TAG, "locationClient start failed because of IllegalArgumentException.");
            dealInitError(103);
        } catch (Exception e10) {
            C1016d.m6183c(TAG, "locationClient start failed." + e10.getMessage());
            dealInitError(105);
        }
        if (locationClient == null) {
            C1016d.m6183c(TAG, "LocationClient init failed");
            dealInitError(103);
        } else {
            this.iCarVdrInitListener.onSuccess();
            C1016d.m6186f(TAG, "startGwiRequest success.");
        }
    }

    public synchronized void addVdrLocationListener(ICarVdrLocationListener iCarVdrLocationListener) {
        CarVdrListenerManager.getInstance().addVdrLocationListener(iCarVdrLocationListener);
    }

    public synchronized void disableAccuracyFilter() {
        C1016d.m6186f(TAG, "disableAccuracyFilter");
        this.accuracyFilterEnable = false;
        this.accuracyThreshold = 0.0f;
    }

    public synchronized void enableAccuracyFilter(float f10) {
        C1016d.m6186f(TAG, "enableAccuracyFilter: " + f10);
        this.accuracyFilterEnable = true;
        this.accuracyThreshold = f10;
    }

    public synchronized void init(Context context, RotationAngle rotationAngle, ICarVdrInitListener iCarVdrInitListener) {
        C1016d.m6186f(TAG, "init");
        if (iCarVdrInitListener == null) {
            C1016d.m6183c(TAG, "iCarVdrInitListener is null, return here.");
            return;
        }
        if (context == null) {
            C1016d.m6183c(TAG, "context is null.");
            dealInitError(107);
            return;
        }
        C11991a.m72147c(context);
        this.iCarVdrInitListener = iCarVdrInitListener;
        if (rotationAngle != null && rotationAngle.isValid()) {
            C1016d.m6186f(TAG, "rotationAngle info, " + rotationAngle.toString());
            this.rotationAngle = rotationAngle;
            if (isGwiStart()) {
                C1016d.m6186f(TAG, "LocationClient is not null, stop Vdr here.");
                stopVdr();
            }
            loadGwiFile();
            return;
        }
        C1016d.m6183c(TAG, "rotationAngle is null or invalid.");
        dealInitError(101);
    }

    public synchronized void removeVdrLocationListener(ICarVdrLocationListener iCarVdrLocationListener) {
        CarVdrListenerManager.getInstance().removeVdrLocationListener(iCarVdrLocationListener);
    }

    public synchronized boolean setVdrInputData(VdrInputData vdrInputData) {
        try {
            if (vdrInputData == null) {
                C1016d.m6183c(TAG, "vdrInputData is null, setVdrData fail.");
                return false;
            }
            CarGwiUtil.calInputInfo(vdrInputData);
            if (this.locationClient == null) {
                CarGwiUtil.logClientNullControl();
                return false;
            }
            if (vdrInputData.getDataType() == VdrInputData.DataType.LOCATION) {
                this.inputLocation = vdrInputData.getLocation();
                this.inputLocationTime = SystemClock.elapsedRealtimeNanos();
                if (this.accuracyFilterEnable && vdrInputData.getLocation().getAccuracy() > this.accuracyThreshold) {
                    C1016d.m6183c(TAG, "accuracy filter is Enable, accuracyThreshold is: " + this.accuracyThreshold + ", acc is: " + vdrInputData.getLocation().getAccuracy());
                    return true;
                }
                if (CarGwiUtil.isIllegalBearing(vdrInputData.getLocation().getBearing())) {
                    C1016d.m6183c(TAG, "bearing is illegal, bearing is: " + vdrInputData.getLocation().getBearing());
                    return true;
                }
            }
            return this.locationClient.setVdrInput(vdrInputData);
        } catch (Exception e10) {
            C1016d.m6183c(TAG, "setVdrInputData exception: " + e10.getMessage());
            return false;
        }
    }

    public synchronized boolean startVdr() {
        try {
            C1016d.m6186f(TAG, "startVdr.");
            LocationClient locationClient = this.locationClient;
            if (locationClient == null) {
                C1016d.m6183c(TAG, "rotationAngle is null, return here.");
                return false;
            }
            if (locationClient.startVdr()) {
                dealGwiLocation();
                return true;
            }
            C1016d.m6183c(TAG, "LocationClient is null, startVdr fail.");
            return false;
        } catch (Exception e10) {
            C1016d.m6183c(TAG, "startVdr exception: " + e10.getMessage());
            return false;
        }
    }

    public synchronized void stopVdr() {
        try {
            try {
                C1016d.m6186f(TAG, "stopVdr.");
                CarVdrListenerManager.getInstance().clearVdrLocationListener();
                LocationClient locationClient = this.locationClient;
                if (locationClient != null) {
                    locationClient.stopVdr();
                }
                LocationClient.releaseInstance();
                this.locationClient = null;
                releaseHandler();
            } catch (Exception e10) {
                C1016d.m6183c(TAG, "stopVdr exception: " + e10.getMessage());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}

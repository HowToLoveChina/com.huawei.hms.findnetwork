package com.huawei.riemann.location.gwivdr;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.SystemClock;
import as.C1016d;
import com.huawei.riemann.location.common.bean.Acceleration;
import com.huawei.riemann.location.common.bean.BiasData;
import com.huawei.riemann.location.common.bean.CalibrationPara;
import com.huawei.riemann.location.common.bean.GnssInfo;
import com.huawei.riemann.location.common.bean.Gyroscope;
import com.huawei.riemann.location.common.bean.LocationInfo;
import com.huawei.riemann.location.common.bean.RoadArea;
import com.huawei.riemann.location.common.bean.RotationAngle;
import com.huawei.riemann.location.common.bean.SatInfo;
import com.huawei.riemann.location.common.bean.Vehicle;
import com.huawei.riemann.location.common.bean.obs.VdrGnssStatus;
import com.huawei.riemann.location.common.bean.obs.VdrResult;
import com.huawei.riemann.location.common.utils.Constant;
import com.huawei.riemann.location.gwivdr.utils.ErrorCodeManager;
import com.huawei.riemann.location.gwivdr.utils.InputFreqCheckThread;
import com.huawei.riemann.location.gwivdr.utils.InputValueChecker;
import com.huawei.riemann.location.gwivdr.utils.SharedPreferencesUtils;
import p784xq.C13850f;

/* loaded from: classes5.dex */
public class GwiVdrClient {
    private static final String TAG = "GwiVdrClient";
    private static volatile GwiVdrClient gwiVdrClient;
    private GwiVdrAlgoWrapper algoWrapper;
    private InputFreqCheckThread freqCheckThread;
    private RotationAngle rotationAngle;
    private SharedPreferencesUtils spUtils;
    private int accFreq = 0;
    private long accFreqStartTime = System.currentTimeMillis();
    private int gyroFreq = 0;
    private long gyroFreqStartTime = System.currentTimeMillis();

    private GwiVdrClient(Context context, String str, RotationAngle rotationAngle) {
        C1016d.m6186f(TAG, "start, UTCTime: " + System.currentTimeMillis() + "bootTime: " + SystemClock.elapsedRealtime());
        if (str == null || str.isEmpty() || !InputValueChecker.isRotationAngleValid(rotationAngle)) {
            C1016d.m6183c(TAG, "invalid input!");
            return;
        }
        try {
            this.rotationAngle = rotationAngle;
            this.algoWrapper = GwiVdrAlgoWrapper.getInstance(str);
            this.spUtils = SharedPreferencesUtils.getInstance(context);
        } catch (IllegalArgumentException e10) {
            C1016d.m6183c(TAG, "gwi vdr client error: " + e10.getMessage());
        }
    }

    public static GwiVdrClient getInstance(Context context, String str, RotationAngle rotationAngle) {
        C1016d.m6186f(TAG, "getInstance start!");
        if (gwiVdrClient == null) {
            synchronized (GwiVdrClient.class) {
                try {
                    if (gwiVdrClient == null) {
                        gwiVdrClient = new GwiVdrClient(context, str, rotationAngle);
                        C1016d.m6186f(TAG, "create ok.");
                    }
                } finally {
                }
            }
        }
        return gwiVdrClient;
    }

    public static void releaseInstance() {
        gwiVdrClient = null;
    }

    private void stopAlgo() {
        C1016d.m6186f(TAG, "stopAlgo start!");
        GwiVdrAlgoWrapper gwiVdrAlgoWrapper = this.algoWrapper;
        if (gwiVdrAlgoWrapper != null && gwiVdrAlgoWrapper.isLibraryLoaded()) {
            this.algoWrapper.stopVdr();
        }
        C1016d.m6186f(TAG, "stopGwiVdr finished!");
    }

    private void storeData(VdrResult vdrResult) {
        if (vdrResult == null || !vdrResult.isNeedUpdateBias()) {
            return;
        }
        C1016d.m6181a(TAG, "ready to update data!");
        this.spUtils.storeBiasData(vdrResult.getBiasData());
        this.spUtils.storeCalibrationPara(vdrResult.getCalibrationPara());
    }

    public Location getVdrResult() {
        GwiVdrAlgoWrapper gwiVdrAlgoWrapper = this.algoWrapper;
        if (gwiVdrAlgoWrapper == null || !gwiVdrAlgoWrapper.isLibraryLoaded()) {
            C1016d.m6183c(TAG, "null wrapper, getVdrResult failed!");
            Location location = new Location(Constant.LOCATION_NAME_INVALID);
            Bundle bundle = new Bundle();
            bundle.putInt(Constant.SDK_RESULT_ERROR_CODE, 400);
            location.setExtras(bundle);
            return location;
        }
        VdrResult result = this.algoWrapper.getResult();
        if (result == null) {
            C1016d.m6183c(TAG, "null gwi result!");
            Location location2 = new Location(Constant.LOCATION_NAME_INVALID);
            Bundle bundle2 = new Bundle();
            bundle2.putInt(Constant.SDK_RESULT_ERROR_CODE, 401);
            location2.setExtras(bundle2);
            return location2;
        }
        storeData(result);
        Location location3 = result.toLocation();
        Bundle extras = location3.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putInt(Constant.SDK_RESULT_ERROR_CODE, ErrorCodeManager.getErrorCode());
        extras.putInt(Constant.ALGO_RESULT_ERROR_CODE, result.getErrCode());
        location3.setExtras(extras);
        return location3;
    }

    public boolean setAcc(Acceleration acceleration) {
        boolean z10 = false;
        if (!InputValueChecker.isAccValid(acceleration)) {
            C1016d.m6183c(TAG, "invalid acc!");
            return false;
        }
        GwiVdrAlgoWrapper gwiVdrAlgoWrapper = this.algoWrapper;
        if (gwiVdrAlgoWrapper != null && gwiVdrAlgoWrapper.isLibraryLoaded()) {
            InputFreqCheckThread inputFreqCheckThread = this.freqCheckThread;
            if (inputFreqCheckThread != null) {
                inputFreqCheckThread.accEnqueue(System.currentTimeMillis());
            }
            this.algoWrapper.processAcc(acceleration);
            if (this.accFreq == 0) {
                this.accFreqStartTime = System.currentTimeMillis();
            }
            z10 = true;
            this.accFreq++;
            if (System.currentTimeMillis() - this.accFreqStartTime >= 1000) {
                StringBuilder sb2 = new StringBuilder("BT: ");
                sb2.append(acceleration.getBootTime());
                sb2.append(", acc freq in client: ");
                C13850f.m83120a(sb2, this.accFreq, TAG);
                this.accFreq = 1;
                this.accFreqStartTime = System.currentTimeMillis();
            }
        }
        return z10;
    }

    public boolean setGnssInfo(GnssInfo gnssInfo) {
        try {
            if (!InputValueChecker.isGnssInfoValid(gnssInfo)) {
                C1016d.m6183c(TAG, "invalid GnssInfo!");
                return false;
            }
            GwiVdrAlgoWrapper gwiVdrAlgoWrapper = this.algoWrapper;
            if (gwiVdrAlgoWrapper != null && gwiVdrAlgoWrapper.isLibraryLoaded()) {
                int size = gnssInfo.getSatInfoList().size();
                C1016d.m6186f(TAG, "satCount: " + size);
                VdrGnssStatus[] vdrGnssStatusArr = new VdrGnssStatus[size];
                for (int i10 = 0; i10 < size; i10++) {
                    SatInfo satInfo = gnssInfo.getSatInfoList().get(i10);
                    VdrGnssStatus vdrGnssStatus = new VdrGnssStatus();
                    vdrGnssStatus.setBootTime(satInfo.getBootTime());
                    vdrGnssStatus.setAzimuth(satInfo.getAzimuth());
                    vdrGnssStatus.setCn0DbHz(satInfo.getSnr());
                    vdrGnssStatus.setConstellationType(satInfo.getConstellationType());
                    vdrGnssStatus.setElevationDegrees(satInfo.getElevation());
                    vdrGnssStatus.setSvid(satInfo.getSatNum());
                    vdrGnssStatus.setUsedInFix(satInfo.isUsedInFix());
                    vdrGnssStatusArr[i10] = vdrGnssStatus;
                }
                this.algoWrapper.processGnssStatus(vdrGnssStatusArr);
                return true;
            }
            return false;
        } catch (Exception unused) {
            C1016d.m6183c(TAG, "set GnssInfo error!");
            return false;
        }
    }

    public boolean setGyroUncal(Gyroscope gyroscope) {
        boolean z10 = false;
        if (!InputValueChecker.isGyroValid(gyroscope)) {
            C1016d.m6183c(TAG, "invalid gyro!");
            return false;
        }
        GwiVdrAlgoWrapper gwiVdrAlgoWrapper = this.algoWrapper;
        if (gwiVdrAlgoWrapper != null && gwiVdrAlgoWrapper.isLibraryLoaded()) {
            InputFreqCheckThread inputFreqCheckThread = this.freqCheckThread;
            if (inputFreqCheckThread != null) {
                inputFreqCheckThread.gyroEnqueue(System.currentTimeMillis());
            }
            this.algoWrapper.processGyroUncal(gyroscope);
            if (this.gyroFreq == 0) {
                this.gyroFreqStartTime = System.currentTimeMillis();
            }
            z10 = true;
            this.gyroFreq++;
            if (System.currentTimeMillis() - this.gyroFreqStartTime >= 1000) {
                StringBuilder sb2 = new StringBuilder("BT: ");
                sb2.append(gyroscope.getBootTime());
                sb2.append(", gyro freq in client: ");
                C13850f.m83120a(sb2, this.gyroFreq, TAG);
                this.gyroFreq = 1;
                this.gyroFreqStartTime = System.currentTimeMillis();
            }
        }
        return z10;
    }

    public boolean setLocation(Location location) {
        if (!InputValueChecker.isLocationValid(location)) {
            C1016d.m6183c(TAG, "invalid location!");
            return false;
        }
        GwiVdrAlgoWrapper gwiVdrAlgoWrapper = this.algoWrapper;
        if (gwiVdrAlgoWrapper == null || !gwiVdrAlgoWrapper.isLibraryLoaded()) {
            return false;
        }
        this.algoWrapper.processGnss(LocationInfo.newBuilder(location).build());
        return true;
    }

    public boolean setRoadArea(RoadArea roadArea) {
        if (InputValueChecker.isRoadAreaValid(roadArea)) {
            GwiVdrAlgoWrapper gwiVdrAlgoWrapper = this.algoWrapper;
            return gwiVdrAlgoWrapper != null && gwiVdrAlgoWrapper.isLibraryLoaded();
        }
        C1016d.m6183c(TAG, "invalid roadArea!");
        return false;
    }

    public boolean setWss(Vehicle vehicle) {
        if (!InputValueChecker.isWssValid(vehicle)) {
            C1016d.m6183c(TAG, "invalid wss!");
            return false;
        }
        GwiVdrAlgoWrapper gwiVdrAlgoWrapper = this.algoWrapper;
        if (gwiVdrAlgoWrapper == null || !gwiVdrAlgoWrapper.isLibraryLoaded()) {
            return false;
        }
        InputFreqCheckThread inputFreqCheckThread = this.freqCheckThread;
        if (inputFreqCheckThread != null) {
            inputFreqCheckThread.wssEnqueue(System.currentTimeMillis());
        }
        this.algoWrapper.processWss(vehicle);
        return true;
    }

    public boolean startVdr() {
        C1016d.m6186f(TAG, "Vdr start!");
        GwiVdrAlgoWrapper gwiVdrAlgoWrapper = this.algoWrapper;
        if (gwiVdrAlgoWrapper == null || !gwiVdrAlgoWrapper.isLibraryLoaded()) {
            C1016d.m6183c(TAG, "Algo so not loaded!");
            return false;
        }
        BiasData biasData = new BiasData();
        CalibrationPara calibrationPara = new CalibrationPara();
        SharedPreferencesUtils sharedPreferencesUtils = this.spUtils;
        if (sharedPreferencesUtils != null) {
            biasData = sharedPreferencesUtils.getBiasData();
            calibrationPara = this.spUtils.getCalibrationPara();
        }
        this.algoWrapper.vdrInit2(biasData, calibrationPara, this.rotationAngle);
        C1016d.m6186f(TAG, "rotationAngle: " + this.rotationAngle);
        C1016d.m6186f(TAG, "BiasData: " + biasData);
        C1016d.m6186f(TAG, "calibrationPara: " + calibrationPara);
        InputFreqCheckThread inputFreqCheckThread = InputFreqCheckThread.getInstance();
        this.freqCheckThread = inputFreqCheckThread;
        inputFreqCheckThread.start();
        C1016d.m6186f(TAG, "startVdr finished!");
        return true;
    }

    public void stopVdr() {
        stopAlgo();
        InputFreqCheckThread inputFreqCheckThread = this.freqCheckThread;
        if (inputFreqCheckThread != null) {
            inputFreqCheckThread.stopChecker();
        }
    }

    public String toString() {
        return TAG + super.toString();
    }
}

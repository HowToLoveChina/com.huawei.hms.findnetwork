package com.huawei.riemann.location.gwivdr.utils;

import android.content.Context;
import android.content.SharedPreferences;
import as.C1016d;
import com.huawei.riemann.location.common.bean.BiasData;
import com.huawei.riemann.location.common.bean.CalibrationPara;

/* loaded from: classes5.dex */
public class SharedPreferencesUtils {
    private static final String KEY_CN0_MEAN_TH = "cn0MeanTh";
    private static final String KEY_GYRO_BIAS_X = "gyroBiasX";
    private static final String KEY_GYRO_BIAS_Y = "gyroBiasY";
    private static final String KEY_GYRO_BIAS_Z = "gyroBiasZ";
    private static final String KEY_G_NORM = "gNorm";
    private static final String KEY_INTERP_BUFFER_SIZE = "interpBufferSize";
    private static final String KEY_PITCH_BIAS = "pitchBias";
    private static final String KEY_RESERVED_PARA1 = "reservedPara1";
    private static final String KEY_RESERVED_PARA2 = "reservedPara2";
    private static final String KEY_ROLL_BIAS = "rollBias";
    private static final String KEY_SYNC_BUFFER_SIZE = "syncBufferSize";
    private static final String KEY_WSS_SCALE_FACTOR = "wssScaleFactor";
    private static final String KEY_YAW_BIAS = "yawBias";
    private static final String PREFERENCES_FILE_NAME = "Gwi-loc-sp";
    private static final String TAG = "SharedPreferencesUtils";

    /* renamed from: sp */
    private static SharedPreferences f40657sp;
    private static volatile SharedPreferencesUtils spUtils;

    public static SharedPreferencesUtils getInstance(Context context) {
        if (spUtils == null) {
            synchronized (SharedPreferencesUtils.class) {
                try {
                    if (spUtils == null) {
                        spUtils = new SharedPreferencesUtils();
                        f40657sp = context.getSharedPreferences(PREFERENCES_FILE_NAME, 0);
                    }
                } finally {
                }
            }
        }
        return spUtils;
    }

    public static void release() {
        spUtils = null;
        f40657sp = null;
    }

    public BiasData getBiasData() {
        StringBuilder sb2;
        BiasData biasData = new BiasData();
        try {
            biasData.setBiasX(Double.parseDouble(f40657sp.getString(KEY_GYRO_BIAS_X, "0.0")));
            biasData.setBiasY(Double.parseDouble(f40657sp.getString(KEY_GYRO_BIAS_Y, "0.0")));
            biasData.setBiasZ(Double.parseDouble(f40657sp.getString(KEY_GYRO_BIAS_Z, "0.0")));
            biasData.setgNorm(Double.parseDouble(f40657sp.getString(KEY_G_NORM, "9.80")));
        } catch (ClassCastException e10) {
            e = e10;
            sb2 = new StringBuilder("get BiasData from sp error: ");
            sb2.append(e.getMessage());
            C1016d.m6183c(TAG, sb2.toString());
            C1016d.m6186f(TAG, "BiasData read from db: " + biasData);
            return biasData;
        } catch (NumberFormatException e11) {
            e = e11;
            sb2 = new StringBuilder("parse double format error: ");
            sb2.append(e.getMessage());
            C1016d.m6183c(TAG, sb2.toString());
            C1016d.m6186f(TAG, "BiasData read from db: " + biasData);
            return biasData;
        }
        C1016d.m6186f(TAG, "BiasData read from db: " + biasData);
        return biasData;
    }

    public CalibrationPara getCalibrationPara() {
        StringBuilder sb2;
        CalibrationPara calibrationPara = new CalibrationPara();
        try {
            calibrationPara.setWssScaleFactor(Double.parseDouble(f40657sp.getString(KEY_WSS_SCALE_FACTOR, "1.0")));
            calibrationPara.setRollBias(Double.parseDouble(f40657sp.getString(KEY_ROLL_BIAS, "0.0")));
            calibrationPara.setPitchBias(Double.parseDouble(f40657sp.getString(KEY_PITCH_BIAS, "0.0")));
            calibrationPara.setYawBias(Double.parseDouble(f40657sp.getString(KEY_YAW_BIAS, "0.0")));
            calibrationPara.setCn0MeanTh(Double.parseDouble(f40657sp.getString(KEY_CN0_MEAN_TH, "30.0")));
            calibrationPara.setInterpBufferSize(Integer.parseInt(f40657sp.getString(KEY_INTERP_BUFFER_SIZE, "8")));
            calibrationPara.setSyncBufferSize(Integer.parseInt(f40657sp.getString(KEY_SYNC_BUFFER_SIZE, "15")));
            calibrationPara.setReservedPara1(Double.parseDouble(f40657sp.getString(KEY_RESERVED_PARA1, "0.0")));
            calibrationPara.setReservedPara2(Double.parseDouble(f40657sp.getString(KEY_RESERVED_PARA2, "0.0")));
        } catch (ClassCastException e10) {
            e = e10;
            sb2 = new StringBuilder("get Calibration Para from sp error: ");
            sb2.append(e.getMessage());
            C1016d.m6183c(TAG, sb2.toString());
            C1016d.m6186f(TAG, "Calibration Para read from db: " + calibrationPara);
            return calibrationPara;
        } catch (NumberFormatException e11) {
            e = e11;
            sb2 = new StringBuilder("parse double format error: ");
            sb2.append(e.getMessage());
            C1016d.m6183c(TAG, sb2.toString());
            C1016d.m6186f(TAG, "Calibration Para read from db: " + calibrationPara);
            return calibrationPara;
        }
        C1016d.m6186f(TAG, "Calibration Para read from db: " + calibrationPara);
        return calibrationPara;
    }

    public void storeBiasData(BiasData biasData) {
        if (biasData == null) {
            C1016d.m6183c(TAG, "invalid BiasData, store failed!");
            return;
        }
        C1016d.m6186f(TAG, "BiasData store to db: " + biasData);
        SharedPreferences.Editor editorEdit = f40657sp.edit();
        editorEdit.putString(KEY_GYRO_BIAS_X, String.valueOf(biasData.getBiasX()));
        editorEdit.putString(KEY_GYRO_BIAS_Y, String.valueOf(biasData.getBiasY()));
        editorEdit.putString(KEY_GYRO_BIAS_Z, String.valueOf(biasData.getBiasZ()));
        editorEdit.putString(KEY_G_NORM, String.valueOf(biasData.getGNorm()));
        if (editorEdit.commit()) {
            return;
        }
        C1016d.m6183c(TAG, "biasData store failed! try again:");
        if (editorEdit.commit()) {
            return;
        }
        C1016d.m6183c(TAG, "biasData store failed again!");
    }

    public void storeCalibrationPara(CalibrationPara calibrationPara) {
        if (calibrationPara == null) {
            C1016d.m6183c(TAG, "invalid calibration Para, store failed!");
            return;
        }
        C1016d.m6186f(TAG, "Calibration Para store to db: " + calibrationPara);
        SharedPreferences.Editor editorEdit = f40657sp.edit();
        editorEdit.putString(KEY_WSS_SCALE_FACTOR, String.valueOf(calibrationPara.getWssScaleFactor()));
        editorEdit.putString(KEY_ROLL_BIAS, String.valueOf(calibrationPara.getRollBias()));
        editorEdit.putString(KEY_PITCH_BIAS, String.valueOf(calibrationPara.getPitchBias()));
        editorEdit.putString(KEY_YAW_BIAS, String.valueOf(calibrationPara.getYawBias()));
        editorEdit.putString(KEY_CN0_MEAN_TH, String.valueOf(calibrationPara.getCn0MeanTh()));
        editorEdit.putString(KEY_INTERP_BUFFER_SIZE, String.valueOf(calibrationPara.getInterpBufferSize()));
        editorEdit.putString(KEY_SYNC_BUFFER_SIZE, String.valueOf(calibrationPara.getSyncBufferSize()));
        editorEdit.putString(KEY_RESERVED_PARA1, String.valueOf(calibrationPara.getReservedPara1()));
        editorEdit.putString(KEY_RESERVED_PARA2, String.valueOf(calibrationPara.getReservedPara2()));
        if (editorEdit.commit()) {
            return;
        }
        C1016d.m6183c(TAG, "Calibration Para store failed! try again:");
        if (editorEdit.commit()) {
            return;
        }
        C1016d.m6183c(TAG, "Calibration Para store failed again!");
    }
}

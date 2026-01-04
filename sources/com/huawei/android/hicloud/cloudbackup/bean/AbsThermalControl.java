package com.huawei.android.hicloud.cloudbackup.bean;

import android.os.Build;
import android.text.TextUtils;
import java.util.List;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public abstract class AbsThermalControl {
    public static final String ALL_DEVICES = "*";
    protected static final int DEFAULT_VALUE = -1;
    private static final String TAG = "AbsThermalControl";
    int thermalRetryInteval = -1;
    int blowoutThreshold = -1;
    int blowoutDuration = -1;
    int uniStopLevel = 1;

    public abstract boolean checkIllegalArgument();

    public int getBlowoutDuration() {
        return this.blowoutDuration;
    }

    public int getBlowoutThreshold() {
        return this.blowoutThreshold;
    }

    public abstract int getStartLevel();

    public abstract int getStopLevel();

    public int getThermalRetryInteval() {
        return this.thermalRetryInteval;
    }

    public int getUniStopLevel() {
        return this.uniStopLevel;
    }

    public abstract boolean isCurrentDeviceMatched();

    public boolean isCurrentDeviceMatched(List<String> list) {
        if (list == null || list.isEmpty()) {
            C11839m.m70689w(TAG, "matchThermalControlDevice config is empty");
            return false;
        }
        String str = Build.MODEL;
        if (TextUtils.isEmpty(str)) {
            C11839m.m70689w(TAG, "matchThermalControlDevice phoneType is empty");
            return false;
        }
        C11839m.m70688i(TAG, "matchThermalControlDevice cloud phoneTypes " + list + " ,current phoneType = " + str);
        for (String str2 : list) {
            if (TextUtils.isEmpty(str2)) {
                C11839m.m70687e(TAG, "device is empty");
            } else {
                if (TextUtils.equals(str2, "*")) {
                    C11839m.m70688i(TAG, "matchThermalControlDevice all " + list);
                    return true;
                }
                if (TextUtils.equals(str, str2)) {
                    C11839m.m70688i(TAG, "matchThermalControlDevice config = " + list);
                    return true;
                }
            }
        }
        return false;
    }

    public void setUniStopLevel(int i10) {
        this.uniStopLevel = i10;
    }
}

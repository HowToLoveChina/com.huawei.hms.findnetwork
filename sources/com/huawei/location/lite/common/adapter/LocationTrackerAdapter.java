package com.huawei.location.lite.common.adapter;

import as.C1016d;
import es.C9552q;

/* loaded from: classes8.dex */
public class LocationTrackerAdapter {
    private static final String TAG = "LocationTrackerAdapter";
    private static boolean locationTrackerEnable = true;

    public static boolean isLocationTrackerEnable() {
        return locationTrackerEnable;
    }

    public static void setLocationTrackerEnable(boolean z10) {
        C1016d.m6186f(TAG, "sdk type: " + C9552q.m59643a() + ", set location tracker enable: " + z10);
        if (C9552q.m59643a() != 100) {
            return;
        }
        locationTrackerEnable = z10;
    }
}

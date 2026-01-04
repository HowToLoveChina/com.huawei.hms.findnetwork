package com.huawei.hms.support.picker.common;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.common.internal.constant.AuthInternalPickerConstant;
import p640sq.C12836o;

/* loaded from: classes8.dex */
public class HMSAPKVersionCheckUtil {
    private static final String TAG = "HMSAPKVersionCheckUtil";

    public static void checkAvailabilityAndConnect(Activity activity, int i10, AvailableAdapter.AvailableCallBack availableCallBack) {
        C12836o.m77097b(TAG, "====== HMSSDK version: 61200300 ======", true);
        Context applicationContext = activity.getApplicationContext();
        int minApkVersion = getMinApkVersion();
        C12836o.m77097b(TAG, "check minVersion:" + minApkVersion, true);
        AvailableAdapter availableAdapter = new AvailableAdapter(minApkVersion);
        int iIsHuaweiMobileServicesAvailable = availableAdapter.isHuaweiMobileServicesAvailable(applicationContext);
        if (2 == iIsHuaweiMobileServicesAvailable || ((1 == iIsHuaweiMobileServicesAvailable && i10 == 2) || (1 == iIsHuaweiMobileServicesAvailable && i10 == 3))) {
            availableAdapter.startResolution(activity, availableCallBack);
        } else {
            availableCallBack.onComplete(iIsHuaweiMobileServicesAvailable);
        }
    }

    private static int getMinApkVersion() {
        return AuthInternalPickerConstant.HMS_APK_VERSION_MIN;
    }
}

package com.huawei.hms.hwid;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.adapter.AvailableAdapter;

/* renamed from: com.huawei.hms.hwid.q */
/* loaded from: classes8.dex */
public class C5619q {
    /* renamed from: a */
    public static int m32953a() {
        return 30000000;
    }

    /* renamed from: a */
    public static void m32954a(Activity activity, AvailableAdapter.AvailableCallBack availableCallBack) {
        C5602as.m32910b("HmsAPKVersionCheckUtil", "====== HMSSDK version: 61200300 ======", true);
        Context applicationContext = activity.getApplicationContext();
        int iM32953a = m32953a();
        C5602as.m32910b("HmsAPKVersionCheckUtil", "check minVersion:" + iM32953a, true);
        AvailableAdapter availableAdapter = new AvailableAdapter(iM32953a);
        int iIsHuaweiMobileServicesAvailable = availableAdapter.isHuaweiMobileServicesAvailable(applicationContext);
        if (iIsHuaweiMobileServicesAvailable == 0) {
            availableCallBack.onComplete(iIsHuaweiMobileServicesAvailable);
        } else if (availableAdapter.isUserResolvableError(iIsHuaweiMobileServicesAvailable)) {
            availableAdapter.startResolution(activity, availableCallBack);
        } else {
            availableCallBack.onComplete(iIsHuaweiMobileServicesAvailable);
        }
    }
}

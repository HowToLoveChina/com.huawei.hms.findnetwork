package com.huawei.hms.hwid;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.adapter.AvailableAdapter;

/* renamed from: com.huawei.hms.hwid.a */
/* loaded from: classes8.dex */
public class C5583a {
    /* renamed from: a */
    public static int m32857a() {
        return 40004000;
    }

    /* renamed from: a */
    public static void m32858a(Activity activity, AvailableAdapter.AvailableCallBack availableCallBack) {
        C5602as.m32910b("HmsAccountKitVersionCheckUtil", "====== HMSSDK version: 61200300 ======", true);
        Context applicationContext = activity.getApplicationContext();
        int iM32857a = m32857a();
        C5602as.m32910b("HmsAccountKitVersionCheckUtil", "check minVersion:" + iM32857a, true);
        AvailableAdapter availableAdapter = new AvailableAdapter(iM32857a);
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

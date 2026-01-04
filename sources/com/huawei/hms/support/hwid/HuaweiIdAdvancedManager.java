package com.huawei.hms.support.hwid;

import android.content.Context;
import com.huawei.hms.support.hwid.service.C6496b;
import com.huawei.hms.support.hwid.service.HuaweiIdAdvancedService;

/* loaded from: classes8.dex */
public class HuaweiIdAdvancedManager {
    public static HuaweiIdAdvancedService getService(Context context) {
        return new C6496b(context);
    }
}

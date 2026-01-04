package com.huawei.hms.activity.internal;

import android.app.Activity;
import android.content.Intent;

/* loaded from: classes8.dex */
public interface BusResponseCallback {
    BusResponseResult innerError(Activity activity, int i10, String str);

    BusResponseResult succeedReturn(Activity activity, int i10, Intent intent);
}

package com.huawei.hms.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.huawei.hms.support.log.HMSLog;

/* renamed from: com.huawei.hms.push.g */
/* loaded from: classes8.dex */
public class C6288g {
    /* renamed from: a */
    public static int m36525a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return activeNetworkInfo.getType();
        }
        HMSLog.m36988i("NetworkUtil", "no connected network");
        return -1;
    }
}

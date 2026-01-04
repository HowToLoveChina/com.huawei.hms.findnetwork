package com.huawei.hms.locationSdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import as.C1016d;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.log.HMSLog;

/* renamed from: com.huawei.hms.locationSdk.z */
/* loaded from: classes8.dex */
public class C5773z implements InterfaceC5761v {

    /* renamed from: a */
    private static volatile boolean f25607a;

    /* renamed from: b */
    private static boolean m33217b(Context context) {
        if (context == null) {
            return true;
        }
        boolean z10 = context.getPackageManager().checkPermission("android.permission.UPDATE_DEVICE_STATS", "com.huawei.hwid") == 0;
        HMSLog.m36988i("LiteSDKProxy", "isHmsWithSysSignature：" + z10);
        return z10;
    }

    /* renamed from: c */
    private static boolean m33218c(Context context) throws PackageManager.NameNotFoundException {
        String str;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 16384);
            if (packageInfo != null && (packageInfo.applicationInfo.flags & 1) != 0) {
                C1016d.m6186f("LiteSDKProxy", "is system app");
                return true;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            str = "isSystemApplication NameNotFoundException";
            C1016d.m6183c("LiteSDKProxy", str);
            return false;
        } catch (RuntimeException unused2) {
            str = "Package Manager has died Exception";
            C1016d.m6183c("LiteSDKProxy", str);
            return false;
        }
        return false;
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5761v
    /* renamed from: a */
    public <TResult, TClient extends AnyClient, TOption extends Api.ApiOptions> Task<TResult> mo33178a(HuaweiApi<TOption> huaweiApi, TaskApiCall<TClient, TResult> taskApiCall, AbstractClientBuilder<TClient, TOption> abstractClientBuilder) {
        HMSLog.m36988i("LiteSDKProxy", "LiteSDKProxy doWriteProxy");
        return huaweiApi.doWrite(taskApiCall);
    }

    /* renamed from: a */
    public static boolean m33216a(Context context) {
        String str;
        if (f25607a) {
            str = "hms is abnormal";
        } else if (context == null) {
            str = "context is null";
        } else {
            z = m33218c(context) || m33217b(context);
            str = "isHMSEnable:" + z;
        }
        HMSLog.m36988i("LiteSDKProxy", str);
        return z;
    }

    /* renamed from: a */
    public static boolean m33215a() {
        return f25607a;
    }

    /* renamed from: a */
    public static void m33214a(boolean z10) {
        f25607a = z10;
    }
}

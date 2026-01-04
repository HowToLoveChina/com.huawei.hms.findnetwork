package com.huawei.location.base.activity.permission;

import as.C1016d;
import es.C9548m;
import p531or.C11991a;
import p622rr.C12619b;

/* loaded from: classes8.dex */
public class ARLocationPermissionManager {
    private static final String ACTIVITY_RECOGNITION_ANDROID_Q = "android.permission.ACTIVITY_RECOGNITION";
    private static final String PERMISSION_DENIED = "PERMISSION_DENIED";
    private static final String TAG = "ARLocationPermissionManager";

    public static boolean checkCPActivityRecognitionPermission(String str, int i10, int i11) {
        boolean zM59620c = C9548m.m59620c(C11991a.m72146b(), ACTIVITY_RECOGNITION_ANDROID_Q, i10, i11);
        C1016d.m6186f(str, "Activity recognition permission on android Q   is " + zM59620c);
        if (!zM59620c) {
            C1016d.m6185e(str, "pid: " + i10 + ",uid: " + i11 + " has no activity recognition permission ", true);
        }
        return zM59620c;
    }

    public static boolean checkCPActivityRecognitionPermissionByException(String str, String str2, int i10, int i11) {
        boolean zCheckCPActivityRecognitionPermission = checkCPActivityRecognitionPermission(str, i10, i11);
        if (zCheckCPActivityRecognitionPermission) {
            return zCheckCPActivityRecognitionPermission;
        }
        C1016d.m6183c(str, str2 + " has no activity recognition permission");
        throw new C12619b(10803, "PERMISSION_DENIED " + str2 + " has no Activity Recognition permission");
    }
}

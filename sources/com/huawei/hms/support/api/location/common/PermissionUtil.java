package com.huawei.hms.support.api.location.common;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.List;

/* loaded from: classes8.dex */
public class PermissionUtil {
    private static final String TAG = "PermissionUtil";

    public static boolean canAccessMockLocation(String str, Context context) {
        String str2;
        try {
            Object systemService = context.getSystemService("appops");
            if (systemService instanceof AppOpsManager) {
                return ((AppOpsManager) systemService).noteOp("android:mock_location", Process.myUid(), str) == 0;
            }
            HMSLog.m36988i(TAG, "canCallerAccessMockLocation ,no AppOpsManager ");
            return false;
        } catch (SecurityException unused) {
            str2 = "canCallerAccessMockLocation ,SecurityException ";
            HMSLog.m36988i(TAG, str2);
            return false;
        } catch (Exception unused2) {
            str2 = "canCallerAccessMockLocation ,Exception ";
            HMSLog.m36988i(TAG, str2);
            return false;
        }
    }

    private static boolean checkSelfPermission(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        }
        HMSLog.m36988i(TAG, "permission is null");
        return false;
    }

    public static boolean isAppIsInBackground(Context context) {
        String str;
        if (context == null) {
            str = "context is null";
        } else {
            Object systemService = context.getSystemService("activity");
            if (systemService instanceof ActivityManager) {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    boolean z10 = true;
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (isImportanceForeground(runningAppProcessInfo.importance)) {
                            String[] strArr = runningAppProcessInfo.pkgList;
                            int length = strArr.length;
                            int i10 = 0;
                            while (true) {
                                if (i10 >= length) {
                                    break;
                                }
                                if (strArr[i10].equals(context.getPackageName())) {
                                    z10 = false;
                                    break;
                                }
                                i10++;
                            }
                        }
                    }
                    return z10;
                }
                str = "runningProcesses is null";
            } else {
                str = "managerResult is not a instance of ActivityManager";
            }
        }
        HMSLog.m36986e(TAG, str);
        return false;
    }

    public static boolean isGeofencePermissionAvailable(Context context) {
        if (checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION")) {
            return checkSelfPermission(context, LocationConstant.BACKGROUND_PERMISSION);
        }
        return false;
    }

    private static boolean isImportanceForeground(int i10) {
        return i10 <= 125;
    }

    public static boolean isLocationPermissionAvailable(Context context) {
        String str;
        if (!checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") && !checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            str = "checkSelfPermission is false";
        } else {
            if (!isAppIsInBackground(context) || checkSelfPermission(context, LocationConstant.BACKGROUND_PERMISSION)) {
                return true;
            }
            str = "App is in background , but BackgroundPermission is false";
        }
        HMSLog.m36988i(TAG, str);
        return false;
    }

    public static boolean isPermissionAvailable(Context context, String str) {
        return checkSelfPermission(context, str);
    }
}

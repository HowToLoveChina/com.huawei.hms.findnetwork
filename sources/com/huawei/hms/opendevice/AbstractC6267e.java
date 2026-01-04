package com.huawei.hms.opendevice;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* renamed from: com.huawei.hms.opendevice.e */
/* loaded from: classes8.dex */
public abstract class AbstractC6267e {

    /* renamed from: a */
    private static String f29578a;

    /* renamed from: a */
    private static String m36418a() throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/self/cmdline");
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                try {
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            bufferedReader.close();
                            inputStreamReader.close();
                            fileInputStream.close();
                            return "";
                        }
                        String strTrim = line.trim();
                        bufferedReader.close();
                        inputStreamReader.close();
                        fileInputStream.close();
                        return strTrim;
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            HMSLog.m36986e("CommFun", "get current app processes IOException!");
            return "";
        } catch (Exception e10) {
            HMSLog.m36986e("CommFun", "get current app processes exception!" + e10.getMessage());
            return "";
        }
    }

    /* renamed from: b */
    public static boolean m36421b() {
        int i10 = HwBuildEx.VERSION.EMUI_SDK_INT;
        HMSLog.m36983d("CommFun", "Emui Api Level:" + i10);
        return i10 > 0;
    }

    /* renamed from: c */
    public static String m36422c(Context context) {
        String str = context.createDeviceProtectedStorageContext().getDataDir() + "";
        if (TextUtils.isEmpty(str)) {
            HMSLog.m36986e("CommFun", "get storage root path of the current user failed.");
        }
        return str;
    }

    /* renamed from: d */
    public static long m36423d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.huawei.android.pushagent", 16384).versionCode;
        } catch (Exception unused) {
            HMSLog.m36986e("CommFun", "get nc versionCode error");
            return -1L;
        }
    }

    /* renamed from: e */
    public static boolean m36424e(Context context) {
        return m36421b() && HwBuildEx.VERSION.EMUI_SDK_INT < 21 && m36423d(context) < 110001400;
    }

    /* renamed from: b */
    private static String m36420b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return "";
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses != null && runningAppProcesses.size() != 0) {
            int iMyPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == iMyPid && runningAppProcessInfo.processName != null) {
                    HMSLog.m36988i("CommFun", "info.pid -> " + runningAppProcessInfo.pid + ", info.processName -> " + runningAppProcessInfo.processName);
                    return runningAppProcessInfo.processName;
                }
            }
            return "";
        }
        HMSLog.m36989w("CommFun", "get running app processes null!");
        return "";
    }

    /* renamed from: a */
    public static String m36419a(Context context) throws IOException {
        if (!TextUtils.isEmpty(f29578a)) {
            return f29578a;
        }
        String strM36420b = m36420b(context);
        f29578a = strM36420b;
        if (!TextUtils.isEmpty(strM36420b)) {
            return f29578a;
        }
        String strM36418a = m36418a();
        f29578a = strM36418a;
        return strM36418a;
    }
}

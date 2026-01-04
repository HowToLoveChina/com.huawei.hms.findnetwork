package com.huawei.android.remotecontrol.track;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.location.Location;
import android.os.PowerManager;
import android.os.Process;
import android.os.SystemClock;
import com.huawei.android.remotecontrol.config.ParamConfig;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import p575qe.C12347f;
import p809yg.C13981a;

/* renamed from: com.huawei.android.remotecontrol.track.n */
/* loaded from: classes4.dex */
public class C4452n {
    /* renamed from: b */
    public static double m27022b(double d10, double d11, double d12, double d13) {
        double radians = Math.toRadians(d10);
        double radians2 = Math.toRadians(d11);
        double radians3 = Math.toRadians(d12);
        double radians4 = Math.toRadians(d13);
        return 12742.008d * Math.asin(Math.sqrt(Math.pow(Math.sin(Math.abs(radians - radians3) / 2.0d), 2.0d) + (Math.cos(radians) * Math.cos(radians3) * Math.pow(Math.sin(Math.abs(radians2 - radians4) / 2.0d), 2.0d)))) * 1000.0d;
    }

    /* renamed from: c */
    public static String m27023c(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        int iMyPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }

    /* renamed from: d */
    public static long m27024d() {
        return System.currentTimeMillis();
    }

    /* renamed from: e */
    public static long m27025e(Context context) {
        return m27028h(context) ? 30000L : 60000L;
    }

    /* renamed from: f */
    public static long m27026f(Context context) {
        if (!m27028h(context) || m27027g(context)) {
            return C4450l.m27009e(context);
        }
        return 30000L;
    }

    /* renamed from: g */
    public static boolean m27027g(Context context) {
        return m27024d() - C4450l.m27006b(context) > 270000;
    }

    /* renamed from: h */
    public static boolean m27028h(Context context) {
        return m27024d() - C4450l.m27006b(context) <= 0;
    }

    /* renamed from: i */
    public static boolean m27029i(Context context, Location location) {
        if ("network".equals(location.getProvider())) {
            if (location.getAccuracy() > ParamConfig.getInstance().getNetworkTrackAccInterval() && C4450l.m27017m(context) != null) {
                C13981a.m83988e("TrackUtils", "currentBestLocation is " + location.getProvider() + ", does not match " + ParamConfig.getInstance().getNetworkTrackAccInterval() + " accuracy and servers has tracks, so report break...");
                return false;
            }
        } else if (location.getAccuracy() > ParamConfig.getInstance().getGpsTrackAccInterval() && C4450l.m27017m(context) != null) {
            C13981a.m83988e("TrackUtils", "currentBestLocation is " + location.getProvider() + ", does not match " + ParamConfig.getInstance().getGpsTrackAccInterval() + " accuracy and servers has tracks, so report break...");
            return false;
        }
        return true;
    }

    /* renamed from: j */
    public static boolean m27030j(Context context) {
        return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    /* renamed from: k */
    public static boolean m27031k(Context context) {
        return ((PowerManager) context.getSystemService("power")).isInteractive();
    }

    /* renamed from: l */
    public static boolean m27032l(Context context) {
        Context context2 = (Context) Optional.ofNullable(context).orElseGet(new Supplier() { // from class: com.huawei.android.remotecontrol.track.m
            @Override // java.util.function.Supplier
            public final Object get() {
                return C4452n.m27033m();
            }
        });
        return C4450l.m27010f(context2) && C4450l.m27011g(context2) && m27030j(context2);
    }

    /* renamed from: m */
    public static /* synthetic */ Context m27033m() {
        return C12347f.m74285n().m74301m();
    }

    /* renamed from: n */
    public static void m27034n(Context context, long j10, int i10, long j11, String str) {
        C13981a.m83989i("TrackUtils", "updateTrackLocateConf,trackperiod:" + j10 + ";minDistance:" + i10 + ";serverTimestamp:" + j11);
        C4450l.m27016l(context, j10);
        C4450l.m27013i(context, i10);
        C4450l.m27014j(context, str);
        if (j11 <= 1492064388129L || Math.abs(j11 - m27024d()) <= 60000) {
            return;
        }
        SystemClock.setCurrentTimeMillis(j11);
    }

    /* renamed from: o */
    public static void m27035o(Context context, long j10) {
        if (m27031k(context)) {
            return;
        }
        ((PowerManager) context.getSystemService("power")).newWakeLock(268435466, "PhoneFind::screenWakeUp").acquire(j10);
        C13981a.m83989i("TrackUtils", "wakeUpScreen");
    }
}

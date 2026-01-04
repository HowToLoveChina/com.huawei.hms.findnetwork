package com.huawei.hms.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.AndroidException;
import com.huawei.hms.stats.C6310a;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import java.sql.Timestamp;

/* loaded from: classes8.dex */
public class AnalyticsSwitchHolder {
    public static final int ANALYTICS_DISABLED = 2;
    public static final int ANALYTICS_ENABLED = 1;

    /* renamed from: a */
    private static volatile int f30149a;

    /* renamed from: b */
    private static final Object f30150b = new Object();

    /* renamed from: c */
    private static volatile Long f30151c = 0L;

    /* renamed from: d */
    private static volatile boolean f30152d = false;

    /* renamed from: e */
    private static volatile boolean f30153e = false;

    /* renamed from: com.huawei.hms.utils.AnalyticsSwitchHolder$a */
    public class RunnableC6517a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f30154a;

        public RunnableC6517a(Context context) {
            this.f30154a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            AnalyticsSwitchHolder.m37005f(this.f30154a);
            HMSLog.m36988i("AnalyticsSwitchHolder", "getStateForHmsAnalyticsProvider");
        }
    }

    /* renamed from: com.huawei.hms.utils.AnalyticsSwitchHolder$b */
    public class RunnableC6518b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f30155a;

        public RunnableC6518b(Context context) {
            this.f30155a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.m36988i("AnalyticsSwitchHolder", "enter setAnalyticsStateAndTimestamp");
            AnalyticsSwitchHolder.m37005f(this.f30155a);
            HMSLog.m36988i("AnalyticsSwitchHolder", "quit setAnalyticsStateAndTimestamp");
        }
    }

    /* renamed from: b */
    private static boolean m37001b(Context context) {
        Bundle bundle;
        if (context == null) {
            HMSLog.m36986e("AnalyticsSwitchHolder", "In getBiIsReportSetting, context is null.");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                    return bundle.getBoolean("com.huawei.hms.client.bireport.setting");
                }
            } catch (AndroidException unused) {
                HMSLog.m36986e("AnalyticsSwitchHolder", "In getBiIsReportSetting, Failed to read meta data bi report setting.");
            } catch (RuntimeException e10) {
                HMSLog.m36987e("AnalyticsSwitchHolder", "In getBiIsReportSetting, Failed to read meta data bi report setting.", e10);
            }
        }
        HMSLog.m36988i("AnalyticsSwitchHolder", "In getBiIsReportSetting, configuration not found for bi report setting.");
        return false;
    }

    /* renamed from: c */
    private static void m37002c(Context context) {
        f30151c = Long.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
        new Thread(new RunnableC6517a(context), "Thread-getStateForHmsAnalyticsProvider").start();
    }

    /* renamed from: d */
    private static boolean m37003d(Context context) {
        return RegionUtils.isChinaROM(context);
    }

    /* renamed from: e */
    private static void m37004e(Context context) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if (timestamp.getTime() - f30151c.longValue() < 86400000 || f30151c.longValue() <= 0) {
            return;
        }
        f30151c = Long.valueOf(timestamp.getTime());
        new Thread(new RunnableC6518b(context), "Thread-refreshOobeAnalyticsState").start();
    }

    /* renamed from: f */
    public static void m37005f(Context context) {
        if (context == null) {
            HMSLog.m36986e("AnalyticsSwitchHolder", "In setAnalyticsState、, context is null.");
            return;
        }
        if (HiAnalyticsUtils.getInstance().getOobeAnalyticsState(context) != 1) {
            synchronized (f30150b) {
                f30149a = 2;
            }
            C6310a.m36621c().m36622a();
            return;
        }
        synchronized (f30150b) {
            f30149a = 1;
        }
        if (HiAnalyticsUtils.getInstance().getInitFlag() || f30152d) {
            return;
        }
        HMSBIInitializer.getInstance(context).initHaSDK();
        f30152d = true;
    }

    public static int getAndRefreshAnalyticsState(Context context) {
        int i10;
        synchronized (f30150b) {
            isAnalyticsDisabled(context);
            i10 = f30149a;
        }
        return i10;
    }

    public static boolean getBiSetting(Context context) {
        Bundle bundle;
        if (context == null) {
            HMSLog.m36986e("AnalyticsSwitchHolder", "In getBiSetting, context is null.");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                    return bundle.getBoolean("com.huawei.hms.client.bi.setting");
                }
            } catch (AndroidException unused) {
                HMSLog.m36986e("AnalyticsSwitchHolder", "In getBiSetting, Failed to read meta data bisetting.");
            } catch (RuntimeException e10) {
                HMSLog.m36987e("AnalyticsSwitchHolder", "In getBiSetting, Failed to read meta data bisetting.", e10);
            }
        }
        HMSLog.m36988i("AnalyticsSwitchHolder", "In getBiSetting, configuration not found for bisetting.");
        return false;
    }

    public static boolean isAnalyticsDisabled(Context context) {
        synchronized (f30150b) {
            try {
                if (f30149a == 0) {
                    if (context == null) {
                        return true;
                    }
                    if (m37001b(context)) {
                        HMSLog.m36988i("AnalyticsSwitchHolder", "Builder->biReportSetting :true");
                        f30149a = 1;
                    } else if (getBiSetting(context)) {
                        HMSLog.m36988i("AnalyticsSwitchHolder", "Builder->biSetting :true");
                        f30149a = 2;
                    } else if (m37003d(context)) {
                        f30149a = 1;
                    } else {
                        HMSLog.m36988i("AnalyticsSwitchHolder", "not ChinaROM");
                        f30149a = 3;
                        f30153e = true;
                        m37002c(context);
                    }
                } else if (f30153e) {
                    m37004e(context);
                }
                return f30149a != 1;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}

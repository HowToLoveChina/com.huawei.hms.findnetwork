package p451lf;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import com.huawei.android.remotecontrol.lowpower.LowPowerReport;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import p521og.C11877j;
import p664u0.C13108a;
import p809yg.C13981a;

/* renamed from: lf.a */
/* loaded from: classes4.dex */
public class C11274a {

    /* renamed from: b */
    public static final C11274a f52903b = new C11274a();

    /* renamed from: a */
    public b f52904a = new b();

    /* renamed from: lf.a$b */
    public static class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            if (context.getPackageName().equals(C11274a.m67665b(context))) {
                String action = hiCloudSafeIntent.getAction();
                if (action == null) {
                    C13981a.m83988e("LowPowerManager", "BatteryLowBroadcastReceiver action is null");
                    return;
                }
                boolean zM71202D = C11877j.m71202D(context);
                C13981a.m83989i("LowPowerManager", "BatteryLowBroadcastReceiver action:" + action + ";isLastLocReportSwitchOpen:" + zM71202D);
                if (action.equals("android.intent.action.BATTERY_LOW")) {
                    if (zM71202D) {
                        C13981a.m83989i("LowPowerManager", "ACTION_BATTERY_LOW initLowBatteryReport");
                        LowPowerReport.m26256c().m26258e(context);
                        return;
                    }
                    return;
                }
                if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                    if (zM71202D) {
                        C13981a.m83989i("LowPowerManager", "ACTION_POWER_DISCONNECTED initLowBatteryReport");
                        LowPowerReport.m26256c().m26258e(context);
                        return;
                    }
                    return;
                }
                if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                    C13981a.m83989i("LowPowerManager", "ACTION_POWER_CONNECTED releaseLowBatteryBec");
                    LowPowerReport.m26256c().m26259f(context);
                    return;
                }
                if (!action.equals("com.huawei.android.remotecontrol.PHONEFINDER_LASTLOCATION_SWITCHER")) {
                    if (action.equals("com.huawei.android.remotecontrol.PHONEFINDER_DEVICE_DELETE")) {
                        C13981a.m83989i("LowPowerManager", "PHONEFINDER_DEVICE_DELETE releaseLowBatteryBec");
                        LowPowerReport.m26256c().m26259f(context);
                        return;
                    }
                    return;
                }
                if (hiCloudSafeIntent.getBooleanExtra("phonefinder_lastlocation_switcher_result", true)) {
                    C13981a.m83989i("LowPowerManager", "PHONEFINDER_LASTLOCATION_SWITCHER initLowBatteryReport");
                    LowPowerReport.m26256c().m26258e(context);
                } else {
                    C13981a.m83989i("LowPowerManager", "PHONEFINDER_LASTLOCATION_SWITCHER releaseLowBatteryBec");
                    LowPowerReport.m26256c().m26259f(context);
                }
            }
        }
    }

    /* renamed from: b */
    public static String m67665b(Context context) {
        int iMyPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager.getRunningAppProcesses() != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }

    /* renamed from: c */
    public static C11274a m67666c() {
        return f52903b;
    }

    /* renamed from: d */
    public void m67667d(Context context) {
        if (context.getPackageName().equals(m67665b(context))) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_LOW");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            context.registerReceiver(this.f52904a, intentFilter);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("com.huawei.android.remotecontrol.PHONEFINDER_LASTLOCATION_SWITCHER");
            intentFilter2.addAction("com.huawei.android.remotecontrol.PHONEFINDER_DEVICE_DELETE");
            C13108a.m78878b(context).m78880c(this.f52904a, intentFilter2);
        }
    }
}

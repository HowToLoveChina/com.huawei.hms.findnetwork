package je;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import com.hihonor.android.telephony.HwTelephonyManager;
import com.hihonor.android.telephony.SubscriptionManagerEx;
import com.huawei.hwcloudjs.p164f.C6661f;
import java.util.Iterator;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0227m;
import p514o9.C11839m;

/* renamed from: je.d */
/* loaded from: classes3.dex */
public class C10782d {

    /* renamed from: d */
    public static final C10782d f51522d = new C10782d();

    /* renamed from: a */
    public boolean f51523a = true;

    /* renamed from: b */
    public int f51524b = -1;

    /* renamed from: c */
    public int f51525c = 1;

    /* renamed from: a */
    public static C10782d m65634a() {
        return f51522d;
    }

    /* renamed from: b */
    public String m65635b(Context context) {
        if (context == null) {
            C11839m.m70687e("BackupNetWorkUtil", "context is null");
            return String.valueOf(-1);
        }
        if (!C0209d.m1333z1(context)) {
            C11839m.m70689w("BackupNetWorkUtil", "network disconnect");
            return String.valueOf(-1);
        }
        if (C0209d.m1254f2(context)) {
            C11839m.m70686d("BackupNetWorkUtil", " is using mobile network");
            return C0227m.m1593f(m65639f(context));
        }
        if (m65649p(context)) {
            C11839m.m70686d("BackupNetWorkUtil", " is using Vsim network");
            return String.valueOf(3);
        }
        C11839m.m70686d("BackupNetWorkUtil", " is using mobile network");
        return String.valueOf(m65637d(context));
    }

    /* renamed from: c */
    public int m65636c() {
        return this.f51524b;
    }

    /* renamed from: d */
    public int m65637d(Context context) {
        if (context == null) {
            return -1;
        }
        int slotIndex = C0209d.m1277l1() ? SubscriptionManagerEx.getSlotIndex(m65638e(context)) : com.huawei.android.telephony.SubscriptionManagerEx.getSlotIndex(m65638e(context));
        return !m65647n(slotIndex) ? C0209d.m1277l1() ? HwTelephonyManager.getDefault().getDefault4GSlotId() : android.telephony.HwTelephonyManager.getDefault().getDefault4GSlotId() : slotIndex;
    }

    /* renamed from: e */
    public final int m65638e(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            return Settings.Global.getInt(context.getContentResolver(), "multi_sim_data_call");
        } catch (Settings.SettingNotFoundException e10) {
            C11839m.m70688i("BackupNetWorkUtil", e10.toString());
            return -1;
        }
    }

    /* renamed from: f */
    public String m65639f(Context context) {
        if (context == null) {
            C11839m.m70687e("BackupNetWorkUtil", "getWifiSsid context is null");
            return String.valueOf(-1);
        }
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(C6661f.f30885g);
        if (wifiManager == null) {
            C11839m.m70687e("BackupNetWorkUtil", "getWifiSsid mWifiManager is null");
            return String.valueOf(-1);
        }
        String strValueOf = String.valueOf(-1);
        try {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            strValueOf = connectionInfo.getSSID();
            int networkId = connectionInfo.getNetworkId();
            List<WifiConfiguration> configuredNetworks = wifiManager.getConfiguredNetworks();
            if (configuredNetworks == null || configuredNetworks.size() <= 0) {
                strValueOf = String.valueOf(-1);
                C11839m.m70687e("BackupNetWorkUtil", "wifiSsid is empty");
            } else {
                Iterator<WifiConfiguration> it = configuredNetworks.iterator();
                while (true) {
                    if (it.hasNext()) {
                        WifiConfiguration next = it.next();
                        if (next.networkId == networkId) {
                            strValueOf = next.SSID;
                            break;
                        }
                    }
                }
            }
            break;
        } catch (Exception e10) {
            C11839m.m70687e("BackupNetWorkUtil", "getWifiSsid occurred exception, " + e10.getMessage());
        }
        return strValueOf;
    }

    /* renamed from: g */
    public void m65640g(Context context) {
        if (context == null) {
            C11839m.m70687e("BackupNetWorkUtil", "context is null");
            return;
        }
        if (C0209d.m1333z1(context)) {
            if (C0209d.m1254f2(context)) {
                m65651r(2);
            } else if (!m65649p(context)) {
                m65651r(m65637d(context));
            } else {
                C11839m.m70688i("BackupNetWorkUtil", " is using Vsim");
                m65651r(3);
            }
        }
    }

    /* renamed from: h */
    public void m65641h(boolean z10) {
        C11839m.m70688i("BackupNetWorkUtil", "supportMobileDataOperate " + z10);
        this.f51523a = z10;
    }

    /* renamed from: i */
    public boolean m65642i(Context context) {
        return !m65645l() ? C0209d.m1254f2(context) : C0209d.m1254f2(context) || C0209d.m1333z1(context);
    }

    /* renamed from: j */
    public boolean m65643j(Context context) {
        if (m65645l()) {
            return C0209d.m1150A1(context);
        }
        return false;
    }

    /* renamed from: k */
    public boolean m65644k(Context context) {
        return m65643j(context);
    }

    /* renamed from: l */
    public boolean m65645l() {
        return this.f51523a;
    }

    /* renamed from: m */
    public final boolean m65646m(Context context) {
        if (context == null) {
            C11839m.m70687e("BackupNetWorkUtil", "context is null");
            return false;
        }
        if (C0209d.m1277l1() ? HwTelephonyManager.getDefault().isPlatformSupportVsim() : android.telephony.HwTelephonyManager.getDefault().isPlatformSupportVsim()) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    if (packageManager.getPackageInfo("com.huawei.skytone", 16384) != null) {
                        return true;
                    }
                }
            } catch (PackageManager.NameNotFoundException | RuntimeException e10) {
                C11839m.m70687e("BackupNetWorkUtil", "isSupportVsim error: " + e10.toString());
            }
        }
        return false;
    }

    /* renamed from: n */
    public final boolean m65647n(int i10) {
        if (i10 >= 0 && i10 < 2) {
            return true;
        }
        C11839m.m70688i("BackupNetWorkUtil", " slotId is invalid");
        return false;
    }

    /* renamed from: o */
    public boolean m65648o() {
        return C0209d.m1277l1() ? HwTelephonyManager.getDefault().isVSimEnabled() : android.telephony.HwTelephonyManager.getDefault().isVSimEnabled();
    }

    /* renamed from: p */
    public boolean m65649p(Context context) {
        boolean z10 = context != null && m65648o() && m65646m(context);
        C11839m.m70688i("BackupNetWorkUtil", "isVsimOpen " + z10);
        return z10;
    }

    /* renamed from: q */
    public void m65650q(int i10) {
        this.f51525c = i10;
    }

    /* renamed from: r */
    public void m65651r(int i10) {
        this.f51524b = i10;
    }

    /* renamed from: s */
    public boolean m65652s(Context context) {
        return m65645l() ? C0209d.m1333z1(context) : C0209d.m1254f2(context);
    }
}

package es;

import android.content.Context;
import android.content.IntentFilter;
import android.provider.Settings;
import as.C1016d;
import com.huawei.location.lite.common.android.receiver.ScreenStatusBroadcastReceiver;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import p531or.C11991a;

/* renamed from: es.j */
/* loaded from: classes8.dex */
public class C9545j {

    /* renamed from: a */
    public static AtomicBoolean f47452a = new AtomicBoolean(false);

    /* renamed from: b */
    public static volatile int f47453b = 0;

    /* renamed from: a */
    public static String m59600a(Context context) {
        try {
            return context.createDeviceProtectedStorageContext().getFilesDir().getCanonicalPath();
        } catch (IOException unused) {
            C1016d.m6183c("LocationUtil", "getCanonicalPath is IOException");
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m59601b(Context context) {
        if (context == null) {
            C1016d.m6183c("LocationUtil", "isBlePresent Context is null");
            return false;
        }
        boolean zHasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        C1016d.m6186f("LocationUtil", "isBlePresent isBlePresent is " + zHasSystemFeature);
        return zHasSystemFeature;
    }

    /* renamed from: c */
    public static boolean m59602c(Context context) {
        if (context == null) {
            C1016d.m6183c("LocationUtil", "isBlueBoothEnabled Context is null");
            return false;
        }
        int i10 = Settings.Global.getInt(context.getContentResolver(), "bluetooth_on", -1);
        boolean z10 = i10 == 1;
        C1016d.m6186f("LocationUtil", "isBlueBoothEnabled locationMode is " + i10);
        return z10;
    }

    /* renamed from: d */
    public static boolean m59603d(Context context) {
        return m59604e(context, true);
    }

    /* renamed from: e */
    public static boolean m59604e(Context context, boolean z10) throws Settings.SettingNotFoundException {
        String str;
        if (context == null) {
            str = "isLocationEnabled Context is null";
        } else {
            try {
                int i10 = Settings.Secure.getInt(context.getContentResolver(), "location_mode");
                C1016d.m6186f("LocationUtil", "isLocationEnabled locationMode is " + i10);
                if (!z10) {
                    return i10 != 0;
                }
                if (i10 == 0) {
                    return false;
                }
                int i11 = Settings.Secure.getInt(context.getContentResolver(), "first_open_location_switch", 1);
                C1016d.m6186f("LocationUtil", "isLocationEnabled agreed is " + i11);
                return i11 == 1;
            } catch (Settings.SettingNotFoundException unused) {
                str = "isLocationEnabled SettingNotFoundException";
            }
        }
        C1016d.m6183c("LocationUtil", str);
        return false;
    }

    /* renamed from: f */
    public static boolean m59605f(Context context) throws Settings.SettingNotFoundException {
        if (context == null) {
            C1016d.m6183c("LocationUtil", "isScanBleEnabled Context is null");
            return false;
        }
        try {
            int i10 = Settings.Global.getInt(context.getContentResolver(), "ble_scan_always_enabled");
            z = i10 == 1;
            C1016d.m6186f("LocationUtil", "isScanBleEnabled locationMode is " + i10);
        } catch (Settings.SettingNotFoundException unused) {
            C1016d.m6183c("LocationUtil", "isScanBleEnabled SettingNotFoundException");
        }
        return z;
    }

    /* renamed from: g */
    public static synchronized void m59606g() {
        if (f47452a.get()) {
            C1016d.m6186f("LocationUtil", "registerScreenStatusBroadcast is Register");
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        C11991a.m72145a().registerReceiver(new ScreenStatusBroadcastReceiver(), intentFilter);
        f47452a.set(true);
    }
}

package p611rf;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.cloud.base.util.C4633d0;
import p521og.C11881n;
import p809yg.C13981a;

/* renamed from: rf.f */
/* loaded from: classes4.dex */
public final class C12498f {

    /* renamed from: a */
    public static String f57543a;

    /* renamed from: a */
    public static String m75014a(Context context) {
        String deviceId = null;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                deviceId = telephonyManager.getDeviceId();
            } else {
                C13981a.m83990w("DeviceId", "TelephonyManager is null.");
            }
        } catch (Exception e10) {
            C13981a.m83988e("DeviceId", "TelephonyManager getDeviceId error:" + e10.getMessage());
        }
        return deviceId;
    }

    /* renamed from: b */
    public static String m75015b(Context context) {
        if (!TextUtils.isEmpty(f57543a)) {
            return f57543a;
        }
        f57543a = "";
        if (context == null) {
            return "";
        }
        if (context.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            C13981a.m83989i("DeviceId", "getSerialNo checkPermission failed.");
            return f57543a;
        }
        try {
            f57543a = Build.getSerial();
        } catch (RuntimeException e10) {
            C13981a.m83988e("DeviceId", "getSerialNo exception ：" + e10.getMessage());
            f57543a = "";
        }
        return "unknown".equalsIgnoreCase(f57543a) ? "" : f57543a;
    }

    /* renamed from: c */
    public static String m75016c(Context context, String str, String str2) {
        if (!m75018e(str)) {
            C13981a.m83990w("DeviceId", "sdk deviceId is invalidate.");
            return null;
        }
        if ("9".equals(str2)) {
            String strM71361k = C11881n.m71361k(context);
            if (!C4633d0.m28404a(strM71361k)) {
                return strM71361k;
            }
        }
        String strM75014a = m75014a(context);
        if (m75018e(strM75014a)) {
            return strM75014a;
        }
        C13981a.m83990w("DeviceId", "local deviceId is invalidate.");
        if (m75017d(str)) {
            return null;
        }
        return str;
    }

    /* renamed from: d */
    public static boolean m75017d(String str) {
        return !TextUtils.isEmpty(str) && str.matches("(.{8}-.{4}-.{4}-.{4}-.{12})");
    }

    /* renamed from: e */
    public static boolean m75018e(String str) {
        if (TextUtils.isEmpty(str)) {
            C13981a.m83990w("DeviceId", "deviceId is empty");
            return false;
        }
        if (!str.matches("(0+)")) {
            return true;
        }
        C13981a.m83990w("DeviceId", "deviceId is all-zero");
        return false;
    }

    /* renamed from: f */
    public static boolean m75019f(String str) {
        if (!m75018e(str)) {
            C13981a.m83990w("DeviceId", "sdk deviceId is invalidate.");
            return false;
        }
        if (!m75017d(str)) {
            return true;
        }
        C13981a.m83990w("DeviceId", "sdk deviceId is UUID.");
        return false;
    }
}

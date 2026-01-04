package com.huawei.hianalytics;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;

/* renamed from: com.huawei.hianalytics.n0 */
/* loaded from: classes5.dex */
public abstract class AbstractC4795n0 {
    /* renamed from: a */
    public abstract int mo28968a();

    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m28970a(android.content.Context r2) {
        /*
            r1 = this;
            com.huawei.hianalytics.i r1 = com.huawei.hianalytics.C4782i.m28891a()
            com.huawei.hianalytics.l r1 = r1.m28893a()
            java.lang.String r0 = r1.f21849b
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L33
            java.lang.String r0 = "android.permission.READ_PHONE_STATE"
            boolean r0 = com.huawei.hianalytics.C4785j.m28923a(r2, r0)
            if (r0 != 0) goto L19
            goto L2f
        L19:
            java.lang.String r0 = "phone"
            java.lang.Object r2 = r2.getSystemService(r0)     // Catch: java.lang.SecurityException -> L28
            android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2     // Catch: java.lang.SecurityException -> L28
            if (r2 == 0) goto L2f
            java.lang.String r2 = r2.getDeviceId()     // Catch: java.lang.SecurityException -> L28
            goto L31
        L28:
            java.lang.String r2 = "DeviceIdUtils"
            java.lang.String r0 = "no permissions"
            com.huawei.hianalytics.core.log.HiLog.m28808e(r2, r0)
        L2f:
            java.lang.String r2 = ""
        L31:
            r1.f21849b = r2
        L33:
            java.lang.String r1 = r1.f21849b
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.AbstractC4795n0.m28970a(android.content.Context):java.lang.String");
    }

    /* renamed from: b */
    public final String m28971b(Context context) {
        String serial;
        C4790l c4790lM28893a = C4782i.m28891a().m28893a();
        if (TextUtils.isEmpty(c4790lM28893a.f21852d)) {
            String str = "";
            if (context != null && C4785j.m28923a(context, "android.permission.READ_PHONE_STATE")) {
                try {
                    serial = Build.getSerial();
                } catch (SecurityException unused) {
                    HiLog.m28808e("DeviceIdUtils", "no permissions");
                    serial = "";
                }
                if (!serial.equalsIgnoreCase("unknown")) {
                    str = serial;
                }
            }
            c4790lM28893a.f21852d = str;
        }
        return c4790lM28893a.f21852d;
    }
}

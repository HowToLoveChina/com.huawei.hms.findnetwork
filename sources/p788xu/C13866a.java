package p788xu;

import p752wu.C13640b;
import su.C12860b;

/* renamed from: xu.a */
/* loaded from: classes9.dex */
public class C13866a {
    /* renamed from: a */
    public static String m83194a(String str) {
        return C12860b.m77204h(str, "getDeviceCategory", "device_category");
    }

    /* renamed from: b */
    public static int m83195b(String str) {
        if (C13640b.m82013c("powerMode")) {
            return C12860b.m77198b(str, "getDeviceType", "device_type", -1);
        }
        return -1;
    }

    /* renamed from: c */
    public static int m83196c(String str) {
        return C12860b.m77198b(str, "getMonitorCapability", "device_monitor_capability", 2);
    }

    /* renamed from: d */
    public static int m83197d(String str) {
        return C12860b.m77198b(str, "getNotifyCapability", "device_notify_capability", 2);
    }

    /* renamed from: e */
    public static int m83198e(String str) {
        return C12860b.m77198b(str, "getP2pCapability", "device_p2p_capability", 2);
    }

    /* renamed from: f */
    public static String m83199f(String str) {
        return C12860b.m77204h(str, "getReservedness", "device_reservedness");
    }

    /* renamed from: g */
    public static int m83200g(String str) {
        return C12860b.m77198b(str, "getSensorCapability", "device_sensor_capability", 2);
    }

    /* renamed from: h */
    public static String m83201h(String str) {
        return C12860b.m77204h(str, "getSoftwareVersion", "device_soft_version");
    }

    /* renamed from: i */
    public static boolean m83202i(String str) {
        return C12860b.m77202f(str, "getSupportOTA", "device_is_support_ota");
    }
}

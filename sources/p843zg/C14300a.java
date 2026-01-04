package p843zg;

import java.lang.reflect.InvocationTargetException;
import p809yg.C13981a;

/* renamed from: zg.a */
/* loaded from: classes4.dex */
public final class C14300a {
    /* renamed from: a */
    public static void m85168a(String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            C13981a.m83989i("SecurityCenterReportUtil", "start report secEvent: the device is located. cmd:" + str);
            Class<?> cls = Class.forName("com.huawei.securityguard.SecEvent");
            Object objNewInstance = cls.getConstructor(String.class, String.class).newInstance("phoneFinder", "beLocated");
            cls.getMethod("putString", String.class, String.class).invoke(objNewInstance, "locateCmd", str);
            cls.getMethod("report", new Class[0]).invoke(objNewInstance, new Object[0]);
        } catch (Exception e10) {
            C13981a.m83988e("SecurityCenterReportUtil", "reportBeLocated catch Exception: " + e10.toString());
        }
    }

    /* renamed from: b */
    public static void m85169b(boolean z10) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            C13981a.m83989i("SecurityCenterReportUtil", "start report secEvent: change phone finder switch to " + z10);
            Class<?> cls = Class.forName("com.huawei.securityguard.SecEvent");
            Object objNewInstance = cls.getConstructor(String.class, String.class).newInstance("phoneFinder", "phoneFinderSwitch");
            cls.getMethod("putBool", String.class, Boolean.TYPE).invoke(objNewInstance, "status", Boolean.valueOf(z10));
            cls.getMethod("report", new Class[0]).invoke(objNewInstance, new Object[0]);
        } catch (Exception e10) {
            C13981a.m83988e("SecurityCenterReportUtil", "reportPhoneFinderSwitchChange catch Exception: " + e10.toString());
        }
    }
}

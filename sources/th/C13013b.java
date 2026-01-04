package th;

/* renamed from: th.b */
/* loaded from: classes4.dex */
public class C13013b {

    /* renamed from: a */
    public static boolean f59264a = false;

    /* renamed from: b */
    public static boolean f59265b = false;

    /* JADX WARN: Removed duplicated region for block: B:25:0x0056  */
    static {
        /*
            java.lang.String r0 = "LogConfig"
            java.lang.Class<android.util.Log> r1 = android.util.Log.class
            r2 = 0
            java.lang.String r3 = "HWLog"
            java.lang.reflect.Field r3 = r1.getField(r3)     // Catch: java.lang.Throwable -> L10
            boolean r3 = r3.getBoolean(r1)     // Catch: java.lang.Throwable -> L10
            goto L16
        L10:
            java.lang.String r3 = "can not get HWLog"
            android.util.Log.e(r0, r3)
            r3 = r2
        L16:
            java.lang.String r4 = "HWModuleLog"
            java.lang.reflect.Field r4 = r1.getField(r4)     // Catch: java.lang.Throwable -> L21
            boolean r4 = r4.getBoolean(r1)     // Catch: java.lang.Throwable -> L21
            goto L27
        L21:
            java.lang.String r4 = "can not get HWModuleLog"
            android.util.Log.e(r0, r4)
            r4 = r2
        L27:
            java.lang.String r5 = "MarketInstallService"
            r6 = 1
            if (r3 != 0) goto L38
            if (r4 == 0) goto L36
            r3 = 3
            boolean r3 = android.util.Log.isLoggable(r5, r3)
            if (r3 == 0) goto L36
            goto L38
        L36:
            r3 = r2
            goto L39
        L38:
            r3 = r6
        L39:
            th.C13013b.f59264a = r3
            java.lang.String r3 = "HWINFO"
            java.lang.reflect.Field r3 = r1.getField(r3)     // Catch: java.lang.Throwable -> L48
            boolean r0 = r3.getBoolean(r1)     // Catch: java.lang.Throwable -> L48
            if (r0 != 0) goto L56
            goto L4d
        L48:
            java.lang.String r1 = "can not get HWINFO"
            android.util.Log.e(r0, r1)
        L4d:
            if (r4 == 0) goto L57
            r0 = 4
            boolean r0 = android.util.Log.isLoggable(r5, r0)
            if (r0 == 0) goto L57
        L56:
            r2 = r6
        L57:
            th.C13013b.f59265b = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: th.C13013b.<clinit>():void");
    }

    /* renamed from: a */
    public static boolean m78320a() {
        return f59264a;
    }

    /* renamed from: b */
    public static boolean m78321b() {
        return f59265b;
    }

    /* renamed from: c */
    public static boolean m78322c() {
        return true;
    }
}

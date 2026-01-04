package p015ak;

import android.content.Context;

/* renamed from: ak.f */
/* loaded from: classes6.dex */
public class C0213f {

    /* renamed from: a */
    public static Context f796a;

    /* renamed from: a */
    public static Context m1377a() {
        return f796a;
    }

    /* renamed from: b */
    public static Context m1378b() {
        return f796a.createDeviceProtectedStorageContext();
    }

    /* renamed from: c */
    public static Context m1379c() {
        Context context = f796a;
        if (context == null) {
            return null;
        }
        Context contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        return contextCreateDeviceProtectedStorageContext == null ? f796a : contextCreateDeviceProtectedStorageContext;
    }

    /* renamed from: d */
    public static void m1380d(Context context) {
        f796a = context;
    }
}

package p384j4;

import android.content.Context;

/* renamed from: j4.b */
/* loaded from: classes.dex */
public class C10703b {
    /* renamed from: a */
    public static boolean m65333a() {
        return true;
    }

    /* renamed from: b */
    public static Context m65334b(Context context) {
        return m65333a() ? context.createDeviceProtectedStorageContext() : context;
    }
}

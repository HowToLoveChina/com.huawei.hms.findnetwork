package p434kt;

import android.text.TextUtils;
import android.util.Log;

/* renamed from: kt.d */
/* loaded from: classes2.dex */
public abstract class AbstractC11150d {
    /* renamed from: a */
    public static boolean m67064a(String str) throws ClassNotFoundException {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            Log.w("ReflectAPI", "class not found for " + str);
            return false;
        }
    }
}

package p640sq;

import android.content.Context;
import android.content.pm.PackageManager;

/* renamed from: sq.q */
/* loaded from: classes8.dex */
public class C12838q {
    /* renamed from: a */
    public static String m77102a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        return packageManager == null ? "" : packageManager.getApplicationLabel(context.getApplicationInfo()).toString();
    }
}

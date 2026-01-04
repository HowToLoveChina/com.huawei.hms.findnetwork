package je;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import p371ik.C10527a;
import p514o9.C11839m;

/* renamed from: je.c0 */
/* loaded from: classes3.dex */
public class C10781c0 {
    /* renamed from: a */
    public static boolean m65631a(List<String> list, String str) {
        if (list != null && !TextUtils.isEmpty(str)) {
            return (str.length() > 2 && str.charAt(0) == '\"' && str.charAt(str.length() - 1) == '\"') ? list.contains(str.substring(1, str.length() - 1)) : list.contains(str);
        }
        C11839m.m70689w("VehicleSsidUtils", "isContainsSsid: input is invalid.");
        return false;
    }

    /* renamed from: b */
    public static List<String> m65632b(Context context) {
        if (context != null) {
            return C10527a.m64626d(Settings.Global.getString(context.getContentResolver(), "vehicleSsidList"), String.class);
        }
        C11839m.m70689w("VehicleSsidUtils", "getVehicleSsid: context is null.");
        return new ArrayList();
    }

    /* renamed from: c */
    public static boolean m65633c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            C11839m.m70689w("VehicleSsidUtils", "setVehicleSsidSettings: input is invalid.");
            return false;
        }
        try {
            boolean zPutString = Settings.Global.putString(context.getContentResolver(), "vehicleSsidList", str);
            C11839m.m70688i("VehicleSsidUtils", "setVehicleSsidSettings: set success, isPut = " + zPutString);
            return zPutString;
        } catch (IllegalArgumentException | UnsupportedOperationException unused) {
            C11839m.m70687e("VehicleSsidUtils", "setVehicleSsidSettings: error");
            return false;
        }
    }
}

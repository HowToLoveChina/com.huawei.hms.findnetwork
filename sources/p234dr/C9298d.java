package p234dr;

import android.content.Context;
import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import as.C1016d;
import es.C9551p;
import es.C9555t;
import java.util.LinkedList;
import java.util.List;

/* renamed from: dr.d */
/* loaded from: classes8.dex */
public final class C9298d {

    /* renamed from: a */
    public static final boolean f46655a;

    static {
        boolean z10;
        if (C9551p.m59641e("android.telephony.TelephonyManager$CellInfoCallback")) {
            C1016d.m6186f("TelephonyService", "support CallBack");
            z10 = true;
        } else {
            C1016d.m6190j("TelephonyService", "not support CallBack");
            z10 = false;
        }
        f46655a = z10;
    }

    /* renamed from: a */
    public static String m58596a(Context context) {
        TelephonyManager telephonyManager;
        if (C9555t.m59664i()) {
            C1016d.m6181a("TelephonyService", "airplaneMode on, no mcc");
            return "";
        }
        Object systemService = context.getSystemService("phone");
        String networkOperator = null;
        if (systemService instanceof TelephonyManager) {
            telephonyManager = (TelephonyManager) systemService;
        } else {
            C1016d.m6181a("TelephonyService", "not get TELEPHONY_SERVICE");
            telephonyManager = null;
        }
        if (telephonyManager == null) {
            C1016d.m6181a("TelephonyService", "no TelephonyManager");
            return "";
        }
        if (telephonyManager.getPhoneType() != 2) {
            networkOperator = telephonyManager.getNetworkOperator();
        } else if (telephonyManager.getSimState() == 5 && !telephonyManager.isNetworkRoaming()) {
            networkOperator = telephonyManager.getSimOperator();
        }
        if (networkOperator != null && networkOperator.length() >= 3) {
            return networkOperator.substring(0, 3);
        }
        C1016d.m6183c("TelephonyService", "mcc is Empty");
        return "";
    }

    /* renamed from: b */
    public static List<CellInfo> m58597b(Context context) {
        TelephonyManager telephonyManager;
        Object systemService = context.getSystemService("phone");
        if (systemService instanceof TelephonyManager) {
            telephonyManager = (TelephonyManager) systemService;
        } else {
            C1016d.m6181a("TelephonyService", "not get TELEPHONY_SERVICE");
            telephonyManager = null;
        }
        if (telephonyManager == null) {
            C1016d.m6181a("TelephonyService", "no TelephonyManager");
            return new LinkedList();
        }
        if (f46655a) {
            C9296b.m58594a(telephonyManager);
        }
        List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
        if (allCellInfo != null) {
            return allCellInfo;
        }
        C1016d.m6181a("TelephonyService", "cell info null");
        return new LinkedList();
    }
}

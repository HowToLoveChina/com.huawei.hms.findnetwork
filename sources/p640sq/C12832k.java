package p640sq;

import android.content.Context;
import android.os.Build;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.util.HashMap;
import org.json.JSONException;

/* renamed from: sq.k */
/* loaded from: classes8.dex */
public class C12832k {
    /* renamed from: a */
    public static void m77082a(Context context, int i10, boolean z10) throws JSONException {
        HashMap map = new HashMap();
        map.put("uuid", C12843v.m77127d(context));
        map.put("isHMSCore ", i10 + "");
        map.put("isSignInByMCP", z10 + "");
        map.put("os", "Android");
        map.put("os_ver", Build.VERSION.SDK_INT + "");
        map.put("sdkName", "accountPicker");
        map.put(HiAnalyticsConstant.BI_KEY_SDK_VER, "60900100");
        map.put("pub_mfc", Build.MANUFACTURER);
        map.put(JsbMapKeyNames.H5_BRAND, Build.BRAND);
        map.put("service", "AccountPicker");
        map.put("screenResolution", C12839r.m77112j(context).toString());
        C12836o.m77097b("HiAnalyticsUtils", "HA_params = " + map.toString(), false);
        HiAnalyticsUtil.getInstance().onEvent(context, "accountPicker_deviceinfo", map);
    }

    /* renamed from: b */
    public static void m77083b(Context context, boolean z10) throws JSONException {
        m77082a(context, 0, z10);
    }
}

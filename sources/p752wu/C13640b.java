package p752wu;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.wearengine.monitor.MonitorItem;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import su.C12860b;

/* renamed from: wu.b */
/* loaded from: classes9.dex */
public class C13640b {

    /* renamed from: a */
    public static volatile int f61333a = -1;

    /* renamed from: b */
    public static volatile int f61334b;

    /* renamed from: c */
    public static Map<String, Integer> f61335c;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f61335c = concurrentHashMap;
        concurrentHashMap.put("device_get_bonded_device_ex", 2);
        f61335c.put("p2p_send_extra", 2);
        f61335c.put("p2p_get_device_app_version_code", 4);
        f61335c.put("device_get_hi_link_device_id", 2);
        f61335c.put(MonitorItem.f45313h.m56557a(), 2);
        f61335c.put(MonitorItem.f45310e.m56557a(), 2);
        f61335c.put(MonitorItem.f45312g.m56557a(), 2);
        f61335c.put(MonitorItem.f45309d.m56557a(), 2);
        f61335c.put(MonitorItem.f45311f.m56557a(), 2);
        f61335c.put(MonitorItem.f45308c.m56557a(), 2);
        f61335c.put(MonitorItem.f45314i.m56557a(), 2);
        f61335c.put("monitor_query", 2);
        f61335c.put("notify_notify", 2);
        f61335c.put("sensor", 2);
        f61335c.put("auth_pre_start_auth", 2);
        f61335c.put("p2p_cancel_file_transfer", 5);
        f61335c.put("wear_user_status", 6);
        f61335c.put("motion_sensor", 6);
        f61335c.put("device_get_all_bonded_device", 6);
        f61335c.put("is_support_ota", 7);
        f61335c.put("device_get_common_device", 8);
        f61335c.put("set_frequency_type", 8);
        f61335c.put("p2p_send_file_transfer_way_report", 9);
        f61335c.put("query_device_capability", 10);
        f61335c.put("device_sn", 12);
        f61335c.put("powerMode", 13);
    }

    /* renamed from: a */
    public static int m82011a() throws PackageManager.NameNotFoundException {
        Bundle bundle;
        if (f61334b != 0) {
            return f61334b;
        }
        Context contextM82014a = C13641c.m82014a();
        PackageManager packageManager = contextM82014a.getPackageManager();
        int i10 = 0;
        if (packageManager == null) {
            C12860b.m77205i("ApiLevelUtil", "getMetaDataApiLevel PackageManager is null");
        } else {
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(contextM82014a.getPackageName(), 128);
                if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                    int i11 = bundle.getInt("com.huawei.wearengine.sdk.api_level");
                    C12860b.m77203g("ApiLevelUtil", "getMetaDataApiLevel apiLevel:" + i11);
                    i10 = i11;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                C12860b.m77197a("ApiLevelUtil", "getMetaDataApiLevel PackageManager.NameNotFoundException");
            }
        }
        f61334b = i10;
        return f61334b;
    }

    /* renamed from: b */
    public static void m82012b(int i10) {
        f61333a = i10;
    }

    /* renamed from: c */
    public static boolean m82013c(String str) {
        C12860b.m77203g("ApiLevelUtil", "isServiceSupport apiName:" + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int iIntValue = f61335c.get(str) == null ? 0 : f61335c.get(str).intValue();
        if (iIntValue == 0) {
            C12860b.m77205i("ApiLevelUtil", "isServiceSupport inputApiLevel is null");
            return false;
        }
        C12860b.m77203g("ApiLevelUtil", "isServiceSupport serviceApiLevel: " + f61333a + ", minSupportApiLevel:" + iIntValue);
        return f61333a >= iIntValue;
    }
}

package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.List;

/* renamed from: com.huawei.hms.push.e */
/* loaded from: classes8.dex */
public class C6286e {
    /* renamed from: a */
    public static String m36518a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128)).toString();
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            HMSLog.m36988i("PushSelfShowLog", "get the app name of package:" + str + " failed.");
            return null;
        }
    }

    /* renamed from: b */
    private static boolean m36521b() {
        return true;
    }

    /* renamed from: c */
    public static boolean m36523c(Context context, String str) {
        if (context != null && str != null && !"".equals(str)) {
            try {
                if (context.getPackageManager().getApplicationInfo(str, 8192) == null) {
                    return false;
                }
                HMSLog.m36983d("PushSelfShowLog", str + " is installed");
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* renamed from: d */
    public static boolean m36524d() {
        return true;
    }

    /* renamed from: b */
    public static Intent m36520b(Context context, String str) {
        try {
            return context.getPackageManager().getLaunchIntentForPackage(str);
        } catch (Exception unused) {
            HMSLog.m36989w("PushSelfShowLog", str + " not have launch activity");
            return null;
        }
    }

    /* renamed from: c */
    public static boolean m36522c() {
        return Build.VERSION.SDK_INT >= 33;
    }

    /* renamed from: a */
    public static Boolean m36517a(Context context, String str, Intent intent) {
        try {
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (listQueryIntentActivities != null && listQueryIntentActivities.size() > 0) {
                int size = listQueryIntentActivities.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (listQueryIntentActivities.get(i10).activityInfo != null && str.equals(listQueryIntentActivities.get(i10).activityInfo.applicationInfo.packageName)) {
                        return Boolean.TRUE;
                    }
                }
            }
        } catch (Exception e10) {
            HMSLog.m36987e("PushSelfShowLog", e10.toString(), e10);
        }
        return Boolean.FALSE;
    }

    /* renamed from: a */
    public static int m36516a() {
        return m36521b() ? HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK : HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK;
    }

    /* renamed from: a */
    public static boolean m36519a(Context context) {
        return "com.huawei.hwid".equals(context.getPackageName());
    }
}

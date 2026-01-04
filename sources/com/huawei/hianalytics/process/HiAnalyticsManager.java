package com.huawei.hianalytics.process;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.C4747d1;
import com.huawei.hianalytics.C4782i;
import com.huawei.hianalytics.C4785j;
import com.huawei.hianalytics.C4787j1;
import com.huawei.hianalytics.C4788k;
import com.huawei.hianalytics.core.log.HiLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class HiAnalyticsManager {
    public static void clearCachedData() {
        C4788k c4788kM28953a = C4788k.m28953a();
        if (c4788kM28953a.f21841a == null) {
            HiLog.m28811sw("HADM", "sdk not init");
        } else {
            if (!C4787j1.f21836a.m28952a() || c4788kM28953a.f21842a.size() <= 0) {
                return;
            }
            Iterator<C4747d1> it = c4788kM28953a.f21842a.values().iterator();
            while (it.hasNext()) {
                it.next().f21702a.clearCacheDataByTag();
            }
        }
    }

    public static String createUUID(Context context) {
        C4788k.m28953a().getClass();
        if (context != null) {
            return C4785j.m28940c(context);
        }
        HiLog.m28811sw("HADM", "sdk not init");
        return "";
    }

    public static void disableDefaultInstanceReport() {
        C4788k c4788kM28953a = C4788k.m28953a();
        c4788kM28953a.getClass();
        c4788kM28953a.f21842a.remove("ha_default_collection");
    }

    public static List<String> getAllTags() {
        C4788k c4788kM28953a = C4788k.m28953a();
        c4788kM28953a.getClass();
        return new ArrayList(c4788kM28953a.f21842a.keySet());
    }

    public static boolean getInitFlag(String str) {
        C4788k c4788kM28953a = C4788k.m28953a();
        c4788kM28953a.getClass();
        if (str != null) {
            return c4788kM28953a.f21842a.containsKey(str);
        }
        HiLog.m28811sw("HADM", "tag can't be null");
        return false;
    }

    public static HiAnalyticsInstance getInstanceByTag(String str) {
        return C4788k.m28953a().m28954a(str);
    }

    public static boolean isDebugMode(Context context) {
        C4788k.m28953a().getClass();
        if (context != null) {
            return C4785j.m28922a(context);
        }
        HiLog.m28811sw("HADM", "sdk not init");
        return false;
    }

    public static void setAppid(String str) {
        Context context = C4788k.m28953a().f21841a;
        if (context == null) {
            HiLog.m28811sw("HADM", "sdk not init");
            return;
        }
        String packageName = context.getPackageName();
        if (!C4785j.m28926a("appID", str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}")) {
            str = packageName;
        }
        C4782i.m28891a().m28893a().f21855g = str;
    }

    public static void setCacheSize(int i10) {
        String str;
        if (C4788k.m28953a().f21841a == null) {
            HiLog.m28811sw("HADM", "sdk not init");
            return;
        }
        int i11 = 10;
        if (i10 <= 10) {
            i11 = 5;
            str = i10 < 5 ? "parameter under size" : "parameter overlarge";
            C4782i.m28891a().m28893a().f21845a = i10 * 1048576;
        }
        HiLog.m28812w("ParamCheckUtils", str);
        i10 = i11;
        C4782i.m28891a().m28893a().f21845a = i10 * 1048576;
    }

    public static void setCustomPkgName(String str) {
        if (C4788k.m28953a().f21841a != null) {
            HiLog.m28811sw("HADM", "sdk not init");
        } else if (TextUtils.isEmpty(str) || str.length() > 256) {
            HiLog.m28812w("HADM", "customPkgName check failed");
        } else {
            C4782i.m28891a().m28893a().f21862n = str;
        }
    }
}

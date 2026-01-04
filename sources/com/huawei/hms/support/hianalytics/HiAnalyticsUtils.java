package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hianalytics.util.HiAnalyticTools;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.network.embedded.C6073r5;
import com.huawei.hms.network.embedded.C6110u3;
import com.huawei.hms.stats.C6310a;
import com.huawei.hms.stats.HiAnalyticsOfCpUtils;
import com.huawei.hms.stats.HianalyticsExist;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.AnalyticsSwitchHolder;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;

/* loaded from: classes8.dex */
public class HiAnalyticsUtils {

    /* renamed from: c */
    private static final Object f29967c = new Object();

    /* renamed from: d */
    private static final Object f29968d = new Object();

    /* renamed from: e */
    private static HiAnalyticsUtils f29969e;

    /* renamed from: a */
    private int f29970a = 0;

    /* renamed from: b */
    private final boolean f29971b = HianalyticsExist.isHianalyticsExist();

    /* renamed from: com.huawei.hms.support.hianalytics.HiAnalyticsUtils$a */
    public class RunnableC6438a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f29972a;

        /* renamed from: b */
        final /* synthetic */ String f29973b;

        /* renamed from: c */
        final /* synthetic */ Map f29974c;

        public RunnableC6438a(Context context, String str, Map map) {
            this.f29972a = context;
            this.f29973b = str;
            this.f29974c = map;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            HiAnalyticsUtils.getInstance().onEvent(this.f29972a, this.f29973b, this.f29974c);
        }
    }

    /* renamed from: com.huawei.hms.support.hianalytics.HiAnalyticsUtils$b */
    public class RunnableC6439b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f29976a;

        /* renamed from: b */
        final /* synthetic */ String f29977b;

        /* renamed from: c */
        final /* synthetic */ String f29978c;

        public RunnableC6439b(Context context, String str, String str2) {
            this.f29976a = context;
            this.f29977b = str;
            this.f29978c = str2;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            HiAnalyticsUtils.getInstance().onEvent2(this.f29976a, this.f29977b, this.f29978c);
        }
    }

    /* renamed from: com.huawei.hms.support.hianalytics.HiAnalyticsUtils$c */
    public class RunnableC6440c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f29980a;

        /* renamed from: b */
        final /* synthetic */ String f29981b;

        /* renamed from: c */
        final /* synthetic */ Map f29982c;

        public RunnableC6440c(Context context, String str, Map map) {
            this.f29980a = context;
            this.f29981b = str;
            this.f29982c = map;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            HiAnalyticsUtils.getInstance().onNewEvent(this.f29980a, this.f29981b, this.f29982c);
        }
    }

    /* renamed from: com.huawei.hms.support.hianalytics.HiAnalyticsUtils$d */
    public class RunnableC6441d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f29984a;

        /* renamed from: b */
        final /* synthetic */ String f29985b;

        /* renamed from: c */
        final /* synthetic */ Map f29986c;

        /* renamed from: d */
        final /* synthetic */ int f29987d;

        public RunnableC6441d(Context context, String str, Map map, int i10) {
            this.f29984a = context;
            this.f29985b = str;
            this.f29986c = map;
            this.f29987d = i10;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            HiAnalyticsUtils.getInstance().onNewEvent(this.f29984a, this.f29985b, this.f29986c, this.f29987d);
        }
    }

    /* renamed from: com.huawei.hms.support.hianalytics.HiAnalyticsUtils$e */
    public class RunnableC6442e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f29989a;

        /* renamed from: b */
        final /* synthetic */ String f29990b;

        /* renamed from: c */
        final /* synthetic */ Map f29991c;

        public RunnableC6442e(Context context, String str, Map map) {
            this.f29989a = context;
            this.f29990b = str;
            this.f29991c = map;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            HiAnalyticsUtils.getInstance().onReport(this.f29989a, this.f29990b, this.f29991c);
        }
    }

    /* renamed from: com.huawei.hms.support.hianalytics.HiAnalyticsUtils$f */
    public class RunnableC6443f implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f29993a;

        /* renamed from: b */
        final /* synthetic */ String f29994b;

        /* renamed from: c */
        final /* synthetic */ Map f29995c;

        /* renamed from: d */
        final /* synthetic */ int f29996d;

        public RunnableC6443f(Context context, String str, Map map, int i10) {
            this.f29993a = context;
            this.f29994b = str;
            this.f29995c = map;
            this.f29996d = i10;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            HiAnalyticsUtils.getInstance().onReport(this.f29993a, this.f29994b, this.f29995c, this.f29996d);
        }
    }

    private HiAnalyticsUtils() {
    }

    /* renamed from: a */
    private static LinkedHashMap<String, String> m36808a(Map<String, String> map) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    /* renamed from: b */
    private void m36814b(Context context) {
        synchronized (f29968d) {
            try {
                int i10 = this.f29970a;
                if (i10 < 60) {
                    this.f29970a = i10 + 1;
                } else {
                    this.f29970a = 0;
                    if (this.f29971b) {
                        HiAnalyticsOfCpUtils.onReport(context, 0);
                        HiAnalyticsOfCpUtils.onReport(context, 1);
                    } else {
                        HmsHiAnalyticsUtils.onReport();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: c */
    private void m36818c(Context context, String str, Map map) {
        try {
            C6310a.m36621c().m36623a(new RunnableC6442e(context.getApplicationContext(), str, map));
        } catch (Throwable th2) {
            HMSLog.m36986e("HiAnalyticsUtils", "<addOnReportToCache> failed. " + th2.getMessage());
        }
    }

    public static HiAnalyticsUtils getInstance() {
        HiAnalyticsUtils hiAnalyticsUtils;
        synchronized (f29967c) {
            try {
                if (f29969e == null) {
                    f29969e = new HiAnalyticsUtils();
                }
                hiAnalyticsUtils = f29969e;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return hiAnalyticsUtils;
    }

    public static String versionCodeToName(String str) throws NumberFormatException {
        if (!TextUtils.isEmpty(str) && (str.length() == 8 || str.length() == 9)) {
            try {
                Integer.parseInt(str);
                return Integer.parseInt(str.substring(0, str.length() - 7)) + "." + Integer.parseInt(str.substring(str.length() - 7, str.length() - 5)) + "." + Integer.parseInt(str.substring(str.length() - 5, str.length() - 3)) + "." + Integer.parseInt(str.substring(str.length() - 3));
            } catch (NumberFormatException unused) {
            }
        }
        return "";
    }

    public void enableLog(Context context) {
        HMSLog.m36988i("HiAnalyticsUtils", "Enable Log");
        if (this.f29971b) {
            HiAnalyticTools.enableLog(context);
        } else {
            HmsHiAnalyticsUtils.enableLog();
        }
    }

    public boolean getInitFlag() {
        return !this.f29971b ? HmsHiAnalyticsUtils.getInitFlag() : HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
    }

    public int getOobeAnalyticsState(Context context) throws Settings.SettingNotFoundException {
        if (context == null) {
            return 0;
        }
        int iM36807a = m36807a(context);
        if (iM36807a == 1) {
            return iM36807a;
        }
        Bundle bundle = new Bundle();
        bundle.putString(C6110u3.f28491p, C6073r5.f28047i + "/com.huawei.hms.privacy.HmsAnalyticsStateProvider");
        try {
            Bundle bundleCall = context.getApplicationContext().getContentResolver().call(Uri.parse(C6073r5.f28047i), "getAnalyticsState", (String) null, bundle);
            if (bundleCall == null) {
                return iM36807a;
            }
            iM36807a = bundleCall.getInt("SWITCH_IS_CHECKED");
            HMSLog.m36988i("HiAnalyticsUtils", "get hms analyticsOobe state " + iM36807a);
            return iM36807a;
        } catch (IllegalArgumentException unused) {
            HMSLog.m36988i("HiAnalyticsUtils", "getOobeAnalyticsState IllegalArgumentException ");
            return iM36807a;
        } catch (SecurityException unused2) {
            HMSLog.m36988i("HiAnalyticsUtils", "getOobeAnalyticsState SecurityException ");
            return iM36807a;
        } catch (Exception unused3) {
            HMSLog.m36988i("HiAnalyticsUtils", "getOobeAnalyticsState Exception ");
            return iM36807a;
        }
    }

    public boolean hasError(Context context) {
        return AnalyticsSwitchHolder.isAnalyticsDisabled(context);
    }

    public void onBuoyEvent(Context context, String str, String str2) throws JSONException {
        onEvent2(context, str, str2);
    }

    public void onEvent(Context context, String str, Map<String, String> map) throws JSONException {
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map == null || map.isEmpty() || context == null) {
            HMSLog.m36986e("HiAnalyticsUtils", "<onEvent> map or context is null, state: " + andRefreshAnalyticsState);
            return;
        }
        boolean initFlag = getInitFlag();
        if (m36813a(initFlag, andRefreshAnalyticsState != 2, map)) {
            m36810a(context, str, map);
        }
        if (andRefreshAnalyticsState == 1 && initFlag) {
            if (this.f29971b) {
                HiAnalyticsOfCpUtils.onEvent(context, 0, str, m36808a(map));
                HiAnalyticsOfCpUtils.onEvent(context, 1, str, m36808a(map));
            } else {
                HmsHiAnalyticsUtils.onEvent(0, str, m36808a(map));
                HmsHiAnalyticsUtils.onEvent(1, str, m36808a(map));
            }
            m36814b(context);
        }
    }

    public void onEvent2(Context context, String str, String str2) throws JSONException {
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (context == null) {
            HMSLog.m36986e("HiAnalyticsUtils", "<onEvent2> context is null, state: " + andRefreshAnalyticsState);
            return;
        }
        boolean initFlag = getInitFlag();
        if (!initFlag && andRefreshAnalyticsState != 2 && m36812a(str2)) {
            m36809a(context, str, str2);
        }
        if (andRefreshAnalyticsState == 1 && initFlag) {
            if (this.f29971b) {
                HiAnalyticsOfCpUtils.onEvent(context, str, str2);
            } else {
                HmsHiAnalyticsUtils.onEvent(context, str, str2);
            }
        }
    }

    public void onNewEvent(Context context, String str, Map map) throws JSONException {
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map == null || map.isEmpty() || context == null) {
            HMSLog.m36986e("HiAnalyticsUtils", "<onNewEvent> map or context is null, state: " + andRefreshAnalyticsState);
            return;
        }
        boolean initFlag = getInitFlag();
        if (m36813a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
            m36815b(context, str, map);
        }
        if (andRefreshAnalyticsState == 1 && initFlag) {
            if (this.f29971b) {
                HiAnalyticsOfCpUtils.onEvent(context, 0, str, m36808a((Map<String, String>) map));
                HiAnalyticsOfCpUtils.onEvent(context, 1, str, m36808a((Map<String, String>) map));
            } else {
                HmsHiAnalyticsUtils.onEvent(0, str, m36808a((Map<String, String>) map));
                HmsHiAnalyticsUtils.onEvent(1, str, m36808a((Map<String, String>) map));
            }
            m36814b(context);
        }
    }

    public void onReport(Context context, String str, Map map) throws JSONException {
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map == null || map.isEmpty() || context == null) {
            HMSLog.m36986e("HiAnalyticsUtils", "<onReport> map or context is null, state: " + andRefreshAnalyticsState);
            return;
        }
        boolean initFlag = getInitFlag();
        if (m36813a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
            m36818c(context, str, map);
        }
        if (andRefreshAnalyticsState == 1 && initFlag) {
            if (this.f29971b) {
                HiAnalyticsOfCpUtils.onStreamEvent(context, 0, str, m36808a((Map<String, String>) map));
                HiAnalyticsOfCpUtils.onStreamEvent(context, 1, str, m36808a((Map<String, String>) map));
            } else {
                HmsHiAnalyticsUtils.onStreamEvent(0, str, m36808a((Map<String, String>) map));
                HmsHiAnalyticsUtils.onStreamEvent(1, str, m36808a((Map<String, String>) map));
            }
        }
    }

    public void enableLog() {
        HMSLog.m36988i("HiAnalyticsUtils", "Enable Log");
        if (!this.f29971b) {
            HmsHiAnalyticsUtils.enableLog();
        } else {
            HMSLog.m36988i("HiAnalyticsUtils", "cp needs to pass in the context, this method is not supported");
        }
    }

    /* renamed from: a */
    private int m36807a(Context context) throws Settings.SettingNotFoundException {
        int i10 = 0;
        try {
            i10 = Settings.Secure.getInt(context.getContentResolver(), "hw_app_analytics_state");
            HMSLog.m36988i("HiAnalyticsUtils", "getOobeStateForSettings value is " + i10);
            return i10;
        } catch (Settings.SettingNotFoundException e10) {
            HMSLog.m36988i("HiAnalyticsUtils", "Settings.SettingNotFoundException " + e10.getMessage());
            return i10;
        }
    }

    /* renamed from: a */
    private boolean m36813a(boolean z10, boolean z11, Map<?, ?> map) {
        return !z10 && z11 && m36817b(map);
    }

    /* renamed from: b */
    private boolean m36817b(Map<?, ?> map) {
        try {
            Iterator<?> it = map.values().iterator();
            long length = 0;
            while (it.hasNext()) {
                if (it.next() instanceof String) {
                    length += ((String) r2).getBytes(Charset.forName(Constants.UTF_8)).length;
                }
            }
            return length <= 512;
        } catch (Throwable th2) {
            HMSLog.m36986e("HiAnalyticsUtils", "<isValidSize map> Exception: " + th2.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    private boolean m36812a(String str) {
        if (str == null) {
            return false;
        }
        try {
            return str.getBytes(Charset.forName(Constants.UTF_8)).length <= 512;
        } catch (Throwable th2) {
            HMSLog.m36986e("HiAnalyticsUtils", "<isValidSize String> Exception: " + th2.getMessage());
            return false;
        }
    }

    public void onReport(Context context, String str, Map map, int i10) throws JSONException {
        if (i10 != 0 && i10 != 1) {
            HMSLog.m36986e("HiAnalyticsUtils", "<onReport with type> Data reporting type is not supported");
            return;
        }
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map != null && !map.isEmpty() && context != null) {
            boolean initFlag = getInitFlag();
            if (m36813a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
                m36816b(context, str, map, i10);
            }
            if (andRefreshAnalyticsState == 1 && initFlag) {
                if (!this.f29971b) {
                    HmsHiAnalyticsUtils.onStreamEvent(i10, str, m36808a((Map<String, String>) map));
                    return;
                } else {
                    HiAnalyticsOfCpUtils.onStreamEvent(context, i10, str, m36808a((Map<String, String>) map));
                    return;
                }
            }
            return;
        }
        HMSLog.m36986e("HiAnalyticsUtils", "<onReport with type> map or context is null, state: " + andRefreshAnalyticsState);
    }

    /* renamed from: a */
    private void m36810a(Context context, String str, Map<String, String> map) {
        try {
            C6310a.m36621c().m36623a(new RunnableC6438a(context.getApplicationContext(), str, map));
        } catch (Throwable th2) {
            HMSLog.m36986e("HiAnalyticsUtils", "<addOnEventToCache> failed. " + th2.getMessage());
        }
    }

    public void onNewEvent(Context context, String str, Map map, int i10) throws JSONException {
        if (i10 != 0 && i10 != 1) {
            HMSLog.m36986e("HiAnalyticsUtils", "<onNewEvent with type> Data reporting type is not supported");
            return;
        }
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map != null && !map.isEmpty() && context != null) {
            boolean initFlag = getInitFlag();
            if (m36813a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
                m36811a(context, str, map, i10);
            }
            if (andRefreshAnalyticsState == 1 && initFlag) {
                if (!this.f29971b) {
                    HmsHiAnalyticsUtils.onEvent(i10, str, m36808a((Map<String, String>) map));
                } else {
                    HiAnalyticsOfCpUtils.onEvent(context, i10, str, m36808a((Map<String, String>) map));
                }
                m36814b(context);
                return;
            }
            return;
        }
        HMSLog.m36986e("HiAnalyticsUtils", "<onNewEvent with type> map or context is null, state: " + andRefreshAnalyticsState);
    }

    /* renamed from: b */
    private void m36815b(Context context, String str, Map map) {
        try {
            C6310a.m36621c().m36623a(new RunnableC6440c(context.getApplicationContext(), str, map));
        } catch (Throwable th2) {
            HMSLog.m36986e("HiAnalyticsUtils", "<addOnNewEventToCache> failed. " + th2.getMessage());
        }
    }

    /* renamed from: a */
    private void m36809a(Context context, String str, String str2) {
        try {
            C6310a.m36621c().m36623a(new RunnableC6439b(context.getApplicationContext(), str, str2));
        } catch (Throwable th2) {
            HMSLog.m36986e("HiAnalyticsUtils", "<addOnEvent2ToCache> Failed. " + th2.getMessage());
        }
    }

    /* renamed from: b */
    private void m36816b(Context context, String str, Map map, int i10) {
        try {
            C6310a.m36621c().m36623a(new RunnableC6443f(context.getApplicationContext(), str, map, i10));
        } catch (Throwable th2) {
            HMSLog.m36986e("HiAnalyticsUtils", "<addOnReportToCache with type> failed. " + th2.getMessage());
        }
    }

    /* renamed from: a */
    private void m36811a(Context context, String str, Map map, int i10) {
        try {
            C6310a.m36621c().m36623a(new RunnableC6441d(context.getApplicationContext(), str, map, i10));
        } catch (Throwable th2) {
            HMSLog.m36986e("HiAnalyticsUtils", "<addOnNewEventToCache with type> failed. " + th2.getMessage());
        }
    }
}

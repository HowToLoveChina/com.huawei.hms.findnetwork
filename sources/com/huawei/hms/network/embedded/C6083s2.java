package com.huawei.hms.network.embedded;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.InitReport;
import java.lang.Thread;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.huawei.hms.network.embedded.s2 */
/* loaded from: classes8.dex */
public class C6083s2 implements Thread.UncaughtExceptionHandler {

    /* renamed from: c */
    public static final String f28149c = "CrashHandler";

    /* renamed from: d */
    public static final String f28150d = "crash_analytics";

    /* renamed from: e */
    public static final int f28151e = 1024;

    /* renamed from: a */
    public Thread.UncaughtExceptionHandler f28152a = null;

    /* renamed from: b */
    public Context f28153b = ContextHolder.getAppContext();

    /* renamed from: com.huawei.hms.network.embedded.s2$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C6083s2.this.m35249a();
        }
    }

    /* renamed from: a */
    private String m35248a(Throwable th2) {
        StackTraceElement[] stackTrace = th2.getStackTrace();
        StringBuilder sb2 = new StringBuilder(1024);
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb2.append("at ");
            sb2.append(stackTraceElement.toString());
            sb2.append(";");
        }
        return sb2.toString();
    }

    public void init() {
        this.f28152a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        InitReport.reportWhenInit(new a());
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th2) {
        if (HianalyticsHelper.getInstance().isEnableReportNoSeed(this.f28153b)) {
            Logger.m32141i(f28149c, "crash coming");
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("time", "" + System.currentTimeMillis());
            linkedHashMap.put(CrashHianalyticsData.PROCESS_ID, "" + Process.myPid());
            linkedHashMap.put(CrashHianalyticsData.THREAD_ID, "" + Process.myTid());
            linkedHashMap.put(CrashHianalyticsData.THREAD_NAME, thread.getName());
            linkedHashMap.put("exception_name", th2.getClass().getName());
            linkedHashMap.put("message", StringUtils.anonymizeMessage(th2.getMessage()));
            linkedHashMap.put(CrashHianalyticsData.STACK_TRACE, m35248a(th2));
            m35251a(linkedHashMap);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f28152a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m35249a() {
        if (HianalyticsHelper.getInstance().isEnableReportNoSeed(this.f28153b)) {
            PLSharedPreferences pLSharedPreferences = new PLSharedPreferences(this.f28153b, f28150d);
            if (pLSharedPreferences.getString("time", null) == null) {
                Logger.m32143v(f28149c, "not report");
                return;
            }
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("sdk_type", "UxPP");
            linkedHashMap.put(HianalyticsBaseData.SDK_NAME, "networkkit");
            linkedHashMap.put("sdk_version", "8.0.1.309");
            linkedHashMap.put(CrashHianalyticsData.CRASH_TYPE, CrashHianalyticsData.EVENT_ID_CRASH);
            linkedHashMap.put("time", pLSharedPreferences.getString("time", ""));
            linkedHashMap.put(CrashHianalyticsData.PROCESS_ID, pLSharedPreferences.getString(CrashHianalyticsData.PROCESS_ID, ""));
            linkedHashMap.put(CrashHianalyticsData.THREAD_ID, pLSharedPreferences.getString(CrashHianalyticsData.THREAD_ID, ""));
            linkedHashMap.put(CrashHianalyticsData.THREAD_NAME, pLSharedPreferences.getString(CrashHianalyticsData.THREAD_NAME, ""));
            linkedHashMap.put("exception_name", pLSharedPreferences.getString("exception_name", ""));
            linkedHashMap.put("message", pLSharedPreferences.getString("message", ""));
            linkedHashMap.put(CrashHianalyticsData.STACK_TRACE, pLSharedPreferences.getString(CrashHianalyticsData.STACK_TRACE, ""));
            HianalyticsHelper.getInstance().onEvent(linkedHashMap, CrashHianalyticsData.EVENT_ID_CRASH);
            Logger.m32144v(f28149c, "%s", linkedHashMap);
            pLSharedPreferences.clear();
        }
    }

    /* renamed from: a */
    private void m35251a(LinkedHashMap<String, String> linkedHashMap) {
        if (linkedHashMap == null) {
            return;
        }
        Logger.m32144v(f28149c, "data = %s", linkedHashMap);
        try {
            PLSharedPreferences pLSharedPreferences = new PLSharedPreferences(this.f28153b, f28150d);
            SharedPreferences.Editor editorEdit = pLSharedPreferences.edit();
            for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
                editorEdit.putString(entry.getKey(), entry.getValue());
            }
            editorEdit.apply();
            Logger.m32143v(f28149c, pLSharedPreferences.getString("message", null));
        } catch (InternalError unused) {
        }
    }
}

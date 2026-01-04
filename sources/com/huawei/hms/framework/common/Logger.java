package com.huawei.hms.framework.common;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.Arrays;
import java.util.IllegalFormatException;
import org.json.JSONException;

/* loaded from: classes8.dex */
public class Logger {
    private static final String CLASSNAME_COMMON_PRE_FK = "com.huawei.hms.framework.";
    private static final String CLASSNAME_COMMON_PRE_NK = "com.huawei.hms.network.";
    private static final boolean DEBUG = false;
    private static final int MAX_STACK_DEEP_LENGTH = 20;
    private static final int MAX_STACK_DEEP_LENGTH_NORMAL = 8;
    private static final String SPLIT = "|";
    private static final String TAG = "NK_Logger";
    private static final String TAG_NETWORKKIT_PRE = "NK_";
    private static final String TAG_NETWORK_SDK_PRE = "NetworkSdk_";
    private static ExtLogger extLogger = null;
    private static boolean kitPrint = true;
    private static int minLogEnableLevel = 2;

    public static class ThrowableWrapper extends Throwable {
        private static final long serialVersionUID = 7129050843360571879L;
        private String message;
        private Throwable ownerThrowable;
        private Throwable thisCause;

        public /* synthetic */ ThrowableWrapper(Throwable th2, C54191 c54191) {
            this(th2);
        }

        public synchronized void setCause(Throwable th2) {
            this.thisCause = th2;
        }

        @Override // java.lang.Throwable
        public synchronized Throwable getCause() {
            Throwable th2;
            th2 = this.thisCause;
            if (th2 == this) {
                th2 = null;
            }
            return th2;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public void setMessage(String str) {
            this.message = str;
        }

        @Override // java.lang.Throwable
        public String toString() {
            Throwable th2 = this.ownerThrowable;
            if (th2 == null) {
                return "";
            }
            String name = th2.getClass().getName();
            if (this.message == null) {
                return name;
            }
            String str = name + ": ";
            if (this.message.startsWith(str)) {
                return this.message;
            }
            return str + this.message;
        }

        private ThrowableWrapper(Throwable th2) {
            this.ownerThrowable = th2;
            StackTraceElement[] stackTrace = th2.getStackTrace();
            int i10 = ((th2 instanceof IOException) || (th2 instanceof JSONException)) ? 8 : 20;
            if (stackTrace.length > i10) {
                setStackTrace((StackTraceElement[]) Arrays.copyOf(stackTrace, i10));
            } else {
                setStackTrace(stackTrace);
            }
            setMessage(StringUtils.anonymizeMessage(th2.getMessage()));
        }
    }

    private static String complexAppTag(String str) {
        return TAG_NETWORK_SDK_PRE + str;
    }

    private static String complexMsg(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            return getCallMethodInfo(i10);
        }
        String callMethodInfo = getCallMethodInfo(i10);
        if (TextUtils.isEmpty(callMethodInfo)) {
            return str;
        }
        return callMethodInfo + "|" + str;
    }

    private static String complexTag(String str) {
        return TAG_NETWORKKIT_PRE + str;
    }

    @SuppressLint({"LogTagMismatch"})
    /* renamed from: d */
    public static void m32136d(String str, Object obj) {
        println(3, str, obj);
    }

    /* renamed from: e */
    public static void m32138e(String str, Object obj) {
        println(6, str, obj);
    }

    private static void extLogPrintln(int i10, String str, String str2) {
        if (i10 == 2) {
            extLogger.mo32133v(str, str2);
            return;
        }
        if (i10 == 3) {
            extLogger.mo32129d(str, str2);
            return;
        }
        if (i10 == 4) {
            extLogger.mo32132i(str, str2);
        } else if (i10 == 5) {
            extLogger.mo32134w(str, str2);
        } else {
            if (i10 != 6) {
                return;
            }
            extLogger.mo32130e(str, str2);
        }
    }

    private static String getBriefCallMethodInfo(int i10) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length <= i10) {
            return "";
        }
        StackTraceElement stackTraceElement = stackTrace[i10];
        return Thread.currentThread().getName() + "|" + stackTraceElement.getClassName().replace(CLASSNAME_COMMON_PRE_NK, "").replace(CLASSNAME_COMMON_PRE_FK, "") + "|" + stackTraceElement.getLineNumber();
    }

    private static String getCallMethodInfo(int i10) {
        return !Log.isLoggable(TAG_NETWORKKIT_PRE, 3) ? getBriefCallMethodInfo(i10 + 1) : getVerboseCallMethodInfo(i10 + 1);
    }

    private static Throwable getNewThrowable(Throwable th2) {
        if (isLoggable(3)) {
            return th2;
        }
        if (th2 == null) {
            return null;
        }
        ThrowableWrapper throwableWrapper = new ThrowableWrapper(th2);
        Throwable cause = th2.getCause();
        ThrowableWrapper throwableWrapper2 = throwableWrapper;
        while (cause != null) {
            ThrowableWrapper throwableWrapper3 = new ThrowableWrapper(cause);
            throwableWrapper2.setCause(throwableWrapper3);
            cause = cause.getCause();
            throwableWrapper2 = throwableWrapper3;
        }
        return throwableWrapper;
    }

    private static String getVerboseCallMethodInfo(int i10) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length <= i10) {
            return "";
        }
        StackTraceElement stackTraceElement = stackTrace[i10];
        return Thread.currentThread().getName() + "|" + stackTraceElement.getFileName() + "|" + stackTraceElement.getClassName() + "|" + stackTraceElement.getMethodName() + "|" + stackTraceElement.getLineNumber();
    }

    @SuppressLint({"LogTagMismatch"})
    /* renamed from: i */
    public static void m32141i(String str, Object obj) {
        println(4, str, obj);
    }

    private static boolean isAPPLoggable(int i10) {
        return extLogger != null && i10 >= 3;
    }

    private static boolean isKitLoggable(int i10) {
        return kitPrint && isLoggable(i10);
    }

    public static boolean isLoggable(int i10) {
        return Log.isLoggable(TAG_NETWORKKIT_PRE, i10);
    }

    private static int logPrintln(int i10, String str, String str2) {
        if (i10 < minLogEnableLevel) {
            return 1;
        }
        if (isAPPLoggable(i10)) {
            extLogPrintln(i10, complexAppTag(str), complexMsg(str2, 7));
        }
        if (isKitLoggable(i10)) {
            return Log.println(i10, complexTag(str), complexMsg(str2, 7));
        }
        return 1;
    }

    public static void println(int i10, String str, Object obj) {
        if (i10 < 3) {
            return;
        }
        logPrintln(i10, str, obj == null ? "null" : obj.toString());
    }

    public static void setExtLogger(ExtLogger extLogger2, boolean z10) {
        extLogger = extLogger2;
        kitPrint = z10;
        m32141i(TAG, "logger = " + extLogger2 + z10);
    }

    public static void setLogEnableLevel(int i10) {
        minLogEnableLevel = i10;
        Log.i(TAG, "setLogEnableLevel: " + i10);
    }

    /* renamed from: v */
    public static void m32144v(String str, String str2, Object... objArr) {
        println(2, str, str2, objArr);
    }

    /* renamed from: w */
    public static void m32145w(String str, Object obj) {
        println(5, str, obj);
    }

    @SuppressLint({"LogTagMismatch"})
    /* renamed from: d */
    public static void m32137d(String str, String str2, Object... objArr) {
        println(3, str, str2, objArr);
    }

    /* renamed from: e */
    public static void m32140e(String str, String str2, Object... objArr) {
        println(6, str, str2, objArr);
    }

    @SuppressLint({"LogTagMismatch"})
    /* renamed from: i */
    public static void m32142i(String str, String str2, Object... objArr) {
        println(4, str, str2, objArr);
    }

    public static void println(int i10, String str, String str2, Object... objArr) {
        if (i10 < 3) {
            return;
        }
        if (str2 == null) {
            Log.w(TAG, "format is null, not log");
            return;
        }
        try {
            logPrintln(i10, str, StringUtils.format(str2, objArr));
        } catch (IllegalFormatException e10) {
            m32146w(TAG, "log format error" + str2, e10);
        }
    }

    /* renamed from: v */
    public static void m32143v(String str, Object obj) {
        println(2, str, obj);
    }

    /* renamed from: w */
    public static void m32147w(String str, String str2, Object... objArr) {
        println(5, str, str2, objArr);
    }

    /* renamed from: e */
    public static void m32139e(String str, String str2, Throwable th2) {
        if (6 < minLogEnableLevel) {
            return;
        }
        if (isAPPLoggable(6)) {
            extLogger.mo32131e(complexAppTag(str), complexMsg(str2, 5), getNewThrowable(th2));
        }
        if (kitPrint) {
            Log.e(complexTag(str), complexMsg(str2, 5), getNewThrowable(th2));
        }
    }

    /* renamed from: w */
    public static void m32146w(String str, String str2, Throwable th2) {
        if (5 < minLogEnableLevel) {
            return;
        }
        if (isAPPLoggable(5)) {
            extLogger.mo32135w(complexAppTag(str), complexMsg(str2, 5), getNewThrowable(th2));
        }
        if (kitPrint) {
            Log.w(complexTag(str), complexMsg(str2, 5), getNewThrowable(th2));
        }
    }
}

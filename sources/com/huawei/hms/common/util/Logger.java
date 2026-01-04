package com.huawei.hms.common.util;

import android.annotation.SuppressLint;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Locale;
import org.json.JSONException;

/* loaded from: classes8.dex */
public class Logger {

    /* renamed from: a */
    public static final boolean f23544a = false;

    /* renamed from: b */
    public static final String f23545b = "Logger";

    /* renamed from: c */
    public static final String f23546c = "|";

    /* renamed from: d */
    public static final int f23547d = 8;

    /* renamed from: e */
    public static final int f23548e = 20;

    /* renamed from: f */
    public static final String f23549f = "dynamic-api_";

    /* renamed from: com.huawei.hms.common.util.Logger$b */
    public static class C5157b extends Throwable {

        /* renamed from: d */
        public static final long f23550d = 7129050843360571879L;

        /* renamed from: a */
        public String f23551a;

        /* renamed from: b */
        public Throwable f23552b;

        /* renamed from: c */
        public Throwable f23553c;

        public C5157b(Throwable th2) {
            this.f23553c = th2;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            Throwable th2 = this.f23552b;
            if (th2 == this) {
                return null;
            }
            return th2;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.f23551a;
        }

        @Override // java.lang.Throwable
        public String toString() {
            Throwable th2 = this.f23553c;
            if (th2 == null) {
                return "";
            }
            String name = th2.getClass().getName();
            if (this.f23551a == null) {
                return name;
            }
            String str = name + ": ";
            if (this.f23551a.startsWith(str)) {
                return this.f23551a;
            }
            return str + this.f23551a;
        }

        /* renamed from: a */
        public void m30749a(String str) {
            this.f23551a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m30748a(Throwable th2) {
            this.f23552b = th2;
        }
    }

    /* renamed from: a */
    public static int m30730a(int i10, String str, String str2) {
        return Log.println(i10, m30732a(str), m30733a(str2, 7));
    }

    public static String anonymizeMessage(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i10 = 0; i10 < charArray.length; i10++) {
            if (i10 % 2 == 1) {
                charArray[i10] = '*';
            }
        }
        return new String(charArray);
    }

    @SuppressLint({"LogTagMismatch"})
    /* renamed from: d */
    public static void m30735d(String str, Object obj) {
        println(3, str, obj);
    }

    /* renamed from: e */
    public static void m30737e(String str, Object obj) {
        println(6, str, obj);
    }

    public static String format(String str, Object... objArr) {
        return str == null ? "" : String.format(Locale.ROOT, str, objArr);
    }

    @SuppressLint({"LogTagMismatch"})
    /* renamed from: i */
    public static void m30740i(String str, Object obj) {
        println(4, str, obj);
    }

    public static boolean isLoggable(int i10) {
        return Log.isLoggable(f23549f, i10);
    }

    public static void println(int i10, String str, Object obj) {
        if (i10 >= 3 && isLoggable(i10)) {
            m30730a(i10, str, obj == null ? "null" : obj.toString());
        }
    }

    /* renamed from: v */
    public static void m30742v(String str, Object obj) {
        println(2, str, obj);
    }

    /* renamed from: w */
    public static void m30744w(String str, Object obj) {
        println(5, str, obj);
    }

    /* renamed from: a */
    public static String m30731a(int i10) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length <= i10) {
            return "";
        }
        StackTraceElement stackTraceElement = stackTrace[i10];
        return Process.myPid() + "-" + Process.myTid() + "|" + stackTraceElement.getFileName() + "|" + stackTraceElement.getClassName() + "|" + stackTraceElement.getMethodName() + "|" + stackTraceElement.getLineNumber();
    }

    @SuppressLint({"LogTagMismatch"})
    /* renamed from: d */
    public static void m30736d(String str, String str2, Object... objArr) {
        println(3, str, str2, objArr);
    }

    /* renamed from: e */
    public static void m30738e(String str, String str2, Throwable th2) {
        Log.e(m30732a(str), m30733a(str2, 5), m30734a(th2));
    }

    @SuppressLint({"LogTagMismatch"})
    /* renamed from: i */
    public static void m30741i(String str, String str2, Object... objArr) {
        println(4, str, str2, objArr);
    }

    public static void println(int i10, String str, String str2, Object... objArr) {
        if (i10 < 3) {
            return;
        }
        if (str2 == null) {
            Log.w(f23545b, "format is null, not log");
            return;
        }
        try {
            if (isLoggable(i10)) {
                m30730a(i10, str, format(str2, objArr));
            }
        } catch (IllegalFormatException e10) {
            m30745w(f23545b, "log format error" + str2, e10);
        }
    }

    /* renamed from: v */
    public static void m30743v(String str, String str2, Object... objArr) {
        println(2, str, str2, objArr);
    }

    /* renamed from: w */
    public static void m30745w(String str, String str2, Throwable th2) {
        Log.w(m30732a(str), m30733a(str2, 5), m30734a(th2));
    }

    /* renamed from: a */
    public static String m30732a(String str) {
        return f23549f + str;
    }

    /* renamed from: e */
    public static void m30739e(String str, String str2, Object... objArr) {
        println(6, str, str2, objArr);
    }

    /* renamed from: w */
    public static void m30746w(String str, String str2, Object... objArr) {
        println(5, str, str2, objArr);
    }

    /* renamed from: a */
    public static String m30733a(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            return m30731a(i10);
        }
        return m30731a(i10) + "|" + str;
    }

    /* renamed from: a */
    public static Throwable m30734a(Throwable th2) {
        if (isLoggable(3)) {
            return th2;
        }
        if (th2 == null) {
            return null;
        }
        int i10 = ((th2 instanceof IOException) || (th2 instanceof JSONException)) ? 8 : 20;
        C5157b c5157b = new C5157b(th2);
        StackTraceElement[] stackTrace = c5157b.getStackTrace();
        if (stackTrace.length > i10) {
            c5157b.setStackTrace((StackTraceElement[]) Arrays.copyOf(stackTrace, i10));
        } else {
            c5157b.setStackTrace(stackTrace);
        }
        c5157b.m30749a(anonymizeMessage(th2.getMessage()));
        Throwable cause = th2.getCause();
        C5157b c5157b2 = c5157b;
        while (cause != null) {
            C5157b c5157b3 = new C5157b(cause);
            c5157b3.m30749a(anonymizeMessage(cause.getMessage()));
            c5157b2.m30748a(c5157b3);
            cause = cause.getCause();
            c5157b2 = c5157b3;
        }
        return c5157b;
    }
}

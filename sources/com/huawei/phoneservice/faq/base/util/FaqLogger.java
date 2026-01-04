package com.huawei.phoneservice.faq.base.util;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.FormatterClosedException;
import java.util.IllegalFormatException;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class FaqLogger {

    /* renamed from: a */
    public static boolean f38698a = false;

    /* renamed from: b */
    public static Context f38699b;

    /* renamed from: a */
    public static String m51832a(String str, Object... objArr) {
        if (objArr == null) {
            return str;
        }
        try {
            return objArr.length == 0 ? str : String.format(str, objArr);
        } catch (FormatterClosedException | IllegalFormatException unused) {
            return str;
        }
    }

    /* renamed from: b */
    public static String m51833b(Throwable th2) {
        if (th2 == null) {
            return "";
        }
        for (Throwable cause = th2; cause != null; cause = cause.getCause()) {
            if (cause instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th2.printStackTrace(printWriter);
        printWriter.flush();
        printWriter.close();
        return stringWriter.toString();
    }

    /* renamed from: c */
    public static Date m51834c() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, calendar.get(5) - 1);
        return calendar.getTime();
    }

    /* renamed from: d */
    public static void m51835d(int i10, String str, String str2) throws Throwable {
        if (8 == i10) {
            try {
                m51848j(str, str2);
            } catch (Exception unused) {
                Log.e("FaqLogger", "  writeLogToFile Exception  ");
            }
        }
        if (!f38698a || TextUtils.isEmpty(str2)) {
            return;
        }
        if (i10 == 3) {
            Log.d(str, str2);
            return;
        }
        if (i10 == 4) {
            Log.i(str, str2);
            return;
        }
        if (i10 == 5) {
            Log.w(str, str2);
        } else if (i10 != 6) {
            Log.v(str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    /* renamed from: e */
    public static void m51839e(int i10, String str, Throwable th2) throws Throwable {
        m51835d(i10, str, m51833b(th2));
    }

    /* renamed from: f */
    public static void m51843f(int i10, String str, Throwable th2, String str2, Object... objArr) throws Throwable {
        String strM51832a = m51832a(str2, objArr);
        if (th2 != null) {
            strM51832a = strM51832a + " : " + m51833b(th2);
        }
        if (TextUtils.isEmpty(str2)) {
            strM51832a = "Empty/NULL log message";
        }
        m51835d(i10, str, strM51832a);
    }

    /* renamed from: g */
    public static void m51844g(Context context) {
        f38699b = context.getApplicationContext();
        String str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(m51834c());
        File file = new File(m51851m());
        try {
            if (file.exists()) {
                String[] list = file.list();
                long jM51887f = FaqTimeStringUtil.m51887f(str);
                if (list != null) {
                    for (String str2 : list) {
                        if (jM51887f >= FaqTimeStringUtil.m51887f(str2)) {
                            m51845h(new File(m51851m() + File.separator + str2));
                        }
                    }
                }
            }
        } catch (ParseException unused) {
            Log.e("FaqLogger", "  ParseException ");
        }
    }

    /* renamed from: h */
    public static void m51845h(File file) {
        if (file.exists()) {
            file.delete();
        }
    }

    @Keep
    /* renamed from: i */
    public static void m51846i(String str, String str2) throws Throwable {
        m51835d(4, str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x00ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:144:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Writer] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.Writer] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.io.FileWriter, java.io.Writer] */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m51848j(java.lang.String r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "  fileWriter Exception  "
            java.lang.String r1 = "  bufferedWriter Exception  "
            java.util.Date r2 = new java.util.Date
            r2.<init>()
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat
            java.util.Locale r4 = java.util.Locale.getDefault()
            java.lang.String r5 = "yyyy-MM-dd"
            r3.<init>(r5, r4)
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat
            java.util.Locale r5 = java.util.Locale.getDefault()
            java.lang.String r6 = "yyyy-MM-dd HH:mm:ss"
            r4.<init>(r6, r5)
            java.lang.String r3 = r3.format(r2)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r2 = r4.format(r2)
            r5.append(r2)
            java.lang.String r2 = " "
            r5.append(r2)
            r5.append(r7)
            r5.append(r2)
            r5.append(r8)
            java.lang.String r7 = r5.toString()
            java.io.File r8 = new java.io.File
            java.lang.String r2 = m51851m()
            r8.<init>(r2)
            boolean r2 = r8.exists()
            if (r2 != 0) goto L53
            r8.mkdirs()
        L53:
            java.io.File r2 = new java.io.File
            java.lang.String r8 = r8.toString()
            r2.<init>(r8, r3)
            boolean r8 = r2.exists()
            java.lang.String r3 = "FaqLogger"
            if (r8 != 0) goto L6d
            r2.createNewFile()     // Catch: java.io.IOException -> L68
            goto L6d
        L68:
            java.lang.String r8 = "  createNewFile Exception  "
            android.util.Log.e(r3, r8)
        L6d:
            r8 = 0
            java.io.FileWriter r4 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L91 java.io.IOException -> L94
            r5 = 1
            r4.<init>(r2, r5)     // Catch: java.lang.Throwable -> L91 java.io.IOException -> L94
            java.io.BufferedWriter r2 = new java.io.BufferedWriter     // Catch: java.lang.Throwable -> L8f java.io.IOException -> L95
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L8f java.io.IOException -> L95
            r2.write(r7)     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8d
            r2.newLine()     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8d
            r2.close()     // Catch: java.io.IOException -> L83
            goto L86
        L83:
            android.util.Log.e(r3, r1)
        L86:
            r4.close()     // Catch: java.io.IOException -> La6
            goto La9
        L8a:
            r7 = move-exception
        L8b:
            r8 = r2
            goto Laf
        L8d:
            r8 = r2
            goto L95
        L8f:
            r7 = move-exception
            goto Laf
        L91:
            r7 = move-exception
            r2 = r8
            goto Lad
        L94:
            r4 = r8
        L95:
            java.lang.String r7 = "  IOException "
            android.util.Log.e(r3, r7)     // Catch: java.lang.Throwable -> Laa
            if (r8 == 0) goto La3
            r8.close()     // Catch: java.io.IOException -> La0
            goto La3
        La0:
            android.util.Log.e(r3, r1)
        La3:
            if (r4 == 0) goto La9
            goto L86
        La6:
            android.util.Log.e(r3, r0)
        La9:
            return
        Laa:
            r7 = move-exception
            r2 = r8
            r8 = r4
        Lad:
            r4 = r8
            goto L8b
        Laf:
            if (r8 == 0) goto Lb8
            r8.close()     // Catch: java.io.IOException -> Lb5
            goto Lb8
        Lb5:
            android.util.Log.e(r3, r1)
        Lb8:
            if (r4 == 0) goto Lc1
            r4.close()     // Catch: java.io.IOException -> Lbe
            goto Lc1
        Lbe:
            android.util.Log.e(r3, r0)
        Lc1:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.faq.base.util.FaqLogger.m51848j(java.lang.String, java.lang.String):void");
    }

    /* renamed from: k */
    public static void m51849k(String str, Throwable th2, String str2, Object... objArr) throws Throwable {
        m51843f(5, str, th2, str2, objArr);
    }

    /* renamed from: l */
    public static void m51850l(boolean z10, Application application) {
        f38698a = z10;
        f38699b = application;
    }

    /* renamed from: m */
    public static String m51851m() {
        return f38699b.getFilesDir().getAbsolutePath() + File.separator + "feedbackLog";
    }

    @Keep
    public static void print(String str, String str2) throws Throwable {
        m51835d(8, str, str2);
    }

    @Keep
    /* renamed from: w */
    public static void m51852w(String str, String str2) throws Throwable {
        m51835d(5, str, str2);
    }

    @Keep
    /* renamed from: d */
    public static void m51836d(String str, String str2) throws Throwable {
        m51835d(3, str, str2);
    }

    @Keep
    /* renamed from: e */
    public static void m51840e(String str, String str2) throws Throwable {
        m51835d(5, str, str2);
    }

    @Keep
    /* renamed from: i */
    public static void m51847i(String str, String str2, Object... objArr) throws Throwable {
        m51843f(4, str, null, str2, objArr);
    }

    @Keep
    /* renamed from: d */
    public static void m51837d(String str, String str2, Object... objArr) throws Throwable {
        m51843f(3, str, null, str2, objArr);
    }

    @Keep
    /* renamed from: e */
    public static void m51841e(String str, String str2, Object... objArr) throws Throwable {
        m51843f(5, str, null, str2, objArr);
    }

    @Keep
    /* renamed from: d */
    public static void m51838d(String str, Throwable th2) throws Throwable {
        m51839e(3, str, th2);
    }

    @Keep
    /* renamed from: e */
    public static void m51842e(String str, Throwable th2) throws Throwable {
        m51839e(5, str, th2);
    }
}

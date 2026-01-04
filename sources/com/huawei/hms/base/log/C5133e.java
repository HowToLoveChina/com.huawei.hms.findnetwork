package com.huawei.hms.base.log;

import android.os.Process;
import android.util.Log;
import com.huawei.hms.network.embedded.C5929g4;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* renamed from: com.huawei.hms.base.log.e */
/* loaded from: classes8.dex */
public class C5133e {

    /* renamed from: b */
    private String f23396b;

    /* renamed from: c */
    private String f23397c;

    /* renamed from: d */
    private int f23398d;

    /* renamed from: g */
    private String f23401g;

    /* renamed from: h */
    private int f23402h;

    /* renamed from: i */
    private int f23403i;

    /* renamed from: j */
    private int f23404j;

    /* renamed from: a */
    private final StringBuilder f23395a = new StringBuilder();

    /* renamed from: e */
    private long f23399e = 0;

    /* renamed from: f */
    private long f23400f = 0;

    public C5133e(int i10, String str, int i11, String str2) {
        this.f23397c = "HMS";
        this.f23404j = i10;
        this.f23396b = str;
        this.f23398d = i11;
        if (str2 != null) {
            this.f23397c = str2;
        }
        m30626b();
    }

    /* renamed from: a */
    public static String m30624a(int i10) {
        return i10 != 3 ? i10 != 4 ? i10 != 5 ? i10 != 6 ? String.valueOf(i10) : "E" : "W" : "I" : "D";
    }

    /* renamed from: b */
    private C5133e m30626b() {
        this.f23399e = System.currentTimeMillis();
        Thread threadCurrentThread = Thread.currentThread();
        this.f23400f = threadCurrentThread.getId();
        this.f23402h = Process.myPid();
        StackTraceElement[] stackTrace = threadCurrentThread.getStackTrace();
        int length = stackTrace.length;
        int i10 = this.f23404j;
        if (length > i10) {
            StackTraceElement stackTraceElement = stackTrace[i10];
            this.f23401g = stackTraceElement.getFileName();
            this.f23403i = stackTraceElement.getLineNumber();
        }
        return this;
    }

    /* renamed from: c */
    public String m30631c() {
        StringBuilder sb2 = new StringBuilder();
        m30627b(sb2);
        return sb2.toString();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        m30627b(sb2);
        m30625a(sb2);
        return sb2.toString();
    }

    /* renamed from: a */
    public <T> C5133e m30628a(T t10) {
        this.f23395a.append(t10);
        return this;
    }

    /* renamed from: a */
    public C5133e m30629a(Throwable th2) {
        m30628a((C5133e) '\n').m30628a((C5133e) Log.getStackTraceString(th2));
        return this;
    }

    /* renamed from: a */
    public String m30630a() {
        StringBuilder sb2 = new StringBuilder();
        m30625a(sb2);
        return sb2.toString();
    }

    /* renamed from: b */
    private StringBuilder m30627b(StringBuilder sb2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        sb2.append('[');
        sb2.append(simpleDateFormat.format(Long.valueOf(this.f23399e)));
        String strM30624a = m30624a(this.f23398d);
        sb2.append(' ');
        sb2.append(strM30624a);
        sb2.append(C5929g4.f26852n);
        sb2.append(this.f23397c);
        sb2.append(C5929g4.f26852n);
        sb2.append(this.f23396b);
        sb2.append(' ');
        sb2.append(this.f23402h);
        sb2.append(':');
        sb2.append(this.f23400f);
        sb2.append(' ');
        sb2.append(this.f23401g);
        sb2.append(':');
        sb2.append(this.f23403i);
        sb2.append(']');
        return sb2;
    }

    /* renamed from: a */
    private StringBuilder m30625a(StringBuilder sb2) {
        sb2.append(' ');
        sb2.append(this.f23395a.toString());
        return sb2;
    }
}

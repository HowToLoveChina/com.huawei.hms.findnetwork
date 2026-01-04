package com.huawei.hms.network.embedded;

import java.io.IOException;
import java.util.Arrays;
import org.json.JSONException;

/* renamed from: com.huawei.hms.network.embedded.e8 */
/* loaded from: classes8.dex */
public class C5907e8 extends Throwable {

    /* renamed from: d */
    public static final int f26701d = 8;

    /* renamed from: e */
    public static final int f26702e = 20;

    /* renamed from: f */
    public static final long f26703f = 7129050843360571879L;

    /* renamed from: a */
    public String f26704a;

    /* renamed from: b */
    public Throwable f26705b;

    /* renamed from: c */
    public Throwable f26706c;

    public C5907e8(Throwable th2) {
        this.f26706c = th2;
        StackTraceElement[] stackTrace = th2.getStackTrace();
        int i10 = ((th2 instanceof IOException) || (th2 instanceof JSONException)) ? 8 : 20;
        if (stackTrace.length > i10) {
            setStackTrace((StackTraceElement[]) Arrays.copyOf(stackTrace, i10));
        } else {
            setStackTrace(stackTrace);
        }
        m34135b(m34134a(th2.getMessage()));
    }

    /* renamed from: a */
    public String m34134a(String str) {
        if (str == null || str.trim().isEmpty()) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i10 = 0; i10 < charArray.length; i10++) {
            if (i10 % 2 != 0) {
                charArray[i10] = '*';
            }
        }
        return new String(charArray);
    }

    /* renamed from: b */
    public void m34135b(String str) {
        this.f26704a = str;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        Throwable th2 = this.f26705b;
        if (th2 == this) {
            return null;
        }
        return th2;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f26704a;
    }

    @Override // java.lang.Throwable
    public String toString() {
        Throwable th2 = this.f26706c;
        if (th2 == null) {
            return "";
        }
        String name = th2.getClass().getName();
        if (this.f26704a == null) {
            return name;
        }
        String str = name + ": ";
        if (this.f26704a.startsWith(str)) {
            return this.f26704a;
        }
        return str + this.f26704a;
    }

    /* renamed from: a */
    public static Throwable m34132a(Throwable th2) {
        if (th2 == null) {
            return null;
        }
        C5907e8 c5907e8 = new C5907e8(th2);
        Throwable cause = th2.getCause();
        C5907e8 c5907e82 = c5907e8;
        while (cause != null) {
            C5907e8 c5907e83 = new C5907e8(cause);
            c5907e82.m34133b(c5907e83);
            cause = cause.getCause();
            c5907e82 = c5907e83;
        }
        return c5907e8;
    }

    /* renamed from: b */
    private void m34133b(Throwable th2) {
        this.f26705b = th2;
    }
}

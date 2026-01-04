package com.huawei.hms.drive;

import java.io.IOException;
import java.util.Arrays;
import org.json.JSONException;

/* renamed from: com.huawei.hms.drive.bn */
/* loaded from: classes8.dex */
public class C5209bn extends Throwable {

    /* renamed from: a */
    private String f23985a;

    /* renamed from: b */
    private Throwable f23986b;

    /* renamed from: c */
    private Throwable f23987c;

    private C5209bn(Throwable th2) {
        this.f23987c = th2;
        StackTraceElement[] stackTrace = th2.getStackTrace();
        int i10 = ((th2 instanceof IOException) || (th2 instanceof JSONException)) ? 8 : 20;
        if (stackTrace.length > i10) {
            setStackTrace((StackTraceElement[]) Arrays.copyOf(stackTrace, i10));
        } else {
            setStackTrace(stackTrace);
        }
        m31170a(m31171b(th2.getMessage()));
    }

    /* renamed from: b */
    private void m31169b(Throwable th2) {
        this.f23986b = th2;
    }

    /* renamed from: a */
    public void m31170a(String str) {
        this.f23985a = str;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        Throwable th2 = this.f23986b;
        if (th2 == this) {
            return null;
        }
        return th2;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f23985a;
    }

    @Override // java.lang.Throwable
    public String toString() {
        Throwable th2 = this.f23987c;
        if (th2 == null) {
            return "";
        }
        String name = th2.getClass().getName();
        if (this.f23985a == null) {
            return name;
        }
        String str = name + ": ";
        if (this.f23985a.startsWith(str)) {
            return this.f23985a;
        }
        return str + this.f23985a;
    }

    /* renamed from: a */
    public static Throwable m31168a(Throwable th2) {
        if (th2 == null) {
            return null;
        }
        C5209bn c5209bn = new C5209bn(th2);
        Throwable cause = th2.getCause();
        C5209bn c5209bn2 = c5209bn;
        while (cause != null) {
            C5209bn c5209bn3 = new C5209bn(cause);
            c5209bn2.m31169b(c5209bn3);
            cause = cause.getCause();
            c5209bn2 = c5209bn3;
        }
        return c5209bn;
    }

    /* renamed from: b */
    public String m31171b(String str) {
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
}

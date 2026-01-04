package aw;

import android.util.Log;
import java.text.MessageFormat;

/* renamed from: aw.b */
/* loaded from: classes9.dex */
public class C1029b {

    /* renamed from: a */
    public static InterfaceC1028a f5097a = new C1030c();

    /* renamed from: a */
    public static void m6230a(String str, String str2, Object... objArr) {
        InterfaceC1028a interfaceC1028a = f5097a;
        if (interfaceC1028a != null) {
            interfaceC1028a.mo6226d(m6233d(str), m6232c(str, str2, objArr));
        }
    }

    /* renamed from: b */
    public static void m6231b(String str, String str2, Object... objArr) {
        InterfaceC1028a interfaceC1028a = f5097a;
        if (interfaceC1028a != null) {
            interfaceC1028a.mo6227e(m6233d(str), m6232c(str, str2, objArr));
        }
    }

    /* renamed from: c */
    public static String m6232c(String str, String str2, Object... objArr) {
        try {
            return MessageFormat.format(str2, objArr);
        } catch (Throwable th2) {
            Log.e(str, "log error : " + th2.getMessage());
            return "return default";
        }
    }

    /* renamed from: d */
    public static String m6233d(String str) {
        return "UCS-" + str;
    }

    /* renamed from: e */
    public static void m6234e(String str, String str2, Object... objArr) {
        InterfaceC1028a interfaceC1028a = f5097a;
        if (interfaceC1028a != null) {
            interfaceC1028a.mo6228i(m6233d(str), m6232c(str, str2, objArr));
        }
    }

    /* renamed from: f */
    public static void m6235f(InterfaceC1028a interfaceC1028a) {
        if (interfaceC1028a != null) {
            f5097a = interfaceC1028a;
        }
    }

    /* renamed from: g */
    public static void m6236g(String str, String str2, Object... objArr) {
        InterfaceC1028a interfaceC1028a = f5097a;
        if (interfaceC1028a != null) {
            interfaceC1028a.mo6229w(m6233d(str), m6232c(str, str2, objArr));
        }
    }
}

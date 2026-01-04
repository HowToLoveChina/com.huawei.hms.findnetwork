package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* renamed from: com.huawei.hms.base.log.b */
/* loaded from: classes8.dex */
public class C5130b {

    /* renamed from: b */
    private String f23392b;

    /* renamed from: a */
    private int f23391a = 4;

    /* renamed from: c */
    private InterfaceC5132d f23393c = new C5131c();

    /* renamed from: a */
    public void m30619a(Context context, int i10, String str) {
        this.f23391a = i10;
        this.f23392b = str;
        this.f23393c.mo30612a(context, "HMSCore");
    }

    /* renamed from: b */
    public void m30623b(int i10, String str, String str2, Throwable th2) {
        try {
            if (m30622a(i10)) {
                C5133e c5133eM30615a = m30615a(i10, str, str2, th2);
                String str3 = c5133eM30615a.m30631c() + c5133eM30615a.m30630a();
                this.f23393c.mo30614a(str3, i10, str, str2 + '\n' + Log.getStackTraceString(th2));
            }
        } catch (OutOfMemoryError unused) {
            m30616b();
        }
    }

    /* renamed from: a */
    public InterfaceC5132d m30617a() {
        return this.f23393c;
    }

    /* renamed from: a */
    public void m30620a(InterfaceC5132d interfaceC5132d) {
        this.f23393c = interfaceC5132d;
    }

    /* renamed from: b */
    private void m30616b() {
        try {
            Log.e("HMSSDK_LogAdaptor", "log happened OOM error.");
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public boolean m30622a(int i10) {
        return i10 >= this.f23391a;
    }

    /* renamed from: a */
    public void m30618a(int i10, String str, String str2) {
        try {
            if (m30622a(i10)) {
                C5133e c5133eM30615a = m30615a(i10, str, str2, null);
                this.f23393c.mo30614a(c5133eM30615a.m30631c() + c5133eM30615a.m30630a(), i10, str, str2);
            }
        } catch (OutOfMemoryError unused) {
            m30616b();
        }
    }

    /* renamed from: a */
    public void m30621a(String str, String str2) {
        try {
            C5133e c5133eM30615a = m30615a(4, str, str2, null);
            this.f23393c.mo30614a(c5133eM30615a.m30631c() + '\n' + c5133eM30615a.m30630a(), 4, str, str2);
        } catch (OutOfMemoryError unused) {
            m30616b();
        }
    }

    /* renamed from: a */
    private C5133e m30615a(int i10, String str, String str2, Throwable th2) {
        C5133e c5133e = new C5133e(8, this.f23392b, i10, str);
        c5133e.m30628a((C5133e) str2);
        c5133e.m30629a(th2);
        return c5133e;
    }
}

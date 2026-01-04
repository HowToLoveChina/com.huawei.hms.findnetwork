package com.huawei.appgallery.agd.internal.support.log;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes4.dex */
public class AgdLog {
    public static final AgdLog LOG = new AgdLog();

    /* renamed from: a */
    public final void m28025a(int i10, String str, String str2, Throwable th2) {
        if (str2 == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            str2 = '[' + str + "] " + str2;
        }
        if (th2 != null) {
            str2 = str2 + th2.getMessage();
        }
        if (m28026b(i10)) {
            Log.println(i10, "AgdLog", str2.replace('\n', '_').replace('\r', '_'));
        }
    }

    /* renamed from: b */
    public final boolean m28026b(int i10) {
        return i10 > 3;
    }

    /* renamed from: d */
    public void m28027d(String str, String str2) {
        m28025a(3, str, str2, null);
    }

    /* renamed from: e */
    public void m28029e(String str, String str2) {
        m28025a(6, str, str2, null);
    }

    /* renamed from: i */
    public void m28031i(String str, String str2) {
        m28025a(4, str, str2, null);
    }

    /* renamed from: w */
    public void m28033w(String str, String str2) {
        m28025a(5, str, str2, null);
    }

    /* renamed from: d */
    public void m28028d(String str, String str2, Throwable th2) {
        m28025a(3, str, str2, th2);
    }

    /* renamed from: e */
    public void m28030e(String str, String str2, Throwable th2) {
        m28025a(6, str, str2, th2);
    }

    /* renamed from: i */
    public void m28032i(String str, String str2, Throwable th2) {
        m28025a(4, str, str2, th2);
    }

    /* renamed from: w */
    public void m28034w(String str, String str2, Throwable th2) {
        m28025a(5, str, str2, th2);
    }
}

package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;

/* renamed from: com.huawei.hms.hatool.e0 */
/* loaded from: classes8.dex */
public abstract class AbstractC5526e0 {
    /* renamed from: a */
    private C5537i m32493a(int i10) {
        String strM32496f;
        if (i10 != 0) {
            strM32496f = m32496f();
            if (!TextUtils.isEmpty(strM32496f)) {
                return new C5537i(EnumC5523d0.UDID, strM32496f);
            }
        } else {
            strM32496f = "";
        }
        return new C5537i(EnumC5523d0.EMPTY, strM32496f);
    }

    /* renamed from: b */
    private C5537i m32494b(int i10) {
        String strM32496f;
        if ((i10 & 4) != 0) {
            strM32496f = m32496f();
            if (!TextUtils.isEmpty(strM32496f)) {
                return new C5537i(EnumC5523d0.UDID, strM32496f);
            }
        } else {
            strM32496f = "";
        }
        return new C5537i(EnumC5523d0.EMPTY, strM32496f);
    }

    /* renamed from: e */
    private boolean m32495e() {
        C5533g1 c5533g1M32738b = C5565s.m32733c().m32738b();
        if (TextUtils.isEmpty(c5533g1M32738b.m32545l())) {
            c5533g1M32738b.m32538h(AbstractC5555o.m32665a());
        }
        return !TextUtils.isEmpty(c5533g1M32738b.m32545l());
    }

    /* renamed from: f */
    private String m32496f() {
        C5533g1 c5533g1M32738b = C5565s.m32733c().m32738b();
        if (TextUtils.isEmpty(c5533g1M32738b.m32539i())) {
            c5533g1M32738b.m32532e(C5576x0.m32819c());
        }
        return c5533g1M32738b.m32539i();
    }

    /* renamed from: a */
    public abstract String mo32498a();

    /* renamed from: a */
    public abstract String mo32499a(String str);

    /* renamed from: b */
    public abstract String mo32500b();

    /* renamed from: c */
    public abstract String mo32501c();

    /* renamed from: d */
    public abstract int mo32502d();

    /* renamed from: a */
    public C5537i m32497a(Context context) {
        String strMo32501c = mo32501c();
        if (!TextUtils.isEmpty(strMo32501c)) {
            return new C5537i(EnumC5523d0.UDID, strMo32501c);
        }
        String strMo32498a = mo32498a();
        if (!TextUtils.isEmpty(strMo32498a)) {
            return new C5537i(EnumC5523d0.IMEI, strMo32498a);
        }
        boolean zM32495e = m32495e();
        String strMo32500b = mo32500b();
        return !TextUtils.isEmpty(strMo32500b) ? zM32495e ? new C5537i(EnumC5523d0.SN, strMo32500b) : new C5537i(EnumC5523d0.UDID, mo32499a(strMo32500b)) : zM32495e ? m32493a(mo32502d()) : m32494b(mo32502d());
    }
}

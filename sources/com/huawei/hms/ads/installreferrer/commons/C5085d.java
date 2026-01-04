package com.huawei.hms.ads.installreferrer.commons;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.huawei.hms.ads.installreferrer.commons.d */
/* loaded from: classes8.dex */
public class C5085d implements InterfaceC5084c {

    /* renamed from: a */
    private static InterfaceC5084c f23227a;

    /* renamed from: c */
    private static final byte[] f23228c = new byte[0];

    /* renamed from: b */
    private final SharedPreferences f23229b;

    /* renamed from: d */
    private final byte[] f23230d = new byte[0];

    private C5085d(Context context) {
        this.f23229b = context.getSharedPreferences("pps_install_referrer", 4);
    }

    /* renamed from: a */
    public static InterfaceC5084c m30332a(Context context) {
        return m30333b(context);
    }

    /* renamed from: b */
    private static InterfaceC5084c m30333b(Context context) {
        InterfaceC5084c interfaceC5084c;
        synchronized (f23228c) {
            try {
                if (f23227a == null) {
                    f23227a = new C5085d(context);
                }
                interfaceC5084c = f23227a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return interfaceC5084c;
    }

    @Override // com.huawei.hms.ads.installreferrer.commons.InterfaceC5084c
    /* renamed from: a */
    public void mo30330a(boolean z10) {
        synchronized (this.f23230d) {
            try {
                SharedPreferences sharedPreferences = this.f23229b;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putBoolean("deeplink_isrequest", z10).apply();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.hms.ads.installreferrer.commons.InterfaceC5084c
    /* renamed from: a */
    public boolean mo30331a() {
        synchronized (this.f23230d) {
            try {
                SharedPreferences sharedPreferences = this.f23229b;
                if (sharedPreferences == null) {
                    return false;
                }
                return sharedPreferences.getBoolean("deeplink_isrequest", false);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}

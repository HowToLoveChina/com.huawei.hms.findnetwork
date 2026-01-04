package com.huawei.hms.ads.jsb;

import android.content.Context;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.download.app.C7055l;
import com.huawei.openalliance.p169ad.download.app.interfaces.InterfaceC7052b;
import com.huawei.openalliance.p169ad.inter.HiAd;

/* renamed from: com.huawei.hms.ads.jsb.a */
/* loaded from: classes8.dex */
public class C5091a {

    /* renamed from: a */
    private static final byte[] f23256a = new byte[0];

    /* renamed from: b */
    private static C5091a f23257b;

    /* renamed from: c */
    private Context f23258c;

    /* renamed from: com.huawei.hms.ads.jsb.a$a */
    public static class a {

        /* renamed from: a */
        private static final InterfaceC7052b f23259a = new C7055l();
    }

    private C5091a(Context context) {
        this.f23258c = context.getApplicationContext();
    }

    /* renamed from: a */
    public static C5091a m30359a(Context context) {
        return m30360b(context);
    }

    /* renamed from: b */
    private static C5091a m30360b(Context context) {
        C5091a c5091a;
        synchronized (f23256a) {
            try {
                if (f23257b == null) {
                    f23257b = new C5091a(context);
                }
                c5091a = f23257b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c5091a;
    }

    /* renamed from: a */
    public InterfaceC7052b m30361a() {
        return a.f23259a;
    }

    /* renamed from: a */
    public void m30362a(JsbConfig jsbConfig) {
        synchronized (f23256a) {
            if (jsbConfig != null) {
                try {
                    HiAd.getInstance(this.f23258c).enableUserInfo(jsbConfig.m30335a());
                    HiAd.getInstance(this.f23258c).initLog(jsbConfig.m30338d(), 3);
                    if (C6982bz.m41153c(this.f23258c)) {
                        HiAd.getInstance(this.f23258c).initGrs(jsbConfig.m30336b());
                    } else {
                        HiAd.getInstance(this.f23258c).initGrs(jsbConfig.m30336b(), jsbConfig.m30337c());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }
}

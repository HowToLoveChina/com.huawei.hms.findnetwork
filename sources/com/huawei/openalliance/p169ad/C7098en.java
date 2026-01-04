package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;

/* renamed from: com.huawei.openalliance.ad.en */
/* loaded from: classes8.dex */
public class C7098en implements InterfaceC7132fp {

    /* renamed from: d */
    private static InterfaceC7132fp f32698d;

    /* renamed from: e */
    private static final byte[] f32699e = new byte[0];

    /* renamed from: a */
    private Context f32700a;

    /* renamed from: b */
    private final SharedPreferences f32701b;

    /* renamed from: c */
    private final SharedPreferences f32702c;

    /* renamed from: f */
    private final byte[] f32703f = new byte[0];

    private C7098en(Context context) {
        SharedPreferences sharedPreferences;
        this.f32700a = context.getApplicationContext();
        try {
            sharedPreferences = context.getSharedPreferences("AppDataSharedPreferences", 0);
        } catch (Throwable th2) {
            th = th2;
            sharedPreferences = null;
        }
        try {
            SharedPreferences sharedPreferences2 = context.getSharedPreferences("AppDataSharedPreferences_sec", 0);
            this.f32701b = sharedPreferences;
            this.f32702c = sharedPreferences2;
        } catch (Throwable th3) {
            th = th3;
            try {
                AbstractC7185ho.m43824c("AppDataSpHandler", "get SharedPreference exception: %s", th.getClass().getSimpleName());
            } finally {
                this.f32701b = sharedPreferences;
                this.f32702c = null;
            }
        }
    }

    /* renamed from: b */
    private static InterfaceC7132fp m42967b(Context context) {
        InterfaceC7132fp interfaceC7132fp;
        synchronized (f32699e) {
            try {
                if (f32698d == null) {
                    f32698d = new C7098en(context);
                }
                interfaceC7132fp = f32698d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return interfaceC7132fp;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7132fp
    /* renamed from: a */
    public long mo42968a() {
        synchronized (this.f32703f) {
            try {
                SharedPreferences sharedPreferences = this.f32701b;
                if (sharedPreferences == null) {
                    return 0L;
                }
                return sharedPreferences.getLong("lastSyncTime", 0L);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public static InterfaceC7132fp m42966a(Context context) {
        return m42967b(context);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7132fp
    /* renamed from: b */
    public void mo42969b() {
        synchronized (this.f32703f) {
            try {
                SharedPreferences sharedPreferences = this.f32701b;
                if (sharedPreferences == null) {
                    return;
                }
                sharedPreferences.edit().putLong("lastSyncTime", AbstractC7741ao.m47566c()).commit();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}

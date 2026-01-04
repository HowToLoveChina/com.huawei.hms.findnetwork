package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.hms.ads.common.inter.LoaderSpHandlerInter;

/* renamed from: com.huawei.openalliance.ad.fa */
/* loaded from: classes8.dex */
public class C7117fa implements LoaderSpHandlerInter {

    /* renamed from: a */
    private static C7117fa f32772a;

    /* renamed from: b */
    private static InterfaceC7146gc f32773b;

    /* renamed from: c */
    private static final byte[] f32774c = new byte[0];

    private C7117fa(Context context) {
        f32773b = C7124fh.m43316b(context);
    }

    /* renamed from: a */
    public static C7117fa m43188a(Context context) {
        return m43189b(context);
    }

    /* renamed from: b */
    private static C7117fa m43189b(Context context) {
        C7117fa c7117fa;
        synchronized (f32774c) {
            try {
                if (f32772a == null) {
                    f32772a = new C7117fa(context);
                }
                c7117fa = f32772a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7117fa;
    }

    public long getKitloaderLastCheckTime() {
        return f32773b.mo43442cm();
    }

    public int getLoaderEngin2KitUpdate(String str) {
        return f32773b.mo43321A(str);
    }

    public int getLoaderEngineInterval(String str) {
        return f32773b.mo43322B(str);
    }

    public boolean getLoaderEngineUpdate(String str) {
        return f32773b.mo43492z(str);
    }

    public void setKitloaderLastCheckTime(long j10) {
        f32773b.mo43481p(j10);
    }
}

package com.huawei.openalliance.p169ad.hsf;

import android.content.Context;

/* renamed from: com.huawei.openalliance.ad.hsf.e */
/* loaded from: classes2.dex */
public abstract class AbstractC7196e implements InterfaceC7198g {

    /* renamed from: com.huawei.openalliance.ad.hsf.e$a */
    public interface a {
        /* renamed from: a */
        void mo43854a();

        /* renamed from: a */
        void mo43855a(int i10);

        /* renamed from: b */
        void mo43857b(int i10);
    }

    /* renamed from: a */
    public static AbstractC7196e m43868a(Context context, a aVar) {
        return new ServiceConnectionC7197f(context.getApplicationContext(), aVar);
    }

    /* renamed from: a */
    public abstract void mo43869a();

    /* renamed from: b */
    public abstract boolean mo43870b();
}

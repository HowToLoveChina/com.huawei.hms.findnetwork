package com.huawei.openalliance.p169ad;

import android.content.Context;

/* renamed from: com.huawei.openalliance.ad.kp */
/* loaded from: classes8.dex */
public abstract class AbstractC7369kp<P> implements InterfaceC7372ks<P> {

    /* renamed from: a */
    protected Context f34292a;

    public AbstractC7369kp(Context context) {
        this.f34292a = context;
    }

    /* renamed from: a */
    public abstract String mo45454a(P p10);

    @Override // com.huawei.openalliance.p169ad.InterfaceC7372ks
    /* renamed from: a */
    public String mo45455a(P p10, InterfaceC7368ko interfaceC7368ko) {
        if (interfaceC7368ko != null) {
            interfaceC7368ko.mo45412a(p10);
        }
        return mo45454a(p10);
    }
}

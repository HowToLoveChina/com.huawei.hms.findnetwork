package com.huawei.openalliance.p169ad;

import android.util.Log;

/* renamed from: com.huawei.openalliance.ad.hq */
/* loaded from: classes8.dex */
public final class C7187hq extends AbstractC7183hm {
    private C7187hq() {
    }

    /* renamed from: a */
    public static InterfaceC7199ht m43838a() {
        return new C7187hq();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7199ht
    /* renamed from: a */
    public InterfaceC7199ht mo43809a(String str, String str2) {
        InterfaceC7199ht interfaceC7199ht = this.f33086a;
        if (interfaceC7199ht != null) {
            interfaceC7199ht.mo43809a(str, str2);
        }
        return this;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7199ht
    /* renamed from: a */
    public void mo43810a(C7201hv c7201hv, int i10, String str) {
        if (c7201hv == null) {
            return;
        }
        m43839a(c7201hv.m43882b(), i10, str);
        InterfaceC7199ht interfaceC7199ht = this.f33086a;
        if (interfaceC7199ht != null) {
            interfaceC7199ht.mo43810a(c7201hv, i10, str);
        }
    }

    /* renamed from: a */
    private void m43839a(String str, int i10, String str2) {
        if (str == null) {
            return;
        }
        if (i10 == 3) {
            Log.d(str2, str);
            return;
        }
        if (i10 != 4) {
            if (i10 == 5) {
                Log.w(str2, str);
                return;
            } else if (i10 == 6) {
                Log.e(str2, str);
                return;
            }
        }
        Log.i(str2, str);
    }
}

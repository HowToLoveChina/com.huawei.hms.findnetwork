package com.huawei.wearengine.p2p;

import com.huawei.wearengine.p2p.P2pSendCallback;
import vu.InterfaceC13492d;
import vu.InterfaceC13493e;

/* renamed from: com.huawei.wearengine.p2p.e */
/* loaded from: classes9.dex */
public class BinderC8906e extends P2pSendCallback.AbstractBinderC8900a {

    /* renamed from: a */
    public final /* synthetic */ InterfaceC13492d f45352a;

    /* renamed from: b */
    public final /* synthetic */ C8907f f45353b;

    public BinderC8906e(C8907f c8907f, InterfaceC13492d interfaceC13492d) {
        this.f45353b = c8907f;
        this.f45352a = interfaceC13492d;
    }

    @Override // com.huawei.wearengine.p2p.P2pSendCallback.AbstractBinderC8900a
    /* renamed from: e */
    public void mo56583e(String str) {
        InterfaceC13492d interfaceC13492d = this.f45352a;
        if (interfaceC13492d instanceof InterfaceC13493e) {
            ((InterfaceC13493e) interfaceC13492d).m81182a(str);
        }
    }

    @Override // com.huawei.wearengine.p2p.P2pSendCallback.AbstractBinderC8900a
    /* renamed from: f */
    public void mo56584f(long j10) {
        this.f45352a.mo81180b(j10);
    }

    @Override // com.huawei.wearengine.p2p.P2pSendCallback.AbstractBinderC8900a
    /* renamed from: g */
    public void mo56585g(int i10) {
        this.f45352a.mo81181c(i10);
    }
}

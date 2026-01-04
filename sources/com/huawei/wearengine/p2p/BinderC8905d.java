package com.huawei.wearengine.p2p;

import com.huawei.wearengine.p2p.P2pPingCallback;
import vu.InterfaceC13490b;

/* renamed from: com.huawei.wearengine.p2p.d */
/* loaded from: classes9.dex */
public class BinderC8905d extends P2pPingCallback.AbstractBinderC8899a {

    /* renamed from: a */
    public final /* synthetic */ InterfaceC13490b f45350a;

    /* renamed from: b */
    public final /* synthetic */ C8907f f45351b;

    public BinderC8905d(C8907f c8907f, InterfaceC13490b interfaceC13490b) {
        this.f45351b = c8907f;
        this.f45350a = interfaceC13490b;
    }

    @Override // com.huawei.wearengine.p2p.P2pPingCallback.AbstractBinderC8899a
    /* renamed from: f */
    public void mo56582f(int i10) {
        this.f45350a.mo81178a(i10);
    }
}

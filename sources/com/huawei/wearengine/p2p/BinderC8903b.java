package com.huawei.wearengine.p2p;

import com.huawei.wearengine.p2p.C8902a;
import com.huawei.wearengine.p2p.ReceiverCallback;
import vu.InterfaceC13491c;

/* renamed from: com.huawei.wearengine.p2p.b */
/* loaded from: classes9.dex */
public class BinderC8903b extends ReceiverCallback.AbstractBinderC8901a {

    /* renamed from: a */
    public final /* synthetic */ InterfaceC13491c f45347a;

    /* renamed from: b */
    public final /* synthetic */ C8907f f45348b;

    public BinderC8903b(C8907f c8907f, InterfaceC13491c interfaceC13491c) {
        this.f45348b = c8907f;
        this.f45347a = interfaceC13491c;
    }

    @Override // com.huawei.wearengine.p2p.ReceiverCallback.AbstractBinderC8901a
    /* renamed from: a */
    public void mo56586a(MessageParcel messageParcel) {
        C8907f.m56602d(this.f45348b, this.f45347a, messageParcel);
    }

    @Override // com.huawei.wearengine.p2p.ReceiverCallback.AbstractBinderC8901a
    /* renamed from: b */
    public void mo56587b(byte[] bArr) {
        C8902a.a aVar = new C8902a.a();
        aVar.m56598f(bArr);
        this.f45347a.mo81179a(aVar.m56596c());
    }
}

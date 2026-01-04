package p559pv;

import mv.C11533f;
import p535ov.InterfaceC12042i;

/* renamed from: pv.e */
/* loaded from: classes9.dex */
public class C12235e implements InterfaceC12231a<InterfaceC12042i, Object> {

    /* renamed from: a */
    public String f56618a;

    @Override // p559pv.InterfaceC12231a
    /* renamed from: a */
    public String mo73423a() {
        return this.f56618a;
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: b */
    public boolean mo73424b(Object obj) {
        return obj != null;
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo73425c(String str, InterfaceC12042i interfaceC12042i) {
        this.f56618a = C11533f.m68823a(interfaceC12042i.message(), str + " can't be null");
    }
}
